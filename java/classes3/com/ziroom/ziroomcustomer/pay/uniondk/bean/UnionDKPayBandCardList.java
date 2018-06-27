package com.ziroom.ziroomcustomer.pay.uniondk.bean;

import java.util.List;

public class UnionDKPayBandCardList
  extends UnionDKBaseJson
{
  public List<DataBean> data;
  
  public class DataBean
  {
    public String bankCode;
    public String bankIconApp;
    public String bankIconPc;
    public String bankName;
    public int bankType;
    public String batchFee;
    public long createTime;
    public String id;
    public int isDel;
    public long lastModifyTime;
    public String totalFee;
    public int weight;
    
    public DataBean() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/uniondk/bean/UnionDKPayBandCardList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */