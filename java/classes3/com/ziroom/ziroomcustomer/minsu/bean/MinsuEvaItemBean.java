package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuEvaItemBean
{
  public String replyContent;
  public String replyName;
  public String replyTime;
  public List<ScoreBean> scoreList;
  public String userContent;
  public String userName;
  public String userTime;
  
  public static class ScoreBean
  {
    public String name;
    public int score;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuEvaItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */