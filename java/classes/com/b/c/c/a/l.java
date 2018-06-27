package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class l
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Proprietary Thumbnail Format Data");
    e.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
  }
  
  public l()
  {
    setDescriptor(new k(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Kyocera/Contax Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */