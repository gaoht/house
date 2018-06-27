package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.route.PlanNode;

public class RouteShareURLOption
{
  PlanNode a = null;
  PlanNode b = null;
  RouteShareMode c;
  int d = 0;
  int e = -1;
  
  public RouteShareURLOption cityCode(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public RouteShareURLOption from(PlanNode paramPlanNode)
  {
    this.a = paramPlanNode;
    return this;
  }
  
  public RouteShareMode getmMode()
  {
    return this.c;
  }
  
  public RouteShareURLOption pn(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public RouteShareURLOption routMode(RouteShareMode paramRouteShareMode)
  {
    this.c = paramRouteShareMode;
    return this;
  }
  
  public RouteShareURLOption to(PlanNode paramPlanNode)
  {
    this.b = paramPlanNode;
    return this;
  }
  
  public static enum RouteShareMode
  {
    private int a = -1;
    
    static
    {
      CYCLE_ROUTE_SHARE_MODE = new RouteShareMode("CYCLE_ROUTE_SHARE_MODE", 2, 2);
    }
    
    private RouteShareMode(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getRouteShareMode()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/share/RouteShareURLOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */