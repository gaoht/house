package com.b.c.b;

import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String getCompressionDescription()
  {
    for (;;)
    {
      try
      {
        Integer localInteger1 = ((b)this.a).getInteger(5);
        if (localInteger1 == null) {
          return null;
        }
        localInteger2 = ((b)this.a).getInteger(-1);
        if (localInteger2 == null) {
          return null;
        }
        switch (localInteger1.intValue())
        {
        case 3: 
          return super.getDescription(5);
        }
      }
      catch (Exception localException)
      {
        Integer localInteger2;
        return null;
      }
      if (localInteger2.intValue() != 64) {
        break;
      }
      return "Bit field";
      if (localInteger2.intValue() != 64) {
        break label135;
      }
      return "JPEG";
      return "Bit field";
    }
    return "None";
    return "RLE 8-bit/pixel";
    return "RLE 4-bit/pixel";
    return "Huffman 1D";
    label135:
    return "RLE-24";
    return "PNG";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    }
    return getCompressionDescription();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */