package com.unionpay.mobile.android.nocard.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.net.d;
import com.unionpay.mobile.android.nocard.views.bh;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import java.lang.ref.WeakReference;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class UPPayEngine
  implements Handler.Callback, a, Runnable
{
  private d a = null;
  private String b = null;
  private String c = null;
  private Context d = null;
  private Handler e = null;
  private WeakReference<a> f = null;
  private b g = null;
  private long h = 0L;
  
  public UPPayEngine(Context paramContext)
  {
    this.d = paramContext;
    this.e = new Handler(this);
  }
  
  private native String commonMessage(long paramLong, String paramString1, String paramString2, String paramString3);
  
  private native String decryptResponse(long paramLong, String paramString);
  
  private native String desEncryptMessage(long paramLong, String paramString1, String paramString2);
  
  private native String encryptMessage(long paramLong, String paramString);
  
  private native String followRulesMessage(long paramLong, String paramString1, String paramString2);
  
  private native String getServerUrl(int paramInt1, int paramInt2, int paramInt3);
  
  private native String getTalkingDataId(int paramInt);
  
  private native String getUserInfo(long paramLong, String paramString1, String paramString2);
  
  protected static String h()
  {
    Date localDate = new Date(System.currentTimeMillis());
    return new SimpleDateFormat("yyyyMMddhhmmss").format(localDate);
  }
  
  private native String initMessage(long paramLong, String paramString1, String paramString2);
  
  private void o(String paramString)
  {
    new Thread(this, paramString).start();
  }
  
  private native String openupgradeMessage(long paramLong, String paramString1, String paramString2);
  
  private native String payingMessage(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  private native String retrieveInitializeKey(long paramLong);
  
  private native String rsaEncryptMessageForHFT(long paramLong, String paramString);
  
  private native String rsaPrivateEncryptMessage(long paramLong, String paramString);
  
  private native String ruleMessage(long paramLong, String paramString1, String paramString2);
  
  private native void setSessionKey(long paramLong, String paramString);
  
  private native String unBoundMessage(long paramLong, String paramString1, String paramString2);
  
  public String a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("reqtm", h());
      localObject = ((JSONObject)localObject).toString();
      j.c("uppay", "post message = " + paramString);
      paramString = encryptMessage(this.h, (String)localObject);
      this.a.a(paramString);
      paramString = new HashMap(1);
      paramString.put("sid", this.b);
      this.a.a(paramString);
      paramString = new com.unionpay.mobile.android.net.c(this.a, this.d);
      i = paramString.a();
      paramString = paramString.c();
      if (i == 0)
      {
        paramString = decryptResponse(this.h, paramString);
        j.a("uppay", "[ response msg ] " + paramString);
        return paramString;
      }
    }
    catch (JSONException localJSONException)
    {
      int i;
      for (;;)
      {
        String str = paramString;
      }
      paramString = this.e.obtainMessage(2);
      paramString.arg1 = i;
      this.e.sendMessage(paramString);
    }
    return null;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    return desEncryptMessage(this.h, paramString1, paramString2);
  }
  
  public final void a()
  {
    int j = 2;
    String str;
    if (!TextUtils.isEmpty(this.g.bj))
    {
      if (this.g.f) {
        str = this.g.bj + "/app/mobile/hft";
      }
      for (;;)
      {
        j.a("uppay", "url  is : " + str);
        this.a = new d(str);
        return;
        if (this.g.c) {
          str = this.g.bj + "/app/mobile/json";
        } else {
          str = this.g.bj + "/gateway/mobile/json";
        }
      }
    }
    int i;
    if (this.g.I.c.equalsIgnoreCase("01")) {
      i = 1;
    }
    for (;;)
    {
      label174:
      j.a("uppay", "idx  is : " + i + ", isNewTypeTn :" + this.g.c);
      if (this.g.f) {}
      for (;;)
      {
        str = getServerUrl(j, i, this.g.aO);
        break;
        if (this.g.I.c.equalsIgnoreCase("02"))
        {
          i = 2;
          break label174;
        }
        if (this.g.I.c.equalsIgnoreCase("98"))
        {
          i = 98;
          break label174;
        }
        if (this.g.I.c.equalsIgnoreCase("99"))
        {
          i = 99;
          break label174;
        }
        if (!"95".equalsIgnoreCase(this.g.I.c)) {
          break label357;
        }
        i = 95;
        break label174;
        if (this.g.c) {
          j = 1;
        } else {
          j = 0;
        }
      }
      label357:
      i = 0;
    }
  }
  
  public final void a(long paramLong)
  {
    this.h = paramLong;
  }
  
  public final void a(b paramb)
  {
    if ((this.g == null) || (this.g != paramb)) {
      this.g = paramb;
    }
  }
  
  public final void a(a parama)
  {
    this.f = new WeakReference(parama);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = commonMessage(this.h, paramString1, paramString2, h());
    this.a.a(paramString2);
    paramString2 = new HashMap(1);
    paramString2.put("sid", this.b);
    this.a.a(paramString2);
    if (paramInt <= 0)
    {
      o(paramString1);
      return;
    }
    paramString1 = this.e.obtainMessage(1, paramString1);
    this.e.sendMessageDelayed(paramString1, paramInt * 1000);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = payingMessage(this.h, paramString1, paramString2, paramString3, paramString4, h());
    this.a.a(paramString1);
    paramString1 = new HashMap(1);
    paramString1.put("sid", this.b);
    this.a.a(paramString1);
    o("pay");
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final String b(String paramString)
  {
    if (h.c(paramString)) {}
    for (;;)
    {
      return getTalkingDataId(Integer.decode(paramString).intValue());
      paramString = "00";
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if (this.g.f) {}
    for (paramString1 = bh.b(this.d, paramString1, "android", this.g.a(), this.g.g, this.g.d);; paramString1 = bh.a(this.d, paramString1, "android", this.g.a(), this.g.g, paramString2))
    {
      paramString1 = initMessage(this.h, paramString1, h());
      this.a.a(paramString1);
      paramString1 = new HashMap(1);
      paramString1.put("secret", retrieveInitializeKey(this.h));
      this.a.a(paramString1);
      o("init");
      return;
    }
  }
  
  public final long c()
  {
    return this.h;
  }
  
  public final void c(String paramString)
  {
    this.b = paramString;
  }
  
  public final void c(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0);
  }
  
  public final d d()
  {
    return this.a;
  }
  
  public final void d(String paramString)
  {
    this.c = paramString;
  }
  
  public final Handler e()
  {
    return this.e;
  }
  
  public final boolean e(String paramString)
  {
    setSessionKey(this.h, paramString);
    return true;
  }
  
  public final String f()
  {
    return this.b;
  }
  
  public final String f(String paramString)
  {
    return encryptMessage(this.h, paramString);
  }
  
  public final String g(String paramString)
  {
    return decryptResponse(this.h, paramString);
  }
  
  public final void g()
  {
    this.d = null;
    this.e.removeCallbacksAndMessages(null);
    this.e = null;
    this.a = null;
    this.g = null;
  }
  
  public final String h(String paramString)
  {
    return rsaPrivateEncryptMessage(this.h, paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    b localb;
    if (paramMessage.what == 0)
    {
      localb = (b)paramMessage.obj;
      if (localb.a != 0) {
        break label195;
      }
      paramMessage = decryptResponse(this.h, localb.b);
      j.a("uppay", "resp is:" + paramMessage);
    }
    for (;;)
    {
      if ((this.f != null) && (this.f.get() != null))
      {
        ((a)this.f.get()).a(localb.a, paramMessage);
        j.b("uppayEx", "UPPayEngine:" + this.f.toString());
      }
      do
      {
        return true;
        if (paramMessage.what == 1)
        {
          o((String)paramMessage.obj);
          return true;
        }
      } while ((paramMessage.what != 2) || (this.f == null) || (this.f.get() == null));
      ((a)this.f.get()).a(paramMessage.arg1, null);
      return true;
      label195:
      paramMessage = null;
    }
  }
  
  public final String i(String paramString)
  {
    return rsaEncryptMessageForHFT(this.h, paramString);
  }
  
  public native long initJNIEnv(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, int paramInt3, String paramString2);
  
  public final void j(String paramString)
  {
    paramString = ruleMessage(this.h, paramString, h());
    this.a.a(paramString);
    paramString = new HashMap(1);
    paramString.put("sid", this.b);
    this.a.a(paramString);
    o("rule");
  }
  
  public final void k(String paramString)
  {
    paramString = followRulesMessage(this.h, paramString, h());
    this.a.a(paramString);
    paramString = new HashMap(1);
    paramString.put("sid", this.b);
    this.a.a(paramString);
    o("followRule");
  }
  
  public final void l(String paramString)
  {
    paramString = openupgradeMessage(this.h, paramString, h());
    this.a.a(paramString);
    paramString = new HashMap(1);
    paramString.put("sid", this.b);
    this.a.a(paramString);
    o("openupgrade");
  }
  
  public final void m(String paramString)
  {
    paramString = unBoundMessage(this.h, paramString, h());
    this.a.a(paramString);
    paramString = new HashMap(1);
    paramString.put("sid", this.b);
    this.a.a(paramString);
    o("unbindcard");
  }
  
  public final void n(String paramString)
  {
    paramString = getUserInfo(this.h, paramString, h());
    j.a("uppay", "actEntrust msg:" + paramString);
    this.a.a(paramString);
    paramString = new HashMap(1);
    paramString.put("sid", this.b);
    this.a.a(paramString);
    o("getuserinfo");
  }
  
  public void run()
  {
    if ((this.g.aO > 0) && (this.g.aO <= 5)) {
      this.a.c().put("magic_number", "20150423");
    }
    for (;;)
    {
      Object localObject = new com.unionpay.mobile.android.net.c(this.a, this.d);
      localObject = new b(((com.unionpay.mobile.android.net.c)localObject).a(), ((com.unionpay.mobile.android.net.c)localObject).c());
      if (this.e != null)
      {
        Message localMessage = this.e.obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localObject;
        this.e.sendMessage(localMessage);
      }
      return;
      this.a.c().put("magic_number", "20131120");
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString);
  }
  
  final class b
  {
    public int a;
    public String b;
    
    public b(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/utils/UPPayEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */