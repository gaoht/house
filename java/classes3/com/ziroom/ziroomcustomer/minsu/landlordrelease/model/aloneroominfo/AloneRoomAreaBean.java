package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo;

import java.io.Serializable;

public class AloneRoomAreaBean
  implements Serializable
{
  private String auditMsg;
  private boolean isEdit;
  private double value;
  
  public String getAuditMsg()
  {
    return this.auditMsg;
  }
  
  public double getValue()
  {
    return this.value;
  }
  
  public boolean isEdit()
  {
    return this.isEdit;
  }
  
  public void setAuditMsg(String paramString)
  {
    this.auditMsg = paramString;
  }
  
  public void setEdit(boolean paramBoolean)
  {
    this.isEdit = paramBoolean;
  }
  
  public void setValue(double paramDouble)
  {
    this.value = paramDouble;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/aloneroominfo/AloneRoomAreaBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */