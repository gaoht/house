package com.ziroom.ziroomcustomer.newchat.chatcenter.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class LineWrapLayout
  extends ViewGroup
{
  private int a = 10;
  private int b = 10;
  private int c = 10;
  private int d = 10;
  private int e = 10;
  private int f = 5;
  private List<Integer> g = new ArrayList();
  private List<Integer> h = new ArrayList();
  
  public LineWrapLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LineWrapLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LineWrapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == Integer.MIN_VALUE) {}
    while (i == 1073741824) {
      return paramInt;
    }
    return 400;
  }
  
  private void a()
  {
    this.a = sp2px(18.0F);
    this.b = sp2px(18.0F);
    this.c = sp2px(8.0F);
    this.d = sp2px(8.0F);
    this.e = sp2px(10.0F);
    this.f = sp2px(10.0F);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("AutoLineFeedLayout", "--- onLayout changed :" + paramBoolean + " l :" + paramInt1 + ",t :" + paramInt2 + ",r :" + paramInt3 + ",b :" + paramInt4);
    paramInt2 = getChildCount();
    paramInt1 = getWidth();
    Log.i("AutoLineFeedLayout", "宽度 :" + paramInt1);
    paramInt1 = this.a;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      int i = ((Integer)this.g.get(paramInt1)).intValue();
      int j = ((Integer)this.h.get(paramInt1)).intValue();
      localView.layout(i, j, paramInt3 + i, paramInt4 + j);
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Log.v("AutoLineFeedLayout", "--- onMeasure()");
    int i2 = getChildCount();
    int i3 = a(paramInt1);
    Log.i("AutoLineFeedLayout", "宽度 :" + i3);
    paramInt2 = this.a;
    int i = this.c + 0;
    int k = 1;
    this.g.clear();
    this.h.clear();
    int j = 0;
    while (j < i2)
    {
      Log.v("AutoLineFeedLayout", "----");
      localView = getChildAt(j);
      localView.measure(0, 0);
      int i4 = localView.getMeasuredWidth();
      int i5 = localView.getMeasuredHeight();
      Log.v("AutoLineFeedLayout", "childWidth :" + i4 + " childHeight :" + i5);
      int i6 = paramInt2 + i4;
      int i1 = k;
      int m = i;
      int n = paramInt2;
      if (i6 > i3 - this.b)
      {
        i1 = k;
        m = i;
        n = paramInt2;
        if (paramInt2 > this.a)
        {
          n = this.a;
          m = i + (this.f + i5);
          i1 = k + 1;
        }
      }
      Log.d("AutoLineFeedLayout", "measure child :" + n + ", " + m + ", " + i6 + ", " + (i5 + m));
      this.g.add(Integer.valueOf(n));
      this.h.add(Integer.valueOf(m));
      paramInt2 = this.e;
      j += 1;
      paramInt2 += n + i4;
      k = i1;
      i = m;
    }
    View localView = getChildAt(i2 - 1);
    if (localView != null) {}
    for (paramInt2 = localView.getMeasuredHeight();; paramInt2 = 0)
    {
      setMeasuredDimension(a(paramInt1), paramInt2 + i + this.d);
      return;
    }
  }
  
  public int sp2px(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/views/LineWrapLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */