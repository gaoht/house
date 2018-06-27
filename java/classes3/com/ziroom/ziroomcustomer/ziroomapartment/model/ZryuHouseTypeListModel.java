package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuHouseTypeListModel
  extends b
{
  public DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
  {
    public String fPanoramicUrl;
    public List<HouseTypeListBean> houseTypeList;
    public String ifSearchSuc;
    public String projectAddr;
    public String projectAroundName;
    public String projectAroundUrl;
    public String projectId;
    public List<String> projectImgUrl;
    public double projectLat;
    public double projectLong;
    public String projectMinPrice;
    public String projectName;
    public String projectPhone;
    public String projectShareUrl;
    public String searchFailMsg;
    
    public String getProjectId()
    {
      return this.projectId;
    }
    
    public String getProjectName()
    {
      return this.projectName;
    }
    
    public void setProjectId(String paramString)
    {
      this.projectId = paramString;
    }
    
    public void setProjectName(String paramString)
    {
      this.projectName = paramString;
    }
    
    public static class HouseTypeListBean
    {
      public String htArea;
      public int htAvaRoomAcc;
      public String htId;
      public String htImgUrl;
      public String htMaxPrice;
      public String htMinPrice;
      public String htName;
      public int isRoomful;
      public String roomFulTag;
      public String[] roomTags;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuHouseTypeListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */