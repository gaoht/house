package com.ziroom.datacenter.remote.responsebody.financial.chat;

import java.util.List;

public class s
{
  private int a;
  private String b;
  private List<Object> c;
  
  public List<Object> getData()
  {
    return this.c;
  }
  
  public String getMessage()
  {
    return this.b;
  }
  
  public int getStatus()
  {
    return this.a;
  }
  
  public void setData(List<Object> paramList)
  {
    this.c = paramList;
  }
  
  public void setMessage(String paramString)
  {
    this.b = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/chat/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */