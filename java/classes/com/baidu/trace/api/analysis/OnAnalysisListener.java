package com.baidu.trace.api.analysis;

public abstract interface OnAnalysisListener
{
  public abstract void onDrivingBehaviorCallback(DrivingBehaviorResponse paramDrivingBehaviorResponse);
  
  public abstract void onStayPointCallback(StayPointResponse paramStayPointResponse);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/OnAnalysisListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */