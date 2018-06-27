package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public final class UpdateFenceResponse
  extends BaseResponse
{
  private long a;
  private String b;
  private FenceType c;
  private FenceShape d;
  private String e;
  private List<String> f;
  
  public UpdateFenceResponse() {}
  
  public UpdateFenceResponse(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, FenceType paramFenceType)
  {
    super(paramInt1, paramInt2, paramString1);
    this.a = paramLong;
    this.b = paramString2;
    this.c = paramFenceType;
  }
  
  public UpdateFenceResponse(int paramInt1, int paramInt2, String paramString, FenceType paramFenceType)
  {
    super(paramInt1, paramInt2, paramString);
    this.c = paramFenceType;
  }
  
  public final String getDistrict()
  {
    return this.e;
  }
  
  public final List<String> getDistrictList()
  {
    return this.f;
  }
  
  public final long getFenceId()
  {
    return this.a;
  }
  
  public final String getFenceName()
  {
    return this.b;
  }
  
  public final FenceShape getFenceShape()
  {
    return this.d;
  }
  
  public final FenceType getFenceType()
  {
    return this.c;
  }
  
  public final void setDistrict(String paramString)
  {
    this.e = paramString;
  }
  
  public final void setDistrictList(List<String> paramList)
  {
    this.f = paramList;
  }
  
  public final void setFenceId(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final void setFenceName(String paramString)
  {
    this.b = paramString;
  }
  
  public final void setFenceShape(FenceShape paramFenceShape)
  {
    this.d = paramFenceShape;
  }
  
  public final void setFenceType(FenceType paramFenceType)
  {
    this.c = paramFenceType;
  }
  
  public final String toString()
  {
    if (FenceShape.district != this.d) {
      return "UpdateFenceResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", fenceId=" + this.a + ", fenceName=" + this.b + ", fenceType=" + this.c + ", fenceShape=" + this.d + "]";
    }
    return "UpdateFenceResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", fenceId=" + this.a + ", fenceName=" + this.b + ", fenceType=" + this.c + ", fenceShape=" + this.d + ", district=" + this.e + ", districtList=" + this.f + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/UpdateFenceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */