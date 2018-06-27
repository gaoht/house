package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuConfigBean
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
    private String confTel;
    private String firstCar;
    private int imConMax;
    
    public String getConfTel()
    {
      return this.confTel;
    }
    
    public String getFirstCar()
    {
      return this.firstCar;
    }
    
    public int getImConMax()
    {
      return this.imConMax;
    }
    
    public void setConfTel(String paramString)
    {
      this.confTel = paramString;
    }
    
    public void setFirstCar(String paramString)
    {
      this.firstCar = paramString;
    }
    
    public void setImConMax(int paramInt)
    {
      this.imConMax = paramInt;
    }
    
    public String toString()
    {
      return "DataBean{confTel='" + this.confTel + '\'' + ", imConMax=" + this.imConMax + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuConfigBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */