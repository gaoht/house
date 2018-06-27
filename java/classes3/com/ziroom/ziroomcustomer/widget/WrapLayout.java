package com.ziroom.ziroomcustomer.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.ziroom.ziroomcustomer.R.styleable;
import java.util.ArrayList;

public class WrapLayout
  extends ViewGroup
{
  private static final int[] a = { 16843028, 16843029 };
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private ArrayList<Integer> e = new ArrayList();
  private ArrayList<Integer> f = new ArrayList();
  private int g = 0;
  
  public WrapLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public WrapLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public WrapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public WrapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a, paramInt, 0);
    int k = localTypedArray.getIndexCount();
    paramInt = 0;
    int i = 0;
    int j = 0;
    if (paramInt < k)
    {
      int m = localTypedArray.getIndex(paramInt);
      switch (m)
      {
      }
      for (;;)
      {
        paramInt += 1;
        break;
        j = localTypedArray.getDimensionPixelSize(m, j);
        continue;
        i = localTypedArray.getDimensionPixelSize(m, i);
      }
    }
    localTypedArray.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WrapLayout);
    paramInt = paramContext.getDimensionPixelSize(0, j);
    i = paramContext.getDimensionPixelSize(1, i);
    j = paramContext.getInt(2, 0);
    paramContext.recycle();
    this.c = paramInt;
    this.b = i;
    this.g = j;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getGravity()
  {
    return this.g;
  }
  
  public int getHorizontalSpacing()
  {
    return this.c;
  }
  
  public int getNumColumns(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.e.size())) {
      return -1;
    }
    return ((Integer)this.e.get(paramInt)).intValue();
  }
  
  public int getNumRows()
  {
    return this.d;
  }
  
  public int getVerticalSpacing()
  {
    return this.b;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = a.a(this);
    paramInt2 = getPaddingTop();
    int m = this.g;
    paramInt3 = this.b;
    paramInt1 = 0;
    paramInt4 = paramInt2 - paramInt3;
    paramInt3 = 0;
    int n;
    int i1;
    int j;
    int i;
    if (paramInt3 < this.d)
    {
      n = ((Integer)this.e.get(paramInt3)).intValue();
      i1 = ((Integer)this.f.get(paramInt3)).intValue();
      j = k - this.c;
      i = 0;
    }
    for (;;)
    {
      if (i < n)
      {
        View localView = getChildAt(paramInt1);
        paramInt2 = paramInt1 + 1;
        if (localView != null)
        {
          if (localView.getVisibility() == 8)
          {
            paramInt1 = paramInt2;
            continue;
          }
          int i2 = localView.getMeasuredWidth();
          int i3 = localView.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localView.getLayoutParams()).getGravity();
          j += this.c;
          switch (paramInt1)
          {
          default: 
            switch (m)
            {
            default: 
              paramInt1 = 0;
            }
            break;
          }
          for (;;)
          {
            paramInt1 += this.b + paramInt4;
            localView.layout(j, paramInt1, j + i2, i3 + paramInt1);
            i += 1;
            j = i2 + j;
            paramInt1 = paramInt2;
            break;
            paramInt1 = Math.round((i1 - i3) * 0.5F);
            continue;
            paramInt1 = i1 - i3;
            continue;
            paramInt1 = Math.round((i1 - i3) * 0.5F);
            continue;
            paramInt1 = i1 - i3;
            continue;
            paramInt1 = 0;
          }
        }
      }
      else
      {
        paramInt4 += this.b + i1;
        paramInt3 += 1;
        break;
        return;
      }
      paramInt1 = paramInt2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = a.a(this);
    int i7 = a.b(this);
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    int i8 = getSuggestedMinimumWidth();
    int i5 = getSuggestedMinimumHeight();
    int n = View.MeasureSpec.getMode(paramInt1);
    int i9 = View.MeasureSpec.getSize(paramInt1);
    int k = 0;
    int j = 0;
    int i = 0;
    int m = 0;
    this.d = 0;
    this.e.clear();
    this.f.clear();
    View localView;
    int i1;
    if (getChildCount() > 0)
    {
      if (n != 0) {
        break label292;
      }
      n = 0;
      i = 0;
      if (i < getChildCount())
      {
        localView = getChildAt(i);
        if (localView.getVisibility() == 8) {}
        for (;;)
        {
          i += 1;
          break;
          if (this.d == 0) {
            this.d = 1;
          }
          measureChild(localView, paramInt1, paramInt2);
          i1 = localView.getMeasuredWidth();
          k = localView.getMeasuredHeight();
          if (n == 0) {
            j = -this.c;
          }
          j += i1 + this.c;
          m = Math.max(k, m);
          n += 1;
        }
      }
      i = m;
      k = j;
      if (n != 0)
      {
        this.e.add(Integer.valueOf(n));
        this.f.add(Integer.valueOf(m));
        k = j;
        i = m;
      }
    }
    for (;;)
    {
      j = Math.max(i6 + k + i7, i8);
      i = Math.max(i3 + i + i4, i5);
      setMeasuredDimension(resolveSize(j, paramInt1), resolveSize(i, paramInt2));
      return;
      label292:
      j = 0;
      i1 = 0;
      k = 0;
      m = 0;
      i = 0;
      n = 0;
      if (i1 < getChildCount())
      {
        localView = getChildAt(i1);
        if (localView.getVisibility() == 8) {}
        int i11;
        int i10;
        for (;;)
        {
          i1 += 1;
          break;
          if (this.d == 0) {
            this.d = 1;
          }
          measureChild(localView, paramInt1, paramInt2);
          i11 = localView.getMeasuredWidth();
          i10 = localView.getMeasuredHeight();
          if (n == 0) {
            m = -this.c;
          }
          if (m + i11 + this.c > i9 - i6 - i7) {
            break label442;
          }
          m += i11 + this.c;
          j = Math.max(i10, j);
          n += 1;
        }
        label442:
        int i2 = Math.max(m, i);
        if (this.d == 1) {}
        for (i = j;; i = this.b + j)
        {
          k += i;
          this.e.add(Integer.valueOf(n));
          this.f.add(Integer.valueOf(j));
          this.d += 1;
          m = 0 + i11;
          j = Math.max(i10, 0);
          n = 1;
          i = i2;
          break;
        }
      }
      if (n != 0)
      {
        if (this.d == 1) {}
        for (m = j;; m = this.b + j)
        {
          m = k + m;
          this.e.add(Integer.valueOf(n));
          this.f.add(Integer.valueOf(j));
          k = i;
          i = m;
          break;
        }
      }
      j = i;
      i = k;
      k = j;
    }
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      return;
    }
    this.g = paramInt;
    requestLayout();
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    this.c = paramInt;
    requestLayout();
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    this.b = paramInt;
    requestLayout();
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    private int a = -1;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WrapLayout_Layout);
      int i = paramContext.getInt(0, -1);
      paramContext.recycle();
      this.a = i;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
    }
    
    public int getGravity()
    {
      return this.a;
    }
    
    public void setGravity(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/WrapLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */