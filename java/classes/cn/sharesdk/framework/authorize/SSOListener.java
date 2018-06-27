package cn.sharesdk.framework.authorize;

import android.os.Bundle;

public abstract interface SSOListener
{
  public abstract void onCancel();
  
  public abstract void onComplete(Bundle paramBundle);
  
  public abstract void onFailed(Throwable paramThrowable);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/authorize/SSOListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */