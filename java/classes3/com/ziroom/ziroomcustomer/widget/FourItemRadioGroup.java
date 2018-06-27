package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FourItemRadioGroup
  extends RadioGroup
{
  private int a;
  private int b;
  private float c;
  
  public FourItemRadioGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FourItemRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext.getResources().getDisplayMetrics().density;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = getChildCount();
    if (j == 0) {}
    label120:
    do
    {
      return;
      int i = (int)(4.0F * this.c);
      int k = (int)(12.0F * this.c);
      paramInt4 = (this.a - i * 6) / 4;
      paramInt1 = getChildAt(0).getMeasuredHeight();
      if (j > 0)
      {
        paramInt3 = 0;
        if (paramInt3 < j)
        {
          int m = paramInt3 / 4;
          paramInt2 = (m + 1) * paramInt1 + m * k;
          if (paramInt3 % 4 == 0)
          {
            localObject = getChildAt(paramInt3);
            if (m > 0) {
              ((View)localObject).layout(0, (paramInt1 + k) * m, paramInt4, paramInt2);
            }
          }
          do
          {
            paramInt2 = (int)(1.0F * this.c);
            paramInt2 = (int)(8.0F * this.c);
            if ((getChildAt(paramInt3) instanceof TextView))
            {
              localObject = (TextView)getChildAt(paramInt3);
              ((TextView)localObject).setSingleLine();
              ((TextView)localObject).setGravity(17);
              ((TextView)localObject).setIncludeFontPadding(false);
              if (((TextView)localObject).getText().toString().length() > 5) {
                ((TextView)localObject).setText(((TextView)localObject).getText().toString().substring(0, 5) + "...");
              }
            }
            paramInt3 += 1;
            break;
            paramInt2 = paramInt1;
            break label120;
            if (paramInt3 % 4 == 1)
            {
              localObject = getChildAt(paramInt3);
              if (m > 0) {}
              for (;;)
              {
                ((View)localObject).layout(i * 2 + paramInt4, (paramInt1 + k) * m, paramInt4 * 2 + i * 2, paramInt2);
                break;
                paramInt2 = paramInt1;
              }
            }
            if (paramInt3 % 4 == 2)
            {
              localObject = getChildAt(paramInt3);
              if (m > 0) {}
              for (;;)
              {
                ((View)localObject).layout((i * 2 + paramInt4) * 2, (paramInt1 + k) * m, (i * 2 + paramInt4) * 2 + paramInt4, paramInt2);
                break;
                paramInt2 = paramInt1;
              }
            }
          } while (paramInt3 % 4 != 3);
          Object localObject = getChildAt(paramInt3);
          if (m > 0) {}
          for (;;)
          {
            ((View)localObject).layout((i * 2 + paramInt4) * 3, (paramInt1 + k) * m, (i * 2 + paramInt4) * 3 + paramInt4, paramInt2);
            break;
            paramInt2 = paramInt1;
          }
        }
      }
      if (j == 3)
      {
        paramInt2 = (int)(paramInt4 + 6.0F * this.c) / 2;
        getChildAt(0).layout(paramInt2, 0, paramInt4 + paramInt2, paramInt1);
        getChildAt(1).layout(paramInt2 + paramInt4 + i * 2, 0, paramInt4 * 2 + i * 2 + paramInt2, paramInt1);
        getChildAt(2).layout((i * 2 + paramInt4) * 2 + paramInt2, 0, paramInt2 + ((i * 2 + paramInt4) * 2 + paramInt4), paramInt1);
        return;
      }
      if (j == 2)
      {
        paramInt2 = (int)(paramInt4 + 6.0F * this.c);
        getChildAt(0).layout(paramInt2, 0, paramInt4 + paramInt2, paramInt1);
        getChildAt(1).layout(paramInt2 + paramInt4 + i * 2, 0, paramInt2 + (i * 2 + paramInt4 * 2), paramInt1);
        return;
      }
    } while (j != 1);
    paramInt2 = (int)(paramInt4 + 6.0F * this.c) * 3 / 2;
    getChildAt(0).layout(paramInt2, 0, paramInt4 + paramInt2, paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a = View.MeasureSpec.getSize(paramInt1);
    if (getChildAt(0) == null) {
      return;
    }
    paramInt2 = getChildAt(0).getMeasuredHeight();
    if (getChildCount() == 0) {}
    for (paramInt1 = getChildCount() / 4;; paramInt1 = getChildCount() / 4 + 1)
    {
      this.b = ((paramInt1 - 1) * (int)(12.0F * this.c) + paramInt2 * paramInt1);
      setMeasuredDimension(this.a, this.b);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/FourItemRadioGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */