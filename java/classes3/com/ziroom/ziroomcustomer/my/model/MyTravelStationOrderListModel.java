package com.ziroom.ziroomcustomer.my.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class MyTravelStationOrderListModel
  extends b
{
  public List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public String toString()
  {
    return "StationOrderListModel{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public String address;
    public int amount;
    public String createTime;
    public String endDate;
    public List<HouseTypeInfoBean> houseTypeInfo;
    public String isEvaluate;
    public String name;
    public int nights;
    public String orderBid;
    public String orderNumber;
    public int orderStatus;
    public String paymentNumber;
    public String phone;
    public String projectBid;
    public String projectName;
    public String sellPhone;
    public String startDate;
    
    public MyTravelOrder convertToTravelOrder()
    {
      MyTravelOrder localMyTravelOrder = new MyTravelOrder();
      localMyTravelOrder.arriveTime = this.startDate;
      localMyTravelOrder.leaveTime = this.endDate;
      try
      {
        localMyTravelOrder.createTime = Long.valueOf(this.createTime).longValue();
        localMyTravelOrder.phone = this.sellPhone;
        localMyTravelOrder.fid = this.orderBid;
        localMyTravelOrder.houseAddress = this.address;
        localMyTravelOrder.houseName = this.projectName;
        localMyTravelOrder.orderType = 2;
        return localMyTravelOrder;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localMyTravelOrder.createTime = -1L;
        }
      }
    }
    
    public String toString()
    {
      return "DataBean{orderBid='" + this.orderBid + '\'' + ", orderNumber='" + this.orderNumber + '\'' + ", projectName='" + this.projectName + '\'' + ", projectBid='" + this.projectBid + '\'' + ", amount=" + this.amount + ", orderStatus=" + this.orderStatus + ", startDate='" + this.startDate + '\'' + ", endDate='" + this.endDate + '\'' + ", sellPhone='" + this.sellPhone + '\'' + ", nights=" + this.nights + ", name='" + this.name + '\'' + ", phone='" + this.phone + '\'' + ", paymentNumber='" + this.paymentNumber + '\'' + ", isEvaluate='" + this.isEvaluate + '\'' + ", createTime='" + this.createTime + '\'' + ", address='" + this.address + '\'' + ", houseTypeInfo=" + this.houseTypeInfo + '}';
    }
    
    public static class HouseTypeInfoBean
    {
      public int bedCount;
      public String houseName;
      public String houseTypeBid;
      public String imgUrl;
      
      public String toString()
      {
        return "HouseTypeInfoBean{houseName='" + this.houseName + '\'' + ", imgUrl='" + this.imgUrl + '\'' + ", bedCount=" + this.bedCount + ", houseTypeBid='" + this.houseTypeBid + '\'' + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MyTravelStationOrderListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */