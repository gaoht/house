package com.ziroom.ziroomcustomer.minsu.f;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.ziroom.ziroomcustomer.minsu.b.c;
import com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class n
{
  public static void GetLocalOrNetBitmap(String paramString, final a parama)
  {
    new Thread()
    {
      public void run()
      {
        super.run();
        try
        {
          Object localObject = new URL(this.a);
          if (!(localObject instanceof URL)) {}
          for (localObject = ((URL)localObject).openStream();; localObject = HttpInstrumentation.openStream((URL)localObject))
          {
            localObject = new BufferedInputStream((InputStream)localObject, 1024);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localByteArrayOutputStream, 1024);
            n.a((InputStream)localObject, localBufferedOutputStream);
            localBufferedOutputStream.flush();
            localObject = localByteArrayOutputStream.toByteArray();
            localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
            parama.OnBitmapOver((Bitmap)localObject);
            return;
          }
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
    }.start();
  }
  
  public static boolean addImageToGallery(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    paramString2 = new ContentValues();
    paramString2.put("bucket_display_name", paramString3);
    paramString2.put("title", paramString3);
    paramString2.put("datetaken", Long.valueOf(System.currentTimeMillis()));
    paramString2.put("mime_type", "image/jpeg");
    paramString2.put("_data", paramString1);
    paramContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramString2);
    try
    {
      paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(paramString3))));
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        try
        {
          MediaScannerConnection.scanFile(paramContext, new String[] { paramString1 }, null, null);
          return true;
        }
        catch (Exception paramString1) {}
        paramString2 = paramString2;
        paramString2.printStackTrace();
      }
    }
    return false;
  }
  
  public static String compressAndGenImage(String paramString, Bitmap paramBitmap, int paramInt)
  {
    Object localObject = c.e;
    paramString = (String)localObject + "/" + paramString;
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new ByteArrayOutputStream();
    int i = 100;
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    while (((ByteArrayOutputStream)localObject).toByteArray().length / 1024 > paramInt)
    {
      ((ByteArrayOutputStream)localObject).reset();
      i -= 10;
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
    }
    try
    {
      paramBitmap = new FileOutputStream(paramString);
      paramBitmap.write(((ByteArrayOutputStream)localObject).toByteArray());
      paramBitmap.flush();
      paramBitmap.close();
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static Bitmap convertViewToBitmap(View paramView)
  {
    try
    {
      paramView.setDrawingCacheEnabled(true);
      paramView.buildDrawingCache();
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
      return localBitmap;
    }
    finally
    {
      paramView.setDrawingCacheEnabled(false);
    }
  }
  
  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = 1;
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  public static Bitmap rotatingImg(Context paramContext, Uri paramUri, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramContext = null;
    }
    int i;
    do
    {
      return paramContext;
      i = a.readPictureDegree(ad.getRealFilePath2(paramContext, paramUri));
      paramContext = paramBitmap;
    } while (Math.abs(i) <= 0);
    return a.rotaingImageView(i, paramBitmap);
  }
  
  public static void saveBitmap(Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    if (!"mounted".equals(Environment.getExternalStorageState())) {
      return;
    }
    File localFile = new File(paramString1);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString1 = new File(paramString1 + "/" + paramString2);
    try
    {
      paramString1.createNewFile();
      paramString1 = new FileOutputStream(paramString1);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramString1);
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public static boolean saveImage(Bitmap paramBitmap)
  {
    return saveImage(paramBitmap, null, null);
  }
  
  /* Error */
  public static boolean saveImage(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 280	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 275
    //   6: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +14 -> 23
    //   12: ldc_w 301
    //   15: ldc_w 303
    //   18: invokestatic 308	com/ziroom/ziroomcustomer/util/u:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: astore 4
    //   26: aload_1
    //   27: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +8 -> 38
    //   33: getstatic 125	com/ziroom/ziroomcustomer/minsu/b/c:e	Ljava/lang/String;
    //   36: astore 4
    //   38: aload_2
    //   39: astore 5
    //   41: aload_2
    //   42: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifeq +49 -> 94
    //   48: new 127	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 316
    //   55: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: new 319	android/text/format/DateFormat
    //   62: dup
    //   63: invokespecial 320	android/text/format/DateFormat:<init>	()V
    //   66: pop
    //   67: aload_1
    //   68: ldc_w 322
    //   71: getstatic 328	java/util/Locale:CHINA	Ljava/util/Locale;
    //   74: invokestatic 334	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   77: invokestatic 338	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;Ljava/util/Calendar;)Ljava/lang/CharSequence;
    //   80: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   83: ldc_w 343
    //   86: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 5
    //   94: new 90	java/io/File
    //   97: dup
    //   98: aload 4
    //   100: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 142	java/io/File:exists	()Z
    //   108: ifne +8 -> 116
    //   111: aload_1
    //   112: invokevirtual 145	java/io/File:mkdirs	()Z
    //   115: pop
    //   116: new 127	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   123: aload 4
    //   125: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc -122
    //   130: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 5
    //   135: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore 6
    //   143: new 90	java/io/File
    //   146: dup
    //   147: aload 6
    //   149: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 287	java/io/File:createNewFile	()Z
    //   157: pop
    //   158: new 169	java/io/FileOutputStream
    //   161: dup
    //   162: aload_1
    //   163: invokespecial 290	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   166: astore_2
    //   167: aload_2
    //   168: astore_1
    //   169: aload_0
    //   170: getstatic 154	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   173: bipush 100
    //   175: aload_2
    //   176: invokevirtual 160	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   179: istore_3
    //   180: iload_3
    //   181: ifeq +18 -> 199
    //   184: aload_2
    //   185: astore_1
    //   186: aload 6
    //   188: getstatic 349	com/ziroom/ziroomcustomer/base/ApplicationEx:c	Lcom/ziroom/ziroomcustomer/base/ApplicationEx;
    //   191: aload 4
    //   193: aload 5
    //   195: invokestatic 351	com/ziroom/ziroomcustomer/minsu/f/n:addImageToGallery	(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   198: pop
    //   199: aload_2
    //   200: ifnull +11 -> 211
    //   203: aload_2
    //   204: invokevirtual 177	java/io/FileOutputStream:flush	()V
    //   207: aload_2
    //   208: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   211: iload_3
    //   212: ireturn
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   218: goto -7 -> 211
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_2
    //   224: aload_2
    //   225: astore_1
    //   226: aload_0
    //   227: invokevirtual 352	java/io/FileNotFoundException:printStackTrace	()V
    //   230: aload_2
    //   231: ifnull -210 -> 21
    //   234: aload_2
    //   235: invokevirtual 177	java/io/FileOutputStream:flush	()V
    //   238: aload_2
    //   239: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   242: iconst_0
    //   243: ireturn
    //   244: astore_0
    //   245: aload_0
    //   246: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   249: iconst_0
    //   250: ireturn
    //   251: astore_0
    //   252: aconst_null
    //   253: astore_2
    //   254: aload_2
    //   255: astore_1
    //   256: aload_0
    //   257: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   260: aload_2
    //   261: ifnull -240 -> 21
    //   264: aload_2
    //   265: invokevirtual 177	java/io/FileOutputStream:flush	()V
    //   268: aload_2
    //   269: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   272: iconst_0
    //   273: ireturn
    //   274: astore_0
    //   275: aload_0
    //   276: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_1
    //   284: aload_1
    //   285: ifnull +11 -> 296
    //   288: aload_1
    //   289: invokevirtual 177	java/io/FileOutputStream:flush	()V
    //   292: aload_1
    //   293: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   296: aload_0
    //   297: athrow
    //   298: astore_1
    //   299: aload_1
    //   300: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   303: goto -7 -> 296
    //   306: astore_0
    //   307: goto -23 -> 284
    //   310: astore_0
    //   311: goto -57 -> 254
    //   314: astore_0
    //   315: goto -91 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramBitmap	Bitmap
    //   0	318	1	paramString1	String
    //   0	318	2	paramString2	String
    //   179	33	3	bool	boolean
    //   24	168	4	str1	String
    //   39	155	5	str2	String
    //   141	46	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   203	211	213	java/io/IOException
    //   153	167	221	java/io/FileNotFoundException
    //   234	242	244	java/io/IOException
    //   153	167	251	java/io/IOException
    //   264	272	274	java/io/IOException
    //   153	167	281	finally
    //   288	296	298	java/io/IOException
    //   169	180	306	finally
    //   186	199	306	finally
    //   226	230	306	finally
    //   256	260	306	finally
    //   169	180	310	java/io/IOException
    //   186	199	310	java/io/IOException
    //   169	180	314	java/io/FileNotFoundException
    //   186	199	314	java/io/FileNotFoundException
  }
  
  public static abstract interface a
  {
    public abstract void OnBitmapOver(Bitmap paramBitmap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */