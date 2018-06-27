package com.ziroom.router.activityrouter;

import android.content.Context;
import android.net.Uri;

public class SimpleRouterCallback
  implements RouterCallback
{
  public void afterOpen(Context paramContext, Uri paramUri) {}
  
  public boolean beforeOpen(Context paramContext, Uri paramUri)
  {
    return false;
  }
  
  public void error(Context paramContext, Uri paramUri, Throwable paramThrowable) {}
  
  public void notFound(Context paramContext, Uri paramUri) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/SimpleRouterCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */