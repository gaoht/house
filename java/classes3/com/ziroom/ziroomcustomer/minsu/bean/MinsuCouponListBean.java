package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuCouponListBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<ListBean> list;
    public int total;
    
    public static class ListBean
    {
      public String businessLineName;
      public String businessLineType;
      public String cardId;
      public String cardName;
      public String descrption;
      public String endDate;
      public String price;
      public String startDate;
      public int state;
      public String subtitle;
      public String title;
      public String unit;
      public String unitDes;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCouponListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */