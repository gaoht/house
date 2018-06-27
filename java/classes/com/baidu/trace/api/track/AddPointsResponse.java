package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseResponse;

public class AddPointsResponse
  extends BaseResponse
{
  private int a;
  private FailInfo b;
  
  public AddPointsResponse() {}
  
  public AddPointsResponse(int paramInt)
  {
    this.tag = paramInt;
  }
  
  public AddPointsResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public AddPointsResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, FailInfo paramFailInfo)
  {
    super(paramInt1, paramInt2, paramString);
    this.a = paramInt3;
    this.b = paramFailInfo;
  }
  
  public FailInfo getFailInfo()
  {
    return this.b;
  }
  
  public int getSuccessNum()
  {
    return this.a;
  }
  
  public void setFailInfo(FailInfo paramFailInfo)
  {
    this.b = paramFailInfo;
  }
  
  public void setSuccessNum(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("AddPointsResponse{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", status=").append(this.status);
    localStringBuffer.append(", message=").append(this.message).append('\'');
    localStringBuffer.append(", successNum=").append(this.a);
    localStringBuffer.append(", failInfo=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/AddPointsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */