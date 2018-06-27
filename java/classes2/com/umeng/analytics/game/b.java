package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.ba;
import java.io.Serializable;

public class b
{
  public String a;
  public String b;
  private Context c;
  private final String d = "um_g_cache";
  private final String e = "single_level";
  private final String f = "stat_player_level";
  private final String g = "stat_game_level";
  private a h = null;
  
  public b(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public a a(String paramString)
  {
    this.h = new a(paramString);
    this.h.a();
    return this.h;
  }
  
  public void a()
  {
    if (this.h != null)
    {
      this.h.b();
      SharedPreferences.Editor localEditor = this.c.getSharedPreferences("um_g_cache", 0).edit();
      localEditor.putString("single_level", ax.a(this.h));
      localEditor.putString("stat_player_level", this.b);
      localEditor.putString("stat_game_level", this.a);
      localEditor.commit();
    }
  }
  
  public a b(String paramString)
  {
    if (this.h != null)
    {
      this.h.d();
      if (this.h.a(paramString))
      {
        paramString = this.h;
        this.h = null;
        return paramString;
      }
    }
    return null;
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = ba.a(this.c, "um_g_cache");
    Object localObject = localSharedPreferences.getString("single_level", null);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.h = ((a)ax.a((String)localObject));
      if (this.h != null) {
        this.h.c();
      }
    }
    if (TextUtils.isEmpty(this.b))
    {
      this.b = localSharedPreferences.getString("stat_player_level", null);
      if (this.b == null)
      {
        localObject = ba.a(this.c);
        if (localObject != null) {}
      }
    }
    while (this.a != null)
    {
      return;
      this.b = ((SharedPreferences)localObject).getString("userlevel", null);
    }
    this.a = localSharedPreferences.getString("stat_game_level", null);
  }
  
  static class a
    implements Serializable
  {
    private static final long a = 20140327L;
    private String b;
    private long c;
    private long d;
    
    public a(String paramString)
    {
      this.b = paramString;
    }
    
    public void a()
    {
      this.d = System.currentTimeMillis();
    }
    
    public boolean a(String paramString)
    {
      return this.b.equals(paramString);
    }
    
    public void b()
    {
      this.c += System.currentTimeMillis() - this.d;
      this.d = 0L;
    }
    
    public void c()
    {
      a();
    }
    
    public void d()
    {
      b();
    }
    
    public long e()
    {
      return this.c;
    }
    
    public String f()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/game/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */