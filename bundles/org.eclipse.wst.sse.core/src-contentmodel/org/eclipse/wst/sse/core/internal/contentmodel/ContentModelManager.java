/*
 * Copyright (c) 2002 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Jens Lukowski/Innoopract - initial renaming/restructuring
 * 
 */
package org.eclipse.wst.sse.core.internal.contentmodel;

import java.util.List;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.wst.sse.core.internal.contentmodel.factory.CMDocumentFactory;
import org.eclipse.wst.sse.core.internal.contentmodel.factory.CMDocumentFactoryRegistry;
import org.eclipse.wst.sse.core.internal.contentmodel.factory.CMDocumentFactoryRegistryReader;
import org.eclipse.wst.sse.core.internal.contentmodel.internal.annotation.AnnotationFileRegistry;
import org.eclipse.wst.sse.core.internal.contentmodel.internal.annotation.AnnotationFileRegistryReader;


/**
 * ContentModelManager class
 */
public class ContentModelManager extends Plugin {
	// private static InferredGrammarFactory inferredGrammarFactory;
	private CMDocumentFactoryRegistry cmDocumentFactoryRegistry;
	private AnnotationFileRegistry annotationFileRegistry;

	private static ContentModelManager instance;

	public ContentModelManager() {
		super();
	}

	public static ContentModelManager getInstance() {
		if (instance == null) {
			instance = new ContentModelManager();
		}
		return instance;
	}

	public CMDocument createCMDocument(String uri, String resourceType) {
		if (resourceType == null && uri != null) {
			int index = uri.lastIndexOf(".");
			resourceType = uri.substring(index + 1);
		}

		if (resourceType != null) {
			resourceType = resourceType.toLowerCase();
		}
		CMDocumentFactory factory = getCMDocumentFactoryRegistry().getFactory(resourceType);
		return factory != null ? factory.createCMDocument(uri) : null;
	}


	private CMDocumentFactoryRegistry getCMDocumentFactoryRegistry() {
		if (cmDocumentFactoryRegistry == null) {
			cmDocumentFactoryRegistry = new CMDocumentFactoryRegistry();
			new CMDocumentFactoryRegistryReader(cmDocumentFactoryRegistry).readRegistry();
		}
		return cmDocumentFactoryRegistry;
	}


	public List getAnnotationFiles(String publicId) {
		return getAnnotationFileRegistry().getAnnotationFiles(publicId);
	}


	private AnnotationFileRegistry getAnnotationFileRegistry() {
		if (annotationFileRegistry == null) {
			annotationFileRegistry = new AnnotationFileRegistry();
			new AnnotationFileRegistryReader(annotationFileRegistry).readRegistry();
		}
		return annotationFileRegistry;
	}
}
