package com.b.c.j;

import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    }
    return getExtensionCodeDescription();
  }
  
  public String getExtensionCodeDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(5);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 18: 
    default: 
      return "Unknown extension code " + localInteger;
    case 16: 
      return "Thumbnail coded using JPEG";
    case 17: 
      return "Thumbnail stored using 1 byte/pixel";
    }
    return "Thumbnail stored using 3 bytes/pixel";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */