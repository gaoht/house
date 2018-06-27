package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public final class UPWidget
  extends aa
  implements u.b
{
  private static final int n = a.t / 3;
  private static int r = 0;
  private long o;
  private boolean p = true;
  private String q = null;
  private boolean s = false;
  private ViewTreeObserver.OnGlobalLayoutListener t = new aw(this);
  private bb u = null;
  private View.OnClickListener v = new ax(this);
  
  public UPWidget(Context paramContext, long paramLong, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.o = paramLong;
    this.b.a(this);
    this.b.a(new InputFilter.LengthFilter(6));
    this.b.f();
    this.b.d();
    e();
  }
  
  private View A()
  {
    return ((Activity)this.c).findViewById(8888);
  }
  
  private native void appendOnce(long paramLong, String paramString);
  
  private native void clearAll(long paramLong);
  
  private native void deleteOnce(long paramLong);
  
  private native String getMsg(long paramLong);
  
  private native String getMsgExtra(long paramLong, String paramString);
  
  private void z()
  {
    if (A() != null) {
      A().getViewTreeObserver().removeGlobalOnLayoutListener(this.t);
    }
    if ((this.u != null) && (this.u.b())) {
      this.u.a();
    }
  }
  
  public final String a()
  {
    if (this.p) {
      return getMsgExtra(this.o, this.q);
    }
    return getMsg(this.o);
  }
  
  public final void a(long paramLong)
  {
    this.o = paramLong;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if (paramBoolean)
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
      int i = 1;
      int j = A().getRootView().getHeight();
      int k = A().getHeight();
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      if (j - k != localRect.top) {
        i = 0;
      }
      if (i != 0) {
        l();
      }
      while (j()) {
        return;
      }
      j.a("uppay", "key board is closing..");
      j.a("uppay", "registerKeyboardDissmisslisner() +++");
      if (A() != null) {
        A().getViewTreeObserver().addOnGlobalLayoutListener(this.t);
      }
      j.a("uppay", "registerKeyboardDissmisslisner() ---");
      return;
    }
    z();
  }
  
  public final void a_()
  {
    if ((this.s) && (!j())) {
      l();
    }
  }
  
  public final void b(String paramString)
  {
    this.q = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public final boolean b()
  {
    return r == 6;
  }
  
  public final boolean c()
  {
    j.a("uppay", "emptyCheck() +++ ");
    j.a("uppay", "mPINCounts =  " + r);
    j.a("uppay", "emptyCheck() --- ");
    return r != 0;
  }
  
  protected final String d()
  {
    return "_bank_pwd";
  }
  
  public final void e()
  {
    if (r > 0)
    {
      clearAll(this.o);
      r = 0;
    }
  }
  
  public final boolean j()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.u != null)
    {
      bool1 = bool2;
      if (this.u.b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void k()
  {
    j.a("uppay", "closeCustomKeyboard() +++");
    if (j()) {
      z();
    }
    j.a("uppay", "closeCustomKeyboard() ---");
  }
  
  public final void l()
  {
    if ((this.s) && (!j()))
    {
      this.u = new bb(getContext(), this.v, this);
      this.u.a(this);
      int j = r;
      String str = "";
      int i = 0;
      while (i < j)
      {
        str = str + "*";
        i += 1;
      }
      this.b.c(str);
      this.b.b(str.length());
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    k();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/UPWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */