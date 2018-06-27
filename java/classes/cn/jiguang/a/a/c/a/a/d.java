package cn.jiguang.a.a.c.a.a;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import cn.jiguang.a.a;
import cn.jiguang.a.a.c.b;
import cn.jiguang.api.JAnalyticsAction;

public class d
  extends Instrumentation
{
  private static final String[] z;
  protected Instrumentation a;
  private final Context b;
  private boolean c = true;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "P!3'z^;\025";
    int k = -1;
    int m = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int j = localObject2.length;
    int i;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (j <= 1)
    {
      i = 0;
      localObject3 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 31;
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label121;
          }
        }
      }
      k = j;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      j = k;
      i = m;
      if (k > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "P!\"0lK.\002!";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 63;
        break label99;
        i = 79;
        break label99;
        i = 112;
        break label99;
        i = 85;
        break label99;
        i = 0;
        i2 = k;
        i3 = m;
        localObject4 = localObject1;
        k = j;
        m = i;
      }
    }
  }
  
  public d(Context paramContext, Instrumentation paramInstrumentation)
  {
    this.a = paramInstrumentation;
    this.b = paramContext;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = true;
  }
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle)
  {
    if ((this.c) && (a.a != null)) {
      a.a.dispatchStatus(paramActivity, z[0]);
    }
    if (this.a != null)
    {
      this.a.callActivityOnCreate(paramActivity, paramBundle);
      return;
    }
    super.callActivityOnCreate(paramActivity, paramBundle);
  }
  
  public void callActivityOnPause(Activity paramActivity)
  {
    if (this.c)
    {
      if (a.a != null) {
        a.a.dispatchPause(paramActivity);
      }
      if (!c.a) {
        b.a().b(paramActivity);
      }
    }
    if (this.a != null)
    {
      this.a.callActivityOnPause(paramActivity);
      return;
    }
    super.callActivityOnPause(paramActivity);
  }
  
  public void callActivityOnRestart(Activity paramActivity)
  {
    if ((this.c) && (a.a != null)) {
      a.a.dispatchStatus(paramActivity, z[1]);
    }
    if (this.a != null)
    {
      this.a.callActivityOnRestart(paramActivity);
      return;
    }
    super.callActivityOnRestart(paramActivity);
  }
  
  public void callActivityOnResume(Activity paramActivity)
  {
    if (this.c)
    {
      if (a.a != null) {
        a.a.dispatchResume(paramActivity);
      }
      if (!c.a) {
        b.a().a(paramActivity);
      }
    }
    if (this.a != null)
    {
      this.a.callActivityOnResume(paramActivity);
      return;
    }
    super.callActivityOnResume(paramActivity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/c/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */