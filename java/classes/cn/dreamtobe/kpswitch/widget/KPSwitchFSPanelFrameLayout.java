package cn.dreamtobe.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Window;
import android.widget.FrameLayout;
import cn.dreamtobe.kpswitch.a.a;
import cn.dreamtobe.kpswitch.b;
import cn.dreamtobe.kpswitch.b.e;

public class KPSwitchFSPanelFrameLayout
  extends FrameLayout
  implements b
{
  private a a;
  
  public KPSwitchFSPanelFrameLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public KPSwitchFSPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public KPSwitchFSPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @TargetApi(21)
  public KPSwitchFSPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void a()
  {
    this.a = new a(this);
  }
  
  public void onKeyboardShowing(boolean paramBoolean)
  {
    this.a.onKeyboardShowing(paramBoolean);
  }
  
  public void recordKeyboardStatus(Window paramWindow)
  {
    this.a.recordKeyboardStatus(paramWindow);
  }
  
  public void refreshHeight(int paramInt)
  {
    e.refreshHeight(this, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/widget/KPSwitchFSPanelFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */