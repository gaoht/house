package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuImproveHouseRankBean
{
  public DataBean data;
  public String message;
  public int status;
  
  public static class DataBean
  {
    public HabitBean habit;
    public TaskBean task;
    
    public static class HabitBean
    {
      public List<ListBean> list;
      public String title;
      
      public static class ListBean
      {
        public List<ItemListBean> itemList;
        public String title;
        
        public static class ItemListBean
        {
          public ProgressBarBean progressBar;
          public String subTitle;
          public String title;
          
          public static class ProgressBarBean
          {
            public String color;
            public int value;
          }
        }
      }
    }
    
    public static class TaskBean
    {
      public List<ListBean> list;
      public String title;
      
      public static class ListBean
      {
        public int hasFinish;
        public String result;
        public String title;
        public String type;
        public String url;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuImproveHouseRankBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */