package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.ProcessOption;

public final class DistanceRequest
  extends BaseRequest
{
  private String a;
  private long b;
  private long c;
  private boolean d = false;
  private ProcessOption e;
  private SupplementMode f;
  
  public DistanceRequest() {}
  
  public DistanceRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public DistanceRequest(int paramInt, long paramLong, String paramString)
  {
    super(paramInt, paramLong);
    this.a = paramString;
  }
  
  public DistanceRequest(int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, boolean paramBoolean, ProcessOption paramProcessOption, SupplementMode paramSupplementMode)
  {
    super(paramInt, paramLong1);
    this.a = paramString;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramBoolean;
    this.e = paramProcessOption;
    this.f = paramSupplementMode;
  }
  
  public final long getEndTime()
  {
    return this.c;
  }
  
  public final String getEntityName()
  {
    return this.a;
  }
  
  public final ProcessOption getProcessOption()
  {
    return this.e;
  }
  
  public final long getStartTime()
  {
    return this.b;
  }
  
  public final SupplementMode getSupplementMode()
  {
    return this.f;
  }
  
  public final boolean isProcessed()
  {
    return this.d;
  }
  
  public final void setEndTime(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public final void setProcessOption(ProcessOption paramProcessOption)
  {
    this.e = paramProcessOption;
  }
  
  public final void setProcessed(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void setSupplementMode(SupplementMode paramSupplementMode)
  {
    this.f = paramSupplementMode;
  }
  
  public final String toString()
  {
    return "DistanceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", entityName=" + this.a + ", startTime=" + this.b + ", endTime=" + this.c + ", isProcessed=" + this.d + ", processOption=" + this.e + ", supplementMode=" + this.f + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/DistanceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */