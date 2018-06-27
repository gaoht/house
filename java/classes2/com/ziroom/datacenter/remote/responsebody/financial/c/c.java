package com.ziroom.datacenter.remote.responsebody.financial.c;

public class c
{
  private String a;
  private int b;
  private String c;
  
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
  
  public boolean isSuccess()
  {
    return this.a.equals("success");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */