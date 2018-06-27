package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;

@TargetApi(14)
public class cu
  implements b, cs
{
  private final String a = "visual.changes";
  private final int b = 0;
  private final int c = 1;
  private final int d = 2;
  private final int e = 3;
  private final int f = 4;
  private final int g = 5;
  private final int h = 6;
  private final int i = 7;
  private final int j = 8;
  private final int k = 9;
  private Context l;
  private bs m;
  private cy n;
  private fh o;
  private boolean p;
  
  public cu(Context paramContext)
  {
    this.l = paramContext;
    this.m = new bs();
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new cx(this));
    HandlerThread localHandlerThread = new HandlerThread(cu.class.getCanonicalName());
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.n = new cy(this, paramContext, localHandlerThread.getLooper());
    d();
  }
  
  private void d()
  {
    this.n.a();
    this.n.sendMessage(this.n.obtainMessage(0));
  }
  
  private void e()
  {
    Message localMessage = this.n.obtainMessage(9);
    this.n.sendMessage(localMessage);
  }
  
  public void a(View paramView, String paramString1, String paramString2, String paramString3)
  {
    ar.c("onEvent:" + paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!a())) {
      aa.a().a(paramString1, 1.0D, paramString2, paramString3);
    }
  }
  
  public void a(fh paramfh)
  {
    this.o = paramfh;
  }
  
  public void a(k paramk)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramk != null)
    {
      localObject1 = localObject2;
      if (paramk.c != null) {
        localObject1 = paramk.c.i;
      }
    }
    a((String)localObject1);
  }
  
  public void a(String paramString)
  {
    Message localMessage = this.n.obtainMessage(7);
    localMessage.obj = paramString;
    this.n.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return (this.n != null) && (this.n.b());
  }
  
  public void b()
  {
    Message localMessage = this.n.obtainMessage(1);
    this.n.sendMessage(localMessage);
  }
  
  public void b(View paramView, String paramString1, String paramString2, String paramString3)
  {
    ar.b("onPVEvent:" + paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!a())) {
      aa.a().a(av.a(paramString3, paramString2));
    }
  }
  
  public void c()
  {
    this.n.c();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */