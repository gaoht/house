package com.huawei.hms.support.log.b;

public abstract class a
  extends Thread
{
  private volatile boolean a = true;
  private volatile boolean b = false;
  private b c;
  
  public a(String paramString)
  {
    this(paramString, null);
  }
  
  public a(String paramString, b paramb)
  {
    super(paramString);
    this.c = paramb;
  }
  
  private boolean f()
  {
    return a();
  }
  
  private void g()
  {
    e();
    c();
  }
  
  private boolean h()
  {
    return b();
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected abstract boolean b();
  
  protected void c() {}
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(getName());
    localStringBuilder.append('{');
    localStringBuilder.append(getId());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  protected void e()
  {
    if ((!this.b) && (this.c != null)) {
      this.c.a(this);
    }
  }
  
  public void run()
  {
    if (f()) {}
    for (;;)
    {
      if (this.a) {}
      try
      {
        boolean bool = h();
        if (!bool)
        {
          g();
          return;
        }
      }
      catch (Exception localException)
      {
        try
        {
          sleep(1000L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
  
  public String toString()
  {
    return d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/log/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */