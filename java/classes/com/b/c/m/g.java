package com.b.c.m;

import com.b.c.b;
import java.util.HashMap;

public class g
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Channel Count");
    e.put(Integer.valueOf(2), "Image Height");
    e.put(Integer.valueOf(3), "Image Width");
    e.put(Integer.valueOf(4), "Bits Per Channel");
    e.put(Integer.valueOf(5), "Color Mode");
  }
  
  public g()
  {
    setDescriptor(new f(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "PSD Header";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/m/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */