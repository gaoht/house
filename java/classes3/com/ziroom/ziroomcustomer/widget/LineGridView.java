package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;

public class LineGridView
  extends GridView
{
  public LineGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LineGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LineGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (getChildCount() <= 1) {}
    Object localObject;
    int k;
    int j;
    float f;
    int i;
    int m;
    int n;
    label167:
    int i1;
    int i2;
    do
    {
      for (;;)
      {
        return;
        localObject = getChildAt(0);
        k = getWidth() / ((View)localObject).getWidth();
        j = getChildCount();
        f = getContext().getResources().getDisplayMetrics().density;
        localObject = new Paint(1);
        ((Paint)localObject).setColor(Color.parseColor("#888888"));
        ((Paint)localObject).setStyle(Paint.Style.STROKE);
        if (j >= k) {
          break;
        }
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          localView.getLeft();
          k = localView.getTop();
          m = localView.getRight();
          n = localView.getBottom();
          paramCanvas.drawLine(m, k + 4.0F * f, m, n - 4.0F * f, (Paint)localObject);
          i += 1;
        }
      }
      i = 0;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      m = localView.getLeft();
      n = localView.getTop();
      i1 = localView.getRight();
      i2 = localView.getBottom();
      if ((i + 1) % k != 0) {
        break label250;
      }
    } while (i + 1 == j);
    paramCanvas.drawLine(m, i2, i1, i2, (Paint)localObject);
    for (;;)
    {
      i += 1;
      break label167;
      break;
      label250:
      if (((j % k != 0) && (i + 1 > j - j % k)) || ((j % k == 0) && (i + 1 > j - k)))
      {
        paramCanvas.drawLine(i1, 4.0F * f + n, i1, i2 - 4.0F * f, (Paint)localObject);
      }
      else
      {
        paramCanvas.drawLine(m, i2, i1, i2, (Paint)localObject);
        paramCanvas.drawLine(i1, 4.0F * f + n, i1, i2 - 4.0F * f, (Paint)localObject);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/LineGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */