package cn.jiguang.api;

import android.content.Context;

public abstract interface JAnalyticsAction
{
  public abstract void dispatchPause(Context paramContext);
  
  public abstract void dispatchResume(Context paramContext);
  
  public abstract void dispatchStatus(Context paramContext, String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/JAnalyticsAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */