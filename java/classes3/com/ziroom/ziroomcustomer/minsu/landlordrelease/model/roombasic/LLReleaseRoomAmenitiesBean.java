package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic;

import java.io.Serializable;
import java.util.List;

public class LLReleaseRoomAmenitiesBean
  implements Serializable
{
  private List<FacilitiesChildDataBean> childList;
  private String groupTitle;
  
  public List<FacilitiesChildDataBean> getChildList()
  {
    return this.childList;
  }
  
  public String getGroupTitle()
  {
    return this.groupTitle;
  }
  
  public void setChildList(List<FacilitiesChildDataBean> paramList)
  {
    this.childList = paramList;
  }
  
  public void setGroupTitle(String paramString)
  {
    this.groupTitle = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/roombasic/LLReleaseRoomAmenitiesBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */