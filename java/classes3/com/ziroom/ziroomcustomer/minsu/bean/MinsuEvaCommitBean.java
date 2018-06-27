package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;

public class MinsuEvaCommitBean
  extends MinsuBaseJson
  implements Serializable
{
  public DataBean data;
  
  public static class DataBean
    implements Serializable
  {
    public String mainTitle;
    public String picUrl;
    public String shareUrl;
    public String subTitle;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuEvaCommitBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */