package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuProjectListModel
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
    public int htAcc;
    public String ifSearchSuc;
    public int projectAcc;
    public List<ProjectListBean> projectList;
    public String searchFailMsg;
    
    public static class ProjectListBean
    {
      public List<HouseTypeListBean> houseTypeList;
      public String projectAddr;
      public String projectId;
      public String projectImgUrl;
      public String projectMinPrice;
      public String projectName;
      
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuProjectListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */