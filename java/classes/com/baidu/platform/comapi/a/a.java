package com.baidu.platform.comapi.a;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.platform.comjni.util.AppMD5;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  Context a;
  AsyncHttpClient b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new AsyncHttpClient(paramContext);
  }
  
  private c a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      localObject = new c(d.c);
    }
    JSONArray localJSONArray;
    int i;
    do
    {
      return (c)localObject;
      try
      {
        paramString = new JSONObject(paramString);
        localObject = paramString.optJSONObject("result");
        if (localObject == null) {
          return new c(d.c);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return new c(d.c);
      }
      if (((JSONObject)localObject).optInt("error") != 0) {
        break;
      }
      localJSONArray = paramString.optJSONArray("content");
      if (localJSONArray == null) {
        return new c(d.c);
      }
      paramString = null;
      i = 0;
      localObject = paramString;
    } while (i >= localJSONArray.length());
    Object localObject = localJSONArray.optJSONObject(i).optJSONObject("poiinfo");
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      paramString = new c(d.a);
      paramString.a(((JSONObject)localObject).optString("PID"));
      paramString.a(((JSONObject)localObject).optInt("hasstreet"));
    }
    return new c(d.b);
  }
  
  private String a(Uri.Builder paramBuilder)
  {
    paramBuilder = paramBuilder.build().toString();
    paramBuilder = Uri.parse(paramBuilder + HttpClient.getPhoneInfo()).buildUpon();
    paramBuilder.appendQueryParameter("sign", AppMD5.getSignMD5String(paramBuilder.build().getEncodedQuery()));
    return paramBuilder.build().toString();
  }
  
  private void a(Uri.Builder paramBuilder, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramBuilder.appendQueryParameter(paramString1, paramString2);
    }
  }
  
  public void a(String paramString, a<c> parama)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("http");
    localBuilder.encodedAuthority("api.map.baidu.com");
    localBuilder.path("/sdkproxy/lbs_androidsdk/pano/v1/");
    a(localBuilder, "qt", "poi");
    a(localBuilder, "uid", paramString);
    a(localBuilder, "action", "0");
    paramString = HttpClient.getAuthToken();
    if (paramString == null)
    {
      parama.a(new c(d.d));
      return;
    }
    a(localBuilder, "token", paramString);
    paramString = a(localBuilder);
    this.b.get(paramString, new b(this, parama));
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(HttpClient.HttpStateError paramHttpStateError);
    
    public abstract void a(T paramT);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */