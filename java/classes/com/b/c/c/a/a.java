package com.b.c.c.a;

import com.b.c.g;
import java.text.DecimalFormat;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String getAfPointSelectedDescription()
  {
    return a(49427, 12288, new String[] { "None (MF)", "Auto selected", "Right", "Centre", "Left" });
  }
  
  public String getAfPointUsedDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49678);
    if (localInteger == null) {
      return null;
    }
    if ((localInteger.intValue() & 0x7) == 0) {
      return "Right";
    }
    if ((localInteger.intValue() & 0x7) == 1) {
      return "Centre";
    }
    if ((localInteger.intValue() & 0x7) == 2) {
      return "Left";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String getContinuousDriveModeDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49413);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      localInteger = ((b)this.a).getInteger(49410);
      if (localInteger != null)
      {
        if (localInteger.intValue() == 0) {
          return "Single shot";
        }
        return "Single shot with self-timer";
      }
      break;
    }
    return "Continuous";
  }
  
  public String getContrastDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49421);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 65535: 
      return "Low";
    case 0: 
      return "Normal";
    }
    return "High";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 12: 
      return getSerialNumberDescription();
    case 49436: 
      return getFlashActivityDescription();
    case 49426: 
      return getFocusTypeDescription();
    case 49420: 
      return getDigitalZoomDescription();
    case 49411: 
      return getQualityDescription();
    case 49409: 
      return getMacroModeDescription();
    case 49410: 
      return getSelfTimerDelayDescription();
    case 49412: 
      return getFlashModeDescription();
    case 49413: 
      return getContinuousDriveModeDescription();
    case 49415: 
      return getFocusMode1Description();
    case 49418: 
      return getImageSizeDescription();
    case 49419: 
      return getEasyShootingModeDescription();
    case 49421: 
      return getContrastDescription();
    case 49422: 
      return getSaturationDescription();
    case 49423: 
      return getSharpnessDescription();
    case 49424: 
      return getIsoDescription();
    case 49425: 
      return getMeteringModeDescription();
    case 49427: 
      return getAfPointSelectedDescription();
    case 49428: 
      return getExposureModeDescription();
    case 49430: 
      return getLensTypeDescription();
    case 49431: 
      return getLongFocalLengthDescription();
    case 49432: 
      return getShortFocalLengthDescription();
    case 49433: 
      return getFocalUnitsPerMillimetreDescription();
    case 49437: 
      return getFlashDetailsDescription();
    case 49440: 
      return getFocusMode2Description();
    case 49671: 
      return getWhiteBalanceDescription();
    case 49678: 
      return getAfPointUsedDescription();
    }
    return getFlashBiasDescription();
  }
  
  public String getDigitalZoomDescription()
  {
    return a(49420, new String[] { "No digital zoom", "2x", "4x" });
  }
  
  public String getEasyShootingModeDescription()
  {
    return a(49419, new String[] { "Full auto", "Manual", "Landscape", "Fast shutter", "Slow shutter", "Night", "B&W", "Sepia", "Portrait", "Sports", "Macro / Closeup", "Pan focus" });
  }
  
  public String getExposureModeDescription()
  {
    return a(49428, new String[] { "Easy shooting", "Program", "Tv-priority", "Av-priority", "Manual", "A-DEP" });
  }
  
  public String getFlashActivityDescription()
  {
    return a(49436, new String[] { "Flash did not fire", "Flash fired" });
  }
  
  public String getFlashBiasDescription()
  {
    Object localObject2 = ((b)this.a).getInteger(49679);
    if (localObject2 == null) {
      return null;
    }
    int i = 0;
    Object localObject1 = localObject2;
    if (((Integer)localObject2).intValue() > 61440)
    {
      i = 1;
      localObject1 = Integer.valueOf(Integer.valueOf(65535 - ((Integer)localObject2).intValue()).intValue() + 1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (i != 0) {}
    for (localObject2 = "-";; localObject2 = "") {
      return (String)localObject2 + Float.toString(((Integer)localObject1).intValue() / 32.0F) + " EV";
    }
  }
  
  public String getFlashDetailsDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49437);
    if (localInteger == null) {
      return null;
    }
    if ((localInteger.intValue() >> 14 & 0x1) > 0) {
      return "External E-TTL";
    }
    if ((localInteger.intValue() >> 13 & 0x1) > 0) {
      return "Internal flash";
    }
    if ((localInteger.intValue() >> 11 & 0x1) > 0) {
      return "FP sync used";
    }
    if ((localInteger.intValue() >> 4 & 0x1) > 0) {
      return "FP sync enabled";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String getFlashModeDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49412);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "No flash fired";
    case 1: 
      return "Auto";
    case 2: 
      return "On";
    case 3: 
      return "Red-eye reduction";
    case 4: 
      return "Slow-synchro";
    case 5: 
      return "Auto and red-eye reduction";
    case 6: 
      return "On and red-eye reduction";
    }
    return "External flash";
  }
  
  public String getFocalUnitsPerMillimetreDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49433);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() != 0) {
      return Integer.toString(localInteger.intValue());
    }
    return "";
  }
  
  public String getFocusMode1Description()
  {
    return a(49415, new String[] { "One-shot", "AI Servo", "AI Focus", "Manual Focus", "Single", "Continuous", "Manual Focus" });
  }
  
  public String getFocusMode2Description()
  {
    return a(49440, new String[] { "Single", "Continuous" });
  }
  
  public String getFocusTypeDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49426);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Manual";
    case 1: 
      return "Auto";
    case 3: 
      return "Close-up (Macro)";
    }
    return "Locked (Pan Mode)";
  }
  
  public String getImageSizeDescription()
  {
    return a(49418, new String[] { "Large", "Medium", "Small" });
  }
  
  public String getIsoDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49424);
    if (localInteger == null) {
      return null;
    }
    if ((0x4000 & localInteger.intValue()) > 0) {
      return "" + (localInteger.intValue() & 0xBFFF);
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Not specified (see ISOSpeedRatings tag)";
    case 15: 
      return "Auto";
    case 16: 
      return "50";
    case 17: 
      return "100";
    case 18: 
      return "200";
    }
    return "400";
  }
  
  public String getLensTypeDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49430);
    if (localInteger == null) {
      return null;
    }
    return "Lens type: " + Integer.toString(localInteger.intValue());
  }
  
  public String getLongFocalLengthDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49431);
    if (localInteger == null) {
      return null;
    }
    String str = getFocalUnitsPerMillimetreDescription();
    return Integer.toString(localInteger.intValue()) + " " + str;
  }
  
  public String getMacroModeDescription()
  {
    return a(49409, 1, new String[] { "Macro", "Normal" });
  }
  
  public String getMeteringModeDescription()
  {
    return a(49425, 3, new String[] { "Evaluative", "Partial", "Centre weighted" });
  }
  
  public String getQualityDescription()
  {
    return a(49411, 2, new String[] { "Normal", "Fine", null, "Superfine" });
  }
  
  public String getSaturationDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49422);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 65535: 
      return "Low";
    case 0: 
      return "Normal";
    }
    return "High";
  }
  
  public String getSelfTimerDelayDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49410);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Self timer not used";
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    return localDecimalFormat.format(localInteger.intValue() * 0.1D) + " sec";
  }
  
  public String getSerialNumberDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(12);
    if (localInteger == null) {
      return null;
    }
    return String.format("%04X%05d", new Object[] { Integer.valueOf(localInteger.intValue() >> 8 & 0xFF), Integer.valueOf(localInteger.intValue() & 0xFF) });
  }
  
  public String getSharpnessDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49423);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 65535: 
      return "Low";
    case 0: 
      return "Normal";
    }
    return "High";
  }
  
  public String getShortFocalLengthDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(49432);
    if (localInteger == null) {
      return null;
    }
    String str = getFocalUnitsPerMillimetreDescription();
    return Integer.toString(localInteger.intValue()) + " " + str;
  }
  
  public String getWhiteBalanceDescription()
  {
    return a(49671, new String[] { "Auto", "Sunny", "Cloudy", "Tungsten", "Florescent", "Flash", "Custom" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */