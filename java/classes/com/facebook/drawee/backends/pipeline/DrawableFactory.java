package com.facebook.drawee.backends.pipeline;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

public abstract interface DrawableFactory
{
  @Nullable
  public abstract Drawable createDrawable(CloseableImage paramCloseableImage);
  
  public abstract boolean supportsImageType(CloseableImage paramCloseableImage);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/drawee/backends/pipeline/DrawableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */