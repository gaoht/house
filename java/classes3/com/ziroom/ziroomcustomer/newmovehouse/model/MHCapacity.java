package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;

public class MHCapacity
  implements Serializable
{
  private int capacityTotalNum;
  private String remark;
  private int spareCapacityNum;
  private int useCapacityNum;
  
  public MHCapacity() {}
  
  public MHCapacity(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.capacityTotalNum = paramInt1;
    this.useCapacityNum = paramInt2;
    this.spareCapacityNum = paramInt3;
    this.remark = paramString;
  }
  
  public int getCapacityTotalNum()
  {
    return this.capacityTotalNum;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public int getSpareCapacityNum()
  {
    return this.spareCapacityNum;
  }
  
  public int getUseCapacityNum()
  {
    return this.useCapacityNum;
  }
  
  public void setCapacityTotalNum(int paramInt)
  {
    this.capacityTotalNum = paramInt;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setSpareCapacityNum(int paramInt)
  {
    this.spareCapacityNum = paramInt;
  }
  
  public void setUseCapacityNum(int paramInt)
  {
    this.useCapacityNum = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHCapacity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */