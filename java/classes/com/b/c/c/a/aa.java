package com.b.c.c.a;

import com.b.c.g;

public class aa
  extends g<ab>
{
  public aa(ab paramab)
  {
    super(paramab);
  }
  
  public String getCaptureModeDescription()
  {
    return a(1, new String[] { "Auto", "Night-scene", "Manual", null, "Multiple" });
  }
  
  public String getColourDescription()
  {
    return a(23, 1, new String[] { "Normal", "Black & White", "Sepia" });
  }
  
  public String getContrastDescription()
  {
    return a(12, new String[] { "Normal", "Low", "High" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 21: 
    case 22: 
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return getCaptureModeDescription();
    case 2: 
      return getQualityLevelDescription();
    case 3: 
      return getFocusModeDescription();
    case 4: 
      return getFlashModeDescription();
    case 7: 
      return getWhiteBalanceDescription();
    case 10: 
      return getDigitalZoomDescription();
    case 11: 
      return getSharpnessDescription();
    case 12: 
      return getContrastDescription();
    case 13: 
      return getSaturationDescription();
    case 20: 
      return getIsoSpeedDescription();
    }
    return getColourDescription();
  }
  
  public String getDigitalZoomDescription()
  {
    Float localFloat = ((ab)this.a).getFloatObject(10);
    if (localFloat == null) {
      return null;
    }
    if (localFloat.floatValue() == 0.0F) {
      return "Off";
    }
    return Float.toString(localFloat.floatValue());
  }
  
  public String getFlashModeDescription()
  {
    return a(4, 1, new String[] { "Auto", "Flash On", null, "Flash Off", null, "Red-eye Reduction" });
  }
  
  public String getFocusModeDescription()
  {
    return a(3, 2, new String[] { "Custom", "Auto" });
  }
  
  public String getIsoSpeedDescription()
  {
    Integer localInteger = ((ab)this.a).getInteger(20);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 10: 
      return "ISO 100";
    case 16: 
      return "ISO 200";
    case 100: 
      return "ISO 100";
    }
    return "ISO 200";
  }
  
  public String getQualityLevelDescription()
  {
    return a(2, new String[] { "Good", "Better", "Best" });
  }
  
  public String getSaturationDescription()
  {
    return a(13, new String[] { "Normal", "Low", "High" });
  }
  
  public String getSharpnessDescription()
  {
    return a(11, new String[] { "Normal", "Soft", "Hard" });
  }
  
  public String getWhiteBalanceDescription()
  {
    return a(7, new String[] { "Auto", "Daylight", "Shade", "Tungsten", "Fluorescent", "Manual" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */