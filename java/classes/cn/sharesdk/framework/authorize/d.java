package cn.sharesdk.framework.authorize;

import android.content.Intent;

public abstract class d
{
  protected c a;
  protected int b;
  protected SSOListener c;
  
  public d(c paramc)
  {
    this.a = paramc;
    this.c = paramc.a().getSSOListener();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Intent paramIntent) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/authorize/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */