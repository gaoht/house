package com.ziroom.ziroomcustomer.newclean.cardpay.model;

public class CardStylesBean
{
  private String cardStyleNote;
  private String cardStyleUrl;
  private Boolean isSelected = Boolean.valueOf(false);
  
  public String getCardStyleNote()
  {
    return this.cardStyleNote;
  }
  
  public String getCardStyleUrl()
  {
    return this.cardStyleUrl;
  }
  
  public Boolean getSelected()
  {
    return this.isSelected;
  }
  
  public void setCardStyleNote(String paramString)
  {
    this.cardStyleNote = paramString;
  }
  
  public void setCardStyleUrl(String paramString)
  {
    this.cardStyleUrl = paramString;
  }
  
  public void setSelected(Boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/model/CardStylesBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */