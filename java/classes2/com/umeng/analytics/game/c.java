package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.cb;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class c
  implements bx
{
  private com.umeng.analytics.b a = MobclickAgent.getAgent();
  private b b = null;
  private final int c = 100;
  private final int d = 1;
  private final int e = 0;
  private final int f = -1;
  private final int g = 1;
  private final String h = "level";
  private final String i = "pay";
  private final String j = "buy";
  private final String k = "use";
  private final String l = "bonus";
  private final String m = "item";
  private final String n = "cash";
  private final String o = "coin";
  private final String p = "source";
  private final String q = "amount";
  private final String r = "user_level";
  private final String s = "bonus_source";
  private final String t = "level";
  private final String u = "status";
  private final String v = "duration";
  private final String w = "curtype";
  private final String x = "orderid";
  private final String y = "UMGameAgent.init(Context) should be called before any game api";
  private Context z;
  
  public c()
  {
    a.a = true;
  }
  
  private void a(final String paramString, final int paramInt)
  {
    if (this.z == null)
    {
      by.e("UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    bz.a(new cb()
    {
      public void a()
      {
        Object localObject = c.a(c.this).b(paramString);
        if (localObject != null)
        {
          long l = ((b.a)localObject).e();
          if (l <= 0L)
          {
            by.b("level duration is 0");
            return;
          }
          localObject = new HashMap();
          ((HashMap)localObject).put("level", paramString);
          ((HashMap)localObject).put("status", Integer.valueOf(paramInt));
          ((HashMap)localObject).put("duration", Long.valueOf(l));
          if (c.a(c.this).b != null) {
            ((HashMap)localObject).put("user_level", c.a(c.this).b);
          }
          c.c(c.this).a(c.b(c.this), "level", (HashMap)localObject);
          return;
        }
        by.d(String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
      }
    });
  }
  
  public void a()
  {
    by.b("App resume from background");
    if (this.z == null) {
      by.e("UMGameAgent.init(Context) should be called before any game api");
    }
    while (!a.a) {
      return;
    }
    this.b.b();
  }
  
  void a(double paramDouble1, double paramDouble2, int paramInt)
  {
    if (this.z == null)
    {
      by.e("UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cash", Long.valueOf((paramDouble1 * 100.0D)));
    localHashMap.put("coin", Long.valueOf((paramDouble2 * 100.0D)));
    localHashMap.put("source", Integer.valueOf(paramInt));
    if (this.b.b != null) {
      localHashMap.put("user_level", this.b.b);
    }
    if (this.b.a != null) {
      localHashMap.put("level", this.b.a);
    }
    this.a.a(this.z, "pay", localHashMap);
  }
  
  void a(double paramDouble, int paramInt)
  {
    if (this.z == null)
    {
      by.e("UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("coin", Long.valueOf((100.0D * paramDouble)));
    localHashMap.put("bonus_source", Integer.valueOf(paramInt));
    if (this.b.b != null) {
      localHashMap.put("user_level", this.b.b);
    }
    if (this.b.a != null) {
      localHashMap.put("level", this.b.a);
    }
    this.a.a(this.z, "bonus", localHashMap);
  }
  
  void a(double paramDouble1, String paramString1, double paramDouble2, int paramInt, String paramString2)
  {
    if (this.z == null) {
      by.e("UMGameAgent.init(Context) should be called before any game api");
    }
    while ((paramDouble1 < 0.0D) || (paramDouble2 < 0.0D)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.length() > 0) && (paramString1.length() <= 3)) {
      localHashMap.put("curtype", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      int i1 = paramString2.getBytes("UTF-8").length;
      if ((i1 > 0) && (i1 <= 1024)) {
        localHashMap.put("orderid", paramString2);
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    localHashMap.put("cash", Long.valueOf((paramDouble1 * 100.0D)));
    localHashMap.put("coin", Long.valueOf((paramDouble2 * 100.0D)));
    localHashMap.put("source", Integer.valueOf(paramInt));
    if (this.b.b != null) {
      localHashMap.put("user_level", this.b.b);
    }
    if (this.b.a != null) {
      localHashMap.put("level", this.b.a);
    }
    this.a.a(this.z, "pay", localHashMap);
  }
  
  void a(double paramDouble1, String paramString, int paramInt1, double paramDouble2, int paramInt2)
  {
    a(paramDouble1, paramDouble2 * paramInt1, paramInt2);
    a(paramString, paramInt1, paramDouble2);
  }
  
  void a(Context paramContext)
  {
    if (paramContext == null)
    {
      by.e("Context is null, can't init GameAgent");
      return;
    }
    this.z = paramContext.getApplicationContext();
    this.a.a(this);
    this.b = new b(this.z);
    this.a.a(paramContext, 1);
  }
  
  void a(String paramString)
  {
    this.b.b = paramString;
    Object localObject = ba.a(this.z);
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("userlevel", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  void a(String paramString, int paramInt, double paramDouble)
  {
    if (this.z == null)
    {
      by.e("UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("item", paramString);
    localHashMap.put("amount", Integer.valueOf(paramInt));
    localHashMap.put("coin", Long.valueOf((paramInt * paramDouble * 100.0D)));
    if (this.b.b != null) {
      localHashMap.put("user_level", this.b.b);
    }
    if (this.b.a != null) {
      localHashMap.put("level", this.b.a);
    }
    this.a.a(this.z, "buy", localHashMap);
  }
  
  void a(String paramString, int paramInt1, double paramDouble, int paramInt2)
  {
    a(paramInt1 * paramDouble, paramInt2);
    a(paramString, paramInt1, paramDouble);
  }
  
  void a(boolean paramBoolean)
  {
    by.b(String.format("Trace sleep time : %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    a.a = paramBoolean;
  }
  
  public void b()
  {
    if (this.z == null) {
      by.e("UMGameAgent.init(Context) should be called before any game api");
    }
    while (!a.a) {
      return;
    }
    this.b.a();
  }
  
  void b(final String paramString)
  {
    if (this.z == null)
    {
      by.e("UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    this.b.a = paramString;
    bz.a(new cb()
    {
      public void a()
      {
        c.a(c.this).a(paramString);
        HashMap localHashMap = new HashMap();
        localHashMap.put("level", paramString);
        localHashMap.put("status", Integer.valueOf(0));
        if (c.a(c.this).b != null) {
          localHashMap.put("user_level", c.a(c.this).b);
        }
        c.c(c.this).a(c.b(c.this), "level", localHashMap);
      }
    });
  }
  
  void b(String paramString, int paramInt, double paramDouble)
  {
    if (this.z == null)
    {
      by.e("UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("item", paramString);
    localHashMap.put("amount", Integer.valueOf(paramInt));
    localHashMap.put("coin", Long.valueOf((paramInt * paramDouble * 100.0D)));
    if (this.b.b != null) {
      localHashMap.put("user_level", this.b.b);
    }
    if (this.b.a != null) {
      localHashMap.put("level", this.b.a);
    }
    this.a.a(this.z, "use", localHashMap);
  }
  
  void c(String paramString)
  {
    if (this.z == null)
    {
      by.e("UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    a(paramString, 1);
  }
  
  void d(String paramString)
  {
    if (this.z == null)
    {
      by.e("UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    a(paramString, -1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/game/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */