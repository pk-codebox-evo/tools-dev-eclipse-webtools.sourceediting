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
package org.eclipse.wst.sse.core.internal.contentmodel.internal.annotation;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.wst.sse.core.internal.contentmodel.annotation.Annotation;
import org.eclipse.wst.sse.core.internal.contentmodel.annotation.AnnotationMap;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 
 */
public class AnnotationFileParser
{
  public static final String TAG_ID_ANNOTATIONS = "abstractGrammarAnnotations";
  public static final String TAG_ID_ANNOTATION = "annotation";                               
  public static final String TAG_ID_PROPERTY = "property";  

  /**
   * This method is called to parse an annotation file and store the contents into an annotationMap
   */
  protected void parse(AnnotationMap annotationMap, InputStream input, String baseURI) throws Exception
  {
    // move to Xerces-2.... add 'contextClassLoader' stuff
    ClassLoader prevClassLoader = Thread.currentThread().getContextClassLoader();
    try
    {
    	SAXParserFactory factory = SAXParserFactory.newInstance();
    	factory.setNamespaceAware(true);
    	SAXParser parser = factory.newSAXParser();
    	parser.parse(new InputSource(input), new AnnotationMapContentHandler(annotationMap, baseURI));
    }
    finally
    {
      Thread.currentThread().setContextClassLoader(prevClassLoader);
    }
  } 

  /**
   * This method is called to parse an annotation file and store the contents into an annotationMap
   */
  public void parse(AnnotationMap map, String uri) throws Exception
  {   
    InputStream inputStream = null;
    try
    {       
      URL url = new URL(uri); 
      inputStream = url.openStream(); 
      int index = uri.lastIndexOf("/");
      if (index == -1)
      {
        throw new Exception("malformed uri");
      }
      String baseURI = uri.substring(0, index);
      parse(map, inputStream, baseURI);               
    }
    catch (Exception e)
    {    
      e.printStackTrace();
      throw(e);
    }
    finally
    {
      try
      {
        inputStream.close();
      }
      catch (Exception e)
      {
      }
    }
  }
 

  protected String quote(String string)
  {
    return "\"" + string + "\"";
  }


  protected void printlnIndented(PrintStream out, int indent, String string)
  {
    for (int i = 0; i < indent; i++)
    {
      out.print(" ");
    }
    out.println(string);
  }    


  protected class AnnotationMapContentHandler extends DefaultHandler
  {
    protected AnnotationMap annotationMap;
    protected Annotation currentAnnotation;  
    protected String currentPropertyName;    
    protected StringBuffer propertyValueBuffer;
    protected ResourceBundle resourceBundle; 
    protected String baseURI;

    public AnnotationMapContentHandler(AnnotationMap annotationMap, String baseURI)
    {
      this.annotationMap = annotationMap;                                                                              
      this.baseURI = baseURI;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)  throws SAXException
    {         
      propertyValueBuffer = new StringBuffer();
      if (localName.equals(TAG_ID_ANNOTATIONS))
      {
        int attributesLength = attributes.getLength();
        for (int i = 0; i < attributesLength; i++)
        {                  
          String attributeName = attributes.getLocalName(i);
          String attributeValue = attributes.getValue(i);  
          if (attributeName.equals("propertiesLocation"))
          {                                                 
            String resourceURI = baseURI + "/" + attributeValue;  
            try
            {                     
              resourceBundle = ResourceBundleHelper.getResourceBundle(resourceURI);
            }
            catch (Exception e)
            {           
              e.printStackTrace();
            }
          } 
          else if (attributeName.equals("caseSensitive"))
          {   
            if (attributeValue.trim().equals("false"))
            {
              annotationMap.setCaseSensitive(false);
            }                 
          }
        }
      }
      else if (localName.equals(TAG_ID_ANNOTATION))
      {                 
        currentAnnotation = null;
        String specValue = attributes.getValue("spec");                                          
        if (specValue != null)
        {
          currentAnnotation = new Annotation();   
          currentAnnotation.setSpec(specValue); 
        }    
        annotationMap.addAnnotation(currentAnnotation);
      }
      else if (localName.equals(TAG_ID_PROPERTY))
      {           
        if (currentAnnotation != null)
        {                          
          currentPropertyName = attributes.getValue("name");   
        }                                                   
      }           
    }   
                             
    public void endElement(String uri, String localName, String qName)  throws SAXException
    {          
      if (currentPropertyName != null && currentAnnotation != null)
      {   
        String propertyValue = propertyValueBuffer.toString();
        if (propertyValue != null)
        {
          if (propertyValue.startsWith("%") && resourceBundle != null)
          {  
            try
            {
              propertyValue = resourceBundle.getString(propertyValue.substring(1));
            }
            catch (Exception e)
            {
              // ignore any exception that occurs while trying to fetch a resource
            }
          }
          currentAnnotation.setProperty(currentPropertyName, propertyValue);       
        }
      }

      if (localName.equals(TAG_ID_ANNOTATION))
      {                 
        currentAnnotation = null;
      }
      else if (localName.equals(TAG_ID_PROPERTY))
      {         
        currentPropertyName = null;                                                 
      }  
    }

    public void characters(char[] ch, int start, int length) 
    {  
      if (currentPropertyName != null && currentAnnotation != null)
      {   
        propertyValueBuffer.append(ch, start, length);       
      }
    }
  }
}
