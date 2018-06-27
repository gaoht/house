package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuCityBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<MinsuCityItemBean> hot;
    public List<ListBean> list;
    
    public static class ListBean
    {
      public List<MinsuCityItemBean> cityList;
      public String key;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCityBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */