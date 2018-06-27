package com.b.c.c.a;

import com.b.c.g;

public class ai
  extends g<aj>
{
  public ai(aj paramaj)
  {
    super(paramaj);
  }
  
  public String getAFIlluminatorDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45124);
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
      return "Auto";
    }
    return "n/a";
  }
  
  public String getAFModeDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45123);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Default";
    case 1: 
      return "Multi";
    case 2: 
      return "Center";
    case 3: 
      return "Spot";
    case 4: 
      return "Flexible Spot";
    case 6: 
      return "Touch";
    case 14: 
      return "Manual Focus";
    case 15: 
      return "Face Detected";
    }
    return "n/a";
  }
  
  public String getAFPointSelectedDescription()
  {
    return a(8222, new String[] { "Auto", "Center", "Top", "Upper-right", "Right", "Lower-right", "Bottom", "Lower-left", "Left", "Upper-left\t  \t", "Far Right", "Far Left", "Upper-middle", "Near Right", "Lower-middle", "Near Left", "Upper Far Right", "Lower Far Right", "Lower Far Left", "Upper Far Left" });
  }
  
  public String getAntiBlurDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45131);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "On (Continuous)";
    case 2: 
      return "On (Shooting)";
    }
    return "N/A";
  }
  
  public String getAutoPortraitFramedDescription()
  {
    return a(8214, new String[] { "No", "Yes" });
  }
  
  public String getColorModeDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45097);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Standard";
    case 1: 
      return "Vivid";
    case 2: 
      return "Portrait";
    case 3: 
      return "Landscape";
    case 4: 
      return "Sunset";
    case 5: 
      return "Night Portrait";
    case 6: 
      return "Black & White";
    case 7: 
      return "Adobe RGB";
    case 12: 
    case 100: 
      return "Neutral";
    case 13: 
    case 101: 
      return "Clear";
    case 14: 
    case 102: 
      return "Deep";
    case 15: 
    case 103: 
      return "Light";
    case 16: 
      return "Autumn";
    case 17: 
      return "Sepia";
    case 104: 
      return "Night View";
    }
    return "Autumn Leaves";
  }
  
  public String getColorTemperatureDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45089);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Auto";
    }
    int i = localInteger.intValue();
    return String.format("%d K", new Object[] { Integer.valueOf((localInteger.intValue() & 0xFF000000) >> 24 | (i & 0xFF0000) >> 8) });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 258: 
      return getImageQualityDescription();
    case 260: 
      return getFlashExposureCompensationDescription();
    case 261: 
      return getTeleconverterDescription();
    case 277: 
      return getWhiteBalanceDescription();
    case 45089: 
      return getColorTemperatureDescription();
    case 45091: 
      return getSceneModeDescription();
    case 45092: 
      return getZoneMatchingDescription();
    case 45093: 
      return getDynamicRangeOptimizerDescription();
    case 45094: 
      return getImageStabilizationDescription();
    case 45097: 
      return getColorModeDescription();
    case 45120: 
      return getMacroDescription();
    case 45121: 
      return getExposureModeDescription();
    case 45127: 
      return getJpegQualityDescription();
    case 45131: 
      return getAntiBlurDescription();
    case 45134: 
      return getLongExposureNoiseReductionDescription();
    case 8201: 
      return getHighIsoNoiseReductionDescription();
    case 8206: 
      return getPictureEffectDescription();
    case 8207: 
      return getSoftSkinEffectDescription();
    case 8209: 
      return getVignettingCorrectionDescription();
    case 8210: 
      return getLateralChromaticAberrationDescription();
    case 8211: 
      return getDistortionCorrectionDescription();
    case 8214: 
      return getAutoPortraitFramedDescription();
    case 8219: 
      return getFocusModeDescription();
    case 8222: 
      return getAFPointSelectedDescription();
    case 45057: 
      return getSonyModelIdDescription();
    case 45123: 
      return getAFModeDescription();
    case 45124: 
      return getAFIlluminatorDescription();
    case 45128: 
      return getFlashLevelDescription();
    case 45129: 
      return getReleaseModeDescription();
    }
    return getSequenceNumberDescription();
  }
  
  public String getDistortionCorrectionDescription()
  {
    return a(8211, new String[] { "Off", null, "Auto" });
  }
  
  public String getDynamicRangeOptimizerDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45093);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "Standard";
    case 2: 
      return "Advanced Auto";
    case 3: 
      return "Auto";
    case 8: 
      return "Advanced LV1";
    case 9: 
      return "Advanced LV2";
    case 10: 
      return "Advanced LV3";
    case 11: 
      return "Advanced LV4";
    case 12: 
      return "Advanced LV5";
    case 16: 
      return "LV1";
    case 17: 
      return "LV2";
    case 18: 
      return "LV3";
    case 19: 
      return "LV4";
    }
    return "LV5";
  }
  
  public String getExposureModeDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45121);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Program";
    case 1: 
      return "Portrait";
    case 2: 
      return "Beach";
    case 3: 
      return "Sports";
    case 4: 
      return "Snow";
    case 5: 
      return "Landscape";
    case 6: 
      return "Auto";
    case 7: 
      return "Aperture Priority";
    case 8: 
      return "Shutter Priority";
    case 9: 
      return "Night Scene / Twilight";
    case 10: 
      return "Hi-Speed Shutter";
    case 11: 
      return "Twilight Portrait";
    case 12: 
      return "Soft Snap/Portrait";
    case 13: 
      return "Fireworks";
    case 14: 
      return "Smile Shutter";
    case 15: 
      return "Manual";
    case 18: 
      return "High Sensitivity";
    case 19: 
      return "Macro";
    case 20: 
      return "Advanced Sports Shooting";
    case 29: 
      return "Underwater";
    case 33: 
      return "Food";
    case 34: 
      return "Panorama";
    case 35: 
      return "Handheld Night Shot";
    case 36: 
      return "Anti Motion Blur";
    case 37: 
      return "Pet";
    case 38: 
      return "Backlight Correction HDR";
    case 39: 
      return "Superior Auto";
    case 40: 
      return "Background Defocus";
    case 41: 
      return "Soft Skin";
    case 42: 
      return "3D Image";
    }
    return "N/A";
  }
  
  public String getFlashExposureCompensationDescription()
  {
    return a(260, "%d EV");
  }
  
  public String getFlashLevelDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45128);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case -32768: 
      return "Low";
    case -3: 
      return "-3/3";
    case -2: 
      return "-2/3";
    case -1: 
      return "-1/3";
    case 0: 
      return "Normal";
    case 1: 
      return "+1/3";
    case 2: 
      return "+2/3";
    case 3: 
      return "+3/3";
    case 128: 
      return "n/a";
    }
    return "High";
  }
  
  public String getFocusModeDescription()
  {
    return a(8219, new String[] { "Manual", null, "AF-A", "AF-C", "AF-S", null, "DMF", "AF-D" });
  }
  
  public String getHighIsoNoiseReductionDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(8201);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "On";
    case 2: 
      return "Normal";
    case 3: 
      return "High";
    case 256: 
      return "Auto";
    }
    return "N/A";
  }
  
  public String getImageQualityDescription()
  {
    return a(258, new String[] { "RAW", "Super Fine", "Fine", "Standard", "Economy", "Extra Fine", "RAW + JPEG", "Compressed RAW", "Compressed RAW + JPEG" });
  }
  
  public String getImageStabilizationDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45094);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "N/A";
    case 0: 
      return "Off";
    }
    return "On";
  }
  
  public String getJpegQualityDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45127);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Normal";
    case 1: 
      return "Fine";
    case 2: 
      return "Extra Fine";
    }
    return "N/A";
  }
  
  public String getLateralChromaticAberrationDescription()
  {
    return a(8210, new String[] { "Off", null, "Auto" });
  }
  
  public String getLongExposureNoiseReductionDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45134);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "On";
    }
    return "N/A";
  }
  
  public String getMacroDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45120);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "On";
    case 2: 
      return "Magnifying Glass/Super Macro";
    }
    return "N/A";
  }
  
  public String getPictureEffectDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(8206);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "Off";
    case 1: 
      return "Toy Camera";
    case 2: 
      return "Pop Color";
    case 3: 
      return "Posterization";
    case 4: 
      return "Posterization B/W";
    case 5: 
      return "Retro Photo";
    case 6: 
      return "Soft High Key";
    case 7: 
      return "Partial Color (red)";
    case 8: 
      return "Partial Color (green)";
    case 9: 
      return "Partial Color (blue)";
    case 10: 
      return "Partial Color (yellow)";
    case 13: 
      return "High Contrast Monochrome";
    case 16: 
      return "Toy Camera (normal)";
    case 17: 
      return "Toy Camera (cool)";
    case 18: 
      return "Toy Camera (warm)";
    case 19: 
      return "Toy Camera (green)";
    case 20: 
      return "Toy Camera (magenta)";
    case 32: 
      return "Soft Focus (low)";
    case 33: 
      return "Soft Focus";
    case 34: 
      return "Soft Focus (high)";
    case 48: 
      return "Miniature (auto)";
    case 49: 
      return "Miniature (top)";
    case 50: 
      return "Miniature (middle horizontal)";
    case 51: 
      return "Miniature (bottom)";
    case 52: 
      return "Miniature (left)";
    case 53: 
      return "Miniature (middle vertical)";
    case 54: 
      return "Miniature (right)";
    case 64: 
      return "HDR Painting (low)";
    case 65: 
      return "HDR Painting";
    case 66: 
      return "HDR Painting (high)";
    case 80: 
      return "Rich-tone Monochrome";
    case 97: 
      return "Water Color";
    case 98: 
      return "Water Color 2";
    case 112: 
      return "Illustration (low)";
    case 113: 
      return "Illustration";
    }
    return "Illustration (high)";
  }
  
  public String getReleaseModeDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45129);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 2: 
      return "Continuous";
    case 5: 
      return "Exposure Bracketing";
    case 6: 
      return "White Balance Bracketing";
    }
    return "n/a";
  }
  
  public String getSceneModeDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45091);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Standard";
    case 1: 
      return "Portrait";
    case 2: 
      return "Text";
    case 3: 
      return "Night Scene";
    case 4: 
      return "Sunset";
    case 5: 
      return "Sports";
    case 6: 
      return "Landscape";
    case 7: 
      return "Night Portrait";
    case 8: 
      return "Macro";
    case 9: 
      return "Super Macro";
    case 16: 
      return "Auto";
    case 17: 
      return "Night View/Portrait";
    case 18: 
      return "Sweep Panorama";
    case 19: 
      return "Handheld Night Shot";
    case 20: 
      return "Anti Motion Blur";
    case 21: 
      return "Cont. Priority AE";
    case 22: 
      return "Auto+";
    case 23: 
      return "3D Sweep Panorama";
    case 24: 
      return "Superior Auto";
    case 25: 
      return "High Sensitivity";
    case 26: 
      return "Fireworks";
    case 27: 
      return "Food";
    }
    return "Pet";
  }
  
  public String getSequenceNumberDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45129);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return localInteger.toString();
    case 0: 
      return "Single";
    }
    return "n/a";
  }
  
  public String getSoftSkinEffectDescription()
  {
    return a(8207, new String[] { "Off", "Low", "Mid", "High" });
  }
  
  public String getSonyModelIdDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(45057);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 2: 
      return "DSC-R1";
    case 256: 
      return "DSLR-A100";
    case 257: 
      return "DSLR-A900";
    case 258: 
      return "DSLR-A700";
    case 259: 
      return "DSLR-A200";
    case 260: 
      return "DSLR-A350";
    case 261: 
      return "DSLR-A300";
    case 262: 
      return "DSLR-A900 (APS-C mode)";
    case 263: 
      return "DSLR-A380/A390";
    case 264: 
      return "DSLR-A330";
    case 265: 
      return "DSLR-A230";
    case 266: 
      return "DSLR-A290";
    case 269: 
      return "DSLR-A850";
    case 270: 
      return "DSLR-A850 (APS-C mode)";
    case 273: 
      return "DSLR-A550";
    case 274: 
      return "DSLR-A500";
    case 275: 
      return "DSLR-A450";
    case 278: 
      return "NEX-5";
    case 279: 
      return "NEX-3";
    case 280: 
      return "SLT-A33";
    case 281: 
      return "SLT-A55V";
    case 282: 
      return "DSLR-A560";
    case 283: 
      return "DSLR-A580";
    case 284: 
      return "NEX-C3";
    case 285: 
      return "SLT-A35";
    case 286: 
      return "SLT-A65V";
    case 287: 
      return "SLT-A77V";
    case 288: 
      return "NEX-5N";
    case 289: 
      return "NEX-7";
    case 290: 
      return "NEX-VG20E";
    case 291: 
      return "SLT-A37";
    case 292: 
      return "SLT-A57";
    case 293: 
      return "NEX-F3";
    case 294: 
      return "SLT-A99V";
    case 295: 
      return "NEX-6";
    case 296: 
      return "NEX-5R";
    case 297: 
      return "DSC-RX100";
    }
    return "DSC-RX1";
  }
  
  public String getTeleconverterDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(261);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "None";
    case 72: 
      return "Minolta/Sony AF 2x APO (D)";
    case 80: 
      return "Minolta AF 2x APO II";
    case 96: 
      return "Minolta AF 2x APO";
    case 136: 
      return "Minolta/Sony AF 1.4x APO (D)";
    case 144: 
      return "Minolta AF 1.4x APO II";
    }
    return "Minolta AF 1.4x APO";
  }
  
  public String getVignettingCorrectionDescription()
  {
    return a(8209, new String[] { "Off", null, "Auto" });
  }
  
  public String getWhiteBalanceDescription()
  {
    Integer localInteger = ((aj)this.a).getInteger(277);
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
      return "Color Temperature/Color Filter";
    case 16: 
      return "Daylight";
    case 32: 
      return "Cloudy";
    case 48: 
      return "Shade";
    case 64: 
      return "Tungsten";
    case 80: 
      return "Flash";
    case 96: 
      return "Fluorescent";
    }
    return "Custom";
  }
  
  public String getZoneMatchingDescription()
  {
    return a(45092, new String[] { "ISO Setting Used", "High Key", "Low Key" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */