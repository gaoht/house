package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.FacilitiesListDataBean;
import java.util.List;

public class LandlordReleaseAmenitiesBean
  extends MinsuBaseJson
{
  private List<FacilitiesListDataBean> childList;
  private String groupTitle;
  
  public List<FacilitiesListDataBean> getChildList()
  {
    return this.childList;
  }
  
  public String getGroupTitle()
  {
    return this.groupTitle;
  }
  
  public void setChildList(List<FacilitiesListDataBean> paramList)
  {
    this.childList = paramList;
  }
  
  public void setGroupTitle(String paramString)
  {
    this.groupTitle = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LandlordReleaseAmenitiesBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */