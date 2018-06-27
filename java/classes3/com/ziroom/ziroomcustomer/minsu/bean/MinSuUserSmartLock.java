package com.ziroom.ziroomcustomer.minsu.bean;

public class MinSuUserSmartLock
  extends MinsuBaseJson
{
  public DataBean data;
  
  public String toString()
  {
    return "MinSuUserSmartLock{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public String expiredTime;
    public String password;
    public int status;
    
    public String toString()
    {
      return "DataBean{status=" + this.status + ", password='" + this.password + '\'' + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinSuUserSmartLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */