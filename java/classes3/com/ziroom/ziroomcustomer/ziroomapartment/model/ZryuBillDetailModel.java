package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuBillDetailModel
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
    public String actualAmount;
    public String actualAmountStr;
    public String appVersionStr;
    public String billFid;
    public String billNum;
    public String cityCode;
    public String contractCode;
    public List<DetailsBean> details;
    public long gatherDate;
    public String gatherDateStr;
    public String imei;
    public String l;
    public String minPayAmount;
    public double oughtTotalAmount;
    public String oughtTotalAmountStr;
    public String payNum;
    public String pendingAmountStr;
    public String phoneModel;
    public String source;
    public String state;
    public String sysVersionStr;
    public String timestamp;
    
    public void setDetails(List<DetailsBean> paramList)
    {
      this.details = paramList;
    }
    
    public static class DetailsBean
    {
      public double amount;
      public String appVersionStr;
      public String cityCode;
      public String imei;
      public String key;
      public String l;
      public String phoneModel;
      public String source;
      public String sysVersionStr;
      public String timestamp;
      public String value;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuBillDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */