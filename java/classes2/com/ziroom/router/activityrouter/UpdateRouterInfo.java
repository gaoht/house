package com.ziroom.router.activityrouter;

import android.net.Uri;

public class UpdateRouterInfo
{
  private String newPageUri;
  private String targetNeedReplayUri;
  
  public Uri getNewPageUri()
  {
    return Uri.parse(this.newPageUri);
  }
  
  public Uri getTargetNeedReplayUri()
  {
    return Uri.parse(this.targetNeedReplayUri);
  }
  
  public void setNewPageUri(String paramString)
  {
    this.newPageUri = paramString;
  }
  
  public void setTargetNeedReplayUri(String paramString)
  {
    this.targetNeedReplayUri = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/UpdateRouterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */