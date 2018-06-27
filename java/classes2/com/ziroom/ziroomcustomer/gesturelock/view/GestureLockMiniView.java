package com.ziroom.ziroomcustomer.gesturelock.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.minsu.f.ab;

public class GestureLockMiniView
  extends RelativeLayout
{
  private ImageView[] a;
  private int b = 3;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public GestureLockMiniView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GestureLockMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public GestureLockMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GestureLockViewGroup, paramInt, 0).getInt(4, this.b);
    this.c = ab.dp2px(paramContext, 1.0F);
  }
  
  private void a()
  {
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.a == null)
    {
      this.a = new ImageView[this.b * this.b];
      i = 0;
      if (i < this.a.length)
      {
        this.a[i] = new ImageView(getContext());
        this.a[i].setImageResource(2130839566);
        this.a[i].setId(i + 1);
        localLayoutParams = new RelativeLayout.LayoutParams(this.f, this.f);
        if (i % this.b != 0) {
          localLayoutParams.addRule(1, this.a[(i - 1)].getId());
        }
        if (i > this.b - 1) {
          localLayoutParams.addRule(3, this.a[(i - this.b)].getId());
        }
        if ((i + 1) % 3 == 0) {
          break label257;
        }
      }
    }
    label257:
    for (int j = this.e;; j = 0)
    {
      if (i < this.b * (this.b - 1)) {}
      for (int k = this.e;; k = 0)
      {
        if (i < this.b) {}
        for (int m = this.d;; m = 0)
        {
          if (i % this.b == 0) {}
          for (int n = this.d;; n = 0)
          {
            localLayoutParams.setMargins(n, m, j, k);
            addView(this.a[i], localLayoutParams);
            i += 1;
            break;
            return;
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 < paramInt2) {}
    for (;;)
    {
      this.f = ((int)getResources().getDimension(2131230911));
      this.e = ((int)(this.f * 0.8F));
      this.d = ((paramInt1 - this.f * this.b - this.e * 2) / 2);
      a();
      return;
      paramInt1 = paramInt2;
    }
  }
  
  public void resetPath()
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((ImageView)getChildAt(i)).setImageResource(2130839566);
      i += 1;
    }
  }
  
  public void setCurrentPath(int... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      ((ImageView)getChildAt(paramVarArgs[i])).setImageResource(2130839567);
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/gesturelock/view/GestureLockMiniView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */