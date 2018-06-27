package android.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class m
  implements AdapterView.OnItemSelectedListener
{
  private final ActionBar.b a;
  
  public m(ActionBar.b paramb)
  {
    this.a = paramb;
  }
  
  @Instrumented
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemSelected(this, paramAdapterView, paramView, paramInt, paramLong);
    if (this.a != null) {
      this.a.onNavigationItemSelected(paramInt, paramLong);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */