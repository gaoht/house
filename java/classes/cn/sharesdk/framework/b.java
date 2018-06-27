package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.c;
import cn.sharesdk.framework.authorize.d;
import cn.sharesdk.framework.authorize.e;

public abstract class b
  implements AuthorizeHelper
{
  protected Platform a;
  private AuthorizeListener b;
  private SSOListener c;
  
  public b(Platform paramPlatform)
  {
    this.a = paramPlatform;
  }
  
  protected void a(SSOListener paramSSOListener)
  {
    this.c = paramSSOListener;
    c localc = new c();
    localc.a(paramSSOListener);
    localc.a(this);
  }
  
  protected void b(AuthorizeListener paramAuthorizeListener)
  {
    this.b = paramAuthorizeListener;
    paramAuthorizeListener = new e();
    paramAuthorizeListener.a(this.b);
    paramAuthorizeListener.a(this);
  }
  
  public int c()
  {
    return this.a.getPlatformId();
  }
  
  public AuthorizeListener getAuthorizeListener()
  {
    return this.b;
  }
  
  public Platform getPlatform()
  {
    return this.a;
  }
  
  public SSOListener getSSOListener()
  {
    return this.c;
  }
  
  public d getSSOProcessor(c paramc)
  {
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */