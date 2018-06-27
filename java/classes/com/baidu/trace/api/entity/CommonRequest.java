package com.baidu.trace.api.entity;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;

public class CommonRequest
  extends BaseRequest
{
  protected FilterCondition a;
  protected SortBy b;
  protected CoordType c = CoordType.bd09ll;
  protected int d = 1;
  protected int e = 100;
  
  public CommonRequest() {}
  
  public CommonRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public CommonRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, SortBy paramSortBy, CoordType paramCoordType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong);
    this.a = paramFilterCondition;
    this.b = paramSortBy;
    this.c = paramCoordType;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public CommonRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, CoordType paramCoordType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong);
    this.a = paramFilterCondition;
    this.c = paramCoordType;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public CoordType getCoordTypeOutput()
  {
    return this.c;
  }
  
  public FilterCondition getFilterCondition()
  {
    return this.a;
  }
  
  public int getPageIndex()
  {
    return this.d;
  }
  
  public int getPageSize()
  {
    return this.e;
  }
  
  public SortBy getSortBy()
  {
    return this.b;
  }
  
  public void setCoordTypeOutput(CoordType paramCoordType)
  {
    this.c = paramCoordType;
  }
  
  public void setFilterCondition(FilterCondition paramFilterCondition)
  {
    this.a = paramFilterCondition;
  }
  
  public void setPageIndex(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setPageSize(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setSortBy(SortBy paramSortBy)
  {
    this.b = paramSortBy;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("CommonRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", filterCondition=").append(this.a);
    localStringBuffer.append(", sortBy=").append(this.b);
    localStringBuffer.append(", coordTypeOutput=").append(this.c);
    localStringBuffer.append(", pageIndex=").append(this.d);
    localStringBuffer.append(", pageSize=").append(this.e);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/CommonRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */