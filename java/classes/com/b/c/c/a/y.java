package com.b.c.c.a;

import com.b.b.b;
import com.b.b.j;
import com.b.c.a;
import com.b.c.c;
import com.b.c.g;
import java.io.IOException;

public class y
  extends g<z>
{
  private static final String[] c = { "Normal", "Portrait", "Scenery", "Sports", "Night Portrait", "Program", "Aperture Priority", "Shutter Priority", "Macro", "Spot", "Manual", "Movie Preview", "Panning", "Simple", "Color Effects", "Self Portrait", "Economy", "Fireworks", "Party", "Snow", "Night Scenery", "Food", "Baby", "Soft Skin", "Candlelight", "Starry Night", "High Sensitivity", "Panorama Assist", "Underwater", "Beach", "Aerial Photo", "Sunset", "Pet", "Intelligent ISO", "Clipboard", "High Speed Continuous Shooting", "Intelligent Auto", null, "Multi-aspect", null, "Transform", "Flash Burst", "Pin Hole", "Film Grain", "My Color", "Photo Frame", null, null, null, null, "HDR" };
  
  public y(z paramz)
  {
    super(paramz);
  }
  
  private String a(c[] paramArrayOfc)
  {
    if (paramArrayOfc == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfc.length)
    {
      localStringBuilder.append("Face ").append(i + 1).append(": ").append(paramArrayOfc[i].toString()).append("\n");
      i += 1;
    }
    if (localStringBuilder.length() > 0) {}
    for (paramArrayOfc = localStringBuilder.substring(0, localStringBuilder.length() - 1);; paramArrayOfc = null) {
      return paramArrayOfc;
    }
  }
  
  private String h(int paramInt)
  {
    Object localObject = ((z)this.a).getByteArray(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = new b((byte[])localObject);
    int i;
    label91:
    do
    {
      try
      {
        paramInt = ((j)localObject).getUInt16(0);
        i = ((j)localObject).getUInt16(2);
        if ((paramInt != -1) || (i != 1)) {
          break label91;
        }
        return "Slim Low";
      }
      catch (IOException localIOException)
      {
        return null;
      }
      localObject = "Unknown (" + paramInt + " " + i + ")";
      return (String)localObject;
      if ((paramInt == -3) && (i == 2)) {
        return "Slim High";
      }
      if ((paramInt == 0) && (i == 0)) {
        return "Off";
      }
      if ((paramInt == 1) && (i == 1)) {
        return "Stretch Low";
      }
    } while ((paramInt != 3) || (i != 2));
    return "Stretch High";
  }
  
  public String getAdvancedSceneModeDescription()
  {
    return a(61, 1, new String[] { "Normal", "Outdoor/Illuminations/Flower/HDR Art", "Indoor/Architecture/Objects/HDR B&W", "Creative", "Auto", null, "Expressive", "Retro", "Pure", "Elegant", null, "Monochrome", "Dynamic Art", "Silhouette" });
  }
  
  public String getAfAreaModeDescription()
  {
    int[] arrayOfInt = ((z)this.a).getIntArray(15);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    switch (arrayOfInt[0])
    {
    default: 
      return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
    case 0: 
      switch (arrayOfInt[1])
      {
      default: 
        return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
      case 1: 
        return "Spot Mode On";
      }
      return "Spot Mode Off";
    case 1: 
      switch (arrayOfInt[1])
      {
      default: 
        return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
      case 0: 
        return "Spot Focusing";
      }
      return "5-area";
    case 16: 
      switch (arrayOfInt[1])
      {
      default: 
        return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
      case 0: 
        return "1-area";
      }
      return "1-area (high speed)";
    case 32: 
      switch (arrayOfInt[1])
      {
      default: 
        return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
      case 0: 
        return "Auto or Face Detect";
      case 1: 
        return "3-area (left)";
      case 2: 
        return "3-area (center)";
      }
      return "3-area (right)";
    }
    return "Face Detect";
  }
  
  public String getAfAssistLampDescription()
  {
    return a(49, 1, new String[] { "Fired", "Enabled but not used", "Disabled but required", "Disabled and not required" });
  }
  
  public String getAudioDescription()
  {
    return a(32, 1, new String[] { "Off", "On" });
  }
  
  public String getBabyAge1Description()
  {
    a locala = ((z)this.a).getAge(32784);
    if (locala == null) {
      return null;
    }
    return locala.toFriendlyString();
  }
  
  public String getBabyAgeDescription()
  {
    a locala = ((z)this.a).getAge(51);
    if (locala == null) {
      return null;
    }
    return locala.toFriendlyString();
  }
  
  public String getBabyNameDescription()
  {
    return e(102);
  }
  
  public String getBurstModeDescription()
  {
    return a(42, new String[] { "Off", null, "On", "Indefinite", "Unlimited" });
  }
  
  public String getCityDescription()
  {
    return e(109);
  }
  
  public String getColorEffectDescription()
  {
    return a(40, 1, new String[] { "Off", "Warm", "Cool", "Black & White", "Sepia" });
  }
  
  public String getColorModeDescription()
  {
    return a(50, new String[] { "Normal", "Natural", "Vivid" });
  }
  
  public String getContrastDescription()
  {
    return a(57, new String[] { "Normal" });
  }
  
  public String getContrastModeDescription()
  {
    Integer localInteger = ((z)this.a).getInteger(44);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 1: 
      return "Low";
    case 2: 
      return "High";
    case 6: 
      return "Medium Low";
    case 7: 
      return "Medium High";
    case 256: 
      return "Low";
    case 272: 
      return "Normal";
    }
    return "High";
  }
  
  public String getConversionLensDescription()
  {
    return a(53, 1, new String[] { "Off", "Wide", "Telephoto", "Macro" });
  }
  
  public String getCountryDescription()
  {
    return e(105);
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return getQualityModeDescription();
    case 2: 
      return getVersionDescription();
    case 3: 
      return getWhiteBalanceDescription();
    case 7: 
      return getFocusModeDescription();
    case 15: 
      return getAfAreaModeDescription();
    case 26: 
      return getImageStabilizationDescription();
    case 28: 
      return getMacroModeDescription();
    case 31: 
      return getRecordModeDescription();
    case 32: 
      return getAudioDescription();
    case 33: 
      return getUnknownDataDumpDescription();
    case 40: 
      return getColorEffectDescription();
    case 41: 
      return getUptimeDescription();
    case 42: 
      return getBurstModeDescription();
    case 44: 
      return getContrastModeDescription();
    case 45: 
      return getNoiseReductionDescription();
    case 46: 
      return getSelfTimerDescription();
    case 48: 
      return getRotationDescription();
    case 49: 
      return getAfAssistLampDescription();
    case 50: 
      return getColorModeDescription();
    case 52: 
      return getOpticalZoomModeDescription();
    case 53: 
      return getConversionLensDescription();
    case 57: 
      return getContrastDescription();
    case 58: 
      return getWorldTimeLocationDescription();
    case 61: 
      return getAdvancedSceneModeDescription();
    case 78: 
      return getDetectedFacesDescription();
    case 89: 
      return getTransformDescription();
    case 32786: 
      return getTransform1Description();
    case 93: 
      return getIntelligentExposureDescription();
    case 98: 
      return getFlashWarningDescription();
    case 105: 
      return getCountryDescription();
    case 107: 
      return getStateDescription();
    case 109: 
      return getCityDescription();
    case 111: 
      return getLandmarkDescription();
    case 112: 
      return getIntelligentResolutionDescription();
    case 97: 
      return getRecognizedFacesDescription();
    case 3584: 
      return getPrintImageMatchingInfoDescription();
    case 32769: 
      return getSceneModeDescription();
    case 32775: 
      return getFlashFiredDescription();
    case 59: 
      return getTextStampDescription();
    case 62: 
      return getTextStamp1Description();
    case 32776: 
      return getTextStamp2Description();
    case 32777: 
      return getTextStamp3Description();
    case 32768: 
      return getMakernoteVersionDescription();
    case 38: 
      return getExifVersionDescription();
    case 37: 
      return getInternalSerialNumberDescription();
    case 101: 
      return getTitleDescription();
    case 102: 
      return getBabyNameDescription();
    case 103: 
      return getLocationDescription();
    case 51: 
      return getBabyAgeDescription();
    }
    return getBabyAge1Description();
  }
  
  public String getDetectedFacesDescription()
  {
    return a(((z)this.a).getDetectedFaces());
  }
  
  public String getExifVersionDescription()
  {
    return a(38, 2);
  }
  
  public String getFlashFiredDescription()
  {
    return a(32775, 1, new String[] { "Off", "On" });
  }
  
  public String getFlashWarningDescription()
  {
    return a(98, new String[] { "No", "Yes (Flash required but disabled)" });
  }
  
  public String getFocusModeDescription()
  {
    return a(7, 1, new String[] { "Auto", "Manual", null, "Auto, Focus Button", "Auto, Continuous" });
  }
  
  public String getImageStabilizationDescription()
  {
    return a(26, 2, new String[] { "On, Mode 1", "Off", "On, Mode 2" });
  }
  
  public String getIntelligentExposureDescription()
  {
    return a(93, new String[] { "Off", "Low", "Standard", "High" });
  }
  
  public String getIntelligentResolutionDescription()
  {
    return a(112, new String[] { "Off", null, "Auto", "On" });
  }
  
  public String getInternalSerialNumberDescription()
  {
    return d(37);
  }
  
  public String getLandmarkDescription()
  {
    return e(111);
  }
  
  public String getLocationDescription()
  {
    return e(103);
  }
  
  public String getMacroModeDescription()
  {
    return a(28, 1, new String[] { "Off", "On" });
  }
  
  public String getMakernoteVersionDescription()
  {
    return a(32768, 2);
  }
  
  public String getNoiseReductionDescription()
  {
    return a(45, new String[] { "Standard (0)", "Low (-1)", "High (+1)", "Lowest (-2)", "Highest (+2)" });
  }
  
  public String getOpticalZoomModeDescription()
  {
    return a(52, 1, new String[] { "Standard", "Extended" });
  }
  
  public String getPrintImageMatchingInfoDescription()
  {
    return a(3584);
  }
  
  public String getQualityModeDescription()
  {
    return a(1, 2, new String[] { "High", "Normal", null, null, "Very High", "Raw", null, "Motion Picture" });
  }
  
  public String getRecognizedFacesDescription()
  {
    return a(((z)this.a).getRecognizedFaces());
  }
  
  public String getRecordModeDescription()
  {
    return a(31, 1, c);
  }
  
  public String getRotationDescription()
  {
    Integer localInteger = ((z)this.a).getInteger(48);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Horizontal";
    case 3: 
      return "Rotate 180";
    case 6: 
      return "Rotate 90 CW";
    }
    return "Rotate 270 CW";
  }
  
  public String getSceneModeDescription()
  {
    return a(32769, 1, c);
  }
  
  public String getSelfTimerDescription()
  {
    return a(46, 1, new String[] { "Off", "10 s", "2 s" });
  }
  
  public String getStateDescription()
  {
    return e(107);
  }
  
  public String getTextStamp1Description()
  {
    return a(62, 1, new String[] { "Off", "On" });
  }
  
  public String getTextStamp2Description()
  {
    return a(32776, 1, new String[] { "Off", "On" });
  }
  
  public String getTextStamp3Description()
  {
    return a(32777, 1, new String[] { "Off", "On" });
  }
  
  public String getTextStampDescription()
  {
    return a(59, 1, new String[] { "Off", "On" });
  }
  
  public String getTitleDescription()
  {
    return e(101);
  }
  
  public String getTransform1Description()
  {
    return h(32786);
  }
  
  public String getTransformDescription()
  {
    return h(89);
  }
  
  public String getUnknownDataDumpDescription()
  {
    return a(33);
  }
  
  public String getUptimeDescription()
  {
    Integer localInteger = ((z)this.a).getInteger(41);
    if (localInteger == null) {
      return null;
    }
    return localInteger.intValue() / 100.0F + " s";
  }
  
  public String getVersionDescription()
  {
    return a(2, 2);
  }
  
  public String getWhiteBalanceDescription()
  {
    return a(3, 1, new String[] { "Auto", "Daylight", "Cloudy", "Incandescent", "Manual", null, null, "Flash", null, "Black & White", "Manual", "Shade" });
  }
  
  public String getWorldTimeLocationDescription()
  {
    return a(58, 1, new String[] { "Home", "Destination" });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */