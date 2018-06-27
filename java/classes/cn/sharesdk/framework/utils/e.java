package cn.sharesdk.framework.utils;

import cn.sharesdk.framework.ShareSDK;
import com.mob.commons.logcollector.LogsCollector;
import com.mob.tools.log.NLog;

public class e
  extends NLog
{
  private e()
  {
    setCollector("SHARESDK", new LogsCollector()
    {
      protected String getSDKTag()
      {
        return "SHARESDK";
      }
      
      protected int getSDKVersion()
      {
        return ShareSDK.SDK_VERSION_CODE;
      }
    });
  }
  
  public static NLog a()
  {
    return new e();
  }
  
  public static NLog b()
  {
    return getInstanceForSDK("SHARESDK", true);
  }
  
  protected String getSDKTag()
  {
    return "SHARESDK";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */