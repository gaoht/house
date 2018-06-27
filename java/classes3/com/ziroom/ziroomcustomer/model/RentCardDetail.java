package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class RentCardDetail
  implements Serializable
{
  private String cardCode;
  private float cardValue;
  private String drawDate;
  private String expireDate;
  private int isCheck;
  private String rentCardDescription;
  private String rentCardId;
  private String rentCardName;
  private String useDate;
  
  public String getCardCode()
  {
    return this.cardCode;
  }
  
  public float getCardValue()
  {
    return this.cardValue;
  }
  
  public String getDrawDate()
  {
    return this.drawDate;
  }
  
  public String getExpireDate()
  {
    return this.expireDate;
  }
  
  public int getIsCheck()
  {
    return this.isCheck;
  }
  
  public String getRentCardDescription()
  {
    return this.rentCardDescription;
  }
  
  public String getRentCardId()
  {
    return this.rentCardId;
  }
  
  public String getRentCardName()
  {
    return this.rentCardName;
  }
  
  public String getUseDate()
  {
    return this.useDate;
  }
  
  public void setCardCode(String paramString)
  {
    this.cardCode = paramString;
  }
  
  public void setCardValue(float paramFloat)
  {
    this.cardValue = paramFloat;
  }
  
  public void setDrawDate(String paramString)
  {
    this.drawDate = paramString;
  }
  
  public void setExpireDate(String paramString)
  {
    this.expireDate = paramString;
  }
  
  public void setIsCheck(int paramInt)
  {
    this.isCheck = paramInt;
  }
  
  public void setRentCardDescription(String paramString)
  {
    this.rentCardDescription = paramString;
  }
  
  public void setRentCardId(String paramString)
  {
    this.rentCardId = paramString;
  }
  
  public void setRentCardName(String paramString)
  {
    this.rentCardName = paramString;
  }
  
  public void setUseDate(String paramString)
  {
    this.useDate = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/RentCardDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */