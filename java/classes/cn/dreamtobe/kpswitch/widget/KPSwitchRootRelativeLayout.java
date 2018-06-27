package cn.dreamtobe.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import cn.dreamtobe.kpswitch.a.c;

public class KPSwitchRootRelativeLayout
  extends RelativeLayout
{
  private c a;
  
  public KPSwitchRootRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public KPSwitchRootRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public KPSwitchRootRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @TargetApi(21)
  public KPSwitchRootRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  private void a()
  {
    this.a = new c(this);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a.handleBeforeMeasure(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/widget/KPSwitchRootRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */