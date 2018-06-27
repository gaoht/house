package com.ziroom.ziroomcustomer.minsu.searchlist.c;

import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.LocationInfoBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean;

public class a
  extends c
{
  private StationSearchListBean b;
  private StrategySearchListBean c;
  private MinsuHouseBean d;
  private MinsuHouseBean e;
  private MinsuHouseCollectResultBean f;
  private MinsuHouseCancelCollectResultBean g;
  private LocationInfoBean h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  
  public a() {}
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public String getCancelCollectResultMsg()
  {
    return this.n;
  }
  
  public String getHistoryErrMsg()
  {
    return this.l;
  }
  
  public LocationInfoBean getLocationInfoBean()
  {
    return this.h;
  }
  
  public String getLocationInfoErrorMsg()
  {
    return this.o;
  }
  
  public MinsuHouseCancelCollectResultBean getMinsuCancelCollectResultBean()
  {
    return this.g;
  }
  
  public String getMinsuCollectResultErrMsg()
  {
    return this.m;
  }
  
  public MinsuHouseBean getMinsuHistoryHouseBean()
  {
    return this.e;
  }
  
  public MinsuHouseBean getMinsuHouseBean()
  {
    return this.d;
  }
  
  public MinsuHouseCollectResultBean getMinsuHouseCollectResultBean()
  {
    return this.f;
  }
  
  public String getMinsuHouseErrMsg()
  {
    return this.k;
  }
  
  public StationSearchListBean getStationSearchListBean()
  {
    return this.b;
  }
  
  public String getStationSearchListErrMsg()
  {
    return this.i;
  }
  
  public StrategySearchListBean getStrategySearchListBean()
  {
    return this.c;
  }
  
  public String getStrategySearchListErrMsg()
  {
    return this.j;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    String str = parama.getType();
    int i1 = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    for (;;)
    {
      a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
      return;
      if (!str.equals("zry_query")) {
        break;
      }
      i1 = 0;
      break;
      if (!str.equals("strategy_query")) {
        break;
      }
      i1 = 1;
      break;
      if (!str.equals("minsu_query")) {
        break;
      }
      i1 = 2;
      break;
      if (!str.equals("browsing_history")) {
        break;
      }
      i1 = 3;
      break;
      if (!str.equals("collect_house")) {
        break;
      }
      i1 = 4;
      break;
      if (!str.equals("cancel_collect_house")) {
        break;
      }
      i1 = 5;
      break;
      if (!str.equals("location_info")) {
        break;
      }
      i1 = 6;
      break;
      if (!str.equals("zry_query_error")) {
        break;
      }
      i1 = 7;
      break;
      if (!str.equals("strategy_query_error")) {
        break;
      }
      i1 = 8;
      break;
      if (!str.equals("minsu_query_error")) {
        break;
      }
      i1 = 9;
      break;
      if (!str.equals("browsing_history_error")) {
        break;
      }
      i1 = 10;
      break;
      if (!str.equals("collect_house_error")) {
        break;
      }
      i1 = 11;
      break;
      if (!str.equals("cancel_collect_house_error")) {
        break;
      }
      i1 = 12;
      break;
      if (!str.equals("location_info_error")) {
        break;
      }
      i1 = 13;
      break;
      this.b = ((StationSearchListBean)parama.getData());
      continue;
      this.c = ((StrategySearchListBean)parama.getData());
      continue;
      this.d = ((MinsuHouseBean)parama.getData());
      this.e = ((MinsuHouseBean)parama.getData());
      continue;
      this.f = ((MinsuHouseCollectResultBean)parama.getData());
      continue;
      this.g = ((MinsuHouseCancelCollectResultBean)parama.getData());
      continue;
      this.h = ((LocationInfoBean)parama.getData());
      continue;
      this.i = ((String)parama.getData());
      continue;
      this.j = ((String)parama.getData());
      continue;
      this.k = ((String)parama.getData());
      this.l = ((String)parama.getData());
      continue;
      this.m = ((String)parama.getData());
      continue;
      this.n = ((String)parama.getData());
      continue;
      this.o = ((String)parama.getData());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */