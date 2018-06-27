package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuChatRecordBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public int count;
    public List<ListMsgBean> listMsg;
    
    public static class ListMsgBean
    {
      public String appChatRecordsExt;
      public String createTime;
      public String froms;
      public String msgContent;
      public int msgSenderType;
      public String tos;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuChatRecordBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */