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
package org.eclipse.wst.sse.ui.extension;



import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * IExtendedMarkupEditor
 * @deprecated
 */
public interface IExtendedMarkupEditor extends IExtendedSimpleEditor {

	public Node getCaretNode();

	public Document getDOMDocument();

	public List getSelectedNodes();
}
