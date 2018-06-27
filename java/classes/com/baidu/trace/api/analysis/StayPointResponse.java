package com.baidu.trace.api.analysis;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public final class StayPointResponse
  extends BaseResponse
{
  private int a;
  private List<StayPoint> b;
  
  public StayPointResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public StayPointResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, List<StayPoint> paramList)
  {
    super(paramInt1, paramInt2, paramString);
    this.a = paramInt3;
    this.b = paramList;
  }
  
  public final int getStayPointNum()
  {
    return this.a;
  }
  
  public final List<StayPoint> getStayPoints()
  {
    return this.b;
  }
  
  public final void setStayPointNum(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void setStayPoints(List<StayPoint> paramList)
  {
    this.b = paramList;
  }
  
  public final String toString()
  {
    return "StayPointResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", stayPointNum=" + this.a + ", stayPoints=" + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/StayPointResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */