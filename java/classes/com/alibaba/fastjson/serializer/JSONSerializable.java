package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public abstract interface JSONSerializable
{
  public abstract void write(JSONSerializer paramJSONSerializer, Object paramObject, Type paramType, int paramInt)
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONSerializable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */