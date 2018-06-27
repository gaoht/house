package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;
import java.util.List;

public class MinsuImReplyCommonBean
  extends MinsuBaseJson
  implements Serializable
{
  public DataBean data;
  
  public static class DataBean
    implements Serializable
  {
    public int count;
    public List<ListMsgBean> listMsg;
    
    public static class ListMsgBean
      implements Serializable
    {
      public String content;
      public String fid;
      public int msgType;
      public String uid;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuImReplyCommonBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */