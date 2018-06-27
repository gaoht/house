package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.util.List;

public class ZryuSignBillList
{
  private String contractCode;
  private String lifeFeeTip;
  private List<ZryuSignBillLiving> liftList;
  private List<ZryuSignBillRent> roomRentList;
  private String roomRentTip;
  private String systemId;
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getLifeFeeTip()
  {
    return this.lifeFeeTip;
  }
  
  public List<ZryuSignBillLiving> getLiftList()
  {
    return this.liftList;
  }
  
  public List<ZryuSignBillRent> getRoomRentList()
  {
    return this.roomRentList;
  }
  
  public String getRoomRentTip()
  {
    return this.roomRentTip;
  }
  
  public String getSystemId()
  {
    return this.systemId;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setLifeFeeTip(String paramString)
  {
    this.lifeFeeTip = paramString;
  }
  
  public void setLiftList(List<ZryuSignBillLiving> paramList)
  {
    this.liftList = paramList;
  }
  
  public void setRoomRentList(List<ZryuSignBillRent> paramList)
  {
    this.roomRentList = paramList;
  }
  
  public void setRoomRentTip(String paramString)
  {
    this.roomRentTip = paramString;
  }
  
  public void setSystemId(String paramString)
  {
    this.systemId = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignBillList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */