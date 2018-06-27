package com.ziroom.datacenter.remote.responsebody;

import com.ziroom.datacenter.b.a;

public class b<T>
  extends a
{
  private String a;
  private String b;
  private String c;
  private T d;
  
  public String getCode()
  {
    return this.a;
  }
  
  public T getData()
  {
    return (T)this.d;
  }
  
  public String getMessage()
  {
    return this.b;
  }
  
  public String getStatus()
  {
    return this.c;
  }
  
  public void setCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setData(T paramT)
  {
    this.d = paramT;
  }
  
  public void setMessage(String paramString)
  {
    this.b = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */