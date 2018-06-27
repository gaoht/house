package com.unionpay.mobile.android.hce;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static final Object w = new Object();
  private Context a;
  private a b;
  private Handler c;
  private String d;
  private String e;
  private int f = 0;
  private int g = 0;
  private int h = 10;
  private int i = 1000;
  private String j = "hce";
  private String k = "";
  private String l;
  private String m = "";
  private HashMap<String, k> n = new HashMap(0);
  private List<k> o = new ArrayList(0);
  private HashMap<Integer, k> p = new HashMap(0);
  private int q = 0;
  private int r = 1;
  private int s = 0;
  private int t = 5;
  private ConcurrentHashMap<String, d> u = new ConcurrentHashMap(0);
  private ConcurrentHashMap<String, l> v = new ConcurrentHashMap(0);
  private final Handler.Callback x = new g(this);
  private Handler y;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
    this.y = new Handler(this.x);
    this.l = "20150801000000000000";
    this.b = ((a)((BaseActivity)paramContext).a(UPPayEngine.class.toString()));
  }
  
  private Bundle a(String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action_resp_code", "0000");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("v", "1.9");
      localJSONObject1.put("cmd", this.j);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject1.put("params", localJSONObject2);
      localJSONObject2.put("base_version", paramString);
      localJSONObject2.put("page", paramInt1);
      localJSONObject2.put("size", paramInt2);
      paramString = localJSONObject1.toString();
      localBundle.putString("action_resp_message", this.b.a(paramString));
      a(localBundle);
      this.f += 1;
      if (this.f <= this.g) {
        a(this.l, this.f, this.h);
      }
      return localBundle;
    }
    catch (JSONException paramString)
    {
      localBundle.putString("action_resp_code", "10019");
    }
    return localBundle;
  }
  
  private boolean a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("action_resp_code");
    paramBundle = paramBundle.getString("action_resp_message");
    if (("0000".equalsIgnoreCase((String)localObject)) && (paramBundle != null)) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      localObject = i.a(paramBundle, "resp");
      i.a(paramBundle, "msg");
      paramBundle = i.c(paramBundle, "params");
      if (((String)localObject).equalsIgnoreCase("00"))
      {
        this.d = i.c(paramBundle, "signature").toString();
        localObject = i.d(paramBundle, "configs");
        if (localObject != null)
        {
          i1 = 0;
          while (i1 < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
            this.o.add(new k(localJSONObject));
            this.m = i.a(paramBundle, "version");
            i1 += 1;
          }
        }
        int i1 = Integer.decode(i.a(paramBundle, "total_count")).intValue();
        if (i1 > this.h) {
          this.g = (i1 / this.h);
        }
      }
      return false;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return false;
  }
  
  public final void a()
  {
    this.f = 1;
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void a(Handler paramHandler)
  {
    this.c = paramHandler;
  }
  
  public final void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.j = paramString;
    }
  }
  
  public final void b()
  {
    if (this.q == 0)
    {
      b.bk = true;
      if (this.c != null)
      {
        ??? = this.c.obtainMessage(0);
        this.c.sendMessage((Message)???);
      }
      return;
    }
    synchronized (w)
    {
      int i1 = this.r;
      while ((i1 <= this.q) && (this.s < this.t))
      {
        Object localObject3 = (k)this.p.get(Integer.valueOf(i1));
        String str = ((k)localObject3).b();
        localObject3 = ((k)localObject3).d();
        this.s += 1;
        new h(this, str, (String)localObject3).start();
        this.r += 1;
        i1 += 1;
      }
      return;
    }
  }
  
  public final void b(int paramInt)
  {
    if (paramInt > 0) {
      this.i = paramInt;
    }
  }
  
  public final void b(String paramString)
  {
    this.e = paramString;
  }
  
  public final void c()
  {
    if (b.bb != null)
    {
      b.bb.clear();
      b.bb = null;
    }
    Object localObject1 = PreferenceUtils.a(this.a, "hce_version");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.l = ((String)localObject1);
    }
    Object localObject2 = PreferenceUtils.a(this.a, "hce_info");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "[{\"package\":\"com.yitong.mbank0408\",\"issuer\":\"64083300\",\"syn_key\":\"0123456789ABCDEF1010101010101010\",\"pub_key\":\"268576AF6F50DA40196E18D6E059D2A721373638\",\"status\":\"I\",\"priority\":\"1\"}]";
    }
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      int i1 = 0;
      while (i1 < ((JSONArray)localObject1).length())
      {
        localObject2 = new k(((JSONArray)localObject1).getJSONObject(i1));
        this.n.put(((k)localObject2).b(), localObject2);
        i1 += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      new Thread(new j(this)).start();
    }
  }
  
  public final void c(int paramInt)
  {
    if (paramInt > 0) {
      this.t = paramInt;
    }
  }
  
  public final void c(String paramString)
  {
    this.k = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */