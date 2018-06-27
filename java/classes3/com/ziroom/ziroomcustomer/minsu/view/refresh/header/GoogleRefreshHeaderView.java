package com.ziroom.ziroomcustomer.minsu.view.refresh.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.aspsine.swipetoloadlayout.d;
import com.aspsine.swipetoloadlayout.e;
import com.ziroom.ziroomcustomer.minsu.view.refresh.a.a.b;

public class GoogleRefreshHeaderView
  extends FrameLayout
  implements d, e
{
  private ImageView a;
  private int b;
  private b c;
  
  public GoogleRefreshHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GoogleRefreshHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GoogleRefreshHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = new b(paramContext);
    getResources();
    this.c.setColors(new int[] { Color.parseColor("#7B1FA2") });
    this.b = paramContext.getResources().getDimensionPixelOffset(2131231203);
  }
  
  public void complete()
  {
    this.c.stop();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131696036));
    this.a.setBackgroundDrawable(this.c);
  }
  
  public void onPrepare() {}
  
  public void onRefresh()
  {
    this.c.start();
  }
  
  public void onRelease() {}
  
  public void onReset() {}
  
  public void onSwipe(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c.setPercent(paramInt / this.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/refresh/header/GoogleRefreshHeaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */