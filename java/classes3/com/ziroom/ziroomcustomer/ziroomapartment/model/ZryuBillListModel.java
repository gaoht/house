package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuBillListModel
  extends b
{
  public DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
  {
    public List<BillListBean> billList;
    public String contractCode;
    public String contractId;
    public String houseTypeName;
    public String payType;
    public String projectAddress;
    public String projectImg;
    public String projectName;
    public String roomNum;
    public int roomPrice;
    public String roomPriceStr;
    public String status;
    
    public static class BillListBean
    {
      public String actualAmount;
      public String actualAmountStr;
      public String billFid;
      public String billNum;
      public String contractCode;
      public String details;
      public long gatherDate;
      public String gatherDateStr;
      public String minPayAmount;
      public double oughtTotalAmount;
      public String oughtTotalAmountStr;
      public int payNum;
      public String paymentTime;
      public String pendingAmountStr;
      public int showPay;
      public int state;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuBillListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */