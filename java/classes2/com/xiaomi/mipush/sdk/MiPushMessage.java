package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class MiPushMessage
  implements PushMessageHandler.a
{
  private String alias;
  private boolean arrived = false;
  private String category;
  private String content;
  private String description;
  private HashMap<String, String> extra = new HashMap();
  private boolean isNotified;
  private String messageId;
  private int messageType;
  private int notifyId;
  private int notifyType;
  private int passThrough;
  private String title;
  private String topic;
  private String userAccount;
  
  public static MiPushMessage fromBundle(Bundle paramBundle)
  {
    MiPushMessage localMiPushMessage = new MiPushMessage();
    localMiPushMessage.messageId = paramBundle.getString("messageId");
    localMiPushMessage.messageType = paramBundle.getInt("messageType");
    localMiPushMessage.passThrough = paramBundle.getInt("passThrough");
    localMiPushMessage.alias = paramBundle.getString("alias");
    localMiPushMessage.userAccount = paramBundle.getString("user_account");
    localMiPushMessage.topic = paramBundle.getString("topic");
    localMiPushMessage.content = paramBundle.getString("content");
    localMiPushMessage.description = paramBundle.getString("description");
    localMiPushMessage.title = paramBundle.getString("title");
    localMiPushMessage.isNotified = paramBundle.getBoolean("isNotified");
    localMiPushMessage.notifyId = paramBundle.getInt("notifyId");
    localMiPushMessage.notifyType = paramBundle.getInt("notifyType");
    localMiPushMessage.category = paramBundle.getString("category");
    localMiPushMessage.extra = ((HashMap)paramBundle.getSerializable("extra"));
    return localMiPushMessage;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public Map<String, String> getExtra()
  {
    return this.extra;
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public int getMessageType()
  {
    return this.messageType;
  }
  
  public int getNotifyId()
  {
    return this.notifyId;
  }
  
  public int getNotifyType()
  {
    return this.notifyType;
  }
  
  public int getPassThrough()
  {
    return this.passThrough;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getTopic()
  {
    return this.topic;
  }
  
  public String getUserAccount()
  {
    return this.userAccount;
  }
  
  public boolean isArrivedMessage()
  {
    return this.arrived;
  }
  
  public boolean isNotified()
  {
    return this.isNotified;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setArrivedMessage(boolean paramBoolean)
  {
    this.arrived = paramBoolean;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setExtra(Map<String, String> paramMap)
  {
    this.extra.clear();
    if (paramMap != null) {
      this.extra.putAll(paramMap);
    }
  }
  
  public void setMessageId(String paramString)
  {
    this.messageId = paramString;
  }
  
  public void setMessageType(int paramInt)
  {
    this.messageType = paramInt;
  }
  
  public void setNotified(boolean paramBoolean)
  {
    this.isNotified = paramBoolean;
  }
  
  public void setNotifyId(int paramInt)
  {
    this.notifyId = paramInt;
  }
  
  public void setNotifyType(int paramInt)
  {
    this.notifyType = paramInt;
  }
  
  public void setPassThrough(int paramInt)
  {
    this.passThrough = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setTopic(String paramString)
  {
    this.topic = paramString;
  }
  
  public void setUserAccount(String paramString)
  {
    this.userAccount = paramString;
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("messageId", this.messageId);
    localBundle.putInt("passThrough", this.passThrough);
    localBundle.putInt("messageType", this.messageType);
    if (!TextUtils.isEmpty(this.alias)) {
      localBundle.putString("alias", this.alias);
    }
    if (!TextUtils.isEmpty(this.userAccount)) {
      localBundle.putString("user_account", this.userAccount);
    }
    if (!TextUtils.isEmpty(this.topic)) {
      localBundle.putString("topic", this.topic);
    }
    localBundle.putString("content", this.content);
    if (!TextUtils.isEmpty(this.description)) {
      localBundle.putString("description", this.description);
    }
    if (!TextUtils.isEmpty(this.title)) {
      localBundle.putString("title", this.title);
    }
    localBundle.putBoolean("isNotified", this.isNotified);
    localBundle.putInt("notifyId", this.notifyId);
    localBundle.putInt("notifyType", this.notifyType);
    if (!TextUtils.isEmpty(this.category)) {
      localBundle.putString("category", this.category);
    }
    if (this.extra != null) {
      localBundle.putSerializable("extra", this.extra);
    }
    return localBundle;
  }
  
  public String toString()
  {
    return "messageId={" + this.messageId + "},passThrough={" + this.passThrough + "},alias={" + this.alias + "},topic={" + this.topic + "},userAccount={" + this.userAccount + "},content={" + this.content + "},description={" + this.description + "},title={" + this.title + "},isNotified={" + this.isNotified + "},notifyId={" + this.notifyId + "},notifyType={" + this.notifyType + "}, category={" + this.category + "}, extra={" + this.extra + "}";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/MiPushMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */