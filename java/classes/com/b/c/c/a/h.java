package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class h
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(0), "Makernote Version");
    e.put(Integer.valueOf(16), "Serial Number");
    e.put(Integer.valueOf(4096), "Quality");
    e.put(Integer.valueOf(4097), "Sharpness");
    e.put(Integer.valueOf(4098), "White Balance");
    e.put(Integer.valueOf(4099), "Color Saturation");
    e.put(Integer.valueOf(4100), "Tone (Contrast)");
    e.put(Integer.valueOf(4101), "Color Temperature");
    e.put(Integer.valueOf(4102), "Contrast");
    e.put(Integer.valueOf(4106), "White Balance Fine Tune");
    e.put(Integer.valueOf(4107), "Noise Reduction");
    e.put(Integer.valueOf(4110), "High ISO Noise Reduction");
    e.put(Integer.valueOf(4112), "Flash Mode");
    e.put(Integer.valueOf(4113), "Flash Strength");
    e.put(Integer.valueOf(4128), "Macro");
    e.put(Integer.valueOf(4129), "Focus Mode");
    e.put(Integer.valueOf(4131), "Focus Pixel");
    e.put(Integer.valueOf(4144), "Slow Sync");
    e.put(Integer.valueOf(4145), "Picture Mode");
    e.put(Integer.valueOf(4147), "EXR Auto");
    e.put(Integer.valueOf(4148), "EXR Mode");
    e.put(Integer.valueOf(4352), "Auto Bracketing");
    e.put(Integer.valueOf(4353), "Sequence Number");
    e.put(Integer.valueOf(4624), "FinePix Color Setting");
    e.put(Integer.valueOf(4864), "Blur Warning");
    e.put(Integer.valueOf(4865), "Focus Warning");
    e.put(Integer.valueOf(4866), "AE Warning");
    e.put(Integer.valueOf(4868), "GE Image Size");
    e.put(Integer.valueOf(5120), "Dynamic Range");
    e.put(Integer.valueOf(5121), "Film Mode");
    e.put(Integer.valueOf(5122), "Dynamic Range Setting");
    e.put(Integer.valueOf(5123), "Development Dynamic Range");
    e.put(Integer.valueOf(5124), "Minimum Focal Length");
    e.put(Integer.valueOf(5125), "Maximum Focal Length");
    e.put(Integer.valueOf(5126), "Maximum Aperture at Minimum Focal Length");
    e.put(Integer.valueOf(5127), "Maximum Aperture at Maximum Focal Length");
    e.put(Integer.valueOf(5131), "Auto Dynamic Range");
    e.put(Integer.valueOf(16640), "Faces Detected");
    e.put(Integer.valueOf(16643), "Face Positions");
    e.put(Integer.valueOf(17026), "Face Detection Data");
    e.put(Integer.valueOf(32768), "File Source");
    e.put(Integer.valueOf(32770), "Order Number");
    e.put(Integer.valueOf(32771), "Frame Number");
    e.put(Integer.valueOf(45585), "Parallax");
  }
  
  public h()
  {
    setDescriptor(new g(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Fujifilm Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */