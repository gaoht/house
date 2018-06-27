package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class FieldSerializer
  implements Comparable<FieldSerializer>
{
  private final String double_quoted_fieldPrefix;
  protected int features;
  protected BeanContext fieldContext;
  public final FieldInfo fieldInfo;
  private String format;
  private RuntimeSerializerInfo runtimeInfo;
  protected boolean serializeUsing = false;
  private String single_quoted_fieldPrefix;
  private String un_quoted_fieldPrefix;
  protected boolean writeEnumUsingName = false;
  protected boolean writeEnumUsingToString = false;
  protected final boolean writeNull;
  
  public FieldSerializer(Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    this.fieldInfo = paramFieldInfo;
    this.fieldContext = new BeanContext(paramClass, paramFieldInfo);
    paramFieldInfo.setAccessible();
    this.double_quoted_fieldPrefix = ('"' + paramFieldInfo.name + "\":");
    paramClass = paramFieldInfo.getAnnotation();
    boolean bool;
    if (paramClass != null)
    {
      paramFieldInfo = paramClass.serialzeFeatures();
      int k = paramFieldInfo.length;
      int i = 0;
      if (i < k)
      {
        label161:
        Object localObject;
        if ((paramFieldInfo[i].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0)
        {
          bool = true;
          this.format = paramClass.format();
          if (this.format.trim().length() == 0) {
            this.format = null;
          }
          paramFieldInfo = paramClass.serialzeFeatures();
          k = paramFieldInfo.length;
          i = j;
          if (i >= k) {
            break label215;
          }
          localObject = paramFieldInfo[i];
          if (localObject != SerializerFeature.WriteEnumUsingToString) {
            break label199;
          }
          this.writeEnumUsingToString = true;
        }
        for (;;)
        {
          i += 1;
          break label161;
          i += 1;
          break;
          label199:
          if (localObject == SerializerFeature.WriteEnumUsingName) {
            this.writeEnumUsingName = true;
          }
        }
        label215:
        this.features = SerializerFeature.of(paramClass.serialzeFeatures());
      }
    }
    for (;;)
    {
      this.writeNull = bool;
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public int compareTo(FieldSerializer paramFieldSerializer)
  {
    return this.fieldInfo.compareTo(paramFieldSerializer.fieldInfo);
  }
  
  public Object getPropertyValue(Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    Object localObject = this.fieldInfo.get(paramObject);
    paramObject = localObject;
    if (this.format != null)
    {
      paramObject = localObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (this.fieldInfo.fieldClass == Date.class)
        {
          paramObject = new SimpleDateFormat(this.format);
          ((SimpleDateFormat)paramObject).setTimeZone(a.a);
          paramObject = ((SimpleDateFormat)paramObject).format(localObject);
        }
      }
    }
    return paramObject;
  }
  
  public Object getPropertyValueDirect(Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    return this.fieldInfo.get(paramObject);
  }
  
  public void writePrefix(JSONSerializer paramJSONSerializer)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    if (paramJSONSerializer.quoteFieldNames)
    {
      if (paramJSONSerializer.useSingleQuotes)
      {
        if (this.single_quoted_fieldPrefix == null) {
          this.single_quoted_fieldPrefix = ('\'' + this.fieldInfo.name + "':");
        }
        paramJSONSerializer.write(this.single_quoted_fieldPrefix);
        return;
      }
      paramJSONSerializer.write(this.double_quoted_fieldPrefix);
      return;
    }
    if (this.un_quoted_fieldPrefix == null) {
      this.un_quoted_fieldPrefix = (this.fieldInfo.name + ":");
    }
    paramJSONSerializer.write(this.un_quoted_fieldPrefix);
  }
  
  public void writeValue(JSONSerializer paramJSONSerializer, Object paramObject)
    throws Exception
  {
    if (this.runtimeInfo == null) {
      if (paramObject != null) {
        break label136;
      }
    }
    Object localObject1;
    Object localObject2;
    int i;
    label136:
    for (Class localClass = this.fieldInfo.fieldClass;; localClass = paramObject.getClass())
    {
      localObject1 = this.fieldInfo.getAnnotation();
      if ((localObject1 == null) || (((JSONField)localObject1).serializeUsing() == Void.class)) {
        break;
      }
      localObject2 = (ObjectSerializer)((JSONField)localObject1).serializeUsing().newInstance();
      this.serializeUsing = true;
      this.runtimeInfo = new RuntimeSerializerInfo((ObjectSerializer)localObject2, localClass);
      localObject1 = this.runtimeInfo;
      i = this.fieldInfo.serialzeFeatures;
      if (paramObject != null) {
        break label357;
      }
      localObject2 = ((RuntimeSerializerInfo)localObject1).runtimeFieldClass;
      paramObject = paramJSONSerializer.out;
      if (!Number.class.isAssignableFrom((Class)localObject2)) {
        break label231;
      }
      ((SerializeWriter)paramObject).writeNull(this.features, SerializerFeature.WriteNullNumberAsZero.mask);
      return;
    }
    if (this.format != null) {
      if ((localClass == Double.TYPE) || (localClass == Double.class)) {
        localObject1 = new DoubleSerializer(this.format);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject2 = paramJSONSerializer.getObjectWriter(localClass);
      break;
      if ((localClass == Float.TYPE) || (localClass == Float.class))
      {
        localObject1 = new FloatCodec(this.format);
        continue;
        label231:
        if (String.class == localObject2)
        {
          ((SerializeWriter)paramObject).writeNull(this.features, SerializerFeature.WriteNullStringAsEmpty.mask);
          return;
        }
        if (Boolean.class == localObject2)
        {
          ((SerializeWriter)paramObject).writeNull(this.features, SerializerFeature.WriteNullBooleanAsFalse.mask);
          return;
        }
        if (Collection.class.isAssignableFrom((Class)localObject2))
        {
          ((SerializeWriter)paramObject).writeNull(this.features, SerializerFeature.WriteNullListAsEmpty.mask);
          return;
        }
        localObject1 = ((RuntimeSerializerInfo)localObject1).fieldSerializer;
        if ((((SerializeWriter)paramObject).isEnabled(SerializerFeature.WRITE_MAP_NULL_FEATURES)) && ((localObject1 instanceof JavaBeanSerializer)))
        {
          ((SerializeWriter)paramObject).writeNull();
          return;
        }
        ((ObjectSerializer)localObject1).write(paramJSONSerializer, null, this.fieldInfo.name, this.fieldInfo.fieldType, i);
        return;
        label357:
        if (this.fieldInfo.isEnum)
        {
          if (this.writeEnumUsingName)
          {
            paramJSONSerializer.out.writeString(((Enum)paramObject).name());
            return;
          }
          if (this.writeEnumUsingToString)
          {
            paramJSONSerializer.out.writeString(((Enum)paramObject).toString());
            return;
          }
        }
        localObject2 = paramObject.getClass();
        if ((localObject2 == ((RuntimeSerializerInfo)localObject1).runtimeFieldClass) || (this.serializeUsing)) {
          localObject1 = ((RuntimeSerializerInfo)localObject1).fieldSerializer;
        }
        while ((this.format != null) && (!(localObject1 instanceof DoubleSerializer)) && (!(localObject1 instanceof FloatCodec))) {
          if ((localObject1 instanceof ContextObjectSerializer))
          {
            ((ContextObjectSerializer)localObject1).write(paramJSONSerializer, paramObject, this.fieldContext);
            return;
            localObject1 = paramJSONSerializer.getObjectWriter((Class)localObject2);
          }
          else
          {
            paramJSONSerializer.writeWithFormat(paramObject, this.format);
            return;
          }
        }
        ((ObjectSerializer)localObject1).write(paramJSONSerializer, paramObject, this.fieldInfo.name, this.fieldInfo.fieldType, i);
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  static class RuntimeSerializerInfo
  {
    ObjectSerializer fieldSerializer;
    Class<?> runtimeFieldClass;
    
    public RuntimeSerializerInfo(ObjectSerializer paramObjectSerializer, Class<?> paramClass)
    {
      this.fieldSerializer = paramObjectSerializer;
      this.runtimeFieldClass = paramClass;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/FieldSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */