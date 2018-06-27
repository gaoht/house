package com.b.c.c.a;

import com.b.c.g;

public class c
  extends g<d>
{
  public c(d paramd)
  {
    super(paramd);
  }
  
  public String getCcdSensitivityDescription()
  {
    Integer localInteger = ((d)this.a).getInteger(20);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 64: 
      return "Normal";
    case 125: 
      return "+1.0";
    case 250: 
      return "+2.0";
    case 244: 
      return "+3.0";
    case 80: 
      return "Normal (ISO 80 equivalent)";
    }
    return "High";
  }
  
  public String getContrastDescription()
  {
    return a(12, new String[] { "Normal", "Low", "High" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 9: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return getRecordingModeDescription();
    case 2: 
      return getQualityDescription();
    case 3: 
      return getFocusingModeDescription();
    case 4: 
      return getFlashModeDescription();
    case 5: 
      return getFlashIntensityDescription();
    case 6: 
      return getObjectDistanceDescription();
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
    }
    return getCcdSensitivityDescription();
  }
  
  public String getDigitalZoomDescription()
  {
    Integer localInteger = ((d)this.a).getInteger(10);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 65536: 
      return "No digital zoom";
    case 65537: 
      return "2x digital zoom";
    case 131072: 
      return "2x digital zoom";
    }
    return "4x digital zoom";
  }
  
  public String getFlashIntensityDescription()
  {
    Integer localInteger = ((d)this.a).getInteger(5);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 12: 
    case 14: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 11: 
      return "Weak";
    case 13: 
      return "Normal";
    }
    return "Strong";
  }
  
  public String getFlashModeDescription()
  {
    return a(4, 1, new String[] { "Auto", "On", "Off", "Red eye reduction" });
  }
  
  public String getFocusingModeDescription()
  {
    return a(3, 2, new String[] { "Macro", "Auto focus", "Manual focus", "Infinity" });
  }
  
  public String getObjectDistanceDescription()
  {
    Integer localInteger = ((d)this.a).getInteger(6);
    if (localInteger == null) {
      return null;
    }
    return b(localInteger.intValue());
  }
  
  public String getQualityDescription()
  {
    return a(2, 1, new String[] { "Economy", "Normal", "Fine" });
  }
  
  public String getRecordingModeDescription()
  {
    return a(1, 1, new String[] { "Single shutter", "Panorama", "Night scene", "Portrait", "Landscape" });
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
    Integer localInteger = ((d)this.a).getInteger(7);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Auto";
    case 2: 
      return "Tungsten";
    case 3: 
      return "Daylight";
    case 4: 
      return "Florescent";
    case 5: 
      return "Shade";
    }
    return "Manual";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */