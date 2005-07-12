/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Jens Lukowski/Innoopract - initial renaming/restructuring
 *     
 *******************************************************************************/
package org.eclipse.wst.xml.ui.internal.contentoutline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.wst.sse.core.internal.provisional.INodeAdapterFactory;
import org.eclipse.wst.sse.core.internal.provisional.INodeNotifier;
import org.eclipse.wst.sse.core.internal.util.StringUtils;
import org.eclipse.wst.sse.ui.internal.contentoutline.IJFaceNodeAdapter;
import org.eclipse.wst.sse.ui.internal.contentoutline.IJFaceNodeAdapterFactory;
import org.eclipse.wst.xml.core.internal.contentmodel.CMAttributeDeclaration;
import org.eclipse.wst.xml.core.internal.contentmodel.CMDataType;
import org.eclipse.wst.xml.core.internal.contentmodel.CMDocument;
import org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration;
import org.eclipse.wst.xml.core.internal.contentmodel.modelquery.CMDocumentManager;
import org.eclipse.wst.xml.core.internal.contentmodel.modelquery.CMDocumentManagerListener;
import org.eclipse.wst.xml.core.internal.contentmodel.modelquery.ModelQuery;
import org.eclipse.wst.xml.core.internal.contentmodel.util.CMDocumentCache;
import org.eclipse.wst.xml.core.internal.modelquery.ModelQueryUtil;
import org.eclipse.wst.xml.ui.internal.XMLUIMessages;
import org.eclipse.wst.xml.ui.internal.editor.CMImageUtil;
import org.eclipse.wst.xml.ui.internal.editor.XMLEditorPluginImageHelper;
import org.eclipse.wst.xml.ui.internal.editor.XMLEditorPluginImages;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Adapts a DOM node to a JFace viewer.
 */
public class JFaceNodeAdapter implements IJFaceNodeAdapter {

	public class CMDocumentManagerListenerImpl implements CMDocumentManagerListener {

		List beingRefreshed = Collections.synchronizedList(new ArrayList());

		public void cacheCleared(org.eclipse.wst.xml.core.internal.contentmodel.util.CMDocumentCache cache) {
			// nothing to do
		}

		public void cacheUpdated(CMDocumentCache cache, final String uri, int oldStatus, int newStatus, CMDocument cmDocument) {

			if (newStatus == CMDocumentCache.STATUS_LOADED || newStatus == CMDocumentCache.STATUS_ERROR) {
				refreshViewers();
			}
		}

		Display getDisplay() {
			Display display = null;
			// Note: the workbench should always have a display
			// (unless running headless), whereas Display.getCurrent()
			// only returns the display if the currently executing thread
			// has one.
			if (PlatformUI.isWorkbenchRunning()) {
				display = PlatformUI.getWorkbench().getDisplay();
			}
			return display;
		}

		public void propertyChanged(CMDocumentManager cmDocumentManager, String propertyName) {

			if (cmDocumentManager.getPropertyEnabled(CMDocumentManager.PROPERTY_AUTO_LOAD)) {
				refreshViewers();
			}
		}

		private void refreshViewers() {

			// we're counting on getListers returning a "copy" of the
			// listeners, so we'll be thread safe.
			Collection listeners = ((IJFaceNodeAdapterFactory) fAdapterFactory).getListeners();
			Iterator iterator = listeners.iterator();
			while (iterator.hasNext()) {
				Object listener = iterator.next();
				// now that we use aynchExec, we ourselves have to gaurd
				// against
				// agains adding some refreshes when its already being
				// refreshed.
				if (listener instanceof PropertySheetPage && (!beingRefreshed.contains(listener))) {
					final PropertySheetPage propertySheetPage = (PropertySheetPage) listener;
					beingRefreshed.add(propertySheetPage);
					getDisplay().asyncExec(new Runnable() {

						public void run() {

							if (getDisplay().isDisposed()) {
								return;
							}
							if (propertySheetPage.getControl() != null && !propertySheetPage.getControl().isDisposed()) {
								propertySheetPage.refresh();
								beingRefreshed.remove(propertySheetPage);
							}
						}
					});
				}
			}
		}
	}

	final static Class ADAPTER_KEY = IJFaceNodeAdapter.class;

	/**
	 * debug .option
	 */
	private static final boolean DEBUG = getDebugValue();

	private static boolean getDebugValue() {
		String value = Platform.getDebugOption("org.eclipse.wst.sse.ui/debug/outline"); //$NON-NLS-1$
		boolean result = value != null && value.equalsIgnoreCase("true"); //$NON-NLS-1$
		return result;
	}

	INodeAdapterFactory fAdapterFactory;
	private CMDocumentManagerListener cmDocumentManagerListener;
	private BufferedOutlineUpdater fUpdater = null;

	public JFaceNodeAdapter(INodeAdapterFactory adapterFactory1) {

		super();
		this.fAdapterFactory = adapterFactory1;
	}

	protected Image createImage(Object object) {

		Image image = null;
		Node node = (Node) object;
		switch (node.getNodeType()) {
			case Node.ELEMENT_NODE : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_ELEMENT);
				break;
			}
			case Node.ATTRIBUTE_NODE : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_ATTRIBUTE);
				break;
			}
			case Node.TEXT_NODE : { // actually, TEXT should never be seen in
				// the tree
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_ELEMENT);
				break;
			}
			case Node.CDATA_SECTION_NODE : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_CDATASECTION);
				break;
			}
			case Node.ENTITY_REFERENCE_NODE :
			case Node.ENTITY_NODE : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_ENTITY);
				break;
			}
			case Node.PROCESSING_INSTRUCTION_NODE : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_PROCESSINGINSTRUCTION);
				break;
			}
			case Node.COMMENT_NODE : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_COMMENT);
				break;
			}
			case Node.DOCUMENT_TYPE_NODE : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_DOCTYPE);
				break;
			}
			case Node.NOTATION_NODE : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_NOTATION);
				break;
			}
			default : {
				image = createXMLImageDescriptor(XMLEditorPluginImages.IMG_OBJ_ELEMENT);
				break;
			}
		}
		return image;
	}

	protected Image createXMLImageDescriptor(String imageResourceName) {
		return XMLEditorPluginImageHelper.getInstance().getImage(imageResourceName);
	}

	public Object[] getChildren(Object object) {

		// (pa) 20021217
		// cmvc defect 235554
		// performance enhancement: using child.getNextSibling() rather than
		// nodeList(item) for O(n) vs. O(n*n)
		//
		Node node = (Node) object;
		ArrayList v = new ArrayList(node.getChildNodes().getLength());
		for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
			Node n = child;
			if (n.getNodeType() != Node.TEXT_NODE)
				v.add(n);
		}
		return v.toArray();
	}

	/**
	 * Returns a CMDocumentManagerListener that can update JFace views when
	 * notified of CMDocumentManager events
	 */
	public org.eclipse.wst.xml.core.internal.contentmodel.modelquery.CMDocumentManagerListener getCMDocumentManagerListener() {

		if (cmDocumentManagerListener == null)
			cmDocumentManagerListener = new CMDocumentManagerListenerImpl();
		return cmDocumentManagerListener;
	}

	Display getDisplay() {
		Display display = null;
		// Note: the workbench should always have a display
		// (unless running headless), whereas Display.getCurrent()
		// only returns the display if the currently executing thread
		// has one.
		if (PlatformUI.isWorkbenchRunning()) {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		return display;
	}

	/**
	 * Returns an enumeration with the elements belonging to the passed
	 * element. These are the top level items in a list, tree, table, etc...
	 */
	public Object[] getElements(Object node) {

		return getChildren(node);
	}

	/**
	 * Fetches the label image specific to this object instance.
	 */
	public Image getLabelImage(Object node) {

		Image image = CMImageUtil.getImage(CMImageUtil.getDeclaration((Node) node));
		if (image == null && JFaceResources.getImageRegistry() != null) {
			ImageRegistry imageRegistry = JFaceResources.getImageRegistry();
			String nodeName = getNodeName(node);
			image = imageRegistry.get(nodeName);
			if (image == null) {
				image = createImage(node);
				if (image != null)
					imageRegistry.put(nodeName, image);
			}
		}
		return image;
	}

	/**
	 * Fetches the label text specific to this object instance.
	 */
	public String getLabelText(Object node) {

		return getNodeName(node);
	}

	private String getNodeName(Object object) {
		StringBuffer nodeName = new StringBuffer();
		Node node = (Node) object;
		nodeName.append(node.getNodeName());

		if (node.getNodeType() == Node.DOCUMENT_TYPE_NODE) {
			nodeName.insert(0, "DOCTYPE:"); //$NON-NLS-1$
		}
		else if (node.getNodeType() == Node.ELEMENT_NODE && getShowAttribute()) {
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=88444
			if (node.hasAttributes()) {
				Element element = (Element) node;
				NamedNodeMap attributes = element.getAttributes();
				Node attribute = null;
				Node attribute2 = null;

				// try to get content model element declaration
				CMElementDeclaration elementDecl = null;
				ModelQuery mq = ModelQueryUtil.getModelQuery(element.getOwnerDocument());
				if (mq != null) {
					elementDecl = mq.getCMElementDeclaration(element);
				}
				// find an attribute of type ID
				if (elementDecl != null) {
					int i = 0;
					while (i < attributes.getLength() && attribute == null) {
						Node attr = attributes.item(i);
						String attrName = attr.getNodeName();
						CMAttributeDeclaration attrDecl = (CMAttributeDeclaration) elementDecl.getAttributes().getNamedItem(attrName);
						if (attrDecl != null) {
							if ((attrDecl.getAttrType() != null) && (CMDataType.ID.equals(attrDecl.getAttrType().getDataTypeName()))) {
								attribute = attr;
							}
							else if (attrDecl.getUsage() == CMAttributeDeclaration.REQUIRED) {
								// as a backup, keep tabs on any required
								// attributes
								attribute2 = attr;
							}
						}
						++i;
					}
				}

				// if no suitable attribute found, try using a required
				// attribute, if none, then just use first attribute
				if (attribute == null) {
					if (attribute2 != null) {
						attribute = attribute2;
					}
					else
						attribute = attributes.item(0);
				}

				// display the attribute
				String attributeName = attribute.getNodeName();
				if (attributeName != null && attributeName.length() > 0) {
					nodeName.append(" " + attributeName); //$NON-NLS-1$
					String attributeValue = attribute.getNodeValue();
					if (attributeValue != null && attributeValue.length() > 0) {
						nodeName.append("=" + StringUtils.strip(attributeValue)); //$NON-NLS-1$
					}
				}
			}
		}
		return nodeName.toString();
	}

	private BufferedOutlineUpdater getOutlineUpdater() {
		if (fUpdater == null)
			fUpdater = new BufferedOutlineUpdater();
		return fUpdater;
	}

	public Object getParent(Object object) {

		Node node = (Node) object;
		return node.getParentNode();
	}

	public boolean hasChildren(Object object) {

		// (pa) 20021217
		// cmvc defect 235554 > use child.getNextSibling() instead of
		// nodeList(item) for O(n) vs. O(n*n)
		Node node = (Node) object;
		for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
			if (child.getNodeType() != Node.TEXT_NODE)
				return true;
		}
		return false;
	}

	/**
	 * Allowing the INodeAdapter to compare itself against the type allows it
	 * to return true in more than one case.
	 */
	public boolean isAdapterForType(Object type) {
		if (type == null) {
			return false;
		}
		return type.equals(ADAPTER_KEY);
	}

	/**
	 * Called by the object being adapter (the notifier) when something has
	 * changed.
	 */
	public void notifyChanged(INodeNotifier notifier, int eventType, Object changedFeature, Object oldValue, Object newValue, int pos) {

		// future_TODO: the 'uijobs' used in this method were added to solve
		// threading problems when the dom
		// is updated in the background while the editor is open. They may be
		// a bit overkill and not that useful.
		// (That is, may be be worthy of job manager management). If they are
		// found to be important enough to leave in,
		// there's probably some optimization that can be done.
		Collection listeners = ((JFaceNodeAdapterFactory) fAdapterFactory).getListeners();
		Iterator iterator = listeners.iterator();

		while (iterator.hasNext()) {
			Object listener = iterator.next();
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=90637
			// if (notifier instanceof Node && (listener instanceof
			// StructuredViewer) && (eventType ==
			// INodeNotifier.STRUCTURE_CHANGED || (eventType ==
			// INodeNotifier.CHANGE && changedFeature == null))) {
			if (notifier instanceof Node && (listener instanceof StructuredViewer) && (eventType == INodeNotifier.STRUCTURE_CHANGED || (eventType == INodeNotifier.CHANGE))) {

				if (DEBUG) {
					System.out.println("JFaceNodeAdapter notified on event type > " + eventType); //$NON-NLS-1$
				}

				// refresh on structural and "unknown" changes
				StructuredViewer structuredViewer = (StructuredViewer) listener;
				// https://w3.opensource.ibm.com/bugzilla/show_bug.cgi?id=5230
				if (structuredViewer.getControl() != null) {
					getOutlineUpdater().processNode(structuredViewer, (Node) notifier);
				}
			}
			else if ((listener instanceof PropertySheetPage) && ((eventType == INodeNotifier.CHANGE) || (eventType == INodeNotifier.STRUCTURE_CHANGED))) {
				PropertySheetPage propertySheetPage = (PropertySheetPage) listener;
				if (propertySheetPage.getControl() != null) {
					RefreshPropertySheetJob refreshPropertySheetJob = new RefreshPropertySheetJob(getDisplay(), XMLUIMessages.JFaceNodeAdapter_1, propertySheetPage); //$NON-NLS-1$
					refreshPropertySheetJob.schedule();
				}
			}
		}
	}

	/**
	 * Retrieves info from JFaceNodeAdapterFactory on whether or not to show
	 * attributes when getLabelText is called
	 * 
	 * @return boolean
	 */
	private boolean getShowAttribute() {
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=88444
		return ((JFaceNodeAdapterFactory) fAdapterFactory).getShowAttribute();
	}
}
