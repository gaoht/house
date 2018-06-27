package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseResponse;

public final class DistanceResponse
  extends BaseResponse
{
  private String a;
  private double b;
  
  public DistanceResponse() {}
  
  public DistanceResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public DistanceResponse(int paramInt1, int paramInt2, String paramString1, String paramString2, double paramDouble)
  {
    super(paramInt1, paramInt2, paramString1);
    this.a = paramString2;
    this.b = paramDouble;
  }
  
  public final double getDistance()
  {
    return this.b;
  }
  
  public final String getEntityName()
  {
    return this.a;
  }
  
  public final void setDistance(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public final void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public final String toString()
  {
    return "DistanceResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", entityName=" + this.a + ", distance=" + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/DistanceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */