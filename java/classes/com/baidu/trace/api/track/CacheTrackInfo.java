package com.baidu.trace.api.track;

public class CacheTrackInfo
{
  private String a;
  private int b;
  private long c;
  private long d;
  
  public CacheTrackInfo() {}
  
  public CacheTrackInfo(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramLong1;
    this.d = paramLong2;
  }
  
  public CacheTrackInfo(String paramString, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.c = paramLong1;
    this.d = paramLong2;
  }
  
  public long getEndTime()
  {
    return this.d;
  }
  
  public String getEntityName()
  {
    return this.a;
  }
  
  public long getStartTime()
  {
    return this.c;
  }
  
  public int getTotal()
  {
    return this.b;
  }
  
  public void setEndTime(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setStartTime(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setTotal(int paramInt)
  {
    this.b = paramInt;
  }
  
  public String toString()
  {
    return "CacheTrackInfo [entityName=" + this.a + ", total=" + this.b + ", startTime=" + this.c + ", endTime=" + this.d + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/CacheTrackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */