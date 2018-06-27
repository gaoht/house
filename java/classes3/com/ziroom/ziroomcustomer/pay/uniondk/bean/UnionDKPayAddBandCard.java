package com.ziroom.ziroomcustomer.pay.uniondk.bean;

import java.io.Serializable;
import java.util.List;

public class UnionDKPayAddBandCard
  extends UnionDKBaseJson
{
  public List<DataBean> data;
  
  public class DataBean
    implements Serializable
  {
    public String appIcon;
    public String bankCardNo;
    public String bankCode;
    public String bankName;
    public String certificateNum;
    public String mobile;
    public String uid;
    public String userName;
    
    public DataBean() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/uniondk/bean/UnionDKPayAddBandCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */