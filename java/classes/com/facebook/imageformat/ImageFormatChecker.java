package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class ImageFormatChecker
{
  private static ImageFormatChecker sInstance;
  @Nullable
  private List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
  private final ImageFormat.FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
  private int mMaxHeaderLength;
  
  private ImageFormatChecker()
  {
    updateMaxHeaderLength();
  }
  
  public static ImageFormat getImageFormat(InputStream paramInputStream)
    throws IOException
  {
    return getInstance().determineImageFormat(paramInputStream);
  }
  
  /* Error */
  public static ImageFormat getImageFormat(String paramString)
  {
    // Byte code:
    //   0: new 42	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 45	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokestatic 47	com/facebook/imageformat/ImageFormatChecker:getImageFormat	(Ljava/io/InputStream;)Lcom/facebook/imageformat/ImageFormat;
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 53	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_0
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: astore_0
    //   27: getstatic 59	com/facebook/imageformat/ImageFormat:UNKNOWN	Lcom/facebook/imageformat/ImageFormat;
    //   30: astore_2
    //   31: aload_1
    //   32: invokestatic 53	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   35: aload_2
    //   36: areturn
    //   37: astore_0
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_0
    //   41: astore_1
    //   42: aload_2
    //   43: invokestatic 53	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: aload_0
    //   50: astore_2
    //   51: goto -9 -> 42
    //   54: astore_0
    //   55: goto -30 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramString	String
    //   8	39	1	localObject1	Object
    //   48	1	1	localObject2	Object
    //   15	36	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	22	java/io/IOException
    //   0	9	37	finally
    //   11	16	48	finally
    //   27	31	48	finally
    //   11	16	54	java/io/IOException
  }
  
  public static ImageFormat getImageFormat_WrapIOException(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = getImageFormat(paramInputStream);
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw Throwables.propagate(paramInputStream);
    }
  }
  
  public static ImageFormatChecker getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new ImageFormatChecker();
      }
      ImageFormatChecker localImageFormatChecker = sInstance;
      return localImageFormatChecker;
    }
    finally {}
  }
  
  private static int readHeaderFromStream(int paramInt, InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramArrayOfByte.length >= paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (!paramInputStream.markSupported()) {
        break;
      }
      try
      {
        paramInputStream.mark(paramInt);
        paramInt = ByteStreams.read(paramInputStream, paramArrayOfByte, 0, paramInt);
        return paramInt;
      }
      finally
      {
        paramInputStream.reset();
      }
    }
    return ByteStreams.read(paramInputStream, paramArrayOfByte, 0, paramInt);
  }
  
  private void updateMaxHeaderLength()
  {
    this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
    if (this.mCustomImageFormatCheckers != null)
    {
      Iterator localIterator = this.mCustomImageFormatCheckers.iterator();
      while (localIterator.hasNext())
      {
        ImageFormat.FormatChecker localFormatChecker = (ImageFormat.FormatChecker)localIterator.next();
        this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, localFormatChecker.getHeaderSize());
      }
    }
  }
  
  public ImageFormat determineImageFormat(InputStream paramInputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Object localObject = new byte[this.mMaxHeaderLength];
    int i = readHeaderFromStream(this.mMaxHeaderLength, paramInputStream, (byte[])localObject);
    if (this.mCustomImageFormatCheckers != null)
    {
      Iterator localIterator = this.mCustomImageFormatCheckers.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramInputStream = ((ImageFormat.FormatChecker)localIterator.next()).determineFormat((byte[])localObject, i);
      } while ((paramInputStream == null) || (paramInputStream == ImageFormat.UNKNOWN));
    }
    do
    {
      return paramInputStream;
      localObject = this.mDefaultFormatChecker.determineFormat((byte[])localObject, i);
      paramInputStream = (InputStream)localObject;
    } while (localObject != null);
    return ImageFormat.UNKNOWN;
  }
  
  public void setCustomImageFormatCheckers(@Nullable List<ImageFormat.FormatChecker> paramList)
  {
    this.mCustomImageFormatCheckers = paramList;
    updateMaxHeaderLength();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imageformat/ImageFormatChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */