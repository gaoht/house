package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class ad
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Makernote Data Type");
    e.put(Integer.valueOf(2), "Version");
    e.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    e.put(Integer.valueOf(8193), "Ricoh Camera Info Makernote Sub-IFD");
  }
  
  public ad()
  {
    setDescriptor(new ac(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Ricoh Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */