package com.baidu.mapapi.map;

import com.baidu.platform.comapi.map.e;

public final class UiSettings
{
  private e a;
  
  UiSettings(e parame)
  {
    this.a = parame;
  }
  
  public boolean isCompassEnabled()
  {
    return this.a.q();
  }
  
  public boolean isOverlookingGesturesEnabled()
  {
    return this.a.y();
  }
  
  public boolean isRotateGesturesEnabled()
  {
    return this.a.x();
  }
  
  public boolean isScrollGesturesEnabled()
  {
    return this.a.v();
  }
  
  public boolean isZoomGesturesEnabled()
  {
    return this.a.w();
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    setRotateGesturesEnabled(paramBoolean);
    setScrollGesturesEnabled(paramBoolean);
    setOverlookingGesturesEnabled(paramBoolean);
    setZoomGesturesEnabled(paramBoolean);
  }
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    this.a.h(paramBoolean);
  }
  
  public void setOverlookingGesturesEnabled(boolean paramBoolean)
  {
    this.a.p(paramBoolean);
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    this.a.o(paramBoolean);
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.a.m(paramBoolean);
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    this.a.n(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/UiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */