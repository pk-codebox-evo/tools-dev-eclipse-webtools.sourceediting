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
package org.eclipse.wst.html.core.contentmodel;



import org.eclipse.wst.html.core.HTML40Namespace;
import org.eclipse.wst.sse.core.internal.contentmodel.CMContent;
import org.eclipse.wst.sse.core.internal.contentmodel.CMGroup;
import org.eclipse.wst.sse.core.internal.contentmodel.CMNamedNodeMap;
import org.eclipse.wst.sse.core.internal.contentmodel.CMNode;

/**
 * NOFRAMES.
 */
final class HedNOFRAMES extends HTMLElemDeclImpl {

	/**
	 */
	public HedNOFRAMES(ElementCollection collection) {
		super(HTML40Namespace.ElementName.NOFRAMES, collection);
		typeDefinitionName = ComplexTypeDefinitionFactory.CTYPE_NOFRAMES_CONTENT;
		layoutType = LAYOUT_HIDDEN;
	}

	/**
	 * %attrs;
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
	 * Exclusion.
	 * <code>NOFRAMES</code> has the exclusion.
	 * It is <code>NOFRAMES</code> itself.
	 * @see com.ibm.sed.contentmodel.html.HTMLElementDeclaration
	 */
	public CMContent getExclusion() {
		if (exclusion != null)
			return exclusion; // already created.
		if (elementCollection == null)
			return null;

		exclusion = new CMGroupImpl(CMGroup.CHOICE, 1, 1);
		CMNode label = elementCollection.getNamedItem(HTML40Namespace.ElementName.NOFRAMES);
		if (label != null)
			exclusion.appendChild(label);

		return exclusion;
	}

	/**
	 */
	public CMNamedNodeMap getProhibitedAncestors() {
		if (prohibitedAncestors != null)
			return prohibitedAncestors;

		String[] names = {HTML40Namespace.ElementName.DIR, HTML40Namespace.ElementName.MENU, HTML40Namespace.ElementName.NOFRAMES};
		prohibitedAncestors = elementCollection.getDeclarations(names);

		return prohibitedAncestors;
	}
}