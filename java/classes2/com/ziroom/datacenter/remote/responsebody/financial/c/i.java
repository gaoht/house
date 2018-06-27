package com.ziroom.datacenter.remote.responsebody.financial.c;

public class i
{
  private String a;
  private String b;
  private String c;
  
  public String getError_code()
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
  
  public void setError_code(String paramString)
  {
    this.b = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */