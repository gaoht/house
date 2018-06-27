package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuSearchSortBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<SortListBean> sortList;
    
    public static class SortListBean
    {
      public String code;
      public int index;
      public String name;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuSearchSortBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */