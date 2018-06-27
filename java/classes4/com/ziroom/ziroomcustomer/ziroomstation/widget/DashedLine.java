package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.ziroom.ziroomcustomer.util.n;

public class DashedLine
  extends View
{
  Context a;
  
  public DashedLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(-1118482);
    localPaint.setStrokeWidth(n.dip2px(this.a, 2.0F));
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.lineTo(0.0F, 900.0F);
    localPaint.setPathEffect(new DashPathEffect(new float[] { n.dip2px(this.a, 3.0F), n.dip2px(this.a, 2.0F) }, 2.0F));
    paramCanvas.drawPath(localPath, localPaint);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/DashedLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */