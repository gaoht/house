package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.List;

public class ZiroomFlowLayout
  extends ViewGroup
{
  private int a = Integer.MAX_VALUE;
  private int b = Integer.MAX_VALUE;
  private boolean c = false;
  private List<List<View>> d = new ArrayList();
  private List<Integer> e = new ArrayList();
  
  public ZiroomFlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZiroomFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
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
    this.d.clear();
    this.e.clear();
    int j = getWidth();
    paramInt1 = 0;
    Object localObject1 = new ArrayList();
    int k = getChildCount();
    paramInt4 = 0;
    paramInt2 = 0;
    paramInt3 = 0;
    Object localObject3;
    int m;
    Object localObject2;
    while (paramInt3 < k)
    {
      i = paramInt1 + 1;
      localObject3 = getChildAt(paramInt3);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject3).getLayoutParams();
      m = ((View)localObject3).getMeasuredWidth();
      int n = ((View)localObject3).getMeasuredHeight();
      if (localMarginLayoutParams.leftMargin + m + localMarginLayoutParams.rightMargin + paramInt2 <= j)
      {
        localObject2 = localObject1;
        paramInt1 = i;
        if (i < this.b) {}
      }
      else
      {
        this.e.add(Integer.valueOf(paramInt4));
        this.d.add(localObject1);
        paramInt2 = 0;
        localObject2 = new ArrayList();
        paramInt1 = 0;
      }
      i = localMarginLayoutParams.leftMargin;
      int i1 = localMarginLayoutParams.rightMargin;
      int i2 = localMarginLayoutParams.topMargin;
      paramInt4 = Math.max(paramInt4, localMarginLayoutParams.bottomMargin + (i2 + n));
      ((List)localObject2).add(localObject3);
      paramInt3 += 1;
      paramInt2 = m + i + i1 + paramInt2;
      localObject1 = localObject2;
    }
    this.e.add(Integer.valueOf(paramInt4));
    this.d.add(localObject1);
    int i = this.d.size();
    paramInt3 = 0;
    paramInt2 = 0;
    if ((paramInt3 < i) && (paramInt3 < this.a))
    {
      localObject1 = (List)this.d.get(paramInt3);
      j = ((Integer)this.e.get(paramInt3)).intValue();
      paramInt4 = 0;
      paramInt1 = 0;
      label342:
      if (paramInt4 < ((List)localObject1).size())
      {
        localObject2 = (View)((List)localObject1).get(paramInt4);
        if (((View)localObject2).getVisibility() != 8) {}
      }
      for (;;)
      {
        paramInt4 += 1;
        break label342;
        if ((this.c) && (paramInt4 == ((List)localObject1).size() - 1) && ("line".equals(((View)localObject2).getTag())))
        {
          paramInt3 += 1;
          paramInt2 += j;
          break;
        }
        localObject3 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
        k = ((ViewGroup.MarginLayoutParams)localObject3).leftMargin + paramInt1;
        m = ((ViewGroup.MarginLayoutParams)localObject3).topMargin + paramInt2;
        ((View)localObject2).layout(k, m, ((View)localObject2).getMeasuredWidth() + k, ((View)localObject2).getMeasuredHeight() + m);
        paramInt1 += ((View)localObject2).getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject3).rightMargin + ((ViewGroup.MarginLayoutParams)localObject3).leftMargin;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i5 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i9 = getChildCount();
    int k = 0;
    int i3 = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    int j = 0;
    if ((i3 < i9) && (k < this.a))
    {
      View localView = getChildAt(i3);
      measureChild(localView, paramInt1, paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i6 = localView.getMeasuredHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
      int i2;
      if (n + i1 > i5)
      {
        i2 = Math.max(n, i1);
        n = i6;
        j = i1;
        m = i + m;
        i = k + 1;
        k = n;
      }
      for (;;)
      {
        n = m;
        i1 = i2;
        if (i3 == i9 - 1)
        {
          i1 = Math.max(i2, j);
          n = m + k;
        }
        i3 += 1;
        m = k;
        i2 = j;
        k = i;
        j = i1;
        i = n;
        n = i2;
        break;
        m = Math.max(m, i6);
        i1 += n;
        n = m;
        m = i;
        i2 = j;
        i = k;
        k = n;
        j = i1;
      }
    }
    if (i8 == 1073741824)
    {
      paramInt1 = i5;
      if (i7 != 1073741824) {
        break label313;
      }
    }
    label313:
    for (paramInt2 = i4;; paramInt2 = i)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = j;
      break;
    }
  }
  
  public void removeLastView()
  {
    this.c = true;
  }
  
  public void setMaxLine(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.a = 1;
      return;
    }
    this.a = paramInt;
  }
  
  public void setMaxLineLabelCount(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.b = 1;
      return;
    }
    this.b = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ZiroomFlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */