package com.b.c.c.a;

import com.b.c.g;

public class i
  extends g<j>
{
  public i(j paramj)
  {
    super(paramj);
  }
  
  public String getBurstModeDescription()
  {
    return a(10, new String[] { "Off", "On" });
  }
  
  public String getColorModeDescription()
  {
    Integer localInteger = ((j)this.a).getInteger(102);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
    case 8192: 
      return "B&W";
    case 2: 
    case 16384: 
      return "Sepia";
    case 3: 
      return "B&W Yellow Filter";
    case 4: 
      return "B&W Red Filter";
    case 32: 
      return "Saturated Color";
    case 64: 
    case 512: 
      return "Neutral Color";
    }
    return "Saturated Color";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 9: 
      return getQualityDescription();
    case 10: 
      return getBurstModeDescription();
    case 27: 
      return getShutterModeDescription();
    case 56: 
      return getFocusModeDescription();
    case 64: 
      return getWhiteBalanceDescription();
    case 92: 
      return getFlashModeDescription();
    case 93: 
      return getFlashFiredDescription();
    case 102: 
      return getColorModeDescription();
    }
    return getSharpnessDescription();
  }
  
  public String getFlashFiredDescription()
  {
    return a(93, new String[] { "No", "Yes" });
  }
  
  public String getFlashModeDescription()
  {
    Integer localInteger = ((j)this.a).getInteger(92);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto";
    case 1: 
    case 16: 
      return "Fill Flash";
    case 2: 
    case 32: 
      return "Off";
    }
    return "Red Eye";
  }
  
  public String getFocusModeDescription()
  {
    return a(56, new String[] { "Normal", null, "Macro" });
  }
  
  public String getQualityDescription()
  {
    return a(9, 1, new String[] { "Fine", "Normal" });
  }
  
  public String getSharpnessDescription()
  {
    return a(107, new String[] { "Normal" });
  }
  
  public String getShutterModeDescription()
  {
    Integer localInteger = ((j)this.a).getInteger(27);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto";
    case 8: 
      return "Aperture Priority";
    }
    return "Manual";
  }
  
  public String getWhiteBalanceDescription()
  {
    return a(64, new String[] { "Auto", "Flash", "Tungsten", "Daylight" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */