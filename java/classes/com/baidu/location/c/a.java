package com.baidu.location.c;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.a.c;
import com.baidu.location.a.i;
import com.baidu.location.a.l;
import com.baidu.location.a.r;
import com.baidu.location.a.s;
import com.baidu.location.b.d;
import com.baidu.location.f;

public class a
  extends Service
  implements LLSInterface
{
  static a a = null;
  private static long f = 0L;
  Messenger b = null;
  private Looper c;
  private HandlerThread d;
  private boolean e = false;
  
  public static Handler a()
  {
    return a;
  }
  
  private void a(Message paramMessage)
  {
    Log.d("baidu_location_service", "baidu location service register ...");
    com.baidu.location.a.a.a().a(paramMessage);
    l.b().c();
  }
  
  private void b()
  {
    com.baidu.location.a.h.a().a(f.getServiceContext());
    d.a().b();
    com.baidu.location.b.b.a().b();
    com.baidu.location.b.h.a().b();
    com.baidu.location.d.b.a();
    i.c().d();
  }
  
  private void b(Message paramMessage)
  {
    com.baidu.location.a.a.a().b(paramMessage);
  }
  
  private void c()
  {
    com.baidu.location.b.h.a().c();
    d.a().e();
    com.baidu.location.b.b.a().c();
    i.c().e();
    s.e();
    com.baidu.location.a.a.a().b();
    c.a().b();
    try
    {
      if (a != null) {
        a.removeCallbacksAndMessages(null);
      }
      a = null;
      Log.d("baidu_location_service", "baidu location service has stoped ...");
      if (!this.e) {
        Process.killProcess(Process.myPid());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void c(Message paramMessage)
  {
    com.baidu.location.a.a.a().c(paramMessage);
  }
  
  public double getVersion()
  {
    return 7.019999980926514D;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    boolean bool = false;
    if (paramIntent != null)
    {
      com.baidu.location.d.b.g = paramIntent.getString("key");
      com.baidu.location.d.b.f = paramIntent.getString("sign");
      this.e = paramIntent.getBoolean("kill_process");
      bool = paramIntent.getBoolean("cache_exception");
    }
    if (!bool) {}
    return this.b.getBinder();
  }
  
  public void onCreate(Context paramContext)
  {
    f = System.currentTimeMillis();
    this.d = r.a();
    this.c = this.d.getLooper();
    a = new a(this.c);
    this.b = new Messenger(a);
    a.sendEmptyMessage(0);
    Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
  }
  
  public void onDestroy()
  {
    try
    {
      a.sendEmptyMessage(1);
      Log.d("baidu_location_service", "baidu location service stop ...");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("baidu_location_service", "baidu location service stop exception...");
        Process.killProcess(Process.myPid());
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public boolean onUnBind(Intent paramIntent)
  {
    return false;
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (f.isServing == true) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        if (paramMessage.what == 1) {
          a.a(a.this);
        }
        if (paramMessage.what == 0) {
          a.b(a.this);
        }
        super.handleMessage(paramMessage);
        return;
        a.a(a.this, paramMessage);
        continue;
        a.b(a.this, paramMessage);
        continue;
        a.c(a.this, paramMessage);
        continue;
        i.c().b(paramMessage);
        continue;
        i.c().h();
        continue;
        try
        {
          paramMessage.getData();
        }
        catch (Exception localException) {}
        continue;
        byte[] arrayOfByte = paramMessage.getData().getByteArray("errorid");
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          new String(arrayOfByte);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */