package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public final class DeleteFenceResponse
  extends BaseResponse
{
  private List<Long> a;
  private FenceType b;
  
  public DeleteFenceResponse() {}
  
  public DeleteFenceResponse(int paramInt1, int paramInt2, String paramString, FenceType paramFenceType)
  {
    super(paramInt1, paramInt2, paramString);
    this.b = paramFenceType;
  }
  
  public DeleteFenceResponse(int paramInt1, int paramInt2, String paramString, List<Long> paramList, FenceType paramFenceType)
  {
    this(paramInt1, paramInt2, paramString, paramFenceType);
    this.a = paramList;
  }
  
  public final List<Long> getFenceIds()
  {
    return this.a;
  }
  
  public final FenceType getFenceType()
  {
    return this.b;
  }
  
  public final void setFenceIds(List<Long> paramList)
  {
    this.a = paramList;
  }
  
  public final void setFenceType(FenceType paramFenceType)
  {
    this.b = paramFenceType;
  }
  
  public final String toString()
  {
    return "DeleteFenceResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", fenceType=" + this.b + ", fenceIds=" + this.a + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/DeleteFenceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */