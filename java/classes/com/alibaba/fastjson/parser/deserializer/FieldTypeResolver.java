package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

public abstract interface FieldTypeResolver
  extends ParseProcess
{
  public abstract Type resolve(Object paramObject, String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/FieldTypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */