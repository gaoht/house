package com.baidu.trace.api.entity;

import com.baidu.trace.model.CoordType;

public final class EntityListRequest
  extends CommonRequest
{
  private CoordType f = CoordType.bd09ll;
  
  public EntityListRequest() {}
  
  public EntityListRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public EntityListRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, CoordType paramCoordType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramCoordType, paramInt2, paramInt3);
  }
  
  public final CoordType getCoordTypeOutput()
  {
    return this.f;
  }
  
  public final void setCoordTypeOutput(CoordType paramCoordType)
  {
    this.f = paramCoordType;
  }
  
  public final String toString()
  {
    return "EntityListRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", coordTypeOutput=" + this.f + ", filterCondition=" + this.a + ", pageIndex=" + this.d + ", pageSize=" + this.e + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/EntityListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */