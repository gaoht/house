package com.hyphenate.chat;

import android.text.TextUtils;
import android.util.Pair;
import com.hyphenate.chat.adapter.EMAError;
import com.hyphenate.chat.adapter.EMAPushConfigs;
import com.hyphenate.chat.adapter.EMAPushManager;
import com.hyphenate.chat.core.EMChatConfigPrivate;
import com.hyphenate.cloud.EMHttpClient;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.EMLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class EMPushManager
{
  private static final String TAG = EMPushManager.class.getSimpleName();
  EMAPushManager emaObject;
  EMClient mClient;
  
  EMPushManager(EMClient paramEMClient, EMAPushManager paramEMAPushManager)
  {
    this.emaObject = paramEMAPushManager;
    this.mClient = paramEMClient;
  }
  
  private void handleError(EMAError paramEMAError)
    throws HyphenateException
  {
    if (paramEMAError.errCode() != 0) {
      throw new HyphenateException(paramEMAError);
    }
  }
  
  public void disableOfflinePush(int paramInt1, int paramInt2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.disableOfflineNotification(paramInt1, paramInt2, localEMAError);
    handleError(localEMAError);
  }
  
  public void enableOfflinePush()
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.enableOfflineNotification(localEMAError);
    handleError(localEMAError);
  }
  
  public List<String> getNoPushGroups()
  {
    return this.emaObject.getNoPushGroups();
  }
  
  public EMPushConfigs getPushConfigs()
  {
    EMAPushConfigs localEMAPushConfigs = this.emaObject.getPushConfigs();
    if (localEMAPushConfigs == null) {
      return null;
    }
    return new EMPushConfigs(localEMAPushConfigs);
  }
  
  public EMPushConfigs getPushConfigsFromServer()
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    EMAPushConfigs localEMAPushConfigs = this.emaObject.getPushConfigsFromServer(localEMAError);
    handleError(localEMAError);
    return new EMPushConfigs(localEMAPushConfigs);
  }
  
  public boolean updatePushNickname(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      EMLog.e(TAG, "nick name is null or empty");
      return false;
    }
    Object localObject2 = EMClient.getInstance().getCurrentUser();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      EMLog.e(TAG, "currentUser is null or empty");
      return false;
    }
    Object localObject1 = EMClient.getInstance().getAccessToken();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      EMLog.e(TAG, "token is null or empty");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder(EMClient.getInstance().getChatConfigPrivate().f());
    localStringBuilder.append("/");
    localStringBuilder.append("users/");
    localStringBuilder.append((String)localObject2);
    localObject2 = new HashMap();
    ((Map)localObject2).put("Authorization", "Bearer " + (String)localObject1);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("nickname", paramString);
      paramString = (String)EMHttpClient.getInstance().sendRequest(localStringBuilder.toString(), (Map)localObject2, ((JSONObject)localObject1).toString(), EMHttpClient.PUT).second;
      if (paramString.contains("error"))
      {
        EMLog.e(TAG, "response error : " + paramString);
        return false;
      }
    }
    catch (Exception paramString)
    {
      EMLog.e(TAG, "error:" + paramString.getMessage());
      return false;
    }
    return true;
  }
  
  public void updatePushServiceForGroup(List<String> paramList, boolean paramBoolean)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.updatePushServiceForGroup(paramList, paramBoolean, localEMAError);
    handleError(localEMAError);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMPushManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */