package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public final class FenceListResponse
  extends BaseResponse
{
  private int a;
  private FenceType b;
  private List<FenceInfo> c;
  
  public FenceListResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, FenceType paramFenceType, List<FenceInfo> paramList)
  {
    this(paramInt1, paramInt2, paramString, paramFenceType);
    this.a = paramInt3;
    this.c = paramList;
  }
  
  public FenceListResponse(int paramInt1, int paramInt2, String paramString, FenceType paramFenceType)
  {
    super(paramInt1, paramInt2, paramString);
    this.b = paramFenceType;
  }
  
  public final List<FenceInfo> getFenceInfos()
  {
    return this.c;
  }
  
  public final FenceType getFenceType()
  {
    return this.b;
  }
  
  public final int getSize()
  {
    return this.a;
  }
  
  public final void setFenceInfos(List<FenceInfo> paramList)
  {
    this.c = paramList;
  }
  
  public final void setFenceType(FenceType paramFenceType)
  {
    this.b = paramFenceType;
  }
  
  public final void setSize(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final String toString()
  {
    return "FenceListResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", size=" + this.a + ", fenceType=" + this.b + ", fenceInfos=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/FenceListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */