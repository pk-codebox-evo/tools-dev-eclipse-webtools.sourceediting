/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.html.core.contentmodel.chtml;



import org.eclipse.wst.sse.core.internal.contentmodel.CMNamedNodeMap;

/**
 * BLOCKQUOTE.
 */
final class HedBLOCKQUOTE extends HedFlowContainer {

	/**
	 */
	public HedBLOCKQUOTE(ElementCollection collection) {
		super(CHTMLNamespace.ElementName.BLOCKQUOTE, collection);
		correctionType = CORRECT_EMPTY;
		layoutType = LAYOUT_BLOCK;
	}

	/**
	 * %attrs;
	 * (cite %URI; #IMPLIED) 
	 */
	protected void createAttributeDeclarations() {
		if (attributes != null)
			return; // already created.
		if (attributeCollection == null)
			return; // fatal

		attributes = new CMNamedNodeMapImpl();

		// %attrs;
		attributeCollection.getAttrs(attributes);
	}

	/**
	 */
	public CMNamedNodeMap getProhibitedAncestors() {
		if (prohibitedAncestors != null)
			return prohibitedAncestors;

		String[] names = {CHTMLNamespace.ElementName.DIR, CHTMLNamespace.ElementName.MENU};
		prohibitedAncestors = elementCollection.getDeclarations(names);

		return prohibitedAncestors;
	}
}