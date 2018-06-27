package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;

@SuppressLint({"ViewConstructor"})
class GhostViewApi14
  extends View
  implements h
{
  final View a;
  ViewGroup b;
  View c;
  int d;
  Matrix e;
  private int f;
  private int g;
  private final Matrix h = new Matrix();
  private final ViewTreeObserver.OnPreDrawListener i = new ViewTreeObserver.OnPreDrawListener()
  {
    public boolean onPreDraw()
    {
      GhostViewApi14.this.e = GhostViewApi14.this.a.getMatrix();
      ViewCompat.postInvalidateOnAnimation(GhostViewApi14.this);
      if ((GhostViewApi14.this.b != null) && (GhostViewApi14.this.c != null))
      {
        GhostViewApi14.this.b.endViewTransition(GhostViewApi14.this.c);
        ViewCompat.postInvalidateOnAnimation(GhostViewApi14.this.b);
        GhostViewApi14.this.b = null;
        GhostViewApi14.this.c = null;
      }
      return true;
    }
  };
  
  GhostViewApi14(View paramView)
  {
    super(paramView.getContext());
    this.a = paramView;
    setLayerType(2, null);
  }
  
  static GhostViewApi14 a(View paramView)
  {
    return (GhostViewApi14)paramView.getTag(R.id.ghost_view);
  }
  
  private static void a(View paramView, GhostViewApi14 paramGhostViewApi14)
  {
    paramView.setTag(R.id.ghost_view, paramGhostViewApi14);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(this.a, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    this.a.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - this.a.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - this.a.getTranslationY()));
    this.f = (arrayOfInt2[0] - arrayOfInt1[0]);
    this.g = (arrayOfInt2[1] - arrayOfInt1[1]);
    this.a.getViewTreeObserver().addOnPreDrawListener(this.i);
    this.a.setVisibility(4);
  }
  
  protected void onDetachedFromWindow()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this.i);
    this.a.setVisibility(0);
    a(this.a, null);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.h.set(this.e);
    this.h.postTranslate(this.f, this.g);
    paramCanvas.setMatrix(this.h);
    this.a.draw(paramCanvas);
  }
  
  public void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView)
  {
    this.b = paramViewGroup;
    this.c = paramView;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    View localView = this.a;
    if (paramInt == 0) {}
    for (paramInt = 4;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      return;
    }
  }
  
  static class a
    implements h.a
  {
    private static FrameLayout a(ViewGroup paramViewGroup)
    {
      while (!(paramViewGroup instanceof FrameLayout))
      {
        paramViewGroup = paramViewGroup.getParent();
        if (!(paramViewGroup instanceof ViewGroup)) {
          return null;
        }
        paramViewGroup = (ViewGroup)paramViewGroup;
      }
      return (FrameLayout)paramViewGroup;
    }
    
    public h addGhost(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
    {
      GhostViewApi14 localGhostViewApi14 = GhostViewApi14.a(paramView);
      paramMatrix = localGhostViewApi14;
      if (localGhostViewApi14 == null)
      {
        paramViewGroup = a(paramViewGroup);
        if (paramViewGroup == null) {
          return null;
        }
        paramMatrix = new GhostViewApi14(paramView);
        paramViewGroup.addView(paramMatrix);
      }
      paramMatrix.d += 1;
      return paramMatrix;
    }
    
    public void removeGhost(View paramView)
    {
      paramView = GhostViewApi14.a(paramView);
      if (paramView != null)
      {
        paramView.d -= 1;
        if (paramView.d <= 0)
        {
          Object localObject = paramView.getParent();
          if ((localObject instanceof ViewGroup))
          {
            localObject = (ViewGroup)localObject;
            ((ViewGroup)localObject).endViewTransition(paramView);
            ((ViewGroup)localObject).removeView(paramView);
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/GhostViewApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */