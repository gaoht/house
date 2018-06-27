package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class MoveOrderProgress
  implements Serializable
{
  private List<MoveProgressDetail> details;
  private Master master;
  
  public List<MoveProgressDetail> getDetails()
  {
    return this.details;
  }
  
  public Master getMaster()
  {
    return this.master;
  }
  
  public void setDetails(List<MoveProgressDetail> paramList)
  {
    this.details = paramList;
  }
  
  public void setMaster(Master paramMaster)
  {
    this.master = paramMaster;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MoveOrderProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */