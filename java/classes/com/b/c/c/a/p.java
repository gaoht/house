package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class p
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(6), "CCD Sensitivity");
    e.put(Integer.valueOf(4), "Color Mode");
    e.put(Integer.valueOf(10), "Digital Zoom");
    e.put(Integer.valueOf(11), "Fisheye Converter");
    e.put(Integer.valueOf(8), "Focus");
    e.put(Integer.valueOf(5), "Image Adjustment");
    e.put(Integer.valueOf(3), "Quality");
    e.put(Integer.valueOf(2), "Makernote Unknown 1");
    e.put(Integer.valueOf(9), "Makernote Unknown 2");
    e.put(Integer.valueOf(3840), "Makernote Unknown 3");
    e.put(Integer.valueOf(7), "White Balance");
  }
  
  public p()
  {
    setDescriptor(new o(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Nikon Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */