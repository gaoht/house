package com.b.c.n;

import com.b.a.f.d;
import java.util.HashMap;

public class c
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  private final d f;
  
  static
  {
    e.put(Integer.valueOf(2), "Image Height");
    e.put(Integer.valueOf(1), "Image Width");
    e.put(Integer.valueOf(3), "Bits Per Sample");
    e.put(Integer.valueOf(4), "Color Type");
    e.put(Integer.valueOf(5), "Compression Type");
    e.put(Integer.valueOf(6), "Filter Method");
    e.put(Integer.valueOf(7), "Interlace Method");
    e.put(Integer.valueOf(8), "Palette Size");
    e.put(Integer.valueOf(9), "Palette Has Transparency");
    e.put(Integer.valueOf(10), "sRGB Rendering Intent");
    e.put(Integer.valueOf(11), "Image Gamma");
    e.put(Integer.valueOf(12), "ICC Profile Name");
    e.put(Integer.valueOf(13), "Textual Data");
    e.put(Integer.valueOf(14), "Last Modification Time");
    e.put(Integer.valueOf(15), "Background Color");
    e.put(Integer.valueOf(16), "Pixels Per Unit X");
    e.put(Integer.valueOf(17), "Pixels Per Unit Y");
    e.put(Integer.valueOf(18), "Unit Specifier");
    e.put(Integer.valueOf(19), "Significant Bits");
  }
  
  public c(d paramd)
  {
    this.f = paramd;
    setDescriptor(new b(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "PNG-" + this.f.getIdentifier();
  }
  
  public d getPngChunkType()
  {
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/n/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */