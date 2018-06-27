package com.baidu.trace.api.fence;

public abstract class Fence
{
  protected long a;
  protected String b;
  protected String c;
  protected int d;
  protected FenceType e;
  
  protected Fence() {}
  
  protected Fence(long paramLong, String paramString1, String paramString2, int paramInt, FenceType paramFenceType)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.e = paramFenceType;
    this.d = paramInt;
    this.c = paramString2;
  }
  
  public int getDenoise()
  {
    return this.d;
  }
  
  public long getFenceId()
  {
    return this.a;
  }
  
  public String getFenceName()
  {
    return this.b;
  }
  
  public FenceType getFenceType()
  {
    return this.e;
  }
  
  public String getMonitoredPerson()
  {
    return this.c;
  }
  
  public void setDenoise(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setFenceId(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setFenceName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setMonitoredPerson(String paramString)
  {
    this.c = paramString;
  }
  
  public String toString()
  {
    return "Fence [fenceId=" + this.a + ", fenceName=" + this.b + ", monitoredPerson= " + this.c + ", denoise=" + this.d + ", fenceType=" + this.e + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/Fence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */