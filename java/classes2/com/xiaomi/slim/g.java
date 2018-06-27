package com.xiaomi.slim;

class g
  extends Thread
{
  g(f paramf, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    try
    {
      f.a(this.a).a();
      return;
    }
    catch (Exception localException)
    {
      this.a.c(9, localException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/slim/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */