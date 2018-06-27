package com.alibaba.fastjson.serializer;

import java.io.IOException;

public abstract interface ContextObjectSerializer
  extends ObjectSerializer
{
  public abstract void write(JSONSerializer paramJSONSerializer, Object paramObject, BeanContext paramBeanContext)
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/ContextObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */