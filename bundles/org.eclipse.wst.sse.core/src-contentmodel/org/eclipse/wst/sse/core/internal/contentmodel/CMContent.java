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

public interface CMContent extends CMNode
{
/**
 * getMaxOccur method
 * @return int
 *
 * If -1, it's UNBOUNDED.
 */
int getMaxOccur();
/**
 * getMinOccur method
 * @return int
 *
 * If 0, it's OPTIONAL.
 * If 1, it's REQUIRED.
 */
int getMinOccur();
}
