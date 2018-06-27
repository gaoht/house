package com.growingio.android.sdk.circle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Base64;
import android.view.View;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.models.i.a;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  private final String a = "GIO.ScreenshotInfo";
  private WeakReference<Activity> b = null;
  private JSONArray c = new JSONArray();
  private List<com.growingio.android.sdk.models.i> d;
  private com.growingio.android.sdk.models.i e;
  private JSONArray f;
  private String g;
  private String h;
  private String i;
  private com.growingio.android.sdk.models.j j = new com.growingio.android.sdk.models.j()
  {
    public boolean a(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      return (super.a(paramAnonymousi)) || (Util.b(paramAnonymousi.c));
    }
    
    public void b(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      JSONObject localJSONObject = paramAnonymousi.e();
      j.a(j.this, localJSONObject, paramAnonymousi);
      if (localJSONObject != null) {
        j.b(j.this).put(localJSONObject);
      }
    }
  };
  
  public j(Activity paramActivity, List<com.growingio.android.sdk.models.i> paramList, com.growingio.android.sdk.models.i parami)
  {
    this.b = new WeakReference(paramActivity);
    this.d = paramList;
    this.e = parami;
  }
  
  private JSONArray a(View[] paramArrayOfView)
  {
    this.c = new JSONArray();
    ViewHelper.a(paramArrayOfView, this.j);
    if (this.d != null)
    {
      paramArrayOfView = this.d.iterator();
      while (paramArrayOfView.hasNext())
      {
        JSONObject localJSONObject = a((com.growingio.android.sdk.models.i)paramArrayOfView.next());
        if (localJSONObject != null) {
          this.c.put(localJSONObject);
        }
      }
    }
    return this.c;
  }
  
  private JSONObject a(com.growingio.android.sdk.models.i parami)
  {
    JSONObject localJSONObject = parami.e();
    a(localJSONObject, parami);
    return localJSONObject;
  }
  
  private void a(JSONObject paramJSONObject, com.growingio.android.sdk.models.i parami)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str2 = this.g;
    String str1 = this.h;
    if (parami.q != null)
    {
      str2 = this.g + "::" + parami.q.b;
      str1 = this.h + "::" + parami.q.a;
    }
    try
    {
      paramJSONObject.put("domain", str1);
      paramJSONObject.put("page", str2);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  @TargetApi(8)
  public JSONObject a()
  {
    Object localObject = (Activity)this.b.get();
    JSONObject localJSONObject = new JSONObject();
    View[] arrayOfView;
    byte[] arrayOfByte;
    if (localObject != null)
    {
      arrayOfView = WindowHelper.c();
      arrayOfByte = i.a(arrayOfView, null);
    }
    try
    {
      this.g = AppState.l().b((Activity)localObject);
      this.h = AppState.l().b();
      localJSONObject.put("page", this.g);
      localJSONObject.put("screenshotWidth", i.c());
      localJSONObject.put("screenshotHeight", i.e());
      localJSONObject.put("title", ((Activity)localObject).getTitle());
      this.i = ("data:image/jpeg;base64," + Base64.encodeToString(arrayOfByte, 2));
      localJSONObject.put("impress", a(arrayOfView));
      if (this.e != null)
      {
        this.f = new JSONArray();
        localObject = new com.growingio.android.sdk.models.j()
        {
          public void b(com.growingio.android.sdk.models.i paramAnonymousi)
          {
            paramAnonymousi = paramAnonymousi.e();
            if (paramAnonymousi != null) {
              j.a(j.this).put(paramAnonymousi);
            }
          }
        };
        ((com.growingio.android.sdk.models.j)localObject).b(this.e);
        this.e.a((com.growingio.android.sdk.models.j)localObject);
        this.e.b();
        localJSONObject.put("targets", this.f);
      }
      localJSONObject.put("screenshot", this.i);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      LogUtil.d("GIO.ScreenshotInfo", "generate screenshot data error", localJSONException);
    }
    return localJSONObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */