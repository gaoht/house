package com.ziroom.router.activityrouter;

import android.content.Context;
import android.net.Uri;

public abstract interface RouterCallback
{
  public abstract void afterOpen(Context paramContext, Uri paramUri);
  
  public abstract boolean beforeOpen(Context paramContext, Uri paramUri);
  
  public abstract void error(Context paramContext, Uri paramUri, Throwable paramThrowable);
  
  public abstract void notFound(Context paramContext, Uri paramUri);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/RouterCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */