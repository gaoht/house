package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuTopHouseListBean
{
  public DataBean data;
  public String message;
  public String status;
  
  public static class DataBean
  {
    public List<ListBean> list;
    public String top50ListShareTitle;
    public String top50ListTitleBackground;
    public int total;
    
    public static class ListBean
    {
      public String fid;
      public String houseName;
      public List<String> indivLabelTipsList;
      public String picUrl;
      public int rentWay;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuTopHouseListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */