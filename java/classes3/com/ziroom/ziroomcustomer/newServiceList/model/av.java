package com.ziroom.ziroomcustomer.newServiceList.model;

import java.util.List;

public class av
{
  private String a;
  private int b;
  private String c;
  private List<Object> d;
  
  public List<Object> getData()
  {
    return this.d;
  }
  
  public int getError_code()
  {
    return this.b;
  }
  
  public String getError_message()
  {
    return this.c;
  }
  
  public String getStatus()
  {
    return this.a;
  }
  
  public void setData(List<Object> paramList)
  {
    this.d = paramList;
  }
  
  public void setError_code(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setError_message(String paramString)
  {
    this.c = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */