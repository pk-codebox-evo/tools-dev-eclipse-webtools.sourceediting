/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 *******************************************************************************/
package org.eclipse.wst.xsd.ui.internal.search.actions;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;

//org.eclipse.wst.xsd.ui.internal.search.actions.XSDSearchGroupActionDelegate
public class XSDSearchReferencesGroupActionDelegate extends BaseGroupActionDelegate
{
    protected void fillMenu(Menu menu) {
      try
      {
        if (fSelection == null) {
            return;
        }  
        if (workbenchPart instanceof IEditorPart)
        {            
          ReferencesSearchGroup referencesGroup = new ReferencesSearchGroup((IEditorPart)workbenchPart);
          XSDSearchGroupSubMenu subMenu = new XSDSearchGroupSubMenu(referencesGroup);
          subMenu.fill(menu, -1);
        }  
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }  
}
