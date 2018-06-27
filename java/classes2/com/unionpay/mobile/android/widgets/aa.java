package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public abstract class aa
  extends z
{
  protected int a;
  protected u b = null;
  private a n = null;
  
  public aa(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    this(paramContext, paramInt, paramJSONObject, paramString, (byte)0);
  }
  
  public aa(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString, byte paramByte)
  {
    super(paramContext, paramJSONObject, paramString);
    this.a = paramInt;
    com.unionpay.mobile.android.resource.c.a(this.c);
    paramContext = getContext();
    paramInt = this.a;
    this.b = new u(paramContext);
    if (this.h)
    {
      this.b.a();
      this.b.d();
    }
    this.b.c(i());
    paramContext = new RelativeLayout.LayoutParams(-1, a.n);
    paramContext.addRule(15, -1);
    this.l.addView(this.b, paramContext);
    this.b.b(i.a(paramJSONObject, "placeholder"));
    this.b.setFocusable(true);
    this.b.a(new ab(this));
    this.b.a(new ac(this));
    paramContext = com.unionpay.mobile.android.resource.c.a(this.c).a(2000, -1, a.v);
    this.b.a(paramContext);
    if ((this instanceof af)) {
      if (!this.h) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aQ);
      }
    }
    while ((this instanceof k))
    {
      this.b.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1011));
      return;
      this.b.c(this.g + " " + this.f);
      continue;
      if ((this instanceof ap)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aR);
      } else if ((this instanceof ah)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aT);
      } else if ((this instanceof UPWidget)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aS);
      } else if ((this instanceof au)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aU);
      } else if ((this instanceof ao)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aV);
      } else if ((this instanceof e)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aW);
      } else if ((this instanceof ae)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aX);
      } else if ((this instanceof bd)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aY);
      } else if ((this instanceof at)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.aZ);
      } else if ((this instanceof av)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.ba);
      } else if ((this instanceof f)) {
        this.b.a(com.unionpay.mobile.android.languages.c.bD.bb);
      }
    }
    this.b.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1013));
  }
  
  public String a()
  {
    return this.b.b();
  }
  
  public void a(Editable paramEditable) {}
  
  public final void a(a parama)
  {
    this.n = parama;
  }
  
  protected final boolean a(View paramView)
  {
    boolean bool = true;
    if (paramView == null) {
      throw new NullPointerException();
    }
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    Log.e("uppay", "v getGlobalVisibleRect():" + localRect.toString());
    localRect = new Rect();
    ((Activity)this.c).getWindow().getDecorView().findViewById(16908290).getGlobalVisibleRect(localRect);
    int[] arrayOfInt1 = new int[2];
    paramView.getLocationInWindow(arrayOfInt1);
    Log.e("uppay", " locationW = [" + arrayOfInt1[0] + "," + arrayOfInt1[1] + "]");
    int[] arrayOfInt2 = new int[2];
    paramView.getLocationOnScreen(arrayOfInt2);
    Log.e("uppay", " locationS = [" + arrayOfInt2[0] + "," + arrayOfInt2[1] + "]");
    if (arrayOfInt1[1] + paramView.getHeight() + 10 > localRect.bottom) {}
    for (;;)
    {
      paramView = ((Activity)this.c).getWindow().getDecorView().findViewById(16908290);
      localRect = new Rect();
      paramView.getLocalVisibleRect(localRect);
      Log.e("uppay", " getLocalVisibleRect = " + localRect.toString());
      localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      Log.e("uppay", " getGlobalVisibleRect = " + localRect.toString());
      return bool;
      bool = false;
    }
  }
  
  public final boolean a(u paramu)
  {
    return (paramu != null) && (this.b == paramu);
  }
  
  public boolean c()
  {
    return (a() != null) && (a().length() != 0);
  }
  
  public final void g()
  {
    if ((this.b != null) && (!this.h)) {
      this.b.e();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(u paramu, String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */