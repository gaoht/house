package com.hyphenate.chat.adapter;

import java.util.List;

public abstract interface EMAMultiDeviceListenerInterface
{
  public abstract void onContactEvent(int paramInt, String paramString1, String paramString2);
  
  public abstract void onGroupEvent(int paramInt, String paramString, List<String> paramList);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAMultiDeviceListenerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */