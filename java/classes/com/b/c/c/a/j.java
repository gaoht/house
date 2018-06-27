package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class j
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(0), "Kodak Model");
    e.put(Integer.valueOf(9), "Quality");
    e.put(Integer.valueOf(10), "Burst Mode");
    e.put(Integer.valueOf(12), "Image Width");
    e.put(Integer.valueOf(14), "Image Height");
    e.put(Integer.valueOf(16), "Year Created");
    e.put(Integer.valueOf(18), "Month/Day Created");
    e.put(Integer.valueOf(20), "Time Created");
    e.put(Integer.valueOf(24), "Burst Mode 2");
    e.put(Integer.valueOf(27), "Shutter Speed");
    e.put(Integer.valueOf(28), "Metering Mode");
    e.put(Integer.valueOf(29), "Sequence Number");
    e.put(Integer.valueOf(30), "F Number");
    e.put(Integer.valueOf(32), "Exposure Time");
    e.put(Integer.valueOf(36), "Exposure Compensation");
    e.put(Integer.valueOf(56), "Focus Mode");
    e.put(Integer.valueOf(64), "White Balance");
    e.put(Integer.valueOf(92), "Flash Mode");
    e.put(Integer.valueOf(93), "Flash Fired");
    e.put(Integer.valueOf(94), "ISO Setting");
    e.put(Integer.valueOf(96), "ISO");
    e.put(Integer.valueOf(98), "Total Zoom");
    e.put(Integer.valueOf(100), "Date/Time Stamp");
    e.put(Integer.valueOf(102), "Color Mode");
    e.put(Integer.valueOf(104), "Digital Zoom");
    e.put(Integer.valueOf(107), "Sharpness");
  }
  
  public j()
  {
    setDescriptor(new i(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Kodak Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */