package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import java.io.Serializable;

public class HouseFacilityGroupBean
  implements Serializable
{
  private FacilitiesListBean facilitiesList;
  private String name;
  
  public FacilitiesListBean getFacilitiesList()
  {
    return this.facilitiesList;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setFacilitiesList(FacilitiesListBean paramFacilitiesListBean)
  {
    this.facilitiesList = paramFacilitiesListBean;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/HouseFacilityGroupBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */