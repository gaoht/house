package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuLLOrderListBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public int isShowMoreOrder;
    public List<OrderListBean> orderList;
    public int total;
    
    public static class OrderListBean
    {
      public int contactsNum;
      public String detailUrl;
      public String endTimeStr;
      public int evaStatus;
      public String evaluateUrl;
      public Object headPicUrl;
      public String houseAddr;
      public String houseFid;
      public String houseName;
      public String housePicUrl;
      public int housingDay;
      public String imToTaButton;
      public String landlordUid;
      public double needMoney;
      public String orderSn;
      public int orderStatus;
      public String orderStatusShowName;
      public String pjButton;
      public int pjStatus;
      public String remarkUrl;
      public int rentWay;
      public String startTimeStr;
      public String userName;
      public String userUid;
      public String waitDealOrderButton;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLLOrderListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */