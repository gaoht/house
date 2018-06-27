package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;

public class FiveEvaluteButton
  extends MinsuEvaluteButton
  implements MinsuEvaluteButton.a
{
  private boolean a = true;
  private float b = 0.0F;
  private int[] c = new int[4];
  private int d = 10;
  private a e = a.b;
  private int f = -16777216;
  private int g = 0;
  private MinsuEvaluteButton.a h;
  
  public FiveEvaluteButton(Context paramContext)
  {
    super(paramContext);
    a();
    setOnSwitchStateListener(this);
  }
  
  public FiveEvaluteButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fiveeva).getInteger(0, 10);
    a();
    setOnSwitchStateListener(this);
  }
  
  public FiveEvaluteButton(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fiveeva).getInteger(0, 10);
    a();
    setOnSwitchStateListener(this);
    this.c = paramArrayOfInt;
  }
  
  private int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
  }
  
  private void a()
  {
    int i = 0;
    if (i < 5)
    {
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a(this.d), a(this.d));
      localLayoutParams.gravity = 17;
      int j = this.c[0];
      int k = this.c[1];
      int m = this.c[2];
      int n = this.c[3];
      if ((j == 0) && (k == 0) && (m == 0) && (n == 0)) {
        localLayoutParams.setMargins(a(10), a(5), a(10), a(5));
      }
      for (;;)
      {
        localLayoutParams.gravity = 16;
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setBackgroundResource(2130839075);
        addView(localImageView);
        i += 1;
        break;
        localLayoutParams.setMargins(a(j), a(k), a(m), a(n));
      }
    }
    b();
  }
  
  private void b()
  {
    TextView localTextView = getScoreTextView();
    int i;
    if (this.e == a.c)
    {
      i = 8;
      localTextView.setVisibility(i);
      if (this.e != a.b) {
        break label79;
      }
      localTextView.setText(this.b + "分");
    }
    for (;;)
    {
      localTextView.setTextColor(this.f);
      localTextView.setTextSize(12.0F);
      return;
      i = 0;
      break;
      label79:
      if (this.e == a.a)
      {
        String str = this.g + "条";
        if (this.g > 0) {
          localTextView.setText(str);
        }
      }
    }
  }
  
  public float getScore()
  {
    return this.b;
  }
  
  public TextView getScoreTextView()
  {
    Object localObject = getChildAt(5);
    if (localObject == null)
    {
      localObject = new TextView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, a(16));
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 17;
      localLayoutParams.setMargins(a(10), 5, 0, 5);
      ((TextView)localObject).setGravity(16);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      addView((View)localObject);
      return (TextView)localObject;
    }
    return (TextView)localObject;
  }
  
  public boolean isSwitch()
  {
    return this.a;
  }
  
  public void onSwitch(int paramInt)
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      if (getStep() == 5)
      {
        int i = paramInt;
        if (paramInt == 0) {
          i = 1;
        }
        setScore(i);
        paramInt = i;
      }
      while (this.h != null)
      {
        this.h.onSwitch(paramInt);
        return;
        setScore(paramInt / 2.0F);
      }
    }
  }
  
  public void setCount(int paramInt)
  {
    this.g = paramInt;
    setEveTextStatus(a.a);
  }
  
  public void setEveTextStatus(a parama)
  {
    this.e = parama;
    b();
  }
  
  public void setOnSwitchStateListener(MinsuEvaluteButton.a parama)
  {
    this.h = parama;
  }
  
  public void setPadding(int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
    if (getChildCount() > 0) {
      removeAllViews();
    }
    a();
  }
  
  public void setScore(float paramFloat)
  {
    this.b = paramFloat;
    int j = (int)this.b;
    int i = 0;
    while (i < j)
    {
      ((ImageView)getChildAt(i)).setImageResource(2130839077);
      i += 1;
    }
    i = 4;
    while (i >= j)
    {
      ((ImageView)getChildAt(i)).setImageResource(2130839075);
      i -= 1;
    }
    i = Math.round((paramFloat - j) * 2.0F);
    if (i == 1) {
      ((ImageView)getChildAt(j)).setImageResource(2130839076);
    }
    for (;;)
    {
      b();
      return;
      if (i == 2) {
        ((ImageView)getChildAt(j)).setImageResource(2130839077);
      }
    }
  }
  
  public void setScoreTextVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (a locala = a.b;; locala = a.c)
    {
      setEveTextStatus(locala);
      return;
    }
  }
  
  public void setSwitch(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (paramBoolean) {
      setStep(5);
    }
    for (;;)
    {
      super.setOnSwitchStateListener(this);
      return;
      setStep(10);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.f = paramInt;
    b();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/FiveEvaluteButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */