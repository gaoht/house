package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalContentUriFetchProducer
  extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
  private static final String[] PROJECTION = { "_id", "_data" };
  private final ContentResolver mContentResolver;
  
  public LocalContentUriFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mContentResolver = paramContentResolver;
  }
  
  @Nullable
  private EncodedImage getCameraImage(Uri paramUri)
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
      Object localObject1 = paramUri.getString(paramUri.getColumnIndex("_data"));
      if (localObject1 != null)
      {
        localObject1 = getEncodedImage(new FileInputStream((String)localObject1), getLength((String)localObject1));
        return (EncodedImage)localObject1;
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
  
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    Uri localUri = paramImageRequest.getSourceUri();
    if (UriUtil.isLocalContactUri(localUri)) {
      if (localUri.toString().endsWith("/photo"))
      {
        paramImageRequest = this.mContentResolver.openInputStream(localUri);
        paramImageRequest = getEncodedImage(paramImageRequest, -1);
      }
    }
    Object localObject;
    do
    {
      return paramImageRequest;
      localObject = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, localUri);
      paramImageRequest = (ImageRequest)localObject;
      if (localObject != null) {
        break;
      }
      throw new IOException("Contact photo does not exist: " + localUri);
      if (!UriUtil.isLocalCameraUri(localUri)) {
        break label103;
      }
      localObject = getCameraImage(localUri);
      paramImageRequest = (ImageRequest)localObject;
    } while (localObject != null);
    label103:
    return getEncodedImage(this.mContentResolver.openInputStream(localUri), -1);
  }
  
  protected String getProducerName()
  {
    return "LocalContentUriFetchProducer";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/LocalContentUriFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */