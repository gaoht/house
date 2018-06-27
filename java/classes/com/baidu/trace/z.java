package com.baidu.trace;

import android.content.Context;
import com.baidu.lbsapi.auth.tracesdk.LBSAuthManager;
import com.baidu.trace.c.e;
import com.baidu.trace.c.g;
import org.json.JSONObject;

public class z
  implements g
{
  protected static String a = "";
  protected static long b = 0L;
  protected static String c = "";
  protected static String d = "";
  protected static String e = "";
  protected static String f = "";
  protected static String g = "";
  protected static String h = "";
  protected static String i = "";
  protected static String j = "";
  protected static String k = "";
  protected static String l = "";
  protected static String m = "";
  protected static byte n;
  protected static byte o;
  protected static byte p = 15;
  protected static byte q = 30;
  protected static byte r;
  protected static byte s = 1;
  protected static byte t;
  protected static byte u;
  protected static byte v;
  protected static byte w = 5;
  
  protected static void a(Context paramContext)
  {
    LBSAuthManager localLBSAuthManager = LBSAuthManager.getInstance(paramContext);
    k = localLBSAuthManager.getCUID();
    h = localLBSAuthManager.getDeviceID();
    i = localLBSAuthManager.getIMEI();
    j = e.b(paramContext);
    f = com.baidu.trace.c.f.c;
    g = "3.0.7";
    l = com.baidu.trace.c.f.a;
    m = com.baidu.trace.c.f.b;
  }
  
  public final void a() {}
  
  public final void a(JSONObject paramJSONObject)
  {
    az.b = 0;
    com.baidu.trace.a.f localf = new com.baidu.trace.a.f();
    try
    {
      localf.a = ((byte)paramJSONObject.getInt("operat_result"));
      localf.i = ((byte)paramJSONObject.getInt("is_activated"));
      localf.b = ((byte)paramJSONObject.getInt("heartbeat_period"));
      localf.c = ((byte)paramJSONObject.getInt("packed_data_transmit_period"));
      localf.d = ((byte)paramJSONObject.getInt("packed_data_capacity"));
      localf.e = ((byte)paramJSONObject.getInt("packed_data_need_response"));
      localf.f = ((byte)paramJSONObject.getInt("module_switch"));
      localf.g = ((byte)paramJSONObject.getInt("sensor_wakeup_threshold"));
      localf.h = ((byte)paramJSONObject.getInt("volume_size"));
      localf.j = ((byte)paramJSONObject.getInt("location_info_sample_period"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      localf.a = 0;
      localf.b = 15;
      localf.f = 31;
      localf.d = 96;
      localf.e = 1;
      localf.c = 30;
      localf.j = 5;
      localf.g = 5;
      localf.h = 50;
      return;
    }
    finally
    {
      bc.a().a(localf);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */