package com.hyphenate.chat.adapter;

import java.util.List;

public class EMAPushManager
  extends EMABase
{
  public void disableOfflineNotification(int paramInt1, int paramInt2, EMAError paramEMAError)
  {
    nativeDisableOfflineNotification(paramInt1, paramInt2, paramEMAError);
  }
  
  public void enableOfflineNotification(EMAError paramEMAError)
  {
    nativeEnableOfflineNotification(paramEMAError);
  }
  
  public List<String> getNoPushGroups()
  {
    return nativeGetNoPushGroups();
  }
  
  public EMAPushConfigs getPushConfigs()
  {
    return nativeGetPushConfigs();
  }
  
  public EMAPushConfigs getPushConfigsFromServer(EMAError paramEMAError)
  {
    return nativeGetPushConfigsFromServer(paramEMAError);
  }
  
  native void nativeDisableOfflineNotification(int paramInt1, int paramInt2, EMAError paramEMAError);
  
  native void nativeEnableOfflineNotification(EMAError paramEMAError);
  
  native List<String> nativeGetNoPushGroups();
  
  native EMAPushConfigs nativeGetPushConfigs();
  
  native EMAPushConfigs nativeGetPushConfigsFromServer(EMAError paramEMAError);
  
  native void nativeUpdatePushServiceForGroup(List<String> paramList, boolean paramBoolean, EMAError paramEMAError);
  
  public void updatePushServiceForGroup(List<String> paramList, boolean paramBoolean, EMAError paramEMAError)
  {
    nativeUpdatePushServiceForGroup(paramList, paramBoolean, paramEMAError);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAPushManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */