package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.util.List;

public class ZryuSignDeliveryLifeFeeItems
{
  private List<ZryuSignDeliveryLifeFeeItem> feeList;
  private Integer isPay;
  private Integer payMoney;
  
  public List<ZryuSignDeliveryLifeFeeItem> getFeeList()
  {
    return this.feeList;
  }
  
  public Integer getIsPay()
  {
    return this.isPay;
  }
  
  public Integer getPayMoney()
  {
    return this.payMoney;
  }
  
  public void setFeeList(List<ZryuSignDeliveryLifeFeeItem> paramList)
  {
    this.feeList = paramList;
  }
  
  public void setIsPay(Integer paramInteger)
  {
    this.isPay = paramInteger;
  }
  
  public void setPayMoney(Integer paramInteger)
  {
    this.payMoney = paramInteger;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignDeliveryLifeFeeItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */