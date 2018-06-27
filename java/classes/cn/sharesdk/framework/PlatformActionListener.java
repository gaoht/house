package cn.sharesdk.framework;

import java.util.HashMap;

public abstract interface PlatformActionListener
{
  public abstract void onCancel(Platform paramPlatform, int paramInt);
  
  public abstract void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap);
  
  public abstract void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/PlatformActionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */