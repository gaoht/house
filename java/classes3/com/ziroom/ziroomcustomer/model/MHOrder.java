package com.ziroom.ziroomcustomer.model;

public class MHOrder
{
  private int distance;
  private String itemId;
  private String ladder;
  private String price;
  private String rule;
  private String type;
  
  public MHOrder() {}
  
  public MHOrder(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.distance = paramInt;
    this.price = paramString1;
    this.ladder = paramString2;
    this.rule = paramString3;
    this.type = paramString4;
  }
  
  public int getDistance()
  {
    return this.distance;
  }
  
  public String getItemId()
  {
    return this.itemId;
  }
  
  public String getLadder()
  {
    return this.ladder;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getRule()
  {
    return this.rule;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setDistance(int paramInt)
  {
    this.distance = paramInt;
  }
  
  public void setItemId(String paramString)
  {
    this.itemId = paramString;
  }
  
  public void setLadder(String paramString)
  {
    this.ladder = paramString;
  }
  
  public void setPrice(String paramString)
  {
    this.price = paramString;
  }
  
  public void setRule(String paramString)
  {
    this.rule = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MHOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */