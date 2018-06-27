package com.ziroom.ziroomcustomer.model;

public class OrderInfo
{
  private String _package;
  private int card_values;
  private int current_money;
  private String merorder_id;
  private String partnerid;
  private String sign;
  private String timestamp;
  private String trans_id;
  
  public int getCard_values()
  {
    return this.card_values;
  }
  
  public int getCurrent_money()
  {
    return this.current_money;
  }
  
  public String getMerorder_id()
  {
    return this.merorder_id;
  }
  
  public String getPartnerid()
  {
    return this.partnerid;
  }
  
  public String getSign()
  {
    return this.sign;
  }
  
  public String getTimestamp()
  {
    return this.timestamp;
  }
  
  public String getTrans_id()
  {
    return this.trans_id;
  }
  
  public String get_package()
  {
    return this._package;
  }
  
  public void setCard_values(int paramInt)
  {
    this.card_values = paramInt;
  }
  
  public void setCurrent_money(int paramInt)
  {
    this.current_money = paramInt;
  }
  
  public void setMerorder_id(String paramString)
  {
    this.merorder_id = paramString;
  }
  
  public void setPartnerid(String paramString)
  {
    this.partnerid = paramString;
  }
  
  public void setSign(String paramString)
  {
    this.sign = paramString;
  }
  
  public void setTimestamp(String paramString)
  {
    this.timestamp = paramString;
  }
  
  public void setTrans_id(String paramString)
  {
    this.trans_id = paramString;
  }
  
  public void set_package(String paramString)
  {
    this._package = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/OrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */