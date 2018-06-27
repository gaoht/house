package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class OIDetailModel
{
  public boolean cancelButton;
  public String downUrl;
  public List<InfoBean> invoiceInfo;
  public String realUrl;
  public List<InfoBean> receiverInfo;
  public String status;
  public String statusInstruct;
  public String statusName;
  
  public static class InfoBean
  {
    public String title;
    public String value;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OIDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */