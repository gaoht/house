package com.ziroom.ziroomcustomer.newclean.cardpay.model;

import java.io.Serializable;
import java.util.List;

public class CanBuyCard
  implements Serializable
{
  private int cid;
  private Long giftCount;
  private String label;
  private Long promotionCodeCount;
  private String rechargeAmount;
  private Long saleAmount;
  private Long showGiftAmount;
  private String showName;
  private String typeName;
  private List<Promotions> typePromotions;
  private int validMonth;
  
  public int getCid()
  {
    return this.cid;
  }
  
  public Long getGiftCount()
  {
    return this.giftCount;
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public Long getPromotionCodeCount()
  {
    return this.promotionCodeCount;
  }
  
  public String getRechargeAmount()
  {
    return this.rechargeAmount;
  }
  
  public Long getSaleAmount()
  {
    return this.saleAmount;
  }
  
  public Long getShowGiftAmount()
  {
    return this.showGiftAmount;
  }
  
  public String getShowName()
  {
    return this.showName;
  }
  
  public String getTypeName()
  {
    return this.typeName;
  }
  
  public List<Promotions> getTypePromotions()
  {
    return this.typePromotions;
  }
  
  public int getValidMonth()
  {
    return this.validMonth;
  }
  
  public void setCid(int paramInt)
  {
    this.cid = paramInt;
  }
  
  public void setGiftCount(Long paramLong)
  {
    this.giftCount = paramLong;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setPromotionCodeCount(Long paramLong)
  {
    this.promotionCodeCount = paramLong;
  }
  
  public void setRechargeAmount(String paramString)
  {
    this.rechargeAmount = paramString;
  }
  
  public void setSaleAmount(Long paramLong)
  {
    this.saleAmount = paramLong;
  }
  
  public void setShowGiftAmount(Long paramLong)
  {
    this.showGiftAmount = paramLong;
  }
  
  public void setShowName(String paramString)
  {
    this.showName = paramString;
  }
  
  public void setTypeName(String paramString)
  {
    this.typeName = paramString;
  }
  
  public void setTypePromotions(List<Promotions> paramList)
  {
    this.typePromotions = paramList;
  }
  
  public void setValidMonth(int paramInt)
  {
    this.validMonth = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/model/CanBuyCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */