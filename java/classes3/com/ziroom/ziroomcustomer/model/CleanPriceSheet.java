package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class CleanPriceSheet
{
  private List<CleanTimeUnit> serviceList;
  private double unitCost;
  private double unitMedCost;
  
  public CleanPriceSheet() {}
  
  public CleanPriceSheet(List<CleanTimeUnit> paramList, double paramDouble1, double paramDouble2)
  {
    this.serviceList = paramList;
    this.unitCost = paramDouble1;
    this.unitMedCost = paramDouble2;
  }
  
  public List<CleanTimeUnit> getServiceList()
  {
    return this.serviceList;
  }
  
  public double getUnitCost()
  {
    return this.unitCost;
  }
  
  public double getUnitMedCost()
  {
    return this.unitMedCost;
  }
  
  public void setServiceList(List<CleanTimeUnit> paramList)
  {
    this.serviceList = paramList;
  }
  
  public void setUnitCost(double paramDouble)
  {
    this.unitCost = paramDouble;
  }
  
  public void setUnitMedCost(double paramDouble)
  {
    this.unitMedCost = paramDouble;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanPriceSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */