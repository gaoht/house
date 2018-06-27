package com.baidu.mapapi.search.route;

import java.util.List;

public class DrivingRoutePlanOption
{
  PlanNode a = null;
  PlanNode b = null;
  String c;
  DrivingPolicy d = DrivingPolicy.ECAR_TIME_FIRST;
  List<PlanNode> e = null;
  DrivingTrafficPolicy f = DrivingTrafficPolicy.ROUTE_PATH;
  
  public DrivingRoutePlanOption currentCity(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public DrivingRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.a = paramPlanNode;
    return this;
  }
  
  public DrivingRoutePlanOption passBy(List<PlanNode> paramList)
  {
    this.e = paramList;
    return this;
  }
  
  public DrivingRoutePlanOption policy(DrivingPolicy paramDrivingPolicy)
  {
    this.d = paramDrivingPolicy;
    return this;
  }
  
  public DrivingRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.b = paramPlanNode;
    return this;
  }
  
  public DrivingRoutePlanOption trafficPolicy(DrivingTrafficPolicy paramDrivingTrafficPolicy)
  {
    this.f = paramDrivingTrafficPolicy;
    return this;
  }
  
  public static enum DrivingPolicy
  {
    private int a;
    
    private DrivingPolicy(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
  
  public static enum DrivingTrafficPolicy
  {
    private int a;
    
    private DrivingTrafficPolicy(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/DrivingRoutePlanOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */