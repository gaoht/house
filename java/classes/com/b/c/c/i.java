package com.b.c.c;

import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class i
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    a(e);
  }
  
  public i()
  {
    setDescriptor(new h(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public Date getDateDigitized()
  {
    return getDateDigitized(null);
  }
  
  public Date getDateDigitized(TimeZone paramTimeZone)
  {
    return getDate(36868, getString(37522), paramTimeZone);
  }
  
  public Date getDateOriginal()
  {
    return getDateOriginal(null);
  }
  
  public Date getDateOriginal(TimeZone paramTimeZone)
  {
    return getDate(36867, getString(37521), paramTimeZone);
  }
  
  public String getName()
  {
    return "Exif SubIFD";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */