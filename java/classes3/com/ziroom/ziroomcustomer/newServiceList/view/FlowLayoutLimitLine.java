package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.List;

public class FlowLayoutLimitLine
  extends ViewGroup
{
  private int a = -1;
  private int b = -1;
  private List<List<View>> c = new ArrayList();
  private List<Integer> d = new ArrayList();
  
  public FlowLayoutLimitLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.clear();
    this.d.clear();
    int i = getWidth();
    Object localObject1 = new ArrayList();
    int j = getChildCount();
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    Object localObject2 = localObject1;
    Object localObject3;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int k;
    int n;
    if (paramInt2 < j)
    {
      localObject3 = getChildAt(paramInt2);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject3).getLayoutParams();
      k = ((View)localObject3).getMeasuredWidth();
      n = ((View)localObject3).getMeasuredHeight();
      localObject2 = localObject1;
      paramInt4 = paramInt1;
      if (localMarginLayoutParams.leftMargin + k + localMarginLayoutParams.rightMargin + paramInt1 > i)
      {
        this.d.add(Integer.valueOf(paramInt3));
        this.c.add(localObject1);
        paramInt4 = 0;
        localObject2 = new ArrayList();
      }
      if ((this.a == -1) || (this.c.size() <= this.a)) {}
    }
    else
    {
      this.d.add(Integer.valueOf(paramInt3));
      this.c.add(localObject2);
      i = this.c.size();
      paramInt3 = 0;
      paramInt2 = 0;
    }
    for (;;)
    {
      if (paramInt3 >= i) {
        return;
      }
      localObject1 = (List)this.c.get(paramInt3);
      j = ((Integer)this.d.get(paramInt3)).intValue();
      paramInt4 = 0;
      paramInt1 = 0;
      label268:
      if (paramInt4 < ((List)localObject1).size())
      {
        localObject2 = (View)((List)localObject1).get(paramInt4);
        if (((View)localObject2).getVisibility() == 8) {}
        for (;;)
        {
          paramInt4 += 1;
          break label268;
          paramInt1 = localMarginLayoutParams.leftMargin;
          int m = localMarginLayoutParams.rightMargin;
          int i1 = localMarginLayoutParams.topMargin;
          paramInt3 = Math.max(paramInt3, localMarginLayoutParams.bottomMargin + (i1 + n));
          ((List)localObject2).add(localObject3);
          paramInt2 += 1;
          paramInt1 = k + paramInt1 + m + paramInt4;
          localObject1 = localObject2;
          break;
          localObject3 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
          k = ((ViewGroup.MarginLayoutParams)localObject3).leftMargin + paramInt1;
          m = ((ViewGroup.MarginLayoutParams)localObject3).topMargin + paramInt2;
          ((View)localObject2).layout(k, m, ((View)localObject2).getMeasuredWidth() + k, ((View)localObject2).getMeasuredHeight() + m);
          paramInt1 += ((View)localObject2).getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject3).rightMargin + ((ViewGroup.MarginLayoutParams)localObject3).leftMargin;
        }
      }
      paramInt3 += 1;
      paramInt2 += j;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i10 = View.MeasureSpec.getMode(paramInt1);
    int i9 = View.MeasureSpec.getMode(paramInt2);
    if (this.b > 0) {}
    for (int i2 = i6 / this.b;; i2 = 0)
    {
      int i = 0;
      int m = 0;
      int i11 = getChildCount();
      int i3 = 0;
      int k = 0;
      int j = 0;
      int n = 0;
      int i7;
      int i1;
      int i4;
      if (i3 < i11)
      {
        View localView = getChildAt(i3);
        if (this.b > 0) {
          localView.setLayoutParams(new ViewGroup.MarginLayoutParams(i2, -2));
        }
        measureChild(localView, paramInt1, paramInt2);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        i7 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
        i1 = localView.getMeasuredHeight();
        i4 = localMarginLayoutParams.topMargin;
        i1 = localMarginLayoutParams.bottomMargin + (i1 + i4);
        if (n + i7 > i6)
        {
          j = Math.max(n, i7);
          if (this.a == -1)
          {
            int i8 = i + k;
            i4 = m;
            n = i7;
            i = i1;
            k = j;
            j = i8;
          }
          for (;;)
          {
            m = j;
            i1 = k;
            if (i3 == i11 - 1)
            {
              k = Math.max(k, n);
              if (this.a != -1) {
                break label399;
              }
              m = j + i;
              i1 = k;
            }
            label267:
            i3 += 1;
            k = i;
            j = i1;
            i = m;
            m = i4;
            break;
            if (m >= this.a) {
              break label327;
            }
            i4 = m + 1;
            i += k;
            k = j;
            j = i;
            i = i1;
            n = i7;
          }
        }
      }
      label327:
      for (paramInt1 = Math.max(j, i7);; paramInt1 = j)
      {
        if (i10 == 1073741824)
        {
          paramInt1 = i6;
          label345:
          if (i9 != 1073741824) {
            break label432;
          }
        }
        label399:
        label432:
        for (paramInt2 = i5;; paramInt2 = i)
        {
          setMeasuredDimension(paramInt1, paramInt2);
          return;
          i4 = i7 + n;
          n = Math.max(k, i1);
          k = j;
          j = i;
          i = n;
          n = i4;
          i4 = m;
          break;
          m = j;
          i1 = k;
          if (i4 >= this.a) {
            break label267;
          }
          m = j + i;
          i1 = k;
          break label267;
          break label345;
        }
      }
    }
  }
  
  public void setLimitItem(int paramInt)
  {
    if (paramInt > 0) {
      this.b = paramInt;
    }
  }
  
  public void setLimitLine(int paramInt)
  {
    if (paramInt > 0) {
      this.a = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/FlowLayoutLimitLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */