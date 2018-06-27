package com.growingio.android.sdk.models;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends g
{
  private String a;
  private String b;
  private String c = "PORTRAIT";
  private WeakReference<Object> d;
  private long g;
  
  public d(Activity paramActivity, String paramString, long paramLong)
  {
    this.f = j().b(paramActivity);
    if (paramActivity.getResources().getConfiguration().orientation == 1) {}
    for (String str = "PORTRAIT";; str = "LANDSCAPE")
    {
      this.c = str;
      if (!TextUtils.isEmpty(paramActivity.getTitle())) {
        this.b = paramActivity.getTitle().toString();
      }
      this.g = paramLong;
      this.a = paramString;
      this.d = new WeakReference(paramActivity);
      return;
    }
  }
  
  @TargetApi(11)
  public d(android.app.Fragment paramFragment, String paramString, long paramLong)
  {
    this(paramFragment.getActivity(), paramString, paramLong);
    this.d = new WeakReference(paramFragment);
  }
  
  public d(android.support.v4.app.Fragment paramFragment, String paramString, long paramLong)
  {
    this(paramFragment.getActivity(), paramString, paramLong);
    this.d = new WeakReference(paramFragment);
  }
  
  public d(String paramString1, String paramString2, long paramLong)
  {
    this.f = paramString1;
    this.g = paramLong;
    this.a = paramString2;
    paramString2 = j().h();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = j().i();
    }
    if (paramString1 != null) {
      this.d = new WeakReference(paramString1);
    }
    paramString2 = j().i();
    if (paramString2 != null) {
      if (paramString2.getResources().getConfiguration().orientation != 1) {
        break label121;
      }
    }
    label121:
    for (paramString1 = "PORTRAIT";; paramString1 = "LANDSCAPE")
    {
      this.c = paramString1;
      if (!TextUtils.isEmpty(paramString2.getTitle())) {
        this.b = paramString2.getTitle().toString();
      }
      return;
    }
  }
  
  private void h(JSONObject paramJSONObject)
  {
    Object localObject = this.d.get();
    if (localObject == null) {}
    SparseArray localSparseArray;
    do
    {
      return;
      localSparseArray = (SparseArray)j().a().get(localObject);
    } while (localSparseArray == null);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= localSparseArray.size()) {
          break;
        }
        int j = localSparseArray.keyAt(i);
        if (j == 0)
        {
          localObject = "pg";
          String str = (String)localSparseArray.valueAt(i);
          if (!TextUtils.isEmpty(str)) {
            paramJSONObject.put((String)localObject, str);
          }
        }
        else
        {
          localObject = "ps" + j;
          continue;
        }
        i += 1;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
  }
  
  public String a()
  {
    return "page";
  }
  
  public JSONObject c()
  {
    JSONObject localJSONObject = l();
    try
    {
      localJSONObject.put("t", "page");
      g(localJSONObject);
      h(localJSONObject);
      a(localJSONObject);
      b(localJSONObject);
      localJSONObject.put("tm", this.g);
      if (!TextUtils.isEmpty(this.a)) {
        localJSONObject.put("rp", this.a);
      }
      localJSONObject.put("o", this.c);
      localJSONObject.put("tl", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      LogUtil.d("GIO.VPAEvent", "generate page event error", localJSONException);
    }
    return localJSONObject;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */