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



import org.eclipse.wst.sse.core.internal.contentmodel.CMElementDeclaration;
import org.eclipse.wst.sse.core.internal.contentmodel.CMGroup;

/**
 * Complex type definition for containers of <code>%flow;</code>.
 */
final class CtdFlowContainer extends ComplexTypeDefinition {

	/**
	 */
	public CtdFlowContainer(ElementCollection elementCollection) {
		super(elementCollection);
	}

	/**
	 * (%flow;)*
	 */
	protected void createContent() {
		if (content != null)
			return; // already created.
		if (collection == null)
			return;

		content = new CMGroupImpl(CMGroup.CHOICE, 0, CMContentImpl.UNBOUNDED);
		collection.getFlow(content);
	}

	/**
	 * @see com.ibm.sed.contentmodel.html.ComplexTypeDefinition
	 */
	public int getContentType() {
		return CMElementDeclaration.MIXED;
	}

	/**
	 * @see com.ibm.sed.contentmodel.html.ComplexTypeDefinition
	 */
	public String getTypeName() {
		return ComplexTypeDefinitionFactory.CTYPE_FLOW_CONTAINER;
	}
}