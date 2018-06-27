package com.b.c.c.a;

import com.b.b.l;

public class g
  extends com.b.c.g<h>
{
  public g(h paramh)
  {
    super(paramh);
  }
  
  private String a()
  {
    return a(0, 2);
  }
  
  public String getAutoBracketingDescription()
  {
    return a(4352, new String[] { "Off", "On", "No Flash & Flash" });
  }
  
  public String getAutoExposureWarningDescription()
  {
    return a(4866, new String[] { "AE Good", "Over Exposed" });
  }
  
  public String getBlurWarningDescription()
  {
    return a(4864, new String[] { "No Blur Warning", "Blur warning" });
  }
  
  public String getColorSaturationDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4099);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 128: 
      return "Medium High";
    case 256: 
      return "High";
    case 384: 
      return "Medium Low";
    case 512: 
      return "Low";
    case 768: 
      return "None (B&W)";
    case 769: 
      return "B&W Green Filter";
    case 770: 
      return "B&W Yellow Filter";
    case 771: 
      return "B&W Blue Filter";
    case 772: 
      return "B&W Sepia";
    }
    return "Film Simulation";
  }
  
  public String getContrastDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4102);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 256: 
      return "High";
    }
    return "Low";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 0: 
      return a();
    case 4097: 
      return getSharpnessDescription();
    case 4098: 
      return getWhiteBalanceDescription();
    case 4099: 
      return getColorSaturationDescription();
    case 4100: 
      return getToneDescription();
    case 4102: 
      return getContrastDescription();
    case 4107: 
      return getNoiseReductionDescription();
    case 4110: 
      return getHighIsoNoiseReductionDescription();
    case 4112: 
      return getFlashModeDescription();
    case 4113: 
      return getFlashExposureValueDescription();
    case 4128: 
      return getMacroDescription();
    case 4129: 
      return getFocusModeDescription();
    case 4144: 
      return getSlowSyncDescription();
    case 4145: 
      return getPictureModeDescription();
    case 4147: 
      return getExrAutoDescription();
    case 4148: 
      return getExrModeDescription();
    case 4352: 
      return getAutoBracketingDescription();
    case 4624: 
      return getFinePixColorDescription();
    case 4864: 
      return getBlurWarningDescription();
    case 4865: 
      return getFocusWarningDescription();
    case 4866: 
      return getAutoExposureWarningDescription();
    case 5120: 
      return getDynamicRangeDescription();
    case 5121: 
      return getFilmModeDescription();
    }
    return getDynamicRangeSettingDescription();
  }
  
  public String getDynamicRangeDescription()
  {
    return a(5120, 1, new String[] { "Standard", null, "Wide" });
  }
  
  public String getDynamicRangeSettingDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(5122);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto (100-400%)";
    case 1: 
      return "Manual";
    case 256: 
      return "Standard (100%)";
    case 512: 
      return "Wide 1 (230%)";
    case 513: 
      return "Wide 2 (400%)";
    }
    return "Film Simulation";
  }
  
  public String getExrAutoDescription()
  {
    return a(4147, new String[] { "Auto", "Manual" });
  }
  
  public String getExrModeDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4148);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 256: 
      return "HR (High Resolution)";
    case 512: 
      return "SN (Signal to Noise Priority)";
    }
    return "DR (Dynamic Range Priority)";
  }
  
  public String getFilmModeDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(5121);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "F0/Standard (Provia) ";
    case 256: 
      return "F1/Studio Portrait";
    case 272: 
      return "F1a/Studio Portrait Enhanced Saturation";
    case 288: 
      return "F1b/Studio Portrait Smooth Skin Tone (Astia)";
    case 304: 
      return "F1c/Studio Portrait Increased Sharpness";
    case 512: 
      return "F2/Fujichrome (Velvia)";
    case 768: 
      return "F3/Studio Portrait Ex";
    case 1024: 
      return "F4/Velvia";
    case 1280: 
      return "Pro Neg. Std";
    }
    return "Pro Neg. Hi";
  }
  
  public String getFinePixColorDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4624);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Standard";
    case 16: 
      return "Chrome";
    }
    return "B&W";
  }
  
  public String getFlashExposureValueDescription()
  {
    l locall = ((h)this.a).getRational(4113);
    if (locall == null) {
      return null;
    }
    return locall.toSimpleString(false) + " EV (Apex)";
  }
  
  public String getFlashModeDescription()
  {
    return a(4112, new String[] { "Auto", "On", "Off", "Red-eye Reduction", "External" });
  }
  
  public String getFocusModeDescription()
  {
    return a(4129, new String[] { "Auto Focus", "Manual Focus" });
  }
  
  public String getFocusWarningDescription()
  {
    return a(4865, new String[] { "Good Focus", "Out Of Focus" });
  }
  
  public String getHighIsoNoiseReductionDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4110);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 256: 
      return "Strong";
    }
    return "Weak";
  }
  
  public String getMacroDescription()
  {
    return a(4128, new String[] { "Off", "On" });
  }
  
  public String getNoiseReductionDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4107);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 64: 
      return "Low";
    case 128: 
      return "Normal";
    }
    return "N/A";
  }
  
  public String getPictureModeDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4145);
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
      return "Portrait scene";
    case 2: 
      return "Landscape scene";
    case 3: 
      return "Macro";
    case 4: 
      return "Sports scene";
    case 5: 
      return "Night scene";
    case 6: 
      return "Program AE";
    case 7: 
      return "Natural Light";
    case 8: 
      return "Anti-blur";
    case 9: 
      return "Beach & Snow";
    case 10: 
      return "Sunset";
    case 11: 
      return "Museum";
    case 12: 
      return "Party";
    case 13: 
      return "Flower";
    case 14: 
      return "Text";
    case 15: 
      return "Natural Light & Flash";
    case 16: 
      return "Beach";
    case 17: 
      return "Snow";
    case 18: 
      return "Fireworks";
    case 19: 
      return "Underwater";
    case 20: 
      return "Portrait with Skin Correction";
    case 22: 
      return "Panorama";
    case 23: 
      return "Night (Tripod)";
    case 24: 
      return "Pro Low-light";
    case 25: 
      return "Pro Focus";
    case 27: 
      return "Dog Face Detection";
    case 28: 
      return "Cat Face Detection";
    case 256: 
      return "Aperture priority AE";
    case 512: 
      return "Shutter priority AE";
    }
    return "Manual exposure";
  }
  
  public String getSharpnessDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4097);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Softest";
    case 2: 
      return "Soft";
    case 3: 
      return "Normal";
    case 4: 
      return "Hard";
    case 5: 
      return "Hardest";
    case 130: 
      return "Medium Soft";
    case 132: 
      return "Medium Hard";
    case 32768: 
      return "Film Simulation";
    }
    return "N/A";
  }
  
  public String getSlowSyncDescription()
  {
    return a(4144, new String[] { "Off", "On" });
  }
  
  public String getToneDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4100);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 128: 
      return "Medium High";
    case 256: 
      return "High";
    case 384: 
      return "Medium Low";
    case 512: 
      return "Low";
    case 768: 
      return "None (B&W)";
    }
    return "Film Simulation";
  }
  
  public String getWhiteBalanceDescription()
  {
    Integer localInteger = ((h)this.a).getInteger(4098);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto";
    case 256: 
      return "Daylight";
    case 512: 
      return "Cloudy";
    case 768: 
      return "Daylight Fluorescent";
    case 769: 
      return "Day White Fluorescent";
    case 770: 
      return "White Fluorescent";
    case 771: 
      return "Warm White Fluorescent";
    case 772: 
      return "Living Room Warm White Fluorescent";
    case 1024: 
      return "Incandescence";
    case 1280: 
      return "Flash";
    case 3840: 
      return "Custom White Balance";
    case 3841: 
      return "Custom White Balance 2";
    case 3842: 
      return "Custom White Balance 3";
    case 3843: 
      return "Custom White Balance 4";
    case 3844: 
      return "Custom White Balance 5";
    }
    return "Kelvin";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */