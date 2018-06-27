package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;

public class MHFloorsFee
  implements Serializable
{
  private int elevator;
  private int floors;
  private double floorsFee;
  private String floorsFeeDescribe;
  private String floorsFeeId;
  private String serviceInfoId;
  private String xmid;
  
  public int getElevator()
  {
    return this.elevator;
  }
  
  public int getFloors()
  {
    return this.floors;
  }
  
  public double getFloorsFee()
  {
    return this.floorsFee;
  }
  
  public String getFloorsFeeDescribe()
  {
    return this.floorsFeeDescribe;
  }
  
  public String getFloorsFeeId()
  {
    return this.floorsFeeId;
  }
  
  public String getServiceInfoId()
  {
    return this.serviceInfoId;
  }
  
  public String getXmid()
  {
    return this.xmid;
  }
  
  public void setElevator(int paramInt)
  {
    this.elevator = paramInt;
  }
  
  public void setFloors(int paramInt)
  {
    this.floors = paramInt;
  }
  
  public void setFloorsFee(double paramDouble)
  {
    this.floorsFee = paramDouble;
  }
  
  public void setFloorsFeeDescribe(String paramString)
  {
    this.floorsFeeDescribe = paramString;
  }
  
  public void setFloorsFeeId(String paramString)
  {
    this.floorsFeeId = paramString;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.serviceInfoId = paramString;
  }
  
  public void setXmid(String paramString)
  {
    this.xmid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHFloorsFee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */