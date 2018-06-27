package com.baidu.mapapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class SwipeDismissView
  extends RelativeLayout
{
  WearMapView.OnDismissCallback a = null;
  
  public SwipeDismissView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, View paramView)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramView);
  }
  
  public SwipeDismissView(Context paramContext, AttributeSet paramAttributeSet, View paramView)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramView);
  }
  
  public SwipeDismissView(Context paramContext, View paramView)
  {
    super(paramContext);
    a(paramContext, paramView);
  }
  
  void a(Context paramContext, View paramView)
  {
    setOnTouchListener(new SwipeDismissTouchListener(paramView, new Object(), new p(this)));
  }
  
  public void setCallback(WearMapView.OnDismissCallback paramOnDismissCallback)
  {
    this.a = paramOnDismissCallback;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/SwipeDismissView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */