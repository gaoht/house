package com.baidu.mapapi.search.route;

public class WalkingRoutePlanOption
{
  PlanNode a = null;
  PlanNode b = null;
  
  public WalkingRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.a = paramPlanNode;
    return this;
  }
  
  public WalkingRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.b = paramPlanNode;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/WalkingRoutePlanOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */