package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import java.util.List;

public class LandlordFifthRoomBean
{
  public int maxNum;
  public int minNum;
  public List<LandlordFifthPicBean> picList;
  public int picType;
  public String picTypeName;
  public String roomFid;
  
  public static class LandlordFifthPicBean
  {
    public String houseBaseFid;
    public int isDefault;
    public String maxUrl;
    public String minUrl;
    public String picAuditMsg;
    public String picFid;
    public int picType;
    public String roomFid;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LandlordFifthRoomBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */