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

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.wst.sse.core.internal.contentmodel.CMNamedNodeMap;
import org.eclipse.wst.sse.core.internal.contentmodel.CMNode;



public class CMNamedNodeMapImpl implements CMNamedNodeMap 
{
  public static CMNamedNodeMapImpl EMPTY_NAMED_NODE_MAP = new CMNamedNodeMapImpl();
  protected Hashtable table = new Hashtable();

  /**
   * CMNamedNodeMapImpl constructor comment.
   */
  public CMNamedNodeMapImpl()
  {
  	super();
  }

  /**
   * getLength method
   * @return int
   */
  public int getLength()
  {
  	return table.size();
  }

  /**
   * getNamedItem method
   * @return CMNode
   * @param name java.lang.String
   */
  public CMNode getNamedItem(String name)
  {
  	return (CMNode)table.get(name);
  }

  /**
   * item method
   * @return CMNode
   * @param index int
   */
  public CMNode item(int index)
  {
    CMNode result = null;
    int size = table.size();
    if (index < size)
    {
      Enumeration values = table.elements();
      for(int i = 0; i <= index; i++)
      {
        result = (CMNode)values.nextElement();
      }
    }
    return result;
  }
  
  public Hashtable getHashtable()
  {
          return table;
  }
  
  public Iterator iterator()
  {
          return table.values().iterator();
  }        
  
  public void put(CMNode cmNode)
  {
    table.put(cmNode.getNodeName(), cmNode);
  }
}
  
