package cn.jpush.android.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class a
  implements View.OnClickListener
{
  a(FullScreenView paramFullScreenView) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (FullScreenView.access$000(this.a) != null) {
      ((Activity)FullScreenView.access$000(this.a)).onBackPressed();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */