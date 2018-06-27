package com.growingio.android.sdk.a;

import android.util.Log;
import android.util.Pair;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static final Object a = new Object();
  private static e d;
  private static final Object e = new Object();
  private String b;
  private String c;
  
  public static e a()
  {
    synchronized (e)
    {
      if (d == null)
      {
        locale = new e();
        d = locale;
        return locale;
      }
      e locale = d;
      return locale;
    }
  }
  
  public Pair<Integer, byte[]> a(String arg1)
  {
    LogUtil.d("GIO.LoginAPI", new Object[] { "Begin use LoginToken:" + ??? + "  to login" });
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("grantType", "login_token");
      ((JSONObject)localObject1).put("deviceId", b().m().a());
      ((JSONObject)localObject1).put("loginToken", ???);
      LogUtil.d("GIO.LoginAPI", new Object[] { "jsonObject:\ngrantType:login_token\n deviceId:" + b().m().a() + "\n loginToken:" + ??? });
      localObject1 = c().a(NetworkConfig.i() + "/oauth2/token", (JSONObject)localObject1);
      if ((((Integer)((Pair)localObject1).first).intValue() != 200) || (((byte[])((Pair)localObject1).second).length <= 0)) {}
    }
    catch (JSONException ???)
    {
      synchronized (a)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(new String((byte[])((Pair)localObject1).second));
          this.b = localJSONObject.getString("accessToken");
          this.c = localJSONObject.getString("userId");
          Log.i("GIO.LoginAPI", "get access token by login token success");
          return (Pair<Integer, byte[]>)localObject1;
          ??? = ???;
          Log.d("GIO.LoginAPI", "gen login json error");
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            LogUtil.d("GIO.LoginAPI", new Object[] { "parse the loginToken error" });
          }
        }
      }
    }
  }
  
  AppState b()
  {
    return AppState.l();
  }
  
  d c()
  {
    return d.a();
  }
  
  public String d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.c;
  }
  
  @Deprecated
  public void f()
  {
    this.b = "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/growingio/android/sdk/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */