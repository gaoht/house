package com.ziroom.ziroomcustomer.minsu.mapsojourn.bean;

import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean.DataBean.ListBean;
import java.io.Serializable;

public class ZryMapItembean
  implements Serializable
{
  public String areaName;
  public String cityName;
  public int evaluateCount;
  public float evaluateScore;
  public int houseModelCount;
  public String latitude;
  public String longitude;
  public int maxPrice;
  public int minPrice;
  public String picUrl;
  public String projectBid;
  public String projectName;
  public int status;
  
  public StationSearchListBean.DataBean.ListBean convertListBean()
  {
    StationSearchListBean.DataBean.ListBean localListBean = new StationSearchListBean.DataBean.ListBean();
    localListBean.setProjectBid(this.projectBid);
    localListBean.setProjectName(this.projectName);
    localListBean.setCityName(this.cityName);
    localListBean.setAreaName(this.areaName);
    localListBean.setHouseModelCount(this.houseModelCount);
    localListBean.setEvaluateCount(this.evaluateCount);
    localListBean.setEvaluateScore(this.evaluateScore);
    localListBean.setMinPrice(this.minPrice);
    localListBean.setMaxPrice(this.maxPrice);
    localListBean.setPicUrl(this.picUrl);
    localListBean.setStatus(this.status);
    return localListBean;
  }
  
  public ZryMapBuildBean convertZryMapBuildBean(boolean paramBoolean)
  {
    ZryMapBuildBean localZryMapBuildBean = new ZryMapBuildBean();
    try
    {
      localZryMapBuildBean.setLatitude(Double.valueOf(this.latitude).doubleValue());
      localZryMapBuildBean.setLongitude(Double.valueOf(this.longitude).doubleValue());
      localZryMapBuildBean.setMinPrice(Integer.valueOf(this.minPrice));
      localZryMapBuildBean.setMaxPrice(Integer.valueOf(this.maxPrice));
      localZryMapBuildBean.setProjectBid(this.projectBid);
      localZryMapBuildBean.setProjectName(this.projectName);
      localZryMapBuildBean.setValidLevel(paramBoolean);
      localZryMapBuildBean.setStatus(this.status);
      return localZryMapBuildBean;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/bean/ZryMapItembean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */