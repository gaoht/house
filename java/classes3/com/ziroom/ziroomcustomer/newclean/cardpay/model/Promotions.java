package com.ziroom.ziroomcustomer.newclean.cardpay.model;

import java.io.Serializable;

public class Promotions
  implements Serializable
{
  private int endMonth;
  private String promotionTypeName;
  private int sendCount;
  private String sendPrice;
  
  public int getEndMonth()
  {
    return this.endMonth;
  }
  
  public String getPromotionTypeName()
  {
    return this.promotionTypeName;
  }
  
  public int getSendCount()
  {
    return this.sendCount;
  }
  
  public String getSendPrice()
  {
    return this.sendPrice;
  }
  
  public void setEndMonth(int paramInt)
  {
    this.endMonth = paramInt;
  }
  
  public void setPromotionTypeName(String paramString)
  {
    this.promotionTypeName = paramString;
  }
  
  public void setSendCount(int paramInt)
  {
    this.sendCount = paramInt;
  }
  
  public void setSendPrice(String paramString)
  {
    this.sendPrice = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/model/Promotions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */