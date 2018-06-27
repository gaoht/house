package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class StationListModel
  extends b
{
  public List<DataBean> data;
  
  public static class DataBean
  {
    public double minPrice;
    public String projectAddress;
    public String projectBid;
    public String projectName;
    public String url;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */