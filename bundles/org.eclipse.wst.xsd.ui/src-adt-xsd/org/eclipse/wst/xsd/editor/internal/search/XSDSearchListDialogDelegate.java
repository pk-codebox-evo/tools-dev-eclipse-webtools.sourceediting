/*******************************************************************************
 * Copyright (c) 2001, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.xsd.editor.internal.search;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.common.core.search.pattern.QualifiedName;
import org.eclipse.wst.xsd.adt.edit.IComponentDialog;
import org.eclipse.wst.xsd.adt.search.ComponentSearchListDialog;
import org.eclipse.wst.xsd.adt.search.ComponentSearchListDialogConfiguration;
import org.eclipse.wst.xsd.adt.search.ComponentSpecification;
import org.eclipse.wst.xsd.adt.search.ScopedComponentSearchListDialog;
import org.eclipse.wst.xsd.editor.XSDEditorPlugin;
import org.eclipse.wst.xsd.editor.internal.dialogs.NewTypeButtonHandler;
import org.eclipse.wst.xsd.ui.internal.search.IXSDSearchConstants;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDConstants;

public class XSDSearchListDialogDelegate implements IComponentDialog
{
  public final static QualifiedName TYPE_META_NAME = new QualifiedName(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001, "type");
  // protected Object setObject;
  protected ComponentSpecification selection;
  protected IFile currentFile;
  protected XSDSchema[] schemas;
  protected QualifiedName metaName;

  public XSDSearchListDialogDelegate(QualifiedName metaName, IFile currentFile, XSDSchema[] schemas)
  {
    super();
    this.metaName = metaName;
    this.currentFile = currentFile;
    this.schemas = schemas;
  }

  public ComponentSpecification getSelectedComponent()
  {
    return selection;
  }

  public void setInitialSelection(ComponentSpecification componentSpecification)
  {
    // TODO Auto-generated method stub   
  }
  
  public int createAndOpen()
  {
    Shell shell = XSDEditorPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
    int returnValue = Window.CANCEL;
    ComponentSearchListDialog dialog = null;
    if (metaName == IXSDSearchConstants.ELEMENT_META_NAME)
    {
      // TODO
    }
    else if (metaName == TYPE_META_NAME)
    {
      XSDComponentDescriptionProvider descriptionProvider = new XSDComponentDescriptionProvider();
      final XSDComponentSearchListProvider searchListProvider = new XSDComponentSearchListProvider(currentFile, schemas);
 
      //ComponentSearchListDialogConfiguration configuration = new ThingerooDialogConfiguration()      
      ComponentSearchListDialogConfiguration configuration = new ComponentSearchListDialogConfiguration()
      {
        public void createToolBarItems(ToolBar toolBar)
        {
          // TODO Extra thing for RAD product. Not for open source
          FilterMenuContributor contributor = new FilterMenuContributor(searchListProvider, getDialog());      
          // TODO The icons gif files should be put in the icons directory of the old XSDEditor
          // make changes when this new editor is separated from the old editor
          contributor.setToolItemIconFile("icons/TriangleToolBar.gif");
          contributor.setOn_off_filter_actionText("Uncommon built-in types");
          contributor.setConfigureFilterDialogText("Filter");
          contributor.setFilterIconFile("filter.gif");
          contributor.createToolItem(toolBar);
        }
      };
      configuration.setDescriptionProvider(descriptionProvider);
      configuration.setSearchListProvider(searchListProvider);
      dialog = new ScopedComponentSearchListDialog(shell, XSDEditorPlugin.getXSDString("_UI_LABEL_SET_TYPE"), configuration);
      dialog.setFilterLabel("Text:");
            

      
      // TODO another non-open-source thing needs to be removed
      dialog.setNewButtonSelectionListener(new NewTypeButtonHandler());
    }
    
    if (dialog != null)
    {
      dialog.setBlockOnOpen(true);
      dialog.create();
      returnValue = dialog.open();
      if (returnValue == Window.OK)
      {
        selection = dialog.getSelectedComponent();
      }
    }
    return returnValue;
  }

  private IEditorPart getActiveEditor()
  {
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
    IEditorPart editorPart = workbenchWindow.getActivePage().getActiveEditor();
    return editorPart;
  }
}
