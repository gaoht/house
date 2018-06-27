package com.b.c.n;

import com.b.a.f.e;
import com.b.b.h;
import com.b.b.m;
import com.b.b.n;
import com.b.c.g;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class b
  extends g<c>
{
  public b(c paramc)
  {
    super(paramc);
  }
  
  public String getBackgroundColorDescription()
  {
    Object localObject2 = ((c)this.a).getByteArray(15);
    Object localObject1 = ((c)this.a).getInteger(4);
    if ((localObject2 == null) || (localObject1 == null)) {
      return null;
    }
    localObject2 = new m((byte[])localObject2);
    try
    {
      switch (((Integer)localObject1).intValue())
      {
      case 0: 
      case 4: 
        return String.format("Greyscale Level %d", new Object[] { Integer.valueOf(((n)localObject2).getUInt16()) });
      }
    }
    catch (IOException localIOException)
    {
      return null;
    }
    return String.format("R %d, G %d, B %d", new Object[] { Integer.valueOf(((n)localObject2).getUInt16()), Integer.valueOf(((n)localObject2).getUInt16()), Integer.valueOf(((n)localObject2).getUInt16()) });
    localObject1 = String.format("Palette Index %d", new Object[] { Short.valueOf(((n)localObject2).getUInt8()) });
    return (String)localObject1;
    return null;
  }
  
  public String getColorTypeDescription()
  {
    Object localObject = ((c)this.a).getInteger(4);
    if (localObject == null) {
      return null;
    }
    localObject = e.fromNumericValue(((Integer)localObject).intValue());
    if (localObject == null) {
      return null;
    }
    return ((e)localObject).getDescription();
  }
  
  public String getCompressionTypeDescription()
  {
    return a(5, new String[] { "Deflate" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 11: 
    case 12: 
    case 14: 
    case 16: 
    case 17: 
    default: 
      return super.getDescription(paramInt);
    case 4: 
      return getColorTypeDescription();
    case 5: 
      return getCompressionTypeDescription();
    case 6: 
      return getFilterMethodDescription();
    case 7: 
      return getInterlaceMethodDescription();
    case 9: 
      return getPaletteHasTransparencyDescription();
    case 10: 
      return getIsSrgbColorSpaceDescription();
    case 13: 
      return getTextualDataDescription();
    case 15: 
      return getBackgroundColorDescription();
    }
    return getUnitSpecifierDescription();
  }
  
  public String getFilterMethodDescription()
  {
    return a(6, new String[] { "Adaptive" });
  }
  
  public String getInterlaceMethodDescription()
  {
    return a(7, new String[] { "No Interlace", "Adam7 Interlace" });
  }
  
  public String getIsSrgbColorSpaceDescription()
  {
    return a(10, new String[] { "Perceptual", "Relative Colorimetric", "Saturation", "Absolute Colorimetric" });
  }
  
  public String getPaletteHasTransparencyDescription()
  {
    return a(9, new String[] { null, "Yes" });
  }
  
  public String getTextualDataDescription()
  {
    Object localObject1 = ((c)this.a).getObject(13);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = (List)localObject1;
    localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      h localh = (h)((Iterator)localObject2).next();
      if (((StringBuilder)localObject1).length() != 0) {
        ((StringBuilder)localObject1).append('\n');
      }
      ((StringBuilder)localObject1).append(String.format("%s: %s", new Object[] { localh.getKey(), localh.getValue() }));
    }
    return ((StringBuilder)localObject1).toString();
  }
  
  public String getUnitSpecifierDescription()
  {
    return a(18, new String[] { "Unspecified", "Metres" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/n/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */