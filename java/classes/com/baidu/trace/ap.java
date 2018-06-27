package com.baidu.trace;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.trace.model.OnTraceListener;
import java.io.PrintWriter;
import java.io.StringWriter;

final class ap
  implements ServiceConnection
{
  ap(LBSTraceClient paramLBSTraceClient) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LBSTraceClient.a(this.a, IService.Stub.asInterface(paramIBinder));
    try
    {
      LBSTraceClient.b(this.a).registerListener(LBSTraceClient.a(this.a));
      return;
    }
    catch (Exception paramComponentName)
    {
      do
      {
        paramIBinder = new StringWriter();
        paramComponentName.printStackTrace(new PrintWriter(paramIBinder));
        a.a("BaiduTraceSDK", "register client listener failed, Exception : " + paramIBinder.toString());
      } while (LBSTraceClient.c(this.a) == null);
      LBSTraceClient.c(this.a).onBindServiceCallback(1, "失败");
      return;
    }
    finally
    {
      if (LBSTraceClient.c(this.a) != null) {
        LBSTraceClient.c(this.a).onBindServiceCallback(0, "成功");
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    LBSTraceClient.a(this.a, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */