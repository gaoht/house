package cn.testin.analysis;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class az
  implements View.OnClickListener
{
  az(ay paramay, View.OnClickListener paramOnClickListener) {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.b.dismiss();
    if (this.a != null) {
      this.a.onClick(paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */