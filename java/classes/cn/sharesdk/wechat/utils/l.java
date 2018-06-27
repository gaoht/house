package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public abstract class l
{
  public String d;
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("_wxapi_command_type", a());
    paramBundle.putString("_wxapi_basereq_transaction", this.d);
  }
  
  public abstract boolean b();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */