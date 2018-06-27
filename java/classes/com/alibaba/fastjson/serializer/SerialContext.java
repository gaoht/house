package com.alibaba.fastjson.serializer;

public class SerialContext
{
  public final int features;
  public final Object fieldName;
  public final Object object;
  public final SerialContext parent;
  
  public SerialContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2)
  {
    this.parent = paramSerialContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
    this.features = paramInt1;
  }
  
  public String toString()
  {
    if (this.parent == null) {
      return "$";
    }
    if ((this.fieldName instanceof Integer)) {
      return this.parent.toString() + "[" + this.fieldName + "]";
    }
    return this.parent.toString() + "." + this.fieldName;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/SerialContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */