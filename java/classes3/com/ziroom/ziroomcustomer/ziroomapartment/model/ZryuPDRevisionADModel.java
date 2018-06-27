package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuPDRevisionADModel
  extends b
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<ZraDetailAdBean> zra_detail_ad;
    
    public static class ZraDetailAdBean
    {
      public String app;
      public String description;
      public String img;
      public String target;
      public String title;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuPDRevisionADModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */