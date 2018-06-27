package com.hyphenate.chat.adapter;

public abstract interface EMACallRtcInterface
{
  public abstract void answer();
  
  public abstract void createOffer();
  
  public abstract String getDefaultConfig(int paramInt);
  
  public abstract String getRtcId();
  
  public abstract String getRtcReport();
  
  public abstract String getSubConfig();
  
  public abstract void hangup();
  
  public abstract void setConfigJson(String paramString);
  
  public abstract void setRemoteJson(String paramString);
  
  public abstract void setStatsEnable(boolean paramBoolean);
  
  public static enum calltype
  {
    private calltype() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallRtcInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */