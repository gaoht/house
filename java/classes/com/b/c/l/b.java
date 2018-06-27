package com.b.c.l;

import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Version");
    e.put(Integer.valueOf(2), "Bits Per Pixel");
    e.put(Integer.valueOf(3), "X Min");
    e.put(Integer.valueOf(4), "Y Min");
    e.put(Integer.valueOf(5), "X Max");
    e.put(Integer.valueOf(6), "Y Max");
    e.put(Integer.valueOf(7), "Horizontal DPI");
    e.put(Integer.valueOf(8), "Vertical DPI");
    e.put(Integer.valueOf(9), "Palette");
    e.put(Integer.valueOf(10), "Color Planes");
    e.put(Integer.valueOf(11), "Bytes Per Line");
    e.put(Integer.valueOf(12), "Palette Type");
    e.put(Integer.valueOf(13), "H Scr Size");
    e.put(Integer.valueOf(14), "V Scr Size");
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
    return "PCX";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/l/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */