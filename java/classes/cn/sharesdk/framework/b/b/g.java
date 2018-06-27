package cn.sharesdk.framework.b.b;

import android.text.TextUtils;
import cn.sharesdk.framework.b.a.e;

public class g
  extends c
{
  private static int a;
  private static long b;
  
  protected String a()
  {
    return "[RUN]";
  }
  
  protected void a(long paramLong)
  {
    b = paramLong;
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
    return a;
  }
  
  protected long e()
  {
    return b;
  }
  
  protected void f()
  {
    a += 1;
  }
  
  public boolean g()
  {
    e locale = e.a();
    a = locale.g("insertRunEventCount");
    b = locale.f("lastInsertRunEventTime");
    return super.g();
  }
  
  public void h()
  {
    super.h();
    e locale = e.a();
    locale.a("lastInsertRunEventTime", Long.valueOf(b));
    locale.a("insertRunEventCount", a);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append('|');
    if (!TextUtils.isEmpty(this.l)) {
      localStringBuilder.append(this.l);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */