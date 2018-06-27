package com.baidu.mapapi.search.route;

public class TransitRoutePlanOption
{
  PlanNode a = null;
  PlanNode b = null;
  String c = null;
  TransitPolicy d = TransitPolicy.EBUS_TIME_FIRST;
  
  public TransitRoutePlanOption city(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public TransitRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.a = paramPlanNode;
    return this;
  }
  
  public TransitRoutePlanOption policy(TransitPolicy paramTransitPolicy)
  {
    this.d = paramTransitPolicy;
    return this;
  }
  
  public TransitRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.b = paramPlanNode;
    return this;
  }
  
  public static enum TransitPolicy
  {
    private int a = 0;
    
    private TransitPolicy(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getInt()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/TransitRoutePlanOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */