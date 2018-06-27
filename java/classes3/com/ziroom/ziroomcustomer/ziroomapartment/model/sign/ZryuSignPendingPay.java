package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.util.List;

public class ZryuSignPendingPay
{
  private List<ZryuSignPendingPayItem> lifeBillList;
  private List<ZryuSignPendingPayItem> roomRentList;
  
  public List<ZryuSignPendingPayItem> getLifeBillList()
  {
    return this.lifeBillList;
  }
  
  public List<ZryuSignPendingPayItem> getRoomRentList()
  {
    return this.roomRentList;
  }
  
  public void setLifeBillList(List<ZryuSignPendingPayItem> paramList)
  {
    this.lifeBillList = paramList;
  }
  
  public void setRoomRentList(List<ZryuSignPendingPayItem> paramList)
  {
    this.roomRentList = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignPendingPay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */