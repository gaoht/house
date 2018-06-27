package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;
import java.util.Locale;
import javax.annotation.concurrent.Immutable;

@Immutable
public class ImageDecodeOptions
{
  private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
  public final Bitmap.Config bitmapConfig;
  public final boolean decodeAllFrames;
  public final boolean decodePreviewFrame;
  public final boolean forceStaticImage;
  public final int minDecodeIntervalMs;
  public final boolean useLastFrameForPreview;
  
  public ImageDecodeOptions(ImageDecodeOptionsBuilder paramImageDecodeOptionsBuilder)
  {
    this.minDecodeIntervalMs = paramImageDecodeOptionsBuilder.getMinDecodeIntervalMs();
    this.decodePreviewFrame = paramImageDecodeOptionsBuilder.getDecodePreviewFrame();
    this.useLastFrameForPreview = paramImageDecodeOptionsBuilder.getUseLastFrameForPreview();
    this.decodeAllFrames = paramImageDecodeOptionsBuilder.getDecodeAllFrames();
    this.forceStaticImage = paramImageDecodeOptionsBuilder.getForceStaticImage();
    this.bitmapConfig = paramImageDecodeOptionsBuilder.getBitmapConfig();
  }
  
  public static ImageDecodeOptions defaults()
  {
    return DEFAULTS;
  }
  
  public static ImageDecodeOptionsBuilder newBuilder()
  {
    return new ImageDecodeOptionsBuilder();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ImageDecodeOptions)paramObject;
      if (this.decodePreviewFrame != ((ImageDecodeOptions)paramObject).decodePreviewFrame) {
        return false;
      }
      if (this.useLastFrameForPreview != ((ImageDecodeOptions)paramObject).useLastFrameForPreview) {
        return false;
      }
      if (this.decodeAllFrames != ((ImageDecodeOptions)paramObject).decodeAllFrames) {
        return false;
      }
      if (this.forceStaticImage != ((ImageDecodeOptions)paramObject).forceStaticImage) {
        return false;
      }
    } while (this.bitmapConfig == ((ImageDecodeOptions)paramObject).bitmapConfig);
    return false;
  }
  
  public int hashCode()
  {
    int m = 1;
    int n = this.minDecodeIntervalMs;
    int i;
    int j;
    label27:
    int k;
    if (this.decodePreviewFrame)
    {
      i = 1;
      if (!this.useLastFrameForPreview) {
        break label83;
      }
      j = 1;
      if (!this.decodeAllFrames) {
        break label88;
      }
      k = 1;
      label36:
      if (!this.forceStaticImage) {
        break label93;
      }
    }
    for (;;)
    {
      return ((k + (j + (i + n * 31) * 31) * 31) * 31 + m) * 31 + this.bitmapConfig.ordinal();
      i = 0;
      break;
      label83:
      j = 0;
      break label27;
      label88:
      k = 0;
      break label36;
      label93:
      m = 0;
    }
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%d-%b-%b-%b-%b-%s", new Object[] { Integer.valueOf(this.minDecodeIntervalMs), Boolean.valueOf(this.decodePreviewFrame), Boolean.valueOf(this.useLastFrameForPreview), Boolean.valueOf(this.decodeAllFrames), Boolean.valueOf(this.forceStaticImage), this.bitmapConfig.name() });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/common/ImageDecodeOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */