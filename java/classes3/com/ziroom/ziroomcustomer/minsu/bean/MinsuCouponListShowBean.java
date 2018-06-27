package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuCouponListShowBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<CouponListBean> couponList;
    public String subTitle;
    public String title;
    
    public static class CouponListBean
    {
      public String actSn;
      public String desc;
      public int isCan;
      public String money;
      public String symbol;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCouponListShowBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */