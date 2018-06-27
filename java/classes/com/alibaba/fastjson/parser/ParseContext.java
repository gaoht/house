package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

public class ParseContext
{
  public final Object fieldName;
  public Object object;
  public final ParseContext parent;
  private transient String path;
  public Type type;
  
  public ParseContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2)
  {
    this.parent = paramParseContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
  }
  
  public String toString()
  {
    if (this.path == null)
    {
      if (this.parent != null) {
        break label25;
      }
      this.path = "$";
    }
    for (;;)
    {
      return this.path;
      label25:
      if ((this.fieldName instanceof Integer)) {
        this.path = (this.parent.toString() + "[" + this.fieldName + "]");
      } else {
        this.path = (this.parent.toString() + "." + this.fieldName);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/parser/ParseContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */