package cn.dreamtobe.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cn.dreamtobe.kpswitch.a;

public class KPSwitchPanelRelativeLayout
  extends RelativeLayout
  implements a, cn.dreamtobe.kpswitch.b
{
  private cn.dreamtobe.kpswitch.a.b a;
  
  public KPSwitchPanelRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public KPSwitchPanelRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public KPSwitchPanelRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  @TargetApi(21)
  public KPSwitchPanelRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.a = new cn.dreamtobe.kpswitch.a.b(this, paramAttributeSet);
  }
  
  public void handleHide()
  {
    this.a.handleHide();
  }
  
  public void handleShow()
  {
    super.setVisibility(0);
  }
  
  public boolean isKeyboardShowing()
  {
    return this.a.isKeyboardShowing();
  }
  
  public boolean isVisible()
  {
    return this.a.isVisible();
  }
  
  public void onKeyboardShowing(boolean paramBoolean)
  {
    this.a.setIsKeyboardShowing(paramBoolean);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.a.processOnMeasure(paramInt1, paramInt2);
    super.onMeasure(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public void refreshHeight(int paramInt)
  {
    this.a.resetToRecommendPanelHeight(paramInt);
  }
  
  public void setIgnoreRecommendHeight(boolean paramBoolean)
  {
    this.a.setIgnoreRecommendHeight(paramBoolean);
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.a.filterSetVisibility(paramInt)) {
      return;
    }
    super.setVisibility(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/widget/KPSwitchPanelRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */