package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;

public class d
  extends l
{
  public WXMediaMessage a;
  public int b;
  
  public int a()
  {
    return 2;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putAll(WXMediaMessage.a.a(this.a));
    paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.b);
  }
  
  public boolean b()
  {
    if ((this.a.getType() == 8) && ((this.a.thumbData == null) || (this.a.thumbData.length <= 0)))
    {
      e.b().d("checkArgs fail, thumbData should not be null when send emoji", new Object[0]);
      return false;
    }
    if ((this.a.thumbData != null) && (this.a.thumbData.length > 32768))
    {
      e.b().d("checkArgs fail, thumbData is invalid", new Object[0]);
      return false;
    }
    if ((this.a.title != null) && (this.a.title.length() > 512))
    {
      e.b().d("checkArgs fail, title is invalid", new Object[0]);
      return false;
    }
    if ((this.a.description != null) && (this.a.description.length() > 1024)) {
      this.a.description = (this.a.description.substring(0, 1021) + "...");
    }
    if (this.a.mediaObject == null)
    {
      e.b().d("checkArgs fail, mediaObject is null", new Object[0]);
      return false;
    }
    return this.a.mediaObject.checkArgs();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */