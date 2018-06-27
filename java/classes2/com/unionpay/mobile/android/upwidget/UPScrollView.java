package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import java.lang.ref.WeakReference;

public class UPScrollView
  extends ScrollView
{
  private WeakReference<a> a;
  private int b;
  private ViewTreeObserver.OnGlobalLayoutListener c = new u(this);
  private Handler d = new v(this);
  
  public UPScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public UPScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UPScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(a parama)
  {
    this.a = new WeakReference(parama);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getViewTreeObserver().addOnGlobalLayoutListener(this.c);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getViewTreeObserver().removeGlobalOnLayoutListener(this.c);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      a locala = (a)this.a.get();
      int i = getScrollY();
      this.b = i;
      locala.e(i);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.d.sendMessageDelayed(this.d.obtainMessage(), 5L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/UPScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */