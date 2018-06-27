package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.mobile.android.utils.q;
import com.unionpay.mobile.android.utils.q.a;
import com.unionpay.sdk.UPAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends b
  implements q.a
{
  private String A = null;
  private int B = 0;
  private volatile int C = 0;
  private boolean D = false;
  private boolean E = false;
  private JSONArray F;
  private com.unionpay.mobile.android.model.e G;
  private long H;
  private Activity I;
  private boolean J;
  private boolean K = false;
  public List<com.unionpay.mobile.android.model.c> r = null;
  public List<com.unionpay.mobile.android.model.c> s = null;
  int t = 0;
  String u = "";
  String v = "";
  String w = "";
  int x = 500;
  int y = 5;
  private ProgressBar z = null;
  
  public l(Context paramContext)
  {
    super(paramContext);
    this.f = 1;
    this.q = "init";
    d();
    this.I = ((Activity)paramContext);
    this.J = com.unionpay.mobile.android.nocard.utils.a.a(this.I.getIntent(), this.a);
    if (this.a.aM)
    {
      setVisibility(8);
      this.b.a(com.unionpay.mobile.android.languages.c.bD.c);
    }
    t();
  }
  
  private final boolean C()
  {
    boolean bool2 = false;
    try
    {
      if (this.F != null) {}
      for (String str = this.F.getString(3);; str = null)
      {
        boolean bool1 = bool2;
        if (str != null)
        {
          bool1 = bool2;
          if (str.length() > 0)
          {
            boolean bool3 = "null".equalsIgnoreCase(str);
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      return false;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private final void D()
  {
    int m = 0;
    int j;
    label134:
    label297:
    Object localObject2;
    Object localObject4;
    label600:
    for (;;)
    {
      int i;
      try
      {
        j.c("uppay", "showContentView() +++" + this.C);
        if (this.C != 2) {
          if (!this.E)
          {
            i = 1;
            int k = m;
            if (this.E)
            {
              k = m;
              if (!"1".equalsIgnoreCase(this.a.an))
              {
                j = this.a.ao;
                if ((!f(j)) || ((j & 0x11101) != 0)) {
                  break label1119;
                }
                j = 1;
                k = m;
                if (j == 0)
                {
                  bool = this.a.aD;
                  k = m;
                  if (!bool) {
                    k = 1;
                  }
                }
              }
            }
            if ((i == 0) && (k == 0)) {}
          }
          else
          {
            i = 0;
            continue;
          }
        }
        if (this.D) {
          continue;
        }
        this.D = true;
        if (this.a.aM) {
          this.b.c();
        }
        i = this.a.ao;
        if (!"1".equalsIgnoreCase(this.a.an)) {
          break label297;
        }
        if (this.a.aC)
        {
          this.a.q = null;
          if ((!"0".equalsIgnoreCase(this.a.an)) || ((this.a.q != null) && (this.a.q.size() > 0)) || (f(i))) {
            break;
          }
          c(this.a.ap, "fail");
          continue;
        }
        this.a.q = this.r;
      }
      finally {}
      continue;
      if ((com.unionpay.mobile.android.model.b.aA) && (com.unionpay.mobile.android.model.b.aB) && (!com.unionpay.mobile.android.model.b.bm) && (this.s != null) && (this.s.size() > 0))
      {
        localObject2 = this.s.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((com.unionpay.mobile.android.model.c)((Iterator)localObject2).next()).c() == 1) {
            ((Iterator)localObject2).remove();
          }
        }
      }
      if ("0".equalsIgnoreCase(this.a.an)) {
        this.a.q = this.s;
      }
      for (;;)
      {
        if ((this.a.q == null) || (this.a.q.size() <= 0)) {
          break label600;
        }
        localObject2 = this.a.q.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (com.unionpay.mobile.android.model.c)((Iterator)localObject2).next();
          if ((((com.unionpay.mobile.android.model.c)localObject4).c() != 0) && ((((com.unionpay.mobile.android.model.c)localObject4).c() & i) == 0)) {
            ((Iterator)localObject2).remove();
          }
        }
        break;
        if (this.a.aC)
        {
          this.a.q = this.s;
        }
        else
        {
          if ((this.s != null) && (this.s.size() > 0)) {
            this.a.q.addAll(this.s);
          }
          if ((this.r != null) && (this.r.size() > 0)) {
            this.a.q.addAll(this.r);
          }
        }
      }
    }
    boolean bool = "1".equalsIgnoreCase(this.a.an);
    if (!bool) {}
    for (;;)
    {
      String str1;
      String str2;
      String str3;
      try
      {
        if (this.F == null) {
          break label859;
        }
        localObject4 = this.F.getString(0);
        if (this.F == null) {
          break label870;
        }
        str1 = this.F.getString(1);
        if (this.F == null) {
          break label881;
        }
        str2 = this.F.getString(2);
        if (!C()) {
          break label892;
        }
        str3 = this.F.getString(3);
        com.unionpay.mobile.android.model.c localc;
        if (this.a.q != null)
        {
          Iterator localIterator = this.a.q.iterator();
          if (localIterator.hasNext())
          {
            localc = (com.unionpay.mobile.android.model.c)localIterator.next();
            if (localc.c() == 0) {
              continue;
            }
            localObject2 = "";
          }
        }
        switch (localc.c())
        {
        case 16: 
          localc.a((String)localObject2);
          continue;
          if (com.unionpay.mobile.android.model.b.bm) {}
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (((!com.unionpay.mobile.android.model.b.aA) || (!com.unionpay.mobile.android.model.b.aB)) && (com.unionpay.mobile.android.model.b.bl))
      {
        c(this.a.ap, "fail");
        break label134;
        label859:
        localObject4 = com.unionpay.mobile.android.languages.c.bD.ak;
        continue;
        label870:
        str1 = com.unionpay.mobile.android.languages.c.bD.aj;
        continue;
        label881:
        str2 = com.unionpay.mobile.android.languages.c.bD.ai;
        continue;
        label892:
        str3 = com.unionpay.mobile.android.languages.c.bD.al;
        continue;
        Object localObject3 = str2;
        continue;
        localObject3 = localObject4;
        continue;
        localObject3 = str1;
        continue;
        localObject3 = str3;
        continue;
      }
      if ((v()) && (this.a.az) && (!this.a.aC) && (!this.a.aD)) {
        a(this.t, this.x, this.u, this.v, this.y, this.w);
      }
      if ((this.a.ax) && (this.a.aD) && (this.a.ay)) {
        d(17);
      }
      for (;;)
      {
        j.c("uppay", "showContentView() ---");
        break;
        if ((this.a.aE) && (this.a.az) && (com.unionpay.mobile.android.model.b.bk) && ((com.unionpay.mobile.android.model.b.bb == null) || (com.unionpay.mobile.android.model.b.bb.size() <= 0))) {
          b(com.unionpay.mobile.android.languages.c.bD.bq, this.a.bg);
        } else {
          a(2, this.G);
        }
      }
      label1119:
      j = 0;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = new m(this, paramString3);
    n localn = new n(this);
    if (paramString1.equalsIgnoreCase("01")) {}
    for (int i = 0; i != 0; i = 1)
    {
      this.b.a(paramString3, localn);
      this.b.a(com.unionpay.mobile.android.languages.c.bD.ae, paramString2, com.unionpay.mobile.android.languages.c.bD.af, com.unionpay.mobile.android.languages.c.bD.ag);
      return;
    }
    this.b.a(paramString3, localn);
    this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, paramString2, com.unionpay.mobile.android.languages.c.bD.af, com.unionpay.mobile.android.languages.c.bD.ag);
  }
  
  private void b(int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      this.a.I.f = paramString;
    }
    this.z.setVisibility(4);
    a(c(paramInt), true);
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      this.a.I.f = paramString2;
    }
    this.z.setVisibility(4);
    a(paramString1, true);
  }
  
  private boolean f(int paramInt)
  {
    if ((paramInt & 0x2) != 0)
    {
      this.a.aw = true;
      return true;
    }
    return false;
  }
  
  public final void A()
  {
    removeAllViews();
    this.z = null;
  }
  
  public void B()
  {
    d("000");
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3) {}
  
  public final void a(int paramInt, byte[] paramArrayOfByte)
  {
    j();
    if (paramInt != 0) {
      b(paramInt, null);
    }
    j.a("uppay", "status = " + paramInt);
    if (paramArrayOfByte != null)
    {
      paramInt = 0;
      if ("mounted".equals(Environment.getExternalStorageState())) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        b(9, null);
      }
    }
    else
    {
      return;
    }
    if (p.a(paramArrayOfByte) == true)
    {
      paramArrayOfByte = new Intent();
      paramArrayOfByte.setAction("android.intent.action.VIEW");
      String str = Environment.getExternalStorageDirectory() + File.separator + "UPPay" + File.separator + "UPPayPluginEx.apk";
      j.a("uppay", "apk path:" + str);
      paramArrayOfByte.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
      ((BaseActivity)this.d).startActivityForResult(paramArrayOfByte, 100);
      return;
    }
    b(21, null);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    j.a("uppay", "init.parserParamJsonObj() +++");
    if (paramJSONObject == null)
    {
      b(2);
      return;
    }
    switch (this.B)
    {
    }
    for (;;)
    {
      j.a("uppay", "init.parserParamJsonObj() ---");
      return;
      Object localObject1 = i.a(paramJSONObject, "secret");
      i.a(paramJSONObject, "sec_sign");
      this.e.e((String)localObject1);
      localObject1 = i.a(paramJSONObject, "talking_data_flag");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        com.unionpay.mobile.android.global.a.L = "0".equals(localObject1);
      }
      String str1 = i.a(paramJSONObject, "mer_id");
      localObject1 = "002";
      if (!TextUtils.isEmpty(str1)) {
        localObject1 = str1;
      }
      if (!this.a.I.d) {
        localObject1 = "001";
      }
      if (com.unionpay.mobile.android.global.a.L)
      {
        UPAgent.init(this.d, this.e.b(this.a.I.c), (String)localObject1);
        UPAgent.setReportUncaughtExceptions(true);
        UPAgent.setAdditionalVersionNameAndCode(com.unionpay.mobile.android.languages.c.bD.a, 57L);
      }
      a(this.d, "tn", o.a, new String[] { this.a.b });
      a(this.d, "merch_id", o.b, new String[] { str1 });
      a(this.d, "package_version", o.c, new String[] { com.unionpay.mobile.android.languages.c.bD.a });
      localObject1 = i.c(paramJSONObject, "upgrade_info");
      this.A = i.a((JSONObject)localObject1, "type");
      str1 = i.a((JSONObject)localObject1, "desc");
      String str2 = i.a((JSONObject)localObject1, "url");
      if (this.A.equalsIgnoreCase("02"))
      {
        a(this.A, str1, str2);
      }
      else
      {
        this.a.o = i.a(paramJSONObject, "title");
        this.a.j = i.c(paramJSONObject, "init_button");
        this.a.h = i.d(paramJSONObject, "order");
        localObject1 = new HashMap();
        int i = 0;
        Object localObject2;
        while (i < this.a.h.length())
        {
          localObject2 = i.b(this.a.h, i);
          if (localObject2 != null)
          {
            localObject2 = (JSONObject)localObject2;
            ((Map)localObject1).put(i.a((JSONObject)localObject2, "label"), i.a((JSONObject)localObject2, "value"));
          }
          i += 1;
        }
        a(this.d, "basic_info", o.d, new String[] { localObject1.toString() });
        this.a.i = i.c(paramJSONObject, "risk_info");
        localObject1 = i.e(paramJSONObject, "cards");
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
          this.r = new ArrayList(((List)localObject1).size());
        }
        i = 0;
        while ((localObject1 != null) && (i < ((List)localObject1).size()))
        {
          localObject2 = new com.unionpay.mobile.android.model.a(i.a((JSONArray)((List)localObject1).get(i), 0), i.a((JSONArray)((List)localObject1).get(i), 1), i.a((JSONArray)((List)localObject1).get(i), 2), (byte)0);
          this.r.add(localObject2);
          i += 1;
        }
        this.a.s = i.a(paramJSONObject, "bank_url");
        this.a.t = i.d(paramJSONObject, "input_info");
        this.a.v = i.c(paramJSONObject, "account_info");
        this.a.w = i.c(paramJSONObject, "other_card_info");
        this.a.u = i.a(paramJSONObject, "user_id");
        this.e.c(i.a(paramJSONObject, "sid"));
        this.e.d(i.a(paramJSONObject, "secret"));
        localObject1 = i.a(paramJSONObject, "sid");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.a.k = this.e.i(com.unionpay.mobile.android.utils.c.b((String)localObject1));
        }
        localObject1 = i.a(paramJSONObject, "secret");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.a.l = this.e.i(com.unionpay.mobile.android.utils.c.b((String)localObject1));
          this.a.m = ((String)localObject1);
        }
        localObject1 = i.a(paramJSONObject, "uid");
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          PreferenceUtils.b(this.d, (String)localObject1);
        }
        if (w())
        {
          if (v())
          {
            this.a.x = i.c(paramJSONObject, "kalefu_info");
            this.a.y = i.a(paramJSONObject, "kalefu_button_label");
            if (((this.a.y == null) || (this.a.y.length() <= 0)) && (com.unionpay.mobile.android.languages.c.bD != null)) {
              this.a.y = com.unionpay.mobile.android.languages.c.bD.am;
            }
          }
          this.F = i.d(paramJSONObject, "cards_desc");
          this.a.an = i.a(paramJSONObject, "trade_privilege");
          this.a.ap = i.a(paramJSONObject, "upcard_msg");
          this.a.ao = 0;
          localObject1 = i.a(paramJSONObject, "upcard_support_type");
          if ((!"1".equalsIgnoreCase(this.a.an)) && (localObject1 != null) && (((String)localObject1).length() > 0)) {
            this.a.ao = Integer.parseInt((String)localObject1, 2);
          }
          f(this.a.ao);
        }
        this.a.ar = i.a(paramJSONObject, "ad");
        this.a.at = i.a(paramJSONObject, "pay_tip");
        localObject1 = i.a(paramJSONObject, "sup_pay_method");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.a.aC = "01".equals(localObject1);
          this.a.aD = "001".equals(localObject1);
        }
        localObject1 = i.a(paramJSONObject, "default_pay_type");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.a.aE = "0501".equals(localObject1);
        }
        this.a.au = i.c(paramJSONObject, "find_pwd_url");
        this.a.Y = i.c(paramJSONObject, "reg_url");
        this.a.ay = "1".equals(i.a(paramJSONObject, "sup_nfc"));
        this.a.az = "1".equals(i.a(paramJSONObject, "sup_hce"));
        com.unionpay.mobile.android.model.b.aA = "1".equals(i.a(paramJSONObject, "sup_samsung_pay"));
        this.a.bg = i.a(paramJSONObject, "hce_introduction_url");
        if ((v()) && (this.a.ay) && (!this.a.aC))
        {
          localObject1 = i.a(paramJSONObject, "nfc_title");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            com.unionpay.mobile.android.languages.c.bD.bo = ((String)localObject1);
          }
          localObject1 = i.c(paramJSONObject, "nfc_button");
          if (localObject1 != null)
          {
            localObject1 = i.a((JSONObject)localObject1, "label");
            if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
              com.unionpay.mobile.android.languages.c.bD.bp = ((String)localObject1);
            }
          }
        }
        Object localObject3;
        Object localObject4;
        if ((v()) && (this.a.az) && (!this.a.aC) && (!this.a.aD))
        {
          localObject1 = i.a(paramJSONObject, "hce_title");
          this.t = i.b(paramJSONObject, "hce_page_size");
          localObject2 = i.c(paramJSONObject, "hce_button");
          localObject3 = i.a((JSONObject)localObject2, "label");
          localObject4 = i.a((JSONObject)localObject2, "htmlLabel");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            com.unionpay.mobile.android.languages.c.bD.bq = ((String)localObject1);
            label1384:
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              break label1739;
            }
            com.unionpay.mobile.android.languages.c.bD.br = ((String)localObject4);
            label1400:
            this.u = i.a((JSONObject)localObject2, "action");
            this.v = i.a((JSONObject)localObject2, "reserved");
            this.w = i.a(paramJSONObject, "iss_ins_code");
            this.x = i.b(paramJSONObject, "hce_bank_timeout");
            this.y = i.b(paramJSONObject, "hce_concurrent_count");
            i = i.b(paramJSONObject, "hce_pay_timeout");
            if (i == 0) {
              break label1750;
            }
            this.a.bd = i;
            label1477:
            this.a.bh = i.a(paramJSONObject, "no_hce_card_msg");
          }
        }
        else
        {
          localObject2 = this.a;
          ((com.unionpay.mobile.android.model.b)localObject2).p = new HashMap();
          localObject3 = i.c(paramJSONObject, "f55");
          localObject1 = i.a((JSONObject)localObject3, "order_amount");
          localObject4 = ((com.unionpay.mobile.android.model.b)localObject2).p;
          if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
            break label1763;
          }
          paramJSONObject = (JSONObject)localObject1;
          label1547:
          ((HashMap)localObject4).put("trans_amt", paramJSONObject);
          ((com.unionpay.mobile.android.model.b)localObject2).bo = com.unionpay.mobile.android.utils.c.c((String)localObject1);
          localObject1 = i.a((JSONObject)localObject3, "order_currency");
          localObject4 = ((com.unionpay.mobile.android.model.b)localObject2).p;
          if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
            break label1770;
          }
          paramJSONObject = (JSONObject)localObject1;
          label1595:
          ((HashMap)localObject4).put("trans currcy code", paramJSONObject);
          ((com.unionpay.mobile.android.model.b)localObject2).bp = ((String)localObject1);
          paramJSONObject = i.a((JSONObject)localObject3, "trans_type");
          localObject1 = ((com.unionpay.mobile.android.model.b)localObject2).p;
          if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
            break label1777;
          }
          label1637:
          ((HashMap)localObject1).put("trans_type", paramJSONObject);
          paramJSONObject = i.a((JSONObject)localObject3, "mer_name");
          localObject1 = ((com.unionpay.mobile.android.model.b)localObject2).p;
          if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
            break label1784;
          }
        }
        for (;;)
        {
          ((HashMap)localObject1).put("mer_name", paramJSONObject);
          if (this.a.aD) {
            this.a.u = "";
          }
          if (this.A.equalsIgnoreCase("00")) {
            break label1790;
          }
          a(this.A, str1, str2);
          break;
          com.unionpay.mobile.android.languages.c.bD.bq = ((String)localObject3);
          break label1384;
          label1739:
          com.unionpay.mobile.android.languages.c.bD.br = ((String)localObject3);
          break label1400;
          label1750:
          this.a.bd = 5000;
          break label1477;
          label1763:
          paramJSONObject = "000000000000";
          break label1547;
          label1770:
          paramJSONObject = "0156";
          break label1595;
          label1777:
          paramJSONObject = "00";
          break label1637;
          label1784:
          paramJSONObject = "";
        }
        label1790:
        if (b(this.a.u))
        {
          this.B = 2;
          paramJSONObject = String.format("\"user_id\":\"%s\"", new Object[] { this.a.u });
          this.e.n(paramJSONObject);
        }
        else
        {
          x();
          continue;
          f.c(this.a, paramJSONObject);
          i = f.b(this.a, paramJSONObject);
          if (i != 0)
          {
            b(i);
          }
          else
          {
            localObject1 = i.a(paramJSONObject, "userId");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              a(this.d, "_login", o.e, new Object[] { localObject1 });
            }
            this.G = f.a(paramJSONObject);
            x();
          }
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.ax = paramBoolean;
  }
  
  public final void b(int paramInt)
  {
    j.a("uppay", toString() + "doErrHappended() +++");
    b(paramInt, "fail");
    j.a("uppay", toString() + "doErrHappended() ---");
  }
  
  public final void c(String paramString)
  {
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    new q(this.d, paramString, this).a();
  }
  
  protected final void d()
  {
    super.d();
    this.m.setBackgroundColor(-1);
    setBackgroundDrawable(this.c.a(3008));
    int i = com.unionpay.mobile.android.global.a.I / 2;
    Object localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageDrawable(this.c.a(1027, i, -1));
    ((ImageView)localObject).setId(localObject.hashCode());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.leftMargin = com.unionpay.mobile.android.global.a.j;
    localLayoutParams.topMargin = ((int)(0.3F * com.unionpay.mobile.android.global.a.t));
    addView((View)localObject, localLayoutParams);
    this.z = new ProgressBar(getContext(), null, 16843399);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(3, ((ImageView)localObject).getId());
    localLayoutParams.topMargin = (com.unionpay.mobile.android.global.a.d * 3);
    addView(this.z, localLayoutParams);
    localObject = new LinearLayout(this.d);
    ((LinearLayout)localObject).setOrientation(1);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.bottomMargin = com.unionpay.mobile.android.global.a.b;
    addView((View)localObject, localLayoutParams);
    TextView localTextView = new TextView(this.d);
    localTextView.setText(com.unionpay.mobile.android.languages.c.bD.a);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(14.0F);
    localTextView.setGravity(1);
    new LinearLayout.LayoutParams(-2, -2).gravity = 14;
    ((LinearLayout)localObject).addView(localTextView, localLayoutParams);
    localTextView = new TextView(getContext());
    localTextView.setText(com.unionpay.mobile.android.languages.c.bD.b);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(16.0F);
    localTextView.setGravity(1);
    new LinearLayout.LayoutParams(-2, -2).gravity = 14;
    ((LinearLayout)localObject).addView(localTextView, localLayoutParams);
  }
  
  public final void d(String paramString)
  {
    this.B = 1;
    this.e.a(this.H);
    if (this.a.f) {
      this.e.b(this.a.e, paramString);
    }
    for (;;)
    {
      this.e.a(this);
      return;
      this.e.b(this.a.b, paramString);
    }
  }
  
  public final void l() {}
  
  protected void t()
  {
    u();
  }
  
  public final void u()
  {
    int i = 1;
    Activity localActivity;
    boolean bool2;
    if (!this.K)
    {
      this.K = true;
      y();
      this.E = false;
      localActivity = this.I;
      bool2 = this.J;
      this.e.a();
    }
    try
    {
      j = Integer.parseInt(this.a.I.c);
      if (!"com.unionpay.uppay".equals(com.unionpay.mobile.android.utils.e.b(this.d)))
      {
        bool1 = true;
        if (!this.a.f) {
          break label207;
        }
        Object localObject1 = this.a;
        i = 2;
        UPPayEngine localUPPayEngine = this.e;
        String str = this.a.a;
        int k = this.a.aO;
        if (!this.a.f) {
          break label237;
        }
        localObject1 = this.a.d;
        this.H = localUPPayEngine.initJNIEnv(localActivity, i, j, bool1, str, k, com.unionpay.mobile.android.utils.c.b((String)localObject1));
        if ((!bool2) || (this.H == 0L) || (this.H == -1L)) {
          break label249;
        }
        localObject1 = this.d;
        B();
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label207:
      label237:
      label249:
      do
      {
        for (;;)
        {
          int j = 0;
          continue;
          boolean bool1 = false;
          continue;
          Object localObject2;
          if (this.a.c)
          {
            localObject2 = this.a;
          }
          else
          {
            localObject2 = this.a;
            i = 0;
            continue;
            localObject2 = this.a.b;
          }
        }
        if (this.H == -1L)
        {
          b(7, null);
          return;
        }
      } while (bool2);
      b(5, null);
    }
  }
  
  public boolean v()
  {
    return false;
  }
  
  public boolean w()
  {
    return false;
  }
  
  public final void x()
  {
    if (this.A.equalsIgnoreCase("02"))
    {
      k();
      return;
    }
    this.C += 1;
    this.E = true;
    D();
  }
  
  public void y()
  {
    z();
  }
  
  protected final void z()
  {
    this.C += 1;
    D();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */