package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class ah
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(2), "Serial Number");
    e.put(Integer.valueOf(3), "Drive Mode");
    e.put(Integer.valueOf(4), "Resolution Mode");
    e.put(Integer.valueOf(5), "Auto Focus Mode");
    e.put(Integer.valueOf(6), "Focus Setting");
    e.put(Integer.valueOf(7), "White Balance");
    e.put(Integer.valueOf(8), "Exposure Mode");
    e.put(Integer.valueOf(9), "Metering Mode");
    e.put(Integer.valueOf(10), "Lens Range");
    e.put(Integer.valueOf(11), "Color Space");
    e.put(Integer.valueOf(12), "Exposure");
    e.put(Integer.valueOf(13), "Contrast");
    e.put(Integer.valueOf(14), "Shadow");
    e.put(Integer.valueOf(15), "Highlight");
    e.put(Integer.valueOf(16), "Saturation");
    e.put(Integer.valueOf(17), "Sharpness");
    e.put(Integer.valueOf(18), "Fill Light");
    e.put(Integer.valueOf(20), "Color Adjustment");
    e.put(Integer.valueOf(21), "Adjustment Mode");
    e.put(Integer.valueOf(22), "Quality");
    e.put(Integer.valueOf(23), "Firmware");
    e.put(Integer.valueOf(24), "Software");
    e.put(Integer.valueOf(25), "Auto Bracket");
  }
  
  public ah()
  {
    setDescriptor(new ag(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Sigma Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */