package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.widget.TextView;

public class GradientTextView
  extends TextView
{
  private int a;
  private Paint b;
  private LinearGradient c;
  private int d = 0;
  private int e = 0;
  
  public GradientTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GradientTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GradientTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != 0) {}
    for (this.a = paramInt1;; this.a = getMeasuredWidth())
    {
      if ((this.d != 0) && (this.e != 0))
      {
        this.b = getPaint();
        this.c = new LinearGradient(0.0F, 0.0F, this.a, 0.0F, this.d, this.e, Shader.TileMode.CLAMP);
        this.b.setShader(this.c);
      }
      return;
    }
  }
  
  public void setGradientColor(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/GradientTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */