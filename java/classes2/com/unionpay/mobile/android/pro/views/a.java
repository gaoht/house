package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.z;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.unionpay.mobile.android.nocard.views.b
  implements Handler.Callback, a.b
{
  private static Date M = new Date(System.currentTimeMillis());
  private static String N = new SimpleDateFormat("yyyyMMddhhmmss").format(M);
  private static HashMap<String, String> P = new HashMap();
  private static HashMap<String, String> Q = new HashMap();
  private ay A;
  private String B;
  private com.unionpay.mobile.android.hce.c C;
  private int D = 5;
  private String E;
  private boolean F = false;
  private Handler.Callback G = new b(this);
  private Handler H = new Handler(this.G);
  private View.OnClickListener I = new c(this);
  private View.OnClickListener J = new d(this);
  private View.OnClickListener K = new e(this);
  private View.OnClickListener L = new f(this);
  private String O = null;
  public String r = "1.9";
  UPPayEngine s;
  private int t = 20;
  private int u = 100;
  private TextView v = null;
  private boolean w = false;
  private com.unionpay.mobile.android.upviews.a x = null;
  private com.unionpay.mobile.android.upviews.a y = null;
  private Handler z = null;
  
  public a(Context paramContext, com.unionpay.mobile.android.model.e parame, UPPayEngine paramUPPayEngine)
  {
    super(paramContext, parame);
    this.f = 6;
    this.q = "hcepay";
    this.s = paramUPPayEngine;
    this.z = new Handler(this);
    this.C = ((com.unionpay.mobile.android.hce.c)com.unionpay.mobile.android.model.b.bb.get(this.a.bc));
    this.w = this.a.K;
    setBackgroundColor(-1052684);
    e();
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    Object localObject1 = null;
    if (this.y != null) {
      localObject1 = this.y.c("instalment");
    }
    int j = this.a.z.length();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label151;
      }
      Object localObject2 = i.b(this.a.z, i);
      if (localObject2 != null) {}
      try
      {
        localObject2 = (JSONObject)localObject2;
        if ("pan".equals(i.a((JSONObject)localObject2, "type"))) {
          ((JSONObject)localObject2).put("label", this.C.b() + this.C.c());
        }
        localJSONArray.put(localObject2);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      i += 1;
    }
    label151:
    this.x = new com.unionpay.mobile.android.upviews.a(this.d, localJSONArray, this.e.c(), this, this.C.a(), true, false, (z)localObject1, this.a.ad, this.q);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    paramLinearLayout.addView(this.x, (ViewGroup.LayoutParams)localObject1);
  }
  
  private static void a(StringBuffer paramStringBuffer)
  {
    Iterator localIterator = P.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)P.get(str1);
      if (!TextUtils.isEmpty(str2))
      {
        Object localObject = new byte[1];
        localObject[0] = ((byte)(str2.length() / 2));
        localObject = com.unionpay.mobile.android.pboctransaction.e.a((byte[])localObject, localObject.length);
        paramStringBuffer.append(str1);
        paramStringBuffer.append((String)localObject);
        paramStringBuffer.append(str2);
      }
    }
  }
  
  private Bundle b(String paramString, HashMap<String, String> paramHashMap)
  {
    Bundle localBundle;
    try
    {
      localBundle = v();
      Q.put("PIN", paramString);
      Q.put("AN1", this.C.a());
      paramString = new StringBuffer();
      a(paramString);
      paramString = paramString.toString();
      Q.put("DCD", paramString);
      this.B = d(this.a.be, this.s.b());
      if (Q.get("5F34") != null)
      {
        paramString = new StringBuffer((String)Q.get("5F34"));
        paramString.insert(0, "0");
        Q.put("5F34", paramString.toString());
      }
      for (;;)
      {
        if (Q.get("57") == null) {
          break label354;
        }
        for (paramString = ((String)Q.get("57")).toUpperCase(); (paramString.substring(paramString.length() - 1, paramString.length()).equalsIgnoreCase("f")) || (paramString.substring(paramString.length() - 1, paramString.length()).equalsIgnoreCase("F")); paramString = paramString.substring(0, paramString.length() - 1)) {}
        Q.put("5F34", "");
      }
      Q.put("TD2", paramString.toString());
    }
    finally {}
    int i = paramString.indexOf("D");
    Object localObject2 = paramString.substring(0, i);
    if (!((String)localObject2).endsWith("F"))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).endsWith("f")) {}
    }
    else
    {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    Q.put("AN1", localObject1);
    paramString = paramString.substring(i + 1, i + 5);
    Q.put("ED", paramString);
    label354:
    Q.put("AMT", P.get("9F02"));
    paramString = "" + "pan=" + (String)Q.get("AN1");
    paramString = paramString + "&pin=" + (String)Q.get("PIN");
    paramString = paramString + "&icc_data=" + (String)Q.get("DCD");
    paramString = paramString + "&card_seq_id=" + (String)Q.get("5F34");
    Object localObject1 = paramString + "&auth_id=" + this.a.bf;
    j.c("mac", (String)localObject1);
    paramString = d((String)localObject1);
    j.c("md5", paramString);
    paramString = this.e.h(paramString);
    j.c("sig", paramString);
    localObject1 = (String)localObject1 + "&" + paramString;
    String str = this.e.a((String)localObject1, this.B);
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("v", this.r);
      ((JSONObject)localObject1).put("cmd", "pay");
      localObject2 = new JSONObject();
      ((JSONObject)localObject1).put("params", localObject2);
      ((JSONObject)localObject2).put("encrypt_key_field", str);
      ((JSONObject)localObject2).put("pay_type", "2");
      ((JSONObject)localObject2).put("pay_mode", "1");
      ((JSONObject)localObject2).put("bind", "no");
      ((JSONObject)localObject2).put("carrier_tp", "9");
      ((JSONObject)localObject2).put("carrier_app_tp", "0");
      ((JSONObject)localObject2).put("sign", paramString);
      ((JSONObject)localObject2).put("pan", Q.get("AN1"));
      if (Q.get("ED") != null) {
        ((JSONObject)localObject2).put("expire", Q.get("ED"));
      }
      if (Q.get("TD2") != null) {
        ((JSONObject)localObject2).put("track2_data", Q.get("TD2"));
      }
      if ((paramHashMap != null) && (paramHashMap.keySet() != null) && (paramHashMap.keySet().size() > 0))
      {
        paramHashMap.remove("pan");
        paramHashMap.remove("pin");
        paramString = paramHashMap.keySet().iterator();
        while (paramString.hasNext())
        {
          str = (String)paramString.next();
          ((JSONObject)localObject2).put(str, paramHashMap.get(str));
        }
      }
    }
    catch (JSONException paramString)
    {
      localBundle.putString("action_resp_code", "10019");
    }
    for (;;)
    {
      return localBundle;
      paramString = ((JSONObject)localObject1).toString();
      localBundle.putString("action_resp_message", this.s.a(paramString));
    }
  }
  
  private boolean b(HashMap<String, String> paramHashMap)
  {
    String str1 = N.substring(2, 8);
    long l = new Date(System.currentTimeMillis()).getTime();
    Object localObject = String.valueOf(l);
    if (((String)localObject).length() < 8) {
      localObject = String.format("%08d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      P.put("9F26", "");
      P.put("9F27", "80");
      P.put("9F10", "");
      P.put("9F37", localObject);
      P.put("9F36", "");
      P.put("95", "0000000800");
      P.put("9A", str1);
      P.put("9C", "45");
      P.put("9F02", "000000000000");
      P.put("5F2A", "0156");
      P.put("82", "");
      P.put("9F1A", "0156");
      P.put("9F03", "000000000000");
      P.put("9F33", "A04000");
      P.put("9F34", "420300");
      P.put("9F35", "34");
      P.put("9F1E", "3030303030303030");
      P.put("84", "");
      P.put("9F09", "0001");
      P.put("9F41", "");
      P.put("91", "");
      P.put("71", "");
      P.put("72", "");
      P.put("DF31", "");
      P.put("9F74", "");
      P.put("9F63", "");
      P.put("8A", "");
      Q.put("9F66", "26C00000");
      v();
      P.put("9F02", paramHashMap.get("trans_amt"));
      P.put("9F1A", "0156");
      P.put("5F2A", paramHashMap.get("trans currcy code"));
      P.put("9C", paramHashMap.get("trans_type"));
      Q.put("CUR", P.get("5F2A"));
      paramHashMap = new JSONObject();
      try
      {
        paramHashMap.put("9F66", Q.get("9F66"));
        paramHashMap.put("9F02", P.get("9F02"));
        paramHashMap.put("9F03", P.get("9F03"));
        paramHashMap.put("9F1A", P.get("9F1A"));
        paramHashMap.put("95", P.get("95"));
        paramHashMap.put("5F2A", P.get("5F2A"));
        paramHashMap.put("9A", P.get("9A"));
        paramHashMap.put("9C", P.get("9C"));
        paramHashMap.put("9F37", P.get("9F37"));
        String str2 = this.C.f();
        localObject = this.C.g();
        str1 = com.unionpay.mobile.android.hce.a.b(this.C.a(), str2);
        paramHashMap = com.unionpay.mobile.android.hce.a.b(paramHashMap.toString(), str2);
        try
        {
          ((com.unionpay.mobile.android.hce.service.a)localObject).a(str1, paramHashMap, "", new com.unionpay.mobile.android.hce.b(2004, "", this.H));
          paramHashMap = this.H.obtainMessage(2006);
          this.H.sendMessageDelayed(paramHashMap, this.a.bd);
          return true;
        }
        catch (RemoteException paramHashMap)
        {
          paramHashMap.printStackTrace();
          a(this.a.ap, false);
        }
        localObject = ((String)localObject).substring(((String)localObject).length() - 8, ((String)localObject).length());
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private static final String d(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString);
      paramString = com.unionpay.mobile.android.pboctransaction.e.a(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String d(String paramString1, String paramString2)
  {
    paramString1 = com.unionpay.mobile.android.pboctransaction.e.a(paramString1);
    paramString2 = com.unionpay.mobile.android.pboctransaction.e.a(paramString2);
    int i = 0;
    while (i < paramString1.length)
    {
      paramString1[i] = ((byte)(paramString1[i] ^ paramString2[i]));
      i += 1;
    }
    return com.unionpay.mobile.android.pboctransaction.e.a(paramString1);
  }
  
  private void e(String paramString1, String paramString2)
  {
    this.u = 9;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    }
    for (;;)
    {
      this.D -= 1;
      return;
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    }
  }
  
  private void u()
  {
    this.u = 103;
    int i = this.t;
    this.e.a("query", this.a.aj, 3);
    this.t -= 1;
  }
  
  private static Bundle v()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action_resp_code", "0000");
    return localBundle;
  }
  
  public final Bundle a(String paramString, HashMap<String, String> paramHashMap)
  {
    return b(paramString, paramHashMap);
  }
  
  public final void a(a.a parama) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    switch (this.u)
    {
    }
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              try
              {
                this.a.be = ((String)paramJSONObject.get("encrypt_key"));
                this.a.bf = ((String)paramJSONObject.get("auth_id"));
                if (this.a.p != null)
                {
                  paramJSONObject = this.x.a();
                  if (!paramJSONObject.a())
                  {
                    this.F = true;
                    a(paramJSONObject.b);
                    return;
                  }
                }
              }
              catch (JSONException paramJSONObject)
              {
                for (;;)
                {
                  paramJSONObject.printStackTrace();
                }
                this.u = 101;
                a(this.a.p);
                return;
              }
            }
            this.a.aj = h.a(paramJSONObject.toString());
            paramJSONObject = i.a(paramJSONObject, "qn");
            if (!TextUtils.isEmpty(paramJSONObject)) {
              this.a.n = this.e.i(com.unionpay.mobile.android.utils.c.b(paramJSONObject));
            }
            if ((this.a.aj == null) || (this.a.aj.length() <= 0))
            {
              b(2);
              return;
            }
            this.t = 20;
            u();
            return;
            Object localObject1 = i.a(paramJSONObject, "status");
            String str = i.a(paramJSONObject, "fail_msg");
            if ((this.t > 0) && (((String)localObject1).equalsIgnoreCase("01")))
            {
              u();
              return;
            }
            this.u = 100;
            if (((String)localObject1).equalsIgnoreCase("00"))
            {
              j();
              this.u = 100;
              this.a.H = i.d(paramJSONObject, "result");
              this.a.P = i.a(paramJSONObject, "openupgrade_flag");
              this.a.Q = i.a(paramJSONObject, "temporary_pay_flag");
              this.a.R = i.a(paramJSONObject, "temporary_pay_info");
              this.a.V = i.a(paramJSONObject, "front_url");
              this.a.W = i.a(paramJSONObject, "front_request");
              this.a.A = i.a(paramJSONObject, "title");
              this.a.B = i.a(paramJSONObject, "succ_info");
              com.unionpay.mobile.android.nocard.utils.b.b(paramJSONObject, this.a);
              com.unionpay.mobile.android.nocard.utils.b.a(paramJSONObject, this.a);
              if (this.x != null) {
                this.x.f();
              }
              a(this.d, this.q + "_succeed");
              paramJSONObject = com.unionpay.mobile.android.model.b.bb.iterator();
              while (paramJSONObject.hasNext())
              {
                localObject1 = ((com.unionpay.mobile.android.hce.c)paramJSONObject.next()).h();
                try
                {
                  this.d.unbindService((ServiceConnection)localObject1);
                }
                catch (IllegalArgumentException localIllegalArgumentException) {}
              }
              if (this.a.f)
              {
                this.a.I.f = "success";
                k();
                return;
              }
              d(8);
              return;
            }
            j();
            this.F = true;
            if (localIllegalArgumentException.equalsIgnoreCase("03"))
            {
              a(this.d, this.q + "_fail", o.j, new String[] { localIllegalArgumentException, str });
              a(str);
              return;
            }
          } while (this.t > 0);
          b(19);
          return;
          j();
          paramJSONObject = i.d(paramJSONObject, "options");
        } while (this.y == null);
        this.y.a(paramJSONObject);
        return;
        localObject2 = i.a(paramJSONObject, "status");
        if ((localObject2 == null) || (!"01".equals(localObject2))) {
          break;
        }
        paramJSONObject = i.a(paramJSONObject, "uuid");
        if (this.D >= 0)
        {
          e(this.E, paramJSONObject);
          return;
        }
        paramJSONObject = com.unionpay.mobile.android.languages.c.bD.D;
      } while (this.y == null);
      this.y.a(null, paramJSONObject);
      return;
      localObject2 = i.d(paramJSONObject, "options");
      paramJSONObject = i.a(paramJSONObject, "empty_info");
    } while (this.y == null);
    this.y.a((JSONArray)localObject2, paramJSONObject);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.v != null)
    {
      localTextView = this.v;
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
    }
  }
  
  public final boolean a(HashMap<String, String> paramHashMap)
  {
    M = new Date(System.currentTimeMillis());
    N = new SimpleDateFormat("yyyyMMddHHmmss").format(M);
    this.O = new String(N);
    return b(paramHashMap);
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.A = new ay(getContext(), com.unionpay.mobile.android.languages.c.bD.bq, this);
    localLayoutParams.addRule(13, -1);
    this.k.addView(this.A, localLayoutParams);
  }
  
  public final void b(int paramInt)
  {
    switch (this.u)
    {
    }
    for (;;)
    {
      super.b(paramInt);
      return;
      this.F = true;
    }
  }
  
  protected final void c()
  {
    this.m.removeAllViews();
    this.o.a(this);
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setOrientation(1);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    this.m.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    localObject = new JSONArray();
    if (this.p != null)
    {
      com.unionpay.mobile.android.model.f localf = (com.unionpay.mobile.android.model.f)this.p;
      ((JSONArray)localObject).put(localf.a("promotion"));
      ((JSONArray)localObject).put(localf.a("instalment"));
      this.a.aU = localf.a("promotion_instalment_msgbox");
    }
    if (((JSONArray)localObject).length() > 0)
    {
      this.y = new com.unionpay.mobile.android.upviews.a(this.d, (JSONArray)localObject, this, this.q);
      this.y.a(this.I);
      this.y.b(this.J);
      this.y.c(this.K);
      this.y.a(this.b, this.a.aU);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = com.unionpay.mobile.android.global.a.f;
      localLinearLayout.addView(this.y, (ViewGroup.LayoutParams)localObject);
    }
    a(localLinearLayout);
    new LinearLayout.LayoutParams(-1, -2);
    this.v = new TextView(this.d);
    this.v.setText(i.a(this.a.C, "label"));
    this.v.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.v.setTextColor(p());
    this.v.setGravity(17);
    localObject = this.v;
    if ((this.x == null) || (this.x.e())) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject).setEnabled(bool);
      int i = com.unionpay.mobile.android.global.a.n;
      localObject = this.c.a(2008);
      this.v.setBackgroundDrawable((Drawable)localObject);
      this.v.setOnClickListener(this.L);
      localObject = new LinearLayout.LayoutParams(-1, i);
      ((LinearLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
      i = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject).leftMargin = i;
      localLinearLayout.addView(this.v, (ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.obj != null)
    {
      Object localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("action_resp_code");
      localObject = ((Bundle)localObject).getString("action_resp_message");
      if (!"0000".equalsIgnoreCase(paramMessage)) {
        break label53;
      }
      if (localObject != null) {
        a(0, (String)localObject);
      }
    }
    for (;;)
    {
      return true;
      label53:
      a(this.a.ap, false);
    }
  }
  
  public final void l()
  {
    if ((this.x != null) && (this.x.d())) {
      return;
    }
    if ((this.a.K) && (this.w))
    {
      this.a.K = false;
      n();
      return;
    }
    this.a.K = false;
    a(2);
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.x != null) {
      this.x.d();
    }
    this.b = null;
  }
  
  public final void t() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */