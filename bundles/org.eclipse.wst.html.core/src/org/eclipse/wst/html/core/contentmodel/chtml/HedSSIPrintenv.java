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
 * SSI:PRINTENV.
 */
final class HedSSIPrintenv extends HedSSIBase {

	/**
	 */
	public HedSSIPrintenv(ElementCollection collection) {
		super(CHTMLNamespace.ElementName.SSI_PRINTENV, collection);
	}

	/**
	 */
	protected void createAttributeDeclarations() {
		if (attributes != null)
			return; // already created.
		if (attributeCollection == null)
			return; // fatal

		attributes = new CMNamedNodeMapImpl();
	}

	/**
	 * SSI:PRINTENV has no attributes.  So, this method should
	 * always return <code>null</code>.
	 * Note: Since somebody doesn't expect null is returned, return the empty attribute
	 * like a custom tag which doesn't have attributes
	 */
	public CMNamedNodeMap getAttributes() {
		return super.getAttributes();
	}
}