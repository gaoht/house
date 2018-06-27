package com.b.c.c.a;

import com.b.b.f;
import com.b.c.g;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class w
  extends g<x>
{
  public w(x paramx)
  {
    super(paramx);
  }
  
  public String getApexApertureDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61451);
    if (localLong == null) {
      return null;
    }
    return a(Math.pow(localLong.longValue() / 16.0D - 0.5D, 2.0D));
  }
  
  public String getApexBrightnessDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61485);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    if (localLong == null) {
      return null;
    }
    return localDecimalFormat.format(localLong.longValue() / 8.0D - 6.0D);
  }
  
  public String getApexFilmSpeedDescription()
  {
    Object localObject = ((x)this.a).getLongObject(61449);
    if (localObject == null) {
      return null;
    }
    double d = Math.pow(((Long)localObject).longValue() / 8.0D - 1.0D, 2.0D);
    localObject = new DecimalFormat("0.##");
    ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
    return ((DecimalFormat)localObject).format(d * 3.125D);
  }
  
  public String getApexShutterSpeedTimeDescription()
  {
    Object localObject = ((x)this.a).getLongObject(61450);
    if (localObject == null) {
      return null;
    }
    double d = Math.pow((49L - ((Long)localObject).longValue()) / 8.0D, 2.0D);
    localObject = new DecimalFormat("0.###");
    ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
    return ((DecimalFormat)localObject).format(d) + " sec";
  }
  
  public String getBWModeDescription()
  {
    return a(515, new String[] { "Off", "On" });
  }
  
  public String getBlackAndWhiteFilterDescription()
  {
    return super.getDescription(61483);
  }
  
  public String getBracketStepDescription()
  {
    return a(61455, new String[] { "1/3 EV", "2/3 EV", "1 EV" });
  }
  
  public String getCameraIdDescription()
  {
    byte[] arrayOfByte = ((x)this.a).getByteArray(521);
    if (arrayOfByte == null) {
      return null;
    }
    return new String(arrayOfByte);
  }
  
  public String getCameraModelDescription()
  {
    return a(61478, new String[] { "DiMAGE 7", "DiMAGE 5", "DiMAGE S304", "DiMAGE S404", "DiMAGE 7i", "DiMAGE 7Hi", "DiMAGE A1", "DiMAGE S414" });
  }
  
  public String getColorFilterDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61482);
    if (localLong == null) {
      return null;
    }
    return Long.toString(localLong.longValue() - 3L);
  }
  
  public String getColorModeCameraSettingDescription()
  {
    return a(61481, new String[] { "Natural Color", "Black & White", "Vivid Color", "Solarization", "AdobeRGB" });
  }
  
  public String getColorModeDescription()
  {
    return a(257, new String[] { "Natural Colour", "Black & White", "Vivid Colour", "Solarization", "AdobeRGB" });
  }
  
  public String getContrastDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61473);
    if (localLong == null) {
      return null;
    }
    return Long.toString(localLong.longValue() - 3L);
  }
  
  public String getDateDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61462);
    if (localLong == null) {
      return null;
    }
    int i = (int)(localLong.longValue() & 0xFF);
    int j = (int)(localLong.longValue() >> 16 & 0xFF);
    int k = (int)(localLong.longValue() >> 8 & 0xFF) + 1970;
    if (!f.isValidDate(k, j, i)) {
      return "Invalid date";
    }
    return String.format("%04d-%02d-%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j + 1), Integer.valueOf(i) });
  }
  
  public String getDecSwitchPositionDescription()
  {
    return a(61491, new String[] { "Exposure", "Contrast", "Saturation", "Filter" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 0: 
      return getMakernoteVersionDescription();
    case 257: 
      return getColorModeDescription();
    case 258: 
      return getImageQuality1Description();
    case 259: 
      return getImageQuality2Description();
    case 512: 
      return getSpecialModeDescription();
    case 513: 
      return getJpegQualityDescription();
    case 514: 
      return getMacroModeDescription();
    case 515: 
      return getBWModeDescription();
    case 516: 
      return getDigiZoomRatioDescription();
    case 521: 
      return getCameraIdDescription();
    case 4100: 
      return getFlashModeDescription();
    case 4106: 
      return getFocusRangeDescription();
    case 4107: 
      return getFocusModeDescription();
    case 4111: 
      return getSharpnessDescription();
    case 61442: 
      return getExposureModeDescription();
    case 61443: 
      return getFlashModeCameraSettingDescription();
    case 61444: 
      return getWhiteBalanceDescription();
    case 61445: 
      return getImageSizeDescription();
    case 61446: 
      return getImageQualityDescription();
    case 61447: 
      return getShootingModeDescription();
    case 61448: 
      return getMeteringModeDescription();
    case 61449: 
      return getApexFilmSpeedDescription();
    case 61450: 
      return getApexShutterSpeedTimeDescription();
    case 61451: 
      return getApexApertureDescription();
    case 61452: 
      return getMacroModeCameraSettingDescription();
    case 61453: 
      return getDigitalZoomDescription();
    case 61454: 
      return getExposureCompensationDescription();
    case 61455: 
      return getBracketStepDescription();
    case 61457: 
      return getIntervalLengthDescription();
    case 61458: 
      return getIntervalNumberDescription();
    case 61459: 
      return getFocalLengthDescription();
    case 61460: 
      return getFocusDistanceDescription();
    case 61461: 
      return getFlashFiredDescription();
    case 61462: 
      return getDateDescription();
    case 61463: 
      return getTimeDescription();
    case 61464: 
      return getMaxApertureAtFocalLengthDescription();
    case 61467: 
      return getFileNumberMemoryDescription();
    case 61468: 
      return getLastFileNumberDescription();
    case 61469: 
      return getWhiteBalanceRedDescription();
    case 61470: 
      return getWhiteBalanceGreenDescription();
    case 61471: 
      return getWhiteBalanceBlueDescription();
    case 61472: 
      return getSaturationDescription();
    case 61473: 
      return getContrastDescription();
    case 61474: 
      return getSharpnessCameraSettingDescription();
    case 61475: 
      return getSubjectProgramDescription();
    case 61476: 
      return getFlashCompensationDescription();
    case 61477: 
      return getIsoSettingDescription();
    case 61478: 
      return getCameraModelDescription();
    case 61479: 
      return getIntervalModeDescription();
    case 61480: 
      return getFolderNameDescription();
    case 61481: 
      return getColorModeCameraSettingDescription();
    case 61482: 
      return getColorFilterDescription();
    case 61483: 
      return getBlackAndWhiteFilterDescription();
    case 61484: 
      return getInternalFlashDescription();
    case 61485: 
      return getApexBrightnessDescription();
    case 61486: 
      return getSpotFocusPointXCoordinateDescription();
    case 61487: 
      return getSpotFocusPointYCoordinateDescription();
    case 61488: 
      return getWideFocusZoneDescription();
    case 61489: 
      return getFocusModeCameraSettingDescription();
    case 61490: 
      return getFocusAreaDescription();
    }
    return getDecSwitchPositionDescription();
  }
  
  public String getDigiZoomRatioDescription()
  {
    return a(516, new String[] { "Normal", null, "Digital 2x Zoom" });
  }
  
  public String getDigitalZoomDescription()
  {
    return a(61453, new String[] { "Off", "Electronic magnification", "Digital zoom 2x" });
  }
  
  public String getExposureCompensationDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61454);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    if (localLong == null) {
      return null;
    }
    return localDecimalFormat.format(localLong.longValue() / 3.0D - 2.0D) + " EV";
  }
  
  public String getExposureModeDescription()
  {
    return a(61442, new String[] { "P", "A", "S", "M" });
  }
  
  public String getFileNumberMemoryDescription()
  {
    return a(61467, new String[] { "Off", "On" });
  }
  
  public String getFlashCompensationDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61476);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    if (localLong == null) {
      return null;
    }
    return localDecimalFormat.format((localLong.longValue() - 6L) / 3.0D) + " EV";
  }
  
  public String getFlashFiredDescription()
  {
    return a(61461, new String[] { "No", "Yes" });
  }
  
  public String getFlashModeCameraSettingDescription()
  {
    return a(61443, new String[] { "Normal", "Red-eye reduction", "Rear flash sync", "Wireless" });
  }
  
  public String getFlashModeDescription()
  {
    return a(4100, new String[] { null, null, "On", "Off" });
  }
  
  public String getFocalLengthDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61459);
    if (localLong == null) {
      return null;
    }
    return b(localLong.longValue() / 256.0D);
  }
  
  public String getFocusAreaDescription()
  {
    return a(61490, new String[] { "Wide Focus (Normal)", "Spot Focus" });
  }
  
  public String getFocusDistanceDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61460);
    if (localLong == null) {
      return null;
    }
    if (localLong.longValue() == 0L) {
      return "Infinity";
    }
    return localLong + " mm";
  }
  
  public String getFocusModeCameraSettingDescription()
  {
    return a(61489, new String[] { "Auto Focus", "Manual Focus" });
  }
  
  public String getFocusModeDescription()
  {
    return a(4107, new String[] { "Auto", "Manual" });
  }
  
  public String getFocusRangeDescription()
  {
    return a(4106, new String[] { "Normal", "Macro" });
  }
  
  public String getFolderNameDescription()
  {
    return a(61480, new String[] { "Standard Form", "Data Form" });
  }
  
  public String getImageQuality1Description()
  {
    return a(258, new String[] { "Raw", "Super Fine", "Fine", "Standard", "Extra Fine" });
  }
  
  public String getImageQuality2Description()
  {
    return a(259, new String[] { "Raw", "Super Fine", "Fine", "Standard", "Extra Fine" });
  }
  
  public String getImageQualityDescription()
  {
    return a(61446, new String[] { "Raw", "Super Fine", "Fine", "Standard", "Economy", "Extra Fine" });
  }
  
  public String getImageSizeDescription()
  {
    return a(61445, new String[] { "2560 x 1920", "1600 x 1200", "1280 x 960", "640 x 480" });
  }
  
  public String getInternalFlashDescription()
  {
    return a(61484, new String[] { "Did Not Fire", "Fired" });
  }
  
  public String getIntervalLengthDescription()
  {
    if (!((x)this.a).isIntervalMode()) {
      return "N/A";
    }
    Long localLong = ((x)this.a).getLongObject(61457);
    if (localLong == null) {
      return null;
    }
    return localLong + " min";
  }
  
  public String getIntervalModeDescription()
  {
    return a(61479, new String[] { "Still Image", "Time Lapse Movie" });
  }
  
  public String getIntervalNumberDescription()
  {
    if (!((x)this.a).isIntervalMode()) {
      return "N/A";
    }
    Long localLong = ((x)this.a).getLongObject(61458);
    if (localLong == null) {
      return null;
    }
    return Long.toString(localLong.longValue());
  }
  
  public String getIsoSettingDescription()
  {
    return a(61477, new String[] { "100", "200", "400", "800", "Auto", "64" });
  }
  
  public String getJpegQualityDescription()
  {
    return a(513, 1, new String[] { "Standard Quality", "High Quality", "Super High Quality" });
  }
  
  public String getLastFileNumberDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61468);
    if (localLong == null) {
      return null;
    }
    if (localLong.longValue() == 0L) {
      return "File Number Memory Off";
    }
    return Long.toString(localLong.longValue());
  }
  
  public String getMacroModeCameraSettingDescription()
  {
    return a(61452, new String[] { "Off", "On" });
  }
  
  public String getMacroModeDescription()
  {
    return a(514, new String[] { "Normal (no macro)", "Macro" });
  }
  
  public String getMakernoteVersionDescription()
  {
    return a(0, 2);
  }
  
  public String getMaxApertureAtFocalLengthDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61463);
    if (localLong == null) {
      return null;
    }
    return a(Math.pow(localLong.longValue() / 16.0D - 0.5D, 2.0D));
  }
  
  public String getMeteringModeDescription()
  {
    return a(61448, new String[] { "Multi-Segment", "Centre Weighted", "Spot" });
  }
  
  public String getSaturationDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61472);
    if (localLong == null) {
      return null;
    }
    return Long.toString(localLong.longValue() - 3L);
  }
  
  public String getSharpnessCameraSettingDescription()
  {
    return a(61474, new String[] { "Hard", "Normal", "Soft" });
  }
  
  public String getSharpnessDescription()
  {
    return a(4111, new String[] { "Normal", "Hard", "Soft" });
  }
  
  public String getShootingModeDescription()
  {
    return a(61447, new String[] { "Single", "Continuous", "Self Timer", null, "Bracketing", "Interval", "UHS Continuous", "HS Continuous" });
  }
  
  public String getSpecialModeDescription()
  {
    long[] arrayOfLong = (long[])((x)this.a).getObject(512);
    if (arrayOfLong == null) {
      return null;
    }
    if (arrayOfLong.length < 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch ((int)arrayOfLong[0])
    {
    default: 
      localStringBuilder.append("Unknown picture taking mode");
      if (arrayOfLong.length >= 2) {}
      switch ((int)arrayOfLong[1])
      {
      default: 
        localStringBuilder.append(" / ");
        localStringBuilder.append(arrayOfLong[1]);
        localStringBuilder.append("th in a sequence");
      case 0: 
        label152:
        if (arrayOfLong.length >= 3) {
          switch ((int)arrayOfLong[2])
          {
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("Normal picture taking mode");
      break;
      localStringBuilder.append("Unknown picture taking mode");
      break;
      localStringBuilder.append("Fast picture taking mode");
      break;
      localStringBuilder.append("Panorama picture taking mode");
      break;
      localStringBuilder.append(" / 1st in a sequence");
      break label152;
      localStringBuilder.append(" / 2nd in a sequence");
      break label152;
      localStringBuilder.append(" / 3rd in a sequence");
      break label152;
      localStringBuilder.append(" / Left to right panorama direction");
      continue;
      localStringBuilder.append(" / Right to left panorama direction");
      continue;
      localStringBuilder.append(" / Bottom to top panorama direction");
      continue;
      localStringBuilder.append(" / Top to bottom panorama direction");
    }
  }
  
  public String getSpotFocusPointXCoordinateDescription()
  {
    return super.getDescription(61486);
  }
  
  public String getSpotFocusPointYCoordinateDescription()
  {
    return super.getDescription(61487);
  }
  
  public String getSubjectProgramDescription()
  {
    return a(61475, new String[] { "None", "Portrait", "Text", "Night Portrait", "Sunset", "Sports Action" });
  }
  
  public String getTimeDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61463);
    if (localLong == null) {
      return null;
    }
    int i = (int)(localLong.longValue() >> 8 & 0xFF);
    int j = (int)(localLong.longValue() >> 16 & 0xFF);
    int k = (int)(localLong.longValue() & 0xFF);
    if (!f.isValidTime(i, j, k)) {
      return "Invalid time";
    }
    return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
  }
  
  public String getWhiteBalanceBlueDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61471);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    if (localLong == null) {
      return null;
    }
    return localDecimalFormat.format(localLong.longValue() / 256.0D);
  }
  
  public String getWhiteBalanceDescription()
  {
    return a(61444, new String[] { "Auto", "Daylight", "Cloudy", "Tungsten", null, "Custom", null, "Fluorescent", "Fluorescent 2", null, null, "Custom 2", "Custom 3" });
  }
  
  public String getWhiteBalanceGreenDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61470);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    if (localLong == null) {
      return null;
    }
    return localDecimalFormat.format(localLong.longValue() / 256.0D);
  }
  
  public String getWhiteBalanceRedDescription()
  {
    Long localLong = ((x)this.a).getLongObject(61469);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    if (localLong == null) {
      return null;
    }
    return localDecimalFormat.format(localLong.longValue() / 256.0D);
  }
  
  public String getWideFocusZoneDescription()
  {
    return a(61488, new String[] { "No Zone or AF Failed", "Center Zone (Horizontal Orientation)", "Center Zone (Vertical Orientation)", "Left Zone", "Right Zone" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */