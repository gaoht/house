package com.superrtc.sdk;

public class b
{
  long a = 0L;
  long b = 0L;
  long c = 0L;
  
  public long getBitrate()
  {
    return this.c * 8L;
  }
  
  public String getBitrateString()
  {
    return "" + getBitrate() / 1000L;
  }
  
  public long getRate()
  {
    return this.c;
  }
  
  public void update(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.b;
    if ((l2 < 0L) || (l2 > 5000L))
    {
      this.a = paramLong;
      this.b = l1;
    }
    while (l2 < 2000L) {
      return;
    }
    this.c = (1000L * (paramLong - this.a) / l2);
  }
  
  public void update(String paramString)
  {
    update(Long.valueOf(paramString).longValue());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */