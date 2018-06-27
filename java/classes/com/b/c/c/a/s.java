package com.b.c.c.a;

import com.b.b.l;
import com.b.c.g;
import java.text.DecimalFormat;
import java.util.HashMap;

public class s
  extends g<t>
{
  private static final HashMap<Integer, String> c = new HashMap();
  
  static
  {
    c.put(Integer.valueOf(0), "Off");
    c.put(Integer.valueOf(1), "Soft Focus");
    c.put(Integer.valueOf(2), "Pop Art");
    c.put(Integer.valueOf(3), "Pale & Light Color");
    c.put(Integer.valueOf(4), "Light Tone");
    c.put(Integer.valueOf(5), "Pin Hole");
    c.put(Integer.valueOf(6), "Grainy Film");
    c.put(Integer.valueOf(9), "Diorama");
    c.put(Integer.valueOf(10), "Cross Process");
    c.put(Integer.valueOf(12), "Fish Eye");
    c.put(Integer.valueOf(13), "Drawing");
    c.put(Integer.valueOf(14), "Gentle Sepia");
    c.put(Integer.valueOf(15), "Pale & Light Color II");
    c.put(Integer.valueOf(16), "Pop Art II");
    c.put(Integer.valueOf(17), "Pin Hole II");
    c.put(Integer.valueOf(18), "Pin Hole III");
    c.put(Integer.valueOf(19), "Grainy Film II");
    c.put(Integer.valueOf(20), "Dramatic Tone");
    c.put(Integer.valueOf(21), "Punk");
    c.put(Integer.valueOf(22), "Soft Focus 2");
    c.put(Integer.valueOf(23), "Sparkle");
    c.put(Integer.valueOf(24), "Watercolor");
    c.put(Integer.valueOf(25), "Key Line");
    c.put(Integer.valueOf(26), "Key Line II");
    c.put(Integer.valueOf(27), "Miniature");
    c.put(Integer.valueOf(28), "Reflection");
    c.put(Integer.valueOf(29), "Fragmented");
    c.put(Integer.valueOf(31), "Cross Process II");
    c.put(Integer.valueOf(32), "Dramatic Tone II");
    c.put(Integer.valueOf(33), "Watercolor I");
    c.put(Integer.valueOf(34), "Watercolor II");
    c.put(Integer.valueOf(35), "Diorama II");
    c.put(Integer.valueOf(36), "Vintage");
    c.put(Integer.valueOf(37), "Vintage II");
    c.put(Integer.valueOf(38), "Vintage III");
    c.put(Integer.valueOf(39), "Partial Color");
    c.put(Integer.valueOf(40), "Partial Color II");
    c.put(Integer.valueOf(41), "Partial Color III");
  }
  
  public s(t paramt)
  {
    super(paramt);
  }
  
  private String h(int paramInt)
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(paramInt);
    if ((arrayOfInt == null) || (arrayOfInt.length < 3)) {
      return null;
    }
    return String.format("%d (min %d, max %d)", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(arrayOfInt[2]) });
  }
  
  private String i(int paramInt)
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(paramInt);
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    if (paramInt < arrayOfInt.length)
    {
      String str;
      if (paramInt == 0) {
        if (c.containsKey(Integer.valueOf(arrayOfInt[paramInt])))
        {
          str = (String)c.get(Integer.valueOf(arrayOfInt[paramInt]));
          label75:
          localStringBuilder.append(str);
        }
      }
      for (;;)
      {
        localStringBuilder.append("; ");
        paramInt += 1;
        break;
        str = "[unknown]";
        break label75;
        localStringBuilder.append(arrayOfInt[paramInt]);
      }
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 2);
  }
  
  public String getAeLockDescription()
  {
    return a(513, new String[] { "Off", "On" });
  }
  
  public String getAfAreasDescription()
  {
    Object localObject = ((t)this.a).getObject(772);
    if ((localObject == null) || (!(localObject instanceof long[]))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = (long[])localObject;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      long l = localObject[i];
      if (l == 0L)
      {
        i += 1;
      }
      else
      {
        if (localStringBuilder.length() != 0) {
          localStringBuilder.append(", ");
        }
        if (l == 913916549L) {
          localStringBuilder.append("Left ");
        }
        for (;;)
        {
          localStringBuilder.append(String.format("(%d/255,%d/255)-(%d/255,%d/255)", new Object[] { Long.valueOf(l >> 24 & 0xFF), Long.valueOf(l >> 16 & 0xFF), Long.valueOf(l >> 8 & 0xFF), Long.valueOf(l & 0xFF) }));
          break;
          if (l == 2038007173L) {
            localStringBuilder.append("Center ");
          } else if (l == 3178875269L) {
            localStringBuilder.append("Right ");
          }
        }
      }
    }
    if (localStringBuilder.length() == 0) {
      return null;
    }
    return localStringBuilder.toString();
  }
  
  public String getAfFineTuneDescription()
  {
    return a(774, new String[] { "Off", "On" });
  }
  
  public String getAfPointSelectedDescription()
  {
    l[] arrayOfl = ((t)this.a).getRationalArray(773);
    if (arrayOfl == null) {
      return "n/a";
    }
    if (arrayOfl.length < 4) {
      return null;
    }
    if ((arrayOfl.length == 5) && (arrayOfl[0].longValue() == 0L)) {}
    for (int i = 1;; i = 0) {
      return String.format("(%d%%,%d%%) (%d%%,%d%%)", new Object[] { Integer.valueOf((int)(arrayOfl[i].doubleValue() * 100.0D)), Integer.valueOf((int)(arrayOfl[(i + 1)].doubleValue() * 100.0D)), Integer.valueOf((int)(arrayOfl[(i + 2)].doubleValue() * 100.0D)), Integer.valueOf((int)(arrayOfl[(i + 3)].doubleValue() * 100.0D)) });
    }
  }
  
  public String getAfSearchDescription()
  {
    return a(771, new String[] { "Not Ready", "Ready" });
  }
  
  public String getArtFilterDescription()
  {
    return i(1321);
  }
  
  public String getArtFilterEffectDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(1327);
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < arrayOfInt.length)
    {
      String str;
      if (i == 0) {
        if (c.containsKey(Integer.valueOf(arrayOfInt[i])))
        {
          str = (String)c.get(Integer.valueOf(arrayOfInt[i]));
          label77:
          localStringBuilder.append(str);
        }
      }
      for (;;)
      {
        localStringBuilder.append("; ");
        i += 1;
        break;
        str = "[unknown]";
        break label77;
        if (i == 4) {
          switch (arrayOfInt[i])
          {
          default: 
            localStringBuilder.append("Unknown (").append(arrayOfInt[i]).append(")");
            break;
          case 0: 
            localStringBuilder.append("No Effect");
            break;
          case 32784: 
            localStringBuilder.append("Star Light");
            break;
          case 32800: 
            localStringBuilder.append("Pin Hole");
            break;
          case 32816: 
            localStringBuilder.append("Frame");
            break;
          case 32832: 
            localStringBuilder.append("Soft Focus");
            break;
          case 32848: 
            localStringBuilder.append("White Edge");
            break;
          case 32864: 
            localStringBuilder.append("B&W");
            break;
          }
        } else {
          localStringBuilder.append(arrayOfInt[i]);
        }
      }
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 2);
  }
  
  public String getCameraSettingsVersionDescription()
  {
    return a(0, 4);
  }
  
  public String getColorSpaceDescription()
  {
    return a(1287, new String[] { "sRGB", "Adobe RGB", "Pro Photo RGB" });
  }
  
  public String getContrastSettingDescription()
  {
    return h(1285);
  }
  
  public String getCustomSaturationDescription()
  {
    return h(1283);
  }
  
  public String getDateTimeUTCDescription()
  {
    Object localObject = ((t)this.a).getObject(2312);
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 0: 
      return getCameraSettingsVersionDescription();
    case 256: 
      return getPreviewImageValidDescription();
    case 512: 
      return getExposureModeDescription();
    case 513: 
      return getAeLockDescription();
    case 514: 
      return getMeteringModeDescription();
    case 515: 
      return getExposureShiftDescription();
    case 516: 
      return getNdFilterDescription();
    case 768: 
      return getMacroModeDescription();
    case 769: 
      return getFocusModeDescription();
    case 770: 
      return getFocusProcessDescription();
    case 771: 
      return getAfSearchDescription();
    case 772: 
      return getAfAreasDescription();
    case 773: 
      return getAfPointSelectedDescription();
    case 774: 
      return getAfFineTuneDescription();
    case 1024: 
      return getFlashModeDescription();
    case 1027: 
      return getFlashRemoteControlDescription();
    case 1028: 
      return getFlashControlModeDescription();
    case 1029: 
      return getFlashIntensityDescription();
    case 1030: 
      return getManualFlashStrengthDescription();
    case 1280: 
      return getWhiteBalance2Description();
    case 1281: 
      return getWhiteBalanceTemperatureDescription();
    case 1283: 
      return getCustomSaturationDescription();
    case 1284: 
      return getModifiedSaturationDescription();
    case 1285: 
      return getContrastSettingDescription();
    case 1286: 
      return getSharpnessSettingDescription();
    case 1287: 
      return getColorSpaceDescription();
    case 1289: 
      return getSceneModeDescription();
    case 1290: 
      return getNoiseReductionDescription();
    case 1291: 
      return getDistortionCorrectionDescription();
    case 1292: 
      return getShadingCompensationDescription();
    case 1295: 
      return getGradationDescription();
    case 1312: 
      return getPictureModeDescription();
    case 1313: 
      return getPictureModeSaturationDescription();
    case 1315: 
      return getPictureModeContrastDescription();
    case 1316: 
      return getPictureModeSharpnessDescription();
    case 1317: 
      return getPictureModeBWFilterDescription();
    case 1318: 
      return getPictureModeToneDescription();
    case 1319: 
      return getNoiseFilterDescription();
    case 1321: 
      return getArtFilterDescription();
    case 1324: 
      return getMagicFilterDescription();
    case 1325: 
      return getPictureModeEffectDescription();
    case 1326: 
      return getToneLevelDescription();
    case 1327: 
      return getArtFilterEffectDescription();
    case 1536: 
      return getDriveModeDescription();
    case 1537: 
      return getPanoramaModeDescription();
    case 1539: 
      return getImageQuality2Description();
    case 1540: 
      return getImageStabilizationDescription();
    case 2052: 
      return getStackedImageDescription();
    case 2304: 
      return getManometerPressureDescription();
    case 2305: 
      return getManometerReadingDescription();
    case 2306: 
      return getExtendedWBDetectDescription();
    case 2307: 
      return getRollAngleDescription();
    case 2308: 
      return getPitchAngleDescription();
    }
    return getDateTimeUTCDescription();
  }
  
  public String getDistortionCorrectionDescription()
  {
    return a(1291, new String[] { "Off", "On" });
  }
  
  public String getDriveModeDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(1536);
    if (arrayOfInt == null) {
      return null;
    }
    if ((arrayOfInt.length == 0) || (arrayOfInt[0] == 0)) {
      return "Single Shot";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((arrayOfInt[0] == 5) && (arrayOfInt.length >= 3))
    {
      int i = arrayOfInt[2];
      if ((i & 0x1) > 0) {
        localStringBuilder.append("AE");
      }
      if ((i >> 1 & 0x1) > 0) {
        localStringBuilder.append("WB");
      }
      if ((i >> 2 & 0x1) > 0) {
        localStringBuilder.append("FL");
      }
      if ((i >> 3 & 0x1) > 0) {
        localStringBuilder.append("MF");
      }
      if ((i >> 6 & 0x1) > 0) {
        localStringBuilder.append("Focus");
      }
      localStringBuilder.append(" Bracketing");
    }
    for (;;)
    {
      localStringBuilder.append(", Shot ").append(arrayOfInt[1]);
      return localStringBuilder.toString();
      switch (arrayOfInt[0])
      {
      default: 
        localStringBuilder.append("Unknown (").append(arrayOfInt[0]).append(")");
        break;
      case 1: 
        localStringBuilder.append("Continuous Shooting");
        break;
      case 2: 
        localStringBuilder.append("Exposure Bracketing");
        break;
      case 3: 
        localStringBuilder.append("White Balance Bracketing");
        break;
      case 4: 
        localStringBuilder.append("Exposure+WB Bracketing");
      }
    }
  }
  
  public String getExposureModeDescription()
  {
    return a(512, 1, new String[] { "Manual", "Program", "Aperture-priority AE", "Shutter speed priority", "Program-shift" });
  }
  
  public String getExposureShiftDescription()
  {
    return f(515);
  }
  
  public String getExtendedWBDetectDescription()
  {
    return a(2306, new String[] { "Off", "On" });
  }
  
  public String getFlashControlModeDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(1028);
    if (arrayOfInt == null) {
      return null;
    }
    if (arrayOfInt.length == 0) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch (arrayOfInt[0])
    {
    case 1: 
    case 2: 
    default: 
      localStringBuilder.append("Unknown (").append(arrayOfInt[0]).append(")");
    }
    for (;;)
    {
      int i = 1;
      while (i < arrayOfInt.length)
      {
        localStringBuilder.append("; ").append(arrayOfInt[i]);
        i += 1;
      }
      localStringBuilder.append("Off");
      continue;
      localStringBuilder.append("TTL");
      continue;
      localStringBuilder.append("Auto");
      continue;
      localStringBuilder.append("Manual");
    }
    return localStringBuilder.toString();
  }
  
  public String getFlashIntensityDescription()
  {
    l[] arrayOfl = ((t)this.a).getRationalArray(1029);
    if ((arrayOfl == null) || (arrayOfl.length == 0)) {
      return null;
    }
    if (arrayOfl.length == 3)
    {
      if ((arrayOfl[0].getDenominator() == 0L) && (arrayOfl[1].getDenominator() == 0L) && (arrayOfl[2].getDenominator() == 0L)) {
        return "n/a";
      }
    }
    else if ((arrayOfl.length == 4) && (arrayOfl[0].getDenominator() == 0L) && (arrayOfl[1].getDenominator() == 0L) && (arrayOfl[2].getDenominator() == 0L) && (arrayOfl[3].getDenominator() == 0L)) {
      return "n/a (x4)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = arrayOfl.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfl[i]).append(", ");
      i += 1;
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 2);
  }
  
  public String getFlashModeDescription()
  {
    Integer localInteger = ((t)this.a).getInteger(1024);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Off";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = localInteger.intValue();
    if ((i & 0x1) != 0) {
      localStringBuilder.append("On, ");
    }
    if ((i >> 1 & 0x1) != 0) {
      localStringBuilder.append("Fill-in, ");
    }
    if ((i >> 2 & 0x1) != 0) {
      localStringBuilder.append("Red-eye, ");
    }
    if ((i >> 3 & 0x1) != 0) {
      localStringBuilder.append("Slow-sync, ");
    }
    if ((i >> 4 & 0x1) != 0) {
      localStringBuilder.append("Forced On, ");
    }
    if ((i >> 5 & 0x1) != 0) {
      localStringBuilder.append("2nd Curtain, ");
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 2);
  }
  
  public String getFlashRemoteControlDescription()
  {
    Integer localInteger = ((t)this.a).getInteger(1027);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    case 1: 
      return "Channel 1, Low";
    case 2: 
      return "Channel 2, Low";
    case 3: 
      return "Channel 3, Low";
    case 4: 
      return "Channel 4, Low";
    case 9: 
      return "Channel 1, Mid";
    case 10: 
      return "Channel 2, Mid";
    case 11: 
      return "Channel 3, Mid";
    case 12: 
      return "Channel 4, Mid";
    case 17: 
      return "Channel 1, High";
    case 18: 
      return "Channel 2, High";
    case 19: 
      return "Channel 3, High";
    }
    return "Channel 4, High";
  }
  
  public String getFocusModeDescription()
  {
    Object localObject2 = ((t)this.a).getIntArray(769);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = ((t)this.a).getInteger(769);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new int[1];
      localObject1[0] = ((Integer)localObject2).intValue();
    }
    if (localObject1.length == 0) {
      return null;
    }
    localObject2 = new StringBuilder();
    int i;
    switch (localObject1[0])
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      ((StringBuilder)localObject2).append("Unknown (" + localObject1[0] + ")");
      if (localObject1.length > 1)
      {
        ((StringBuilder)localObject2).append("; ");
        i = localObject1[1];
        if (i != 0) {
          break label259;
        }
        ((StringBuilder)localObject2).append("(none)");
      }
      break;
    }
    for (;;)
    {
      return ((StringBuilder)localObject2).toString();
      ((StringBuilder)localObject2).append("Single AF");
      break;
      ((StringBuilder)localObject2).append("Sequential shooting AF");
      break;
      ((StringBuilder)localObject2).append("Continuous AF");
      break;
      ((StringBuilder)localObject2).append("Multi AF");
      break;
      ((StringBuilder)localObject2).append("Face detect");
      break;
      ((StringBuilder)localObject2).append("MF");
      break;
      label259:
      if ((i & 0x1) > 0) {
        ((StringBuilder)localObject2).append("S-AF, ");
      }
      if ((i >> 2 & 0x1) > 0) {
        ((StringBuilder)localObject2).append("C-AF, ");
      }
      if ((i >> 4 & 0x1) > 0) {
        ((StringBuilder)localObject2).append("MF, ");
      }
      if ((i >> 5 & 0x1) > 0) {
        ((StringBuilder)localObject2).append("Face detect, ");
      }
      if ((i >> 6 & 0x1) > 0) {
        ((StringBuilder)localObject2).append("Imager AF, ");
      }
      if ((i >> 7 & 0x1) > 0) {
        ((StringBuilder)localObject2).append("Live View Magnification Frame, ");
      }
      if ((i >> 8 & 0x1) > 0) {
        ((StringBuilder)localObject2).append("AF sensor, ");
      }
      ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 2);
    }
  }
  
  public String getFocusProcessDescription()
  {
    Object localObject2 = ((t)this.a).getIntArray(770);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = ((t)this.a).getInteger(770);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new int[1];
      localObject1[0] = ((Integer)localObject2).intValue();
    }
    if (localObject1.length == 0) {
      return null;
    }
    localObject2 = new StringBuilder();
    switch (localObject1[0])
    {
    default: 
      ((StringBuilder)localObject2).append("Unknown (" + localObject1[0] + ")");
    }
    for (;;)
    {
      if (localObject1.length > 1) {
        ((StringBuilder)localObject2).append("; " + localObject1[1]);
      }
      return ((StringBuilder)localObject2).toString();
      ((StringBuilder)localObject2).append("AF not used");
      continue;
      ((StringBuilder)localObject2).append("AF used");
    }
  }
  
  public String getGradationDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(1295);
    Object localObject;
    if ((arrayOfInt == null) || (arrayOfInt.length < 3)) {
      localObject = null;
    }
    String str;
    label193:
    do
    {
      return (String)localObject;
      str = String.format("%d %d %d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(arrayOfInt[2]) });
      if (str.equals("0 0 0")) {
        str = "n/a";
      }
      for (;;)
      {
        localObject = str;
        if (arrayOfInt.length <= 3) {
          break;
        }
        if (arrayOfInt[3] != 0) {
          break label193;
        }
        return str + "; User-Selected";
        if (str.equals("-1 -1 1")) {
          str = "Low Key";
        } else if (str.equals("0 -1 1")) {
          str = "Normal";
        } else if (str.equals("1 -1 1")) {
          str = "High Key";
        } else {
          str = "Unknown (" + str + ")";
        }
      }
      localObject = str;
    } while (arrayOfInt[3] != 1);
    return str + "; Auto-Override";
  }
  
  public String getImageQuality2Description()
  {
    return a(1539, 1, new String[] { "SQ", "HQ", "SHQ", "RAW", "SQ (5)" });
  }
  
  public String getImageStabilizationDescription()
  {
    return a(1540, new String[] { "Off", "On, Mode 1", "On, Mode 2", "On, Mode 3", "On, Mode 4" });
  }
  
  public String getMacroModeDescription()
  {
    return a(768, new String[] { "Off", "On", "Super Macro" });
  }
  
  public String getMagicFilterDescription()
  {
    return i(1324);
  }
  
  public String getManometerPressureDescription()
  {
    Integer localInteger = ((t)this.a).getInteger(2304);
    if (localInteger == null) {
      return null;
    }
    return String.format("%s kPa", new Object[] { new DecimalFormat("#.##").format(localInteger.intValue() / 10.0D) });
  }
  
  public String getManometerReadingDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(2305);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("#.##");
    return String.format("%s m, %s ft", new Object[] { localDecimalFormat.format(arrayOfInt[0] / 10.0D), localDecimalFormat.format(arrayOfInt[1] / 10.0D) });
  }
  
  public String getManualFlashStrengthDescription()
  {
    l[] arrayOfl = ((t)this.a).getRationalArray(1030);
    if ((arrayOfl == null) || (arrayOfl.length == 0)) {
      return "n/a";
    }
    if (arrayOfl.length == 3)
    {
      if ((arrayOfl[0].getDenominator() == 0L) && (arrayOfl[1].getDenominator() == 0L) && (arrayOfl[2].getDenominator() == 0L)) {
        return "n/a";
      }
    }
    else if ((arrayOfl.length == 4) && (arrayOfl[0].getDenominator() == 0L) && (arrayOfl[1].getDenominator() == 0L) && (arrayOfl[2].getDenominator() == 0L) && (arrayOfl[3].getDenominator() == 0L)) {
      return "n/a (x4)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = arrayOfl.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfl[i]).append(", ");
      i += 1;
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 2);
  }
  
  public String getMeteringModeDescription()
  {
    Integer localInteger = ((t)this.a).getInteger(514);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 2: 
      return "Center-weighted average";
    case 3: 
      return "Spot";
    case 5: 
      return "ESP";
    case 261: 
      return "Pattern+AF";
    case 515: 
      return "Spot+Highlight control";
    }
    return "Spot+Shadow control";
  }
  
  public String getModifiedSaturationDescription()
  {
    return a(1284, new String[] { "Off", "CM1 (Red Enhance)", "CM2 (Green Enhance)", "CM3 (Blue Enhance)", "CM4 (Skin Tones)" });
  }
  
  public String getNdFilterDescription()
  {
    return a(516, new String[] { "Off", "On" });
  }
  
  public String getNoiseFilterDescription()
  {
    Object localObject = ((t)this.a).getIntArray(1319);
    if (localObject == null) {
      return null;
    }
    localObject = String.format("%d %d %d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(localObject[2]) });
    if (((String)localObject).equals("0 0 0")) {
      return "n/a";
    }
    if (((String)localObject).equals("-2 -2 1")) {
      return "Off";
    }
    if (((String)localObject).equals("-1 -2 1")) {
      return "Low";
    }
    if (((String)localObject).equals("0 -2 1")) {
      return "Standard";
    }
    if (((String)localObject).equals("1 -2 1")) {
      return "High";
    }
    return "Unknown (" + (String)localObject + ")";
  }
  
  public String getNoiseReductionDescription()
  {
    Integer localInteger = ((t)this.a).getInteger(1290);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "(none)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = localInteger.intValue();
    if ((i & 0x1) != 0) {
      localStringBuilder.append("Noise Reduction, ");
    }
    if ((i >> 1 & 0x1) != 0) {
      localStringBuilder.append("Noise Filter, ");
    }
    if ((i >> 2 & 0x1) != 0) {
      localStringBuilder.append("Noise Filter (ISO Boost), ");
    }
    if ((i >> 3 & 0x1) != 0) {
      localStringBuilder.append("Auto, ");
    }
    if (localStringBuilder.length() != 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - 2);
    }
    return "(none)";
  }
  
  public String getPanoramaModeDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(1537);
    if (arrayOfInt == null) {
      return null;
    }
    if ((arrayOfInt.length == 0) || (arrayOfInt[0] == 0)) {
      return "Off";
    }
    String str;
    switch (arrayOfInt[0])
    {
    default: 
      str = "Unknown (" + arrayOfInt[0] + ")";
    }
    for (;;)
    {
      return String.format("%s, Shot %d", new Object[] { str, Integer.valueOf(arrayOfInt[1]) });
      str = "Left to Right";
      continue;
      str = "Right to Left";
      continue;
      str = "Bottom to Top";
      continue;
      str = "Top to Bottom";
    }
  }
  
  public String getPictureModeBWFilterDescription()
  {
    return a(1317, new String[] { "n/a", "Neutral", "Yellow", "Orange", "Red", "Green" });
  }
  
  public String getPictureModeContrastDescription()
  {
    return h(1315);
  }
  
  public String getPictureModeDescription()
  {
    Object localObject2 = ((t)this.a).getIntArray(1312);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = ((t)this.a).getInteger(1290);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new int[1];
      localObject1[0] = ((Integer)localObject2).intValue();
    }
    if (localObject1.length == 0) {
      return null;
    }
    localObject2 = new StringBuilder();
    switch (localObject1[0])
    {
    default: 
      ((StringBuilder)localObject2).append("Unknown (").append(localObject1[0]).append(")");
    }
    for (;;)
    {
      if (localObject1.length > 1) {
        ((StringBuilder)localObject2).append("; ").append(localObject1[1]);
      }
      return ((StringBuilder)localObject2).toString();
      ((StringBuilder)localObject2).append("Vivid");
      continue;
      ((StringBuilder)localObject2).append("Natural");
      continue;
      ((StringBuilder)localObject2).append("Muted");
      continue;
      ((StringBuilder)localObject2).append("Portrait");
      continue;
      ((StringBuilder)localObject2).append("i-Enhance");
      continue;
      ((StringBuilder)localObject2).append("Monotone");
      continue;
      ((StringBuilder)localObject2).append("Sepia");
    }
  }
  
  public String getPictureModeEffectDescription()
  {
    Object localObject = ((t)this.a).getIntArray(1325);
    if (localObject == null) {
      return null;
    }
    localObject = String.format("%d %d %d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(localObject[2]) });
    if (((String)localObject).equals("0 0 0")) {
      return "n/a";
    }
    if (((String)localObject).equals("-1 -1 1")) {
      return "Low";
    }
    if (((String)localObject).equals("0 -1 1")) {
      return "Standard";
    }
    if (((String)localObject).equals("1 -1 1")) {
      return "High";
    }
    return "Unknown (" + (String)localObject + ")";
  }
  
  public String getPictureModeSaturationDescription()
  {
    return h(1313);
  }
  
  public String getPictureModeSharpnessDescription()
  {
    return h(1316);
  }
  
  public String getPictureModeToneDescription()
  {
    return a(1318, new String[] { "n/a", "Neutral", "Sepia", "Blue", "Purple", "Green" });
  }
  
  public String getPitchAngleDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(2308);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    if (arrayOfInt[0] != 0) {}
    for (String str = Double.toString(arrayOfInt[0] / 10.0D);; str = "n/a") {
      return String.format("%s %d", new Object[] { str, Integer.valueOf(arrayOfInt[1]) });
    }
  }
  
  public String getPreviewImageValidDescription()
  {
    return a(256, new String[] { "No", "Yes" });
  }
  
  public String getRollAngleDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(2307);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    if (arrayOfInt[0] != 0) {}
    for (String str = Double.toString(-arrayOfInt[0] / 10.0D);; str = "n/a") {
      return String.format("%s %d", new Object[] { str, Integer.valueOf(arrayOfInt[1]) });
    }
  }
  
  public String getSceneModeDescription()
  {
    Integer localInteger = ((t)this.a).getInteger(1289);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Standard";
    case 6: 
      return "Auto";
    case 7: 
      return "Sport";
    case 8: 
      return "Portrait";
    case 9: 
      return "Landscape+Portrait";
    case 10: 
      return "Landscape";
    case 11: 
      return "Night Scene";
    case 12: 
      return "Self Portrait";
    case 13: 
      return "Panorama";
    case 14: 
      return "2 in 1";
    case 15: 
      return "Movie";
    case 16: 
      return "Landscape+Portrait";
    case 17: 
      return "Night+Portrait";
    case 18: 
      return "Indoor";
    case 19: 
      return "Fireworks";
    case 20: 
      return "Sunset";
    case 21: 
      return "Beauty Skin";
    case 22: 
      return "Macro";
    case 23: 
      return "Super Macro";
    case 24: 
      return "Food";
    case 25: 
      return "Documents";
    case 26: 
      return "Museum";
    case 27: 
      return "Shoot & Select";
    case 28: 
      return "Beach & Snow";
    case 29: 
      return "Self Portrait+Timer";
    case 30: 
      return "Candle";
    case 31: 
      return "Available Light";
    case 32: 
      return "Behind Glass";
    case 33: 
      return "My Mode";
    case 34: 
      return "Pet";
    case 35: 
      return "Underwater Wide1";
    case 36: 
      return "Underwater Macro";
    case 37: 
      return "Shoot & Select1";
    case 38: 
      return "Shoot & Select2";
    case 39: 
      return "High Key";
    case 40: 
      return "Digital Image Stabilization";
    case 41: 
      return "Auction";
    case 42: 
      return "Beach";
    case 43: 
      return "Snow";
    case 44: 
      return "Underwater Wide2";
    case 45: 
      return "Low Key";
    case 46: 
      return "Children";
    case 47: 
      return "Vivid";
    case 48: 
      return "Nature Macro";
    case 49: 
      return "Underwater Snapshot";
    case 50: 
      return "Shooting Guide";
    case 54: 
      return "Face Portrait";
    case 57: 
      return "Bulb";
    case 59: 
      return "Smile Shot";
    case 60: 
      return "Quick Shutter";
    case 63: 
      return "Slow Shutter";
    case 64: 
      return "Bird Watching";
    case 65: 
      return "Multiple Exposure";
    case 66: 
      return "e-Portrait";
    case 67: 
      return "Soft Background Shot";
    case 142: 
      return "Hand-held Starlight";
    }
    return "HDR";
  }
  
  public String getShadingCompensationDescription()
  {
    return a(1292, new String[] { "Off", "On" });
  }
  
  public String getSharpnessSettingDescription()
  {
    return h(1286);
  }
  
  public String getStackedImageDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(2052);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if ((i == 0) && (j == 0)) {
      return "No";
    }
    if ((i == 9) && (j == 8)) {
      return "Focus-stacked (8 images)";
    }
    return String.format("Unknown (%d %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
  }
  
  public String getToneLevelDescription()
  {
    int[] arrayOfInt = ((t)this.a).getIntArray(1326);
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < arrayOfInt.length)
    {
      if (i == 1) {
        localStringBuilder.append("Highlights ");
      }
      for (;;)
      {
        localStringBuilder.append(arrayOfInt[i]).append("; ");
        i += 1;
        break;
        if (i == 5) {
          localStringBuilder.append("Shadows ");
        }
      }
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 2);
  }
  
  public String getWhiteBalance2Description()
  {
    Integer localInteger = ((t)this.a).getInteger(1280);
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
      return "Auto (Keep Warm Color Off)";
    case 16: 
      return "7500K (Fine Weather with Shade)";
    case 17: 
      return "6000K (Cloudy)";
    case 18: 
      return "5300K (Fine Weather)";
    case 20: 
      return "3000K (Tungsten light)";
    case 21: 
      return "3600K (Tungsten light-like)";
    case 22: 
      return "Auto Setup";
    case 23: 
      return "5500K (Flash)";
    case 33: 
      return "6600K (Daylight fluorescent)";
    case 34: 
      return "4500K (Neutral white fluorescent)";
    case 35: 
      return "4000K (Cool white fluorescent)";
    case 36: 
      return "White Fluorescent";
    case 48: 
      return "3600K (Tungsten light-like)";
    case 67: 
      return "Underwater";
    case 256: 
      return "One Touch WB 1";
    case 257: 
      return "One Touch WB 2";
    case 258: 
      return "One Touch WB 3";
    case 259: 
      return "One Touch WB 4";
    case 512: 
      return "Custom WB 1";
    case 513: 
      return "Custom WB 2";
    case 514: 
      return "Custom WB 3";
    }
    return "Custom WB 4";
  }
  
  public String getWhiteBalanceTemperatureDescription()
  {
    Integer localInteger = ((t)this.a).getInteger(1281);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Auto";
    }
    return localInteger.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */