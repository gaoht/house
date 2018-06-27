package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.util.List;

public class ZryuSignDelivery
{
  private Integer hasSharer;
  private Integer isPay;
  private List<ZryuSignDeliveryItem> list;
  private String tipMsg;
  
  public Integer getHasSharer()
  {
    return this.hasSharer;
  }
  
  public Integer getIsPay()
  {
    return this.isPay;
  }
  
  public List<ZryuSignDeliveryItem> getList()
  {
    return this.list;
  }
  
  public String getTipMsg()
  {
    return this.tipMsg;
  }
  
  public void setHasSharer(Integer paramInteger)
  {
    this.hasSharer = paramInteger;
  }
  
  public void setIsPay(Integer paramInteger)
  {
    this.isPay = paramInteger;
  }
  
  public void setList(List<ZryuSignDeliveryItem> paramList)
  {
    this.list = paramList;
  }
  
  public void setTipMsg(String paramString)
  {
    this.tipMsg = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignDelivery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */