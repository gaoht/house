package com.baidu.trace.api.fence;

public class DistrictFence
  extends Fence
{
  private String f;
  private String g;
  
  private DistrictFence(long paramLong, String paramString1, String paramString2, int paramInt, FenceType paramFenceType, String paramString3)
  {
    super(paramLong, paramString1, paramString2, paramInt, paramFenceType);
    this.f = paramString3;
  }
  
  public static DistrictFence buildServerFence(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return new DistrictFence(paramLong, paramString1, paramString2, paramInt, FenceType.server, paramString3);
  }
  
  public String getDistrict()
  {
    return this.g;
  }
  
  public String getKeyword()
  {
    return this.f;
  }
  
  public void setDistrict(String paramString)
  {
    this.g = paramString;
  }
  
  public void setKeyword(String paramString)
  {
    this.f = paramString;
  }
  
  public String toString()
  {
    return "DistrictFence [fenceId=" + this.a + ", fenceName=" + this.b + ", fenceType=" + this.e + ", monitoredPerson=" + this.c + ", keyword=" + this.f + ", district=" + this.g + ", denoise=" + this.d + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/DistrictFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */