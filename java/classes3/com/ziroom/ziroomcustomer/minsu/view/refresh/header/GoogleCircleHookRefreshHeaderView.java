package com.ziroom.ziroomcustomer.minsu.view.refresh.header;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.aspsine.swipetoloadlayout.d;
import com.aspsine.swipetoloadlayout.e;
import com.ziroom.ziroomcustomer.minsu.view.refresh.GoogleCircleProgressView;

public class GoogleCircleHookRefreshHeaderView
  extends FrameLayout
  implements d, e
{
  private GoogleCircleProgressView a;
  private int b;
  private int c;
  
  public GoogleCircleHookRefreshHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GoogleCircleHookRefreshHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GoogleCircleHookRefreshHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext.getResources().getDimensionPixelOffset(2131231203);
    this.c = paramContext.getResources().getDimensionPixelOffset(2131231201);
  }
  
  public void complete()
  {
    this.a.stop();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((GoogleCircleProgressView)findViewById(2131696037));
    this.a.setColorSchemeResources(new int[] { 2131624017, 2131624087, 2131624057, 2131624066 });
    this.a.setStartEndTrim(0.0F, 0.75F);
  }
  
  public void onPrepare()
  {
    this.a.setStartEndTrim(0.0F, 0.75F);
  }
  
  public void onRefresh()
  {
    this.a.start();
  }
  
  public void onRelease() {}
  
  public void onReset()
  {
    ViewCompat.setAlpha(this.a, 1.0F);
  }
  
  public void onSwipe(int paramInt, boolean paramBoolean)
  {
    float f = paramInt / this.b;
    ViewCompat.setAlpha(this.a, f);
    this.a.setProgressRotation(paramInt / this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/refresh/header/GoogleCircleHookRefreshHeaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */