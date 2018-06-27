package com.baidu.trace.api.analysis;

public enum TurnType
{
  static
  {
    left = new TurnType("left", 1);
    right = new TurnType("right", 2);
  }
  
  private TurnType() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/TurnType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */