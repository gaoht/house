package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class AnimatedImageFactoryImpl
  implements AnimatedImageFactory
{
  static AnimatedImageDecoder sGifAnimatedImageDecoder = loadIfPresent("com.facebook.animated.gif.GifImage");
  static AnimatedImageDecoder sWebpAnimatedImageDecoder = loadIfPresent("com.facebook.animated.webp.WebPImage");
  private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
  private final PlatformBitmapFactory mBitmapFactory;
  
  public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider paramAnimatedDrawableBackendProvider, PlatformBitmapFactory paramPlatformBitmapFactory)
  {
    this.mAnimatedDrawableBackendProvider = paramAnimatedDrawableBackendProvider;
    this.mBitmapFactory = paramPlatformBitmapFactory;
  }
  
  @SuppressLint({"NewApi"})
  private CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    paramConfig = this.mBitmapFactory.createBitmapInternal(paramInt1, paramInt2, paramConfig);
    ((Bitmap)paramConfig.get()).eraseColor(0);
    if (Build.VERSION.SDK_INT >= 12) {
      ((Bitmap)paramConfig.get()).setHasAlpha(true);
    }
    return paramConfig;
  }
  
  private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage paramAnimatedImage, Bitmap.Config paramConfig, int paramInt)
  {
    paramConfig = createBitmap(paramAnimatedImage.getWidth(), paramAnimatedImage.getHeight(), paramConfig);
    paramAnimatedImage = AnimatedImageResult.forAnimatedImage(paramAnimatedImage);
    new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(paramAnimatedImage, null), new AnimatedImageCompositor.Callback()
    {
      public CloseableReference<Bitmap> getCachedBitmap(int paramAnonymousInt)
      {
        return null;
      }
      
      public void onIntermediateResult(int paramAnonymousInt, Bitmap paramAnonymousBitmap) {}
    }).renderFrame(paramInt, (Bitmap)paramConfig.get());
    return paramConfig;
  }
  
  private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage paramAnimatedImage, Bitmap.Config paramConfig)
  {
    paramAnimatedImage = AnimatedImageResult.forAnimatedImage(paramAnimatedImage);
    paramAnimatedImage = this.mAnimatedDrawableBackendProvider.get(paramAnimatedImage, null);
    final ArrayList localArrayList = new ArrayList(paramAnimatedImage.getFrameCount());
    AnimatedImageCompositor localAnimatedImageCompositor = new AnimatedImageCompositor(paramAnimatedImage, new AnimatedImageCompositor.Callback()
    {
      public CloseableReference<Bitmap> getCachedBitmap(int paramAnonymousInt)
      {
        return CloseableReference.cloneOrNull((CloseableReference)localArrayList.get(paramAnonymousInt));
      }
      
      public void onIntermediateResult(int paramAnonymousInt, Bitmap paramAnonymousBitmap) {}
    });
    int i = 0;
    while (i < paramAnimatedImage.getFrameCount())
    {
      CloseableReference localCloseableReference = createBitmap(paramAnimatedImage.getWidth(), paramAnimatedImage.getHeight(), paramConfig);
      localAnimatedImageCompositor.renderFrame(i, (Bitmap)localCloseableReference.get());
      localArrayList.add(localCloseableReference);
      i += 1;
    }
    return localArrayList;
  }
  
  private CloseableImage getCloseableImage(ImageDecodeOptions paramImageDecodeOptions, AnimatedImage paramAnimatedImage, Bitmap.Config paramConfig)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        int i;
        if (paramImageDecodeOptions.useLastFrameForPreview)
        {
          i = paramAnimatedImage.getFrameCount() - 1;
          if (paramImageDecodeOptions.forceStaticImage)
          {
            paramImageDecodeOptions = new CloseableStaticBitmap(createPreviewBitmap(paramAnimatedImage, paramConfig, i), ImmutableQualityInfo.FULL_QUALITY, 0);
            CloseableReference.closeSafely(null);
            CloseableReference.closeSafely(null);
            return paramImageDecodeOptions;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if (paramImageDecodeOptions.decodeAllFrames)
        {
          localList = decodeAllFrames(paramAnimatedImage, paramConfig);
          localObject1 = localObject2;
          localObject3 = localList;
        }
        Object localObject4;
        List localList = null;
      }
      finally
      {
        try
        {
          localObject2 = CloseableReference.cloneOrNull((CloseableReference)localList.get(i));
          localObject4 = localObject2;
          localObject1 = localObject2;
          localObject3 = localList;
          if (paramImageDecodeOptions.decodePreviewFrame)
          {
            localObject4 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              localObject3 = localList;
              localObject4 = createPreviewBitmap(paramAnimatedImage, paramConfig, i);
            }
          }
          localObject1 = localObject4;
          localObject3 = localList;
          paramImageDecodeOptions = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(paramAnimatedImage).setPreviewBitmap((CloseableReference)localObject4).setFrameForPreview(i).setDecodedFrames(localList).build());
          CloseableReference.closeSafely((CloseableReference)localObject4);
          CloseableReference.closeSafely(localList);
          return paramImageDecodeOptions;
        }
        finally
        {
          continue;
        }
        paramImageDecodeOptions = finally;
        localObject3 = null;
        CloseableReference.closeSafely((CloseableReference)localObject1);
        CloseableReference.closeSafely((Iterable)localObject3);
      }
      localObject2 = localObject3;
    }
  }
  
  private static AnimatedImageDecoder loadIfPresent(String paramString)
  {
    try
    {
      paramString = (AnimatedImageDecoder)Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public CloseableImage decodeGif(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions, Bitmap.Config paramConfig)
  {
    if (sGifAnimatedImageDecoder == null) {
      throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
    }
    paramEncodedImage = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(paramEncodedImage);
    try
    {
      PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramEncodedImage.get();
      paramImageDecodeOptions = getCloseableImage(paramImageDecodeOptions, sGifAnimatedImageDecoder.decode(localPooledByteBuffer.getNativePtr(), localPooledByteBuffer.size()), paramConfig);
      return paramImageDecodeOptions;
    }
    finally
    {
      CloseableReference.closeSafely(paramEncodedImage);
    }
  }
  
  public CloseableImage decodeWebP(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions, Bitmap.Config paramConfig)
  {
    if (sWebpAnimatedImageDecoder == null) {
      throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
    }
    paramEncodedImage = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(paramEncodedImage);
    try
    {
      PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramEncodedImage.get();
      paramImageDecodeOptions = getCloseableImage(paramImageDecodeOptions, sWebpAnimatedImageDecoder.decode(localPooledByteBuffer.getNativePtr(), localPooledByteBuffer.size()), paramConfig);
      return paramImageDecodeOptions;
    }
    finally
    {
      CloseableReference.closeSafely(paramEncodedImage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/factory/AnimatedImageFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */