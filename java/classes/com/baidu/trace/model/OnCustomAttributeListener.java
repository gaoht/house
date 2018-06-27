package com.baidu.trace.model;

import java.util.Map;

public abstract interface OnCustomAttributeListener
{
  public abstract Map<String, String> onTrackAttributeCallback();
  
  public abstract Map<String, String> onTrackAttributeCallback(long paramLong);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/OnCustomAttributeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */