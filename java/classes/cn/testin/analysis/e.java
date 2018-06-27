package cn.testin.analysis;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class e
  implements View.OnClickListener
{
  e(TesterActivity paramTesterActivity, boolean paramBoolean) {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.a)
    {
      this.b.finish();
      return;
    }
    TesterActivity.a(this.b, TesterActivity.c(this.b));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */