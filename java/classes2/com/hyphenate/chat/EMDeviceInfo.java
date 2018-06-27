package com.hyphenate.chat;

import com.hyphenate.chat.adapter.EMADeviceInfo;

public class EMDeviceInfo
  extends EMBase<EMADeviceInfo>
{
  EMADeviceInfo emaObject;
  
  EMDeviceInfo(EMADeviceInfo paramEMADeviceInfo)
  {
    this.emaObject = paramEMADeviceInfo;
  }
  
  public String getDeviceName()
  {
    return this.emaObject.getDeviceName();
  }
  
  public String getDeviceUUID()
  {
    return this.emaObject.getDeviceUUID();
  }
  
  public String getResource()
  {
    return this.emaObject.getResource();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMDeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */