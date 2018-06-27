package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DaysPrice
  implements Serializable
{
  public Date dayDate;
  public List<TypePrice> typePriceList;
  
  public String toString()
  {
    return "DaysPrice{dayDate=" + this.dayDate + ", typePriceList=" + this.typePriceList + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/DaysPrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */