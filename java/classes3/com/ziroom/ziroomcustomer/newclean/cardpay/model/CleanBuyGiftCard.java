package com.ziroom.ziroomcustomer.newclean.cardpay.model;

import java.util.List;

public class CleanBuyGiftCard
{
  private List<CardStylesBean> cardStyles;
  private String defaultStyleNote;
  private String defaultStyleUrl;
  private String tips;
  private List<ValueCardTypesBean> valueCardTypes;
  
  public List<CardStylesBean> getCardStyles()
  {
    return this.cardStyles;
  }
  
  public String getDefaultStyleNote()
  {
    return this.defaultStyleNote;
  }
  
  public String getDefaultStyleUrl()
  {
    return this.defaultStyleUrl;
  }
  
  public String getTips()
  {
    return this.tips;
  }
  
  public List<ValueCardTypesBean> getValueCardTypes()
  {
    return this.valueCardTypes;
  }
  
  public void setCardStyles(List<CardStylesBean> paramList)
  {
    this.cardStyles = paramList;
  }
  
  public void setDefaultStyleNote(String paramString)
  {
    this.defaultStyleNote = paramString;
  }
  
  public void setDefaultStyleUrl(String paramString)
  {
    this.defaultStyleUrl = paramString;
  }
  
  public void setTips(String paramString)
  {
    this.tips = paramString;
  }
  
  public void setValueCardTypes(List<ValueCardTypesBean> paramList)
  {
    this.valueCardTypes = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/model/CleanBuyGiftCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */