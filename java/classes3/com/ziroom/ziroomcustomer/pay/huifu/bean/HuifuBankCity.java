package com.ziroom.ziroomcustomer.pay.huifu.bean;

import java.util.List;

public class HuifuBankCity
  extends HuifuBaseJson
{
  private List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public class DataBean
  {
    public String cardAreaCode;
    public String cardAreaName;
    public String cardProvCode;
    
    public DataBean() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/bean/HuifuBankCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */