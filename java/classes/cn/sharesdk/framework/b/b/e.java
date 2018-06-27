package cn.sharesdk.framework.b.b;

import android.text.TextUtils;

public class e
  extends c
{
  private static int b;
  private static long c;
  public long a;
  
  protected String a()
  {
    return "[EXT]";
  }
  
  protected void a(long paramLong)
  {
    c = paramLong;
  }
  
  protected int b()
  {
    return 5000;
  }
  
  protected int c()
  {
    return 5;
  }
  
  protected long d()
  {
    return b;
  }
  
  protected long e()
  {
    return c;
  }
  
  protected void f()
  {
    b += 1;
  }
  
  public boolean g()
  {
    cn.sharesdk.framework.b.a.e locale = cn.sharesdk.framework.b.a.e.a();
    b = locale.g("insertExitEventCount");
    c = locale.f("lastInsertExitEventTime");
    return super.g();
  }
  
  public void h()
  {
    super.h();
    cn.sharesdk.framework.b.a.e locale = cn.sharesdk.framework.b.a.e.a();
    locale.a("lastInsertExitEventTime", Long.valueOf(c));
    locale.a("insertExitEventCount", b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append('|');
    if (!TextUtils.isEmpty(this.l)) {
      localStringBuilder.append(this.l);
    }
    localStringBuilder.append('|').append(Math.round((float)this.a / 1000.0F));
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */