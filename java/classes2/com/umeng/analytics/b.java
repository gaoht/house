package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.f;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

public class b
  implements ay
{
  private static final String j = "sp";
  private Context a = null;
  private bx b;
  private as c = new as();
  private bf d = new bf();
  private bd e = new bd();
  private at f = null;
  private ar g = null;
  private ap h = null;
  private m i = null;
  private boolean k = false;
  private boolean l = false;
  private JSONObject m = null;
  private boolean n = false;
  
  b()
  {
    this.c.a(this);
  }
  
  private void g(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((Build.VERSION.SDK_INT > 13) && (!this.n) && ((paramContext instanceof Activity)))
        {
          this.h = new ap((Activity)paramContext);
          this.n = true;
        }
        if (!this.k)
        {
          this.a = paramContext.getApplicationContext();
          this.f = new at(this.a);
          this.g = ar.b(this.a);
          this.k = true;
          if (this.i == null) {
            this.i = m.a(this.a);
          }
          if (!this.l)
          {
            bz.b(new cb()
            {
              public void a()
              {
                b.a(b.this).a(new f()
                {
                  public void a(Object paramAnonymous2Object, boolean paramAnonymous2Boolean)
                  {
                    b.a(b.this, true);
                  }
                });
              }
            });
            return;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
  }
  
  private void h(Context paramContext)
  {
    this.e.c(paramContext);
    if (this.b != null) {
      this.b.a();
    }
  }
  
  private void i(Context paramContext)
  {
    this.e.d(paramContext);
    bf.a(paramContext);
    ap.b(paramContext);
    this.g.a(this.a).a(paramContext);
    if (this.b != null) {
      this.b.b();
    }
  }
  
  private JSONObject j(Context paramContext)
  {
    try
    {
      paramContext = ba.a(paramContext).getString("sp", null);
      if (!TextUtils.isEmpty(paramContext))
      {
        paramContext = new JSONObject(paramContext);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public bd a()
  {
    return this.e;
  }
  
  void a(double paramDouble1, double paramDouble2)
  {
    if (AnalyticsConfig.a == null) {
      AnalyticsConfig.a = new double[2];
    }
    AnalyticsConfig.a[0] = paramDouble1;
    AnalyticsConfig.a[1] = paramDouble2;
  }
  
  void a(long paramLong)
  {
    AnalyticsConfig.sLatentWindow = (int)paramLong * 1000;
  }
  
  void a(final Context paramContext)
  {
    if (paramContext == null)
    {
      by.e("unexpected null context in onResume");
      return;
    }
    if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
      this.d.a(paramContext.getClass().getName());
    }
    try
    {
      if ((!this.k) || (!this.n)) {
        g(paramContext);
      }
      bz.a(new cb()
      {
        public void a()
        {
          b.a(b.this, paramContext.getApplicationContext());
        }
      });
      return;
    }
    catch (Exception paramContext)
    {
      by.e("Exception occurred in Mobclick.onResume(). ", paramContext);
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    AnalyticsConfig.a(paramContext, paramInt);
  }
  
  void a(Context paramContext, MobclickAgent.EScenarioType paramEScenarioType)
  {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
    if (paramEScenarioType != null) {
      a(paramContext, paramEScenarioType.toValue());
    }
  }
  
  void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (paramContext == null)
      {
        by.e("unexpected null context in reportError");
        return;
      }
      try
      {
        if ((!this.k) || (!this.n)) {
          g(paramContext);
        }
        paramContext = new JSONObject();
        paramContext.put("ts", System.currentTimeMillis());
        paramContext.put("error_source", 2);
        paramContext.put("context", paramString);
        w.a(this.a).a(bd.a(), paramContext.toString(), 2);
        return;
      }
      catch (Exception paramContext) {}
    } while (!by.a);
    by.e(paramContext);
  }
  
  public void a(Context paramContext, String paramString, Object paramObject) {}
  
  public void a(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      if ((!this.k) || (!this.n)) {
        g(paramContext);
      }
      this.f.a(paramString1, paramString2, paramLong, paramInt);
      return;
    }
    catch (Exception paramContext)
    {
      while (!by.a) {}
      by.e(paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString, HashMap<String, Object> paramHashMap)
  {
    try
    {
      if ((!this.k) || (!this.n)) {
        g(paramContext);
      }
      this.f.b(paramString, paramHashMap);
      return;
    }
    catch (Exception paramContext)
    {
      while (!by.a) {}
      by.e(paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString, Map<String, Object> paramMap) {}
  
  void a(Context paramContext, String paramString, Map<String, Object> paramMap, long paramLong)
  {
    try
    {
      if ((!this.k) || (!this.n)) {
        g(paramContext);
      }
      this.f.a(paramString, paramMap, paramLong);
      return;
    }
    catch (Exception paramContext)
    {
      while (!by.a) {}
      by.e(paramContext);
    }
  }
  
  void a(Context paramContext, Throwable paramThrowable)
  {
    if ((paramContext == null) || (paramThrowable == null)) {}
    do
    {
      return;
      try
      {
        a(paramContext, bt.a(paramThrowable));
        return;
      }
      catch (Exception paramContext) {}
    } while (!by.a);
    by.e(paramContext);
  }
  
  public void a(Context paramContext, List<String> paramList)
  {
    try
    {
      if ((!this.k) || (!this.n)) {
        g(paramContext);
      }
      this.f.a(paramContext, paramList);
      return;
    }
    catch (Exception paramContext)
    {
      by.e(paramContext);
    }
  }
  
  public void a(Context paramContext, List<String> paramList, int paramInt, String paramString)
  {
    try
    {
      if ((!this.k) || (!this.n)) {
        g(paramContext);
      }
      this.f.a(paramList, paramInt, paramString);
      return;
    }
    catch (Exception paramContext)
    {
      while (!by.a) {}
      by.e(paramContext);
    }
  }
  
  void a(MobclickAgent.UMAnalyticsConfig paramUMAnalyticsConfig)
  {
    if (paramUMAnalyticsConfig.mContext != null) {
      this.a = paramUMAnalyticsConfig.mContext.getApplicationContext();
    }
    if (!TextUtils.isEmpty(paramUMAnalyticsConfig.mAppkey))
    {
      AnalyticsConfig.a(paramUMAnalyticsConfig.mContext, paramUMAnalyticsConfig.mAppkey);
      if (!TextUtils.isEmpty(paramUMAnalyticsConfig.mChannelId)) {
        AnalyticsConfig.a(paramUMAnalyticsConfig.mChannelId);
      }
      AnalyticsConfig.CATCH_EXCEPTION = paramUMAnalyticsConfig.mIsCrashEnable;
      a(this.a, paramUMAnalyticsConfig.mType);
      return;
    }
    by.e("the appkey is null!");
  }
  
  public void a(bx parambx)
  {
    this.b = parambx;
  }
  
  void a(String paramString)
  {
    if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {}
    try
    {
      this.d.a(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  void a(final String paramString1, final String paramString2)
  {
    try
    {
      bz.a(new cb()
      {
        public void a()
        {
          String[] arrayOfString = c.a(b.b(b.this));
          if ((arrayOfString == null) || (!paramString1.equals(arrayOfString[0])) || (!paramString2.equals(arrayOfString[1])))
          {
            b.c(b.this).a(b.b(b.this)).a(b.b(b.this));
            boolean bool = b.this.a().e(b.b(b.this));
            ar.b(b.b(b.this)).b();
            if (bool) {
              b.this.a().f(b.b(b.this));
            }
            c.a(b.b(b.this), paramString1, paramString2);
          }
        }
      });
      return;
    }
    catch (Exception paramString1)
    {
      while (!by.a) {}
      by.e(" Excepthon  in  onProfileSignIn", paramString1);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    try
    {
      this.d.a();
      if (this.a != null)
      {
        if ((paramThrowable != null) && (this.g != null))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("ts", System.currentTimeMillis());
          localJSONObject.put("error_source", 1);
          localJSONObject.put("context", bt.a(paramThrowable));
          w.a(this.a).a(bd.a(), localJSONObject.toString(), 1);
        }
        this.i.e();
        this.h.a(this.a);
        i(this.a);
        ba.a(this.a).edit().commit();
      }
      bz.a();
      return;
    }
    catch (Exception paramThrowable)
    {
      while (!by.a) {}
      by.e("Exception in onAppCrash", paramThrowable);
    }
  }
  
  void a(GL10 paramGL10)
  {
    paramGL10 = bv.a(paramGL10);
    if (paramGL10.length == 2)
    {
      AnalyticsConfig.GPU_VENDER = paramGL10[0];
      AnalyticsConfig.GPU_RENDERER = paramGL10[1];
    }
  }
  
  void a(boolean paramBoolean)
  {
    AnalyticsConfig.CATCH_EXCEPTION = paramBoolean;
  }
  
  void b()
  {
    try
    {
      bz.a(new cb()
      {
        public void a()
        {
          String[] arrayOfString = c.a(b.b(b.this));
          if ((arrayOfString != null) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
          {
            b.c(b.this).a(b.b(b.this)).a(b.b(b.this));
            boolean bool = b.this.a().e(b.b(b.this));
            ar.b(b.b(b.this)).b();
            if (bool) {
              b.this.a().f(b.b(b.this));
            }
            c.b(b.b(b.this));
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      while (!by.a) {}
      by.e(" Excepthon  in  onProfileSignOff", localException);
    }
  }
  
  void b(long paramLong)
  {
    AnalyticsConfig.kContinueSessionMillis = paramLong;
  }
  
  void b(final Context paramContext)
  {
    if (paramContext == null) {
      by.e("unexpected null context in onPause");
    }
    do
    {
      return;
      if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
        this.d.b(paramContext.getClass().getName());
      }
      try
      {
        if ((!this.k) || (!this.n)) {
          g(paramContext);
        }
        bz.a(new cb()
        {
          public void a()
          {
            b.b(b.this, paramContext.getApplicationContext());
            b.a(b.this).f();
          }
        });
        return;
      }
      catch (Exception paramContext) {}
    } while (!by.a);
    by.e("Exception occurred in Mobclick.onRause(). ", paramContext);
  }
  
  void b(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
    AnalyticsConfig.b(paramContext, paramString);
  }
  
  void b(String paramString)
  {
    if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {}
    try
    {
      this.d.b(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  void b(boolean paramBoolean)
  {
    AnalyticsConfig.ACTIVITY_DURATION_OPEN = paramBoolean;
  }
  
  void c(Context paramContext)
  {
    try
    {
      if ((!this.k) || (!this.n)) {
        g(paramContext);
      }
      this.g.a();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public void c(Context paramContext, String paramString) {}
  
  void c(boolean paramBoolean)
  {
    a.d = paramBoolean;
  }
  
  public Object d(Context paramContext, String paramString)
  {
    return null;
  }
  
  void d(Context paramContext)
  {
    try
    {
      this.h.a(paramContext);
      this.d.a();
      i(paramContext);
      ba.a(paramContext).edit().commit();
      this.i.d();
      bz.a();
      return;
    }
    catch (Exception paramContext)
    {
      while (!by.a) {}
      paramContext.printStackTrace();
    }
  }
  
  void d(boolean paramBoolean)
  {
    by.a = paramBoolean;
  }
  
  public String e(Context paramContext)
  {
    return null;
  }
  
  void e(boolean paramBoolean)
  {
    AnalyticsConfig.a(paramBoolean);
  }
  
  public void f(Context paramContext) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */