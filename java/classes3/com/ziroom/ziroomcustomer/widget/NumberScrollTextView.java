package com.ziroom.ziroomcustomer.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import java.text.DecimalFormat;

public class NumberScrollTextView
  extends AutoScaleTextView
{
  static final int[] a = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
  private int b = 0;
  private float c;
  private float d;
  private long e = 1000L;
  private int f = 2;
  private DecimalFormat g;
  private a h = null;
  
  public NumberScrollTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NumberScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  static int a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (paramInt <= a[i]) {
        return i + 1;
      }
      i += 1;
    }
  }
  
  private void a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.d, this.c });
    localValueAnimator.setDuration(this.e);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        Log.e("yangxj---", "" + paramAnonymousValueAnimator.getAnimatedValue().toString());
        NumberScrollTextView.this.setText(NumberScrollTextView.a(NumberScrollTextView.this).format(Float.parseFloat(paramAnonymousValueAnimator.getAnimatedValue().toString())));
        if (paramAnonymousValueAnimator.getAnimatedFraction() >= 1.0F)
        {
          NumberScrollTextView.a(NumberScrollTextView.this, 0);
          if (NumberScrollTextView.b(NumberScrollTextView.this) != null) {
            NumberScrollTextView.b(NumberScrollTextView.this).onEndFinish();
          }
        }
      }
    });
    localValueAnimator.start();
  }
  
  private void b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { (int)this.d, (int)this.c });
    localValueAnimator.setDuration(this.e);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        NumberScrollTextView.this.setText(paramAnonymousValueAnimator.getAnimatedValue().toString());
        if (paramAnonymousValueAnimator.getAnimatedFraction() >= 1.0F)
        {
          NumberScrollTextView.a(NumberScrollTextView.this, 0);
          if (NumberScrollTextView.b(NumberScrollTextView.this) != null) {
            NumberScrollTextView.b(NumberScrollTextView.this).onEndFinish();
          }
        }
      }
    });
    localValueAnimator.start();
  }
  
  public boolean isRunning()
  {
    return this.b == 1;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.g = new DecimalFormat("##0.00");
  }
  
  public void setDuration(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void setFromAndEndNumber(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.c = paramFloat2;
    this.f = 2;
  }
  
  public void setFromAndEndNumber(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.c = paramInt2;
    this.f = 1;
  }
  
  public void setOnEndListener(a parama)
  {
    this.h = parama;
  }
  
  public void start()
  {
    if (!isRunning())
    {
      this.b = 1;
      if (this.f == 1) {
        b();
      }
    }
    else
    {
      return;
    }
    a();
  }
  
  public void withNumber(float paramFloat)
  {
    this.c = paramFloat;
    this.f = 2;
    if (paramFloat > 1000.0F)
    {
      this.d = (paramFloat - (float)Math.pow(10.0D, a((int)paramFloat) - 1));
      return;
    }
    this.d = (paramFloat / 2.0F);
  }
  
  public void withNumber(int paramInt)
  {
    this.c = paramInt;
    this.f = 1;
    if (paramInt > 1000)
    {
      this.d = (paramInt - (float)Math.pow(10.0D, a(paramInt) - 2));
      return;
    }
    this.d = (paramInt / 2);
  }
  
  public static abstract interface a
  {
    public abstract void onEndFinish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/NumberScrollTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */