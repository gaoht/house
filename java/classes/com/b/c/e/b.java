package com.b.c.e;

import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "GIF Format Version");
    e.put(Integer.valueOf(3), "Image Height");
    e.put(Integer.valueOf(2), "Image Width");
    e.put(Integer.valueOf(4), "Color Table Size");
    e.put(Integer.valueOf(5), "Is Color Table Sorted");
    e.put(Integer.valueOf(6), "Bits per Pixel");
    e.put(Integer.valueOf(7), "Has Global Color Table");
    e.put(Integer.valueOf(8), "Background Color Index");
    e.put(Integer.valueOf(9), "Pixel Aspect Ratio");
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
    return "GIF Header";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */