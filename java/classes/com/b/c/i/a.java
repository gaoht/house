package com.b.c.i;

import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 9: 
    default: 
      return super.getDescription(paramInt);
    case 8: 
      return getImageResXDescription();
    case 10: 
      return getImageResYDescription();
    case 5: 
      return getImageVersionDescription();
    }
    return getImageResUnitsDescription();
  }
  
  public String getImageResUnitsDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(7);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "unit";
    case 0: 
      return "none";
    case 1: 
      return "inch";
    }
    return "centimetre";
  }
  
  public String getImageResXDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(8);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 1) {}
    for (String str = "";; str = "s") {
      return String.format("%d dot%s", new Object[] { localInteger, str });
    }
  }
  
  public String getImageResYDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(10);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 1) {}
    for (String str = "";; str = "s") {
      return String.format("%d dot%s", new Object[] { localInteger, str });
    }
  }
  
  public String getImageVersionDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(5);
    if (localInteger == null) {
      return null;
    }
    return String.format("%d.%d", new Object[] { Integer.valueOf((localInteger.intValue() & 0xFF00) >> 8), Integer.valueOf(localInteger.intValue() & 0xFF) });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */