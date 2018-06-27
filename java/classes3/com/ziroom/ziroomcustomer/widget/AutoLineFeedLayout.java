package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.ziroom.ziroomcustomer.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class AutoLineFeedLayout
  extends ViewGroup
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 10;
  private int f = 10;
  private List<Integer> g;
  private List<Integer> h;
  
  public AutoLineFeedLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoLineFeedLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public AutoLineFeedLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
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
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.AutoLineFeedLayout);
    int j = paramAttributeSet.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramAttributeSet.getIndex(i);
      switch (k)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        this.e = ((int)paramAttributeSet.getDimension(k, 0.0F));
        continue;
        this.f = ((int)paramAttributeSet.getDimension(k, 0.0F));
        continue;
        this.d = ((int)paramAttributeSet.getDimension(k, 0.0F));
        continue;
        this.a = ((int)paramAttributeSet.getDimension(k, 0.0F));
        continue;
        this.b = ((int)paramAttributeSet.getDimension(k, 0.0F));
        continue;
        this.c = ((int)paramAttributeSet.getDimension(k, 0.0F));
      }
    }
    this.g = new ArrayList();
    this.h = new ArrayList();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
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
    int i1 = getChildCount();
    int i2 = a(paramInt1);
    paramInt2 = this.a;
    int j = this.c;
    this.g.clear();
    this.h.clear();
    int i = 0;
    int n;
    for (int k = 0; i < i1; k = n)
    {
      View localView = getChildAt(i);
      localView.measure(0, 0);
      int i3 = localView.getMeasuredWidth();
      n = localView.getMeasuredHeight();
      k = j;
      int m = paramInt2;
      if (paramInt2 + i3 > i2 - this.b - this.e)
      {
        k = j;
        m = paramInt2;
        if (paramInt2 > this.a)
        {
          m = this.a;
          k = j + (this.f + n);
        }
      }
      this.g.add(Integer.valueOf(m));
      this.h.add(Integer.valueOf(k));
      paramInt2 = this.e;
      i += 1;
      paramInt2 += m + i3;
      j = k;
    }
    setMeasuredDimension(a(paramInt1), j + k + this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/AutoLineFeedLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */