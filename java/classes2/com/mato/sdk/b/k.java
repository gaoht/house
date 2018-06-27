package com.mato.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.mato.sdk.g.a.a;
import com.mato.sdk.g.a.b;
import com.mato.sdk.g.i;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicReference;

public final class k
  extends Observable
{
  private static final String a = g.b("");
  private static k c = null;
  private final AtomicReference<h> b = new AtomicReference();
  private final a d = new a();
  private PhoneStateListener e = null;
  private final Context f;
  private b g = new b((byte)0);
  
  private k(Context paramContext)
  {
    this.f = paramContext;
  }
  
  public static h a()
  {
    if (c != null) {
      return (h)c.b.get();
    }
    return null;
  }
  
  public static void a(final Context paramContext, Observer paramObserver)
  {
    if (c == null)
    {
      paramContext = new k(paramContext);
      c = paramContext;
      paramContext.addObserver(paramObserver);
      paramObserver = c;
      paramObserver.b.set(h.a(paramObserver.f, null));
      a().f();
      paramContext = paramObserver.f;
      if (!i.c()) {
        break label105;
      }
      paramObserver.c(paramContext);
    }
    for (;;)
    {
      paramContext = paramObserver.d;
      paramObserver = paramObserver.f;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(1000);
      paramObserver.registerReceiver(paramContext, localIntentFilter);
      return;
      label105:
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          k.a(k.this, paramContext);
        }
      });
    }
  }
  
  private void a(final h paramh, final boolean paramBoolean)
  {
    if (paramh.c() == 0)
    {
      this.g.a();
      this.g.a(new k.b.a()
      {
        public final void a(boolean paramAnonymousBoolean)
        {
          k.c();
          k.b(k.this, paramh, paramBoolean);
        }
      });
      return;
    }
    this.g.a();
    b(paramh, paramBoolean);
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext = i.b(paramContext).getNetworkInfo(0);
      if (paramContext != null)
      {
        paramContext = paramContext.getExtraInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.equalsIgnoreCase("3gwap");
          if (bool) {
            return true;
          }
        }
        return false;
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return true;
  }
  
  public static void b()
  {
    if (c != null)
    {
      k localk = c;
      i.a(localk.f).listen(localk.e, 0);
      a locala = localk.d;
      localk.f.unregisterReceiver(locala);
    }
  }
  
  private void b(Context paramContext)
  {
    if (i.c())
    {
      c(paramContext);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        k.a(k.this, paramContext);
      }
    });
  }
  
  private void b(h paramh, boolean paramBoolean)
  {
    label89:
    for (;;)
    {
      try
      {
        h localh = (h)this.b.get();
        if (!paramh.a(localh))
        {
          localh.f();
          paramh.f();
          this.b.set(paramh);
          if (paramBoolean)
          {
            if (!paramh.d()) {
              break label89;
            }
            paramBoolean = a(this.f);
            setChanged();
            notifyObservers(Boolean.valueOf(paramBoolean));
          }
        }
        else
        {
          return;
        }
        paramBoolean = i.j(this.f);
        continue;
        paramBoolean = false;
      }
      finally {}
    }
  }
  
  private void c(Context paramContext)
  {
    this.e = new PhoneStateListener()
    {
      public final void onDataConnectionStateChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if ((((h)k.a(k.this).get()).d()) && (paramAnonymousInt1 == 2))
        {
          h localh = h.a(paramAnonymousInt2, "Unknown");
          k.c();
          localh.a();
          k.a(k.this, localh, true);
        }
      }
    };
    i.a(paramContext).listen(this.e, 64);
  }
  
  private void d()
  {
    this.b.set(h.a(this.f, null));
    a().f();
    Object localObject = this.f;
    if (i.c()) {
      c((Context)localObject);
    }
    for (;;)
    {
      localObject = this.d;
      Context localContext = this.f;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(1000);
      localContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
      return;
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          k.a(k.this, paramContext);
        }
      });
    }
  }
  
  private void d(Context paramContext)
  {
    i.a(paramContext).listen(this.e, 0);
  }
  
  private void e()
  {
    i.a(this.f).listen(this.e, 0);
    a locala = this.d;
    this.f.unregisterReceiver(locala);
  }
  
  private h f()
  {
    return (h)this.b.get();
  }
  
  public final class a
    extends BroadcastReceiver
  {
    private static final String a = "android.net.conn.CONNECTIVITY_CHANGE";
    
    public a() {}
    
    public final void a(Context paramContext)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(1000);
      paramContext.registerReceiver(this, localIntentFilter);
    }
    
    public final void b(Context paramContext)
    {
      paramContext.unregisterReceiver(this);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {}
      while (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        return;
      }
      paramContext = h.a(paramContext, null);
      k.c();
      paramContext.a();
      k.a(k.this, paramContext, false);
    }
  }
  
  static final class b
  {
    private b a;
    
    private static boolean a(String paramString)
    {
      try
      {
        InetAddress.getByName(paramString);
        return false;
      }
      catch (UnknownHostException paramString)
      {
        return true;
      }
      catch (Throwable paramString)
      {
        for (;;) {}
      }
    }
    
    public final void a()
    {
      if (this.a != null)
      {
        this.a.b();
        this.a = null;
      }
    }
    
    public final void a(final a parama)
    {
      k.c();
      parama = new Runnable()
      {
        public final void run()
        {
          if ((k.b.a(k.b.this, "www.baidu.com")) && (k.b.a(k.b.this, "www.qq.com")) && (k.b.a(k.b.this, "www.163.com")) && (parama != null)) {
            parama.a(true);
          }
        }
      };
      this.a = a.b().a(parama, 1L);
    }
    
    static abstract interface a
    {
      public abstract void a(boolean paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */