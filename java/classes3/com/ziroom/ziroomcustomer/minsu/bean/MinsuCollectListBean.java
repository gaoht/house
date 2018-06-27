package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuCollectListBean
{
  public DataBean data;
  public String message;
  public String status;
  
  public static class DataBean
  {
    public List<MinsuHouseBean.DataBean.ListBean> rows;
    public int total;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCollectListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */