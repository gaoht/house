package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.HouseBedListBean;
import java.util.List;

public class HouseGroupListBean
{
  private List<HouseBedListBean> houseBedList;
  private String houseGroupTitle;
  private String roomFid;
  
  public List<HouseBedListBean> getHouseBedList()
  {
    return this.houseBedList;
  }
  
  public String getHouseGroupTitle()
  {
    return this.houseGroupTitle;
  }
  
  public String getRoomFid()
  {
    return this.roomFid;
  }
  
  public void setHouseBedList(List<HouseBedListBean> paramList)
  {
    this.houseBedList = paramList;
  }
  
  public void setHouseGroupTitle(String paramString)
  {
    this.houseGroupTitle = paramString;
  }
  
  public void setRoomFid(String paramString)
  {
    this.roomFid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/HouseGroupListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */