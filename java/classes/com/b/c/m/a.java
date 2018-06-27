package com.b.c.m;

import com.b.c.b;
import com.b.c.g;
import java.util.HashMap;

public class a
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Quality");
    e.put(Integer.valueOf(2), "Comment");
    e.put(Integer.valueOf(3), "Copyright");
  }
  
  public a()
  {
    setDescriptor(new g(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Ducky";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */