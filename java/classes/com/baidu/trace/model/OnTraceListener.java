package com.baidu.trace.model;

public abstract interface OnTraceListener
{
  public abstract void onBindServiceCallback(int paramInt, String paramString);
  
  public abstract void onInitBOSCallback(int paramInt, String paramString);
  
  public abstract void onPushCallback(byte paramByte, PushMessage paramPushMessage);
  
  public abstract void onStartGatherCallback(int paramInt, String paramString);
  
  public abstract void onStartTraceCallback(int paramInt, String paramString);
  
  public abstract void onStopGatherCallback(int paramInt, String paramString);
  
  public abstract void onStopTraceCallback(int paramInt, String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/OnTraceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */