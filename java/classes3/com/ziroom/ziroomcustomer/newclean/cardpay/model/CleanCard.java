package com.ziroom.ziroomcustomer.newclean.cardpay.model;

import java.io.Serializable;

public class CleanCard
  implements Serializable
{
  private String cardName;
  private String cardNumber;
  private int cardState;
  private String cardStateValue;
  private String cardStyleNote;
  private String cardStyleUrl;
  private String endTime;
  private String remainAmount;
  private String totalAmount;
  
  public String getCardName()
  {
    return this.cardName;
  }
  
  public String getCardNumber()
  {
    return this.cardNumber;
  }
  
  public int getCardState()
  {
    return this.cardState;
  }
  
  public String getCardStateValue()
  {
    return this.cardStateValue;
  }
  
  public String getCardStyleNote()
  {
    return this.cardStyleNote;
  }
  
  public String getCardStyleUrl()
  {
    return this.cardStyleUrl;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public String getRemainAmount()
  {
    return this.remainAmount;
  }
  
  public String getTotalAmount()
  {
    return this.totalAmount;
  }
  
  public void setCardName(String paramString)
  {
    this.cardName = paramString;
  }
  
  public void setCardNumber(String paramString)
  {
    this.cardNumber = paramString;
  }
  
  public void setCardState(int paramInt)
  {
    this.cardState = paramInt;
  }
  
  public void setCardStateValue(String paramString)
  {
    this.cardStateValue = paramString;
  }
  
  public void setCardStyleNote(String paramString)
  {
    this.cardStyleNote = paramString;
  }
  
  public void setCardStyleUrl(String paramString)
  {
    this.cardStyleUrl = paramString;
  }
  
  public void setEndTime(String paramString)
  {
    this.endTime = paramString;
  }
  
  public void setRemainAmount(String paramString)
  {
    this.remainAmount = paramString;
  }
  
  public void setTotalAmount(String paramString)
  {
    this.totalAmount = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/model/CleanCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */