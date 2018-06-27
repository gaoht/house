package com.ziroom.ziroomcustomer.minsu.searchlist.a;

import android.app.Activity;
import android.content.Context;
import com.freelxl.baselibrary.d.f.d;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.LocationInfoBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean;

public class a
{
  private static a b;
  private static final Object c = new Object();
  final b a;
  
  private a(b paramb)
  {
    this.a = paramb;
  }
  
  public static a getInstance(b paramb)
  {
    if (b == null) {}
    synchronized (c)
    {
      if (b == null) {
        b = new a(paramb);
      }
      return b;
    }
  }
  
  public void cancelCollectHouse(final Object paramObject, Activity paramActivity, MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.cancelCollectHouse(paramActivity, paramListBean.fid, paramListBean.rentWay, new s(paramActivity, new r(MinsuHouseCancelCollectResultBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("cancel_collect_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseCancelCollectResultBean paramAnonymousMinsuHouseCancelCollectResultBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseCancelCollectResultBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("cancel_collect_house", paramAnonymousMinsuHouseCancelCollectResultBean), paramObject);
      }
    });
  }
  
  public void collectHouse(final Object paramObject, Activity paramActivity, MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.collectHouse(paramActivity, paramListBean.fid, paramListBean.rentWay, new s(paramActivity, new r(MinsuHouseCollectResultBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("collect_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseCollectResultBean paramAnonymousMinsuHouseCollectResultBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseCollectResultBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("collect_house", paramAnonymousMinsuHouseCollectResultBean), paramObject);
      }
    });
  }
  
  public void getLocationInfo(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLocationInfo(paramActivity, new com.ziroom.commonlibrary.a.a(paramActivity, new d(LocationInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("location_info_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LocationInfoBean paramAnonymousLocationInfoBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLocationInfoBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("location_info", paramAnonymousLocationInfoBean), paramObject);
      }
    });
  }
  
  public void getMinsuHistory(final Activity paramActivity, String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.BrowsingHistory(paramActivity, paramString, new t(paramActivity, new d(MinsuHouseBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("browsing_history_error", paramAnonymousThrowable.getMessage()), paramActivity);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseBean paramAnonymousMinsuHouseBean)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("browsing_history", paramAnonymousMinsuHouseBean), paramActivity);
      }
    });
  }
  
  public void queryMinsuList(final Object paramObject, Activity paramActivity, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.queryMinsu(paramActivity, paramInt, new com.ziroom.commonlibrary.a.a(paramActivity, new d(MinsuHouseBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("minsu_query_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseBean paramAnonymousMinsuHouseBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("minsu_query", paramAnonymousMinsuHouseBean), paramObject);
      }
    });
  }
  
  public void queryStationList(final Object paramObject, Activity paramActivity, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.queryStation(paramActivity, paramInt, new com.ziroom.commonlibrary.a.a(paramActivity, new d(StationSearchListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("zry_query_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, StationSearchListBean paramAnonymousStationSearchListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousStationSearchListBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("zry_query", paramAnonymousStationSearchListBean), paramObject);
      }
    });
  }
  
  public void queryStrategyList(final Object paramObject, Activity paramActivity, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.queryStrategy(paramActivity, paramInt, new com.ziroom.commonlibrary.a.a(paramActivity, new d(StrategySearchListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("strategy_query_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, StrategySearchListBean paramAnonymousStrategySearchListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousStrategySearchListBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("strategy_query", paramAnonymousStrategySearchListBean), paramObject);
      }
    });
  }
  
  public void queryStrategyListFromStation(final Object paramObject, Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.queryStrategyFromStation(paramActivity, paramInt, paramString1, paramString2, new com.ziroom.commonlibrary.a.a(paramActivity, new d(StrategySearchListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("strategy_query_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, StrategySearchListBean paramAnonymousStrategySearchListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousStrategySearchListBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("strategy_query", paramAnonymousStrategySearchListBean), paramObject);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */