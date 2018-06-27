package com.b.c.c;

import java.util.HashMap;

public class d
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    a(e);
  }
  
  public d()
  {
    setDescriptor(new c(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Exif IFD0";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */