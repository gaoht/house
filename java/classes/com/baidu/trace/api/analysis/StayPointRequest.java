package com.baidu.trace.api.analysis;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.ProcessOption;

public final class StayPointRequest
  extends BaseRequest
{
  private String a;
  private long b;
  private long c;
  private int d = 600;
  private int e = 20;
  private ProcessOption f;
  private CoordType g = CoordType.bd09ll;
  
  public StayPointRequest() {}
  
  public StayPointRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public StayPointRequest(int paramInt, long paramLong, String paramString)
  {
    super(paramInt, paramLong);
    this.a = paramString;
  }
  
  public StayPointRequest(int paramInt1, long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt2, int paramInt3, ProcessOption paramProcessOption, CoordType paramCoordType)
  {
    super(paramInt1, paramLong1);
    this.a = paramString;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramProcessOption;
    this.g = paramCoordType;
  }
  
  public StayPointRequest(int paramInt1, long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt2, ProcessOption paramProcessOption, CoordType paramCoordType)
  {
    super(paramInt1, paramLong1);
    this.a = paramString;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramInt2;
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
  
  public final long getStartTime()
  {
    return this.b;
  }
  
  public final int getStayRadius()
  {
    return this.e;
  }
  
  public final int getStayTime()
  {
    return this.d;
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
  
  public final void setStartTime(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void setStayRadius(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void setStayTime(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("StayPointRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", entityName='").append(this.a).append('\'');
    localStringBuffer.append(", startTime=").append(this.b);
    localStringBuffer.append(", endTime=").append(this.c);
    localStringBuffer.append(", stayTime=").append(this.d);
    localStringBuffer.append(", stayRadius=").append(this.e);
    localStringBuffer.append(", processOption=").append(this.f);
    localStringBuffer.append(", coordTypeOutput=").append(this.g);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/StayPointRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */