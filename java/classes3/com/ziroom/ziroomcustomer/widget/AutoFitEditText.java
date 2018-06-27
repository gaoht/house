package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class AutoFitEditText
  extends EditText
{
  private static float a = 1.0F;
  private static float b = 40.0F;
  private TextPaint c;
  private float d;
  private float e;
  
  public AutoFitEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AutoFitEditText(Context paramContext, AttributeSet paramAttributeSet)
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
    int m;
    int n;
    int i1;
    float f1;
    int i;
    int j;
    int k;
    float f4;
    int i2;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      m = paramInt1 - getPaddingLeft() - getPaddingRight();
      n = getPaddingBottom();
      i1 = getPaddingTop();
      float f3 = 1.0F;
      float f2 = 0.0F;
      if (Build.VERSION.SDK_INT > 16)
      {
        f3 = getLineSpacingMultiplier();
        f2 = getLineSpacingExtra();
      }
      f1 = this.e;
      this.c.setTextSize(f1);
      i = 1;
      paramInt1 = 1;
      j = m;
      k = paramInt1;
      f4 = f1;
      if (f1 > this.d)
      {
        k = (int)this.c.measureText(paramString);
        i2 = round(this.c.getFontMetricsInt(null) * f3 + f2);
        if (k >= j) {
          break label170;
        }
        f4 = f1;
        k = paramInt1;
      }
      label145:
      if (k < 2) {
        break label240;
      }
      setSingleLine(false);
      setMaxLines(k);
    }
    for (;;)
    {
      setTextSize(0, f4);
      return;
      label170:
      paramInt1 = (paramInt2 - n - i1) / i2;
      if (paramInt1 > i)
      {
        j = m * paramInt1;
        i = paramInt1;
        break;
      }
      f1 -= 6.0F;
      if (f1 <= this.d)
      {
        f4 = this.d;
        k = paramInt1;
        break label145;
      }
      this.c.setTextSize(f1);
      break;
      label240:
      setSingleLine(true);
      setMaxLines(k);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/AutoFitEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */