package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo;

import java.io.Serializable;

public class AloneRoomNameBean
  implements Serializable
{
  private String auditMsg;
  private boolean isEdit;
  private String value;
  
  public String getAuditMsg()
  {
    return this.auditMsg;
  }
  
  public String getValue()
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
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/aloneroominfo/AloneRoomNameBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */