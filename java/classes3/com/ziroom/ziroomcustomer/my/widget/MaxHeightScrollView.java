package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.util.ah;

public class MaxHeightScrollView
  extends ScrollView
{
  private Context a;
  private int b;
  
  public MaxHeightScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    paramContext = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.MaxHeightScrollView);
    this.b = paramContext.getDimensionPixelSize(0, ah.dip2px(this.a, 280.0F));
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    if (getMeasuredHeight() > this.b) {
      setMeasuredDimension(paramInt1, this.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/MaxHeightScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */