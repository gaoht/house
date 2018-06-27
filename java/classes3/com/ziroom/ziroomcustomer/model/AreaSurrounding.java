package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class AreaSurrounding
{
  private List<SurroundingBusiness> business;
  private List<SurroundingFacility> surround;
  
  public List<SurroundingBusiness> getBusiness()
  {
    return this.business;
  }
  
  public List<SurroundingFacility> getSurround()
  {
    return this.surround;
  }
  
  public void setBusiness(List<SurroundingBusiness> paramList)
  {
    this.business = paramList;
  }
  
  public void setSurround(List<SurroundingFacility> paramList)
  {
    this.surround = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AreaSurrounding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */