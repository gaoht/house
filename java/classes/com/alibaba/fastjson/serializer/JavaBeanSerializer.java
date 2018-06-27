package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaBeanSerializer
  extends SerializeFilterable
  implements ObjectSerializer
{
  protected SerializeBeanInfo beanInfo;
  protected final FieldSerializer[] getters;
  protected final FieldSerializer[] sortedGetters;
  
  public JavaBeanSerializer(SerializeBeanInfo paramSerializeBeanInfo)
  {
    this.beanInfo = paramSerializeBeanInfo;
    this.sortedGetters = new FieldSerializer[paramSerializeBeanInfo.sortedFields.length];
    int i = 0;
    while (i < this.sortedGetters.length)
    {
      this.sortedGetters[i] = new FieldSerializer(paramSerializeBeanInfo.beanType, paramSerializeBeanInfo.sortedFields[i]);
      i += 1;
    }
    if (paramSerializeBeanInfo.fields == paramSerializeBeanInfo.sortedFields) {
      this.getters = this.sortedGetters;
    }
    for (;;)
    {
      return;
      this.getters = new FieldSerializer[paramSerializeBeanInfo.fields.length];
      i = j;
      while (i < this.getters.length)
      {
        this.getters[i] = getFieldSerializer(paramSerializeBeanInfo.fields[i].name);
        i += 1;
      }
    }
  }
  
  public JavaBeanSerializer(Class<?> paramClass)
  {
    this(paramClass, (Map)null);
  }
  
  public JavaBeanSerializer(Class<?> paramClass, Map<String, String> paramMap)
  {
    this(TypeUtils.buildBeanInfo(paramClass, paramMap, null));
  }
  
  public JavaBeanSerializer(Class<?> paramClass, String... paramVarArgs)
  {
    this(paramClass, createAliasMap(paramVarArgs));
  }
  
  static Map<String, String> createAliasMap(String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localHashMap.put(str, str);
      i += 1;
    }
    return localHashMap;
  }
  
  protected boolean applyLabel(JSONSerializer paramJSONSerializer, String paramString)
  {
    if (paramJSONSerializer.labelFilters != null)
    {
      paramJSONSerializer = paramJSONSerializer.labelFilters.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((LabelFilter)paramJSONSerializer.next()).apply(paramString)) {
          return false;
        }
      }
    }
    if (this.labelFilters != null)
    {
      paramJSONSerializer = this.labelFilters.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((LabelFilter)paramJSONSerializer.next()).apply(paramString)) {
          return false;
        }
      }
    }
    return true;
  }
  
  protected BeanContext getBeanContext(int paramInt)
  {
    return this.sortedGetters[paramInt].fieldContext;
  }
  
  public FieldSerializer getFieldSerializer(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = 0;
    int j = this.sortedGetters.length - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.sortedGetters[k].fieldInfo.name.compareTo(paramString);
      if (m < 0) {
        i = k + 1;
      } else if (m > 0) {
        j = k - 1;
      } else {
        return this.sortedGetters[k];
      }
    }
    return null;
  }
  
  protected Type getFieldType(int paramInt)
  {
    return this.sortedGetters[paramInt].fieldInfo.fieldType;
  }
  
  public Object getFieldValue(Object paramObject, String paramString)
  {
    FieldSerializer localFieldSerializer = getFieldSerializer(paramString);
    if (localFieldSerializer == null) {
      throw new d("field not found. " + paramString);
    }
    try
    {
      paramObject = localFieldSerializer.getPropertyValue(paramObject);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new d("getFieldValue error." + paramString, (Throwable)paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new d("getFieldValue error." + paramString, (Throwable)paramObject);
    }
  }
  
  public List<Object> getFieldValues(Object paramObject)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList(this.sortedGetters.length);
    FieldSerializer[] arrayOfFieldSerializer = this.sortedGetters;
    int j = arrayOfFieldSerializer.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(arrayOfFieldSerializer[i].getPropertyValue(paramObject));
      i += 1;
    }
    return localArrayList;
  }
  
  public Map<String, Object> getFieldValuesMap(Object paramObject)
    throws Exception
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.sortedGetters.length);
    FieldSerializer[] arrayOfFieldSerializer = this.sortedGetters;
    int j = arrayOfFieldSerializer.length;
    int i = 0;
    while (i < j)
    {
      FieldSerializer localFieldSerializer = arrayOfFieldSerializer[i];
      localLinkedHashMap.put(localFieldSerializer.fieldInfo.name, localFieldSerializer.getPropertyValue(paramObject));
      i += 1;
    }
    return localLinkedHashMap;
  }
  
  public int getSize(Object paramObject)
    throws Exception
  {
    int j = 0;
    FieldSerializer[] arrayOfFieldSerializer = this.sortedGetters;
    int m = arrayOfFieldSerializer.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (arrayOfFieldSerializer[i].getPropertyValueDirect(paramObject) != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected boolean isWriteAsArray(JSONSerializer paramJSONSerializer)
  {
    return isWriteAsArray(paramJSONSerializer, 0);
  }
  
  protected boolean isWriteAsArray(JSONSerializer paramJSONSerializer, int paramInt)
  {
    int i = SerializerFeature.BeanToArray.mask;
    return ((this.beanInfo.features & i) != 0) || (paramJSONSerializer.out.beanToArray) || ((i & paramInt) != 0);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      localSerializeWriter.writeNull();
    }
    while (writeReference(paramJSONSerializer, paramObject1, paramInt)) {
      return;
    }
    FieldSerializer[] arrayOfFieldSerializer;
    SerialContext localSerialContext;
    boolean bool1;
    char c2;
    label82:
    char c1;
    if (localSerializeWriter.sortField)
    {
      arrayOfFieldSerializer = this.sortedGetters;
      localSerialContext = paramJSONSerializer.context;
      paramJSONSerializer.setContext(localSerialContext, paramObject1, paramObject2, this.beanInfo.features, paramInt);
      bool1 = isWriteAsArray(paramJSONSerializer, paramInt);
      if (!bool1) {
        break label327;
      }
      c2 = '[';
      if (!bool1) {
        break label334;
      }
      c1 = ']';
    }
    label91:
    int i;
    label183:
    label202:
    label218:
    label241:
    FieldSerializer localFieldSerializer;
    FieldInfo localFieldInfo;
    String str1;
    Class localClass1;
    try
    {
      localSerializeWriter.append(c2);
      if ((arrayOfFieldSerializer.length > 0) && (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)))
      {
        paramJSONSerializer.incrementIndent();
        paramJSONSerializer.println();
      }
      i = 0;
      if ((this.beanInfo.features & SerializerFeature.WriteClassName.mask) == 0)
      {
        paramInt = i;
        if (!paramJSONSerializer.isWriteClassName(paramType, paramObject1)) {}
      }
      else
      {
        paramInt = i;
        if (paramObject1.getClass() != paramType)
        {
          writeClassName(paramJSONSerializer, paramObject1);
          paramInt = 1;
        }
      }
    }
    catch (Exception localException)
    {
      boolean bool2;
      boolean bool3;
      int j;
      boolean bool4;
      label309:
      label327:
      label334:
      label341:
      label353:
      label359:
      paramType = "write javaBean error";
      if (paramObject1 == null) {
        break label497;
      }
      paramType = "write javaBean error" + ", class " + paramObject1.getClass().getName();
      label497:
      paramObject1 = paramType;
      if (paramObject2 == null) {
        break label530;
      }
      paramObject1 = paramType + ", fieldName : " + paramObject2;
      label530:
      paramObject2 = paramObject1;
      if (localException.getMessage() == null) {
        break label569;
      }
      paramObject2 = (String)paramObject1 + ", " + localException.getMessage();
      label569:
      throw new d((String)paramObject2, localException);
    }
    finally
    {
      paramJSONSerializer.context = localSerialContext;
    }
    if ((localSerializeWriter.quoteFieldNames) && (!localSerializeWriter.useSingleQuotes))
    {
      i = 1;
      if (writeBefore(paramJSONSerializer, paramObject1, c2) != ',') {
        break label353;
      }
      paramInt = 1;
      bool2 = localSerializeWriter.isEnabled(SerializerFeature.SkipTransientField);
      bool3 = localSerializeWriter.isEnabled(SerializerFeature.IgnoreNonFieldGetter);
      j = 0;
      if (j >= arrayOfFieldSerializer.length) {
        break label1230;
      }
      localFieldSerializer = arrayOfFieldSerializer[j];
      paramType = localFieldSerializer.fieldInfo.field;
      localFieldInfo = localFieldSerializer.fieldInfo;
      str1 = localFieldInfo.name;
      localClass1 = localFieldInfo.fieldClass;
      if ((!bool2) || (paramType == null)) {
        break label359;
      }
      bool4 = localFieldInfo.fieldTransient;
      if (!bool4) {
        break label359;
      }
    }
    String str2;
    Object localObject;
    Class localClass2;
    do
    {
      do
      {
        for (;;)
        {
          j += 1;
          break label241;
          arrayOfFieldSerializer = this.getters;
          break;
          c2 = '{';
          break label82;
          c1 = '}';
          break label91;
          c2 = '\000';
          break label183;
          i = 0;
          break label202;
          paramInt = 0;
          break label218;
          if ((!bool3) || (paramType != null))
          {
            if (!applyName(paramJSONSerializer, paramObject1, localFieldInfo.name)) {
              break label1209;
            }
            bool4 = applyLabel(paramJSONSerializer, localFieldInfo.label);
            if (bool4) {
              try
              {
                paramType = localFieldSerializer.getPropertyValueDirect(paramObject1);
                if (apply(paramJSONSerializer, paramObject1, str1, paramType)) {}
              }
              catch (InvocationTargetException paramType)
              {
                while (localSerializeWriter.isEnabled(SerializerFeature.IgnoreErrorGetter)) {
                  paramType = null;
                }
                throw paramType;
              }
            }
          }
        }
        str2 = processKey(paramJSONSerializer, paramObject1, str1, paramType);
        localObject = processValue(paramJSONSerializer, localFieldSerializer.fieldContext, paramObject1, str1, paramType);
      } while ((localObject == null) && (!bool1) && (!localFieldSerializer.writeNull) && (!localSerializeWriter.isEnabled(SerializerFeature.WRITE_MAP_NULL_FEATURES)));
      if ((localObject == null) || (!localSerializeWriter.notWriteDefaultValue)) {
        break label886;
      }
      localClass2 = localFieldInfo.fieldClass;
    } while (((localClass2 == Byte.TYPE) && ((localObject instanceof Byte)) && (((Byte)localObject).byteValue() == 0)) || ((localClass2 == Short.TYPE) && ((localObject instanceof Short)) && (((Short)localObject).shortValue() == 0)) || ((localClass2 == Integer.TYPE) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 0)) || ((localClass2 == Long.TYPE) && ((localObject instanceof Long)) && (((Long)localObject).longValue() == 0L)) || ((localClass2 == Float.TYPE) && ((localObject instanceof Float)) && (((Float)localObject).floatValue() == 0.0F)) || ((localClass2 == Double.TYPE) && ((localObject instanceof Double)) && (((Double)localObject).doubleValue() == 0.0D)) || ((localClass2 == Boolean.TYPE) && ((localObject instanceof Boolean)) && (!((Boolean)localObject).booleanValue())));
    label886:
    if (paramInt != 0)
    {
      localSerializeWriter.write(44);
      if (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
        paramJSONSerializer.println();
      }
    }
    if (str2 != str1)
    {
      if (!bool1) {
        localSerializeWriter.writeFieldName(str2, true);
      }
      paramJSONSerializer.write(localObject);
    }
    else if (paramType != localObject)
    {
      if (!bool1) {
        localFieldSerializer.writePrefix(paramJSONSerializer);
      }
      paramJSONSerializer.write(localObject);
    }
    else
    {
      if (!bool1)
      {
        if (i == 0) {
          break label1079;
        }
        localSerializeWriter.write(localFieldInfo.name_chars, 0, localFieldInfo.name_chars.length);
      }
      while (!bool1)
      {
        paramType = localFieldInfo.getAnnotation();
        if ((localClass1 == String.class) && ((paramType == null) || (paramType.serializeUsing() == Void.class)))
        {
          if (localObject == null)
          {
            if (((localSerializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0) || ((localFieldSerializer.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0))
            {
              localSerializeWriter.writeString("");
              break label1224;
              label1079:
              localFieldSerializer.writePrefix(paramJSONSerializer);
            }
            else
            {
              localSerializeWriter.writeNull();
              break label1224;
            }
          }
          else
          {
            paramType = (String)localObject;
            if (localSerializeWriter.useSingleQuotes)
            {
              localSerializeWriter.writeStringWithSingleQuote(paramType);
              break label1224;
            }
            localSerializeWriter.writeStringWithDoubleQuote(paramType, '\000');
            break label1224;
          }
        }
        else
        {
          localFieldSerializer.writeValue(paramJSONSerializer, localObject);
          break label1224;
        }
      }
      localFieldSerializer.writeValue(paramJSONSerializer, localObject);
    }
    for (;;)
    {
      label1154:
      writeAfter(paramJSONSerializer, paramObject1, c2);
      if ((localException.length > 0) && (localSerializeWriter.isEnabled(SerializerFeature.PrettyFormat)))
      {
        paramJSONSerializer.decrementIdent();
        paramJSONSerializer.println();
      }
      localSerializeWriter.append(c1);
      paramJSONSerializer.context = localSerialContext;
      return;
      label1209:
      label1224:
      label1230:
      do
      {
        c2 = '\000';
        break label1154;
        break label309;
        if (paramInt == 0) {
          break label341;
        }
        c2 = ',';
        break;
        paramInt = 1;
        break label309;
      } while (paramInt == 0);
      c2 = ',';
    }
  }
  
  protected char writeAfter(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar)
  {
    char c = paramChar;
    Iterator localIterator;
    if (paramJSONSerializer.afterFilters != null)
    {
      localIterator = paramJSONSerializer.afterFilters.iterator();
      for (;;)
      {
        c = paramChar;
        if (!localIterator.hasNext()) {
          break;
        }
        paramChar = ((AfterFilter)localIterator.next()).writeAfter(paramJSONSerializer, paramObject, paramChar);
      }
    }
    paramChar = c;
    if (this.afterFilters != null)
    {
      localIterator = this.afterFilters.iterator();
      for (;;)
      {
        paramChar = c;
        if (!localIterator.hasNext()) {
          break;
        }
        c = ((AfterFilter)localIterator.next()).writeAfter(paramJSONSerializer, paramObject, c);
      }
    }
    return paramChar;
  }
  
  public void writeAsArray(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    write(paramJSONSerializer, paramObject1, paramObject2, paramType, paramInt);
  }
  
  public void writeAsArrayNonContext(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    write(paramJSONSerializer, paramObject1, paramObject2, paramType, paramInt);
  }
  
  protected char writeBefore(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar)
  {
    char c = paramChar;
    Iterator localIterator;
    if (paramJSONSerializer.beforeFilters != null)
    {
      localIterator = paramJSONSerializer.beforeFilters.iterator();
      for (;;)
      {
        c = paramChar;
        if (!localIterator.hasNext()) {
          break;
        }
        paramChar = ((BeforeFilter)localIterator.next()).writeBefore(paramJSONSerializer, paramObject, paramChar);
      }
    }
    paramChar = c;
    if (this.beforeFilters != null)
    {
      localIterator = this.beforeFilters.iterator();
      for (;;)
      {
        paramChar = c;
        if (!localIterator.hasNext()) {
          break;
        }
        c = ((BeforeFilter)localIterator.next()).writeBefore(paramJSONSerializer, paramObject, c);
      }
    }
    return paramChar;
  }
  
  protected void writeClassName(JSONSerializer paramJSONSerializer, Object paramObject)
  {
    paramJSONSerializer.out.writeFieldName(paramJSONSerializer.config.typeKey, false);
    String str = this.beanInfo.typeName;
    Object localObject = str;
    if (str == null)
    {
      localObject = paramObject.getClass();
      paramObject = localObject;
      if (TypeUtils.isProxy((Class)localObject)) {
        paramObject = ((Class)localObject).getSuperclass();
      }
      localObject = ((Class)paramObject).getName();
    }
    paramJSONSerializer.write((String)localObject);
  }
  
  public void writeDirectNonContext(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    write(paramJSONSerializer, paramObject1, paramObject2, paramType, paramInt);
  }
  
  public boolean writeReference(JSONSerializer paramJSONSerializer, Object paramObject, int paramInt)
  {
    SerialContext localSerialContext = paramJSONSerializer.context;
    int i = SerializerFeature.DisableCircularReferenceDetect.mask;
    if ((localSerialContext == null) || ((localSerialContext.features & i) != 0) || ((paramInt & i) != 0)) {}
    while ((paramJSONSerializer.references == null) || (!paramJSONSerializer.references.containsKey(paramObject))) {
      return false;
    }
    paramJSONSerializer.writeReference(paramObject);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/JavaBeanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */