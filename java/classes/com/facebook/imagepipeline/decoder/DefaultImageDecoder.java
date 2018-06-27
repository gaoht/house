package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Closeables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public class DefaultImageDecoder
  implements ImageDecoder
{
  private final AnimatedImageFactory mAnimatedImageFactory;
  private final Bitmap.Config mBitmapConfig;
  @Nullable
  private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
  private final ImageDecoder mDefaultDecoder = new ImageDecoder()
  {
    public CloseableImage decode(EncodedImage paramAnonymousEncodedImage, int paramAnonymousInt, QualityInfo paramAnonymousQualityInfo, ImageDecodeOptions paramAnonymousImageDecodeOptions)
    {
      ImageFormat localImageFormat = paramAnonymousEncodedImage.getImageFormat();
      if (localImageFormat == DefaultImageFormats.JPEG) {
        return DefaultImageDecoder.this.decodeJpeg(paramAnonymousEncodedImage, paramAnonymousInt, paramAnonymousQualityInfo, paramAnonymousImageDecodeOptions);
      }
      if (localImageFormat == DefaultImageFormats.GIF) {
        return DefaultImageDecoder.this.decodeGif(paramAnonymousEncodedImage, paramAnonymousImageDecodeOptions);
      }
      if (localImageFormat == DefaultImageFormats.WEBP_ANIMATED) {
        return DefaultImageDecoder.this.decodeAnimatedWebp(paramAnonymousEncodedImage, paramAnonymousImageDecodeOptions);
      }
      if (localImageFormat == ImageFormat.UNKNOWN) {
        throw new IllegalArgumentException("unknown image format");
      }
      return DefaultImageDecoder.this.decodeStaticImage(paramAnonymousEncodedImage, paramAnonymousImageDecodeOptions);
    }
  };
  private final PlatformDecoder mPlatformDecoder;
  
  public DefaultImageDecoder(AnimatedImageFactory paramAnimatedImageFactory, PlatformDecoder paramPlatformDecoder, Bitmap.Config paramConfig)
  {
    this(paramAnimatedImageFactory, paramPlatformDecoder, paramConfig, null);
  }
  
  public DefaultImageDecoder(AnimatedImageFactory paramAnimatedImageFactory, PlatformDecoder paramPlatformDecoder, Bitmap.Config paramConfig, @Nullable Map<ImageFormat, ImageDecoder> paramMap)
  {
    this.mAnimatedImageFactory = paramAnimatedImageFactory;
    this.mBitmapConfig = paramConfig;
    this.mPlatformDecoder = paramPlatformDecoder;
    this.mCustomDecoders = paramMap;
  }
  
  public CloseableImage decode(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    ImageFormat localImageFormat = paramEncodedImage.getImageFormat();
    Object localObject;
    if (localImageFormat != null)
    {
      localObject = localImageFormat;
      if (localImageFormat != ImageFormat.UNKNOWN) {}
    }
    else
    {
      localObject = ImageFormatChecker.getImageFormat_WrapIOException(paramEncodedImage.getInputStream());
      paramEncodedImage.setImageFormat((ImageFormat)localObject);
    }
    if (this.mCustomDecoders != null)
    {
      localObject = (ImageDecoder)this.mCustomDecoders.get(localObject);
      if (localObject != null) {
        return ((ImageDecoder)localObject).decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
      }
    }
    return this.mDefaultDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
  }
  
  public CloseableImage decodeAnimatedWebp(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions)
  {
    return this.mAnimatedImageFactory.decodeWebP(paramEncodedImage, paramImageDecodeOptions, this.mBitmapConfig);
  }
  
  public CloseableImage decodeGif(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions)
  {
    InputStream localInputStream = paramEncodedImage.getInputStream();
    if (localInputStream == null) {
      return null;
    }
    try
    {
      if ((!paramImageDecodeOptions.forceStaticImage) && (this.mAnimatedImageFactory != null))
      {
        paramEncodedImage = this.mAnimatedImageFactory.decodeGif(paramEncodedImage, paramImageDecodeOptions, this.mBitmapConfig);
        return paramEncodedImage;
      }
      paramEncodedImage = decodeStaticImage(paramEncodedImage, paramImageDecodeOptions);
      return paramEncodedImage;
    }
    finally
    {
      Closeables.closeQuietly(localInputStream);
    }
  }
  
  public CloseableStaticBitmap decodeJpeg(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    paramImageDecodeOptions = this.mPlatformDecoder.decodeJPEGFromEncodedImage(paramEncodedImage, paramImageDecodeOptions.bitmapConfig, paramInt);
    try
    {
      paramEncodedImage = new CloseableStaticBitmap(paramImageDecodeOptions, paramQualityInfo, paramEncodedImage.getRotationAngle());
      return paramEncodedImage;
    }
    finally
    {
      paramImageDecodeOptions.close();
    }
  }
  
  public CloseableStaticBitmap decodeStaticImage(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions)
  {
    paramImageDecodeOptions = this.mPlatformDecoder.decodeFromEncodedImage(paramEncodedImage, paramImageDecodeOptions.bitmapConfig);
    try
    {
      paramEncodedImage = new CloseableStaticBitmap(paramImageDecodeOptions, ImmutableQualityInfo.FULL_QUALITY, paramEncodedImage.getRotationAngle());
      return paramEncodedImage;
    }
    finally
    {
      paramImageDecodeOptions.close();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/decoder/DefaultImageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */