package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
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
  private List<List<View>> a = new ArrayList();
  private List<Integer> b = new ArrayList();
  
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.clear();
    this.b.clear();
    int j = getWidth();
    Object localObject1 = new ArrayList();
    int k = getChildCount();
    paramInt4 = 0;
    paramInt1 = 0;
    paramInt3 = 0;
    Object localObject3;
    int m;
    int i1;
    Object localObject2;
    int i;
    int n;
    int i2;
    while (paramInt3 < k)
    {
      localObject3 = getChildAt(paramInt3);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject3).getLayoutParams();
      m = ((View)localObject3).getMeasuredWidth();
      i1 = ((View)localObject3).getMeasuredHeight();
      localObject2 = localObject1;
      i = paramInt1;
      if (localMarginLayoutParams.leftMargin + m + localMarginLayoutParams.rightMargin + paramInt1 > j)
      {
        this.b.add(Integer.valueOf(paramInt4));
        this.a.add(localObject1);
        i = 0;
        localObject2 = new ArrayList();
      }
      paramInt1 = localMarginLayoutParams.leftMargin;
      n = localMarginLayoutParams.rightMargin;
      i2 = localMarginLayoutParams.topMargin;
      paramInt4 = Math.max(paramInt4, localMarginLayoutParams.bottomMargin + (i2 + i1));
      ((List)localObject2).add(localObject3);
      paramInt3 += 1;
      paramInt1 = m + paramInt1 + n + i;
      localObject1 = localObject2;
    }
    this.b.add(Integer.valueOf(paramInt4));
    this.a.add(localObject1);
    j = this.a.size();
    paramInt4 = 0;
    paramInt3 = 0;
    while (paramInt4 < j)
    {
      localObject1 = (List)this.a.get(paramInt4);
      k = ((Integer)this.b.get(paramInt4)).intValue();
      Log.e("FlowLayout", "第" + paramInt4 + "行 ：" + ((List)localObject1).size() + " , " + localObject1);
      Log.e("FlowLayout", "第" + paramInt4 + "行， ：" + k);
      i = 0;
      paramInt1 = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (View)((List)localObject1).get(i);
        if (((View)localObject2).getVisibility() == 8) {}
        for (;;)
        {
          i += 1;
          break;
          localObject3 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
          m = ((ViewGroup.MarginLayoutParams)localObject3).leftMargin + paramInt1;
          n = ((ViewGroup.MarginLayoutParams)localObject3).topMargin + paramInt3;
          i1 = ((View)localObject2).getMeasuredWidth() + m;
          i2 = ((View)localObject2).getMeasuredHeight() + n;
          Log.e("FlowLayout", localObject2 + " , l = " + m + " , t = " + paramInt2 + " , r =" + i1 + " , b = " + i2);
          ((View)localObject2).layout(m, n, i1, i2);
          paramInt1 += ((View)localObject2).getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject3).rightMargin + ((ViewGroup.MarginLayoutParams)localObject3).leftMargin;
        }
      }
      paramInt4 += 1;
      paramInt3 += k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i5 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    Log.e("FlowLayout", i5 + "," + i4);
    int i = 0;
    int j = 0;
    int m = 0;
    int i8 = getChildCount();
    int i2 = 0;
    int n = 0;
    int k = 0;
    int i1;
    int i3;
    if (i2 < i8)
    {
      View localView = getChildAt(i2);
      measureChild(localView, paramInt1, paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      i1 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      i3 = localView.getMeasuredHeight();
      int i9 = localMarginLayoutParams.topMargin;
      i3 = localMarginLayoutParams.bottomMargin + (i3 + i9);
      if (n + i1 > i5)
      {
        k = Math.max(n, i1);
        if (j >= 2) {
          break label335;
        }
        n = j + 1;
        j = i + m;
        i = i3;
        m = i1;
      }
    }
    for (;;)
    {
      i1 = k;
      if (i2 == i8 - 1) {
        i1 = Math.max(k, m);
      }
      i3 = i2 + 1;
      i2 = m;
      k = i1;
      m = i;
      i = j;
      j = n;
      n = i2;
      i2 = i3;
      break;
      m = Math.max(m, i3);
      i3 = i;
      i = m;
      m = i1 + n;
      n = j;
      j = i3;
      continue;
      if (i7 == 1073741824)
      {
        paramInt1 = i5;
        if (i6 != 1073741824) {
          break label330;
        }
      }
      label330:
      for (paramInt2 = i4;; paramInt2 = i)
      {
        setMeasuredDimension(paramInt1, paramInt2);
        return;
        paramInt1 = k;
        break;
      }
      label335:
      i3 = i;
      i = m;
      m = i1;
      n = j;
      j = i3;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/FlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */