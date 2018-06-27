package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class f
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(2), "Thumbnail Dimensions");
    e.put(Integer.valueOf(3), "Thumbnail Size");
    e.put(Integer.valueOf(4), "Thumbnail Offset");
    e.put(Integer.valueOf(8), "Quality Mode");
    e.put(Integer.valueOf(9), "Image Size");
    e.put(Integer.valueOf(13), "Focus Mode");
    e.put(Integer.valueOf(20), "ISO Sensitivity");
    e.put(Integer.valueOf(25), "White Balance");
    e.put(Integer.valueOf(29), "Focal Length");
    e.put(Integer.valueOf(31), "Saturation");
    e.put(Integer.valueOf(32), "Contrast");
    e.put(Integer.valueOf(33), "Sharpness");
    e.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    e.put(Integer.valueOf(8192), "Casio Preview Thumbnail");
    e.put(Integer.valueOf(8209), "White Balance Bias");
    e.put(Integer.valueOf(8210), "White Balance");
    e.put(Integer.valueOf(8226), "Object Distance");
    e.put(Integer.valueOf(8244), "Flash Distance");
    e.put(Integer.valueOf(12288), "Record Mode");
    e.put(Integer.valueOf(12289), "Self Timer");
    e.put(Integer.valueOf(12290), "Quality");
    e.put(Integer.valueOf(12291), "Focus Mode");
    e.put(Integer.valueOf(12294), "Time Zone");
    e.put(Integer.valueOf(12295), "BestShot Mode");
    e.put(Integer.valueOf(12308), "CCD ISO Sensitivity");
    e.put(Integer.valueOf(12309), "Colour Mode");
    e.put(Integer.valueOf(12310), "Enhancement");
    e.put(Integer.valueOf(12311), "Filter");
  }
  
  public f()
  {
    setDescriptor(new e(this));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */