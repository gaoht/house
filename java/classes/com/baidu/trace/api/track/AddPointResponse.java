package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseResponse;

public class AddPointResponse
  extends BaseResponse
{
  public AddPointResponse() {}
  
  public AddPointResponse(int paramInt)
  {
    this.tag = paramInt;
  }
  
  public AddPointResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("AddPointResponse{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", status=").append(this.status);
    localStringBuffer.append(", message=").append(this.message).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/AddPointResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */