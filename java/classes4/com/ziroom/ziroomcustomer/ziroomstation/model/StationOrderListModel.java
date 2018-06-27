package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class StationOrderListModel
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
    public int amount;
    public String endDate;
    public List<HouseTypeInfoBean> houseTypeInfo;
    public String isEvaluate;
    public String name;
    public int nights;
    public String orderBid;
    public String orderNumber;
    public int orderStatus;
    public String orderStatusDesc;
    public String paymentNumber;
    public String phone;
    public String projectBid;
    public String projectName;
    public String sellPhone;
    public String startDate;
    
    public String toString()
    {
      return "DataBean{orderBid='" + this.orderBid + '\'' + ", orderNumber='" + this.orderNumber + '\'' + ", projectName='" + this.projectName + '\'' + ", projectBid='" + this.projectBid + '\'' + ", amount=" + this.amount + ", orderStatus=" + this.orderStatus + ", orderStatusDesc=" + this.orderStatusDesc + ", startDate='" + this.startDate + '\'' + ", endDate='" + this.endDate + '\'' + ", sellPhone='" + this.sellPhone + '\'' + ", nights=" + this.nights + ", name='" + this.name + '\'' + ", phone='" + this.phone + '\'' + ", paymentNumber='" + this.paymentNumber + '\'' + ", houseTypeInfo=" + this.houseTypeInfo + '}';
    }
    
    public static class HouseTypeInfoBean
    {
      public int bedCount;
      public String houseName;
      public String imgUrl;
      
      public String toString()
      {
        return "HouseTypeInfoBean{houseName='" + this.houseName + '\'' + ", imgUrl='" + this.imgUrl + '\'' + ", bedCount=" + this.bedCount + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationOrderListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */