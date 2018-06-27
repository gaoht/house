package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class TabTextView
  extends TextView
{
  private Paint a;
  private Paint b;
  private Paint c;
  private Path d;
  private Boolean e = Boolean.valueOf(false);
  private float f;
  
  public TabTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TabTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public TabTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new Paint();
    this.d = new Path();
    this.a.setColor(-16777216);
    this.a.setTextSize(this.f);
    this.a.setTextAlign(Paint.Align.LEFT);
    this.b = new Paint();
    this.b.setColor(-1118482);
    this.b.setStyle(Paint.Style.STROKE);
    this.c = new Paint();
    this.c.setColor(-1118482);
  }
  
  public void isDraw(boolean paramBoolean)
  {
    this.e = Boolean.valueOf(paramBoolean);
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.b);
    int i = (int)TypedValue.applyDimension(1, 7.0F, getResources().getDisplayMetrics());
    if (this.e.booleanValue())
    {
      this.d.moveTo(getWidth() / 2, getHeight() - i);
      this.d.lineTo(getWidth() / 2 - i, getHeight());
      this.d.lineTo(i + getWidth() / 2, getHeight());
      paramCanvas.drawPath(this.d, this.c);
    }
    super.onDraw(paramCanvas);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/TabTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */