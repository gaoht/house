package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class GiftList
  implements Serializable
{
  private String giftNote;
  private String isHaveGift;
  private String payWay;
  
  public String getGiftNote()
  {
    return this.giftNote;
  }
  
  public String getIsHaveGift()
  {
    return this.isHaveGift;
  }
  
  public String getPayWay()
  {
    return this.payWay;
  }
  
  public void setGiftNote(String paramString)
  {
    this.giftNote = paramString;
  }
  
  public void setIsHaveGift(String paramString)
  {
    this.isHaveGift = paramString;
  }
  
  public void setPayWay(String paramString)
  {
    this.payWay = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/GiftList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */