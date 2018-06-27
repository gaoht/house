package com.b.c.l;

import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String getColorPlanesDescription()
  {
    return a(10, 3, new String[] { "24-bit color", "16 colors" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return getVersionDescription();
    case 10: 
      return getColorPlanesDescription();
    }
    return getPaletteTypeDescription();
  }
  
  public String getPaletteTypeDescription()
  {
    return a(12, 1, new String[] { "Color or B&W", "Grayscale" });
  }
  
  public String getVersionDescription()
  {
    return a(1, new String[] { "2.5 with fixed EGA palette information", null, "2.8 with modifiable EGA palette information", "2.8 without palette information (default palette)", "PC Paintbrush for Windows", "3.0 or better" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */