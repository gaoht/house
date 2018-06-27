package com.baidu.trace.api.fence;

public final class FenceInfo
{
  private FenceShape a;
  private CircleFence b;
  private PolygonFence c;
  private PolylineFence d;
  private DistrictFence e;
  private String f;
  private String g;
  
  public FenceInfo() {}
  
  public FenceInfo(FenceShape paramFenceShape, CircleFence paramCircleFence, PolygonFence paramPolygonFence, PolylineFence paramPolylineFence, DistrictFence paramDistrictFence, String paramString1, String paramString2)
  {
    this.a = paramFenceShape;
    this.b = paramCircleFence;
    this.c = paramPolygonFence;
    this.d = paramPolylineFence;
    this.e = paramDistrictFence;
    this.f = paramString1;
    this.g = paramString2;
  }
  
  public FenceInfo(FenceShape paramFenceShape, CircleFence paramCircleFence, PolygonFence paramPolygonFence, PolylineFence paramPolylineFence, String paramString1, String paramString2)
  {
    this.a = paramFenceShape;
    this.b = paramCircleFence;
    this.c = paramPolygonFence;
    this.d = paramPolylineFence;
    this.f = paramString1;
    this.g = paramString2;
  }
  
  public final CircleFence getCircleFence()
  {
    return this.b;
  }
  
  public final String getCreateTime()
  {
    return this.f;
  }
  
  public final DistrictFence getDistrictFence()
  {
    return this.e;
  }
  
  public final FenceShape getFenceShape()
  {
    return this.a;
  }
  
  public final String getModifyTime()
  {
    return this.g;
  }
  
  public final PolygonFence getPolygonFence()
  {
    return this.c;
  }
  
  public final PolylineFence getPolylineFence()
  {
    return this.d;
  }
  
  public final void setCircleFence(CircleFence paramCircleFence)
  {
    this.b = paramCircleFence;
  }
  
  public final void setCreateTime(String paramString)
  {
    this.f = paramString;
  }
  
  public final void setDistrictFence(DistrictFence paramDistrictFence)
  {
    this.e = paramDistrictFence;
  }
  
  public final void setFenceShape(FenceShape paramFenceShape)
  {
    this.a = paramFenceShape;
  }
  
  public final void setModifyTime(String paramString)
  {
    this.g = paramString;
  }
  
  public final void setPolygonFence(PolygonFence paramPolygonFence)
  {
    this.c = paramPolygonFence;
  }
  
  public final void setPolylineFence(PolylineFence paramPolylineFence)
  {
    this.d = paramPolylineFence;
  }
  
  public final String toString()
  {
    if (FenceShape.circle == this.a) {
      return "FenceInfo [fenceShape=" + this.a + ", circleFence=" + this.b + ", createTime=" + this.f + ", modifyTime=" + this.g + "]";
    }
    if (FenceShape.polygon == this.a) {
      return "FenceInfo [fenceShape=" + this.a + ", polygonFence=" + this.c + ", createTime=" + this.f + ", modifyTime=" + this.g + "]";
    }
    if (FenceShape.polyline == this.a) {
      return "FenceInfo [fenceShape=" + this.a + ", polylineFence=" + this.d + ", createTime=" + this.f + ", modifyTime=" + this.g + "]";
    }
    if (FenceShape.district == this.a) {
      return "FenceInfo [fenceShape=" + this.a + ", districtFence=" + this.e + ", createTime=" + this.f + ", modifyTime=" + this.g + "]";
    }
    return "FenceInfo [fenceShape=" + this.a + ", circleFence=" + this.b + ", polygonFence=" + this.c + ", polylineFence=" + this.d + ", districtFence=" + this.e + ", createTime=" + this.f + ", modifyTime=" + this.g + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/FenceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */