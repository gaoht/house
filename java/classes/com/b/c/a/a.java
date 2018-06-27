package com.b.c.a;

import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  private String a()
  {
    Integer localInteger = ((b)this.a).getInteger(0);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 100) {
      return "100";
    }
    return Integer.toString(localInteger.intValue());
  }
  
  private String b()
  {
    return a(3, new String[] { "Unknown (RGB or CMYK)", "YCbCr", "YCCK" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return super.getDescription(paramInt);
    case 3: 
      return b();
    }
    return a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */