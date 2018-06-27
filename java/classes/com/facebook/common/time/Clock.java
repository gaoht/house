package com.facebook.common.time;

public abstract interface Clock
{
  public static final long MAX_TIME = Long.MAX_VALUE;
  
  public abstract long now();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/time/Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */