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
package org.eclipse.jst.jsp.core.modelquery;



import org.eclipse.wst.sse.core.internal.contentmodel.modelquery.ModelQuery;
import org.eclipse.wst.sse.core.internal.contentmodel.util.CMDocumentCache;
import org.eclipse.wst.sse.core.modelquery.ModelQueryAdapterImpl;
import org.eclipse.wst.xml.uriresolver.util.IdResolver;


public class JSPModelQueryAdapterImpl extends ModelQueryAdapterImpl {
	public JSPModelQueryAdapterImpl(CMDocumentCache cmDocumentCache, ModelQuery modelQuery, IdResolver idResolver) {
		super(cmDocumentCache, modelQuery, idResolver);
	}
}