package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuLLGetNeedPayBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public String toString()
  {
    return "MinsuLLGetNeedPayBean{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public int checkInLimit;
    public String couponMoney;
    public List<FeeItemListBean> feeItemList;
    public String feeUnit;
    public List<?> labelTipsList;
    public int minDay;
    public String notices;
    public int orderType;
    public String orderTypeName;
    public Object originalPrice;
    public int totalFee;
    
    public String toString()
    {
      return "DataBean{notices='" + this.notices + '\'' + ", minDay=" + this.minDay + ", orderType=" + this.orderType + ", originalPrice=" + this.originalPrice + ", totalFee=" + this.totalFee + ", feeUnit='" + this.feeUnit + '\'' + ", couponMoney='" + this.couponMoney + '\'' + ", checkInLimit=" + this.checkInLimit + ", orderTypeName='" + this.orderTypeName + '\'' + ", feeItemList=" + this.feeItemList + ", labelTipsList=" + this.labelTipsList + '}';
    }
    
    public static class FeeItemListBean
    {
      public int colorType;
      public String fee;
      public int index;
      public int isHasTips;
      public String name;
      public String symbol;
      public String tipContent;
      public String title1;
      public String title2;
      
      public String toString()
      {
        return "FeeItemListBean{name='" + this.name + '\'' + ", colorType=" + this.colorType + ", fee='" + this.fee + '\'' + ", index=" + this.index + ", symbol='" + this.symbol + '\'' + ", title1='" + this.title1 + '\'' + ", title2='" + this.title2 + '\'' + ", isHasTips=" + this.isHasTips + ", tipContent='" + this.tipContent + '\'' + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLLGetNeedPayBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */