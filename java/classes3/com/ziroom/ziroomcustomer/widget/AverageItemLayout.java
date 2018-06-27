package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;

public class AverageItemLayout
  extends LinearLayout
{
  private int a = 5;
  private int b = 4;
  private int c;
  private int d;
  private int e = 0;
  private float f;
  private int g;
  
  public AverageItemLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AverageItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext.getResources().getDisplayMetrics().density;
    this.g = ((int)(12.0F * this.f));
    setOrientation(0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AverageItemLayout);
    this.b = paramContext.getInteger(0, 4);
    this.a = paramContext.getInteger(1, 5);
    this.g = paramContext.getInteger(2, 12);
    this.e = paramContext.getInteger(3, 0);
    paramContext.recycle();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = getChildCount();
    if (paramInt3 <= 0) {
      return;
    }
    paramInt4 = (int)(12.0F * this.f);
    int i = (this.c - this.b * this.g) / this.b;
    int j = getChildAt(0).getMeasuredHeight();
    if ((this.e == 0) && (paramInt3 < this.b)) {}
    for (paramInt1 = (this.b - paramInt3) * (this.g + i) / 2;; paramInt1 = 0)
    {
      paramInt2 = 0;
      while (paramInt2 < paramInt3)
      {
        int k = paramInt2 / this.b;
        int m = paramInt2 % this.b;
        int n = this.g;
        int i1 = this.g;
        getChildAt(paramInt2).layout((n + i) * m + paramInt1, k * (j + paramInt4), m * i1 + (m + 1) * i + paramInt1, (k + 1) * j + k * paramInt4);
        k = (int)(1.0F * this.f);
        k = (int)(8.0F * this.f);
        getChildAt(paramInt2).setPadding(0, k, 0, k);
        if ((getChildAt(paramInt2) instanceof TextView))
        {
          TextView localTextView = (TextView)getChildAt(paramInt2);
          localTextView.setIncludeFontPadding(false);
          localTextView.setSingleLine();
          localTextView.setGravity(17);
          if (localTextView.getText().toString().length() > this.a) {
            localTextView.setText(localTextView.getText().toString().substring(0, this.a) + "..");
          }
        }
        paramInt2 += 1;
      }
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c = View.MeasureSpec.getSize(paramInt1);
    View localView = getChildAt(0);
    if (localView == null) {
      return;
    }
    measureChild(localView, paramInt1, paramInt2);
    paramInt2 = localView.getMeasuredHeight();
    if (getChildCount() % this.b == 0) {}
    for (paramInt1 = getChildCount() / this.b;; paramInt1 = getChildCount() / this.b + 1)
    {
      this.d = ((paramInt1 - 1) * (int)(12.0F * this.f) + paramInt2 * paramInt1);
      setMeasuredDimension(this.c, this.d);
      return;
    }
  }
  
  public void setChildTextLength(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setItemGravity(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
  
  public void setItemMargin(int paramInt)
  {
    this.g = ((int)(paramInt * this.f));
  }
  
  public void setOneLineChildCount(int paramInt)
  {
    this.b = paramInt;
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/AverageItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */