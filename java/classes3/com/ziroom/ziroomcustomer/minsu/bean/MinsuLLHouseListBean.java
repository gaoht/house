package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuLLHouseListBean
  extends MinsuBaseJson
{
  public Data data;
  
  public String toString()
  {
    return "MinsuLLHouseListBean{status=" + this.status + "message=" + this.message + "data=" + this.data + '}';
  }
  
  public static class Data
  {
    public List<DataBean> list;
    
    public String toString()
    {
      return "Data{list=" + this.list + '}';
    }
    
    public static class DataBean
    {
      public Object actualMoney;
      public String bedFid;
      public String bookStartTime;
      public String defaultPic;
      public String houseAddr;
      public String houseBaseFid;
      public double houseBookRate;
      public String houseEvaScore;
      public String houseName;
      public int housePv;
      public String houseRoomFid;
      public String houseSn;
      public int houseStatus;
      public double intactRate;
      public int isIssue;
      public int isNoDel;
      public String isTodayDiscount;
      public String lastModifyDate;
      public String name;
      public int operateSeq;
      public Object orderNum;
      public String orderTypeStr;
      public String photoStatName;
      public Object predictMoney;
      public String refuseReason;
      public int rentWay;
      public String roomName;
      public String roomSn;
      public int roomStatus;
      public int roomType;
      public Object starRating;
      public int status;
      public String statusName;
      public String todayDiscount;
      public int whetherBookPhoto;
      public String zoCode;
      public String zoMobile;
      public String zoName;
      
      public String toString()
      {
        return "DataBean{houseBaseFid='" + this.houseBaseFid + '\'' + ", houseRoomFid='" + this.houseRoomFid + '\'' + ", rentWay=" + this.rentWay + ", orderTypeStr=" + this.orderTypeStr + ", roomType=" + this.roomType + ", houseStatus=" + this.houseStatus + ", roomStatus=" + this.roomStatus + ", houseName='" + this.houseName + '\'' + ", roomName='" + this.roomName + '\'' + ", defaultPic='" + this.defaultPic + '\'' + ", houseBookRate=" + this.houseBookRate + ", intactRate=" + this.intactRate + ", starRating=" + this.starRating + ", houseAddr='" + this.houseAddr + '\'' + ", zoCode='" + this.zoCode + '\'' + ", zoName='" + this.zoName + '\'' + ", zoMobile='" + this.zoMobile + '\'' + ", actualMoney=" + this.actualMoney + ", predictMoney=" + this.predictMoney + ", status=" + this.status + ", statusName='" + this.statusName + '\'' + ", name='" + this.name + '\'' + ", housePv=" + this.housePv + ", houseEvaScore='" + this.houseEvaScore + '\'' + ", orderNum=" + this.orderNum + ", houseSn='" + this.houseSn + '\'' + ", roomSn='" + this.roomSn + '\'' + ", lastModifyDate='" + this.lastModifyDate + '\'' + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLLHouseListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */