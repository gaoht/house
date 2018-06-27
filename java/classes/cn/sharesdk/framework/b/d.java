package cn.sharesdk.framework.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.b.b.c;
import cn.sharesdk.framework.b.b.g;
import com.mob.MobSDK;
import com.mob.commons.SHARESDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.util.Calendar;

public class d
  extends cn.sharesdk.framework.utils.d
{
  private static d b;
  private DeviceHelper c = DeviceHelper.getInstance(MobSDK.getContext());
  private a d = a.a();
  private Handler e;
  private boolean f;
  private long g;
  private boolean h;
  private File i = new File(MobSDK.getContext().getFilesDir(), ".statistics");
  private FileLocker j = new FileLocker();
  
  private d()
  {
    if (!this.i.exists()) {}
    try
    {
      this.i.createNewFile();
      return;
    }
    catch (Exception localException)
    {
      cn.sharesdk.framework.utils.e.b().d(localException);
    }
  }
  
  public static d b()
  {
    try
    {
      if (b == null) {
        b = new d();
      }
      d locald = b;
      return locald;
    }
    finally {}
  }
  
  private void b(c paramc)
  {
    paramc.f = this.c.getDeviceKey();
    paramc.g = this.c.getPackageName();
    paramc.h = this.c.getAppVersion();
    paramc.i = String.valueOf(ShareSDK.SDK_VERSION_CODE);
    paramc.j = this.c.getPlatformCode();
    paramc.k = this.c.getDetailNetworkTypeForStatic();
    if (TextUtils.isEmpty(MobSDK.getAppkey())) {
      Log.w("ShareSDKCore", "Your appKey of ShareSDK is null , this will cause its data won't be count!");
    }
    for (;;)
    {
      paramc.l = this.c.getDeviceData();
      return;
      if ((!"cn.sharesdk.demo".equals(paramc.g)) && (("api20".equals(MobSDK.getAppkey())) || ("androidv1101".equals(MobSDK.getAppkey())))) {
        Log.w("ShareSDKCore", "Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
      }
    }
  }
  
  private void c()
  {
    boolean bool = d();
    if (bool) {
      if (!this.h)
      {
        this.h = bool;
        this.g = System.currentTimeMillis();
        a(new g());
      }
    }
    while (!this.h) {
      return;
    }
    this.h = bool;
    long l1 = System.currentTimeMillis();
    long l2 = this.g;
    cn.sharesdk.framework.b.b.e locale = new cn.sharesdk.framework.b.b.e();
    locale.a = (l1 - l2);
    a(locale);
  }
  
  private void c(c paramc)
  {
    try
    {
      this.d.a(paramc);
      paramc.h();
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b().d(localThrowable);
      cn.sharesdk.framework.utils.e.b().d(paramc.toString(), new Object[0]);
    }
  }
  
  private boolean d()
  {
    return DeviceHelper.getInstance(MobSDK.getContext()).amIOnForeground();
  }
  
  public void a(Handler paramHandler)
  {
    this.e = paramHandler;
  }
  
  protected void a(Message paramMessage)
  {
    if (!this.f) {
      this.f = true;
    }
    try
    {
      this.j.setLockFile(this.i.getAbsolutePath());
      if (this.j.lock(false))
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            String str = DeviceAuthorizer.authorize(new SHARESDK());
            d.a(d.this).a(str);
          }
        }).start();
        this.d.b();
        this.d.c();
        this.a.sendEmptyMessageDelayed(4, 3600000L);
        this.a.sendEmptyMessage(1);
        this.a.sendEmptyMessage(2);
      }
      return;
    }
    catch (Throwable paramMessage)
    {
      cn.sharesdk.framework.utils.e.b().d(paramMessage);
    }
  }
  
  public void a(c paramc)
  {
    Message localMessage;
    if (this.f)
    {
      b(paramc);
      if (paramc.g())
      {
        localMessage = new Message();
        localMessage.what = 3;
        localMessage.obj = paramc;
      }
    }
    else
    {
      try
      {
        this.a.sendMessage(localMessage);
        return;
      }
      catch (Throwable paramc)
      {
        cn.sharesdk.framework.utils.e.b().d(paramc);
        return;
      }
    }
    cn.sharesdk.framework.utils.e.b().d("Drop event: " + paramc.toString(), new Object[0]);
  }
  
  protected void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
      do
      {
        return;
      } while (paramMessage.obj == null);
      c((c)paramMessage.obj);
      this.a.removeMessages(2);
      this.a.sendEmptyMessageDelayed(2, 2000L);
      return;
    case 1: 
      c();
      try
      {
        this.a.sendEmptyMessageDelayed(1, 5000L);
        return;
      }
      catch (Throwable paramMessage)
      {
        cn.sharesdk.framework.utils.e.b().d(paramMessage);
        return;
      }
    case 2: 
      try
      {
        this.d.d();
        return;
      }
      catch (Throwable paramMessage)
      {
        cn.sharesdk.framework.utils.e.b().d(paramMessage);
        return;
      }
    }
    long l = cn.sharesdk.framework.b.a.e.a().h().longValue();
    paramMessage = Calendar.getInstance();
    paramMessage.setTimeInMillis(l);
    int k = paramMessage.get(1);
    int m = paramMessage.get(2);
    int n = paramMessage.get(5);
    paramMessage.setTimeInMillis(System.currentTimeMillis());
    int i1 = paramMessage.get(1);
    int i2 = paramMessage.get(2);
    int i3 = paramMessage.get(5);
    if ((k != i1) || (m != i2) || (n != i3)) {
      this.d.c();
    }
    this.a.sendEmptyMessageDelayed(4, 3600000L);
  }
  
  protected void c(Message paramMessage)
  {
    if (this.f)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.g;
      paramMessage = new cn.sharesdk.framework.b.b.e();
      paramMessage.a = (l1 - l2);
      a(paramMessage);
      this.f = false;
    }
    try
    {
      this.e.sendEmptyMessage(1);
      b = null;
      this.a.getLooper().quit();
      return;
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.b().d(paramMessage);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */