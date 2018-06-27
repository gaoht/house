package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class AutoFitTextView
  extends TextView
{
  private static float a = 1.0F;
  private static float b = 40.0F;
  private TextPaint c;
  private float d;
  private float e;
  
  public AutoFitTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AutoFitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.c = new TextPaint();
    this.c.set(getPaint());
    this.e = getTextSize();
    if (this.e <= a) {
      this.e = b;
    }
    this.d = a;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    int j;
    int m;
    int n;
    float f3;
    float f2;
    float f1;
    int i;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      j = paramInt1 - getPaddingLeft() - getPaddingRight();
      m = getPaddingBottom();
      n = getPaddingTop();
      f3 = 1.0F;
      f2 = 0.0F;
      if (Build.VERSION.SDK_INT > 16)
      {
        f3 = getLineSpacingMultiplier();
        f2 = getLineSpacingExtra();
      }
      f1 = this.e;
      this.c.setTextSize(f1);
      paramInt1 = 1;
      i = j;
    }
    for (;;)
    {
      float f4 = f1;
      int k;
      int i1;
      if (f1 > this.d)
      {
        k = (int)this.c.measureText(paramString);
        i1 = round(this.c.getFontMetricsInt(null) * f3 + f2);
        if (k >= i) {
          break label144;
        }
      }
      for (f4 = f1;; f4 = this.d)
      {
        setTextSize(0, f4);
        return;
        label144:
        k = (paramInt2 - m - n) / i1;
        if (k > paramInt1)
        {
          i = j * k;
          paramInt1 = k;
          break;
        }
        f1 -= 6.0F;
        if (f1 > this.d) {
          break label201;
        }
      }
      label201:
      this.c.setTextSize(f1);
    }
  }
  
  public static int round(float paramFloat)
  {
    return (int)((1.6777216E7F * paramFloat) + 8388608L >> 24);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.e("TagSizeChange", "new(" + paramInt1 + "," + paramInt2 + ") old(" + paramInt3 + "" + paramInt4 + ")");
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      a(getText().toString(), paramInt1, paramInt2);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a(paramCharSequence.toString(), getWidth(), getHeight());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/AutoFitTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */