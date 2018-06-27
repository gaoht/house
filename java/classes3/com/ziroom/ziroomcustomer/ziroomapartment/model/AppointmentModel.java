package com.ziroom.ziroomcustomer.ziroomapartment.model;

public class AppointmentModel
  extends ZryuBaseResult
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
    private String message;
    
    public String getMessage()
    {
      return this.message;
    }
    
    public void setMessage(String paramString)
    {
      this.message = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/AppointmentModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */