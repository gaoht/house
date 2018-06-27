package com.baidu.mapapi.search.route;

public class BikingRoutePlanOption
{
  PlanNode a = null;
  PlanNode b = null;
  
  public BikingRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.a = paramPlanNode;
    return this;
  }
  
  public BikingRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.b = paramPlanNode;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/BikingRoutePlanOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */