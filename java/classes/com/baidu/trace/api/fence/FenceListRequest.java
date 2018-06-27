package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import java.util.List;

public final class FenceListRequest
  extends BaseRequest
{
  private String a;
  private List<Long> b;
  private CoordType c = CoordType.bd09ll;
  private FenceType d;
  
  private FenceListRequest(int paramInt, long paramLong, String paramString, List<Long> paramList, CoordType paramCoordType, FenceType paramFenceType)
  {
    super(paramInt, paramLong);
    this.a = paramString;
    this.b = paramList;
    this.c = paramCoordType;
    this.d = paramFenceType;
  }
  
  public static FenceListRequest buildLocalRequest(int paramInt, long paramLong, String paramString, List<Long> paramList)
  {
    return new FenceListRequest(paramInt, paramLong, paramString, paramList, CoordType.bd09ll, FenceType.local);
  }
  
  public static FenceListRequest buildServerRequest(int paramInt, long paramLong, String paramString, List<Long> paramList, CoordType paramCoordType)
  {
    return new FenceListRequest(paramInt, paramLong, paramString, paramList, paramCoordType, FenceType.server);
  }
  
  public final CoordType getCoordTypeOutput()
  {
    return this.c;
  }
  
  public final List<Long> getFenceIds()
  {
    return this.b;
  }
  
  public final FenceType getFenceType()
  {
    return this.d;
  }
  
  public final String getMonitoredPerson()
  {
    return this.a;
  }
  
  public final void setCoordTypeOutput(CoordType paramCoordType)
  {
    if (FenceType.server == this.d) {
      this.c = paramCoordType;
    }
  }
  
  public final void setFenceIds(List<Long> paramList)
  {
    this.b = paramList;
  }
  
  public final void setMonitoredPerson(String paramString)
  {
    this.a = paramString;
  }
  
  public final String toString()
  {
    return "FenceListRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", monitoredPerson=" + this.a + ", fenceIds=" + this.b + ", coordTypeOutput=" + this.c + ", fenceType=" + this.d + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/FenceListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */