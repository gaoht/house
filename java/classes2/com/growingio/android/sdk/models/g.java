package com.growingio.android.sdk.models;

import android.text.TextUtils;
import android.util.SparseArray;
import com.growingio.android.sdk.circle.c;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.SessionManager;
import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONObject;

public abstract class g
{
  long e = System.currentTimeMillis();
  public String f;
  
  public abstract String a();
  
  protected void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("lat", j().e());
      paramJSONObject.put("lng", j().f());
      return;
    }
    catch (Exception paramJSONObject)
    {
      LogUtil.d("GIO.VPAEvent", "patch location error ", paramJSONObject);
    }
  }
  
  protected void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    SparseArray localSparseArray = j().j();
    int i;
    if (localSparseArray != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localSparseArray.size())
        {
          int j = localSparseArray.keyAt(i);
          if (j != 0) {
            break label104;
          }
          String str = "pg";
          if (paramBoolean)
          {
            paramJSONObject.put("pg", localSparseArray.valueAt(i));
            return;
            str = "ps" + j;
          }
          paramJSONObject.put(str, localSparseArray.valueAt(i));
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return;
      label104:
      if (paramBoolean) {
        i += 1;
      }
    }
  }
  
  public String a_()
  {
    return a();
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("r", AppState.l().q());
      return;
    }
    catch (Exception paramJSONObject)
    {
      LogUtil.d("GIO.VPAEvent", "patch NetWorkState value error: ", paramJSONObject);
    }
  }
  
  public abstract JSONObject c();
  
  protected void c(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("adrid", AppState.l().r());
      return;
    }
    catch (Exception paramJSONObject)
    {
      LogUtil.d("GIO.VPAEvent", "patch androidId value error: ", paramJSONObject);
    }
  }
  
  protected void d(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("mac", AppState.l().s());
      return;
    }
    catch (Exception paramJSONObject)
    {
      LogUtil.d("GIO.VPAEvent", "patch macAddress value error: ", paramJSONObject);
    }
  }
  
  protected void e(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("imei", AppState.l().t());
      return;
    }
    catch (Exception paramJSONObject)
    {
      LogUtil.d("GIO.VPAEvent", "patch imei value error: ", paramJSONObject);
    }
  }
  
  protected void f(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("uuid", AppState.l().u());
      return;
    }
    catch (Exception paramJSONObject)
    {
      LogUtil.d("GIO.VPAEvent", "patch uuid value error: ", paramJSONObject);
    }
  }
  
  protected void g(JSONObject paramJSONObject)
  {
    try
    {
      SparseArray localSparseArray = j().x();
      int i = 0;
      while (i < localSparseArray.size())
      {
        int j = localSparseArray.keyAt(i);
        String str = String.valueOf(localSparseArray.get(j));
        paramJSONObject.put("cs" + String.valueOf(j + 1), str);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      LogUtil.d("GIO.VPAEvent", "patch cs value error: ", paramJSONObject);
    }
  }
  
  public int i()
  {
    return 1;
  }
  
  protected AppState j()
  {
    return AppState.l();
  }
  
  protected GConfig k()
  {
    return GConfig.s();
  }
  
  protected JSONObject l()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("s", SessionManager.a());
      localJSONObject.put("tm", this.e);
      String str2 = j().b();
      String str1 = str2;
      if (c.e().a()) {
        str1 = "GioCircle." + str2;
      }
      localJSONObject.put("d", str1);
      if (!TextUtils.isEmpty(this.f)) {
        localJSONObject.put("p", this.f);
      }
      return localJSONObject;
    }
    catch (Exception localException)
    {
      LogUtil.d("GIO.VPAEvent", "generate common event property error", localException);
    }
    return localJSONObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */