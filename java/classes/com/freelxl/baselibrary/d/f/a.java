package com.freelxl.baselibrary.d.f;

import okhttp3.Response;

public abstract class a<T>
{
  protected int code;
  
  public int getCode()
  {
    return this.code;
  }
  
  protected abstract T parse(Response paramResponse)
    throws Exception;
  
  public T parseResponse(Response paramResponse)
    throws Exception
  {
    this.code = paramResponse.code();
    return (T)parse(paramResponse);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */