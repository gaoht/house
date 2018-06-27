package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuNewNeedPayCouponBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public String toString()
  {
    return "MinsuNewNeedPayCouponBean{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public Conpon coupon;
    public List<FeeItemListBean> feeItemList;
    public String feeUnit;
    public Integer totalFee;
    
    public static class Conpon
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
      
      public String toString()
      {
        return "Conpon{businessLineName='" + this.businessLineName + '\'' + ", businessLineType='" + this.businessLineType + '\'' + ", cardId='" + this.cardId + '\'' + ", price='" + this.price + '\'' + ", unit='" + this.unit + '\'' + ", unitDes='" + this.unitDes + '\'' + ", cardName='" + this.cardName + '\'' + ", title='" + this.title + '\'' + ", subtitle='" + this.subtitle + '\'' + ", descrption='" + this.descrption + '\'' + ", state=" + this.state + ", startDate='" + this.startDate + '\'' + ", endDate='" + this.endDate + '\'' + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuNewNeedPayCouponBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */