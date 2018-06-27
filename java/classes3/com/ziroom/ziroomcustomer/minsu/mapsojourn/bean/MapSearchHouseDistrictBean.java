package com.ziroom.ziroomcustomer.minsu.mapsojourn.bean;

import java.util.List;

public class MapSearchHouseDistrictBean
{
  private String code;
  private DataBean data;
  private String message;
  private String status;
  
  public String getCode()
  {
    return this.code;
  }
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private List<MinsuMapDistrictBean> mapSearchHouseVoList;
    
    public List<MinsuMapDistrictBean> getMapSearchHouseVoList()
    {
      return this.mapSearchHouseVoList;
    }
    
    public void setMapSearchHouseVoList(List<MinsuMapDistrictBean> paramList)
    {
      this.mapSearchHouseVoList = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/bean/MapSearchHouseDistrictBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */