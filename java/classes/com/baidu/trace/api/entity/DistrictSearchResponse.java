package com.baidu.trace.api.entity;

import java.util.List;

public final class DistrictSearchResponse
  extends CommonResponse
{
  private List<String> d;
  
  public DistrictSearchResponse() {}
  
  public DistrictSearchResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public DistrictSearchResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, List<EntityInfo> paramList)
  {
    super(paramInt1, paramInt2, paramString, paramInt3, paramInt4, paramList);
  }
  
  public final List<String> getDistrictList()
  {
    return this.d;
  }
  
  public final void setDistrictList(List<String> paramList)
  {
    this.d = paramList;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DistrictSearchResponse{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", status=").append(this.status);
    localStringBuffer.append(", message='").append(this.message).append('\'');
    localStringBuffer.append(", total=").append(this.a);
    localStringBuffer.append(", size=").append(this.b);
    localStringBuffer.append(", entities=").append(this.c);
    localStringBuffer.append(", districtList=").append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/DistrictSearchResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */