package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class RegionBean
{
  List<CityBean> cityList;
  String province;
  
  public List<CityBean> getCityList()
  {
    return this.cityList;
  }
  
  public String getProvince()
  {
    return this.province;
  }
  
  public void setCityList(List<CityBean> paramList)
  {
    this.cityList = paramList;
  }
  
  public void setProvince(String paramString)
  {
    this.province = paramString;
  }
  
  public static class CityBean
  {
    String cityName;
    List<RegionBean.DistrictBean> districtList;
    
    public String getCityName()
    {
      return this.cityName;
    }
    
    public List<RegionBean.DistrictBean> getDistrictList()
    {
      return this.districtList;
    }
    
    public void setCityName(String paramString)
    {
      this.cityName = paramString;
    }
    
    public void setDistrictList(List<RegionBean.DistrictBean> paramList)
    {
      this.districtList = paramList;
    }
  }
  
  public static class DistrictBean
  {
    String districtName;
    
    public String getDistrictName()
    {
      return this.districtName;
    }
    
    public void setDistrictName(String paramString)
    {
      this.districtName = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/RegionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */