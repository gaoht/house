package com.hyphenate.cloud;

public abstract interface CloudOperationCallback
{
  public abstract void onError(String paramString);
  
  public abstract void onProgress(int paramInt);
  
  public abstract void onSuccess(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/cloud/CloudOperationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */