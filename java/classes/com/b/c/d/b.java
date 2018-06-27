package com.b.c.d;

import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "File Name");
    e.put(Integer.valueOf(2), "File Size");
    e.put(Integer.valueOf(3), "File Modified Date");
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
    return "File";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */