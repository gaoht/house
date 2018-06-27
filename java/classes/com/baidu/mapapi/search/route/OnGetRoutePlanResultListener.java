package com.baidu.mapapi.search.route;

public abstract interface OnGetRoutePlanResultListener
{
  public abstract void onGetBikingRouteResult(BikingRouteResult paramBikingRouteResult);
  
  public abstract void onGetDrivingRouteResult(DrivingRouteResult paramDrivingRouteResult);
  
  public abstract void onGetTransitRouteResult(TransitRouteResult paramTransitRouteResult);
  
  public abstract void onGetWalkingRouteResult(WalkingRouteResult paramWalkingRouteResult);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/OnGetRoutePlanResultListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */