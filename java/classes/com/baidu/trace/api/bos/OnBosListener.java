package com.baidu.trace.api.bos;

public abstract interface OnBosListener
{
  public abstract void onGeneratePresignedUrlCallback(BosGeneratePresignedUrlResponse paramBosGeneratePresignedUrlResponse);
  
  public abstract void onGetObjectCallback(BosGetObjectResponse paramBosGetObjectResponse);
  
  public abstract void onPutObjectCallback(BosPutObjectResponse paramBosPutObjectResponse);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/OnBosListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */