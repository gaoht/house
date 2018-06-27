package com.growingio.android.sdk.a;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.util.Pair;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final Object a = new Object();
  
  public static com.growingio.android.sdk.circle.a.d a(String paramString)
  {
    long l = System.currentTimeMillis();
    ??? = new JSONObject();
    try
    {
      ((JSONObject)???).put("domain", AppState.l().b());
      ((JSONObject)???).put("path", paramString);
      ((JSONObject)???).put("beginTime", l - 259200000L);
      ((JSONObject)???).put("endTime", l);
      ((JSONObject)???).put("metric", "clck");
      ((JSONObject)???).put("withIndex", true);
      LogUtil.e("GIO.HeatMapApi", "jsonRequest" + ((JSONObject)???).toString());
      LogUtil.e("GIO.HeatMapApi", "jsonRequest Uri:" + NetworkConfig.i() + "/mobile/heatmap/data");
      paramString = d.a().a(NetworkConfig.i() + "/mobile/heatmap/data", (JSONObject)???);
    }
    catch (JSONException paramString)
    {
      synchronized (a)
      {
        try
        {
          paramString = new com.growingio.android.sdk.circle.a.d(new JSONObject(new String((byte[])paramString.second)));
          return paramString;
          paramString = paramString;
          LogUtil.d("GIO.HeatMapApi", new Object[] { "gen postHeatMapData json error" });
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            LogUtil.d("GIO.HeatMapApi", new Object[] { "parse the HeatMap error" });
            paramString = null;
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  public static void a(String paramString, b paramb)
  {
    new a(paramString, paramb).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  static class a
    extends AsyncTask<Void, Void, com.growingio.android.sdk.circle.a.d>
  {
    String a;
    c.b b;
    
    public a(String paramString, c.b paramb)
    {
      this.a = paramString;
      this.b = paramb;
    }
    
    protected com.growingio.android.sdk.circle.a.d a(Void... paramVarArgs)
    {
      return c.a(this.a);
    }
    
    protected void a(com.growingio.android.sdk.circle.a.d paramd)
    {
      super.onPostExecute(paramd);
      this.b.a(paramd);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(com.growingio.android.sdk.circle.a.d paramd);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */