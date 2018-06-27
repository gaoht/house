package com.ziroom.credit.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class ScoreRankView
  extends View
{
  int a;
  int b;
  int c;
  Paint d = new Paint();
  
  public ScoreRankView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScoreRankView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScoreRankView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int dip2px(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setColor(54708);
    this.d.setStrokeWidth(dip2px(0.5F));
    paramCanvas.drawCircle(this.b, this.c, this.a / 2 - dip2px(2.0F), this.d);
    this.d.setStrokeWidth(dip2px(2.0F));
    this.d.setColor(-921103);
    this.d.setShader(null);
    paramCanvas.drawCircle(this.b + dip2px(3.0F), this.c + dip2px(3.0F), this.a / 2 - dip2px(40.0F), this.d);
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, this.a, 0.0F, -34489, 48750, Shader.TileMode.CLAMP);
    this.d.setShader(localLinearGradient);
    paramCanvas.drawCircle(this.b, this.c, this.a / 2 - dip2px(40.0F), this.d);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    int j = this.a / 2;
    this.c = j;
    this.b = j;
    if (this.a > i)
    {
      this.a = i;
      paramInt1 = this.a / 2;
      this.c = paramInt1;
      this.b = paramInt1;
      super.onMeasure(paramInt2, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/ScoreRankView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */