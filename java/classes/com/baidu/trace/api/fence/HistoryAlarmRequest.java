package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import java.util.List;

public final class HistoryAlarmRequest
  extends BaseRequest
{
  private long a;
  private long b;
  private String c;
  private List<Long> d;
  private CoordType e = CoordType.bd09ll;
  private FenceType f;
  
  private HistoryAlarmRequest(int paramInt, long paramLong1, long paramLong2, long paramLong3, String paramString, List<Long> paramList, CoordType paramCoordType, FenceType paramFenceType)
  {
    super(paramInt, paramLong1);
    this.a = paramLong2;
    this.b = paramLong3;
    this.c = paramString;
    this.d = paramList;
    this.e = paramCoordType;
    this.f = paramFenceType;
  }
  
  public static HistoryAlarmRequest buildLocalRequest(int paramInt, long paramLong1, long paramLong2, long paramLong3, String paramString, List<Long> paramList)
  {
    return new HistoryAlarmRequest(paramInt, paramLong1, paramLong2, paramLong3, paramString, paramList, CoordType.bd09ll, FenceType.local);
  }
  
  public static HistoryAlarmRequest buildServerRequest(int paramInt, long paramLong1, long paramLong2, long paramLong3, String paramString, List<Long> paramList, CoordType paramCoordType)
  {
    return new HistoryAlarmRequest(paramInt, paramLong1, paramLong2, paramLong3, paramString, paramList, paramCoordType, FenceType.server);
  }
  
  public final CoordType getCoordTypeOutput()
  {
    return this.e;
  }
  
  public final long getEndTime()
  {
    return this.b;
  }
  
  public final List<Long> getFenceIds()
  {
    return this.d;
  }
  
  public final FenceType getFenceType()
  {
    return this.f;
  }
  
  public final String getMonitoredPerson()
  {
    return this.c;
  }
  
  public final long getStartTime()
  {
    return this.a;
  }
  
  public final void setCoordTypeOutput(CoordType paramCoordType)
  {
    if (FenceType.server == this.f) {
      this.e = paramCoordType;
    }
  }
  
  public final void setEndTime(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void setFenceIds(List<Long> paramList)
  {
    this.d = paramList;
  }
  
  public final void setMonitoredPerson(String paramString)
  {
    this.c = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final String toString()
  {
    return "HistoryAlarmRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", startTime=" + this.a + ", endTime=" + this.b + ", monitoredPerson=" + this.c + ", fenceIds=" + this.d + ", coordTypeOutput=" + this.e + ", fenceType=" + this.f + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/HistoryAlarmRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */