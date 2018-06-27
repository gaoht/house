package com.b.c.a;

import java.util.HashMap;

public class b
  extends com.b.c.b
{
  private static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(0), "DCT Encode Version");
    e.put(Integer.valueOf(1), "Flags 0");
    e.put(Integer.valueOf(2), "Flags 1");
    e.put(Integer.valueOf(3), "Color Transform");
  }
  
  public b()
  {
    setDescriptor(new a(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Adobe JPEG";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */