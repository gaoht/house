package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o
  extends LinearLayout
{
  private Context a;
  private int b = l.a.intValue();
  private int c = l.a.intValue();
  private JSONObject d;
  private JSONObject e;
  private JSONObject f;
  private Drawable g;
  private JSONArray h;
  private List<Map<String, Object>> i;
  private String j;
  private AbstractMethod k;
  private CViewMethods l;
  private Drawable m;
  private boolean n;
  
  private o(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    setOrientation(1);
  }
  
  public static o a(Context paramContext, Drawable paramDrawable)
  {
    paramContext = new o(paramContext);
    paramContext.g = paramDrawable;
    return paramContext;
  }
  
  public static o a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    paramContext = new o(paramContext);
    paramContext.m = paramDrawable2;
    paramContext.b = l.c.intValue();
    paramContext.c = l.c.intValue();
    paramContext.g = paramDrawable1;
    paramContext.c();
    return paramContext;
  }
  
  public static o a(Context paramContext, JSONArray paramJSONArray, List<Map<String, Object>> paramList, Drawable paramDrawable1, Drawable paramDrawable2, String paramString)
  {
    paramContext = new o(paramContext);
    paramContext.m = paramDrawable2;
    paramContext.b = l.b.intValue();
    paramContext.c = l.b.intValue();
    paramContext.g = paramDrawable1;
    paramContext.h = paramJSONArray;
    paramContext.i = paramList;
    paramContext.j = paramString;
    paramContext.c();
    return paramContext;
  }
  
  public static o b(Context paramContext, JSONArray paramJSONArray, List<Map<String, Object>> paramList, Drawable paramDrawable1, Drawable paramDrawable2, String paramString)
  {
    paramContext = new o(paramContext);
    paramContext.m = paramDrawable2;
    paramContext.b = l.e.intValue();
    paramContext.c = l.e.intValue();
    paramContext.g = paramDrawable1;
    paramContext.h = paramJSONArray;
    paramContext.i = paramList;
    paramContext.j = paramString;
    paramContext.c();
    return paramContext;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final o a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public final o a(Drawable paramDrawable)
  {
    this.m = paramDrawable;
    return this;
  }
  
  public final o a(a parama)
  {
    if (this.k != null)
    {
      this.k.a(parama);
      this.k.a(parama);
      if ((this.k instanceof b)) {
        ((b)this.k).a(parama);
      }
    }
    if (this.l != null) {
      this.l.a(parama);
    }
    return this;
  }
  
  public final o a(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public final o a(List<Map<String, Object>> paramList)
  {
    this.i = paramList;
    return this;
  }
  
  public final o a(JSONArray paramJSONArray)
  {
    this.h = paramJSONArray;
    return this;
  }
  
  public final o a(JSONObject paramJSONObject)
  {
    this.d = paramJSONObject;
    if ((this.k != null) && ((this.k instanceof b))) {
      ((b)this.k).a(this.d);
    }
    return this;
  }
  
  public final o a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }
  
  public final o b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public final o b(Drawable paramDrawable)
  {
    if (this.k != null) {
      this.k.a(paramDrawable);
    }
    return this;
  }
  
  public final o b(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    if ((this.k != null) && ((this.k instanceof i))) {
      ((i)this.k).a(this.e);
    }
    return this;
  }
  
  public final String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.k != null)
    {
      localObject1 = localObject2;
      if ((this.k instanceof i)) {
        localObject1 = ((i)this.k).h();
      }
    }
    return (String)localObject1;
  }
  
  public final void b(String paramString)
  {
    ((b)this.k).b(paramString);
  }
  
  public final o c(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    if ((this.k != null) && ((this.k instanceof i))) {
      ((i)this.k).b(this.f);
    }
    return this;
  }
  
  public final void c()
  {
    this.k = null;
    com.unionpay.mobile.android.resource.c localc;
    if (this.b == l.b.intValue())
    {
      this.c &= (l.b.intValue() ^ 0xFFFFFFFF);
      localObject = new b(this.a, this.i, this.j);
      ((b)localObject).d(com.unionpay.mobile.android.languages.c.bD.by);
      ((b)localObject).e(com.unionpay.mobile.android.languages.c.bD.bz);
      ((b)localObject).a(this.d);
      ((b)localObject).a(this.h);
      ((b)localObject).b(this.n);
      ((b)localObject).b(com.unionpay.mobile.android.resource.c.a(this.a).a(2014));
      localc = com.unionpay.mobile.android.resource.c.a(this.a);
      ((b)localObject).a(localc.a(1015), localc.a(1016), localc.a(1002));
      this.k = ((AbstractMethod)localObject);
    }
    for (;;)
    {
      if (this.k != null)
      {
        this.k.a();
        localObject = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.b.a;
        addView(this.k, (ViewGroup.LayoutParams)localObject);
      }
      if (this.b != l.e.intValue()) {
        break;
      }
      return;
      if (this.b == l.c.intValue())
      {
        this.c &= (l.c.intValue() ^ 0xFFFFFFFF);
        localObject = new i(this.a);
        ((i)localObject).b(com.unionpay.mobile.android.languages.c.bD.bA);
        ((i)localObject).d(com.unionpay.mobile.android.languages.c.bD.bB);
        ((i)localObject).a(this.e);
        ((i)localObject).b(this.f);
        this.k = ((AbstractMethod)localObject);
      }
      else if (this.b == l.e.intValue())
      {
        this.c &= (l.e.intValue() ^ 0xFFFFFFFF);
        localObject = new b(this.a, this.i, "");
        ((b)localObject).d("");
        ((b)localObject).e(com.unionpay.mobile.android.languages.c.bD.bz);
        ((b)localObject).a(null);
        ((b)localObject).a(this.h);
        ((b)localObject).b(l.e.intValue());
        ((b)localObject).f("");
        ((b)localObject).b(com.unionpay.mobile.android.resource.c.a(this.a).a(2014));
        localc = com.unionpay.mobile.android.resource.c.a(this.a);
        ((b)localObject).a(localc.a(1015), localc.a(1016), localc.a(1002));
        this.k = ((AbstractMethod)localObject);
      }
    }
    this.l = new CViewMethods(this.a);
    this.l.a(this.g);
    this.l.a(this.c);
    Object localObject = new HashMap();
    ((HashMap)localObject).put(l.b, com.unionpay.mobile.android.languages.c.bD.by);
    if ((com.unionpay.mobile.android.languages.c.bD.bp != null) && (!TextUtils.isEmpty(com.unionpay.mobile.android.languages.c.bD.bp)))
    {
      ((HashMap)localObject).put(l.d, com.unionpay.mobile.android.languages.c.bD.bp);
      ((HashMap)localObject).put(l.c, com.unionpay.mobile.android.languages.c.bD.bA);
      if ((com.unionpay.mobile.android.languages.c.bD.br == null) || (TextUtils.isEmpty(com.unionpay.mobile.android.languages.c.bD.br))) {
        break label762;
      }
      ((HashMap)localObject).put(l.e, com.unionpay.mobile.android.languages.c.bD.br);
    }
    for (;;)
    {
      ((HashMap)localObject).put(l.f, com.unionpay.mobile.android.languages.c.bD.bt);
      this.l.a((HashMap)localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put(l.b, this.m);
      ((HashMap)localObject).put(l.d, this.m);
      ((HashMap)localObject).put(l.c, this.m);
      ((HashMap)localObject).put(l.e, this.m);
      ((HashMap)localObject).put(l.f, this.m);
      this.l.b((HashMap)localObject);
      this.l.a(com.unionpay.mobile.android.languages.c.bD.bC).a();
      localObject = new LinearLayout.LayoutParams(-1, -2);
      addView(this.l, (ViewGroup.LayoutParams)localObject);
      return;
      ((HashMap)localObject).put(l.d, com.unionpay.mobile.android.languages.c.bD.bo);
      break;
      label762:
      ((HashMap)localObject).put(l.e, com.unionpay.mobile.android.languages.c.bD.bq);
    }
  }
  
  public final void c(int paramInt)
  {
    if ((this.k != null) && ((this.k instanceof b))) {
      ((b)this.k).a(paramInt);
    }
  }
  
  public static abstract interface a
    extends AbstractMethod.a, AbstractMethod.b, CViewMethods.a, b.b
  {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */