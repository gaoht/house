package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class BeanContext
{
  private final Class<?> beanClass;
  private final FieldInfo fieldInfo;
  private final String format;
  
  public BeanContext(Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    this.beanClass = paramClass;
    this.fieldInfo = paramFieldInfo;
    this.format = paramFieldInfo.getFormat();
  }
  
  public <T extends Annotation> T getAnnation(Class<T> paramClass)
  {
    return this.fieldInfo.getAnnation(paramClass);
  }
  
  public Class<?> getBeanClass()
  {
    return this.beanClass;
  }
  
  public int getFeatures()
  {
    return this.fieldInfo.serialzeFeatures;
  }
  
  public Field getField()
  {
    return this.fieldInfo.field;
  }
  
  public Class<?> getFieldClass()
  {
    return this.fieldInfo.fieldClass;
  }
  
  public Type getFieldType()
  {
    return this.fieldInfo.fieldType;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public String getLabel()
  {
    return this.fieldInfo.label;
  }
  
  public Method getMethod()
  {
    return this.fieldInfo.method;
  }
  
  public String getName()
  {
    return this.fieldInfo.name;
  }
  
  public boolean isJsonDirect()
  {
    return this.fieldInfo.jsonDirect;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/BeanContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */