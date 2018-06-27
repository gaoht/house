package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;

public class a
  extends l
{
  public String a;
  public String b;
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("_wxapi_sendauth_req_scope", this.a);
    paramBundle.putString("_wxapi_sendauth_req_state", this.b);
  }
  
  public boolean b()
  {
    if ((this.a == null) || (this.a.length() == 0) || (this.a.length() > 1024))
    {
      e.b().d("MicroMsg.SDK.SendAuth.Req", new Object[] { "checkArgs fail, scope is invalid" });
      return false;
    }
    if ((this.b != null) && (this.b.length() > 1024))
    {
      e.b().d("MicroMsg.SDK.SendAuth.Req", new Object[] { "checkArgs fail, state is invalid" });
      return false;
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */