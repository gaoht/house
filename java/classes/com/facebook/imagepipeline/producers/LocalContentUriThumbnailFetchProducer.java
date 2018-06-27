package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalContentUriThumbnailFetchProducer
  extends LocalFetchProducer
  implements ThumbnailProducer<EncodedImage>
{
  private static final Rect MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);
  private static final Rect MINI_THUMBNAIL_DIMENSIONS;
  private static final int NO_THUMBNAIL = 0;
  public static final String PRODUCER_NAME = "LocalContentUriThumbnailFetchProducer";
  private static final String[] PROJECTION;
  private static final Class<?> TAG = LocalContentUriThumbnailFetchProducer.class;
  private static final String[] THUMBNAIL_PROJECTION;
  private final ContentResolver mContentResolver;
  
  static
  {
    PROJECTION = new String[] { "_id", "_data" };
    THUMBNAIL_PROJECTION = new String[] { "_data" };
    MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, 384);
  }
  
  public LocalContentUriThumbnailFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mContentResolver = paramContentResolver;
  }
  
  @Nullable
  private EncodedImage getCameraImage(Uri paramUri, ResizeOptions paramResizeOptions)
    throws IOException
  {
    paramUri = this.mContentResolver.query(paramUri, PROJECTION, null, null, null);
    if (paramUri == null) {
      return null;
    }
    try
    {
      int i = paramUri.getCount();
      if (i == 0) {
        return null;
      }
      paramUri.moveToFirst();
      String str = paramUri.getString(paramUri.getColumnIndex("_data"));
      if (paramResizeOptions != null)
      {
        paramResizeOptions = getThumbnail(paramResizeOptions, paramUri.getInt(paramUri.getColumnIndex("_id")));
        if (paramResizeOptions != null)
        {
          paramResizeOptions.setRotationAngle(getRotationAngle(str));
          return paramResizeOptions;
        }
      }
      return null;
    }
    finally
    {
      paramUri.close();
    }
  }
  
  private static int getLength(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return (int)new File(paramString).length();
  }
  
  private static int getRotationAngle(String paramString)
  {
    int i = 0;
    if (paramString != null) {}
    try
    {
      i = JfifUtil.getAutoRotateAngleFromOrientation(new ExifInterface(paramString).getAttributeInt("Orientation", 1));
      return i;
    }
    catch (IOException localIOException)
    {
      FLog.e(TAG, localIOException, "Unable to retrieve thumbnail rotation for %s", new Object[] { paramString });
    }
    return 0;
  }
  
  private EncodedImage getThumbnail(ResizeOptions paramResizeOptions, int paramInt)
    throws IOException
  {
    Object localObject1 = null;
    int i = getThumbnailKind(paramResizeOptions);
    if (i == 0) {}
    for (;;)
    {
      return (EncodedImage)localObject1;
      try
      {
        paramResizeOptions = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, paramInt, i, THUMBNAIL_PROJECTION);
        if (paramResizeOptions == null)
        {
          if (paramResizeOptions == null) {
            continue;
          }
          paramResizeOptions.close();
          return null;
        }
      }
      finally
      {
        try
        {
          paramResizeOptions.moveToFirst();
          if (paramResizeOptions.getCount() > 0)
          {
            localObject3 = paramResizeOptions.getString(paramResizeOptions.getColumnIndex("_data"));
            if (new File((String)localObject3).exists())
            {
              localObject3 = getEncodedImage(new FileInputStream((String)localObject3), getLength((String)localObject3));
              localObject1 = localObject3;
              if (paramResizeOptions == null) {
                continue;
              }
              paramResizeOptions.close();
              return (EncodedImage)localObject3;
            }
          }
          if (paramResizeOptions == null) {
            continue;
          }
          paramResizeOptions.close();
          return null;
        }
        finally
        {
          Object localObject3 = paramResizeOptions;
        }
        paramResizeOptions = finally;
        localObject3 = null;
        localObject1 = paramResizeOptions;
      }
    }
    if (localObject3 != null) {
      ((Cursor)localObject3).close();
    }
    throw ((Throwable)localObject1);
  }
  
  private static int getThumbnailKind(ResizeOptions paramResizeOptions)
  {
    if (ThumbnailSizeChecker.isImageBigEnough(MICRO_THUMBNAIL_DIMENSIONS.width(), MICRO_THUMBNAIL_DIMENSIONS.height(), paramResizeOptions)) {
      return 3;
    }
    if (ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), paramResizeOptions)) {
      return 1;
    }
    return 0;
  }
  
  public boolean canProvideImageForSize(ResizeOptions paramResizeOptions)
  {
    return ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), paramResizeOptions);
  }
  
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    Uri localUri = paramImageRequest.getSourceUri();
    if (UriUtil.isLocalCameraUri(localUri))
    {
      paramImageRequest = getCameraImage(localUri, paramImageRequest.getResizeOptions());
      if (paramImageRequest != null) {
        return paramImageRequest;
      }
    }
    return null;
  }
  
  protected String getProducerName()
  {
    return "LocalContentUriThumbnailFetchProducer";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/LocalContentUriThumbnailFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */