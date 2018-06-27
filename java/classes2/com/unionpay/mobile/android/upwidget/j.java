package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.widgets.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
  extends LinearLayout
{
  private View.OnClickListener A = new m(this);
  private View.OnClickListener B = new n(this);
  private View.OnClickListener C = new o(this);
  private View.OnClickListener D = new p(this);
  private Context a;
  private JSONArray b;
  private int c;
  private int d;
  private boolean e = true;
  private a[] f;
  private ArrayList<Object> g;
  private LinearLayout h;
  private HorizontalScrollView i;
  private com.unionpay.mobile.android.widgets.k j = null;
  private ad k = null;
  private TextView l = null;
  private TextView m = null;
  private int n = 0;
  private int o = 0;
  private int p = -1;
  private int q;
  private int r;
  private String s;
  private ArrayList<AdapterView.OnItemClickListener> t = new ArrayList();
  private ArrayList<View.OnClickListener> u = new ArrayList();
  private ArrayList<View.OnClickListener> v = new ArrayList();
  private ArrayList<View.OnClickListener> w = new ArrayList();
  private ArrayList<View.OnClickListener> x = new ArrayList();
  private AdapterView.OnItemClickListener y = new k(this);
  private View.OnClickListener z = new l(this);
  
  public j(Context paramContext, JSONArray paramJSONArray, int paramInt, String paramString)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramJSONArray;
    this.o = paramInt;
    paramContext = new DisplayMetrics();
    ((Activity)this.a).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
    this.q = paramContext.widthPixels;
    paramContext = new DisplayMetrics();
    ((Activity)this.a).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
    this.r = paramContext.heightPixels;
    this.s = paramString;
    if (this.b != null)
    {
      paramContext = new FrameLayout(this.a);
      paramString = new RelativeLayout(this.a);
      paramContext.addView(paramString, new FrameLayout.LayoutParams(-1, -1));
      Object localObject = new RelativeLayout.LayoutParams(-1, this.r / 3 * 2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      paramJSONArray = new LinearLayout(this.a);
      paramJSONArray.setOrientation(1);
      paramJSONArray.setBackgroundColor(-1);
      paramJSONArray.setId(paramJSONArray.hashCode());
      paramString.addView(paramJSONArray, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      LinearLayout localLinearLayout = new LinearLayout(this.a);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, paramJSONArray.getId());
      paramString.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
      localLinearLayout.setOnClickListener(this.z);
      this.h = new LinearLayout(this.a);
      this.h.setBackgroundColor(-1);
      this.h.setOrientation(0);
      paramString = new LinearLayout.LayoutParams(-1, a.n);
      paramJSONArray.addView(this.h, paramString);
      paramString = new LinearLayout.LayoutParams(-1, f.a(this.a, 1.0F));
      localObject = new LinearLayout(this.a);
      ((LinearLayout)localObject).setBackgroundColor(-3355444);
      paramJSONArray.addView((View)localObject, paramString);
      this.i = new HorizontalScrollView(this.a);
      this.i.setBackgroundColor(-1052684);
      paramString = new LinearLayout.LayoutParams(-2, -1);
      paramJSONArray.addView(this.i, paramString);
      paramInt = f.a(this.a, 40.0F);
      paramJSONArray = new ImageView(this.a);
      paramJSONArray.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.a).a(1034));
      paramJSONArray.setOnClickListener(this.z);
      paramString = new FrameLayout.LayoutParams(paramInt, paramInt);
      paramString.gravity = 85;
      paramString.rightMargin = f.a(this.a, 10.0F);
      paramString.bottomMargin = (this.r / 3 * 2 - paramInt / 2);
      paramContext.addView(paramJSONArray, paramString);
      addView(paramContext);
      a();
    }
  }
  
  private View a(LinearLayout paramLinearLayout, JSONObject paramJSONObject)
  {
    paramJSONObject = b(i.d(paramJSONObject, "options"));
    paramJSONObject = new c(this.a, paramJSONObject, "", "", "", this.p, 1);
    this.g.add(paramJSONObject);
    ListView localListView = new ListView(this.a);
    localListView.setDivider(null);
    localListView.setAdapter(paramJSONObject);
    localListView.setOnItemClickListener(this.y);
    localListView.setCacheColorHint(-1);
    paramLinearLayout.addView(localListView, new LinearLayout.LayoutParams(this.q, -1));
    return localListView;
  }
  
  private static String a(JSONArray paramJSONArray, int paramInt, String paramString)
  {
    paramJSONArray = i.b(paramJSONArray, paramInt);
    if (paramJSONArray != null) {
      return i.a((JSONObject)paramJSONArray, paramString);
    }
    return "";
  }
  
  private void a()
  {
    int i2 = this.b.length();
    this.f = new a[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      this.f[i1] = new a(0);
      if (this.f[i1].a == null) {
        this.f[i1].a = new TextView(this.a);
      }
      if (this.f[i1].b == null) {
        this.f[i1].b = new LinearLayout(this.a);
      }
      if (this.f[i1].c == null) {
        this.f[i1].c = new ListView(this.a);
      }
      if (this.f[i1].d == null) {
        this.f[i1].d = "";
      }
      i1 += 1;
    }
    this.g = new ArrayList(this.b.length());
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(0);
    Object localObject1 = new LinearLayout.LayoutParams(-2, -1);
    this.i.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    i1 = 0;
    if (i1 < this.b.length())
    {
      localObject1 = (JSONObject)i.b(this.b, i1);
      String str = i.a((JSONObject)localObject1, "action");
      Object localObject3 = i.a((JSONObject)localObject1, "label");
      RelativeLayout localRelativeLayout = new RelativeLayout(this.a);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -1);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = f.a(this.a, 10.0F);
      this.h.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject2);
      i2 = f.a(this.a, 10.0F);
      localObject2 = new TextView(this.a);
      ((TextView)localObject2).setText((CharSequence)localObject3);
      ((TextView)localObject2).setTextSize(b.k);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setSingleLine(true);
      ((TextView)localObject2).setTextColor(-10066330);
      ((TextView)localObject2).setPadding(i2, 0, i2, 0);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      int i3 = f.a(this.a, 2.0F);
      localObject3 = new RelativeLayout.LayoutParams((int)((TextView)localObject2).getPaint().measureText((String)localObject3) + i2 + i2, i3);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject4 = new LinearLayout(this.a);
      ((LinearLayout)localObject4).setBackgroundColor(-16730965);
      if (this.o != i1) {
        ((LinearLayout)localObject4).setVisibility(8);
      }
      localRelativeLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      localRelativeLayout.setTag(Integer.valueOf(i1));
      localRelativeLayout.setOnClickListener(this.D);
      this.f[i1].a = ((TextView)localObject2);
      this.f[i1].b = ((LinearLayout)localObject4);
      this.f[i1].d = str;
      if (this.o == i1)
      {
        this.p = 0;
        label571:
        str = i.a((JSONObject)localObject1, "type");
        if (!"coupon".equals(str)) {
          break label647;
        }
        this.d = i1;
        localObject1 = b(localLinearLayout, (JSONObject)localObject1);
      }
      for (;;)
      {
        this.f[i1].c = ((View)localObject1);
        this.f[i1].c.setVisibility(8);
        i1 += 1;
        break;
        this.p = -1;
        break label571;
        label647:
        if ("point".equals(str))
        {
          this.c = i1;
          localObject1 = c(localLinearLayout, (JSONObject)localObject1);
        }
        else if ("upoint".equals(str))
        {
          localObject1 = c(localLinearLayout, (JSONObject)localObject1);
        }
        else
        {
          localObject1 = a(localLinearLayout, (JSONObject)localObject1);
        }
      }
    }
    a(this.o);
  }
  
  private void a(int paramInt)
  {
    this.f[this.o].b.setVisibility(8);
    this.f[this.o].a.setTextColor(-16777216);
    this.f[this.o].c.setVisibility(8);
    this.f[paramInt].b.setVisibility(0);
    this.f[paramInt].a.setTextColor(-16730965);
    this.f[paramInt].c.setVisibility(0);
    this.o = paramInt;
  }
  
  private void a(LinearLayout paramLinearLayout, boolean paramBoolean, String paramString, JSONObject paramJSONObject, c paramc)
  {
    paramLinearLayout.removeAllViews();
    Object localObject = new ListView(this.a);
    ((ListView)localObject).setDivider(null);
    ((ListView)localObject).setAdapter(paramc);
    ((ListView)localObject).setOnItemClickListener(this.y);
    this.g.add(paramc);
    paramLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(this.q, -2));
    if (paramc != null) {
      ((LinearLayout.LayoutParams)paramLinearLayout.getLayoutParams()).gravity = 48;
    }
    int i1;
    if (paramBoolean)
    {
      i1 = a.p;
      paramc = new LinearLayout.LayoutParams(i1, i1);
      paramc.bottomMargin = f.a(this.a, 12.0F);
      paramc.gravity = 17;
      paramLinearLayout.addView(new ProgressBar(this.a), paramc);
    }
    paramc = new TextView(this.a);
    if (!TextUtils.isEmpty(paramString))
    {
      paramc.setText(paramString);
      paramc.setTextSize(b.k);
      paramc.setTextColor(-13421773);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      paramLinearLayout.addView(paramc, (ViewGroup.LayoutParams)localObject);
    }
    if (paramJSONObject != null)
    {
      localObject = new TextView(this.a);
      ((TextView)localObject).setText(i.a(paramJSONObject, "label"));
      ((TextView)localObject).setTextSize(b.i);
      ((TextView)localObject).setTextColor(g.a(b.b, b.c, b.c, b.d));
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setEnabled(true);
      i1 = a.n;
      ((TextView)localObject).setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.a).a(2008));
      float f1 = paramc.getPaint().measureText(paramString);
      ((TextView)localObject).setOnClickListener(this.A);
      paramString = new LinearLayout.LayoutParams((int)f1, i1);
      i1 = a.f;
      paramString.bottomMargin = i1;
      paramString.topMargin = i1;
      i1 = f.a(this.a, 10.0F);
      paramString.rightMargin = i1;
      paramString.leftMargin = i1;
      paramLinearLayout.addView((View)localObject, paramString);
    }
  }
  
  private View b(LinearLayout paramLinearLayout, JSONObject paramJSONObject)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.a);
    ListView localListView = new ListView(this.a);
    localListView.setDivider(null);
    localListView.setAdapter(null);
    this.g.add(localListView);
    JSONArray localJSONArray = i.d(paramJSONObject, "rules");
    Object localObject5 = null;
    Object localObject2 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject3 = localObject6;
    Object localObject4 = localObject5;
    int i1;
    if (localJSONArray != null)
    {
      localObject3 = localObject6;
      localObject4 = localObject5;
      if (localJSONArray.length() > 0)
      {
        i1 = 0;
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (i1 < localJSONArray.length())
        {
          localObject3 = i.b(localJSONArray, i1);
          if (localObject3 == null) {
            break label852;
          }
          localObject3 = (JSONObject)localObject3;
          localObject4 = i.a((JSONObject)localObject3, "type");
          if ("coupon_code".equals(localObject4)) {
            localObject2 = localObject3;
          }
        }
      }
    }
    label852:
    for (;;)
    {
      i1 += 1;
      break;
      if ("string".equals(localObject4))
      {
        localObject1 = localObject3;
        continue;
        localObject1 = new RelativeLayout.LayoutParams(this.q, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
        localRelativeLayout.addView(localListView, (ViewGroup.LayoutParams)localObject1);
        i1 = a.I - a.f * 4;
        this.j = new com.unionpay.mobile.android.widgets.k(this.a, i1, (JSONObject)localObject4, this.s);
        this.j.setId(this.j.hashCode());
        localObject1 = new RelativeLayout.LayoutParams(this.q, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
        int i2 = f.a(this.a, 10.0F);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = i2;
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = i2;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = i2;
        localRelativeLayout.addView(this.j, (ViewGroup.LayoutParams)localObject1);
        this.k = new ad(this.a, i1, (JSONObject)localObject3, this.s);
        localObject1 = new RelativeLayout.LayoutParams(this.q, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.j.getId());
        i1 = f.a(this.a, 10.0F);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = i1;
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = i1;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = i1;
        localRelativeLayout.addView(this.k, (ViewGroup.LayoutParams)localObject1);
        this.l = new TextView(this.a);
        this.l.setTextSize(b.k);
        this.l.setTextColor(-10066330);
        this.l.setVisibility(8);
        localObject1 = new RelativeLayout.LayoutParams(this.q, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.j.getId());
        i1 = f.a(this.a, 10.0F);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = i1;
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = i1;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = i1;
        localRelativeLayout.addView(this.l, (ViewGroup.LayoutParams)localObject1);
        localObject1 = i.c(paramJSONObject, "use_button");
        paramJSONObject = new LinearLayout(this.a);
        paramJSONObject.setOrientation(1);
        paramJSONObject.setBackgroundColor(-1);
        localObject2 = new LinearLayout.LayoutParams(-1, f.a(this.a, 1.0F));
        localObject3 = new LinearLayout(this.a);
        ((LinearLayout)localObject3).setBackgroundColor(-3355444);
        paramJSONObject.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
        this.m = new TextView(this.a);
        this.m.setText(i.a((JSONObject)localObject1, "label"));
        this.m.setTextSize(b.i);
        this.m.setTextColor(g.a(b.b, b.c, b.c, b.d));
        this.m.setGravity(17);
        this.m.setEnabled(false);
        i1 = a.n;
        localObject1 = com.unionpay.mobile.android.resource.c.a(this.a).a(2008);
        this.m.setBackgroundDrawable((Drawable)localObject1);
        this.m.setTag(Integer.valueOf(this.d));
        this.m.setOnClickListener(this.C);
        localObject1 = new LinearLayout.LayoutParams(-1, i1);
        i1 = a.f;
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = i1;
        ((LinearLayout.LayoutParams)localObject1).topMargin = i1;
        i1 = f.a(this.a, 10.0F);
        ((LinearLayout.LayoutParams)localObject1).rightMargin = i1;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = i1;
        paramJSONObject.addView(this.m, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(this.q, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
        localRelativeLayout.addView(paramJSONObject, (ViewGroup.LayoutParams)localObject1);
        paramLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(this.q, -2));
        return localRelativeLayout;
      }
    }
  }
  
  private static List<Map<String, Object>> b(JSONArray paramJSONArray)
  {
    HashMap localHashMap = null;
    Object localObject = localHashMap;
    if (paramJSONArray != null)
    {
      localObject = localHashMap;
      if (paramJSONArray.length() > 0)
      {
        localObject = new ArrayList(paramJSONArray.length());
        int i1 = 0;
        while (i1 < paramJSONArray.length())
        {
          localHashMap = new HashMap();
          localHashMap.put("text1", a(paramJSONArray, i1, "label"));
          localHashMap.put("text2", "");
          localHashMap.put("editable", Boolean.FALSE);
          String str = a(paramJSONArray, i1, "available");
          boolean bool2 = Boolean.TRUE.booleanValue();
          boolean bool1 = bool2;
          if (!TextUtils.isEmpty(str))
          {
            bool1 = bool2;
            if ("1".equals(str)) {
              bool1 = Boolean.FALSE.booleanValue();
            }
          }
          localHashMap.put("available", Boolean.valueOf(bool1));
          ((List)localObject).add(localHashMap);
          i1 += 1;
        }
      }
    }
    return (List<Map<String, Object>>)localObject;
  }
  
  private View c(LinearLayout paramLinearLayout, JSONObject paramJSONObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(1);
    String str1 = i.a(paramJSONObject, "tip");
    String str2 = i.a(paramJSONObject, "empty_info");
    JSONObject localJSONObject = i.c(paramJSONObject, "button");
    if (localJSONObject != null)
    {
      a(localLinearLayout, false, str1, localJSONObject, null);
      paramJSONObject = new LinearLayout.LayoutParams(-2, -2);
      paramJSONObject.gravity = 17;
      localLinearLayout.setGravity(17);
      paramLinearLayout.addView(localLinearLayout, paramJSONObject);
      return localLinearLayout;
    }
    if ("upoint".equals(i.a(paramJSONObject, "type")))
    {
      if ((str2 != null) && (!TextUtils.isEmpty(str2)))
      {
        a(localLinearLayout, false, str2, null, null);
        paramJSONObject = new LinearLayout.LayoutParams(-2, -2);
        paramJSONObject.gravity = 17;
        localLinearLayout.setGravity(17);
        paramLinearLayout.addView(localLinearLayout, paramJSONObject);
        return localLinearLayout;
      }
      return a(paramLinearLayout, paramJSONObject);
    }
    paramJSONObject = new LinearLayout.LayoutParams(-2, -2);
    paramJSONObject.gravity = 17;
    localLinearLayout.setGravity(17);
    paramLinearLayout.addView(localLinearLayout, paramJSONObject);
    return localLinearLayout;
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.u.add(paramOnClickListener);
  }
  
  public final void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.t.add(paramOnItemClickListener);
  }
  
  public final void a(JSONArray paramJSONArray)
  {
    paramJSONArray = i.b(paramJSONArray, 0);
    if (paramJSONArray != null)
    {
      paramJSONArray = (JSONObject)paramJSONArray;
      this.l.setText(i.a(paramJSONArray, "label"));
      this.l.setVisibility(0);
      this.k.setVisibility(8);
    }
    this.m.setEnabled(true);
  }
  
  public final void a(JSONArray paramJSONArray, String paramString)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      paramJSONArray = b(paramJSONArray);
      paramJSONArray = new c(this.a, paramJSONArray, "", "", "", -1, 1);
      this.g.add(this.c, paramJSONArray);
    }
    for (;;)
    {
      a((LinearLayout)this.f[this.c].c, false, paramString, null, paramJSONArray);
      return;
      paramJSONArray = null;
    }
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    this.v.add(paramOnClickListener);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    this.w.add(paramOnClickListener);
  }
  
  public final void d(View.OnClickListener paramOnClickListener)
  {
    this.x.add(paramOnClickListener);
  }
  
  public final void e(View.OnClickListener paramOnClickListener)
  {
    if (this.j != null)
    {
      this.j.a(paramOnClickListener);
      this.j.b(this.B);
    }
  }
  
  private final class a
  {
    TextView a;
    LinearLayout b;
    View c;
    String d;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */