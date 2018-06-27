package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuContactsSaveResultBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<String> listFid;
    public int result;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuContactsSaveResultBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */