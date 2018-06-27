package com.growingio.android.sdk.models;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  @SuppressLint({"NewApi"})
  private static LruCache<Class, String> t = new LruCache(100);
  j a;
  public String b;
  public View c;
  public int d;
  public int e = -1;
  public boolean f;
  public e g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public boolean m;
  public boolean n;
  public boolean o = false;
  public Rect p;
  public a q;
  public String r;
  public String s;
  private int u;
  private int v = -1;
  
  public i() {}
  
  public i(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, String paramString3, j paramj)
  {
    this.c = paramView;
    this.e = paramInt2;
    this.f = paramBoolean2;
    this.u = paramInt1;
    this.m = paramBoolean1;
    this.n = paramBoolean3;
    this.o = paramBoolean4;
    this.j = paramString2;
    this.i = paramString1;
    this.r = paramString3;
    this.a = paramj;
  }
  
  private void a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.getGlobalVisibleRect(paramRect);
      return;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView.getLocalVisibleRect(paramRect);
    paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
  }
  
  private void f()
  {
    if (this.c.getTag(84159243) != null) {
      this.l = ((String)this.c.getTag(84159243));
    }
    this.k = Util.a(this.c, this.h);
  }
  
  private void g()
  {
    int i2 = this.u;
    ViewGroup localViewGroup;
    int i1;
    if ((this.c.getParent() != null) && ((this.c.getParent() instanceof ViewGroup)))
    {
      localViewGroup = (ViewGroup)this.c.getParent();
      if (ClassExistHelper.instanceOfViewPager(localViewGroup)) {
        i1 = ((ViewPager)localViewGroup).getCurrentItem();
      }
    }
    for (;;)
    {
      this.d = i1;
      return;
      if ((localViewGroup instanceof AdapterView))
      {
        i1 = ((AdapterView)localViewGroup).getFirstVisiblePosition() + this.u;
      }
      else if (ClassExistHelper.instanceOfRecyclerView(localViewGroup))
      {
        int i3 = ViewHelper.a(this.c, localViewGroup);
        i1 = i3;
        if (i3 >= 0) {}
      }
      else
      {
        i1 = i2;
      }
    }
  }
  
  private void h()
  {
    Object localObject2 = this.c.getParent();
    if ((localObject2 == null) || ((WindowHelper.b(this.c)) && (!(localObject2 instanceof View)))) {}
    label1160:
    for (;;)
    {
      return;
      String str = this.i;
      Object localObject1 = this.j;
      Object localObject3 = this.c.getTag(84159241);
      if (localObject3 != null)
      {
        this.i = ("/" + localObject3);
        this.j = (this.j + "/" + localObject3);
        return;
      }
      long l1;
      if ((localObject2 != null) && ((localObject2 instanceof View)))
      {
        localObject3 = (View)localObject2;
        if ((localObject3 instanceof ExpandableListView))
        {
          localObject2 = (ExpandableListView)localObject3;
          l1 = ((ExpandableListView)this.c.getParent()).getExpandableListPosition(this.d);
          if (ExpandableListView.getPackedPositionType(l1) == 2)
          {
            this.m = false;
            if (this.d < ((ExpandableListView)localObject2).getHeaderViewsCount())
            {
              this.i = (str + "/ELH[" + this.d + "]/" + this.b + "[0]");
              this.j = ((String)localObject1 + "/ELH[" + this.d + "]/" + this.b + "[0]");
            }
          }
        }
      }
      for (;;)
      {
        if (!GConfig.USE_ID) {
          break label1160;
        }
        str = Util.a(this.c, this.o);
        if (str == null) {
          break;
        }
        if (this.c.getTag(84159242) != null) {
          this.o = true;
        }
        this.i = (this.i + "#" + str);
        this.j = (this.j + "#" + str);
        return;
        int i1 = this.d - (((ExpandableListView)localObject2).getCount() - ((ExpandableListView)localObject2).getFooterViewsCount());
        this.i = (str + "/ELF[" + i1 + "]/" + this.b + "[0]");
        this.j = ((String)localObject1 + "/ELF[" + i1 + "]/" + this.b + "[0]");
        continue;
        i1 = ExpandableListView.getPackedPositionGroup(l1);
        int i2 = ExpandableListView.getPackedPositionChild(l1);
        if (i2 != -1)
        {
          this.e = i2;
          this.i = (str + "/ELVG[" + i1 + "]/ELVC[" + i2 + "]/" + this.b + "[0]");
          this.j = (str + "/ELVG[" + i1 + "]/ELVC[-]/" + this.b + "[0]");
        }
        else
        {
          this.e = i1;
          this.i = (str + "/ELVG[" + i1 + "]/" + this.b + "[0]");
          this.j = (str + "/ELVG[-]/" + this.b + "[0]");
          continue;
          if (Util.a((View)localObject3))
          {
            localObject1 = ((View)localObject3).getTag(84159247);
            if ((localObject1 != null) && ((localObject1 instanceof List)))
            {
              this.d = Util.a((List)localObject1, this.d);
              this.h = Util.a(String.valueOf(((List)localObject1).get(this.d)));
            }
            this.e = this.d;
            this.i = (str + "/" + this.b + "[" + this.e + "]");
            this.j = (str + "/" + this.b + "[-]");
          }
          else if (ClassExistHelper.instanceOfSwipeRefreshLayout(localObject2))
          {
            this.i = (str + "/" + this.b + "[0]");
            this.j = ((String)localObject1 + "/" + this.b + "[0]");
          }
          else
          {
            this.i = (str + "/" + this.b + "[" + this.d + "]");
            this.j = ((String)localObject1 + "/" + this.b + "[" + this.d + "]");
            continue;
            this.i = (str + "/" + this.b + "[" + this.d + "]");
            this.j = ((String)localObject1 + "/" + this.b + "[" + this.d + "]");
          }
        }
      }
    }
  }
  
  private boolean i()
  {
    ViewParent localViewParent = this.c.getParent();
    return (localViewParent != null) && ((this.c.isClickable()) || ((this.c instanceof TextView)) || ((this.c instanceof ImageView)) || ((this.c instanceof WebView)) || ((localViewParent instanceof AdapterView)) || ((this.c instanceof RadioGroup)) || ((this.c instanceof Spinner)) || ((this.c instanceof RatingBar)) || ((this.c instanceof SeekBar)) || (ClassExistHelper.instanceOfX5WebView(this.c)));
  }
  
  @TargetApi(11)
  private boolean j()
  {
    return (this.c.getLocalVisibleRect(new Rect())) && (this.c.getVisibility() == 0) && (this.c.getWidth() > 0) && (this.c.getHeight() > 0) && (this.c.getAlpha() > 0.0F);
  }
  
  public void a()
  {
    if (this.a.a(this))
    {
      this.b = Util.a(this.c.getClass());
      g();
      h();
      f();
      if (i()) {
        this.a.b(this);
      }
      if (!ClassExistHelper.instanceOfX5WebView(this.c)) {}
    }
    else
    {
      return;
    }
    b();
  }
  
  public void a(j paramj)
  {
    this.a = paramj;
  }
  
  public void b()
  {
    if (((this.c instanceof ViewGroup)) && (!(this.c instanceof Spinner)) && (!(this.c instanceof RadioGroup)))
    {
      ViewGroup localViewGroup = (ViewGroup)this.c;
      int i1 = 0;
      if (i1 < localViewGroup.getChildCount())
      {
        Object localObject = localViewGroup.getChildAt(i1);
        int i2 = this.e;
        boolean bool1;
        label82:
        boolean bool2;
        if ((this.m) || (Util.a(this.c)))
        {
          bool1 = true;
          boolean bool3 = this.f;
          if ((!this.n) && (!Util.c(this.c))) {
            break label200;
          }
          bool2 = true;
          label108:
          localObject = new i((View)localObject, i1, i2, bool1, bool3, bool2, this.o, this.i, this.j, this.r, this.a);
          if (!Util.c(this.c)) {
            break label206;
          }
        }
        label200:
        label206:
        for (((i)localObject).s = this.j;; ((i)localObject).s = this.s)
        {
          ((i)localObject).h = this.h;
          ((i)localObject).l = this.l;
          ((i)localObject).a();
          i1 += 1;
          break;
          bool1 = false;
          break label82;
          bool2 = false;
          break label108;
        }
      }
    }
  }
  
  public i c()
  {
    return new i(null, this.u, this.e, this.m, this.f, this.n, this.o, this.i, this.j, this.r, null);
  }
  
  public boolean d()
  {
    return (j()) && (!Util.b(this.c));
  }
  
  public JSONObject e()
  {
    boolean bool2 = false;
    Object localObject = this.c;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("xpath", this.j);
        if (this.e > -1) {
          localJSONObject.put("index", String.valueOf(this.e));
        }
        Rect localRect = new Rect();
        a((View)localObject, localRect, this.f);
        double d1 = com.growingio.android.sdk.circle.i.f();
        Util.a((View)localObject, localRect, this.f);
        if ((this.p != null) && (!localRect.intersect(this.p))) {
          return null;
        }
        localJSONObject.put("left", localRect.left * d1);
        localJSONObject.put("top", localRect.top * d1);
        localJSONObject.put("width", localRect.width() * d1);
        localJSONObject.put("height", d1 * localRect.height());
        if (this.c.getTag(84159246) == null) {
          break label485;
        }
        bool1 = true;
        localJSONObject.put("isTrackingEditText", bool1);
        boolean bool3 = Util.c((View)localObject);
        if (!bool3)
        {
          bool1 = bool2;
          if (!this.n)
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.k)) {}
          }
          else
          {
            localJSONObject.put("isContainer", bool1);
            if (bool3)
            {
              localObject = "button";
              if (this.q != null)
              {
                localObject = this.q.e;
                localJSONObject.put("href", this.q.d);
                localJSONObject.put("query", this.q.c);
              }
              localJSONObject.put("nodeType", localObject);
              if (!TextUtils.isEmpty(this.s)) {
                localJSONObject.put("parentXPath", this.s);
              }
              if (!TextUtils.isEmpty(this.k)) {
                localJSONObject.put("content", this.k);
              }
              localObject = this.c.getTag(84159244);
              if (localObject != null) {
                localJSONObject.put("grContent", localObject);
              }
              localJSONObject.put("grImage", this.c instanceof ImageView);
              localJSONObject.put("grBannerContent", this.h);
              localJSONObject.put("grIgnored", Util.b(this.c));
              localJSONObject.put("grObj", this.l);
              return localJSONObject;
            }
            localObject = "text";
            continue;
          }
        }
        bool1 = true;
      }
      catch (JSONException localJSONException)
      {
        LogUtil.d("GIO.ViewNode", "generate impress view error", localJSONException);
        return null;
      }
      continue;
      label485:
      boolean bool1 = false;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof i)) && (paramObject.hashCode() == hashCode());
  }
  
  public int hashCode()
  {
    int i3 = 0;
    int i1;
    if (this.v == -1)
    {
      if (this.k == null) {
        break label87;
      }
      i1 = this.k.hashCode();
      if (this.j == null) {
        break label92;
      }
    }
    label87:
    label92:
    for (int i2 = this.j.hashCode();; i2 = 0)
    {
      if (this.l != null) {
        i3 = this.l.hashCode();
      }
      this.v = (((i2 + (i1 + 527) * 31) * 31 + i3) * 31 + this.e);
      return this.v;
      i1 = 0;
      break;
    }
  }
  
  public static class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */