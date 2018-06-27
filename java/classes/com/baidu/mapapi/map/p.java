package com.baidu.mapapi.map;

import android.view.View;

class p
  implements SwipeDismissTouchListener.DismissCallbacks
{
  p(SwipeDismissView paramSwipeDismissView) {}
  
  public boolean canDismiss(Object paramObject)
  {
    return true;
  }
  
  public void onDismiss(View paramView, Object paramObject)
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.onDismiss();
  }
  
  public void onNotify()
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.onNotify();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */