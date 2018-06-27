package cn.testin.analysis;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class f
  implements View.OnClickListener
{
  f(TesterActivity paramTesterActivity) {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    TesterActivity.d(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */