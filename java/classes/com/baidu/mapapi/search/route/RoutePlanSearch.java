package com.baidu.mapapi.search.route;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.g;
import com.baidu.platform.comapi.search.a;
import com.baidu.platform.comapi.search.b;
import com.baidu.platform.comapi.search.d;
import com.baidu.platform.comapi.search.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RoutePlanSearch
  extends g
{
  private d a = null;
  private OnGetRoutePlanResultListener b = null;
  private boolean c = false;
  private int d = 0;
  private int e = 0;
  
  RoutePlanSearch()
  {
    this.a.a(new a(null));
  }
  
  private ArrayList<f> a(DrivingRoutePlanOption paramDrivingRoutePlanOption)
  {
    if (paramDrivingRoutePlanOption.e == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramDrivingRoutePlanOption = paramDrivingRoutePlanOption.e.iterator();
    while (paramDrivingRoutePlanOption.hasNext())
    {
      PlanNode localPlanNode = (PlanNode)paramDrivingRoutePlanOption.next();
      if ((localPlanNode != null) && ((localPlanNode.getLocation() != null) || ((localPlanNode.getName() != null) && (localPlanNode.getCity() != null) && (localPlanNode.getName().length() > 0) && (localPlanNode.getCity().length() > 0))))
      {
        f localf = new f();
        if (localPlanNode.getName() != null) {
          localf.b = localPlanNode.getName();
        }
        if (localPlanNode.getLocation() != null) {
          localf.a = CoordUtil.ll2point(localPlanNode.getLocation());
        }
        if (localPlanNode.getCity() == null) {}
        for (localf.c = "";; localf.c = localPlanNode.getCity())
        {
          localArrayList.add(localf);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static RoutePlanSearch newInstance()
  {
    BMapManager.init();
    return new RoutePlanSearch();
  }
  
  public boolean bikingSearch(BikingRoutePlanOption paramBikingRoutePlanOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramBikingRoutePlanOption == null) || (paramBikingRoutePlanOption.b == null) || (paramBikingRoutePlanOption.a == null)) {
      throw new IllegalArgumentException("route plan option , origin or destination can not be null");
    }
    a locala1 = new a();
    if (paramBikingRoutePlanOption.a.getName() != null) {
      locala1.d = paramBikingRoutePlanOption.a.getName();
    }
    if (paramBikingRoutePlanOption.a.getLocation() != null)
    {
      locala1.c = paramBikingRoutePlanOption.a.getLocation();
      locala1.a = 1;
    }
    a locala2 = new a();
    if (paramBikingRoutePlanOption.b.getName() != null) {
      locala2.d = paramBikingRoutePlanOption.b.getName();
    }
    if (paramBikingRoutePlanOption.b.getLocation() != null)
    {
      locala2.c = paramBikingRoutePlanOption.b.getLocation();
      locala2.a = 1;
    }
    this.d = this.e;
    this.e = 3;
    return this.a.a(locala1, locala2, paramBikingRoutePlanOption.a.getCity(), paramBikingRoutePlanOption.b.getCity());
  }
  
  public void destroy()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b = null;
    this.a.a();
    this.a = null;
    BMapManager.destroy();
  }
  
  public boolean drivingSearch(DrivingRoutePlanOption paramDrivingRoutePlanOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramDrivingRoutePlanOption == null) || (paramDrivingRoutePlanOption.b == null) || (paramDrivingRoutePlanOption.a == null)) {
      throw new IllegalArgumentException("route plan option , origin or destination can not be null");
    }
    if (paramDrivingRoutePlanOption.d == null) {
      paramDrivingRoutePlanOption.d = DrivingRoutePlanOption.DrivingPolicy.ECAR_TIME_FIRST;
    }
    a locala1 = new a();
    if (paramDrivingRoutePlanOption.a.getName() != null) {
      locala1.d = paramDrivingRoutePlanOption.a.getName();
    }
    if (paramDrivingRoutePlanOption.a.getLocation() != null)
    {
      locala1.b = CoordUtil.ll2point(paramDrivingRoutePlanOption.a.getLocation());
      locala1.a = 1;
    }
    a locala2 = new a();
    if (paramDrivingRoutePlanOption.b.getName() != null) {
      locala2.d = paramDrivingRoutePlanOption.b.getName();
    }
    if (paramDrivingRoutePlanOption.b.getLocation() != null)
    {
      locala2.b = CoordUtil.ll2point(paramDrivingRoutePlanOption.b.getLocation());
      locala2.a = 1;
    }
    this.d = this.e;
    this.e = 2;
    int i = DrivingRoutePlanOption.DrivingTrafficPolicy.ROUTE_PATH.getInt();
    if (paramDrivingRoutePlanOption.f != null) {
      i = paramDrivingRoutePlanOption.f.getInt();
    }
    return this.a.a(locala1, locala2, paramDrivingRoutePlanOption.c, paramDrivingRoutePlanOption.a.getCity(), paramDrivingRoutePlanOption.b.getCity(), null, 12, paramDrivingRoutePlanOption.d.getInt(), i, a(paramDrivingRoutePlanOption), null);
  }
  
  public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener paramOnGetRoutePlanResultListener)
  {
    this.b = paramOnGetRoutePlanResultListener;
  }
  
  public boolean transitSearch(TransitRoutePlanOption paramTransitRoutePlanOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramTransitRoutePlanOption == null) || (paramTransitRoutePlanOption.c == null) || (paramTransitRoutePlanOption.b == null) || (paramTransitRoutePlanOption.a == null)) {
      throw new IllegalArgumentException("route plan option,origin or destination or city can not be null");
    }
    if (paramTransitRoutePlanOption.d == null) {
      paramTransitRoutePlanOption.d = TransitRoutePlanOption.TransitPolicy.EBUS_TIME_FIRST;
    }
    a locala1 = new a();
    if (paramTransitRoutePlanOption.a.getName() != null) {
      locala1.d = paramTransitRoutePlanOption.a.getName();
    }
    if (paramTransitRoutePlanOption.a.getLocation() != null)
    {
      locala1.b = CoordUtil.ll2point(paramTransitRoutePlanOption.a.getLocation());
      locala1.a = 1;
    }
    a locala2 = new a();
    if (paramTransitRoutePlanOption.b.getName() != null) {
      locala2.d = paramTransitRoutePlanOption.b.getName();
    }
    if (paramTransitRoutePlanOption.b.getLocation() != null)
    {
      locala2.b = CoordUtil.ll2point(paramTransitRoutePlanOption.b.getLocation());
      locala2.a = 1;
    }
    this.d = this.e;
    this.e = 0;
    return this.a.a(locala1, locala2, paramTransitRoutePlanOption.c, null, 12, paramTransitRoutePlanOption.d.getInt(), null);
  }
  
  public boolean walkingSearch(WalkingRoutePlanOption paramWalkingRoutePlanOption)
  {
    if (this.a == null) {
      throw new IllegalStateException("searcher has been destroyed");
    }
    if ((paramWalkingRoutePlanOption == null) || (paramWalkingRoutePlanOption.b == null) || (paramWalkingRoutePlanOption.a == null)) {
      throw new IllegalArgumentException("option , origin or destination can not be null");
    }
    a locala1 = new a();
    if (paramWalkingRoutePlanOption.a.getName() != null) {
      locala1.d = paramWalkingRoutePlanOption.a.getName();
    }
    if (paramWalkingRoutePlanOption.a.getLocation() != null)
    {
      locala1.b = CoordUtil.ll2point(paramWalkingRoutePlanOption.a.getLocation());
      locala1.a = 1;
    }
    a locala2 = new a();
    if (paramWalkingRoutePlanOption.b.getName() != null) {
      locala2.d = paramWalkingRoutePlanOption.b.getName();
    }
    if (paramWalkingRoutePlanOption.b.getLocation() != null)
    {
      locala2.b = CoordUtil.ll2point(paramWalkingRoutePlanOption.b.getLocation());
      locala2.a = 1;
    }
    this.d = this.e;
    this.e = 1;
    return this.a.a(locala1, locala2, null, paramWalkingRoutePlanOption.a.getCity(), paramWalkingRoutePlanOption.b.getCity(), null, 12, null);
  }
  
  private class a
    implements b
  {
    private a() {}
    
    public void a(int paramInt)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (RoutePlanSearch.b(RoutePlanSearch.this) == null)) {
        return;
      }
      SearchResult.ERRORNO localERRORNO = null;
      switch (paramInt)
      {
      }
      while (localERRORNO != null) {
        switch (RoutePlanSearch.c(RoutePlanSearch.this))
        {
        default: 
          return;
        case 0: 
          RoutePlanSearch.b(RoutePlanSearch.this).onGetTransitRouteResult(new TransitRouteResult(localERRORNO));
          return;
          localERRORNO = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          continue;
          localERRORNO = SearchResult.ERRORNO.NOT_SUPPORT_BUS;
          continue;
          localERRORNO = SearchResult.ERRORNO.NOT_SUPPORT_BUS_2CITY;
          continue;
          localERRORNO = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
          continue;
          localERRORNO = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          continue;
          localERRORNO = SearchResult.ERRORNO.KEY_ERROR;
          continue;
          localERRORNO = SearchResult.ERRORNO.NETWORK_TIME_OUT;
          continue;
          localERRORNO = SearchResult.ERRORNO.NETWORK_ERROR;
          continue;
          localERRORNO = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
        }
      }
      RoutePlanSearch.b(RoutePlanSearch.this).onGetDrivingRouteResult(new DrivingRouteResult(localERRORNO));
      return;
      RoutePlanSearch.b(RoutePlanSearch.this).onGetWalkingRouteResult(new WalkingRouteResult(localERRORNO));
      return;
      RoutePlanSearch.b(RoutePlanSearch.this).onGetBikingRouteResult(new BikingRouteResult(localERRORNO));
    }
    
    public void a(String paramString) {}
    
    public void b(String paramString) {}
    
    public void c(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null)) {
        return;
      }
      switch (RoutePlanSearch.c(RoutePlanSearch.this))
      {
      default: 
        return;
      case 0: 
        localObject = new TransitRouteResult(SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR);
        ((TransitRouteResult)localObject).a(h.h(paramString));
        RoutePlanSearch.b(RoutePlanSearch.this).onGetTransitRouteResult((TransitRouteResult)localObject);
        return;
      case 2: 
        localObject = new DrivingRouteResult(SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR);
        ((DrivingRouteResult)localObject).a(h.h(paramString));
        if ((((DrivingRouteResult)localObject).getSuggestAddrInfo().getSuggestEndCity() == null) && (((DrivingRouteResult)localObject).getSuggestAddrInfo().getSuggestEndNode() == null) && (((DrivingRouteResult)localObject).getSuggestAddrInfo().getSuggestStartCity() == null) && (((DrivingRouteResult)localObject).getSuggestAddrInfo().getSuggestStartNode() == null) && (((DrivingRouteResult)localObject).getSuggestAddrInfo().getSuggestWpCity() == null) && (((DrivingRouteResult)localObject).getSuggestAddrInfo().getSuggestWpNode() == null)) {
          ((DrivingRouteResult)localObject).error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
        RoutePlanSearch.b(RoutePlanSearch.this).onGetDrivingRouteResult((DrivingRouteResult)localObject);
        return;
      case 1: 
        localObject = new WalkingRouteResult(SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR);
        ((WalkingRouteResult)localObject).a(h.h(paramString));
        RoutePlanSearch.b(RoutePlanSearch.this).onGetWalkingRouteResult((WalkingRouteResult)localObject);
        return;
      }
      Object localObject = new BikingRouteResult(SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR);
      ((BikingRouteResult)localObject).a(h.h(paramString));
      RoutePlanSearch.b(RoutePlanSearch.this).onGetBikingRouteResult((BikingRouteResult)localObject);
    }
    
    public void d(String paramString) {}
    
    public void e(String paramString) {}
    
    public void f(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null)) {
        return;
      }
      RoutePlanSearch.b(RoutePlanSearch.this).onGetDrivingRouteResult(h.b(paramString));
    }
    
    public void g(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null)) {
        return;
      }
      RoutePlanSearch.b(RoutePlanSearch.this).onGetWalkingRouteResult(h.c(paramString));
    }
    
    public void h(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null)) {
        return;
      }
      RoutePlanSearch.b(RoutePlanSearch.this).onGetTransitRouteResult(h.a(paramString));
    }
    
    public void i(String paramString)
    {
      if ((RoutePlanSearch.a(RoutePlanSearch.this)) || (paramString == null) || (paramString.length() == 0) || (RoutePlanSearch.b(RoutePlanSearch.this) == null)) {
        return;
      }
      RoutePlanSearch.b(RoutePlanSearch.this).onGetBikingRouteResult(h.d(paramString));
    }
    
    public void j(String paramString) {}
    
    public void k(String paramString) {}
    
    public void l(String paramString) {}
    
    public void m(String paramString) {}
    
    public void n(String paramString) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/RoutePlanSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */