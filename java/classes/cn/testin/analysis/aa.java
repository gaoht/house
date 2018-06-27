package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONArray;

@TargetApi(14)
public class aa
{
  private static aa a = new aa();
  private final int b = 60000;
  private Context c;
  private u d;
  private ad e;
  private s f;
  private cu g;
  private ab h;
  private boolean i;
  private long j;
  
  public static aa a()
  {
    return a;
  }
  
  public static void h()
  {
    if ((a.d != null) && (a.p))
    {
      a.h = au.a(au.b(a.d), "debugVersionId");
      if (TextUtils.isEmpty(a.h)) {
        a.h = "0";
      }
      if (!a.h.equals("0")) {
        break label58;
      }
    }
    label58:
    for (int k = 0;; k = 1)
    {
      a.i = k;
      return;
    }
  }
  
  private void i()
  {
    HandlerThread localHandlerThread = new HandlerThread(aa.class.getCanonicalName());
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.h = new ab(this, localHandlerThread.getLooper());
  }
  
  public Object a(String paramString, Object paramObject)
  {
    for (;;)
    {
      try
      {
        localObject3 = this.d.a(paramString);
        if (localObject3 != null) {
          continue;
        }
        localObject1 = paramObject;
      }
      catch (Exception localException)
      {
        Object localObject3;
        Object localObject1;
        ar.b(localException);
        Object localObject2 = paramObject;
        continue;
        localObject2 = paramObject;
        if (!(paramObject instanceof Boolean)) {
          continue;
        }
        if (!(localObject3 instanceof Boolean)) {
          continue;
        }
        localObject2 = localObject3;
        continue;
        ar.g("The flag is not the Boolean type!");
        localObject2 = paramObject;
        continue;
      }
      ar.c(paramString + ":" + localObject1);
      return localObject1;
      if ((paramObject == null) || ((paramObject instanceof String)))
      {
        localObject1 = String.valueOf(localObject3);
      }
      else
      {
        if (!(paramObject instanceof Number)) {
          continue;
        }
        if ((localObject3 instanceof Number))
        {
          localObject1 = localObject3;
        }
        else
        {
          ar.g("The flag is not the Number type!");
          localObject1 = paramObject;
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    this.h.sendMessage(this.h.obtainMessage(paramInt, paramVarArgs));
  }
  
  public void a(Context paramContext)
  {
    if (this.i) {
      return;
    }
    this.c = paramContext;
    try
    {
      i();
      this.d = new u(paramContext, this.h);
      this.e = new ad(paramContext);
      this.f = new s(paramContext);
      this.d.a(this.e);
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.g = new cu(paramContext);
        this.d.a(this.g);
        ((Application)paramContext).registerActivityLifecycleCallbacks(new ac(this));
      }
      if (a.l) {
        g.a().b();
      }
      au.g(paramContext);
      this.h.sendEmptyMessage(0);
      this.i = true;
      return;
    }
    catch (Exception paramContext)
    {
      a.d = null;
      a.e = null;
      ar.a(paramContext);
    }
  }
  
  public void a(Pair<String, String> paramPair)
  {
    if ((!this.i) || (paramPair == null)) {
      return;
    }
    Message localMessage = this.h.obtainMessage(3);
    localMessage.obj = paramPair;
    this.h.sendMessage(localMessage);
  }
  
  public void a(OnExpUpdateListener paramOnExpUpdateListener, int paramInt)
  {
    a(paramOnExpUpdateListener, paramInt, true);
  }
  
  public void a(OnExpUpdateListener paramOnExpUpdateListener, int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!al.l(this.c))
      {
        if (paramOnExpUpdateListener != null) {
          paramOnExpUpdateListener.onUpdate(true);
        }
      }
      else
      {
        this.d.a(paramOnExpUpdateListener, paramInt, paramBoolean);
        return;
      }
    }
    catch (Exception paramOnExpUpdateListener)
    {
      ar.b(paramOnExpUpdateListener);
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = this.h.obtainMessage(4);
    localMessage.obj = paramString;
    this.h.sendMessage(localMessage);
  }
  
  public void a(String paramString, double paramDouble)
  {
    ar.b("onEvent:" + paramString);
    Message localMessage = this.h.obtainMessage(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("variable", paramString);
    localBundle.putDouble("value", paramDouble);
    localMessage.setData(localBundle);
    this.h.sendMessage(localMessage);
  }
  
  public void a(String paramString1, double paramDouble, String paramString2, String paramString3)
  {
    Message localMessage = this.h.obtainMessage(2);
    Bundle localBundle = new Bundle();
    localBundle.putString("variable", paramString1);
    localBundle.putDouble("value", paramDouble);
    localBundle.putString("variantId", paramString2);
    localBundle.putString("expId", paramString3);
    localMessage.setData(localBundle);
    this.h.sendMessage(localMessage);
  }
  
  protected void b()
  {
    a(5, new Object[0]);
  }
  
  protected boolean b(Pair paramPair)
  {
    if (this.e != null) {
      return this.e.c(paramPair);
    }
    return false;
  }
  
  protected void c()
  {
    try
    {
      if ((!au.f(this.c)) && (al.l(this.c))) {
        this.d.b();
      }
      return;
    }
    catch (Exception localException)
    {
      ar.b(localException);
    }
  }
  
  protected cu d()
  {
    return this.g;
  }
  
  protected void e()
  {
    try
    {
      if (SystemClock.elapsedRealtime() - this.j > 60000L) {
        c();
      }
      b();
      return;
    }
    catch (Exception localException)
    {
      ar.b(localException);
    }
  }
  
  protected void f()
  {
    try
    {
      this.j = SystemClock.elapsedRealtime();
      b();
      return;
    }
    catch (Exception localException)
    {
      ar.b(localException);
    }
  }
  
  public JSONArray g()
  {
    try
    {
      JSONArray localJSONArray = this.d.c();
      return localJSONArray;
    }
    catch (Exception localException)
    {
      ar.b(localException);
    }
    return new JSONArray();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */