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

/**
 * CMGroup interface
 */
public interface CMGroup extends CMContent {
  
	static final int ALL = 3;
	static final int CHOICE = 2;
	static final int SEQUENCE = 1;
/**
 * getChildNodes method
 * @return CMNodeList
 *
 * Returns child CMNodeList, which includes ElementDefinition or CMElement.
 */
CMNodeList getChildNodes();

/**
 * getOperation method
 * @return int
 *
 * Returns one of :
 * ALONE (a), SEQUENCE (a,b), CHOICE (a|b), ALL (a&b).
 */
int getOperator();
}
