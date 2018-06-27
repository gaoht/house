package org.ksoap2.serialization;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.SoapFault12;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class SoapSerializationEnvelope
  extends SoapEnvelope
{
  private static final String ANY_TYPE_LABEL = "anyType";
  private static final String ARRAY_MAPPING_NAME = "Array";
  private static final String ARRAY_TYPE_LABEL = "arrayType";
  static final Marshal DEFAULT_MARSHAL = new DM();
  private static final String HREF_LABEL = "href";
  private static final String ID_LABEL = "id";
  private static final String ITEM_LABEL = "item";
  protected static final String NIL_LABEL = "nil";
  protected static final String NULL_LABEL = "null";
  protected static final int QNAME_MARSHAL = 3;
  protected static final int QNAME_NAMESPACE = 0;
  protected static final int QNAME_TYPE = 1;
  private static final String ROOT_LABEL = "root";
  private static final String TYPE_LABEL = "type";
  static Class class$org$ksoap2$serialization$SoapObject;
  protected boolean addAdornments = true;
  public boolean avoidExceptionForUnknownProperty;
  protected Hashtable classToQName = new Hashtable();
  public boolean dotNet;
  Hashtable idMap = new Hashtable();
  public boolean implicitTypes;
  Vector multiRef;
  public Hashtable properties = new Hashtable();
  protected Hashtable qNameToClass = new Hashtable();
  public boolean skipNullProperties;
  
  public SoapSerializationEnvelope(int paramInt)
  {
    super(paramInt);
    addMapping(this.enc, "Array", PropertyInfo.VECTOR_CLASS);
    DEFAULT_MARSHAL.register(this);
  }
  
  static Class class$(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  private int getIndex(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    for (;;)
    {
      return paramInt2;
      try
      {
        if (paramString.length() - paramInt1 >= 3)
        {
          paramInt1 = Integer.parseInt(paramString.substring(paramInt1 + 1, paramString.length() - 1));
          return paramInt1;
        }
      }
      catch (Exception paramString) {}
    }
    return paramInt2;
  }
  
  private void writeAttributes(XmlSerializer paramXmlSerializer, HasAttributes paramHasAttributes)
    throws IOException
  {
    int j = paramHasAttributes.getAttributeCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = new AttributeInfo();
      paramHasAttributes.getAttributeInfo(i, (AttributeInfo)localObject);
      String str1 = ((AttributeInfo)localObject).getNamespace();
      String str2 = ((AttributeInfo)localObject).getName();
      if (((AttributeInfo)localObject).getValue() != null) {}
      for (localObject = ((AttributeInfo)localObject).getValue().toString();; localObject = "")
      {
        paramXmlSerializer.attribute(str1, str2, (String)localObject);
        i += 1;
        break;
      }
    }
  }
  
  public void addMapping(String paramString1, String paramString2, Class paramClass)
  {
    addMapping(paramString1, paramString2, paramClass, null);
  }
  
  public void addMapping(String paramString1, String paramString2, Class paramClass, Marshal paramMarshal)
  {
    Hashtable localHashtable = this.qNameToClass;
    SoapPrimitive localSoapPrimitive = new SoapPrimitive(paramString1, paramString2, null);
    if (paramMarshal == null) {}
    for (Object localObject = paramClass;; localObject = paramMarshal)
    {
      localHashtable.put(localSoapPrimitive, localObject);
      this.classToQName.put(paramClass.getName(), new Object[] { paramString1, paramString2, null, paramMarshal });
      return;
    }
  }
  
  public void addTemplate(SoapObject paramSoapObject)
  {
    this.qNameToClass.put(new SoapPrimitive(paramSoapObject.namespace, paramSoapObject.name, null), paramSoapObject);
  }
  
  public Object[] getInfo(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      if (((paramObject2 instanceof SoapObject)) || ((paramObject2 instanceof SoapPrimitive))) {
        paramObject1 = paramObject2;
      }
    }
    for (;;)
    {
      if ((paramObject1 instanceof SoapObject))
      {
        paramObject1 = (SoapObject)paramObject1;
        paramObject1 = new Object[] { ((SoapObject)paramObject1).getNamespace(), ((SoapObject)paramObject1).getName(), null, null };
      }
      do
      {
        return (Object[])paramObject1;
        paramObject1 = paramObject2.getClass();
        break;
        if ((paramObject1 instanceof SoapPrimitive))
        {
          paramObject1 = (SoapPrimitive)paramObject1;
          return new Object[] { ((SoapPrimitive)paramObject1).getNamespace(), ((SoapPrimitive)paramObject1).getName(), null, DEFAULT_MARSHAL };
        }
        if ((!(paramObject1 instanceof Class)) || (paramObject1 == PropertyInfo.OBJECT_CLASS)) {
          break label151;
        }
        paramObject2 = (Object[])this.classToQName.get(((Class)paramObject1).getName());
        paramObject1 = paramObject2;
      } while (paramObject2 != null);
      label151:
      return new Object[] { this.xsd, "anyType", null, null };
    }
  }
  
  public Object getResponse()
    throws SoapFault
  {
    int i = 0;
    if ((this.bodyIn instanceof SoapFault)) {
      throw ((SoapFault)this.bodyIn);
    }
    KvmSerializable localKvmSerializable = (KvmSerializable)this.bodyIn;
    if (localKvmSerializable.getPropertyCount() == 0) {
      return null;
    }
    if (localKvmSerializable.getPropertyCount() == 1) {
      return localKvmSerializable.getProperty(0);
    }
    Vector localVector = new Vector();
    while (i < localKvmSerializable.getPropertyCount())
    {
      localVector.add(localKvmSerializable.getProperty(i));
      i += 1;
    }
    return localVector;
  }
  
  public boolean isAddAdornments()
  {
    return this.addAdornments;
  }
  
  public void parseBody(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    this.bodyIn = null;
    paramXmlPullParser.nextTag();
    Object localObject1;
    if ((paramXmlPullParser.getEventType() == 2) && (paramXmlPullParser.getNamespace().equals(this.env)) && (paramXmlPullParser.getName().equals("Fault"))) {
      if (this.version < 120)
      {
        localObject1 = new SoapFault(this.version);
        ((SoapFault)localObject1).parse(paramXmlPullParser);
        this.bodyIn = localObject1;
      }
    }
    for (;;)
    {
      return;
      localObject1 = new SoapFault12(this.version);
      break;
      while (paramXmlPullParser.getEventType() == 2)
      {
        localObject1 = paramXmlPullParser.getAttributeValue(this.enc, "root");
        Object localObject2 = read(paramXmlPullParser, null, -1, paramXmlPullParser.getNamespace(), paramXmlPullParser.getName(), PropertyInfo.OBJECT_TYPE);
        if (("1".equals(localObject1)) || (this.bodyIn == null)) {
          this.bodyIn = localObject2;
        }
        paramXmlPullParser.nextTag();
      }
    }
  }
  
  public Object read(XmlPullParser paramXmlPullParser, Object paramObject, int paramInt, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
    throws IOException, XmlPullParserException
  {
    String str2 = paramXmlPullParser.getName();
    String str1 = paramXmlPullParser.getAttributeValue(null, "href");
    if (str1 != null)
    {
      if (paramObject == null) {
        throw new RuntimeException("href at root level?!?");
      }
      paramPropertyInfo = str1.substring(1);
      paramString2 = this.idMap.get(paramPropertyInfo);
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (!(paramString2 instanceof FwdRef)) {}
      }
      else
      {
        paramString1 = new FwdRef();
        paramString1.next = ((FwdRef)paramString2);
        paramString1.obj = paramObject;
        paramString1.index = paramInt;
        this.idMap.put(paramPropertyInfo, paramString1);
        paramString1 = null;
      }
      paramXmlPullParser.nextTag();
      paramXmlPullParser.require(3, null, str2);
      paramXmlPullParser.require(3, null, str2);
      return paramString1;
    }
    str1 = paramXmlPullParser.getAttributeValue(this.xsi, "nil");
    String str3 = paramXmlPullParser.getAttributeValue(null, "id");
    paramObject = str1;
    if (str1 == null) {
      paramObject = paramXmlPullParser.getAttributeValue(this.xsi, "null");
    }
    if ((paramObject != null) && (SoapEnvelope.stringToBoolean((String)paramObject)))
    {
      paramXmlPullParser.nextTag();
      paramXmlPullParser.require(3, null, str2);
      paramString1 = null;
      if (str3 != null)
      {
        paramObject = this.idMap.get(str3);
        if (!(paramObject instanceof FwdRef)) {
          break label517;
        }
        paramObject = (FwdRef)paramObject;
      }
    }
    for (;;)
    {
      if ((((FwdRef)paramObject).obj instanceof KvmSerializable))
      {
        ((KvmSerializable)((FwdRef)paramObject).obj).setProperty(((FwdRef)paramObject).index, paramString1);
        label283:
        paramObject = ((FwdRef)paramObject).next;
        if (paramObject != null) {}
      }
      else
      {
        label352:
        label517:
        do
        {
          this.idMap.put(str3, paramString1);
          break;
          String str4 = paramXmlPullParser.getAttributeValue(this.xsi, "type");
          if (str4 != null)
          {
            paramInt = str4.indexOf(':');
            str1 = str4.substring(paramInt + 1);
            if (paramInt == -1)
            {
              paramObject = "";
              paramObject = paramXmlPullParser.getNamespace((String)paramObject);
            }
          }
          for (;;)
          {
            if (str4 == null) {
              this.implicitTypes = true;
            }
            paramString2 = readInstance(paramXmlPullParser, (String)paramObject, str1, paramPropertyInfo);
            paramString1 = paramString2;
            if (paramString2 != null) {
              break;
            }
            paramString1 = readUnknown(paramXmlPullParser, (String)paramObject, str1);
            break;
            paramObject = str4.substring(0, paramInt);
            break label352;
            paramObject = paramString1;
            str1 = paramString2;
            if (paramString2 == null)
            {
              paramObject = paramString1;
              str1 = paramString2;
              if (paramString1 == null) {
                if (paramXmlPullParser.getAttributeValue(this.enc, "arrayType") != null)
                {
                  paramObject = this.enc;
                  str1 = "Array";
                }
                else
                {
                  paramString1 = getInfo(paramPropertyInfo.type, null);
                  paramObject = (String)paramString1[0];
                  str1 = (String)paramString1[1];
                }
              }
            }
          }
          ((Vector)((FwdRef)paramObject).obj).setElementAt(paramString1, ((FwdRef)paramObject).index);
          break label283;
        } while (paramObject == null);
        throw new RuntimeException("double ID");
      }
    }
  }
  
  public Object readInstance(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
    throws IOException, XmlPullParserException
  {
    Object localObject = this.qNameToClass.get(new SoapPrimitive(paramString1, paramString2, null));
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Marshal)) {
      return ((Marshal)localObject).readInstance(paramXmlPullParser, paramString1, paramString2, paramPropertyInfo);
    }
    if ((localObject instanceof SoapObject)) {
      paramString1 = ((SoapObject)localObject).newInstance();
    }
    while ((paramString1 instanceof SoapObject))
    {
      readSerializable(paramXmlPullParser, (SoapObject)paramString1);
      return paramString1;
      Class localClass;
      if (class$org$ksoap2$serialization$SoapObject == null)
      {
        localClass = class$("org.ksoap2.serialization.SoapObject");
        class$org$ksoap2$serialization$SoapObject = localClass;
      }
      for (;;)
      {
        if (localObject != localClass) {
          break label132;
        }
        paramString1 = new SoapObject(paramString1, paramString2);
        break;
        localClass = class$org$ksoap2$serialization$SoapObject;
      }
      try
      {
        label132:
        paramString1 = ((Class)localObject).newInstance();
      }
      catch (Exception paramXmlPullParser)
      {
        throw new RuntimeException(paramXmlPullParser.toString());
      }
    }
    if ((paramString1 instanceof KvmSerializable))
    {
      readSerializable(paramXmlPullParser, (KvmSerializable)paramString1);
      return paramString1;
    }
    if ((paramString1 instanceof Vector))
    {
      readVector(paramXmlPullParser, (Vector)paramString1, paramPropertyInfo.elementType);
      return paramString1;
    }
    throw new RuntimeException("no deserializer for " + paramString1.getClass());
  }
  
  protected void readSerializable(XmlPullParser paramXmlPullParser, KvmSerializable paramKvmSerializable)
    throws IOException, XmlPullParserException
  {
    while (paramXmlPullParser.nextTag() != 3)
    {
      String str = paramXmlPullParser.getName();
      if ((!this.implicitTypes) || (!(paramKvmSerializable instanceof SoapObject)))
      {
        PropertyInfo localPropertyInfo = new PropertyInfo();
        int m = paramKvmSerializable.getPropertyCount();
        int j = 0;
        int i = 0;
        while ((i < m) && (j == 0))
        {
          localPropertyInfo.clear();
          paramKvmSerializable.getPropertyInfo(i, this.properties, localPropertyInfo);
          int k;
          if ((!str.equals(localPropertyInfo.name)) || (localPropertyInfo.namespace != null))
          {
            k = j;
            if (str.equals(localPropertyInfo.name))
            {
              k = j;
              if (!paramXmlPullParser.getNamespace().equals(localPropertyInfo.namespace)) {}
            }
          }
          else
          {
            paramKvmSerializable.setProperty(i, read(paramXmlPullParser, paramKvmSerializable, i, null, null, localPropertyInfo));
            k = 1;
          }
          i += 1;
          j = k;
        }
        if (j == 0)
        {
          if (this.avoidExceptionForUnknownProperty) {
            for (;;)
            {
              if (paramXmlPullParser.next() == 3) {
                if (str.equals(paramXmlPullParser.getName())) {
                  break;
                }
              }
            }
          }
          throw new RuntimeException("Unknown Property: " + str);
        }
      }
      else
      {
        ((SoapObject)paramKvmSerializable).addProperty(paramXmlPullParser.getName(), read(paramXmlPullParser, paramKvmSerializable, paramKvmSerializable.getPropertyCount(), ((SoapObject)paramKvmSerializable).getNamespace(), str, PropertyInfo.OBJECT_TYPE));
      }
    }
    paramXmlPullParser.require(3, null, null);
  }
  
  protected void readSerializable(XmlPullParser paramXmlPullParser, SoapObject paramSoapObject)
    throws IOException, XmlPullParserException
  {
    int i = 0;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      paramSoapObject.addAttribute(paramXmlPullParser.getAttributeName(i), paramXmlPullParser.getAttributeValue(i));
      i += 1;
    }
    readSerializable(paramXmlPullParser, paramSoapObject);
  }
  
  protected Object readUnknown(XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
    throws IOException, XmlPullParserException
  {
    int j = 0;
    String str2 = paramXmlPullParser.getName();
    String str3 = paramXmlPullParser.getNamespace();
    Vector localVector = new Vector();
    int i = 0;
    Object localObject;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      localObject = new AttributeInfo();
      ((AttributeInfo)localObject).setName(paramXmlPullParser.getAttributeName(i));
      ((AttributeInfo)localObject).setValue(paramXmlPullParser.getAttributeValue(i));
      ((AttributeInfo)localObject).setNamespace(paramXmlPullParser.getAttributeNamespace(i));
      ((AttributeInfo)localObject).setType(paramXmlPullParser.getAttributeType(i));
      localVector.addElement(localObject);
      i += 1;
    }
    paramXmlPullParser.next();
    String str1;
    if (paramXmlPullParser.getEventType() == 4)
    {
      str1 = paramXmlPullParser.getText();
      localObject = new SoapPrimitive(paramString1, paramString2, str1);
      i = 0;
      while (i < localVector.size())
      {
        ((SoapPrimitive)localObject).addAttribute((AttributeInfo)localVector.elementAt(i));
        i += 1;
      }
      paramXmlPullParser.next();
    }
    for (;;)
    {
      if (paramXmlPullParser.getEventType() == 2)
      {
        if ((str1 != null) && (str1.trim().length() != 0))
        {
          throw new RuntimeException("Malformed input: Mixed content");
          if (paramXmlPullParser.getEventType() == 3)
          {
            localObject = new SoapObject(paramString1, paramString2);
            i = 0;
            while (i < localVector.size())
            {
              ((SoapObject)localObject).addAttribute((AttributeInfo)localVector.elementAt(i));
              i += 1;
            }
            str1 = null;
          }
        }
        else
        {
          paramString1 = new SoapObject(paramString1, paramString2);
          i = j;
          while (i < localVector.size())
          {
            paramString1.addAttribute((AttributeInfo)localVector.elementAt(i));
            i += 1;
          }
          for (;;)
          {
            localObject = paramString1;
            if (paramXmlPullParser.getEventType() == 3) {
              break;
            }
            paramString1.addProperty(paramXmlPullParser.getName(), read(paramXmlPullParser, paramString1, paramString1.getPropertyCount(), null, null, PropertyInfo.OBJECT_TYPE));
            paramXmlPullParser.nextTag();
          }
        }
      }
      else
      {
        paramXmlPullParser.require(3, str3, str2);
        return localObject;
      }
      str1 = null;
      localObject = null;
    }
  }
  
  protected void readVector(XmlPullParser paramXmlPullParser, Vector paramVector, PropertyInfo paramPropertyInfo)
    throws IOException, XmlPullParserException
  {
    int i = paramVector.size();
    String str3 = paramXmlPullParser.getAttributeValue(this.enc, "arrayType");
    int j;
    String str2;
    String str1;
    if (str3 != null)
    {
      i = str3.indexOf(':');
      j = str3.indexOf("[", i);
      str2 = str3.substring(i + 1, j);
      if (i == -1)
      {
        str1 = "";
        str1 = paramXmlPullParser.getNamespace(str1);
        i = getIndex(str3, j, -1);
        if (i == -1) {
          break label274;
        }
        paramVector.setSize(i);
        j = 0;
      }
    }
    for (;;)
    {
      if (paramPropertyInfo == null) {
        paramPropertyInfo = PropertyInfo.OBJECT_TYPE;
      }
      for (;;)
      {
        paramXmlPullParser.nextTag();
        int k = getIndex(paramXmlPullParser.getAttributeValue(this.enc, "offset"), 0, 0);
        for (;;)
        {
          if (paramXmlPullParser.getEventType() != 3)
          {
            int m = getIndex(paramXmlPullParser.getAttributeValue(this.enc, "position"), 0, k);
            k = i;
            if (j != 0)
            {
              k = i;
              if (m >= i)
              {
                k = m + 1;
                paramVector.setSize(k);
              }
            }
            paramVector.setElementAt(read(paramXmlPullParser, paramVector, m, str1, str2, paramPropertyInfo), m);
            m += 1;
            paramXmlPullParser.nextTag();
            i = k;
            k = m;
            continue;
            str1 = str3.substring(0, i);
            break;
          }
        }
        paramXmlPullParser.require(3, null, null);
        return;
      }
      label274:
      j = 1;
      continue;
      j = 1;
      str2 = null;
      str1 = null;
    }
  }
  
  public void setAddAdornments(boolean paramBoolean)
  {
    this.addAdornments = paramBoolean;
  }
  
  public void setBodyOutEmpty(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.bodyOut = null;
    }
  }
  
  public void writeBody(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    Object[] arrayOfObject;
    if (this.bodyOut != null)
    {
      this.multiRef = new Vector();
      this.multiRef.addElement(this.bodyOut);
      arrayOfObject = getInfo(null, this.bodyOut);
      if (!this.dotNet) {
        break label169;
      }
      str = "";
      paramXmlSerializer.startTag(str, (String)arrayOfObject[1]);
      if (this.dotNet) {
        paramXmlSerializer.attribute(null, "xmlns", (String)arrayOfObject[0]);
      }
      if (this.addAdornments)
      {
        if (arrayOfObject[2] != null) {
          break label179;
        }
        str = "o0";
        label104:
        paramXmlSerializer.attribute(null, "id", str);
        paramXmlSerializer.attribute(this.enc, "root", "1");
      }
      writeElement(paramXmlSerializer, this.bodyOut, null, arrayOfObject[3]);
      if (!this.dotNet) {
        break label189;
      }
    }
    label169:
    label179:
    label189:
    for (String str = "";; str = (String)arrayOfObject[0])
    {
      paramXmlSerializer.endTag(str, (String)arrayOfObject[1]);
      return;
      str = (String)arrayOfObject[0];
      break;
      str = (String)arrayOfObject[2];
      break label104;
    }
  }
  
  protected void writeElement(XmlSerializer paramXmlSerializer, Object paramObject1, PropertyInfo paramPropertyInfo, Object paramObject2)
    throws IOException
  {
    if (paramObject2 != null)
    {
      ((Marshal)paramObject2).writeInstance(paramXmlSerializer, paramObject1);
      return;
    }
    if (((paramObject1 instanceof KvmSerializable)) || (paramObject1 == SoapPrimitive.NullNilElement) || (paramObject1 == SoapPrimitive.NullSkip))
    {
      writeObjectBodyWithAttributes(paramXmlSerializer, (KvmSerializable)paramObject1);
      return;
    }
    if ((paramObject1 instanceof Vector))
    {
      writeVectorBody(paramXmlSerializer, (Vector)paramObject1, paramPropertyInfo.elementType);
      return;
    }
    throw new RuntimeException("Cannot serialize: " + paramObject1);
  }
  
  public void writeObjectBody(XmlSerializer paramXmlSerializer, KvmSerializable paramKvmSerializable)
    throws IOException
  {
    int j = paramKvmSerializable.getPropertyCount();
    PropertyInfo localPropertyInfo = new PropertyInfo();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramKvmSerializable.getProperty(i);
      paramKvmSerializable.getPropertyInfo(i, this.properties, localPropertyInfo);
      Object localObject2;
      if (!(localObject1 instanceof SoapObject))
      {
        if ((localPropertyInfo.flags & 0x1) == 0)
        {
          localObject2 = paramKvmSerializable.getProperty(i);
          if (((localObject1 != null) || (!this.skipNullProperties)) && (localObject2 != SoapPrimitive.NullSkip))
          {
            paramXmlSerializer.startTag(localPropertyInfo.namespace, localPropertyInfo.name);
            writeProperty(paramXmlSerializer, localObject2, localPropertyInfo);
            paramXmlSerializer.endTag(localPropertyInfo.namespace, localPropertyInfo.name);
          }
        }
        i += 1;
      }
      else
      {
        SoapObject localSoapObject = (SoapObject)localObject1;
        localObject2 = getInfo(null, localSoapObject);
        localObject1 = (String)localObject2[0];
        String str1 = (String)localObject2[1];
        if ((localPropertyInfo.name != null) && (localPropertyInfo.name.length() > 0))
        {
          localObject1 = localPropertyInfo.name;
          label204:
          if ((localPropertyInfo.namespace == null) || (localPropertyInfo.namespace.length() <= 0)) {
            break label331;
          }
        }
        label331:
        for (localObject2 = localPropertyInfo.namespace;; localObject2 = (String)localObject2[0])
        {
          paramXmlSerializer.startTag((String)localObject2, (String)localObject1);
          if (!this.implicitTypes)
          {
            String str2 = paramXmlSerializer.getPrefix((String)localObject2, true);
            paramXmlSerializer.attribute(this.xsi, "type", str2 + ":" + str1);
          }
          writeObjectBodyWithAttributes(paramXmlSerializer, localSoapObject);
          paramXmlSerializer.endTag((String)localObject2, (String)localObject1);
          break;
          localObject1 = (String)localObject2[1];
          break label204;
        }
      }
    }
  }
  
  public void writeObjectBodyWithAttributes(XmlSerializer paramXmlSerializer, KvmSerializable paramKvmSerializable)
    throws IOException
  {
    if ((paramKvmSerializable instanceof HasAttributes)) {
      writeAttributes(paramXmlSerializer, (HasAttributes)paramKvmSerializable);
    }
    writeObjectBody(paramXmlSerializer, paramKvmSerializable);
  }
  
  protected void writeProperty(XmlSerializer paramXmlSerializer, Object paramObject, PropertyInfo paramPropertyInfo)
    throws IOException
  {
    if ((paramObject == null) || (paramObject == SoapPrimitive.NullNilElement))
    {
      paramPropertyInfo = this.xsi;
      if (this.version >= 120) {}
      for (paramObject = "nil";; paramObject = "null")
      {
        paramXmlSerializer.attribute(paramPropertyInfo, (String)paramObject, "true");
        return;
      }
    }
    Object[] arrayOfObject = getInfo(null, paramObject);
    if ((paramPropertyInfo.multiRef) || (arrayOfObject[2] != null))
    {
      int j = this.multiRef.indexOf(paramObject);
      int i = j;
      if (j == -1)
      {
        i = this.multiRef.size();
        this.multiRef.addElement(paramObject);
      }
      if (arrayOfObject[2] == null) {}
      for (paramObject = "#o" + i;; paramObject = "#" + arrayOfObject[2])
      {
        paramXmlSerializer.attribute(null, "href", (String)paramObject);
        return;
      }
    }
    if ((!this.implicitTypes) || (paramObject.getClass() != paramPropertyInfo.type))
    {
      String str = paramXmlSerializer.getPrefix((String)arrayOfObject[0], true);
      paramXmlSerializer.attribute(this.xsi, "type", str + ":" + arrayOfObject[1]);
    }
    writeElement(paramXmlSerializer, paramObject, paramPropertyInfo, arrayOfObject[3]);
  }
  
  protected void writeVectorBody(XmlSerializer paramXmlSerializer, Vector paramVector, PropertyInfo paramPropertyInfo)
    throws IOException
  {
    String str2;
    String str1;
    if (paramPropertyInfo == null)
    {
      paramPropertyInfo = PropertyInfo.OBJECT_TYPE;
      str2 = "item";
      str1 = null;
    }
    for (;;)
    {
      int m = paramVector.size();
      Object[] arrayOfObject = getInfo(paramPropertyInfo.type, null);
      String str3;
      label113:
      int k;
      if (!this.implicitTypes)
      {
        paramXmlSerializer.attribute(this.enc, "arrayType", paramXmlSerializer.getPrefix((String)arrayOfObject[0], false) + ":" + arrayOfObject[1] + "[" + m + "]");
        str3 = str1;
        k = 0;
        i = 0;
        label119:
        if (k >= m) {
          break label291;
        }
        if (paramVector.elementAt(k) != null) {
          break label197;
        }
      }
      label197:
      int j;
      for (int i = 1;; i = j)
      {
        k += 1;
        break label119;
        if ((!(paramPropertyInfo instanceof PropertyInfo)) || (paramPropertyInfo.name == null)) {
          break label292;
        }
        str2 = paramPropertyInfo.name;
        str1 = paramPropertyInfo.namespace;
        break;
        str3 = str1;
        if (str1 != null) {
          break label113;
        }
        str3 = (String)arrayOfObject[0];
        break label113;
        paramXmlSerializer.startTag(str3, str2);
        j = i;
        if (i != 0)
        {
          paramXmlSerializer.attribute(this.enc, "position", "[" + k + "]");
          j = 0;
        }
        writeProperty(paramXmlSerializer, paramVector.elementAt(k), paramPropertyInfo);
        paramXmlSerializer.endTag(str3, str2);
      }
      label291:
      return;
      label292:
      str2 = "item";
      str1 = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/ksoap2/serialization/SoapSerializationEnvelope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */