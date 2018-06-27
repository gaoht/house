package com.ziroom.credit.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class CreditImageView
  extends ImageView
{
  public CreditImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CreditImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CreditImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (paramInt2 < paramInt1) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt1);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/CreditImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */