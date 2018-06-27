package com.b.c.c.a;

import com.b.c.g;

public class e
  extends g<f>
{
  public e(f paramf)
  {
    super(paramf);
  }
  
  public String getCasioPreviewThumbnailDescription()
  {
    byte[] arrayOfByte = ((f)this.a).getByteArray(8192);
    if (arrayOfByte == null) {
      return null;
    }
    return "<" + arrayOfByte.length + " bytes of image data>";
  }
  
  public String getCcdIsoSensitivityDescription()
  {
    return a(12308, new String[] { "Off", "On" });
  }
  
  public String getColourModeDescription()
  {
    return a(12309, new String[] { "Off" });
  }
  
  public String getContrastDescription()
  {
    return a(32, new String[] { "-1", "Normal", "+1" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 2: 
      return getThumbnailDimensionsDescription();
    case 3: 
      return getThumbnailSizeDescription();
    case 4: 
      return getThumbnailOffsetDescription();
    case 8: 
      return getQualityModeDescription();
    case 9: 
      return getImageSizeDescription();
    case 13: 
      return getFocusMode1Description();
    case 20: 
      return getIsoSensitivityDescription();
    case 25: 
      return getWhiteBalance1Description();
    case 29: 
      return getFocalLengthDescription();
    case 31: 
      return getSaturationDescription();
    case 32: 
      return getContrastDescription();
    case 33: 
      return getSharpnessDescription();
    case 3584: 
      return getPrintImageMatchingInfoDescription();
    case 8192: 
      return getCasioPreviewThumbnailDescription();
    case 8209: 
      return getWhiteBalanceBiasDescription();
    case 8210: 
      return getWhiteBalance2Description();
    case 8226: 
      return getObjectDistanceDescription();
    case 8244: 
      return getFlashDistanceDescription();
    case 12288: 
      return getRecordModeDescription();
    case 12289: 
      return getSelfTimerDescription();
    case 12290: 
      return getQualityDescription();
    case 12291: 
      return getFocusMode2Description();
    case 12294: 
      return getTimeZoneDescription();
    case 12308: 
      return getCcdIsoSensitivityDescription();
    case 12309: 
      return getColourModeDescription();
    case 12310: 
      return getEnhancementDescription();
    }
    return getFilterDescription();
  }
  
  public String getEnhancementDescription()
  {
    return a(12310, new String[] { "Off" });
  }
  
  public String getFilterDescription()
  {
    return a(12311, new String[] { "Off" });
  }
  
  public String getFlashDistanceDescription()
  {
    return a(8244, new String[] { "Off" });
  }
  
  public String getFocalLengthDescription()
  {
    Double localDouble = ((f)this.a).getDoubleObject(29);
    if (localDouble == null) {
      return null;
    }
    return b(localDouble.doubleValue() / 10.0D);
  }
  
  public String getFocusMode1Description()
  {
    return a(13, new String[] { "Normal", "Macro" });
  }
  
  public String getFocusMode2Description()
  {
    Integer localInteger = ((f)this.a).getInteger(12291);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Fixation";
    }
    return "Multi-Area Focus";
  }
  
  public String getImageSizeDescription()
  {
    Integer localInteger = ((f)this.a).getInteger(9);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "640 x 480 pixels";
    case 4: 
      return "1600 x 1200 pixels";
    case 5: 
      return "2048 x 1536 pixels";
    case 20: 
      return "2288 x 1712 pixels";
    case 21: 
      return "2592 x 1944 pixels";
    case 22: 
      return "2304 x 1728 pixels";
    }
    return "3008 x 2008 pixels";
  }
  
  public String getIsoSensitivityDescription()
  {
    Integer localInteger = ((f)this.a).getInteger(20);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 3: 
      return "50";
    case 4: 
      return "64";
    case 6: 
      return "100";
    }
    return "200";
  }
  
  public String getObjectDistanceDescription()
  {
    Integer localInteger = ((f)this.a).getInteger(8226);
    if (localInteger == null) {
      return null;
    }
    return Integer.toString(localInteger.intValue()) + " mm";
  }
  
  public String getPrintImageMatchingInfoDescription()
  {
    return ((f)this.a).getString(3584);
  }
  
  public String getQualityDescription()
  {
    return a(12290, 3, new String[] { "Fine" });
  }
  
  public String getQualityModeDescription()
  {
    return a(8, 1, new String[] { "Fine", "Super Fine" });
  }
  
  public String getRecordModeDescription()
  {
    return a(12288, 2, new String[] { "Normal" });
  }
  
  public String getSaturationDescription()
  {
    return a(31, new String[] { "-1", "Normal", "+1" });
  }
  
  public String getSelfTimerDescription()
  {
    return a(12289, 1, new String[] { "Off" });
  }
  
  public String getSharpnessDescription()
  {
    return a(33, new String[] { "-1", "Normal", "+1" });
  }
  
  public String getThumbnailDimensionsDescription()
  {
    int[] arrayOfInt = ((f)this.a).getIntArray(2);
    if ((arrayOfInt == null) || (arrayOfInt.length != 2)) {
      return ((f)this.a).getString(2);
    }
    return arrayOfInt[0] + " x " + arrayOfInt[1] + " pixels";
  }
  
  public String getThumbnailOffsetDescription()
  {
    return ((f)this.a).getString(4);
  }
  
  public String getThumbnailSizeDescription()
  {
    Integer localInteger = ((f)this.a).getInteger(3);
    if (localInteger == null) {
      return null;
    }
    return Integer.toString(localInteger.intValue()) + " bytes";
  }
  
  public String getTimeZoneDescription()
  {
    return ((f)this.a).getString(12294);
  }
  
  public String getWhiteBalance1Description()
  {
    return a(25, new String[] { "Auto", "Daylight", "Shade", "Tungsten", "Florescent", "Manual" });
  }
  
  public String getWhiteBalance2Description()
  {
    Integer localInteger = ((f)this.a).getInteger(8210);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Manual";
    case 1: 
      return "Auto";
    case 4: 
      return "Flash";
    }
    return "Flash";
  }
  
  public String getWhiteBalanceBiasDescription()
  {
    return ((f)this.a).getString(8209);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */