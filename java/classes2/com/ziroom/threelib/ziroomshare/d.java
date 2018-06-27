package com.ziroom.threelib.ziroomshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import android.widget.Toast;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class d
{
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramBitmap;
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    checkNotNull(paramInputStream);
    checkNotNull(paramOutputStream);
    byte[] arrayOfByte = new byte['က'];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void getLocalOrNetBitmap(String paramString, final a parama)
  {
    new Thread()
    {
      public void run()
      {
        super.run();
        Object localObject3 = null;
        Object localObject1 = localObject3;
        try
        {
          Object localObject2 = new URL(this.a);
          localObject1 = localObject3;
          if (!(localObject2 instanceof URL)) {
            localObject1 = localObject3;
          }
          for (localObject2 = ((URL)localObject2).openStream();; localObject2 = HttpInstrumentation.openStream((URL)localObject2))
          {
            localObject1 = localObject3;
            localObject2 = new BufferedInputStream((InputStream)localObject2, 1024);
            localObject1 = localObject3;
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            localObject1 = localObject3;
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localByteArrayOutputStream, 1024);
            localObject1 = localObject3;
            d.copy((InputStream)localObject2, localBufferedOutputStream);
            localObject1 = localObject3;
            localBufferedOutputStream.flush();
            localObject1 = localObject3;
            localObject2 = localByteArrayOutputStream.toByteArray();
            localObject1 = localObject3;
            localObject2 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
            localObject1 = localObject2;
            parama.OnBitmapOver((Bitmap)localObject2);
            return;
            localObject1 = localObject3;
          }
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          parama.OnBitmapOver((Bitmap)localObject1);
        }
      }
    }.start();
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if (paramContext[i].getState() == NetworkInfo.State.CONNECTED) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean isNull(String paramString)
  {
    return (paramString == null) || ("".equals(paramString)) || ("null".equals(paramString));
  }
  
  public static boolean notNull(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString));
  }
  
  public static void showToast(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      Toast.makeText(paramContext.getApplicationContext(), paramString, 0);
    }
  }
  
  public static Bitmap zoomImage(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, 100, 100, true);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public static abstract interface a
  {
    public abstract void OnBitmapOver(Bitmap paramBitmap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/threelib/ziroomshare/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */