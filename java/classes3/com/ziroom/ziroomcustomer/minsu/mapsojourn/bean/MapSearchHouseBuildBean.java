package com.ziroom.ziroomcustomer.minsu.mapsojourn.bean;

import java.util.List;

public class MapSearchHouseBuildBean
{
  private DataBean data;
  private String message;
  private String status;
  
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
    private List<MinsuMapBuildBean> mapSearchHouseVoList;
    
    public List<MinsuMapBuildBean> getMapSearchHouseVoList()
    {
      return this.mapSearchHouseVoList;
    }
    
    public void setMapSearchHouseVoList(List<MinsuMapBuildBean> paramList)
    {
      this.mapSearchHouseVoList = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/bean/MapSearchHouseBuildBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */