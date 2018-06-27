package com.alipay.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  b a;
  Context b;
  
  public c(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.a = paramb;
  }
  
  public final void a(a parama)
    throws JSONException
  {
    if (TextUtils.isEmpty(parama.c))
    {
      a(parama.a, a.a.c);
      return;
    }
    parama = new d(this, parama);
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(parama);
  }
  
  public final void a(String paramString, int paramInt)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("error", paramInt - 1);
    a locala = new a("callback");
    locala.e = localJSONObject;
    locala.a = paramString;
    this.a.a(locala);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */