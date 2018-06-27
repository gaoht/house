package com.ziroom.credit.view.rank;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class ScoreRankInSideView
  extends View
{
  int a;
  Paint b;
  private Context c;
  
  public ScoreRankInSideView(Context paramContext)
  {
    this(paramContext, null);
    this.b = new Paint();
  }
  
  public ScoreRankInSideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    this.b = new Paint();
  }
  
  public int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat / 1.5D + 0.5D);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.b.setColor(-12143874);
    this.b.setAntiAlias(true);
    this.b.setStrokeWidth(dip2px(this.c, 1.0F));
    this.b.setStyle(Paint.Style.STROKE);
    paramCanvas.drawArc(new RectF(dip2px(getContext(), 32.0F), dip2px(getContext(), 32.0F), this.a - dip2px(getContext(), 32.0F), this.a - dip2px(getContext(), 32.0F)), 90.0F, 255.0F, false, this.b);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.a > i)
    {
      this.a = i;
      super.onMeasure(paramInt2, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/rank/ScoreRankInSideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */