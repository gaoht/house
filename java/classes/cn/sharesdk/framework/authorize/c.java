package cn.sharesdk.framework.authorize;

import android.content.Intent;
import cn.sharesdk.framework.Platform;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class c
  extends a
{
  protected SSOListener b;
  private d c;
  
  public void a(SSOListener paramSSOListener)
  {
    this.b = paramSSOListener;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.c.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate()
  {
    this.c = this.a.getSSOProcessor(this);
    if (this.c == null)
    {
      finish();
      AuthorizeListener localAuthorizeListener = this.a.getAuthorizeListener();
      if (localAuthorizeListener != null) {
        localAuthorizeListener.onError(new Throwable("Failed to start SSO for " + this.a.getPlatform().getName()));
      }
      return;
    }
    this.c.a(32973);
    this.c.a();
  }
  
  @Instrumented
  public void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    this.c.a(paramIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/authorize/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */