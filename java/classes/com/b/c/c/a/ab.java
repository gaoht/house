package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class ab
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Capture Mode");
    e.put(Integer.valueOf(2), "Quality Level");
    e.put(Integer.valueOf(3), "Focus Mode");
    e.put(Integer.valueOf(4), "Flash Mode");
    e.put(Integer.valueOf(7), "White Balance");
    e.put(Integer.valueOf(10), "Digital Zoom");
    e.put(Integer.valueOf(11), "Sharpness");
    e.put(Integer.valueOf(12), "Contrast");
    e.put(Integer.valueOf(13), "Saturation");
    e.put(Integer.valueOf(20), "ISO Speed");
    e.put(Integer.valueOf(23), "Colour");
    e.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    e.put(Integer.valueOf(4096), "Time Zone");
    e.put(Integer.valueOf(4097), "Daylight Savings");
  }
  
  public ab()
  {
    setDescriptor(new aa(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Pentax Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */