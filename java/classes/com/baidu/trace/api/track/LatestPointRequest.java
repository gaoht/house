package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.ProcessOption;

public final class LatestPointRequest
  extends BaseRequest
{
  private String a;
  private ProcessOption b;
  private CoordType c = CoordType.bd09ll;
  
  public LatestPointRequest() {}
  
  public LatestPointRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public LatestPointRequest(int paramInt, long paramLong, String paramString)
  {
    this(paramInt, paramLong);
    this.a = paramString;
  }
  
  public LatestPointRequest(int paramInt, long paramLong, String paramString, ProcessOption paramProcessOption, CoordType paramCoordType)
  {
    this(paramInt, paramLong, paramString);
    this.b = paramProcessOption;
  }
  
  public final CoordType getCoordTypeOutput()
  {
    return this.c;
  }
  
  public final String getEntityName()
  {
    return this.a;
  }
  
  public final ProcessOption getProcessOption()
  {
    return this.b;
  }
  
  public final void setCoordTypeOutput(CoordType paramCoordType)
  {
    this.c = paramCoordType;
  }
  
  public final void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public final void setProcessOption(ProcessOption paramProcessOption)
  {
    this.b = paramProcessOption;
  }
  
  public final String toString()
  {
    return "LatestPointRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", entityName=" + this.a + ", processOption=" + this.b + ", coordTypeOutput=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/LatestPointRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */