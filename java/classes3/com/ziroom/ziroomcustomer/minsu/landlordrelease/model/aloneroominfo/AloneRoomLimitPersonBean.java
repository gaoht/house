package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo;

import java.io.Serializable;

public class AloneRoomLimitPersonBean
  implements Serializable
{
  private boolean isEdit;
  private int value;
  
  public int getValue()
  {
    return this.value;
  }
  
  public boolean isEdit()
  {
    return this.isEdit;
  }
  
  public void setEdit(boolean paramBoolean)
  {
    this.isEdit = paramBoolean;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/aloneroominfo/AloneRoomLimitPersonBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */