package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;

public class SerializeBeanInfo
{
  protected final Class<?> beanType;
  protected int features;
  protected final FieldInfo[] fields;
  protected final JSONType jsonType;
  protected final FieldInfo[] sortedFields;
  protected final String typeName;
  
  public SerializeBeanInfo(Class<?> paramClass, JSONType paramJSONType, String paramString, int paramInt, FieldInfo[] paramArrayOfFieldInfo1, FieldInfo[] paramArrayOfFieldInfo2)
  {
    this.beanType = paramClass;
    this.jsonType = paramJSONType;
    this.typeName = paramString;
    this.features = paramInt;
    this.fields = paramArrayOfFieldInfo1;
    this.sortedFields = paramArrayOfFieldInfo2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/SerializeBeanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */