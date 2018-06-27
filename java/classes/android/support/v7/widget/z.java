package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.r;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class z
  implements View.OnAttachStateChangeListener, View.OnTouchListener
{
  private final float a;
  private final int b;
  final View c;
  private final int d;
  private Runnable e;
  private Runnable f;
  private boolean g;
  private int h;
  private final int[] i = new int[2];
  
  public z(View paramView)
  {
    this.c = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.a = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.b = ViewConfiguration.getTapTimeout();
    this.d = ((this.b + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.c;
    if (!localView.isEnabled()) {}
    int j;
    do
    {
      return false;
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        return false;
      case 0: 
        this.h = paramMotionEvent.getPointerId(0);
        if (this.e == null) {
          this.e = new a();
        }
        localView.postDelayed(this.e, this.b);
        if (this.f == null) {
          this.f = new b();
        }
        localView.postDelayed(this.f, this.d);
        return false;
      case 2: 
        j = paramMotionEvent.findPointerIndex(this.h);
      }
    } while ((j < 0) || (a(localView, paramMotionEvent.getX(j), paramMotionEvent.getY(j), this.a)));
    b();
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    return true;
    b();
    return false;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < paramView.getRight() - paramView.getLeft() + paramFloat3) && (paramFloat2 < paramView.getBottom() - paramView.getTop() + paramFloat3);
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.i;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  private void b()
  {
    if (this.f != null) {
      this.c.removeCallbacks(this.f);
    }
    if (this.e != null) {
      this.c.removeCallbacks(this.e);
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    View localView = this.c;
    Object localObject = getPopup();
    if ((localObject == null) || (!((r)localObject).isShowing())) {}
    do
    {
      return false;
      localObject = (DropDownListView)((r)localObject).getListView();
    } while ((localObject == null) || (!((DropDownListView)localObject).isShown()));
    MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
    b(localView, localMotionEvent);
    a((View)localObject, localMotionEvent);
    boolean bool = ((DropDownListView)localObject).onForwardedEvent(localMotionEvent, this.h);
    localMotionEvent.recycle();
    int j = paramMotionEvent.getActionMasked();
    if ((j != 1) && (j != 3))
    {
      j = 1;
      if ((!bool) || (j == 0)) {
        break label129;
      }
    }
    label129:
    for (bool = true;; bool = false)
    {
      return bool;
      j = 0;
      break;
    }
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.i;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  void a()
  {
    b();
    View localView = this.c;
    if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
    while (!onForwardingStarted()) {
      return;
    }
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    localView.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.g = true;
  }
  
  public abstract r getPopup();
  
  protected boolean onForwardingStarted()
  {
    r localr = getPopup();
    if ((localr != null) && (!localr.isShowing())) {
      localr.show();
    }
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    r localr = getPopup();
    if ((localr != null) && (localr.isShowing())) {
      localr.dismiss();
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.g;
    if (bool3)
    {
      if ((b(paramMotionEvent)) || (!onForwardingStopped())) {}
      for (bool1 = true;; bool1 = false)
      {
        this.g = bool1;
        if (!bool1)
        {
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
    if ((a(paramMotionEvent)) && (onForwardingStarted())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.c.onTouchEvent(paramView);
        paramView.recycle();
      }
      break;
    }
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.g = false;
    this.h = -1;
    if (this.e != null) {
      this.c.removeCallbacks(this.e);
    }
  }
  
  private class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      ViewParent localViewParent = z.this.c.getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  private class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      z.this.a();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */