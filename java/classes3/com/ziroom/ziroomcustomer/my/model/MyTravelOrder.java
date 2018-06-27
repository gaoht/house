package com.ziroom.ziroomcustomer.my.model;

public class MyTravelOrder
{
  public String arriveTime;
  public long createTime;
  public String fid;
  public String houseAddress;
  public String houseName;
  public String landlordMobile;
  public String landlordUid;
  public String leaveTime;
  public MyTravelMinsuOrderBean minsuOrderBean;
  public String orderSn;
  public int orderType;
  public String phone;
  public int rentWay;
  public MyTravelStationOrderListModel stationOrderListModel;
  
  public String toString()
  {
    return "MyTravelOrder{minsuOrderBean=" + this.minsuOrderBean + ", stationOrderListModel=" + this.stationOrderListModel + ", createTime=" + this.createTime + ", houseName='" + this.houseName + '\'' + ", houseAddress='" + this.houseAddress + '\'' + ", arriveTime='" + this.arriveTime + '\'' + ", leaveTime='" + this.leaveTime + '\'' + ", orderType=" + this.orderType + ", phone='" + this.phone + '\'' + ", fid='" + this.fid + '\'' + ", rentWay=" + this.rentWay + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MyTravelOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */