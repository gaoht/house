package com.hyphenate.chat.adapter;

import com.hyphenate.EMCallBack;

public class EMACallback
  extends EMABase
{
  private EMCallBack owner = null;
  
  public EMACallback(EMCallBack paramEMCallBack)
  {
    this.owner = paramEMCallBack;
    nativeInit();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native void nativeFinalize();
  
  native void nativeInit();
  
  public void onError(int paramInt, String paramString)
  {
    if (this.owner != null)
    {
      this.owner.onError(paramInt, paramString);
      this.owner = null;
    }
  }
  
  public void onProgress(int paramInt, String paramString)
  {
    if (this.owner != null) {
      this.owner.onProgress(paramInt, paramString);
    }
  }
  
  public void onSuccess()
  {
    if (this.owner != null)
    {
      this.owner.onSuccess();
      this.owner = null;
    }
  }
  
  void setOwner(EMCallBack paramEMCallBack)
  {
    this.owner = paramEMCallBack;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */