package org.xmlpull.v1;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class XmlPullParserFactory
{
  public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
  private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
  static final Class referenceContextClass = new XmlPullParserFactory().getClass();
  protected String classNamesLocation;
  protected Hashtable features = new Hashtable();
  protected Vector parserClasses;
  protected Vector serializerClasses;
  
  public static XmlPullParserFactory newInstance()
    throws XmlPullParserException
  {
    return newInstance(null, null);
  }
  
  public static XmlPullParserFactory newInstance(String paramString, Class paramClass)
    throws XmlPullParserException
  {
    Object localObject1 = paramClass;
    if (paramClass == null) {
      localObject1 = referenceContextClass;
    }
    String str1;
    label120:
    Vector localVector1;
    Vector localVector2;
    if ((paramString == null) || (paramString.length() == 0) || ("DEFAULT".equals(paramString)))
    {
      try
      {
        paramString = ((Class)localObject1).getResourceAsStream("/META-INF/services/org.xmlpull.v1.XmlPullParserFactory");
        if (paramString == null) {
          throw new XmlPullParserException("resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available");
        }
      }
      catch (Exception paramString)
      {
        throw new XmlPullParserException(null, null, paramString);
      }
      paramClass = new StringBuffer();
      i = paramString.read();
      if (i < 0)
      {
        paramString.close();
        str1 = paramClass.toString();
        localObject1 = "resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '" + str1 + "'";
        localVector1 = new Vector();
        localVector2 = new Vector();
        i = 0;
      }
    }
    Object localObject3;
    for (paramString = null;; paramString = (String)localObject3)
    {
      if (i >= str1.length()) {
        break label368;
      }
      int k = str1.indexOf(',', i);
      int j = k;
      if (k == -1) {
        j = str1.length();
      }
      String str2 = str1.substring(i, j);
      for (;;)
      {
        try
        {
          paramClass = Class.forName(str2);
        }
        catch (Exception paramClass)
        {
          char c;
          paramClass = null;
        }
        try
        {
          localObject2 = paramClass.newInstance();
          localObject3 = paramString;
          if (paramClass == null) {
            break label357;
          }
          if (!(localObject2 instanceof XmlPullParser)) {
            break label410;
          }
          localVector1.addElement(paramClass);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;) {}
          continue;
          i = 0;
          continue;
        }
        if ((localObject2 instanceof XmlSerializer))
        {
          localVector2.addElement(paramClass);
          i = 1;
        }
        paramClass = paramString;
        if ((localObject2 instanceof XmlPullParserFactory))
        {
          if (paramString != null) {
            break label407;
          }
          paramString = (XmlPullParserFactory)localObject2;
          i = 1;
          paramClass = paramString;
        }
        localObject3 = paramClass;
        if (i != 0) {
          break label357;
        }
        throw new XmlPullParserException("incompatible class: " + str2);
        if (i <= 32) {
          break;
        }
        c = (char)i;
        paramClass.append(c);
        break;
        localObject1 = "parameter classNames to newInstance() that contained '" + paramString + "'";
        str1 = paramString;
        break label120;
        Object localObject2 = null;
      }
      label357:
      i = j + 1;
    }
    label368:
    paramClass = paramString;
    if (paramString == null) {
      paramClass = new XmlPullParserFactory();
    }
    paramClass.parserClasses = localVector1;
    paramClass.serializerClasses = localVector2;
    paramClass.classNamesLocation = ((String)localObject1);
    return paramClass;
  }
  
  public boolean getFeature(String paramString)
  {
    paramString = (Boolean)this.features.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  public boolean isNamespaceAware()
  {
    return getFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces");
  }
  
  public boolean isValidating()
  {
    return getFeature("http://xmlpull.org/v1/doc/features.html#validation");
  }
  
  public XmlPullParser newPullParser()
    throws XmlPullParserException
  {
    if (this.parserClasses == null) {
      throw new XmlPullParserException("Factory initialization was incomplete - has not tried " + this.classNamesLocation);
    }
    if (this.parserClasses.size() == 0) {
      throw new XmlPullParserException("No valid parser classes found in " + this.classNamesLocation);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < this.parserClasses.size())
      {
        Class localClass = (Class)this.parserClasses.elementAt(i);
        try
        {
          XmlPullParser localXmlPullParser = (XmlPullParser)localClass.newInstance();
          Enumeration localEnumeration = this.features.keys();
          while (localEnumeration.hasMoreElements())
          {
            String str = (String)localEnumeration.nextElement();
            Boolean localBoolean = (Boolean)this.features.get(str);
            if ((localBoolean != null) && (localBoolean.booleanValue())) {
              localXmlPullParser.setFeature(str, true);
            }
          }
        }
        catch (Exception localException)
        {
          localStringBuffer.append(localClass.getName() + ": " + localException.toString() + "; ");
          i += 1;
        }
      }
    }
    throw new XmlPullParserException("could not create parser: " + localStringBuffer);
    return localException;
  }
  
  public XmlSerializer newSerializer()
    throws XmlPullParserException
  {
    if (this.serializerClasses == null) {
      throw new XmlPullParserException("Factory initialization incomplete - has not tried " + this.classNamesLocation);
    }
    if (this.serializerClasses.size() == 0) {
      throw new XmlPullParserException("No valid serializer classes found in " + this.classNamesLocation);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.serializerClasses.size())
    {
      Class localClass = (Class)this.serializerClasses.elementAt(i);
      try
      {
        XmlSerializer localXmlSerializer = (XmlSerializer)localClass.newInstance();
        return localXmlSerializer;
      }
      catch (Exception localException)
      {
        localStringBuffer.append(localClass.getName() + ": " + localException.toString() + "; ");
        i += 1;
      }
    }
    throw new XmlPullParserException("could not create serializer: " + localStringBuffer);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
    throws XmlPullParserException
  {
    this.features.put(paramString, new Boolean(paramBoolean));
  }
  
  public void setNamespaceAware(boolean paramBoolean)
  {
    this.features.put("http://xmlpull.org/v1/doc/features.html#process-namespaces", new Boolean(paramBoolean));
  }
  
  public void setValidating(boolean paramBoolean)
  {
    this.features.put("http://xmlpull.org/v1/doc/features.html#validation", new Boolean(paramBoolean));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/xmlpull/v1/XmlPullParserFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */