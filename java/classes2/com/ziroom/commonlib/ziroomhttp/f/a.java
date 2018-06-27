package com.ziroom.commonlib.ziroomhttp.f;

import okhttp3.Response;

public abstract class a<T>
{
  protected int a;
  protected String b;
  
  public int getCode()
  {
    return this.a;
  }
  
  public String getMessage()
  {
    return this.b;
  }
  
  protected abstract T parse(Response paramResponse)
    throws Exception;
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    this.a = paramResponse.code();
    this.b = paramResponse.message();
    return (T)parse(paramResponse);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */