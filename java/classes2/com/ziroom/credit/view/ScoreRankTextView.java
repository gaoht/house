package com.ziroom.credit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.widget.TextView;

public class ScoreRankTextView
  extends TextView
{
  private Context a;
  private LinearGradient b;
  private Paint c;
  private int d = 0;
  private boolean e = true;
  
  public ScoreRankTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScoreRankTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.d = getMeasuredWidth();
    int i = getMeasuredHeight();
    this.c = getPaint();
    String str = getText().toString();
    float f1;
    Object localObject;
    if (this.e)
    {
      f1 = i;
      localObject = Shader.TileMode.REPEAT;
      this.b = new LinearGradient(0.0F, 0.0F, f1, 0.0F, new int[] { -34489, 48750 }, null, (Shader.TileMode)localObject);
      this.c.setShader(this.b);
    }
    for (;;)
    {
      this.c.setTextAlign(Paint.Align.CENTER);
      localObject = this.c.getFontMetrics();
      float f2 = ((Paint.FontMetrics)localObject).bottom;
      float f3 = ((Paint.FontMetrics)localObject).top;
      f1 = getHeight();
      f2 = (getHeight() - (f2 - f3)) / 2.0F;
      f3 = ((Paint.FontMetrics)localObject).bottom;
      paramCanvas.drawText(str, getWidth() / 2, f1 - f2 - f3, this.c);
      return;
      this.c.setColor(Color.parseColor("#EEEEEE"));
    }
  }
  
  public void setView(boolean paramBoolean)
  {
    this.e = paramBoolean;
    postInvalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/ScoreRankTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */