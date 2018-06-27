package com.b.c.c.a;

import com.b.b.l;
import com.b.c.g;

public class o
  extends g<p>
{
  public o(p paramp)
  {
    super(paramp);
  }
  
  public String getCcdSensitivityDescription()
  {
    return a(6, new String[] { "ISO80", null, "ISO160", null, "ISO320", "ISO100" });
  }
  
  public String getColorModeDescription()
  {
    return a(4, 1, new String[] { "Color", "Monochrome" });
  }
  
  public String getConverterDescription()
  {
    return a(11, new String[] { "None", "Fisheye converter" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return super.getDescription(paramInt);
    case 3: 
      return getQualityDescription();
    case 4: 
      return getColorModeDescription();
    case 5: 
      return getImageAdjustmentDescription();
    case 6: 
      return getCcdSensitivityDescription();
    case 7: 
      return getWhiteBalanceDescription();
    case 8: 
      return getFocusDescription();
    case 10: 
      return getDigitalZoomDescription();
    }
    return getConverterDescription();
  }
  
  public String getDigitalZoomDescription()
  {
    l locall = ((p)this.a).getRational(10);
    if (locall == null) {
      return null;
    }
    if (locall.getNumerator() == 0L) {
      return "No digital zoom";
    }
    return locall.toSimpleString(true) + "x digital zoom";
  }
  
  public String getFocusDescription()
  {
    l locall = ((p)this.a).getRational(8);
    if (locall == null) {
      return null;
    }
    if ((locall.getNumerator() == 1L) && (locall.getDenominator() == 0L)) {
      return "Infinite";
    }
    return locall.toSimpleString(true);
  }
  
  public String getImageAdjustmentDescription()
  {
    return a(5, new String[] { "Normal", "Bright +", "Bright -", "Contrast +", "Contrast -" });
  }
  
  public String getQualityDescription()
  {
    return a(3, 1, new String[] { "VGA Basic", "VGA Normal", "VGA Fine", "SXGA Basic", "SXGA Normal", "SXGA Fine" });
  }
  
  public String getWhiteBalanceDescription()
  {
    return a(7, new String[] { "Auto", "Preset", "Daylight", "Incandescence", "Florescence", "Cloudy", "SpeedLight" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */