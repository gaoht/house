package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.e;

public class a
{
  private static a a;
  private Context b;
  private a c;
  
  private a(Context paramContext)
  {
    this.b = paramContext;
    o();
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      a = new a(paramContext);
    }
    return a;
  }
  
  private void o()
  {
    this.c = new a(null);
    SharedPreferences localSharedPreferences = j();
    this.c.a = localSharedPreferences.getString("appId", null);
    this.c.b = localSharedPreferences.getString("appToken", null);
    this.c.c = localSharedPreferences.getString("regId", null);
    this.c.d = localSharedPreferences.getString("regSec", null);
    this.c.f = localSharedPreferences.getString("devId", null);
    if ((!TextUtils.isEmpty(this.c.f)) && (this.c.f.startsWith("a-")))
    {
      this.c.f = e.e(this.b);
      localSharedPreferences.edit().putString("devId", this.c.f).commit();
    }
    this.c.e = localSharedPreferences.getString("vName", null);
    this.c.h = localSharedPreferences.getBoolean("valid", true);
    this.c.i = localSharedPreferences.getBoolean("paused", false);
    this.c.j = localSharedPreferences.getInt("envType", 1);
    this.c.g = localSharedPreferences.getString("regResource", null);
  }
  
  public void a(int paramInt)
  {
    this.c.a(paramInt);
    j().edit().putInt("envType", paramInt).commit();
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = j().edit();
    localEditor.putString("vName", paramString);
    localEditor.commit();
    this.c.e = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramString1, paramString2, paramString3);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
    j().edit().putBoolean("paused", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return !TextUtils.equals(com.xiaomi.channel.commonutils.android.b.a(this.b, this.b.getPackageName()), this.c.e);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.c.b(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    if (!this.c.a())
    {
      com.xiaomi.channel.commonutils.logger.b.a("Don't send message before initialization succeeded!");
      return false;
    }
    return true;
  }
  
  public String c()
  {
    return this.c.a;
  }
  
  public String d()
  {
    return this.c.b;
  }
  
  public String e()
  {
    return this.c.c;
  }
  
  public String f()
  {
    return this.c.d;
  }
  
  public String g()
  {
    return this.c.g;
  }
  
  public void h()
  {
    this.c.b();
  }
  
  public boolean i()
  {
    return this.c.a();
  }
  
  public SharedPreferences j()
  {
    return this.b.getSharedPreferences("mipush", 0);
  }
  
  public void k()
  {
    this.c.c();
  }
  
  public boolean l()
  {
    return this.c.i;
  }
  
  public int m()
  {
    return this.c.j;
  }
  
  public boolean n()
  {
    return !this.c.h;
  }
  
  private class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h = true;
    public boolean i = false;
    public int j = 1;
    
    private a() {}
    
    private String d()
    {
      return com.xiaomi.channel.commonutils.android.b.a(a.a(a.this), a.a(a.this).getPackageName());
    }
    
    public void a(int paramInt)
    {
      this.j = paramInt;
    }
    
    public void a(String paramString1, String paramString2)
    {
      this.c = paramString1;
      this.d = paramString2;
      this.f = e.e(a.a(a.this));
      this.e = d();
      this.h = true;
      SharedPreferences.Editor localEditor = a.this.j().edit();
      localEditor.putString("regId", paramString1);
      localEditor.putString("regSec", paramString2);
      localEditor.putString("devId", this.f);
      localEditor.putString("vName", d());
      localEditor.putBoolean("valid", true);
      localEditor.commit();
    }
    
    public void a(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.g = paramString3;
      paramString1 = a.this.j().edit();
      paramString1.putString("appId", this.a);
      paramString1.putString("appToken", paramString2);
      paramString1.putString("regResource", paramString3);
      paramString1.commit();
    }
    
    public void a(boolean paramBoolean)
    {
      this.i = paramBoolean;
    }
    
    public boolean a()
    {
      return b(this.a, this.b);
    }
    
    public void b()
    {
      a.this.j().edit().clear().commit();
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.f = null;
      this.e = null;
      this.h = false;
      this.i = false;
      this.j = 1;
    }
    
    public boolean b(String paramString1, String paramString2)
    {
      return (TextUtils.equals(this.a, paramString1)) && (TextUtils.equals(this.b, paramString2)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)) && (TextUtils.equals(this.f, e.e(a.a(a.this))));
    }
    
    public void c()
    {
      this.h = false;
      a.this.j().edit().putBoolean("valid", this.h).commit();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */