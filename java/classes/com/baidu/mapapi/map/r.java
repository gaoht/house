package com.baidu.mapapi.map;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.E;
import com.baidu.platform.comapi.map.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class r
  implements View.OnClickListener
{
  r(TextureMapView paramTextureMapView) {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = TextureMapView.a(this.a).b().D();
    paramView.a -= 1.0F;
    TextureMapView.a(this.a).b().a(paramView, 300);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */