package com.ziroom.ziroomcustomer.minsu.view.refresh.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.aspsine.swipetoloadlayout.c;
import com.aspsine.swipetoloadlayout.e;
import com.ziroom.ziroomcustomer.minsu.view.refresh.a.a.b;

public class GoogleLoadMoreFooterView
  extends FrameLayout
  implements c, e
{
  private ImageView a;
  private int b;
  private b c;
  
  public GoogleLoadMoreFooterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GoogleLoadMoreFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GoogleLoadMoreFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = new b(paramContext);
    getResources();
    this.c.setColors(new int[] { Color.parseColor("#7B1FA2") });
    this.b = paramContext.getResources().getDimensionPixelOffset(2131231152);
  }
  
  public void complete()
  {
    this.c.stop();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131696035));
    this.a.setBackgroundDrawable(this.c);
  }
  
  public void onLoadMore()
  {
    this.c.start();
  }
  
  public void onPrepare() {}
  
  public void onRelease() {}
  
  public void onReset() {}
  
  public void onSwipe(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c.setPercent(-paramInt / this.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/refresh/footer/GoogleLoadMoreFooterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */