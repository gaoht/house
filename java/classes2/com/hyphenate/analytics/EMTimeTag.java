package com.hyphenate.analytics;

public class EMTimeTag
{
  private long oldTime = 0L;
  private long timeSpent = 0L;
  
  public void start()
  {
    this.oldTime = System.currentTimeMillis();
  }
  
  public long stop()
  {
    this.timeSpent = (System.currentTimeMillis() - this.oldTime);
    return this.timeSpent;
  }
  
  public long timeSpent()
  {
    return this.timeSpent;
  }
  
  public String timeStr()
  {
    return EMCollector.timeToString(this.timeSpent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/analytics/EMTimeTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */