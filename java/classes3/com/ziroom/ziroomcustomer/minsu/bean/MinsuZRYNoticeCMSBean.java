package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;
import java.util.Map;

public class MinsuZRYNoticeCMSBean
{
  public Map<String, NoticeBean> data;
  public int error_code;
  public String error_message;
  public String status;
  
  public static class NoticeBean
  {
    public List<LunboBean> lunbotu;
    public String subtitle;
    public String title;
    
    public static class LunboBean
    {
      public String app;
      public String description;
      public String img;
      public String target;
      public String title;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuZRYNoticeCMSBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */