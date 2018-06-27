package com.hyphenate.chat.adapter.message;

public class EMATextMessageBody
  extends EMAMessageBody
{
  private EMATextMessageBody()
  {
    nativeInit("");
  }
  
  public EMATextMessageBody(EMATextMessageBody paramEMATextMessageBody)
  {
    nativeInit(paramEMATextMessageBody);
  }
  
  public EMATextMessageBody(String paramString)
  {
    nativeInit(paramString);
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native void nativeFinalize();
  
  native void nativeInit(EMATextMessageBody paramEMATextMessageBody);
  
  native void nativeInit(String paramString);
  
  native String nativeText();
  
  public String text()
  {
    return nativeText();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/message/EMATextMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */