package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class OIOpenModel
{
  public String amount;
  public String feeName;
  public InvoiceTypeBean invoiceType;
  public String phone;
  public String titleName;
  public String topTip;
  
  public static class InvoiceTypeBean
  {
    public String tip;
    public List<OIOpenModel.TypeListBean> typeList;
  }
  
  public static class TypeListBean
  {
    public int code;
    public boolean companyChoose;
    public String name;
    public boolean personChoose;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OIOpenModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */