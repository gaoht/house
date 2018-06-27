package com.b.c.p;

import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Image Height");
    e.put(Integer.valueOf(2), "Image Width");
    e.put(Integer.valueOf(3), "Has Alpha");
    e.put(Integer.valueOf(4), "Is Animation");
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
    return "WebP";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/p/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */