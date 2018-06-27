package com.growingio.android.sdk.a;

import android.annotation.TargetApi;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.HttpService;
import com.growingio.android.sdk.utils.HttpService.Builder;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(11)
class d
{
  private static final Object b = new Object();
  private static d c;
  HttpService.Builder a = new HttpService.Builder();
  
  public static d a()
  {
    synchronized (b)
    {
      if (c == null) {
        c = new d();
      }
      d locald = c;
      return locald;
    }
  }
  
  static AppState b()
  {
    return AppState.l();
  }
  
  static e c()
  {
    return e.a();
  }
  
  Pair<Integer, byte[]> a(String paramString)
  {
    return a(paramString, "GET", null);
  }
  
  Pair<Integer, byte[]> a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    LogUtil.d("GIO.HttpUtil", new Object[] { "request" });
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Type", "application/json");
    localHashMap.put("Accept", "application/json");
    localHashMap.put("token", c().d());
    localHashMap.put("accountId", AppState.l().c());
    LogUtil.d("GIO.HttpUtil", new Object[] { "request headers:\n token:" + c().d() + "\n accountId:" + AppState.l().c() });
    paramArrayOfByte = this.a.a(paramString1).b(paramString2).a(localHashMap).a(paramArrayOfByte).a().b();
    if ((((Integer)paramArrayOfByte.first).intValue() == 403) || (((Integer)paramArrayOfByte.first).intValue() == 404)) {
      ThreadUtils.b(new Runnable()
      {
        public void run()
        {
          Toast.makeText(d.b().k(), "登录信息已失效，请重新从GrowingIO App唤醒定义", 0).show();
        }
      });
    }
    if (GConfig.DEBUG) {
      Log.w("HttpUtil", paramString2 + " " + paramString1 + " response " + paramArrayOfByte.first + " content:" + new String((byte[])paramArrayOfByte.second));
    }
    return paramArrayOfByte;
  }
  
  Pair<Integer, byte[]> a(String paramString, JSONObject paramJSONObject)
  {
    return a(paramString, "POST", paramJSONObject.toString().getBytes());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */