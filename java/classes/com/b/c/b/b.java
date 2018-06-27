package com.b.c.b;

import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(-1), "Header Size");
    e.put(Integer.valueOf(1), "Image Height");
    e.put(Integer.valueOf(2), "Image Width");
    e.put(Integer.valueOf(3), "Planes");
    e.put(Integer.valueOf(4), "Bits Per Pixel");
    e.put(Integer.valueOf(5), "Compression");
    e.put(Integer.valueOf(6), "X Pixels per Meter");
    e.put(Integer.valueOf(7), "Y Pixels per Meter");
    e.put(Integer.valueOf(8), "Palette Colour Count");
    e.put(Integer.valueOf(9), "Important Colour Count");
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
    return "BMP Header";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */