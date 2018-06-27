package com.b.c.c;

import com.b.a.e;
import com.b.b.l;
import com.b.c.b;
import com.b.c.g;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class a<T extends b>
  extends g<T>
{
  private static final DecimalFormat d = new DecimalFormat("0.#");
  private final boolean c = true;
  
  public a(T paramT)
  {
    super(paramT);
  }
  
  private String h(int paramInt)
  {
    Object localObject = this.a.getByteArray(paramInt);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = new String((byte[])localObject, "UTF-16LE").trim();
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
  
  public String get35mmFilmEquivFocalLengthDescription()
  {
    Integer localInteger = this.a.getInteger(41989);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Unknown";
    }
    return b(localInteger.intValue());
  }
  
  public String getApertureValueDescription()
  {
    Double localDouble = this.a.getDoubleObject(37378);
    if (localDouble == null) {
      return null;
    }
    return a(e.apertureToFStop(localDouble.doubleValue()));
  }
  
  public String getBitsPerSampleDescription()
  {
    String str = this.a.getString(258);
    if (str == null) {
      return null;
    }
    return str + " bits/component/pixel";
  }
  
  public String getColorSpaceDescription()
  {
    Integer localInteger = this.a.getInteger(40961);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 1) {
      return "sRGB";
    }
    if (localInteger.intValue() == 65535) {
      return "Undefined";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String getComponentConfigurationDescription()
  {
    int i = 0;
    int[] arrayOfInt = this.a.getIntArray(37121);
    if (arrayOfInt == null) {
      return null;
    }
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "";
    arrayOfString[1] = "Y";
    arrayOfString[2] = "Cb";
    arrayOfString[3] = "Cr";
    arrayOfString[4] = "R";
    arrayOfString[5] = "G";
    arrayOfString[6] = "B";
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < Math.min(4, arrayOfInt.length))
    {
      int j = arrayOfInt[i];
      if ((j > 0) && (j < arrayOfString.length)) {
        localStringBuilder.append(arrayOfString[j]);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String getCompressedAverageBitsPerPixelDescription()
  {
    l locall = this.a.getRational(37122);
    if (locall == null) {
      return null;
    }
    String str = locall.toSimpleString(true);
    if ((locall.isInteger()) && (locall.intValue() == 1)) {
      return str + " bit/pixel";
    }
    return str + " bits/pixel";
  }
  
  public String getCompressionDescription()
  {
    Integer localInteger = this.a.getInteger(259);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Uncompressed";
    case 2: 
      return "CCITT 1D";
    case 3: 
      return "T4/Group 3 Fax";
    case 4: 
      return "T6/Group 4 Fax";
    case 5: 
      return "LZW";
    case 6: 
      return "JPEG (old-style)";
    case 7: 
      return "JPEG";
    case 8: 
      return "Adobe Deflate";
    case 9: 
      return "JBIG B&W";
    case 10: 
      return "JBIG Color";
    case 99: 
      return "JPEG";
    case 262: 
      return "Kodak 262";
    case 32766: 
      return "Next";
    case 32767: 
      return "Sony ARW Compressed";
    case 32769: 
      return "Packed RAW";
    case 32770: 
      return "Samsung SRW Compressed";
    case 32771: 
      return "CCIRLEW";
    case 32772: 
      return "Samsung SRW Compressed 2";
    case 32773: 
      return "PackBits";
    case 32809: 
      return "Thunderscan";
    case 32867: 
      return "Kodak KDC Compressed";
    case 32895: 
      return "IT8CTPAD";
    case 32896: 
      return "IT8LW";
    case 32897: 
      return "IT8MP";
    case 32898: 
      return "IT8BL";
    case 32908: 
      return "PixarFilm";
    case 32909: 
      return "PixarLog";
    case 32946: 
      return "Deflate";
    case 32947: 
      return "DCS";
    case 34661: 
      return "JBIG";
    case 34676: 
      return "SGILog";
    case 34677: 
      return "SGILog24";
    case 34712: 
      return "JPEG 2000";
    case 34713: 
      return "Nikon NEF Compressed";
    case 34715: 
      return "JBIG2 TIFF FX";
    case 34718: 
      return "Microsoft Document Imaging (MDI) Binary Level Codec";
    case 34719: 
      return "Microsoft Document Imaging (MDI) Progressive Transform Codec";
    case 34720: 
      return "Microsoft Document Imaging (MDI) Vector";
    case 34892: 
      return "Lossy JPEG";
    case 65000: 
      return "Kodak DCR Compressed";
    }
    return "Pentax PEF Compressed";
  }
  
  public String getContrastDescription()
  {
    return a(41992, new String[] { "None", "Soft", "Hard" });
  }
  
  public String getCustomRenderedDescription()
  {
    return a(41985, new String[] { "Normal process", "Custom process" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return getInteropIndexDescription();
    case 2: 
      return getInteropVersionDescription();
    case 274: 
      return getOrientationDescription();
    case 296: 
      return getResolutionDescription();
    case 531: 
      return getYCbCrPositioningDescription();
    case 282: 
      return getXResolutionDescription();
    case 283: 
      return getYResolutionDescription();
    case 256: 
      return getImageWidthDescription();
    case 257: 
      return getImageHeightDescription();
    case 258: 
      return getBitsPerSampleDescription();
    case 262: 
      return getPhotometricInterpretationDescription();
    case 278: 
      return getRowsPerStripDescription();
    case 279: 
      return getStripByteCountsDescription();
    case 277: 
      return getSamplesPerPixelDescription();
    case 284: 
      return getPlanarConfigurationDescription();
    case 530: 
      return getYCbCrSubsamplingDescription();
    case 532: 
      return getReferenceBlackWhiteDescription();
    case 40093: 
      return getWindowsAuthorDescription();
    case 40092: 
      return getWindowsCommentDescription();
    case 40094: 
      return getWindowsKeywordsDescription();
    case 40095: 
      return getWindowsSubjectDescription();
    case 40091: 
      return getWindowsTitleDescription();
    case 254: 
      return getNewSubfileTypeDescription();
    case 255: 
      return getSubfileTypeDescription();
    case 263: 
      return getThresholdingDescription();
    case 266: 
      return getFillOrderDescription();
    case 33434: 
      return getExposureTimeDescription();
    case 37377: 
      return getShutterSpeedDescription();
    case 33437: 
      return getFNumberDescription();
    case 37122: 
      return getCompressedAverageBitsPerPixelDescription();
    case 37382: 
      return getSubjectDistanceDescription();
    case 37383: 
      return getMeteringModeDescription();
    case 37384: 
      return getWhiteBalanceDescription();
    case 37385: 
      return getFlashDescription();
    case 37386: 
      return getFocalLengthDescription();
    case 40961: 
      return getColorSpaceDescription();
    case 40962: 
      return getExifImageWidthDescription();
    case 40963: 
      return getExifImageHeightDescription();
    case 41488: 
      return getFocalPlaneResolutionUnitDescription();
    case 41486: 
      return getFocalPlaneXResolutionDescription();
    case 41487: 
      return getFocalPlaneYResolutionDescription();
    case 34850: 
      return getExposureProgramDescription();
    case 37378: 
      return getApertureValueDescription();
    case 37381: 
      return getMaxApertureValueDescription();
    case 41495: 
      return getSensingMethodDescription();
    case 37380: 
      return getExposureBiasDescription();
    case 41728: 
      return getFileSourceDescription();
    case 41729: 
      return getSceneTypeDescription();
    case 37121: 
      return getComponentConfigurationDescription();
    case 36864: 
      return getExifVersionDescription();
    case 40960: 
      return getFlashPixVersionDescription();
    case 34855: 
      return getIsoEquivalentDescription();
    case 37510: 
      return getUserCommentDescription();
    case 41985: 
      return getCustomRenderedDescription();
    case 41986: 
      return getExposureModeDescription();
    case 41987: 
      return getWhiteBalanceModeDescription();
    case 41988: 
      return getDigitalZoomRatioDescription();
    case 41989: 
      return get35mmFilmEquivFocalLengthDescription();
    case 41990: 
      return getSceneCaptureTypeDescription();
    case 41991: 
      return getGainControlDescription();
    case 41992: 
      return getContrastDescription();
    case 41993: 
      return getSaturationDescription();
    case 41994: 
      return getSharpnessDescription();
    case 41996: 
      return getSubjectDistanceRangeDescription();
    case 34864: 
      return getSensitivityTypeRangeDescription();
    case 259: 
      return getCompressionDescription();
    case 512: 
      return getJpegProcDescription();
    }
    return getLensSpecificationDescription();
  }
  
  public String getDigitalZoomRatioDescription()
  {
    l locall = this.a.getRational(41988);
    if (locall == null) {
      return null;
    }
    if (locall.getNumerator() == 0L) {
      return "Digital zoom not used";
    }
    return d.format(locall.doubleValue());
  }
  
  public String getExifImageHeightDescription()
  {
    Integer localInteger = this.a.getInteger(40963);
    if (localInteger == null) {
      return null;
    }
    return localInteger + " pixels";
  }
  
  public String getExifImageWidthDescription()
  {
    Integer localInteger = this.a.getInteger(40962);
    if (localInteger == null) {
      return null;
    }
    return localInteger + " pixels";
  }
  
  public String getExifVersionDescription()
  {
    return a(36864, 2);
  }
  
  public String getExposureBiasDescription()
  {
    l locall = this.a.getRational(37380);
    if (locall == null) {
      return null;
    }
    return locall.toSimpleString(true) + " EV";
  }
  
  public String getExposureModeDescription()
  {
    return a(41986, new String[] { "Auto exposure", "Manual exposure", "Auto bracket" });
  }
  
  public String getExposureProgramDescription()
  {
    return a(34850, 1, new String[] { "Manual control", "Program normal", "Aperture priority", "Shutter priority", "Program creative (slow program)", "Program action (high-speed program)", "Portrait mode", "Landscape mode" });
  }
  
  public String getExposureTimeDescription()
  {
    String str = this.a.getString(33434);
    if (str == null) {
      return null;
    }
    return str + " sec";
  }
  
  public String getFNumberDescription()
  {
    l locall = this.a.getRational(33437);
    if (locall == null) {
      return null;
    }
    return a(locall.doubleValue());
  }
  
  public String getFileSourceDescription()
  {
    return a(41728, 1, new String[] { "Film Scanner", "Reflection Print Scanner", "Digital Still Camera (DSC)" });
  }
  
  public String getFillOrderDescription()
  {
    return a(266, 1, new String[] { "Normal", "Reversed" });
  }
  
  public String getFlashDescription()
  {
    Integer localInteger = this.a.getInteger(37385);
    if (localInteger == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localInteger.intValue() & 0x1) != 0)
    {
      localStringBuilder.append("Flash fired");
      if ((localInteger.intValue() & 0x4) != 0)
      {
        if ((localInteger.intValue() & 0x2) == 0) {
          break label120;
        }
        localStringBuilder.append(", return detected");
      }
    }
    for (;;)
    {
      if ((localInteger.intValue() & 0x10) != 0) {
        localStringBuilder.append(", auto");
      }
      if ((localInteger.intValue() & 0x40) != 0) {
        localStringBuilder.append(", red-eye reduction");
      }
      return localStringBuilder.toString();
      localStringBuilder.append("Flash did not fire");
      break;
      label120:
      localStringBuilder.append(", return not detected");
    }
  }
  
  public String getFlashPixVersionDescription()
  {
    return a(40960, 2);
  }
  
  public String getFocalLengthDescription()
  {
    l locall = this.a.getRational(37386);
    if (locall == null) {
      return null;
    }
    return b(locall.doubleValue());
  }
  
  public String getFocalPlaneResolutionUnitDescription()
  {
    return a(41488, 1, new String[] { "(No unit)", "Inches", "cm" });
  }
  
  public String getFocalPlaneXResolutionDescription()
  {
    Object localObject = this.a.getRational(41486);
    if (localObject == null) {
      return null;
    }
    String str = getFocalPlaneResolutionUnitDescription();
    localObject = new StringBuilder().append(((l)localObject).getReciprocal().toSimpleString(true));
    if (str == null) {}
    for (str = "";; str = " " + str.toLowerCase()) {
      return str;
    }
  }
  
  public String getFocalPlaneYResolutionDescription()
  {
    Object localObject = this.a.getRational(41487);
    if (localObject == null) {
      return null;
    }
    String str = getFocalPlaneResolutionUnitDescription();
    localObject = new StringBuilder().append(((l)localObject).getReciprocal().toSimpleString(true));
    if (str == null) {}
    for (str = "";; str = " " + str.toLowerCase()) {
      return str;
    }
  }
  
  public String getGainControlDescription()
  {
    return a(41991, new String[] { "None", "Low gain up", "Low gain down", "High gain up", "High gain down" });
  }
  
  public String getImageHeightDescription()
  {
    String str = this.a.getString(257);
    if (str == null) {
      return null;
    }
    return str + " pixels";
  }
  
  public String getImageWidthDescription()
  {
    String str = this.a.getString(256);
    if (str == null) {
      return null;
    }
    return str + " pixels";
  }
  
  public String getInteropIndexDescription()
  {
    String str = this.a.getString(1);
    if (str == null) {
      return null;
    }
    if ("R98".equalsIgnoreCase(str.trim())) {
      return "Recommended Exif Interoperability Rules (ExifR98)";
    }
    return "Unknown (" + str + ")";
  }
  
  public String getInteropVersionDescription()
  {
    return a(2, 2);
  }
  
  public String getIsoEquivalentDescription()
  {
    Integer localInteger = this.a.getInteger(34855);
    if (localInteger != null) {
      return Integer.toString(localInteger.intValue());
    }
    return null;
  }
  
  public String getJpegProcDescription()
  {
    Integer localInteger = this.a.getInteger(512);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Baseline";
    }
    return "Lossless";
  }
  
  public String getLensSpecificationDescription()
  {
    return g(42034);
  }
  
  public String getMaxApertureValueDescription()
  {
    Double localDouble = this.a.getDoubleObject(37381);
    if (localDouble == null) {
      return null;
    }
    return a(e.apertureToFStop(localDouble.doubleValue()));
  }
  
  public String getMeteringModeDescription()
  {
    Integer localInteger = this.a.getInteger(37383);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Unknown";
    case 1: 
      return "Average";
    case 2: 
      return "Center weighted average";
    case 3: 
      return "Spot";
    case 4: 
      return "Multi-spot";
    case 5: 
      return "Multi-segment";
    case 6: 
      return "Partial";
    }
    return "(Other)";
  }
  
  public String getNewSubfileTypeDescription()
  {
    return a(254, 1, new String[] { "Full-resolution image", "Reduced-resolution image", "Single page of multi-page reduced-resolution image", "Transparency mask", "Transparency mask of reduced-resolution image", "Transparency mask of multi-page image", "Transparency mask of reduced-resolution multi-page image" });
  }
  
  public String getOrientationDescription()
  {
    return a(274, 1, new String[] { "Top, left side (Horizontal / normal)", "Top, right side (Mirror horizontal)", "Bottom, right side (Rotate 180)", "Bottom, left side (Mirror vertical)", "Left side, top (Mirror horizontal and rotate 270 CW)", "Right side, top (Rotate 90 CW)", "Right side, bottom (Mirror horizontal and rotate 90 CW)", "Left side, bottom (Rotate 270 CW)" });
  }
  
  public String getPhotometricInterpretationDescription()
  {
    Integer localInteger = this.a.getInteger(262);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown colour space";
    case 0: 
      return "WhiteIsZero";
    case 1: 
      return "BlackIsZero";
    case 2: 
      return "RGB";
    case 3: 
      return "RGB Palette";
    case 4: 
      return "Transparency Mask";
    case 5: 
      return "CMYK";
    case 6: 
      return "YCbCr";
    case 8: 
      return "CIELab";
    case 9: 
      return "ICCLab";
    case 10: 
      return "ITULab";
    case 32803: 
      return "Color Filter Array";
    case 32844: 
      return "Pixar LogL";
    case 32845: 
      return "Pixar LogLuv";
    }
    return "Linear Raw";
  }
  
  public String getPlanarConfigurationDescription()
  {
    return a(284, 1, new String[] { "Chunky (contiguous for each subsampling pixel)", "Separate (Y-plane/Cb-plane/Cr-plane format)" });
  }
  
  public String getReferenceBlackWhiteDescription()
  {
    int[] arrayOfInt = this.a.getIntArray(532);
    if ((arrayOfInt == null) || (arrayOfInt.length < 6)) {
      return null;
    }
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[2];
    int m = arrayOfInt[3];
    return String.format("[%d,%d,%d] [%d,%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(arrayOfInt[4]), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(arrayOfInt[5]) });
  }
  
  public String getResolutionDescription()
  {
    return a(296, 1, new String[] { "(No unit)", "Inch", "cm" });
  }
  
  public String getRowsPerStripDescription()
  {
    String str = this.a.getString(278);
    if (str == null) {
      return null;
    }
    return str + " rows/strip";
  }
  
  public String getSamplesPerPixelDescription()
  {
    String str = this.a.getString(277);
    if (str == null) {
      return null;
    }
    return str + " samples/pixel";
  }
  
  public String getSaturationDescription()
  {
    return a(41993, new String[] { "None", "Low saturation", "High saturation" });
  }
  
  public String getSceneCaptureTypeDescription()
  {
    return a(41990, new String[] { "Standard", "Landscape", "Portrait", "Night scene" });
  }
  
  public String getSceneTypeDescription()
  {
    return a(41729, 1, new String[] { "Directly photographed image" });
  }
  
  public String getSensingMethodDescription()
  {
    return a(41495, 1, new String[] { "(Not defined)", "One-chip color area sensor", "Two-chip color area sensor", "Three-chip color area sensor", "Color sequential area sensor", null, "Trilinear sensor", "Color sequential linear sensor" });
  }
  
  public String getSensitivityTypeRangeDescription()
  {
    return a(34864, new String[] { "Unknown", "Standard Output Sensitivity", "Recommended Exposure Index", "ISO Speed", "Standard Output Sensitivity and Recommended Exposure Index", "Standard Output Sensitivity and ISO Speed", "Recommended Exposure Index and ISO Speed", "Standard Output Sensitivity, Recommended Exposure Index and ISO Speed" });
  }
  
  public String getSharpnessDescription()
  {
    return a(41994, new String[] { "None", "Low", "Hard" });
  }
  
  public String getShutterSpeedDescription()
  {
    Object localObject = this.a.getFloatObject(37377);
    if (localObject == null) {
      return null;
    }
    if (((Float)localObject).floatValue() <= 1.0F)
    {
      float f = (float)Math.round((float)(1.0D / Math.exp(((Float)localObject).floatValue() * Math.log(2.0D))) * 10.0D) / 10.0F;
      localObject = new DecimalFormat("0.##");
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      return ((DecimalFormat)localObject).format(f) + " sec";
    }
    int i = (int)Math.exp(((Float)localObject).floatValue() * Math.log(2.0D));
    return "1/" + i + " sec";
  }
  
  public String getStripByteCountsDescription()
  {
    String str = this.a.getString(279);
    if (str == null) {
      return null;
    }
    return str + " bytes";
  }
  
  public String getSubfileTypeDescription()
  {
    return a(255, 1, new String[] { "Full-resolution image", "Reduced-resolution image", "Single page of multi-page image" });
  }
  
  public String getSubjectDistanceDescription()
  {
    l locall = this.a.getRational(37382);
    if (locall == null) {
      return null;
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0##");
    return localDecimalFormat.format(locall.doubleValue()) + " metres";
  }
  
  public String getSubjectDistanceRangeDescription()
  {
    return a(41996, new String[] { "Unknown", "Macro", "Close view", "Distant view" });
  }
  
  public String getThresholdingDescription()
  {
    return a(263, 1, new String[] { "No dithering or halftoning", "Ordered dither or halftone", "Randomized dither" });
  }
  
  public String getUserCommentDescription()
  {
    Object localObject1 = this.a.getByteArray(37510);
    if (localObject1 == null) {
      return null;
    }
    if (localObject1.length == 0) {
      return "";
    }
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("ASCII", System.getProperty("file.encoding"));
    ((Map)localObject2).put("UNICODE", "UTF-16LE");
    ((Map)localObject2).put("JIS", "Shift-JIS");
    for (;;)
    {
      int i;
      try
      {
        if (localObject1.length >= 10)
        {
          String str1 = new String((byte[])localObject1, 0, 10);
          localObject2 = ((Map)localObject2).entrySet().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
            String str2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (String)((Map.Entry)localObject3).getValue();
            if (!str1.startsWith(str2)) {
              continue;
            }
            i = str2.length();
            if (i < 10)
            {
              int j = localObject1[i];
              if ((j == 0) || (j == 32)) {
                break label257;
              }
              return new String((byte[])localObject1, i, localObject1.length - i, (String)localObject3).trim();
            }
            return new String((byte[])localObject1, 10, localObject1.length - 10, (String)localObject3).trim();
          }
        }
        localObject1 = new String((byte[])localObject1, System.getProperty("file.encoding")).trim();
        return (String)localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        return null;
      }
      label257:
      i += 1;
    }
  }
  
  public String getWhiteBalanceDescription()
  {
    Integer localInteger = this.a.getInteger(37384);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Unknown";
    case 1: 
      return "Daylight";
    case 2: 
      return "Florescent";
    case 3: 
      return "Tungsten";
    case 4: 
      return "Flash";
    case 9: 
      return "Fine Weather";
    case 10: 
      return "Cloudy";
    case 11: 
      return "Shade";
    case 12: 
      return "Daylight Fluorescent";
    case 13: 
      return "Day White Fluorescent";
    case 14: 
      return "Cool White Fluorescent";
    case 15: 
      return "White Fluorescent";
    case 16: 
      return "Warm White Fluorescent";
    case 17: 
      return "Standard light";
    case 18: 
      return "Standard light (B)";
    case 19: 
      return "Standard light (C)";
    case 20: 
      return "D55";
    case 21: 
      return "D65";
    case 22: 
      return "D75";
    case 23: 
      return "D50";
    case 24: 
      return "Studio Tungsten";
    }
    return "(Other)";
  }
  
  public String getWhiteBalanceModeDescription()
  {
    return a(41987, new String[] { "Auto white balance", "Manual white balance" });
  }
  
  public String getWindowsAuthorDescription()
  {
    return h(40093);
  }
  
  public String getWindowsCommentDescription()
  {
    return h(40092);
  }
  
  public String getWindowsKeywordsDescription()
  {
    return h(40094);
  }
  
  public String getWindowsSubjectDescription()
  {
    return h(40095);
  }
  
  public String getWindowsTitleDescription()
  {
    return h(40091);
  }
  
  public String getXResolutionDescription()
  {
    Object localObject = this.a.getRational(282);
    if (localObject == null) {
      return null;
    }
    String str = getResolutionDescription();
    localObject = ((l)localObject).toSimpleString(true);
    if (str == null) {}
    for (str = "unit";; str = str.toLowerCase()) {
      return String.format("%s dots per %s", new Object[] { localObject, str });
    }
  }
  
  public String getYCbCrPositioningDescription()
  {
    return a(531, 1, new String[] { "Center of pixel array", "Datum point" });
  }
  
  public String getYCbCrSubsamplingDescription()
  {
    int[] arrayOfInt = this.a.getIntArray(530);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    if ((arrayOfInt[0] == 2) && (arrayOfInt[1] == 1)) {
      return "YCbCr4:2:2";
    }
    if ((arrayOfInt[0] == 2) && (arrayOfInt[1] == 2)) {
      return "YCbCr4:2:0";
    }
    return "(Unknown)";
  }
  
  public String getYResolutionDescription()
  {
    Object localObject = this.a.getRational(283);
    if (localObject == null) {
      return null;
    }
    String str = getResolutionDescription();
    localObject = ((l)localObject).toSimpleString(true);
    if (str == null) {}
    for (str = "unit";; str = str.toLowerCase()) {
      return String.format("%s dots per %s", new Object[] { localObject, str });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */