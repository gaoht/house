package com.b.c.g;

import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Image Type");
    e.put(Integer.valueOf(2), "Image Width");
    e.put(Integer.valueOf(3), "Image Height");
    e.put(Integer.valueOf(4), "Colour Palette Size");
    e.put(Integer.valueOf(5), "Colour Planes");
    e.put(Integer.valueOf(6), "Hotspot X");
    e.put(Integer.valueOf(7), "Bits Per Pixel");
    e.put(Integer.valueOf(8), "Hotspot Y");
    e.put(Integer.valueOf(9), "Image Size Bytes");
    e.put(Integer.valueOf(10), "Image Offset Bytes");
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
    return "ICO";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */