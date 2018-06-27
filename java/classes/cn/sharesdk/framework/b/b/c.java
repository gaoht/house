package cn.sharesdk.framework.b.b;

import com.mob.MobSDK;

public abstract class c
{
  public long e;
  public String f;
  public String g;
  public int h;
  public String i;
  public int j;
  public String k;
  public String l;
  
  protected abstract String a();
  
  protected abstract void a(long paramLong);
  
  protected abstract int b();
  
  protected abstract int c();
  
  protected abstract long d();
  
  protected abstract long e();
  
  protected abstract void f();
  
  public boolean g()
  {
    int m = b();
    int n = c();
    long l1 = System.currentTimeMillis();
    if (l1 - e() < m) {
      return d() < n;
    }
    a(l1);
    return true;
  }
  
  public void h()
  {
    f();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a()).append(':');
    localStringBuilder.append(this.e).append('|');
    localStringBuilder.append(this.f).append('|');
    localStringBuilder.append(MobSDK.getAppkey()).append('|');
    localStringBuilder.append(this.g).append('|');
    localStringBuilder.append(this.h).append('|');
    localStringBuilder.append(this.i).append('|');
    localStringBuilder.append(this.j).append('|');
    localStringBuilder.append(this.k);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */