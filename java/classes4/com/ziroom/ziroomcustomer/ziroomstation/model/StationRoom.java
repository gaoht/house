package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class StationRoom
  extends b
{
  public List<DataBean> data;
  
  public static class DataBean
  {
    public int availableCount;
    public int bedCount;
    public String bedTypeName;
    public double houseArea;
    public String houseShowName;
    public String houseTypeBid;
    public String imgUrl;
    public int isValid;
    public double maxPrice;
    public double minPrice;
    public List<PriceBean> price;
    public int usedCount;
    
    public static class PriceBean
    {
      public String perDate;
      public double price;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */