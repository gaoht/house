package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;

public class ImageObject
  implements Parcelable
{
  public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator()
  {
    public ImageObject createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ImageObject(paramAnonymousParcel);
    }
    
    public ImageObject[] newArray(int paramAnonymousInt)
    {
      return new ImageObject[paramAnonymousInt];
    }
  };
  private static final int DATA_SIZE = 2097152;
  public byte[] imageData;
  public String imagePath;
  
  public ImageObject() {}
  
  public ImageObject(Parcel paramParcel)
  {
    this.imageData = paramParcel.createByteArray();
    this.imagePath = paramParcel.readString();
  }
  
  public boolean checkArgs()
  {
    if ((this.imageData == null) && (this.imagePath == null))
    {
      new Throwable("imageData and imagePath are null").printStackTrace();
      return false;
    }
    if ((this.imageData != null) && (this.imageData.length > DATA_SIZE))
    {
      new Throwable("imageData is too large").printStackTrace();
      return false;
    }
    if ((this.imagePath != null) && (this.imagePath.length() > 512))
    {
      new Throwable("imagePath is too length").printStackTrace();
      return false;
    }
    if (this.imagePath != null) {
      try
      {
        File localFile = new File(this.imagePath);
        if ((!localFile.exists()) || (localFile.length() == 0L) || (localFile.length() > 10485760L))
        {
          new Throwable("checkArgs fail, image content is too large or not exists").printStackTrace();
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        new Throwable("checkArgs fail, image content is too large or not exists").printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getObjType()
  {
    return 2;
  }
  
  /* Error */
  public final void setImageObject(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 85	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 86	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_1
    //   11: getstatic 92	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   14: bipush 85
    //   16: aload_3
    //   17: invokevirtual 98	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   20: pop
    //   21: aload_3
    //   22: astore_2
    //   23: aload_0
    //   24: aload_3
    //   25: invokevirtual 101	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   28: putfield 38	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   31: aload_3
    //   32: ifnull +7 -> 39
    //   35: aload_3
    //   36: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   39: return
    //   40: astore_1
    //   41: invokestatic 110	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   44: aload_1
    //   45: invokevirtual 116	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   48: pop
    //   49: return
    //   50: astore 4
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: astore_2
    //   56: invokestatic 110	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   59: aload 4
    //   61: invokevirtual 116	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   64: pop
    //   65: aload_1
    //   66: ifnull -27 -> 39
    //   69: aload_1
    //   70: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   73: return
    //   74: astore_1
    //   75: invokestatic 110	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   78: aload_1
    //   79: invokevirtual 116	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   82: pop
    //   83: return
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_2
    //   98: invokestatic 110	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   101: aload_2
    //   102: invokevirtual 116	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   105: pop
    //   106: goto -11 -> 95
    //   109: astore_1
    //   110: goto -23 -> 87
    //   113: astore 4
    //   115: aload_3
    //   116: astore_1
    //   117: goto -63 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	ImageObject
    //   0	120	1	paramBitmap	android.graphics.Bitmap
    //   9	83	2	localObject	Object
    //   97	5	2	localThrowable1	Throwable
    //   7	109	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   50	10	4	localThrowable2	Throwable
    //   113	1	4	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   35	39	40	java/lang/Throwable
    //   0	8	50	java/lang/Throwable
    //   69	73	74	java/lang/Throwable
    //   0	8	84	finally
    //   91	95	97	java/lang/Throwable
    //   10	21	109	finally
    //   23	31	109	finally
    //   56	65	109	finally
    //   10	21	113	java/lang/Throwable
    //   23	31	113	java/lang/Throwable
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.imageData);
    paramParcel.writeString(this.imagePath);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/sina/weibo/sdk/api/ImageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */