package com.ziroom.ziroomcustomer.pay.huifu.bean;

import java.util.List;

public class HuifuIsBandCard
  extends HuifuBaseJson
{
  private DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public class DataBean
  {
    private List<HuifuIsBandCard.bindBanks> bindBanks;
    private int isBind;
    
    public DataBean() {}
    
    public List<HuifuIsBandCard.bindBanks> getBindBanks()
    {
      return this.bindBanks;
    }
    
    public int getIsBind()
    {
      return this.isBind;
    }
    
    public void setBindBanks(List<HuifuIsBandCard.bindBanks> paramList)
    {
      this.bindBanks = paramList;
    }
    
    public void setIsBind(int paramInt)
    {
      this.isBind = paramInt;
    }
  }
  
  public class bindBanks
  {
    public String bankCode;
    public String bankIconApp;
    public String bankIconPc;
    public String bankName;
    public String cardNo;
    public String cityCode;
    public String compamyName;
    
    public bindBanks() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/bean/HuifuIsBandCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */