package com.ziroom.ziroomcustomer.pay.huifu.bean;

import java.util.List;

public class HuiFuIsBandAndBandList
  extends HuifuBaseJson
{
  public DataBean data;
  
  public class DataBean
  {
    public HfInfoBean hfInfo;
    
    public DataBean() {}
    
    public class HfInfoBean
    {
      public List<BindBanksBean> bindBanks;
      public int isBind;
      
      public HfInfoBean() {}
      
      public class BindBanksBean
      {
        public String bankCode;
        public String bankIconApp;
        public String bankIconPc;
        public String bankName;
        public String bankNo;
        public String cityCode;
        public String compamyName;
        
        public BindBanksBean() {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/bean/HuiFuIsBandAndBandList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */