package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FourItemLayout
  extends LinearLayout
{
  private int a = 5;
  private int b;
  private int c;
  private float d;
  
  public FourItemLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FourItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext.getResources().getDisplayMetrics().density;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i = getChildCount();
    if (i == 0) {}
    do
    {
      return;
      paramInt4 = (int)(4.0F * this.d);
      int j = (int)(12.0F * this.d);
      paramInt2 = (this.b - paramInt4 * 6) / 4;
      paramInt3 = getChildAt(0).getMeasuredHeight();
      if (i > 0)
      {
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          int k = paramInt1 / 4;
          int m = (k + 1) * paramInt3 + k * j;
          Object localObject;
          if (paramInt1 % 4 == 0)
          {
            localObject = getChildAt(paramInt1);
            if (k > 0) {}
            ((View)localObject).layout(0, (paramInt3 + j) * k, paramInt2, m);
          }
          for (;;)
          {
            k = (int)(1.0F * this.d);
            k = (int)(8.0F * this.d);
            getChildAt(paramInt1).setPadding(0, k, 0, k);
            if ((getChildAt(paramInt1) instanceof TextView))
            {
              localObject = (TextView)getChildAt(paramInt1);
              ((TextView)localObject).setIncludeFontPadding(false);
              ((TextView)localObject).setSingleLine();
              ((TextView)localObject).setGravity(17);
              if (((TextView)localObject).getText().toString().length() > this.a) {
                ((TextView)localObject).setText(((TextView)localObject).getText().toString().substring(0, this.a) + "..");
              }
            }
            paramInt1 += 1;
            break;
            if (paramInt1 % 4 == 1)
            {
              localObject = getChildAt(paramInt1);
              if (k > 0) {}
              ((View)localObject).layout(paramInt4 * 2 + paramInt2, (paramInt3 + j) * k, paramInt2 * 2 + paramInt4 * 2, m);
            }
            else if (paramInt1 % 4 == 2)
            {
              localObject = getChildAt(paramInt1);
              if (k > 0) {}
              ((View)localObject).layout((paramInt4 * 2 + paramInt2) * 2, (paramInt3 + j) * k, (paramInt4 * 2 + paramInt2) * 2 + paramInt2, m);
            }
            else if (paramInt1 % 4 == 3)
            {
              localObject = getChildAt(paramInt1);
              if (k > 0) {}
              ((View)localObject).layout((paramInt4 * 2 + paramInt2) * 3, (paramInt3 + j) * k, (paramInt4 * 2 + paramInt2) * 3 + paramInt2, m);
            }
          }
        }
      }
      if (i == 3)
      {
        paramInt1 = (int)(paramInt2 + 6.0F * this.d) / 2;
        getChildAt(0).layout(paramInt1, 0, paramInt2 + paramInt1, paramInt3);
        getChildAt(1).layout(paramInt1 + paramInt2 + paramInt4 * 2, 0, paramInt2 * 2 + paramInt4 * 2 + paramInt1, paramInt3);
        getChildAt(2).layout((paramInt4 * 2 + paramInt2) * 2 + paramInt1, 0, paramInt1 + ((paramInt4 * 2 + paramInt2) * 2 + paramInt2), paramInt3);
        return;
      }
      if (i == 2)
      {
        paramInt1 = (int)(paramInt2 + 6.0F * this.d);
        getChildAt(0).layout(paramInt1, 0, paramInt2 + paramInt1, paramInt3);
        getChildAt(1).layout(paramInt1 + paramInt2 + paramInt4 * 2, 0, paramInt1 + (paramInt4 * 2 + paramInt2 * 2), paramInt3);
        return;
      }
    } while (i != 1);
    paramInt1 = (int)(paramInt2 + 6.0F * this.d) * 3 / 2;
    getChildAt(0).layout(paramInt1, 0, paramInt2 + paramInt1, paramInt3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.b = View.MeasureSpec.getSize(paramInt1);
    View localView = getChildAt(0);
    if (localView == null) {
      return;
    }
    measureChild(localView, paramInt1, paramInt2);
    paramInt2 = localView.getMeasuredHeight();
    if (getChildCount() % 4 == 0) {}
    for (paramInt1 = getChildCount() / 4;; paramInt1 = getChildCount() / 4 + 1)
    {
      this.c = ((paramInt1 - 1) * (int)(12.0F * this.d) + paramInt2 * paramInt1);
      setMeasuredDimension(this.b, this.c);
      return;
    }
  }
  
  public void setChildTextLength(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/FourItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */