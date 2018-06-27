package com.facebook.imagepipeline.core;

import com.facebook.common.internal.Supplier;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger;

public class ImagePipelineExperiments
{
  private final boolean mDecodeCancellationEnabled;
  private final boolean mExternalCreatedBitmapLogEnabled;
  private final int mForceSmallCacheThresholdBytes;
  private final Supplier<Boolean> mMediaVariationsIndexEnabled;
  private final boolean mSuppressBitmapPrefetching;
  private final boolean mUseDownsamplingRatioForResizing;
  private final WebpBitmapFactory mWebpBitmapFactory;
  private final WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
  private final boolean mWebpSupportEnabled;
  
  private ImagePipelineExperiments(Builder paramBuilder, ImagePipelineConfig.Builder paramBuilder1)
  {
    this.mForceSmallCacheThresholdBytes = paramBuilder.mForceSmallCacheThresholdBytes;
    this.mWebpSupportEnabled = paramBuilder.mWebpSupportEnabled;
    this.mExternalCreatedBitmapLogEnabled = paramBuilder.mExternalCreatedBitmapLogEnabled;
    if (paramBuilder.mMediaVariationsIndexEnabled != null) {}
    for (this.mMediaVariationsIndexEnabled = paramBuilder.mMediaVariationsIndexEnabled;; this.mMediaVariationsIndexEnabled = new Supplier()
        {
          public Boolean get()
          {
            return Boolean.FALSE;
          }
        })
    {
      this.mWebpErrorLogger = paramBuilder.mWebpErrorLogger;
      this.mDecodeCancellationEnabled = paramBuilder.mDecodeCancellationEnabled;
      this.mWebpBitmapFactory = paramBuilder.mWebpBitmapFactory;
      this.mSuppressBitmapPrefetching = paramBuilder.mSuppressBitmapPrefetching;
      this.mUseDownsamplingRatioForResizing = paramBuilder.mUseDownsamplingRatioForResizing;
      return;
    }
  }
  
  public static Builder newBuilder(ImagePipelineConfig.Builder paramBuilder)
  {
    return new Builder(paramBuilder);
  }
  
  public int getForceSmallCacheThresholdBytes()
  {
    return this.mForceSmallCacheThresholdBytes;
  }
  
  public boolean getMediaVariationsIndexEnabled()
  {
    return ((Boolean)this.mMediaVariationsIndexEnabled.get()).booleanValue();
  }
  
  public boolean getUseDownsamplingRatioForResizing()
  {
    return this.mUseDownsamplingRatioForResizing;
  }
  
  public WebpBitmapFactory getWebpBitmapFactory()
  {
    return this.mWebpBitmapFactory;
  }
  
  public WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger()
  {
    return this.mWebpErrorLogger;
  }
  
  public boolean isDecodeCancellationEnabled()
  {
    return this.mDecodeCancellationEnabled;
  }
  
  public boolean isExternalCreatedBitmapLogEnabled()
  {
    return this.mExternalCreatedBitmapLogEnabled;
  }
  
  public boolean isWebpSupportEnabled()
  {
    return this.mWebpSupportEnabled;
  }
  
  public static class Builder
  {
    private final ImagePipelineConfig.Builder mConfigBuilder;
    private boolean mDecodeCancellationEnabled = false;
    private boolean mExternalCreatedBitmapLogEnabled = false;
    private int mForceSmallCacheThresholdBytes = 0;
    private Supplier<Boolean> mMediaVariationsIndexEnabled = null;
    private boolean mSuppressBitmapPrefetching = false;
    private boolean mUseDownsamplingRatioForResizing = false;
    private WebpBitmapFactory mWebpBitmapFactory;
    private WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
    private boolean mWebpSupportEnabled = false;
    
    public Builder(ImagePipelineConfig.Builder paramBuilder)
    {
      this.mConfigBuilder = paramBuilder;
    }
    
    public ImagePipelineExperiments build()
    {
      return new ImagePipelineExperiments(this, this.mConfigBuilder, null);
    }
    
    public ImagePipelineConfig.Builder setDecodeCancellationEnabled(boolean paramBoolean)
    {
      this.mDecodeCancellationEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setExternalCreatedBitmapLogEnabled(boolean paramBoolean)
    {
      this.mExternalCreatedBitmapLogEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setForceSmallCacheThresholdBytes(int paramInt)
    {
      this.mForceSmallCacheThresholdBytes = paramInt;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setMediaVariationsIndexEnabled(Supplier<Boolean> paramSupplier)
    {
      this.mMediaVariationsIndexEnabled = paramSupplier;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setSuppressBitmapPrefetching(boolean paramBoolean)
    {
      this.mSuppressBitmapPrefetching = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setUseDownsampligRatioForResizing(boolean paramBoolean)
    {
      this.mUseDownsamplingRatioForResizing = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setWebpBitmapFactory(WebpBitmapFactory paramWebpBitmapFactory)
    {
      this.mWebpBitmapFactory = paramWebpBitmapFactory;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger paramWebpErrorLogger)
    {
      this.mWebpErrorLogger = paramWebpErrorLogger;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setWebpSupportEnabled(boolean paramBoolean)
    {
      this.mWebpSupportEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/core/ImagePipelineExperiments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */