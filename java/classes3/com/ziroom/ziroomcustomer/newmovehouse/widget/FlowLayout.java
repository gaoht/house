package com.ziroom.ziroomcustomer.newmovehouse.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout
  extends ViewGroup
{
  public int a;
  private List<List<View>> b = new ArrayList();
  private List<Integer> c = new ArrayList();
  
  public FlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
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
  
  public int getAllNums()
  {
    return this.a;
  }
  
  public List<Integer> getmLineHeight()
  {
    return this.c;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.clear();
    this.c.clear();
    int i = getWidth();
    Object localObject1 = new ArrayList();
    int j = getChildCount();
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    Object localObject3;
    int k;
    Object localObject2;
    int m;
    while (paramInt2 < j)
    {
      localObject3 = getChildAt(paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject3).getLayoutParams();
      k = ((View)localObject3).getMeasuredWidth();
      int n = ((View)localObject3).getMeasuredHeight();
      localObject2 = localObject1;
      paramInt4 = paramInt1;
      if (localMarginLayoutParams.leftMargin + k + localMarginLayoutParams.rightMargin + paramInt1 > i)
      {
        this.c.add(Integer.valueOf(paramInt3));
        this.b.add(localObject1);
        paramInt4 = 0;
        localObject2 = new ArrayList();
      }
      paramInt1 = localMarginLayoutParams.leftMargin;
      m = localMarginLayoutParams.rightMargin;
      int i1 = localMarginLayoutParams.topMargin;
      paramInt3 = Math.max(paramInt3, localMarginLayoutParams.bottomMargin + (i1 + n));
      ((List)localObject2).add(localObject3);
      paramInt2 += 1;
      paramInt1 = k + paramInt1 + m + paramInt4;
      localObject1 = localObject2;
    }
    this.c.add(Integer.valueOf(paramInt3));
    this.b.add(localObject1);
    i = this.b.size();
    this.a = i;
    paramInt3 = 0;
    paramInt2 = 0;
    while (paramInt3 < i)
    {
      localObject1 = (List)this.b.get(paramInt3);
      j = ((Integer)this.c.get(paramInt3)).intValue();
      paramInt4 = 0;
      paramInt1 = 0;
      if (paramInt4 < ((List)localObject1).size())
      {
        localObject2 = (View)((List)localObject1).get(paramInt4);
        if (((View)localObject2).getVisibility() == 8) {}
        for (;;)
        {
          paramInt4 += 1;
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
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    int i = 0;
    int i8 = getChildCount();
    int k = 0;
    int m = 0;
    int j = 0;
    int i2 = 0;
    if (i2 < i8)
    {
      View localView = getChildAt(i2);
      measureChild(localView, paramInt1, paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i1 = localView.getMeasuredHeight();
      int i5 = localMarginLayoutParams.topMargin;
      i5 = localMarginLayoutParams.bottomMargin + (i1 + i5);
      if (m + n > i4)
      {
        i1 = Math.max(m, n);
        k = i + k;
        j = i5;
      }
      for (i = n;; i = n)
      {
        m = k;
        n = i1;
        if (i2 == i8 - 1)
        {
          n = Math.max(i1, i);
          m = k + j;
        }
        i2 += 1;
        k = j;
        i1 = i;
        j = n;
        i = m;
        m = i1;
        break;
        n += m;
        m = Math.max(k, i5);
        k = i;
        i1 = j;
        j = m;
      }
    }
    if (i7 == 1073741824)
    {
      paramInt1 = i4;
      if (i6 != 1073741824) {
        break label286;
      }
    }
    label286:
    for (paramInt2 = i3;; paramInt2 = i)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = j;
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/FlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */