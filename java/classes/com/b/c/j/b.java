package com.b.c.j;

import com.b.c.e;
import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(5), "Extension Code");
  }
  
  public b()
  {
    setDescriptor(new a(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public int getExtensionCode()
    throws e
  {
    return getInt(5);
  }
  
  public String getName()
  {
    return "JFXX";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */