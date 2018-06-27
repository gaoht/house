package com.b.c.c.a;

import com.b.b.l;
import com.b.c.g;
import java.text.DecimalFormat;

public class q
  extends g<r>
{
  public q(r paramr)
  {
    super(paramr);
  }
  
  private String h(int paramInt)
  {
    int[] arrayOfInt = ((r)this.a).getIntArray(paramInt);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    if ((arrayOfInt.length < 3) || (arrayOfInt[2] == 0)) {
      return null;
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    double d = arrayOfInt[0] * arrayOfInt[1] / arrayOfInt[2];
    return localDecimalFormat.format(d) + " EV";
  }
  
  public String getActiveDLightingDescription()
  {
    Integer localInteger = ((r)this.a).getInteger(34);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    case 1: 
      return "Light";
    case 3: 
      return "Normal";
    case 5: 
      return "High";
    case 7: 
      return "Extra High";
    }
    return "Auto";
  }
  
  public String getAutoFlashCompensationDescription()
  {
    return h(18);
  }
  
  public String getAutoFocusPositionDescription()
  {
    int[] arrayOfInt = ((r)this.a).getIntArray(136);
    if (arrayOfInt == null) {
      return null;
    }
    if ((arrayOfInt.length != 4) || (arrayOfInt[0] != 0) || (arrayOfInt[2] != 0) || (arrayOfInt[3] != 0)) {
      return "Unknown (" + ((r)this.a).getString(136) + ")";
    }
    switch (arrayOfInt[1])
    {
    default: 
      return "Unknown (" + arrayOfInt[1] + ")";
    case 0: 
      return "Centre";
    case 1: 
      return "Top";
    case 2: 
      return "Bottom";
    case 3: 
      return "Left";
    }
    return "Right";
  }
  
  public String getColorModeDescription()
  {
    String str2 = ((r)this.a).getString(141);
    String str1;
    if (str2 == null) {
      str1 = null;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.startsWith("MODE1"));
    return "Mode I (sRGB)";
  }
  
  public String getColorSpaceDescription()
  {
    return a(30, 1, new String[] { "sRGB", "Adobe RGB" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 13: 
      return getProgramShiftDescription();
    case 14: 
      return getExposureDifferenceDescription();
    case 132: 
      return getLensDescription();
    case 146: 
      return getHueAdjustmentDescription();
    case 141: 
      return getColorModeDescription();
    case 18: 
      return getAutoFlashCompensationDescription();
    case 23: 
      return getFlashExposureCompensationDescription();
    case 24: 
      return getFlashBracketCompensationDescription();
    case 28: 
      return getExposureTuningDescription();
    case 139: 
      return getLensStopsDescription();
    case 30: 
      return getColorSpaceDescription();
    case 34: 
      return getActiveDLightingDescription();
    case 42: 
      return getVignetteControlDescription();
    case 2: 
      return getIsoSettingDescription();
    case 134: 
      return getDigitalZoomDescription();
    case 135: 
      return getFlashUsedDescription();
    case 136: 
      return getAutoFocusPositionDescription();
    case 1: 
      return getFirmwareVersionDescription();
    case 131: 
      return getLensTypeDescription();
    case 137: 
      return getShootingModeDescription();
    case 147: 
      return getNEFCompressionDescription();
    case 177: 
      return getHighISONoiseReductionDescription();
    }
    return getPowerUpTimeDescription();
  }
  
  public String getDigitalZoomDescription()
  {
    l locall = ((r)this.a).getRational(134);
    if (locall == null) {
      return null;
    }
    if (locall.intValue() == 1) {
      return "No digital zoom";
    }
    return locall.toSimpleString(true) + "x digital zoom";
  }
  
  public String getExposureDifferenceDescription()
  {
    return h(14);
  }
  
  public String getExposureTuningDescription()
  {
    return h(28);
  }
  
  public String getFirmwareVersionDescription()
  {
    return a(1, 2);
  }
  
  public String getFlashBracketCompensationDescription()
  {
    return h(24);
  }
  
  public String getFlashExposureCompensationDescription()
  {
    return h(23);
  }
  
  public String getFlashUsedDescription()
  {
    return a(135, new String[] { "Flash Not Used", "Manual Flash", null, "Flash Not Ready", null, null, null, "External Flash", "Fired, Commander Mode", "Fired, TTL Mode" });
  }
  
  public String getHighISONoiseReductionDescription()
  {
    return a(177, new String[] { "Off", "Minimal", "Low", null, "Normal", null, "High" });
  }
  
  public String getHueAdjustmentDescription()
  {
    return b(146, "%s degrees");
  }
  
  public String getIsoSettingDescription()
  {
    int[] arrayOfInt = ((r)this.a).getIntArray(2);
    if (arrayOfInt == null) {
      return null;
    }
    if ((arrayOfInt[0] != 0) || (arrayOfInt[1] == 0)) {
      return "Unknown (" + ((r)this.a).getString(2) + ")";
    }
    return "ISO " + arrayOfInt[1];
  }
  
  public String getLensDescription()
  {
    return g(132);
  }
  
  public String getLensStopsDescription()
  {
    return h(139);
  }
  
  public String getLensTypeDescription()
  {
    return a(131, new Object[] { { "AF", "MF" }, "D", "G", "VR" });
  }
  
  public String getNEFCompressionDescription()
  {
    return a(147, 1, new String[] { "Lossy (Type 1)", null, "Uncompressed", null, null, null, "Lossless", "Lossy (Type 2)" });
  }
  
  public String getPowerUpTimeDescription()
  {
    return c(182);
  }
  
  public String getProgramShiftDescription()
  {
    return h(13);
  }
  
  public String getShootingModeDescription()
  {
    return a(137, new Object[] { { "Single Frame", "Continuous" }, "Delay", null, "PC Control", "Exposure Bracketing", "Auto ISO", "White-Balance Bracketing", "IR Control" });
  }
  
  public String getVignetteControlDescription()
  {
    Integer localInteger = ((r)this.a).getInteger(42);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 2: 
    case 4: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    case 1: 
      return "Low";
    case 3: 
      return "Normal";
    }
    return "High";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */