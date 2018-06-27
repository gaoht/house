package com.megvii.zhimasdk.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class AutoRatioImageview
  extends ImageView
{
  private float a = -1.0F;
  private int b = 0;
  
  public AutoRatioImageview(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoRatioImageview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoRatioImageview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (this.a < 0.0F)
    {
      if (getDrawable() == null)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      paramInt1 = getDrawable().getIntrinsicWidth();
      paramInt2 = getDrawable().getIntrinsicHeight();
      if (this.b == 0)
      {
        setMeasuredDimension(i, i * paramInt2 / paramInt1);
        return;
      }
      setMeasuredDimension(j * paramInt1 / paramInt2, j);
      return;
    }
    if (this.b == 0)
    {
      setMeasuredDimension(i, (int)(i * this.a));
      return;
    }
    setMeasuredDimension((int)(j / this.a), i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/view/AutoRatioImageview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */