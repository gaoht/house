package com.b.c.c.a;

import com.b.c.g;

public class ag
  extends g<ah>
{
  public ag(ah paramah)
  {
    super(paramah);
  }
  
  private String a()
  {
    String str = ((ah)this.a).getString(9);
    if ((str == null) || (str.length() == 0)) {
      return null;
    }
    switch (str.charAt(0))
    {
    default: 
      return str;
    case '8': 
      return "Multi Segment";
    case 'A': 
      return "Average";
    }
    return "Center Weighted Average";
  }
  
  private String b()
  {
    String str = ((ah)this.a).getString(8);
    if ((str == null) || (str.length() == 0)) {
      return null;
    }
    switch (str.charAt(0))
    {
    default: 
      return str;
    case 'A': 
      return "Aperture Priority AE";
    case 'M': 
      return "Manual";
    case 'P': 
      return "Program AE";
    }
    return "Shutter Speed Priority AE";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 8: 
      return b();
    }
    return a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */