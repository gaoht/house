package com.freelxl.baselibrary.widget.imgpicker.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.freelxl.baselibrary.R.id;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final int b = a + 1;
  private static final int c = a * 2 + 1;
  private static final int d = R.id.imagepicker_uri;
  private static final ThreadFactory e = new ThreadFactory()
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, "ImagePicker#" + this.a.getAndIncrement());
    }
  };
  private static final Executor g = new ThreadPoolExecutor(b, c, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), e);
  private static Handler h = new b(Looper.getMainLooper());
  private Context f;
  
  public a(Context paramContext)
  {
    this.f = paramContext.getApplicationContext();
  }
  
  private Bitmap a(com.freelxl.baselibrary.widget.imgpicker.b.a parama, int paramInt1, int paramInt2)
  {
    String str = b(parama.b);
    Bitmap localBitmap = a(str);
    if (localBitmap != null) {
      parama = localBitmap;
    }
    do
    {
      return parama;
      localBitmap = b.getInstance().decodeSampleBitmapFromFile(parama.b, paramInt1, paramInt2);
      parama = localBitmap;
    } while (localBitmap == null);
    a(str, localBitmap);
    b(str, localBitmap);
    return localBitmap;
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject = com.freelxl.baselibrary.widget.imgpicker.a.getInstance(this.f).getMemoryCache().get(paramString);
    if (localObject != null) {}
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      localBitmap = com.freelxl.baselibrary.widget.imgpicker.a.getInstance(this.f).getDiskCache().get(paramString);
      localObject = localBitmap;
    } while (localBitmap == null);
    a(paramString, localBitmap);
    return localBitmap;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    com.freelxl.baselibrary.widget.imgpicker.a.getInstance(this.f).getMemoryCache().put(paramString, paramBitmap);
  }
  
  private String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = a(((MessageDigest)localObject).digest());
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return String.valueOf(paramString.hashCode());
  }
  
  private void b(String paramString, Bitmap paramBitmap)
  {
    com.freelxl.baselibrary.widget.imgpicker.a.getInstance(this.f).getDiskCache().put(paramString, paramBitmap);
  }
  
  public void bindBitmap(com.freelxl.baselibrary.widget.imgpicker.b.a parama, ImageView paramImageView)
  {
    bindBitmap(parama, paramImageView, 0, 0);
  }
  
  public void bindBitmap(final com.freelxl.baselibrary.widget.imgpicker.b.a parama, final ImageView paramImageView, final int paramInt1, final int paramInt2)
  {
    if (parama == null) {
      return;
    }
    paramImageView.setTag(d, parama.b);
    parama = new Runnable()
    {
      public void run()
      {
        Object localObject = (String)paramImageView.getTag(a.a());
        if (((String)localObject).equals(parama.b))
        {
          Bitmap localBitmap = a.a(a.this, parama, paramInt1, paramInt2);
          if ((localBitmap != null) && (((String)localObject).equals(parama.b)))
          {
            localObject = new a.a(paramImageView, parama.b, localBitmap);
            a.b().obtainMessage(1, localObject).sendToTarget();
          }
        }
      }
    };
    g.execute(parama);
  }
  
  public void clear()
  {
    h.removeMessages(1);
  }
  
  private static class a
  {
    public ImageView a;
    public String b;
    public Bitmap c;
    
    public a(ImageView paramImageView, String paramString, Bitmap paramBitmap)
    {
      this.a = paramImageView;
      this.b = paramString;
      this.c = paramBitmap;
    }
  }
  
  private static class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (a.a)paramMessage.obj;
      ImageView localImageView = paramMessage.a;
      if (((String)localImageView.getTag(a.a())).equals(paramMessage.b)) {
        localImageView.setImageBitmap(paramMessage.c);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */