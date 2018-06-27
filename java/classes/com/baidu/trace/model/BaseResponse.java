package com.baidu.trace.model;

public class BaseResponse
{
  public String message;
  public int status;
  public int tag;
  
  public BaseResponse() {}
  
  public BaseResponse(int paramInt1, int paramInt2, String paramString)
  {
    this.tag = paramInt1;
    this.status = paramInt2;
    this.message = paramString;
  }
  
  public BaseResponse(int paramInt, String paramString)
  {
    this.status = paramInt;
    this.message = paramString;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public int getTag()
  {
    return this.tag;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTag(int paramInt)
  {
    this.tag = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/BaseResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */