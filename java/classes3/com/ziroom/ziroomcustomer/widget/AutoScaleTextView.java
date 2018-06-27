package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.util.ah;

public class AutoScaleTextView
  extends TextView
{
  private Paint a = new Paint();
  private float b = 50.0F;
  private float c = 10.0F;
  private float d = 60.0F;
  
  public AutoScaleTextView(Context paramContext)
  {
    super(paramContext);
    this.c = ah.dip2px(paramContext, 10.0F);
    this.d = getTextSize();
  }
  
  public AutoScaleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = ah.dip2px(paramContext, 10.0F);
    this.d = getTextSize();
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((paramInt <= 0) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    int i = getPaddingLeft();
    int j = getPaddingRight();
    this.a.set(getPaint());
    float f1 = this.d;
    this.a.setTextSize(f1);
    for (;;)
    {
      float f2 = f1;
      if (f1 > this.c)
      {
        f2 = f1;
        if (this.a.measureText(paramString) > paramInt - i - j)
        {
          f1 -= ah.dip2px(getContext(), 1.0F);
          if (f1 > this.c) {
            break label128;
          }
          f2 = this.c;
        }
      }
      setTextSize(f2);
      setTextSize(0, f2);
      return;
      label128:
      this.a.setTextSize(f1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      a(getText().toString(), paramInt1);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a(paramCharSequence.toString(), getWidth());
  }
  
  public void setMinTextSize(float paramFloat)
  {
    this.c = paramFloat;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/AutoScaleTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */