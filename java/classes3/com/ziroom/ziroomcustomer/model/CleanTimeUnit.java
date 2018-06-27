package com.ziroom.ziroomcustomer.model;

public class CleanTimeUnit
{
  private CleanPriceUnit drugItem;
  private CleanPriceUnit normalItem;
  private int timeLength;
  
  public CleanTimeUnit() {}
  
  public CleanTimeUnit(int paramInt, CleanPriceUnit paramCleanPriceUnit1, CleanPriceUnit paramCleanPriceUnit2)
  {
    this.timeLength = paramInt;
    this.drugItem = paramCleanPriceUnit1;
    this.normalItem = paramCleanPriceUnit2;
  }
  
  public CleanPriceUnit getDrugItem()
  {
    return this.drugItem;
  }
  
  public CleanPriceUnit getNormalItem()
  {
    return this.normalItem;
  }
  
  public int getTimeLength()
  {
    return this.timeLength;
  }
  
  public void setDrugItem(CleanPriceUnit paramCleanPriceUnit)
  {
    this.drugItem = paramCleanPriceUnit;
  }
  
  public void setNormalItem(CleanPriceUnit paramCleanPriceUnit)
  {
    this.normalItem = paramCleanPriceUnit;
  }
  
  public void setTimeLength(int paramInt)
  {
    this.timeLength = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanTimeUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */