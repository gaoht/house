package com.hyphenate;

public abstract interface EMCallBack
{
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onProgress(int paramInt, String paramString);
  
  public abstract void onSuccess();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/EMCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */