package com.b.c.n;

import com.b.c.b;
import com.b.c.g;
import java.util.HashMap;

public class a
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "White Point X");
    e.put(Integer.valueOf(2), "White Point Y");
    e.put(Integer.valueOf(3), "Red X");
    e.put(Integer.valueOf(4), "Red Y");
    e.put(Integer.valueOf(5), "Green X");
    e.put(Integer.valueOf(6), "Green Y");
    e.put(Integer.valueOf(7), "Blue X");
    e.put(Integer.valueOf(8), "Blue Y");
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
    return "PNG Chromaticities";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */