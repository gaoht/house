package com.ziroom.ziroomcustomer.bestgoods.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public abstract class b
  implements View.OnClickListener
{
  private static long a;
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    long l = System.currentTimeMillis();
    if (l - a >= 5000L)
    {
      a = l;
      onMultiClick(paramView, true);
      return;
    }
    onMultiClick(paramView, false);
  }
  
  public abstract void onMultiClick(View paramView, boolean paramBoolean);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */