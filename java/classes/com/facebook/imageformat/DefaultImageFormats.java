package com.facebook.imageformat;

import com.facebook.common.internal.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class DefaultImageFormats
{
  public static final ImageFormat BMP;
  public static final ImageFormat GIF;
  public static final ImageFormat JPEG = new ImageFormat("JPEG", "jpeg");
  public static final ImageFormat PNG = new ImageFormat("PNG", "png");
  public static final ImageFormat WEBP_ANIMATED = new ImageFormat("WEBP_ANIMATED", "webp");
  public static final ImageFormat WEBP_EXTENDED;
  public static final ImageFormat WEBP_EXTENDED_WITH_ALPHA;
  public static final ImageFormat WEBP_LOSSLESS;
  public static final ImageFormat WEBP_SIMPLE;
  private static ImmutableList<ImageFormat> sAllDefaultFormats;
  
  static
  {
    GIF = new ImageFormat("GIF", "gif");
    BMP = new ImageFormat("BMP", "bmp");
    WEBP_SIMPLE = new ImageFormat("WEBP_SIMPLE", "webp");
    WEBP_LOSSLESS = new ImageFormat("WEBP_LOSSLESS", "webp");
    WEBP_EXTENDED = new ImageFormat("WEBP_EXTENDED", "webp");
    WEBP_EXTENDED_WITH_ALPHA = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", "webp");
  }
  
  public static List<ImageFormat> getDefaultFormats()
  {
    if (sAllDefaultFormats == null)
    {
      ArrayList localArrayList = new ArrayList(9);
      localArrayList.add(JPEG);
      localArrayList.add(PNG);
      localArrayList.add(GIF);
      localArrayList.add(BMP);
      localArrayList.add(WEBP_SIMPLE);
      localArrayList.add(WEBP_LOSSLESS);
      localArrayList.add(WEBP_EXTENDED);
      localArrayList.add(WEBP_EXTENDED_WITH_ALPHA);
      localArrayList.add(WEBP_ANIMATED);
      sAllDefaultFormats = ImmutableList.copyOf(localArrayList);
    }
    return sAllDefaultFormats;
  }
  
  public static boolean isStaticWebpFormat(ImageFormat paramImageFormat)
  {
    return (paramImageFormat == WEBP_SIMPLE) || (paramImageFormat == WEBP_LOSSLESS) || (paramImageFormat == WEBP_EXTENDED) || (paramImageFormat == WEBP_EXTENDED_WITH_ALPHA);
  }
  
  public static boolean isWebpFormat(ImageFormat paramImageFormat)
  {
    return (isStaticWebpFormat(paramImageFormat)) || (paramImageFormat == WEBP_ANIMATED);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imageformat/DefaultImageFormats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */