package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;

public class a
  extends FakeActivity
{
  protected AuthorizeHelper a;
  
  public AuthorizeHelper a()
  {
    return this.a;
  }
  
  public void a(AuthorizeHelper paramAuthorizeHelper)
  {
    this.a = paramAuthorizeHelper;
    super.show(MobSDK.getContext(), null);
  }
  
  public void show(Context paramContext, Intent paramIntent)
  {
    throw new RuntimeException("This method is deprecated, use show(AuthorizeHelper, Intent) instead");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/authorize/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */