package com.ziroom.ziroomcustomer.newServiceList.utils;

public class c<T>
{
  private String a;
  private T b;
  
  public c(String paramString, T paramT)
  {
    this.a = paramString;
    this.b = paramT;
  }
  
  public T getData()
  {
    return (T)this.b;
  }
  
  public String getType()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */