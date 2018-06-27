package com.b.c.i;

import com.b.c.e;
import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(5), "Version");
    e.put(Integer.valueOf(7), "Resolution Units");
    e.put(Integer.valueOf(10), "Y Resolution");
    e.put(Integer.valueOf(8), "X Resolution");
    e.put(Integer.valueOf(12), "Thumbnail Width Pixels");
    e.put(Integer.valueOf(13), "Thumbnail Height Pixels");
  }
  
  public b()
  {
    setDescriptor(new a(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  @Deprecated
  public int getImageHeight()
    throws e
  {
    return getInt(8);
  }
  
  @Deprecated
  public int getImageWidth()
    throws e
  {
    return getInt(10);
  }
  
  public String getName()
  {
    return "JFIF";
  }
  
  public int getResUnits()
    throws e
  {
    return getInt(7);
  }
  
  public int getResX()
    throws e
  {
    return getInt(8);
  }
  
  public int getResY()
    throws e
  {
    return getInt(10);
  }
  
  public int getVersion()
    throws e
  {
    return getInt(5);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */