package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;

public class WXMiniProgramObject
  implements WXMediaMessage.IMediaObject
{
  public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
  public static final int MINIPROGRAM_TYPE_TEST = 1;
  public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
  public int miniprogramType = 0;
  public String path;
  public String userName;
  public String webpageUrl;
  public boolean withShareTicket;
  
  public boolean checkArgs()
  {
    boolean bool = true;
    if ((this.webpageUrl == null) || (this.webpageUrl.length() == 0) || (this.webpageUrl.length() > 10240))
    {
      e.b().d("checkArgs fail, webpageUrl is invalid", new Object[0]);
      bool = false;
    }
    do
    {
      return bool;
      if ((this.userName == null) || (this.userName.length() == 0) || (this.userName.length() > 10240))
      {
        e.b().d("checkArgs fail, userName is invalid", new Object[0]);
        return false;
      }
    } while ((this.miniprogramType >= 0) && (this.miniprogramType <= 2));
    e.b().d("checkArgs fail", new Object[] { "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW" });
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxminiprogram_username", this.userName);
    paramBundle.putString("_wxminiprogram_path", this.path);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
    paramBundle.putInt("_wxminiprogram_type", this.miniprogramType);
  }
  
  public int type()
  {
    return 36;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.webpageUrl = paramBundle.getString("_wxminiprogram_webpageurl");
    this.userName = paramBundle.getString("_wxminiprogram_username");
    this.path = paramBundle.getString("_wxminiprogram_path");
    this.withShareTicket = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    this.miniprogramType = paramBundle.getInt("_wxminiprogram_type");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/WXMiniProgramObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */