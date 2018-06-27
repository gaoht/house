package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuCouponInfoBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public CouponBean coupon;
    
    public static class CouponBean
    {
      public int actCut;
      public int actLimit;
      public String actSn;
      public int actType;
      public int actUser;
      public long checkInTime;
      public long checkOutTime;
      public String cityCode;
      public long couponEndTime;
      public String couponName;
      public String couponSn;
      public int couponSource;
      public long couponStartTime;
      public int couponStatus;
      public String createId;
      public long createTime;
      public Object customerMobile;
      public int id;
      public int isDel;
      public long lastModifyDate;
      public Object oldStatus;
      public Object orderSn;
      public String uid;
      public Object usedTime;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCouponInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */