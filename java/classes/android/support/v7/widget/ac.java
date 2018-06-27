package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class ac
  extends RecyclerView.q
{
  protected final LinearInterpolator a = new LinearInterpolator();
  protected final DecelerateInterpolator b = new DecelerateInterpolator();
  protected PointF c;
  protected int d = 0;
  protected int e = 0;
  private final float f = a(paramContext.getResources().getDisplayMetrics());
  
  public ac(Context paramContext) {}
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - paramInt2;
    paramInt2 = i;
    if (paramInt1 * i <= 0) {
      paramInt2 = 0;
    }
    return paramInt2;
  }
  
  protected float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int a(int paramInt)
  {
    return (int)Math.ceil(b(paramInt) / 0.3356D);
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, RecyclerView.r paramr, RecyclerView.q.a parama)
  {
    if (getChildCount() == 0) {
      e();
    }
    do
    {
      return;
      this.d = a(this.d, paramInt1);
      this.e = a(this.e, paramInt2);
    } while ((this.d != 0) || (this.e != 0));
    a(parama);
  }
  
  protected void a(RecyclerView.q.a parama)
  {
    PointF localPointF = computeScrollVectorForPosition(getTargetPosition());
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      parama.jumpTo(getTargetPosition());
      e();
      return;
    }
    a(localPointF);
    this.c = localPointF;
    this.d = ((int)(localPointF.x * 10000.0F));
    this.e = ((int)(localPointF.y * 10000.0F));
    int i = b(10000);
    parama.update((int)(this.d * 1.2F), (int)(this.e * 1.2F), (int)(i * 1.2F), this.a);
  }
  
  protected void a(View paramView, RecyclerView.r paramr, RecyclerView.q.a parama)
  {
    int i = calculateDxToMakeVisible(paramView, c());
    int j = calculateDyToMakeVisible(paramView, d());
    int k = a((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      parama.update(-i, -j, k, this.b);
    }
  }
  
  protected int b(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.f);
  }
  
  protected void b()
  {
    this.e = 0;
    this.d = 0;
    this.c = null;
  }
  
  protected int c()
  {
    if ((this.c == null) || (this.c.x == 0.0F)) {
      return 0;
    }
    if (this.c.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    switch (paramInt5)
    {
    default: 
      throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    case -1: 
      paramInt1 = paramInt3 - paramInt1;
    }
    do
    {
      do
      {
        return paramInt1;
        return paramInt4 - paramInt2;
        paramInt3 -= paramInt1;
        paramInt1 = paramInt3;
      } while (paramInt3 > 0);
      paramInt2 = paramInt4 - paramInt2;
      paramInt1 = paramInt2;
    } while (paramInt2 < 0);
    return 0;
  }
  
  public int calculateDxToMakeVisible(View paramView, int paramInt)
  {
    RecyclerView.h localh = getLayoutManager();
    if ((localh == null) || (!localh.canScrollHorizontally())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return calculateDtToFit(localh.getDecoratedLeft(paramView) - localLayoutParams.leftMargin, localh.getDecoratedRight(paramView) + localLayoutParams.rightMargin, localh.getPaddingLeft(), localh.getWidth() - localh.getPaddingRight(), paramInt);
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    RecyclerView.h localh = getLayoutManager();
    if ((localh == null) || (!localh.canScrollVertically())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return calculateDtToFit(localh.getDecoratedTop(paramView) - localLayoutParams.topMargin, localh.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin, localh.getPaddingTop(), localh.getHeight() - localh.getPaddingBottom(), paramInt);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    RecyclerView.h localh = getLayoutManager();
    if ((localh instanceof RecyclerView.q.b)) {
      return ((RecyclerView.q.b)localh).computeScrollVectorForPosition(paramInt);
    }
    Log.w("LinearSmoothScroller", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + RecyclerView.q.b.class.getCanonicalName());
    return null;
  }
  
  protected int d()
  {
    if ((this.c == null) || (this.c.y == 0.0F)) {
      return 0;
    }
    if (this.c.y > 0.0F) {
      return 1;
    }
    return -1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */