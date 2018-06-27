package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine.a;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.upwidget.UPScrollView.a;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.widgets.UPWidget;
import com.unionpay.mobile.android.widgets.aa;
import com.unionpay.mobile.android.widgets.aa.a;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.mobile.android.widgets.ae;
import com.unionpay.mobile.android.widgets.ah;
import com.unionpay.mobile.android.widgets.ap;
import com.unionpay.mobile.android.widgets.as;
import com.unionpay.mobile.android.widgets.au;
import com.unionpay.mobile.android.widgets.av;
import com.unionpay.mobile.android.widgets.ay.a;
import com.unionpay.mobile.android.widgets.u;
import com.unionpay.mobile.android.widgets.y;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.sdk.UPAgent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  extends RelativeLayout
  implements UPPayEngine.a, a, UPScrollView.a, aa.a, ay.a
{
  protected com.unionpay.mobile.android.model.b a = null;
  protected com.unionpay.mobile.android.widgets.m b = null;
  protected com.unionpay.mobile.android.resource.c c = null;
  protected Context d = null;
  protected UPPayEngine e = null;
  protected int f = 0;
  protected String g = null;
  protected String h = null;
  protected String i = null;
  protected boolean j = true;
  protected RelativeLayout k = null;
  protected ViewGroup l = null;
  protected RelativeLayout m = null;
  protected as n = null;
  protected UPScrollView o = null;
  protected com.unionpay.mobile.android.model.e p;
  protected String q = "uppay";
  private LinearLayout r;
  private LinearLayout s;
  private LinearLayout t;
  private int u;
  private int v;
  private Activity w = null;
  
  public b(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(Context paramContext, com.unionpay.mobile.android.model.e parame)
  {
    super(paramContext);
    this.d = paramContext;
    if ((this.d instanceof Activity)) {
      this.w = ((Activity)this.d);
    }
    this.p = parame;
    this.e = ((UPPayEngine)((BaseActivity)paramContext).a(UPPayEngine.class.toString()));
    this.a = ((com.unionpay.mobile.android.model.b)((BaseActivity)paramContext).a(null));
    this.b = ((com.unionpay.mobile.android.widgets.m)((BaseActivity)paramContext).a(com.unionpay.mobile.android.widgets.m.class.toString()));
    this.c = com.unionpay.mobile.android.resource.c.a(paramContext);
    setId(8888);
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    setBackgroundColor(-1);
    j.b("uppayEx", "UPViewBase:" + toString());
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.d;
    Object localObject;
    switch (paramInt1)
    {
    case 3: 
    case 4: 
    case 7: 
    case 9: 
    case 15: 
    case 16: 
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        localBaseActivity.a((b)localObject);
      }
      return;
      localObject = localBaseActivity.a(paramInt1, null);
      continue;
      paramInt2 = 0;
      paramInt1 = paramInt2;
      if (this.a.q != null)
      {
        paramInt1 = paramInt2;
        if (this.a.q.size() > 0) {
          paramInt1 = ((com.unionpay.mobile.android.model.c)this.a.q.get(this.a.N)).c();
        }
      }
      if (((i()) || (paramInt1 == 0)) && (!this.a.bq))
      {
        localObject = new at(this.d);
      }
      else
      {
        localObject = localBaseActivity.a(6, null);
        continue;
        localObject = new bd(this.d);
        continue;
        localObject = new g(this.d);
        continue;
        localObject = new ak(this.d);
        continue;
        localObject = new ai(this.d);
        continue;
        localObject = new af(this.d);
        continue;
        localObject = new o(this.d, null);
        continue;
        localObject = new bi(this.d, paramInt2, paramBoolean1, paramBoolean2);
        continue;
        localObject = localBaseActivity.a(paramInt1, null);
        continue;
        localObject = localBaseActivity.a(paramInt1, null);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null, null);
  }
  
  public static void a(Context paramContext, String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject)
  {
    if (com.unionpay.mobile.android.global.a.L)
    {
      j.a("uppay-TD", "event:" + paramString + ", keys:" + Arrays.toString(paramArrayOfString) + ", values:" + Arrays.toString(paramArrayOfObject));
      if ((paramArrayOfString != null) && (paramArrayOfObject != null))
      {
        if ((paramArrayOfString.length != paramArrayOfObject.length) || (paramArrayOfString.length > 10)) {
          throw new IllegalArgumentException();
        }
        HashMap localHashMap = new HashMap();
        int i1 = 0;
        while (i1 < paramArrayOfString.length)
        {
          localHashMap.put(paramArrayOfString[i1], paramArrayOfObject[i1]);
          i1 += 1;
        }
        UPAgent.onEvent(paramContext, paramString, paramString, localHashMap);
      }
    }
    else
    {
      return;
    }
    UPAgent.onEvent(paramContext, paramString);
  }
  
  protected static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0);
  }
  
  protected static ColorStateList p()
  {
    return com.unionpay.mobile.android.utils.g.a(com.unionpay.mobile.android.global.b.b, com.unionpay.mobile.android.global.b.c, com.unionpay.mobile.android.global.b.c, com.unionpay.mobile.android.global.b.d);
  }
  
  private final RelativeLayout t()
  {
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    if (this.k != null)
    {
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.k.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    }
    Object localObject2 = new FrameLayout(this.d);
    addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    this.o = new UPScrollView(this.d);
    this.o.setPadding(0, 0, 0, 0);
    ((FrameLayout)localObject2).addView(this.o, (ViewGroup.LayoutParams)localObject1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    int i1 = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
    this.t = new LinearLayout(this.d);
    this.t.setId(this.t.hashCode());
    this.t.setOrientation(1);
    TextView localTextView;
    if ((this.a.aM) && (!com.unionpay.mobile.android.model.b.bl))
    {
      this.t.setBackgroundColor(-34177);
      this.t.setPadding(i1, i1, i1, i1);
      localObject1 = "";
      if (b(this.a.ar)) {
        localObject1 = "" + this.a.ar;
      }
      if (!b((String)localObject1)) {
        break label388;
      }
      localTextView = new TextView(this.d);
      if ((!this.a.aM) || (com.unionpay.mobile.android.model.b.bl)) {
        break label377;
      }
      localTextView.setTextColor(-1);
      label282:
      localTextView.setText((CharSequence)localObject1);
      localTextView.setTextSize(com.unionpay.mobile.android.global.b.k);
      this.t.addView(localTextView);
    }
    for (;;)
    {
      this.t.setVisibility(8);
      ((FrameLayout)localObject2).addView(this.t, localLayoutParams);
      localObject1 = new RelativeLayout(this.d);
      ((RelativeLayout)localObject1).setBackgroundColor(-1052684);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.o.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      return (RelativeLayout)localObject1;
      this.t.setBackgroundColor(-267336);
      break;
      label377:
      localTextView.setTextColor(-10066330);
      break label282;
      label388:
      this.t.setVisibility(8);
    }
  }
  
  protected final RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setId(localRelativeLayout.hashCode());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(10, -1);
    addView(localRelativeLayout, localLayoutParams);
    return localRelativeLayout;
  }
  
  protected final z a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    String str = i.a(paramJSONObject, "type");
    int i1 = com.unionpay.mobile.android.global.a.I - com.unionpay.mobile.android.global.a.f * 4;
    if ("pan".equalsIgnoreCase(str)) {
      localObject = new com.unionpay.mobile.android.widgets.af(this.d, i1, paramJSONObject, paramString);
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof aa))) {
        ((aa)localObject).a(this);
      }
      return (z)localObject;
      if ("mobile".equalsIgnoreCase(str)) {
        localObject = new ah(this.d, i1, paramJSONObject, paramString);
      } else if ("sms".equalsIgnoreCase(str)) {
        localObject = new ap(this.d, i1, paramJSONObject, paramString);
      } else if ("cvn2".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.e(this.d, i1, paramJSONObject, paramString);
      } else if ("expire".equalsIgnoreCase(str)) {
        localObject = new av(this.d, i1, paramJSONObject, paramString);
      } else if ("pwd".equalsIgnoreCase(str)) {
        localObject = new UPWidget(this.d, this.e.c(), i1, paramJSONObject, paramString);
      } else if ("text".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.at(this.d, i1, paramJSONObject, paramString);
      } else if ("string".equalsIgnoreCase(str)) {
        localObject = new ad(this.d, paramJSONObject, paramString);
      } else if ("cert_id".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.f(this.d, i1, paramJSONObject, paramString);
      } else if ("cert_type".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.g(this.d, paramJSONObject, paramString);
      } else if ("name".equalsIgnoreCase(str)) {
        localObject = new ae(this.d, i1, paramJSONObject, paramString);
      } else if ("hidden".equalsIgnoreCase(str)) {
        localObject = new y(this.d, paramJSONObject, paramString);
      } else if ("user_name".equalsIgnoreCase(str)) {
        localObject = new au(this.d, i1, paramJSONObject, paramString);
      } else if ("password".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.ao(this.d, i1, paramJSONObject, paramString);
      }
    }
  }
  
  public final void a(int paramInt)
  {
    ((BaseActivity)this.d).a(paramInt);
  }
  
  protected final void a(int paramInt, com.unionpay.mobile.android.model.e parame)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.d;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        localBaseActivity.a((b)localObject1);
      }
      return;
      localObject1 = localBaseActivity.a(paramInt, parame);
      continue;
      int i1 = 0;
      paramInt = i1;
      if (this.a.q != null)
      {
        paramInt = i1;
        if (this.a.q.size() > 0) {
          paramInt = ((com.unionpay.mobile.android.model.c)this.a.q.get(this.a.N)).c();
        }
      }
      if (((i()) || (paramInt == 0) || (this.a.aP == l.c.intValue())) && (!this.a.bq))
      {
        localObject1 = new at(this.d, parame);
      }
      else
      {
        localObject1 = localBaseActivity.a(6, parame);
        continue;
        localObject1 = new bd(this.d);
        continue;
        localObject1 = new g(this.d);
        continue;
        localObject1 = new ak(this.d);
        continue;
        localObject1 = new ai(this.d);
        continue;
        localObject1 = new af(this.d);
        continue;
        localObject1 = new o(this.d, parame);
        continue;
        localObject1 = new bi(this.d);
        continue;
        localObject1 = localBaseActivity.a(paramInt, parame);
      }
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    int i1 = 0;
    this.j = true;
    j.a("uppay", " " + toString());
    if (paramInt == 0)
    {
      j.a("uppay", "parserResponseMesage() +++");
      JSONObject localJSONObject = null;
      Object localObject = null;
      if ((paramString == null) || (paramString.length() == 0))
      {
        j.a("uppay", " ERROR_MSG_FORMAT");
        paramInt = 2;
        paramString = (String)localObject;
        if (paramInt == 0) {
          break label537;
        }
        localObject = this.g;
        if (!a(this.h, paramString)) {
          b(paramInt);
        }
      }
      for (;;)
      {
        j.a("uppay", "parserResponseMesage() ---");
        return;
        localObject = localJSONObject;
        try
        {
          paramString = new JSONObject(paramString);
          localObject = localJSONObject;
          this.g = i.a(paramString, "resp");
          localObject = localJSONObject;
          this.h = i.a(paramString, "msg");
          localObject = localJSONObject;
          this.i = i.a(paramString, "cmd");
          localObject = localJSONObject;
          localJSONObject = i.c(paramString, "params");
          paramInt = i1;
          paramString = localJSONObject;
          localObject = localJSONObject;
          if (this.g.equalsIgnoreCase("00")) {
            break;
          }
          localObject = localJSONObject;
          if (!"pay".equals(this.i))
          {
            localObject = localJSONObject;
            if (this.a.E != null)
            {
              localObject = localJSONObject;
              if (this.a.E.length() > 0)
              {
                localObject = localJSONObject;
                if (!this.a.E.equals(this.i)) {}
              }
            }
          }
          else
          {
            localObject = localJSONObject;
            a(this.d, this.q + "_fail", com.unionpay.mobile.android.utils.o.j, new String[] { this.g, this.h });
          }
          localObject = localJSONObject;
          if ("rules".equals(this.i))
          {
            localObject = localJSONObject;
            a(this.d, this.q + "_cardNO_fail", com.unionpay.mobile.android.utils.o.j, new String[] { this.g, this.h });
          }
          localObject = localJSONObject;
          if ("getuserinfo".equals(this.i))
          {
            localObject = localJSONObject;
            a(this.d, "login_fail", com.unionpay.mobile.android.utils.o.j, new String[] { this.g, this.h });
          }
          localObject = localJSONObject;
          if (!this.g.equalsIgnoreCase("21")) {
            break label516;
          }
          paramInt = 17;
          localObject = localJSONObject;
          j.a("uppay", " ERROR_ORDER_TIMEOUT");
          paramString = localJSONObject;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          j.a("uppay", " ERROR_MSG_FORMAT");
          paramInt = 2;
          paramString = (String)localObject;
        }
        break;
        label516:
        paramInt = 3;
        localObject = localJSONObject;
        j.a("uppay", " ERROR_TRANSACTION");
        paramString = localJSONObject;
        break;
        label537:
        a(paramString);
      }
    }
    b(paramInt);
  }
  
  public final void a(u paramu, String paramString) {}
  
  protected final void a(String paramString)
  {
    a(paramString, false);
  }
  
  protected final void a(String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.b.a(paramOnClickListener1, paramOnClickListener2);
    this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, paramString, com.unionpay.mobile.android.languages.c.bD.W, com.unionpay.mobile.android.languages.c.bD.X, false);
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0, false, false);
  }
  
  protected final void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((InputMethodManager)this.d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    this.a.ag = paramString2;
    this.a.af = paramString1;
    a(14, paramInt, paramBoolean1, paramBoolean2);
  }
  
  protected final void a(String paramString, boolean paramBoolean)
  {
    d locald = new d(this, paramBoolean);
    j.a("uppay", " showErrDialog(msg, boolean)  ");
    this.b.a(locald, null);
    this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, paramString, com.unionpay.mobile.android.languages.c.bD.W);
  }
  
  protected boolean a(String paramString, JSONObject paramJSONObject)
  {
    return false;
  }
  
  protected void b() {}
  
  public void b(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 17) || (paramInt == 19))
    {
      this.a.I.f = "fail";
      j.a("uppay", "showErrDialog 1");
      a(c(paramInt), true);
      return;
    }
    j.a("uppay", "showErrDialog 2");
    a(c(paramInt), false);
  }
  
  protected final void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0, true, true);
  }
  
  protected void b(String paramString, JSONObject paramJSONObject) {}
  
  protected final boolean b(JSONObject paramJSONObject)
  {
    boolean bool = false;
    if (com.unionpay.mobile.android.nocard.utils.f.c(this.a, paramJSONObject))
    {
      c(paramJSONObject);
      bool = true;
    }
    return bool;
  }
  
  protected final String c(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return com.unionpay.mobile.android.languages.c.bD.aA;
    case 2: 
      return com.unionpay.mobile.android.languages.c.bD.aB;
    case 7: 
      return com.unionpay.mobile.android.languages.c.bD.aG;
    case 5: 
      return com.unionpay.mobile.android.languages.c.bD.aH;
    case 6: 
      return com.unionpay.mobile.android.languages.c.bD.aI;
    case 4: 
      return com.unionpay.mobile.android.languages.c.bD.az;
    case 8: 
      return com.unionpay.mobile.android.languages.c.bD.aJ;
    case 9: 
      return com.unionpay.mobile.android.languages.c.bD.aK;
    case 21: 
      return com.unionpay.mobile.android.languages.c.bD.aL;
    case 16: 
      return com.unionpay.mobile.android.languages.c.bD.aM;
    case 19: 
      return com.unionpay.mobile.android.languages.c.bD.aN;
    case 20: 
      return com.unionpay.mobile.android.languages.c.bD.aO;
    case 18: 
      return com.unionpay.mobile.android.languages.c.bD.aP;
    }
    return this.h;
  }
  
  protected void c() {}
  
  protected final void c(JSONObject paramJSONObject)
  {
    e locale = new e(this, paramJSONObject);
    paramJSONObject = new f(this, paramJSONObject);
    this.b.a(locale, paramJSONObject);
    this.b.a(this.a.aG, this.a.aH, this.a.aI, this.a.aK);
  }
  
  protected void d()
  {
    this.m = t();
  }
  
  protected final void d(int paramInt)
  {
    a(paramInt, 0, false, false);
  }
  
  protected final void e()
  {
    this.k = a();
    b();
    RelativeLayout localRelativeLayout = t();
    Object localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    ((LinearLayout)localObject1).setBackgroundColor(-1114114);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.l = ((ViewGroup)localObject1);
    this.l.setBackgroundColor(0);
    f();
    int i1 = this.l.getId();
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, i1);
    localObject2 = new RelativeLayout(this.d);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.m = ((RelativeLayout)localObject2);
    c();
  }
  
  public final void e(int paramInt)
  {
    if (paramInt >= this.v) {
      if ((this.t.getVisibility() != 0) && (this.t != null) && (this.r.getVisibility() == 0)) {
        this.t.setVisibility(0);
      }
    }
    while ((paramInt > this.v + this.u) || (this.t.getVisibility() != 0) || (this.t == null)) {
      return;
    }
    this.t.setVisibility(8);
  }
  
  protected void f()
  {
    this.s = new LinearLayout(this.d);
    this.s.setOrientation(1);
    int i1;
    label84:
    Object localObject1;
    Object localObject2;
    if ((this.a.aM) && (!com.unionpay.mobile.android.model.b.bl))
    {
      this.s.setBackgroundColor(-34177);
      i1 = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
      if (!b(this.a.ar)) {
        break label599;
      }
      this.s.setPadding(i1, i1, i1, 0);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      this.l.addView(this.s, (ViewGroup.LayoutParams)localObject1);
      localObject1 = "";
      if (b(this.a.at)) {
        localObject1 = "" + this.a.at;
      }
      if (!b((String)localObject1)) {
        break label624;
      }
      localObject2 = new TextView(this.d);
      if ((!this.a.aM) || (com.unionpay.mobile.android.model.b.bl)) {
        break label613;
      }
      ((TextView)localObject2).setTextColor(-1);
      label198:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
      this.s.addView((View)localObject2);
      label221:
      this.r = new LinearLayout(this.d);
      this.r.setOrientation(1);
      if ((!this.a.aM) || (com.unionpay.mobile.android.model.b.bl)) {
        break label636;
      }
      this.r.setBackgroundColor(-34177);
      label270:
      this.r.setPadding(i1, i1, i1, i1);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      this.l.addView(this.r, (ViewGroup.LayoutParams)localObject1);
      localObject1 = "";
      if (b(this.a.ar)) {
        localObject1 = "" + this.a.ar;
      }
      if (!b((String)localObject1)) {
        break label660;
      }
      localObject2 = new TextView(this.d);
      if ((!this.a.aM) || (com.unionpay.mobile.android.model.b.bl)) {
        break label649;
      }
      ((TextView)localObject2).setTextColor(-1);
      label395:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
      this.r.addView((View)localObject2);
      label418:
      this.r.getViewTreeObserver().addOnPreDrawListener(new c(this));
      localObject1 = new com.unionpay.mobile.android.views.order.m(this.d);
      ((com.unionpay.mobile.android.views.order.m)localObject1).a(this.c.a(1003), this.c.a(1001));
      if (!(this instanceof ao)) {
        break label672;
      }
    }
    label599:
    label613:
    label624:
    label636:
    label649:
    label660:
    label672:
    for (boolean bool = false;; bool = true)
    {
      ((com.unionpay.mobile.android.views.order.m)localObject1).a(bool, this.a.h, this.a.i);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      this.l.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = this.c.a(1026);
      localObject1 = new LinearLayout(this.d);
      if (localObject2 != null) {
        ((LinearLayout)localObject1).setBackgroundDrawable((Drawable)localObject2);
      }
      localObject2 = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.utils.f.a(this.d, 2.0F));
      this.l.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      return;
      this.s.setBackgroundColor(-267336);
      break;
      this.s.setPadding(i1, i1, i1, i1);
      break label84;
      ((TextView)localObject2).setTextColor(-10066330);
      break label198;
      this.s.setVisibility(8);
      break label221;
      this.r.setBackgroundColor(-267336);
      break label270;
      ((TextView)localObject2).setTextColor(-10066330);
      break label395;
      this.r.setVisibility(8);
      break label418;
    }
  }
  
  protected final void g()
  {
    RelativeLayout localRelativeLayout = this.m;
  }
  
  public final int h()
  {
    return this.f;
  }
  
  protected final boolean i()
  {
    return (this.a.J) || (this.a.q == null) || (this.a.q.size() == 0);
  }
  
  protected final void j()
  {
    if ((this.b != null) && (this.b.a())) {
      this.b.c();
    }
  }
  
  public final void k()
  {
    com.unionpay.mobile.android.nocard.utils.d.a(this.d, this.a);
  }
  
  public void l()
  {
    if (this.j) {
      n();
    }
  }
  
  public final void m()
  {
    l();
  }
  
  public final void n()
  {
    ((BaseActivity)this.d).b();
  }
  
  protected final boolean o()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (this.b.a()) {
        bool1 = true;
      }
    }
    j.a("uppay", " dialog showing:" + bool1);
    return bool1;
  }
  
  protected void onAttachedToWindow()
  {
    j.b("uppayEx", toString() + " onAttachedToWindow()");
    super.onAttachedToWindow();
    this.e.a(this);
  }
  
  protected final boolean q()
  {
    return !this.a.c;
  }
  
  public final void r()
  {
    if ((com.unionpay.mobile.android.global.a.L) && (!TextUtils.isEmpty(this.q)) && (this.w != null))
    {
      j.a("uppay-TD", "page start: " + this.q + "_View");
      UPAgent.onPageStart(this.w, this.q + "_View");
    }
  }
  
  public final void s()
  {
    if ((com.unionpay.mobile.android.global.a.L) && (!TextUtils.isEmpty(this.q)) && (this.w != null))
    {
      j.a("uppay-TD", "page end: " + this.q + "_View");
      UPAgent.onPageEnd(this.w, this.q + "_View");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */