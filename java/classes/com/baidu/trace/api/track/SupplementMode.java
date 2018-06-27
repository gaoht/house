package com.baidu.trace.api.track;

public enum SupplementMode
{
  static
  {
    driving = new SupplementMode("driving", 2);
    riding = new SupplementMode("riding", 3);
    walking = new SupplementMode("walking", 4);
  }
  
  private SupplementMode() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/SupplementMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */