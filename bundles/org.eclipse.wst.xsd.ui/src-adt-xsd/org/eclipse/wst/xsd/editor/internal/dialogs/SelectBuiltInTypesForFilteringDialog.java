/*******************************************************************************
 * Copyright (c) 2001, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation 
 *     Trung de Irene <trungha@ca.ibm.com>
 *******************************************************************************/
package org.eclipse.wst.xsd.editor.internal.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.wst.xsd.editor.XSDEditorPlugin;
import org.eclipse.wst.xsd.ui.internal.dialogs.types.xml.XMLComponentSpecification;

/**
 * The BuiltInTypesFilteringDialog is a SelectionDialog that allows the user to
 *  select a ...
 */
public class SelectBuiltInTypesForFilteringDialog extends CheckedTreeSelectionDialog {

	public final static String CUSTOM_LIST_SEPARATOR = XSDEditorPlugin.CUSTOM_LIST_SEPARATOR;

	public SelectBuiltInTypesForFilteringDialog(Shell parent, 
			ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider);

		init();
	}
	
	public CheckboxTreeViewer getTreeViewer(){
		return super.getTreeViewer();
	}
	
	private void init(){
		// grey state enable
		setContainerMode(true);
		
		// TODO externalize String
		setTitle("Set common Built-In types");
		setMessage("Select the types that you do not want to filter out: ");
		
		//super.create();
		//super.getTreeViewer().setSorter(new ViewerSorter());
		
	}
	
	/**
	 *   Returns a String acting as list of built-in types selected by the user
	 * in the filter dialog (white space acts as the item separator).
	 *   Suggest using getSelectedBuiltInTypesFromString
	 * to get a concrete array of selected types.
	 *   We can only store String in the plugin preference's storage so we have 
	 * use this method for conversion
	 */
	public static String getTypesListInString(Object[] chosenTypes) {
		String returningList = "";
		for (int i = 0; i < chosenTypes.length; i++){
			if ( chosenTypes[i] instanceof XMLComponentSpecification){
				XMLComponentSpecification aType = 
					(XMLComponentSpecification) chosenTypes[i];

				returningList += aType.getAttributeInfo("name") + CUSTOM_LIST_SEPARATOR;
			}
			/* else selectedBuiltInTypes[i] instanceof List, ie. a parentNode
			 * we ignore it. */
		}
		return returningList;
	}
	
	/**
	 * Filters out all built-In type not recorded in the 'listString' and 
	 * returns the result in a List
	 * Warning: recursive method
	 * @param listString 
	 * @param aContainer 
	 * 			Containing all types
	 * @return a subset of what 'aContainer' has as specified by 'listString'
	 */
	public static List getSelectedBuiltInTypesFromString(String listString, 
			List aContainer) {
		List selectedTypes = new ArrayList();

		// ignore the 'header' item in the container, starting from i = 1
		for (int i = 1; i < aContainer.size(); i++){
			Object o = aContainer.get(i);
			if ( o instanceof XMLComponentSpecification){
				XMLComponentSpecification aType = (XMLComponentSpecification) o;
				String typeName = (String) aType.getAttributeInfo("name");
				// if typeName's name appears in 'listString'
				if ( listString.indexOf(typeName + CUSTOM_LIST_SEPARATOR) != -1)
					selectedTypes.add(o);
			}
			else if ( o instanceof List){
				selectedTypes.addAll( getSelectedBuiltInTypesFromString(listString, (List) o) ); 
			}
		}
		return selectedTypes;
	}
}
