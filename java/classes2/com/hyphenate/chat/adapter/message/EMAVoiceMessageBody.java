package com.hyphenate.chat.adapter.message;

public class EMAVoiceMessageBody
  extends EMAFileMessageBody
{
  private EMAVoiceMessageBody()
  {
    super("", 4);
    nativeInit("", 0);
  }
  
  public EMAVoiceMessageBody(EMAVoiceMessageBody paramEMAVoiceMessageBody)
  {
    super("", 4);
    nativeInit(paramEMAVoiceMessageBody);
  }
  
  public EMAVoiceMessageBody(String paramString, int paramInt)
  {
    super(paramString, 4);
    nativeInit(paramString, paramInt);
  }
  
  public int duration()
  {
    return nativeDuration();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native int nativeDuration();
  
  native void nativeFinalize();
  
  native void nativeInit(EMAVoiceMessageBody paramEMAVoiceMessageBody);
  
  native void nativeInit(String paramString, int paramInt);
  
  native void nativeSetDuration(int paramInt);
  
  public void setDuration(int paramInt)
  {
    nativeSetDuration(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/message/EMAVoiceMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */