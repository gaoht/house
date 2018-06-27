package com.alibaba.fastjson.serializer;

public abstract interface LabelFilter
  extends SerializeFilter
{
  public abstract boolean apply(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/LabelFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */