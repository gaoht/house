package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuCreateOrderBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public String expireTime;
    public String msg;
    public String orderSn;
    public String phone;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCreateOrderBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */