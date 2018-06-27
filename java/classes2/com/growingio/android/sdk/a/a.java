package com.growingio.android.sdk.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Pair;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.utils.HttpService;
import com.growingio.android.sdk.utils.HttpService.Builder;
import com.growingio.android.sdk.utils.LogUtil;
import java.net.URLEncoder;

public class a
  extends AsyncTask<Void, Void, Void>
{
  protected Void a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = AppState.l();
      DeviceUUIDFactory localDeviceUUIDFactory = paramVarArgs.m();
      paramVarArgs = NetworkConfig.a().h() + "/" + paramVarArgs.c() + "/android/devices?u=" + localDeviceUUIDFactory.a() + "&dm=" + URLEncoder.encode(new StringBuilder().append(Build.BRAND).append(" ").append(Build.MODEL).toString(), "UTF-8") + "&osv=" + URLEncoder.encode(new StringBuilder().append("Android ").append(Build.VERSION.RELEASE).toString(), "UTF-8") + "&d=" + paramVarArgs.b() + "&ui=" + localDeviceUUIDFactory.b() + "&um=" + localDeviceUUIDFactory.c() + "&mac=" + localDeviceUUIDFactory.c() + "&imei=" + localDeviceUUIDFactory.e() + "&adrid=" + localDeviceUUIDFactory.d() + "&uuid=" + localDeviceUUIDFactory.f();
      LogUtil.d("T_SEND", new Object[] { "发送事件：" + paramVarArgs });
      for (;;)
      {
        if (((Integer)new HttpService.Builder().a(paramVarArgs).a().b().first).intValue() == 200)
        {
          LogUtil.d("T_SEND", new Object[] { "得到反馈" });
          GConfig.s().E();
          return null;
        }
        Thread.sleep(10000L);
      }
      return null;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */