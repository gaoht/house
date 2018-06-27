package com.ziroom.ziroomcustomer.pay.huifu.bean;

public class HuifuBankMessage
  extends HuifuBaseJson
{
  public DataBean data;
  
  public class DataBean
  {
    public String business_typ;
    public String order_date;
    public String order_id;
    public String resp_code;
    public String resp_desc;
    public String user_mobile;
    
    public DataBean() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/bean/HuifuBankMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */