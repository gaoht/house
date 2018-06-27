package com.ziroom.ziroomcustomer.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

@Instrumented
public class r
{
  public static HashMap<String, SoftReference<Bitmap>> a = new HashMap();
  private Context b;
  private String c = "Ziruke";
  private HashMap<String, Bitmap> d = new HashMap();
  private boolean e = false;
  
  public r()
  {
    createImageDir();
  }
  
  public r(Context paramContext)
  {
    this.b = paramContext;
    createImageDir();
  }
  
  public static byte[] compressByte(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (IOException localIOException)
    {
      Log.v("图片压缩", localIOException.getMessage());
    }
    return paramBitmap;
  }
  
  public static byte[] compressByte(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (IOException localIOException)
    {
      Log.v("图片压缩", localIOException.getMessage());
    }
    return paramBitmap;
  }
  
  public static ByteArrayInputStream compressByteArrayInputStream(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    int i = 100;
    for (;;)
    {
      if ((localByteArrayOutputStream.toByteArray().length / 1024 <= 100) || (i < 0)) {
        return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
      }
      localByteArrayOutputStream.reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
      i -= 10;
    }
  }
  
  public static Bitmap compressImage(Bitmap paramBitmap, int paramInt)
  {
    paramBitmap = compressByteArrayInputStream(paramBitmap);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramInt;
    return BitmapFactory.decodeStream(paramBitmap, null, localOptions);
  }
  
  public static byte[] compressImage(String paramString, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = null;
    File localFile = new File(h.a, paramString);
    paramString = localByteArrayOutputStream;
    if (localFile.exists())
    {
      new BitmapFactory();
      paramString = compressImage(BitmapFactory.decodeFile(localFile.getAbsolutePath()), paramInt);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      paramString = localByteArrayOutputStream.toByteArray();
    }
    return paramString;
  }
  
  public static byte[] compressNoByte(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (IOException localIOException)
    {
      Log.v("图片压缩", localIOException.getMessage());
    }
    return paramBitmap;
  }
  
  public static byte[] getZoomBitmap(String paramString)
  {
    int i = 1;
    paramString = new File(paramString);
    if (paramString.exists())
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      int j = (int)(((BitmapFactory.Options)localObject).outHeight / 200.0F);
      if (j <= 0) {}
      for (;;)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        paramString = BitmapFactory.decodeFile(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject);
        localObject = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
        return ((ByteArrayOutputStream)localObject).toByteArray();
        i = j;
      }
    }
    return null;
  }
  
  public static int readPictureDegree(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static Bitmap rotaingImageView(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static File zoomImage(File paramFile, int paramInt)
    throws IOException
  {
    if ((paramFile != null) && (paramFile.isFile()) && (paramInt > 0))
    {
      int i = readPictureDegree(paramFile.getAbsolutePath());
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 1;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      Object localObject2 = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      Object localObject1 = localObject2;
      if (localByteArrayOutputStream.size() / 1024.0F > paramInt)
      {
        localOptions.inSampleSize = ((int)Math.ceil(Math.sqrt(localByteArrayOutputStream.size() / 1024.0D / paramInt)));
        ((Bitmap)localObject2).recycle();
        localObject1 = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
      }
      paramFile = new File(ApplicationEx.c.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "image_zoom_temp" + ".jpg");
      if (!paramFile.exists()) {
        paramFile.createNewFile();
      }
      localObject2 = new FileOutputStream(paramFile);
      localObject1 = rotaingImageView(i, (Bitmap)localObject1);
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject2);
      ((Bitmap)localObject1).recycle();
      return paramFile;
    }
    return null;
  }
  
  public static File zoomImageByRatio(String paramString, float paramFloat1, float paramFloat2)
    throws IOException
  {
    int j = 1;
    int k = readPictureDegree(paramString);
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int m = ((BitmapFactory.Options)localObject).outHeight;
    if ((i > m) && (i > paramFloat1)) {
      i = (int)(((BitmapFactory.Options)localObject).outWidth / paramFloat1);
    }
    for (;;)
    {
      if (i <= 0) {
        i = j;
      }
      for (;;)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        Bitmap localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        paramString = new File(ApplicationEx.c.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "image_zoom_temp_ratio" + ".jpg");
        if (!paramString.exists()) {
          paramString.createNewFile();
        }
        localObject = new FileOutputStream(paramString);
        localBitmap = rotaingImageView(k, localBitmap);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject);
        localBitmap.recycle();
        return paramString;
        if ((i >= m) || (m <= paramFloat2)) {
          break label221;
        }
        i = (int)(((BitmapFactory.Options)localObject).outHeight / paramFloat2);
        break;
      }
      label221:
      i = 1;
    }
  }
  
  public static File zoomImageWithQuality(File paramFile, int paramInt)
    throws IOException
  {
    int i = 100;
    if ((paramFile != null) && (paramFile.isFile()) && (paramInt > 0))
    {
      int k = readPictureDegree(paramFile.getAbsolutePath());
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
      localObject = new ByteArrayOutputStream();
      paramFile.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      int j = i;
      if (((ByteArrayOutputStream)localObject).size() / 1024.0F > paramInt) {
        for (;;)
        {
          j = i;
          if (((ByteArrayOutputStream)localObject).size() / 1024.0F <= paramInt) {
            break;
          }
          ((ByteArrayOutputStream)localObject).reset();
          i -= 10;
          paramFile.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
        }
      }
      localObject = new File(ApplicationEx.c.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "image_zoom_temp" + ".jpg");
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject);
      paramFile = rotaingImageView(k, paramFile);
      paramFile.compress(Bitmap.CompressFormat.JPEG, j, localFileOutputStream);
      paramFile.recycle();
      return (File)localObject;
    }
    return null;
  }
  
  public boolean createDir(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return paramString.mkdirs();
    }
    return true;
  }
  
  public boolean createImageDir()
  {
    return createDir(getImageDir());
  }
  
  public Bitmap downloadFile(String paramString1, String paramString2)
  {
    Bitmap localBitmap = null;
    Object localObject = new File(paramString2);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = getImageBytes(paramString1);
    if (localObject == null) {
      paramString1 = localBitmap;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        localBitmap = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        paramString1 = localBitmap;
        if (isSDCard())
        {
          saveImageFile((byte[])localObject, paramString2);
          return localBitmap;
        }
      }
      catch (Exception paramString1) {}
    }
    return null;
  }
  
  public Bitmap getBitmap(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      if (!(paramString instanceof URL)) {}
      for (paramString = paramString.openStream();; paramString = HttpInstrumentation.openStream((URL)paramString)) {
        return BitmapFactory.decodeStream(paramString);
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Bitmap getCacheBitmap(String paramString)
  {
    Bitmap localBitmap = null;
    if (a.containsKey(paramString)) {
      localBitmap = (Bitmap)((SoftReference)a.get(paramString)).get();
    }
    return localBitmap;
  }
  
  public Bitmap getHttpBitmap(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new URL(paramString);
        if (!(paramString instanceof URL))
        {
          paramString = paramString.openConnection();
          localHttpURLConnection = (HttpURLConnection)paramString;
          localHttpURLConnection.setConnectTimeout(5000);
          localHttpURLConnection.setDoInput(true);
          localHttpURLConnection.connect();
          localInputStream = localHttpURLConnection.getInputStream();
          Log.i("TAG", "*********inputstream**" + localInputStream);
          paramString = BitmapFactory.decodeStream(localInputStream);
        }
      }
      catch (Exception localException1)
      {
        HttpURLConnection localHttpURLConnection;
        InputStream localInputStream;
        paramString = null;
      }
      try
      {
        Log.i("TAG", "*********bitmap****" + paramString);
        localInputStream.close();
        localHttpURLConnection.disconnect();
        return paramString;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      paramString = HttpInstrumentation.openConnection((URL)paramString);
    }
    localException1.printStackTrace();
    return paramString;
  }
  
  public Bitmap getImageBitmap(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (!paramString.equals(""))
        {
          Bitmap localBitmap2 = getLocalBitmap(getImagePath(paramString));
          localBitmap1 = localBitmap2;
          if (localBitmap2 != null) {
            return localBitmap1;
          }
          paramString = getRemoteBitmap(paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    Bitmap localBitmap1 = null;
    return localBitmap1;
  }
  
  public void getImageBitmap(final ImageView paramImageView, final String paramString, final a parama)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          Bitmap localBitmap = r.this.getImageBitmap(paramString);
          if (localBitmap != null)
          {
            parama.loadImage(paramImageView, localBitmap);
            return;
          }
          parama.loadDefaultImage(paramImageView);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }.start();
  }
  
  public void getImageBitmap(final String paramString, final Handler paramHandler)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          Object localObject = r.this.getImageBitmap(paramString);
          if (localObject != null)
          {
            Message localMessage2 = new Message();
            localMessage2.what = 131073;
            localMessage2.obj = localObject;
            paramHandler.sendMessage(localMessage2);
            return;
          }
          localObject = new Message();
          ((Message)localObject).what = 131074;
          ((Message)localObject).obj = null;
          paramHandler.sendMessage((Message)localObject);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Message localMessage1 = new Message();
          localMessage1.what = 131074;
          localMessage1.obj = null;
          paramHandler.sendMessage(localMessage1);
        }
      }
    }.start();
  }
  
  public Bitmap getImageBitmap2(final String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    Thread local1 = new Thread()
    {
      public void run()
      {
        Bitmap localBitmap = r.this.getImageBitmap(paramString);
        r.a(r.this).put(paramString, localBitmap);
      }
    };
    local1.start();
    try
    {
      local1.join();
      return (Bitmap)this.d.get(paramString);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public byte[] getImageBytes(String paramString)
  {
    if ((paramString == null) && ("".equals(paramString))) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      paramString = new URL(paramString);
      if (!(paramString instanceof URL))
      {
        paramString = paramString.openConnection();
        paramString.getContentLength();
        InputStream localInputStream = paramString.getInputStream();
        paramString = new byte['Ѐ'];
        localByteArrayOutputStream = new ByteArrayOutputStream();
        for (;;)
        {
          int i = localInputStream.read(paramString);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write(paramString, 0, i);
          localByteArrayOutputStream.flush();
        }
        localException1.printStackTrace();
      }
    }
    catch (Exception localException1)
    {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      paramString = HttpInstrumentation.openConnection((URL)paramString);
      break;
      paramString = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        localException1.close();
        return paramString;
      }
      catch (Exception localException2) {}
    }
  }
  
  public String getImageDir()
  {
    return getSDCardPath() + "/" + this.c + "/images/";
  }
  
  public String getImageName(String paramString)
  {
    String str = paramString;
    if (paramString.lastIndexOf("/") > 0) {
      str = paramString.substring(paramString.lastIndexOf("/") + 1);
    }
    return str;
  }
  
  public String getImagePath(String paramString)
  {
    if (isSDCard()) {
      return getImageDir() + getImageName(paramString);
    }
    return getImageName(paramString);
  }
  
  public Bitmap getLocalBitmap(String paramString)
  {
    return BitmapFactory.decodeFile(paramString);
  }
  
  public String getPackageName()
  {
    if (this.b == null) {
      return this.c;
    }
    return this.b.getPackageName();
  }
  
  public Bitmap getRemoteBitmap(String paramString)
  {
    return downloadFile(paramString, getImagePath(paramString));
  }
  
  public Bitmap getRes(String paramString)
  {
    ApplicationInfo localApplicationInfo = this.b.getApplicationInfo();
    int i = this.b.getResources().getIdentifier(paramString, "drawable", localApplicationInfo.packageName);
    return BitmapFactory.decodeResource(this.b.getResources(), i);
  }
  
  public String getSDCardPath()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath();
  }
  
  public void getSynImageBitmap(final ImageView paramImageView, final String paramString, final a parama)
  {
    paramImageView = new Thread()
    {
      public void run()
      {
        try
        {
          Bitmap localBitmap = r.this.getImageBitmap(paramString);
          if (localBitmap != null)
          {
            parama.loadImage(paramImageView, localBitmap);
            return;
          }
          parama.loadDefaultImage(paramImageView);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    };
    paramImageView.start();
    try
    {
      paramImageView.join();
      return;
    }
    catch (InterruptedException paramImageView)
    {
      paramImageView.printStackTrace();
    }
  }
  
  public boolean isSDCard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public void saveImageFile(Bitmap paramBitmap, String paramString, int paramInt)
  {
    if (paramBitmap == null) {
      return;
    }
    paramString = new File(paramString);
    try
    {
      paramString.createNewFile();
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramString);
      paramString.flush();
      paramString.close();
      return;
    }
    catch (FileNotFoundException paramBitmap) {}catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void saveImageFile(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      paramString = new FileOutputStream(paramString);
      paramString.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramString.close();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public static abstract interface a
  {
    public abstract void loadDefaultImage(ImageView paramImageView);
    
    public abstract void loadImage(ImageView paramImageView, Bitmap paramBitmap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */