package com.baidu.trace.api.analysis;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.ProcessOption;

public final class DrivingBehaviorRequest
  extends BaseRequest
{
  private String a;
  private long b;
  private long c;
  private int d = 0;
  private ThresholdOption e = null;
  private ProcessOption f;
  private CoordType g = CoordType.bd09ll;
  
  public DrivingBehaviorRequest() {}
  
  public DrivingBehaviorRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public DrivingBehaviorRequest(int paramInt, long paramLong, String paramString)
  {
    super(paramInt, paramLong);
    this.a = paramString;
  }
  
  public DrivingBehaviorRequest(int paramInt1, long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt2, ProcessOption paramProcessOption, CoordType paramCoordType)
  {
    super(paramInt1, paramLong1);
    this.a = paramString;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramInt2;
    this.f = paramProcessOption;
    this.g = paramCoordType;
  }
  
  public DrivingBehaviorRequest(int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, ThresholdOption paramThresholdOption, ProcessOption paramProcessOption, CoordType paramCoordType)
  {
    super(paramInt, paramLong1);
    this.a = paramString;
    this.b = paramLong2;
    this.c = paramLong3;
    this.e = paramThresholdOption;
    this.f = paramProcessOption;
    this.g = paramCoordType;
  }
  
  public final CoordType getCoordTypeOutput()
  {
    return this.g;
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
    return this.f;
  }
  
  public final int getSpeedingThreshold()
  {
    return this.d;
  }
  
  public final long getStartTime()
  {
    return this.b;
  }
  
  public final ThresholdOption getThresholdOption()
  {
    return this.e;
  }
  
  public final void setCoordTypeOutput(CoordType paramCoordType)
  {
    this.g = paramCoordType;
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
    this.f = paramProcessOption;
  }
  
  public final void setSpeedingThreshold(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void setThresholdOption(ThresholdOption paramThresholdOption)
  {
    this.e = paramThresholdOption;
  }
  
  public final String toString()
  {
    return "DrivingBehaviorRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", entityName=" + this.a + ", startTime=" + this.b + ", endTime=" + this.c + ", thresholdOption=" + this.e + ", processOption=" + this.f + ", coordTypeOutput=" + this.g + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/DrivingBehaviorRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */