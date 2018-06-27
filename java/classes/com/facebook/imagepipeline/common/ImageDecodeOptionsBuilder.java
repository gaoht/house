package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;

public class ImageDecodeOptionsBuilder
{
  private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
  private boolean mDecodeAllFrames;
  private boolean mDecodePreviewFrame;
  private boolean mForceStaticImage;
  private int mMinDecodeIntervalMs = 100;
  private boolean mUseLastFrameForPreview;
  
  public ImageDecodeOptions build()
  {
    return new ImageDecodeOptions(this);
  }
  
  public Bitmap.Config getBitmapConfig()
  {
    return this.mBitmapConfig;
  }
  
  public boolean getDecodeAllFrames()
  {
    return this.mDecodeAllFrames;
  }
  
  public boolean getDecodePreviewFrame()
  {
    return this.mDecodePreviewFrame;
  }
  
  public boolean getForceStaticImage()
  {
    return this.mForceStaticImage;
  }
  
  public int getMinDecodeIntervalMs()
  {
    return this.mMinDecodeIntervalMs;
  }
  
  public boolean getUseLastFrameForPreview()
  {
    return this.mUseLastFrameForPreview;
  }
  
  public void setBitmapConfig(Bitmap.Config paramConfig)
  {
    this.mBitmapConfig = paramConfig;
  }
  
  public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean paramBoolean)
  {
    this.mDecodeAllFrames = paramBoolean;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean paramBoolean)
  {
    this.mDecodePreviewFrame = paramBoolean;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setForceStaticImage(boolean paramBoolean)
  {
    this.mForceStaticImage = paramBoolean;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions paramImageDecodeOptions)
  {
    this.mDecodePreviewFrame = paramImageDecodeOptions.decodePreviewFrame;
    this.mUseLastFrameForPreview = paramImageDecodeOptions.useLastFrameForPreview;
    this.mDecodeAllFrames = paramImageDecodeOptions.decodeAllFrames;
    this.mForceStaticImage = paramImageDecodeOptions.forceStaticImage;
    this.mBitmapConfig = paramImageDecodeOptions.bitmapConfig;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int paramInt)
  {
    this.mMinDecodeIntervalMs = paramInt;
    return this;
  }
  
  public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean paramBoolean)
  {
    this.mUseLastFrameForPreview = paramBoolean;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/common/ImageDecodeOptionsBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */