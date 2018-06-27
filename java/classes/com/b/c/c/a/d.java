package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class d
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(20), "CCD Sensitivity");
    e.put(Integer.valueOf(12), "Contrast");
    e.put(Integer.valueOf(10), "Digital Zoom");
    e.put(Integer.valueOf(5), "Flash Intensity");
    e.put(Integer.valueOf(4), "Flash Mode");
    e.put(Integer.valueOf(3), "Focusing Mode");
    e.put(Integer.valueOf(6), "Object Distance");
    e.put(Integer.valueOf(2), "Quality");
    e.put(Integer.valueOf(1), "Recording Mode");
    e.put(Integer.valueOf(13), "Saturation");
    e.put(Integer.valueOf(11), "Sharpness");
    e.put(Integer.valueOf(8), "Makernote Unknown 1");
    e.put(Integer.valueOf(9), "Makernote Unknown 2");
    e.put(Integer.valueOf(14), "Makernote Unknown 3");
    e.put(Integer.valueOf(15), "Makernote Unknown 4");
    e.put(Integer.valueOf(16), "Makernote Unknown 5");
    e.put(Integer.valueOf(17), "Makernote Unknown 6");
    e.put(Integer.valueOf(18), "Makernote Unknown 7");
    e.put(Integer.valueOf(19), "Makernote Unknown 8");
    e.put(Integer.valueOf(7), "White Balance");
  }
  
  public d()
  {
    setDescriptor(new c(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Casio Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */