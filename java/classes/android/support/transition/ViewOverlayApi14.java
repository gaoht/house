package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14
  implements ar
{
  protected OverlayViewGroup a = new OverlayViewGroup(paramContext, paramViewGroup, paramView, this);
  
  ViewOverlayApi14(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  static ViewGroup a(View paramView)
  {
    while (paramView != null)
    {
      if ((paramView.getId() == 16908290) && ((paramView instanceof ViewGroup))) {
        return (ViewGroup)paramView;
      }
      if ((paramView.getParent() instanceof ViewGroup)) {
        paramView = (ViewGroup)paramView.getParent();
      }
    }
    return null;
  }
  
  static ViewOverlayApi14 b(View paramView)
  {
    ViewGroup localViewGroup = a(paramView);
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView instanceof OverlayViewGroup)) {
          return ((OverlayViewGroup)localView).e;
        }
        i += 1;
      }
      return new aj(localViewGroup.getContext(), localViewGroup, paramView);
    }
    return null;
  }
  
  public void add(Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public void remove(Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
  
  static class OverlayViewGroup
    extends ViewGroup
  {
    static Method a;
    ViewGroup b;
    View c;
    ArrayList<Drawable> d = null;
    ViewOverlayApi14 e;
    
    static
    {
      try
      {
        a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
    
    OverlayViewGroup(Context paramContext, ViewGroup paramViewGroup, View paramView, ViewOverlayApi14 paramViewOverlayApi14)
    {
      super();
      this.b = paramViewGroup;
      this.c = paramView;
      setRight(paramViewGroup.getWidth());
      setBottom(paramViewGroup.getHeight());
      paramViewGroup.addView(this);
      this.e = paramViewOverlayApi14;
    }
    
    private void a(int[] paramArrayOfInt)
    {
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.b.getLocationOnScreen(arrayOfInt1);
      this.c.getLocationOnScreen(arrayOfInt2);
      arrayOfInt2[0] -= arrayOfInt1[0];
      arrayOfInt2[1] -= arrayOfInt1[1];
    }
    
    boolean a()
    {
      return (getChildCount() == 0) && ((this.d == null) || (this.d.size() == 0));
    }
    
    public void add(Drawable paramDrawable)
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      if (!this.d.contains(paramDrawable))
      {
        this.d.add(paramDrawable);
        invalidate(paramDrawable.getBounds());
        paramDrawable.setCallback(this);
      }
    }
    
    public void add(View paramView)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
        if ((localViewGroup != this.b) && (localViewGroup.getParent() != null) && (ViewCompat.isAttachedToWindow(localViewGroup)))
        {
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          localViewGroup.getLocationOnScreen(arrayOfInt1);
          this.b.getLocationOnScreen(arrayOfInt2);
          ViewCompat.offsetLeftAndRight(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
          ViewCompat.offsetTopAndBottom(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
        }
        localViewGroup.removeView(paramView);
        if (paramView.getParent() != null) {
          localViewGroup.removeView(paramView);
        }
      }
      super.addView(paramView, getChildCount() - 1);
    }
    
    public void clear()
    {
      removeAllViews();
      if (this.d != null) {
        this.d.clear();
      }
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.b.getLocationOnScreen(arrayOfInt1);
      this.c.getLocationOnScreen(arrayOfInt2);
      paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
      paramCanvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
      super.dispatchDraw(paramCanvas);
      if (this.d == null) {}
      for (int i = 0;; i = this.d.size())
      {
        int j = 0;
        while (j < i)
        {
          ((Drawable)this.d.get(j)).draw(paramCanvas);
          j += 1;
        }
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public void invalidateChildFast(View paramView, Rect paramRect)
    {
      if (this.b != null)
      {
        int i = paramView.getLeft();
        int j = paramView.getTop();
        paramView = new int[2];
        a(paramView);
        paramRect.offset(i + paramView[0], j + paramView[1]);
        this.b.invalidate(paramRect);
      }
    }
    
    public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
    {
      if (this.b != null)
      {
        paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
        if ((this.b instanceof ViewGroup))
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = 0;
          int[] arrayOfInt = new int[2];
          a(arrayOfInt);
          paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
          return super.invalidateChildInParent(paramArrayOfInt, paramRect);
        }
        invalidate(paramRect);
      }
      return null;
    }
    
    public void invalidateDrawable(Drawable paramDrawable)
    {
      invalidate(paramDrawable.getBounds());
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void remove(Drawable paramDrawable)
    {
      if (this.d != null)
      {
        this.d.remove(paramDrawable);
        invalidate(paramDrawable.getBounds());
        paramDrawable.setCallback(null);
      }
    }
    
    public void remove(View paramView)
    {
      super.removeView(paramView);
      if (a()) {
        this.b.removeView(this);
      }
    }
    
    protected boolean verifyDrawable(Drawable paramDrawable)
    {
      return (super.verifyDrawable(paramDrawable)) || ((this.d != null) && (this.d.contains(paramDrawable)));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ViewOverlayApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */