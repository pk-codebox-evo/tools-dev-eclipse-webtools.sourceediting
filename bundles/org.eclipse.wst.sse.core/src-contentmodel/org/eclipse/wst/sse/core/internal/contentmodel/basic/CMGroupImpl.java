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
package org.eclipse.wst.sse.core.internal.contentmodel.basic;

import org.eclipse.wst.sse.core.internal.contentmodel.CMGroup;
import org.eclipse.wst.sse.core.internal.contentmodel.CMNodeList;

public class CMGroupImpl extends CMContentImpl implements CMGroup
{
  protected CMNodeList nodeList;                         
  protected int operator;  

  public CMGroupImpl(CMNodeList nodeList, int operator)
  {
    this.nodeList = nodeList;
    this.operator = operator;
  }

  public int getNodeType()
  {
    return GROUP;
  }
 
  public CMNodeList getChildNodes()
  {
    return nodeList;
  }

  public int getOperator()
  {
    return operator;
  } 
}   
