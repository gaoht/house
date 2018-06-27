package com.growingio.android.sdk.circle.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.widget.Toast;
import com.growingio.android.sdk.a.c.b;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.VdsJsBridgeManager;
import com.growingio.android.sdk.models.i;
import com.growingio.android.sdk.models.j;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final Object e = new Object();
  private static a f;
  private boolean a = false;
  private boolean b = false;
  private e c;
  private c d;
  private j g = new j()
  {
    public void b(i paramAnonymousi)
    {
      AppState localAppState;
      JSONObject localJSONObject;
      if (((paramAnonymousi.c instanceof WebView)) || (ClassExistHelper.instanceOfX5WebView(paramAnonymousi.c)))
      {
        paramAnonymousi = paramAnonymousi.c;
        if (VdsJsBridgeManager.isWebViewHooked(paramAnonymousi))
        {
          if (!a.c(a.this)) {
            break label144;
          }
          localAppState = AppState.l();
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("ai", localAppState.c());
        localJSONObject.put("d", localAppState.b());
        localJSONObject.put("p", localAppState.y());
        localJSONObject.put("token", com.growingio.android.sdk.a.e.a().d());
        Util.a(paramAnonymousi, "_vds_hybrid.showHeatMap", new Object[] { localJSONObject });
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.d("GIO.HeatMapManager", "generate openHeatMapObject json error :" + localJSONException);
        }
      }
      label144:
      Util.a(paramAnonymousi, "_vds_hybrid.hideHeatMap", new Object[0]);
    }
  };
  
  private void a(String paramString)
  {
    Toast.makeText(AppState.l().i(), paramString, 0).show();
  }
  
  private void a(com.growingio.android.sdk.models.c[] paramArrayOfc, String paramString)
  {
    if (AppState.l().y().equals(paramString))
    {
      this.d.a(paramArrayOfc);
      this.c.a(paramArrayOfc);
    }
  }
  
  public static a b()
  {
    synchronized (e)
    {
      if (f == null) {
        f = new a();
      }
      return f;
    }
  }
  
  private Activity h()
  {
    return AppState.l().i();
  }
  
  private void i()
  {
    ThreadUtils.b(new Runnable()
    {
      public void run()
      {
        if (a.a(a.this) != null) {
          ViewHelper.a(a.a(a.this).getWindow().getDecorView(), "", a.b(a.this));
        }
      }
    });
  }
  
  @SuppressLint({"RtlHardcoded"})
  @TargetApi(8)
  public void a()
  {
    if (this.b) {
      return;
    }
    this.c = new e(AppState.l().k());
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, com.growingio.android.sdk.circle.c.a, 312, -3);
    localLayoutParams.gravity = 51;
    localLayoutParams.setTitle("HeatMapView");
    ((WindowManager)AppState.l().k().getSystemService("window")).addView(this.c, localLayoutParams);
    this.c.setVisibility(8);
    this.d = new c(this.c);
    this.b = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (paramBoolean)
    {
      g();
      return;
    }
    i();
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.c.a();
    this.d.c();
  }
  
  public void e()
  {
    this.c.b();
    if (this.d != null) {
      this.d.b();
    }
  }
  
  public void f()
  {
    if (this.a) {
      this.d.c();
    }
  }
  
  public void g()
  {
    this.c.c();
    this.d.a();
    final String str = AppState.l().y();
    com.growingio.android.sdk.a.c.a(str, new c.b()
    {
      public void a(d paramAnonymousd)
      {
        if (paramAnonymousd == null)
        {
          a.a(a.this, "请求热图数据失败");
          return;
        }
        if (paramAnonymousd.a())
        {
          a.a(a.this, paramAnonymousd.c(), str);
          return;
        }
        a.a(a.this, "请求热图数据失败:" + paramAnonymousd.b());
      }
    });
    i();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */