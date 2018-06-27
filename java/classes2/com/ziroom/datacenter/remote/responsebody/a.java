package com.ziroom.datacenter.remote.responsebody;

public class a
  extends com.ziroom.datacenter.b.a
{
  public String a;
  public int b;
  public String c;
  public String d;
  
  public a() {}
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
  }
  
  public int getError_code()
  {
    return this.b;
  }
  
  public String getError_message()
  {
    return this.c;
  }
  
  public String getMsg()
  {
    return this.d;
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
  
  public void setMsg(String paramString)
  {
    this.d = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */