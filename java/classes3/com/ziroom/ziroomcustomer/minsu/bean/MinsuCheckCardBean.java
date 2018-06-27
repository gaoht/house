package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuCheckCardBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public String toString()
  {
    return "MinsuCheckCardBean{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public boolean cardFlag;
    
    public String toString()
    {
      return "DataBean{cardFlag=" + this.cardFlag + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCheckCardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */