package cn.dreamtobe.kpswitch.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import cn.dreamtobe.kpswitch.R.dimen;

public class c
{
  private static int a = 0;
  private static int b = 0;
  private static int c = 0;
  private static int d = 0;
  
  public static ViewTreeObserver.OnGlobalLayoutListener attach(Activity paramActivity, cn.dreamtobe.kpswitch.b paramb)
  {
    return attach(paramActivity, paramb, null);
  }
  
  @TargetApi(13)
  public static ViewTreeObserver.OnGlobalLayoutListener attach(Activity paramActivity, cn.dreamtobe.kpswitch.b paramb, b paramb1)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.findViewById(16908290);
    boolean bool1 = e.isFullScreen(paramActivity);
    boolean bool2 = e.isTranslucentStatus(paramActivity);
    boolean bool3 = e.a(paramActivity);
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramActivity.getSize(localPoint);
    }
    for (int i = localPoint.y;; i = paramActivity.getHeight())
    {
      paramActivity = new a(bool1, bool2, bool3, localViewGroup, paramb, paramb1, i);
      localViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(paramActivity);
      return paramActivity;
    }
  }
  
  private static boolean b(Context paramContext, int paramInt)
  {
    if (a == paramInt) {}
    while (paramInt < 0) {
      return false;
    }
    a = paramInt;
    Log.d("KeyBordUtil", String.format("save keyboard: %d", new Object[] { Integer.valueOf(paramInt) }));
    return b.save(paramContext, paramInt);
  }
  
  @TargetApi(16)
  public static void detach(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = (ViewGroup)paramActivity.findViewById(16908290);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.getViewTreeObserver().removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
      return;
    }
    paramActivity.getViewTreeObserver().removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public static int getKeyboardHeight(Context paramContext)
  {
    if (a == 0) {
      a = b.get(paramContext, getMinPanelHeight(paramContext.getResources()));
    }
    return a;
  }
  
  public static int getMaxPanelHeight(Resources paramResources)
  {
    if (b == 0) {
      b = paramResources.getDimensionPixelSize(R.dimen.max_panel_height);
    }
    return b;
  }
  
  public static int getMinKeyboardHeight(Context paramContext)
  {
    if (d == 0) {
      d = paramContext.getResources().getDimensionPixelSize(R.dimen.min_keyboard_height);
    }
    return d;
  }
  
  public static int getMinPanelHeight(Resources paramResources)
  {
    if (c == 0) {
      c = paramResources.getDimensionPixelSize(R.dimen.min_panel_height);
    }
    return c;
  }
  
  public static int getValidPanelHeight(Context paramContext)
  {
    return Math.min(getMaxPanelHeight(paramContext.getResources()), Math.max(getMinPanelHeight(paramContext.getResources()), getKeyboardHeight(paramContext)));
  }
  
  public static void hideKeyboard(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static void showKeyboard(View paramView)
  {
    paramView.requestFocus();
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 0);
  }
  
  private static class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int a = 0;
    private final ViewGroup b;
    private final cn.dreamtobe.kpswitch.b c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final int g;
    private boolean h;
    private final c.b i;
    private final int j;
    private boolean k = false;
    private int l;
    
    a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ViewGroup paramViewGroup, cn.dreamtobe.kpswitch.b paramb, c.b paramb1, int paramInt)
    {
      this.b = paramViewGroup;
      this.c = paramb;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramBoolean3;
      this.g = d.getStatusBarHeight(paramViewGroup.getContext());
      this.i = paramb1;
      this.j = paramInt;
    }
    
    private Context a()
    {
      return this.b.getContext();
    }
    
    private void a(int paramInt)
    {
      if (this.a == 0)
      {
        this.a = paramInt;
        this.c.refreshHeight(c.getValidPanelHeight(a()));
      }
      label200:
      do
      {
        int m;
        do
        {
          for (;;)
          {
            return;
            if (a.isHandleByPlaceholder(this.d, this.e, this.f))
            {
              m = ((View)this.b.getParent()).getHeight();
              Log.d("KeyboardStatusListener", String.format("action bar over layout %d display height: %d", new Object[] { Integer.valueOf(((View)this.b.getParent()).getHeight()), Integer.valueOf(paramInt) }));
              m -= paramInt;
            }
            while (m > c.getMinKeyboardHeight(a()))
            {
              Log.d("KeyboardStatusListener", String.format("pre display height: %d display height: %d keyboard: %d ", new Object[] { Integer.valueOf(this.a), Integer.valueOf(paramInt), Integer.valueOf(m) }));
              if (m != this.g) {
                break label200;
              }
              Log.w("KeyboardStatusListener", String.format("On global layout change get keyboard height just equal statusBar height %d", new Object[] { Integer.valueOf(m) }));
              return;
              m = Math.abs(paramInt - this.a);
            }
          }
        } while (!c.a(a(), m));
        paramInt = c.getValidPanelHeight(a());
      } while (this.c.getHeight() == paramInt);
      this.c.refreshHeight(paramInt);
    }
    
    private void b(int paramInt)
    {
      View localView = (View)this.b.getParent();
      int m = localView.getHeight() - localView.getPaddingTop();
      boolean bool;
      if (a.isHandleByPlaceholder(this.d, this.e, this.f))
      {
        if ((!this.e) && (m - paramInt == this.g)) {
          bool = this.h;
        }
        for (;;)
        {
          if (this.h != bool)
          {
            Log.d("KeyboardStatusListener", String.format("displayHeight %d actionBarOverlayLayoutHeight %d keyboard status change: %B", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Boolean.valueOf(bool) }));
            this.c.onKeyboardShowing(bool);
            if (this.i != null) {
              this.i.onKeyboardShowing(bool);
            }
          }
          this.h = bool;
          return;
          if (m > paramInt) {
            bool = true;
          } else {
            bool = false;
          }
        }
      }
      int n = this.b.getResources().getDisplayMetrics().heightPixels;
      if ((!this.e) && (n == m))
      {
        Log.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", new Object[] { Integer.valueOf(n), Integer.valueOf(m) }));
        return;
      }
      if (this.l == 0) {
        bool = this.h;
      }
      for (;;)
      {
        this.l = Math.max(this.l, m);
        break;
        if (paramInt < this.l - c.getMinKeyboardHeight(a())) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    
    @TargetApi(13)
    public void onGlobalLayout()
    {
      View localView1 = this.b.getChildAt(0);
      View localView2 = (View)this.b.getParent();
      Rect localRect = new Rect();
      int m;
      boolean bool;
      if (this.e)
      {
        localView2.getWindowVisibleDisplayFrame(localRect);
        m = localRect.bottom - localRect.top;
        if (!this.k)
        {
          if (m == this.j)
          {
            bool = true;
            this.k = bool;
          }
        }
        else
        {
          if (this.k) {
            break label113;
          }
          m = this.g + m;
        }
      }
      for (;;)
      {
        a(m);
        b(m);
        this.a = m;
        return;
        bool = false;
        break;
        label113:
        continue;
        localView1.getWindowVisibleDisplayFrame(localRect);
        m = localRect.bottom - localRect.top;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onKeyboardShowing(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */