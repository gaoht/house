package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuCouponBarShowBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<String> barList;
    public String firstOrderReduce;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCouponBarShowBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */