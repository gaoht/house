package com.alibaba.fastjson.parser.deserializer;

public abstract interface ExtraProcessor
  extends ParseProcess
{
  public abstract void processExtra(Object paramObject1, String paramString, Object paramObject2);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ExtraProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */