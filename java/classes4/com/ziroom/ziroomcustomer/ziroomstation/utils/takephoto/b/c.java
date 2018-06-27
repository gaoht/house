package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class c
{
  private static c k;
  private LruCache<String, Bitmap> a;
  private ExecutorService b;
  private int c = 1;
  private c d = c.b;
  private LinkedList<Runnable> e;
  private Thread f;
  private Handler g;
  private Handler h;
  private volatile Semaphore i = new Semaphore(0);
  private volatile Semaphore j;
  
  private c(int paramInt, c paramc)
  {
    a(paramInt, paramc);
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = paramOptions.outWidth;
    int i2 = paramOptions.outHeight;
    int n = 1;
    int m = n;
    if (i1 > paramInt1)
    {
      m = n;
      if (i2 > paramInt2) {
        m = Math.max(Math.round(i1 / paramInt1), Math.round(i1 / paramInt1));
      }
    }
    return m;
  }
  
  private static int a(Object paramObject, String paramString)
  {
    try
    {
      paramString = ImageView.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      int m = ((Integer)paramString.get(paramObject)).intValue();
      if ((m > 0) && (m < Integer.MAX_VALUE)) {}
      return 0;
    }
    catch (Exception paramObject)
    {
      try
      {
        Log.e("TAG", m + "");
        return m;
      }
      catch (Exception paramObject)
      {
        return m;
      }
      paramObject = paramObject;
      return 0;
    }
  }
  
  private Bitmap a(String paramString)
  {
    return (Bitmap)this.a.get(paramString);
  }
  
  private Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  private a a(ImageView paramImageView)
  {
    int i2 = 0;
    a locala = new a(null);
    DisplayMetrics localDisplayMetrics = paramImageView.getContext().getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    int m;
    int i1;
    if (localLayoutParams.width == -2)
    {
      n = 0;
      m = n;
      if (n <= 0) {
        m = localLayoutParams.width;
      }
      n = m;
      if (m <= 0) {
        n = a(paramImageView, "mMaxWidth");
      }
      i1 = n;
      if (n <= 0) {
        i1 = localDisplayMetrics.widthPixels;
      }
      if (localLayoutParams.height != -2) {
        break label157;
      }
    }
    label157:
    for (int n = i2;; n = paramImageView.getHeight())
    {
      m = n;
      if (n <= 0) {
        m = localLayoutParams.height;
      }
      n = m;
      if (m <= 0) {
        n = a(paramImageView, "mMaxHeight");
      }
      m = n;
      if (n <= 0) {
        m = localDisplayMetrics.heightPixels;
      }
      locala.a = i1;
      locala.b = m;
      return locala;
      n = paramImageView.getWidth();
      break;
    }
  }
  
  /* Error */
  private Runnable a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c:d	Lcom/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c$c;
    //   6: getstatic 229	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c$c:a	Lcom/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c$c;
    //   9: if_acmpne +18 -> 27
    //   12: aload_0
    //   13: getfield 231	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c:e	Ljava/util/LinkedList;
    //   16: invokevirtual 237	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   19: checkcast 239	java/lang/Runnable
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aload_0
    //   28: getfield 53	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c:d	Lcom/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c$c;
    //   31: getstatic 51	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c$c:b	Lcom/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c$c;
    //   34: if_acmpne +17 -> 51
    //   37: aload_0
    //   38: getfield 231	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c:e	Ljava/util/LinkedList;
    //   41: invokevirtual 242	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   44: checkcast 239	java/lang/Runnable
    //   47: astore_1
    //   48: goto -25 -> 23
    //   51: aconst_null
    //   52: astore_1
    //   53: goto -30 -> 23
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	c
    //   22	31	1	localRunnable	Runnable
    //   56	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	56	finally
    //   27	48	56	finally
  }
  
  private void a(int paramInt, c paramc)
  {
    this.f = new Thread()
    {
      public void run()
      {
        Looper.prepare();
        c.a(c.this, new Handler()
        {
          public void handleMessage(Message paramAnonymous2Message)
          {
            c.b(c.this).execute(c.a(c.this));
            try
            {
              c.c(c.this).acquire();
              return;
            }
            catch (InterruptedException paramAnonymous2Message) {}
          }
        });
        c.d(c.this).release();
        Looper.loop();
      }
    };
    this.f.start();
    this.a = new LruCache((int)Runtime.getRuntime().maxMemory() / 8)
    {
      protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();
      }
    };
    this.b = Executors.newFixedThreadPool(paramInt);
    this.j = new Semaphore(paramInt);
    this.e = new LinkedList();
    c localc = paramc;
    if (paramc == null) {
      localc = c.b;
    }
    this.d = localc;
  }
  
  /* Error */
  private void a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 167	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c:g	Landroid/os/Handler;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: getfield 60	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c:i	Ljava/util/concurrent/Semaphore;
    //   13: invokevirtual 289	java/util/concurrent/Semaphore:acquire	()V
    //   16: aload_0
    //   17: getfield 231	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c:e	Ljava/util/LinkedList;
    //   20: aload_1
    //   21: invokevirtual 293	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   24: pop
    //   25: aload_0
    //   26: getfield 167	com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c:g	Landroid/os/Handler;
    //   29: sipush 272
    //   32: invokevirtual 299	android/os/Handler:sendEmptyMessage	(I)Z
    //   35: pop
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: astore_2
    //   45: goto -29 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	c
    //   0	48	1	paramRunnable	Runnable
    //   44	1	2	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	16	39	finally
    //   16	36	39	finally
    //   2	16	44	java/lang/InterruptedException
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if ((a(paramString) == null) && (paramBitmap != null)) {
      this.a.put(paramString, paramBitmap);
    }
  }
  
  public static c getInstance()
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new c(1, c.b);
      }
      return k;
    }
    finally {}
  }
  
  public static c getInstance(int paramInt, c paramc)
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new c(paramInt, paramc);
      }
      return k;
    }
    finally {}
  }
  
  public void loadImage(final String paramString, final ImageView paramImageView)
  {
    paramImageView.setTag(paramString);
    if (this.h == null) {
      this.h = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          Object localObject = (c.b)paramAnonymousMessage.obj;
          paramAnonymousMessage = ((c.b)localObject).b;
          Bitmap localBitmap = ((c.b)localObject).a;
          localObject = ((c.b)localObject).c;
          if (paramAnonymousMessage.getTag().toString().equals(localObject)) {
            paramAnonymousMessage.setImageBitmap(localBitmap);
          }
        }
      };
    }
    Bitmap localBitmap = a(paramString);
    if (localBitmap != null)
    {
      b localb = new b(null);
      localb.a = localBitmap;
      localb.b = paramImageView;
      localb.c = paramString;
      paramString = Message.obtain();
      paramString.obj = localb;
      this.h.sendMessage(paramString);
      return;
    }
    a(new Runnable()
    {
      public void run()
      {
        Object localObject = c.a(c.this, paramImageView);
        int i = ((c.a)localObject).a;
        int j = ((c.a)localObject).b;
        localObject = c.a(c.this, paramString, i, j);
        c.a(c.this, paramString, (Bitmap)localObject);
        localObject = new c.b(c.this, null);
        ((c.b)localObject).a = c.a(c.this, paramString);
        ((c.b)localObject).b = paramImageView;
        ((c.b)localObject).c = paramString;
        Message localMessage = Message.obtain();
        localMessage.obj = localObject;
        c.e(c.this).sendMessage(localMessage);
        c.c(c.this).release();
      }
    });
  }
  
  private class a
  {
    int a;
    int b;
    
    private a() {}
  }
  
  private class b
  {
    Bitmap a;
    ImageView b;
    String c;
    
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */