package com.baidu.mapapi.map;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.i;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class w
  implements View.OnClickListener
{
  w(WearMapView paramWearMapView) {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = WearMapView.a(this.a).a().D();
    paramView.a += 1.0F;
    WearMapView.a(this.a).a().a(paramView, 300);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */