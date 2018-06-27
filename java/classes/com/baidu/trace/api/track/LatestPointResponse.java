package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseResponse;

public final class LatestPointResponse
  extends BaseResponse
{
  private String a;
  private LatestPoint b;
  private double c;
  
  public LatestPointResponse() {}
  
  public LatestPointResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public LatestPointResponse(int paramInt1, int paramInt2, String paramString1, String paramString2, LatestPoint paramLatestPoint, double paramDouble)
  {
    super(paramInt1, paramInt2, paramString1);
    this.a = paramString2;
    this.b = paramLatestPoint;
    this.c = paramDouble;
  }
  
  public final String getEntityName()
  {
    return this.a;
  }
  
  public final LatestPoint getLatestPoint()
  {
    return this.b;
  }
  
  public final double getLimitSpeed()
  {
    return this.c;
  }
  
  public final void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public final void setLatestPoint(LatestPoint paramLatestPoint)
  {
    this.b = paramLatestPoint;
  }
  
  public final void setLimitSpeed(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public final String toString()
  {
    return "LatestPointResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", entityName=" + this.a + ", latestPoint=" + this.b + ", limitSpeed=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/LatestPointResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */