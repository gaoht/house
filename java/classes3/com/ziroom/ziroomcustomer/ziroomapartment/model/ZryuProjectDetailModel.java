package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuProjectDetailModel
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
    public String briefInfo;
    public List<HouseTypeListBean> houseTypeList;
    public double lat;
    public double lng;
    public String maxPrice;
    public String minPrice;
    public String panoramicUrl;
    public String peripheralUrl;
    public String proAddr;
    public String proHeadPic;
    public String proId;
    public String proName;
    public String shareUrl;
    public String slogan;
    public String telePhone;
    public List<TopPicListBean> topPicList;
    public List<String> trafficList;
    public String zoServiceDesc;
    public String zodesc;
    public String zourl;
    public ZspaceDtoBean zspaceDto;
    
    public static class HouseTypeListBean
    {
      public double htArea;
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
    
    public static class TopPicListBean
    {
      public String label;
      public List<String> picURL;
    }
    
    public static class ZspaceDtoBean
    {
      public String description;
      public List<PicListBean> picList;
      
      public static class PicListBean
      {
        public String picDes;
        public String picUrl;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuProjectDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */