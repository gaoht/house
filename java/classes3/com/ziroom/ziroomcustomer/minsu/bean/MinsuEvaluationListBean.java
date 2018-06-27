package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuEvaluationListBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<RowsBean> rows;
    public int total;
    
    public static class RowsBean
    {
      public String endTimeStr;
      public int evaStatus;
      public String evaTips;
      public String fid;
      public String houseAddr;
      public String houseFid;
      public String houseName;
      public int housingDay;
      public String invitEvalButton;
      public String lanEvaStatu;
      public String landlordUid;
      public String orderSn;
      public int peopleNum;
      public String picUrl;
      public String pjButton;
      public int pjStatus;
      public int price;
      public int rentWay;
      public String startTimeStr;
      public String tenEvaStatu;
      public String userName;
      public String userPicUrl;
      public String userUid;
      
      public String toString()
      {
        return "RowsBean{orderSn='" + this.orderSn + '\'' + ", houseName='" + this.houseName + '\'' + ", houseAddr='" + this.houseAddr + '\'' + ", picUrl='" + this.picUrl + '\'' + ", price=" + this.price + ", housingDay=" + this.housingDay + ", userName='" + this.userName + '\'' + ", startTimeStr='" + this.startTimeStr + '\'' + ", endTimeStr='" + this.endTimeStr + '\'' + ", evaStatus=" + this.evaStatus + ", evaTips='" + this.evaTips + '\'' + ", peopleNum=" + this.peopleNum + ", userPicUrl='" + this.userPicUrl + '\'' + ", pjStatus=" + this.pjStatus + ", pjButton='" + this.pjButton + '\'' + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuEvaluationListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */