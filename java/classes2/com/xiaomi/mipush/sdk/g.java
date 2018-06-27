package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.metok.geofencing.a;
import com.xiaomi.xmpush.thrift.h;
import com.xiaomi.xmpush.thrift.j;
import com.xiaomi.xmpush.thrift.l;

public class g
{
  private final int a = -1;
  private final double b = 0.0D;
  private a c;
  private Context d;
  
  public g(Context paramContext)
  {
    this.d = paramContext;
    a();
  }
  
  private void a()
  {
    this.c = new a(this.d);
  }
  
  public void a(String paramString)
  {
    this.c.a(this.d, "com.xiaomi.xmsf", paramString);
  }
  
  public boolean a(j paramj)
  {
    if (paramj == null) {
      return false;
    }
    if ((paramj.m() != null) && (paramj.o() > 0.0D))
    {
      l locall = paramj.m();
      this.c.a(this.d, locall.c(), locall.a(), (float)paramj.o(), -1L, "com.xiaomi.xmsf", paramj.a(), paramj.s().name());
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */