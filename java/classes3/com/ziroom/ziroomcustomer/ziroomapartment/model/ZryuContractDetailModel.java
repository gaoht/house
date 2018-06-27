package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;

public class ZryuContractDetailModel
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
    public Object billList;
    public String contactTel;
    public String contractCode;
    public String contractId;
    public String houseTypeName;
    public double lat;
    public double lon;
    public String payType;
    public String projectAddress;
    public String projectImg;
    public String projectName;
    public String roomNum;
    public int roomPrice;
    public String roomPriceStr;
    public String status;
    public String viewUrl;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuContractDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */