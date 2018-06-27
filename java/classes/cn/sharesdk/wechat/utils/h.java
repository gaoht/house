package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;

public class h
{
  public static final class a
    extends l
  {
    public String a;
    public String b = "";
    public int c = 0;
    
    public final int a()
    {
      return 19;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_username", this.a);
      paramBundle.putString("_launch_wxminiprogram_path", this.b);
      paramBundle.putInt("_launch_wxminiprogram_type", this.c);
    }
    
    public final boolean b()
    {
      boolean bool = true;
      if ((this.a == null) || (this.a.length() == 0) || (this.a.length() > 10240))
      {
        e.b().d("checkArgs fail, userName is invalid", new Object[0]);
        bool = false;
      }
      while ((this.c >= 0) && (this.c <= 2)) {
        return bool;
      }
      e.b().d("checkArgs fail", new Object[] { "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW" });
      return false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */