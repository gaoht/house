package com.ziroom.commonlibrary;

import android.app.Application;
import com.ziroom.commonlib.utils.h;
import okhttp3.OkHttpClient.Builder;

public class a
{
  static Application a;
  
  public static void init(Application paramApplication, int paramInt)
  {
    a = paramApplication;
    h.setsEnvironment(paramInt);
    paramApplication = com.freelxl.baselibrary.d.a.getInstanceBuilder();
    if (h.getsEnvironment() != 4) {
      com.freelxl.baselibrary.d.a.isPrintLog(true);
    }
    com.freelxl.baselibrary.d.a.setInstance(paramApplication.build());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/commonlibrary/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */