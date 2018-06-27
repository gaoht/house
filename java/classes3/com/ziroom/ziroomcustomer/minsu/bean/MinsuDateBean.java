package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuDateBean
  extends MinsuBaseJson
{
  private DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
  {
    private String currentDate;
    
    public String getCurrentDate()
    {
      return this.currentDate;
    }
    
    public void setCurrentDate(String paramString)
    {
      this.currentDate = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuDateBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */