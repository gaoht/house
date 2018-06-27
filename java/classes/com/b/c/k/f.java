package com.b.c.k;

import com.b.c.b;
import java.util.HashMap;

public class f
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(-3), "Compression Type");
    e.put(Integer.valueOf(0), "Data Precision");
    e.put(Integer.valueOf(3), "Image Width");
    e.put(Integer.valueOf(1), "Image Height");
    e.put(Integer.valueOf(5), "Number of Components");
    e.put(Integer.valueOf(6), "Component 1");
    e.put(Integer.valueOf(7), "Component 2");
    e.put(Integer.valueOf(8), "Component 3");
    e.put(Integer.valueOf(9), "Component 4");
  }
  
  public f()
  {
    setDescriptor(new e(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public d getComponent(int paramInt)
  {
    return (d)getObject(paramInt + 6);
  }
  
  public int getImageHeight()
    throws com.b.c.e
  {
    return getInt(1);
  }
  
  public int getImageWidth()
    throws com.b.c.e
  {
    return getInt(3);
  }
  
  public String getName()
  {
    return "JPEG";
  }
  
  public int getNumberOfComponents()
    throws com.b.c.e
  {
    return getInt(5);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/k/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */