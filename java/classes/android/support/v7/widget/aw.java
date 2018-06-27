package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

class aw
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  private static aw i;
  private final View a;
  private final CharSequence b;
  private final Runnable c = new Runnable()
  {
    public void run()
    {
      aw.a(aw.this, false);
    }
  };
  private final Runnable d = new Runnable()
  {
    public void run()
    {
      aw.a(aw.this);
    }
  };
  private int e;
  private int f;
  private ax g;
  private boolean h;
  
  private aw(View paramView, CharSequence paramCharSequence)
  {
    this.a = paramView;
    this.b = paramCharSequence;
    this.a.setOnLongClickListener(this);
    this.a.setOnHoverListener(this);
  }
  
  private void a()
  {
    if (i == this)
    {
      i = null;
      if (this.g == null) {
        break label63;
      }
      this.g.a();
      this.g = null;
      this.a.removeOnAttachStateChangeListener(this);
    }
    for (;;)
    {
      this.a.removeCallbacks(this.c);
      this.a.removeCallbacks(this.d);
      return;
      label63:
      Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!ViewCompat.isAttachedToWindow(this.a)) {
      return;
    }
    if (i != null) {
      i.a();
    }
    i = this;
    this.h = paramBoolean;
    this.g = new ax(this.a.getContext());
    this.g.a(this.a, this.e, this.f, this.h, this.b);
    this.a.addOnAttachStateChangeListener(this);
    long l;
    if (this.h) {
      l = 2500L;
    }
    for (;;)
    {
      this.a.removeCallbacks(this.d);
      this.a.postDelayed(this.d, l);
      return;
      if ((ViewCompat.getWindowSystemUiVisibility(this.a) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  public static void setTooltipText(View paramView, CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((i != null) && (i.a == paramView)) {
        i.a();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new aw(paramView, paramCharSequence);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.g != null) && (this.h)) {}
    do
    {
      do
      {
        return false;
        paramView = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
      } while ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()));
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      case 9: 
      default: 
        return false;
      }
    } while ((!this.a.isEnabled()) || (this.g != null));
    this.e = ((int)paramMotionEvent.getX());
    this.f = ((int)paramMotionEvent.getY());
    this.a.removeCallbacks(this.c);
    this.a.postDelayed(this.c, ViewConfiguration.getLongPressTimeout());
    return false;
    a();
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    this.e = (paramView.getWidth() / 2);
    this.f = (paramView.getHeight() / 2);
    a(true);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */