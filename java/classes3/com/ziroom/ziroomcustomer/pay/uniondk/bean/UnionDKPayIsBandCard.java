package com.ziroom.ziroomcustomer.pay.uniondk.bean;

import java.util.List;

public class UnionDKPayIsBandCard
  extends UnionDKBaseJson
{
  public DataBean data;
  
  public class DataBean
  {
    public List<CardInfoListBean> cardInfoList;
    public int isBindContract;
    public int isBindUid;
    
    public DataBean() {}
    
    public class CardInfoListBean
    {
      public String appIcon;
      public String bankCardNo;
      public String bankCode;
      public String bankName;
      public String certificateNum;
      public String mobile;
      public String uid;
      public String userName;
      
      public CardInfoListBean() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/uniondk/bean/UnionDKPayIsBandCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */