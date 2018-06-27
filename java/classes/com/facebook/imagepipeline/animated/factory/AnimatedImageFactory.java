package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;

public abstract interface AnimatedImageFactory
{
  public abstract CloseableImage decodeGif(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions, Bitmap.Config paramConfig);
  
  public abstract CloseableImage decodeWebP(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions, Bitmap.Config paramConfig);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/factory/AnimatedImageFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */