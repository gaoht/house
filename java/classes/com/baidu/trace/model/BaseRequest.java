package com.baidu.trace.model;

public class BaseRequest
{
  private boolean a = false;
  public long serviceId;
  public int tag;
  
  public BaseRequest() {}
  
  public BaseRequest(int paramInt, long paramLong)
  {
    this.tag = paramInt;
    this.serviceId = paramLong;
  }
  
  public void cancel()
  {
    this.a = true;
  }
  
  public long getServiceId()
  {
    return this.serviceId;
  }
  
  public int getTag()
  {
    return this.tag;
  }
  
  public boolean isCanceled()
  {
    return this.a;
  }
  
  public void setServiceId(long paramLong)
  {
    this.serviceId = paramLong;
  }
  
  public void setTag(int paramInt)
  {
    this.tag = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/BaseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */