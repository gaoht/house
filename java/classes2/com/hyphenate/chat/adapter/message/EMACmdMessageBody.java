package com.hyphenate.chat.adapter.message;

import java.util.Map;

public class EMACmdMessageBody
  extends EMAMessageBody
{
  private EMACmdMessageBody()
  {
    nativeInit("");
  }
  
  public EMACmdMessageBody(EMACmdMessageBody paramEMACmdMessageBody)
  {
    nativeInit(paramEMACmdMessageBody);
  }
  
  public EMACmdMessageBody(String paramString)
  {
    nativeInit(paramString);
  }
  
  public String action()
  {
    return nativeAction();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native String nativeAction();
  
  native void nativeFinalize();
  
  native void nativeInit(EMACmdMessageBody paramEMACmdMessageBody);
  
  native void nativeInit(String paramString);
  
  native Map<String, String> nativeParams();
  
  native void nativeSetAction(String paramString);
  
  native void nativeSetParams(Map<String, String> paramMap);
  
  public Map<String, String> params()
  {
    return nativeParams();
  }
  
  public void setAction(String paramString)
  {
    nativeSetAction(paramString);
  }
  
  public void setParams(Map<String, String> paramMap)
  {
    nativeSetParams(paramMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/message/EMACmdMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */