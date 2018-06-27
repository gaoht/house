package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class OIInvoiceListModel
{
  public List<InvoiceListBean> invoiceList;
  public String topTip;
  
  public static class InvoiceListBean
  {
    public String amount;
    public boolean applyButton;
    public String applyCode;
    public String applyDate;
    public boolean downButton;
    public String feeCode;
    public String feeName;
    public String rejectReason;
    public String statusName;
    public String type;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OIInvoiceListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */