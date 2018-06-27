package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public final class HistoryAlarmResponse
  extends BaseResponse
{
  private int a;
  private int b;
  private FenceType c;
  private List<FenceAlarmInfo> d;
  
  public HistoryAlarmResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, FenceType paramFenceType, List<FenceAlarmInfo> paramList)
  {
    this(paramInt1, paramInt2, paramString, paramFenceType);
    this.a = paramInt3;
    this.b = paramInt4;
    this.d = paramList;
  }
  
  public HistoryAlarmResponse(int paramInt1, int paramInt2, String paramString, FenceType paramFenceType)
  {
    super(paramInt1, paramInt2, paramString);
    this.c = paramFenceType;
  }
  
  public final List<FenceAlarmInfo> getFenceAlarmInfos()
  {
    return this.d;
  }
  
  public final FenceType getFenceType()
  {
    return this.c;
  }
  
  public final int getSize()
  {
    return this.b;
  }
  
  public final int getTotal()
  {
    return this.a;
  }
  
  public final void setFenceAlarmInfos(List<FenceAlarmInfo> paramList)
  {
    this.d = paramList;
  }
  
  public final void setFenceType(FenceType paramFenceType)
  {
    this.c = paramFenceType;
  }
  
  public final void setSize(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setTotal(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final String toString()
  {
    return "HistoryAlarmResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", total=" + this.a + ", size=" + this.b + ", fenceType=" + this.c + ", fenceAlarmInfos=" + this.d + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/HistoryAlarmResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */