package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Scroller;
import java.util.List;

public class VerticalDrawerLayout
  extends ViewGroup
{
  private static final int[] o = { 16842931 };
  public final String a = "VerticalDrawerLayout";
  private ViewDragHelper b;
  private Scroller c;
  private View d;
  private View e;
  private int f = 64;
  private int g = 400;
  private boolean h;
  private int i = 0;
  private a j;
  private boolean k;
  private float l;
  private List<Integer> m;
  private int n;
  
  public VerticalDrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VerticalDrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalDrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt, View paramView)
  {
    int i1 = 2;
    int i2 = this.b.getViewDragState();
    if (i2 == 1)
    {
      i1 = 1;
      if ((paramView != null) && (paramInt == 0))
      {
        LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
        if (this.l != 0.0F) {
          break label104;
        }
        if (this.j != null) {
          this.j.onDrawerClosed(paramView);
        }
      }
    }
    for (;;)
    {
      if (i1 != this.i)
      {
        this.i = i1;
        if (this.j != null) {
          this.j.onDrawerStateChanged(i1);
        }
      }
      return;
      if (i2 == 2) {
        break;
      }
      i1 = 0;
      break;
      label104:
      if ((this.l == 1.0F) && (this.j != null)) {
        this.j.onDrawerOpened(paramView);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = ViewDragHelper.create(this, 1.0F, new b(null));
    this.c = new Scroller(paramContext);
  }
  
  private boolean a(View paramView)
  {
    return paramView == this.d;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.b.continueSettling(true)) {
      invalidate();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public float getDrawerOffset()
  {
    return this.l;
  }
  
  public void hide()
  {
    this.b.smoothSlideViewTo(this.e, this.e.getLeft(), getMeasuredHeight());
    invalidate();
  }
  
  public void lockDrawer(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() != 2) {
      throw new IllegalArgumentException("There must be 2 child in VerticalDrawerLayout");
    }
    this.d = getChildAt(0);
    this.e = getChildAt(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!this.h) && (this.b.shouldInterceptTouchEvent(paramMotionEvent));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.k = true;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (a(localView)) {
        localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramInt3 = getMeasuredHeight() - this.g - this.f;
        localView.layout(localLayoutParams.leftMargin, (int)(getMeasuredHeight() - this.g - paramInt3 * this.l), localLayoutParams.leftMargin + this.e.getMeasuredWidth(), (int)(getMeasuredHeight() - this.g - paramInt3 * this.l) + this.e.getMeasuredHeight());
      }
    }
    this.k = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(i2, i3);
    int i4 = getChildCount();
    int i1 = 0;
    if (i1 < i4)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 8) {}
      for (;;)
      {
        i1 += 1;
        break;
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (a(localView))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i2 - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        }
        else
        {
          int i5 = getChildMeasureSpec(paramInt1, localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width);
          int i6 = localLayoutParams.topMargin;
          localView.measure(i5, getChildMeasureSpec(paramInt2, localLayoutParams.bottomMargin + i6, i3 - this.f));
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.b.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void requestLayout()
  {
    if (!this.k) {
      super.requestLayout();
    }
  }
  
  public void setEdge(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    requestLayout();
  }
  
  public void setListener(a parama)
  {
    this.j = parama;
  }
  
  public void setSectionList(List<Integer> paramList)
  {
    this.m = paramList;
  }
  
  public void slideTo(int paramInt)
  {
    paramInt = getMeasuredHeight() - paramInt;
    if ((paramInt >= this.f) && (paramInt <= getMeasuredHeight() - this.g))
    {
      this.b.smoothSlideViewTo(this.e, this.e.getLeft(), paramInt);
      invalidate();
    }
  }
  
  public void slideToBottom()
  {
    this.b.smoothSlideViewTo(this.e, this.e.getLeft(), getMeasuredHeight() - this.g);
    invalidate();
  }
  
  public void slideToSection(int paramInt)
  {
    if ((this.m != null) && (this.m.size() > 0) && (paramInt >= 0) && (paramInt < this.m.size()))
    {
      this.n = paramInt;
      slideTo(((Integer)this.m.get(paramInt)).intValue());
    }
  }
  
  public void slideToTop()
  {
    this.b.smoothSlideViewTo(this.e, this.e.getLeft(), this.f);
    invalidate();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int a = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.a = paramInt3;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, VerticalDrawerLayout.a());
      this.a = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDrawerClosed(View paramView);
    
    public abstract void onDrawerOpened(View paramView);
    
    public abstract void onDrawerSlide(View paramView, float paramFloat);
    
    public abstract void onDrawerStateChanged(int paramInt);
  }
  
  private class b
    extends ViewDragHelper.Callback
  {
    private b() {}
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      if (paramInt1 > VerticalDrawerLayout.this.getMeasuredHeight() - VerticalDrawerLayout.b(VerticalDrawerLayout.this)) {
        paramInt2 = VerticalDrawerLayout.this.getMeasuredHeight() - VerticalDrawerLayout.b(VerticalDrawerLayout.this);
      }
      do
      {
        return paramInt2;
        paramInt2 = paramInt1;
      } while (paramInt1 >= VerticalDrawerLayout.c(VerticalDrawerLayout.this));
      return VerticalDrawerLayout.c(VerticalDrawerLayout.this);
    }
    
    public int getViewVerticalDragRange(View paramView)
    {
      return VerticalDrawerLayout.this.getMeasuredHeight() - VerticalDrawerLayout.b(VerticalDrawerLayout.this) - VerticalDrawerLayout.c(VerticalDrawerLayout.this);
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      VerticalDrawerLayout.a(VerticalDrawerLayout.this, paramInt, VerticalDrawerLayout.e(VerticalDrawerLayout.this).getCapturedView());
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onViewPositionChanged(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if (VerticalDrawerLayout.this.getMeasuredHeight() > 0)
      {
        VerticalDrawerLayout.LayoutParams localLayoutParams = (VerticalDrawerLayout.LayoutParams)paramView.getLayoutParams();
        VerticalDrawerLayout.a(VerticalDrawerLayout.this, (VerticalDrawerLayout.this.getMeasuredHeight() - VerticalDrawerLayout.b(VerticalDrawerLayout.this) - paramInt2) / (VerticalDrawerLayout.this.getMeasuredHeight() - VerticalDrawerLayout.b(VerticalDrawerLayout.this) - VerticalDrawerLayout.c(VerticalDrawerLayout.this)));
        if (VerticalDrawerLayout.g(VerticalDrawerLayout.this) != null) {
          VerticalDrawerLayout.g(VerticalDrawerLayout.this).onDrawerSlide(paramView, VerticalDrawerLayout.h(VerticalDrawerLayout.this));
        }
      }
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      super.onViewReleased(paramView, paramFloat1, paramFloat2);
      if (paramFloat2 > 0.0F) {
        if ((VerticalDrawerLayout.d(VerticalDrawerLayout.this) == null) || (VerticalDrawerLayout.d(VerticalDrawerLayout.this).size() == 0)) {
          VerticalDrawerLayout.e(VerticalDrawerLayout.this).smoothSlideViewTo(paramView, paramView.getLeft(), VerticalDrawerLayout.this.getMeasuredHeight() - VerticalDrawerLayout.b(VerticalDrawerLayout.this));
        }
      }
      for (;;)
      {
        VerticalDrawerLayout.this.invalidate();
        return;
        int i = VerticalDrawerLayout.f(VerticalDrawerLayout.this) - 1;
        if (i >= VerticalDrawerLayout.d(VerticalDrawerLayout.this).size())
        {
          VerticalDrawerLayout.a(VerticalDrawerLayout.this, VerticalDrawerLayout.d(VerticalDrawerLayout.this).size());
          VerticalDrawerLayout.e(VerticalDrawerLayout.this).smoothSlideViewTo(paramView, paramView.getLeft(), VerticalDrawerLayout.c(VerticalDrawerLayout.this));
        }
        else if (i < 0)
        {
          VerticalDrawerLayout.a(VerticalDrawerLayout.this, -1);
          VerticalDrawerLayout.e(VerticalDrawerLayout.this).smoothSlideViewTo(paramView, paramView.getLeft(), VerticalDrawerLayout.this.getMeasuredHeight() - VerticalDrawerLayout.b(VerticalDrawerLayout.this));
        }
        else
        {
          VerticalDrawerLayout.a(VerticalDrawerLayout.this, i);
          VerticalDrawerLayout.this.slideTo(((Integer)VerticalDrawerLayout.d(VerticalDrawerLayout.this).get(i)).intValue());
          continue;
          if ((VerticalDrawerLayout.d(VerticalDrawerLayout.this) == null) || (VerticalDrawerLayout.d(VerticalDrawerLayout.this).size() == 0))
          {
            VerticalDrawerLayout.e(VerticalDrawerLayout.this).smoothSlideViewTo(paramView, paramView.getLeft(), VerticalDrawerLayout.c(VerticalDrawerLayout.this));
          }
          else
          {
            i = VerticalDrawerLayout.f(VerticalDrawerLayout.this) + 1;
            if (i >= VerticalDrawerLayout.d(VerticalDrawerLayout.this).size())
            {
              VerticalDrawerLayout.a(VerticalDrawerLayout.this, VerticalDrawerLayout.d(VerticalDrawerLayout.this).size());
              VerticalDrawerLayout.e(VerticalDrawerLayout.this).smoothSlideViewTo(paramView, paramView.getLeft(), VerticalDrawerLayout.c(VerticalDrawerLayout.this));
            }
            else if (i < 0)
            {
              VerticalDrawerLayout.a(VerticalDrawerLayout.this, -1);
              VerticalDrawerLayout.e(VerticalDrawerLayout.this).smoothSlideViewTo(paramView, paramView.getLeft(), VerticalDrawerLayout.this.getMeasuredHeight() - VerticalDrawerLayout.b(VerticalDrawerLayout.this));
            }
            else
            {
              VerticalDrawerLayout.a(VerticalDrawerLayout.this, i);
              VerticalDrawerLayout.this.slideTo(((Integer)VerticalDrawerLayout.d(VerticalDrawerLayout.this).get(i)).intValue());
            }
          }
        }
      }
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      return (!VerticalDrawerLayout.a(VerticalDrawerLayout.this)) && (!VerticalDrawerLayout.a(VerticalDrawerLayout.this, paramView));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/VerticalDrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */