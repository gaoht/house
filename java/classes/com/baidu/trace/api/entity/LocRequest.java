package com.baidu.trace.api.entity;

import com.baidu.trace.model.BaseRequest;

public class LocRequest
  extends BaseRequest
{
  public LocRequest() {}
  
  public LocRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public LocRequest(long paramLong)
  {
    this.serviceId = paramLong;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append("serviceId=").append(this.serviceId);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/LocRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */