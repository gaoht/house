package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class al
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1299), "Makernote Thumb Offset");
    e.put(Integer.valueOf(1300), "Makernote Thumb Length");
    e.put(Integer.valueOf(8192), "Makernote Thumb Version");
  }
  
  public al()
  {
    setDescriptor(new ak(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Sony Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */