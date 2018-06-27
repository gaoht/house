package com.mob.wrappers;

import android.app.Notification;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import com.mob.pushsdk.MobPush;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.MobPushCustomMessage;
import com.mob.pushsdk.MobPushCustomNotification;
import com.mob.pushsdk.MobPushLocalNotification;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.MobPushReceiver;
import com.mob.tools.proguard.ClassKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import java.io.Serializable;
import java.util.HashMap;

public class MobPushWrapper
  implements PublicMemberKeeper
{
  private static HashMap<MobPushReceiverWrapper, Object> receiverWrapperMap = null;
  private static int state;
  
  public static boolean addLocalNotification(MobPushLocalNotificationWrapper paramMobPushLocalNotificationWrapper)
  {
    if ((!isAvailable()) || (paramMobPushLocalNotificationWrapper == null)) {
      return false;
    }
    MobPushLocalNotification localMobPushLocalNotification = new MobPushLocalNotification(paramMobPushLocalNotificationWrapper.getStyle(), paramMobPushLocalNotificationWrapper.getTitle(), paramMobPushLocalNotificationWrapper.getContent(), paramMobPushLocalNotificationWrapper.getStyleContent(), paramMobPushLocalNotificationWrapper.getInboxStyleContent(), paramMobPushLocalNotificationWrapper.getExtrasMap(), paramMobPushLocalNotificationWrapper.getMessageId(), paramMobPushLocalNotificationWrapper.getTimestamp(), paramMobPushLocalNotificationWrapper.isVoice(), paramMobPushLocalNotificationWrapper.isShake(), paramMobPushLocalNotificationWrapper.isLight());
    localMobPushLocalNotification.setNotificationId(paramMobPushLocalNotificationWrapper.getNotificationId());
    return MobPush.addLocalNotification(localMobPushLocalNotification);
  }
  
  public static void addPushReceiver(MobPushReceiverWrapper paramMobPushReceiverWrapper)
  {
    if (paramMobPushReceiverWrapper == null) {}
    for (;;)
    {
      return;
      if (!isAvailable()) {
        continue;
      }
      Object localObject = null;
      try
      {
        if (receiverWrapperMap == null) {
          receiverWrapperMap = new HashMap();
        }
        while (localObject == null)
        {
          localObject = new MobPushReceiver()
          {
            public void onAliasCallback(Context paramAnonymousContext, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              this.val$wrapper.onAliasCallback(paramAnonymousContext, paramAnonymousString, paramAnonymousInt1, paramAnonymousInt2);
            }
            
            public void onCustomMessageReceive(Context paramAnonymousContext, MobPushCustomMessage paramAnonymousMobPushCustomMessage)
            {
              MobPushWrapper.MobPushCustomMessageWrapper localMobPushCustomMessageWrapper = null;
              if (paramAnonymousMobPushCustomMessage != null) {
                localMobPushCustomMessageWrapper = new MobPushWrapper.MobPushCustomMessageWrapper(paramAnonymousMobPushCustomMessage.getContent(), paramAnonymousMobPushCustomMessage.getExtrasMap(), paramAnonymousMobPushCustomMessage.getMessageId(), paramAnonymousMobPushCustomMessage.getTimestamp());
              }
              this.val$wrapper.onCustomMessageReceive(paramAnonymousContext, localMobPushCustomMessageWrapper);
            }
            
            public void onNotifyMessageOpenedReceive(Context paramAnonymousContext, MobPushNotifyMessage paramAnonymousMobPushNotifyMessage)
            {
              MobPushWrapper.MobPushNotifyMessageWrapper localMobPushNotifyMessageWrapper = null;
              if (paramAnonymousMobPushNotifyMessage != null) {
                localMobPushNotifyMessageWrapper = new MobPushWrapper.MobPushNotifyMessageWrapper(paramAnonymousMobPushNotifyMessage.getStyle(), paramAnonymousMobPushNotifyMessage.getTitle(), paramAnonymousMobPushNotifyMessage.getContent(), paramAnonymousMobPushNotifyMessage.getStyleContent(), paramAnonymousMobPushNotifyMessage.getInboxStyleContent(), paramAnonymousMobPushNotifyMessage.getExtrasMap(), paramAnonymousMobPushNotifyMessage.getMessageId(), paramAnonymousMobPushNotifyMessage.getTimestamp(), paramAnonymousMobPushNotifyMessage.isVoice(), paramAnonymousMobPushNotifyMessage.isShake(), paramAnonymousMobPushNotifyMessage.isLight());
              }
              this.val$wrapper.onNotifyMessageOpenedReceive(paramAnonymousContext, localMobPushNotifyMessageWrapper);
            }
            
            public void onNotifyMessageReceive(Context paramAnonymousContext, MobPushNotifyMessage paramAnonymousMobPushNotifyMessage)
            {
              MobPushWrapper.MobPushNotifyMessageWrapper localMobPushNotifyMessageWrapper = null;
              if (paramAnonymousMobPushNotifyMessage != null) {
                localMobPushNotifyMessageWrapper = new MobPushWrapper.MobPushNotifyMessageWrapper(paramAnonymousMobPushNotifyMessage.getStyle(), paramAnonymousMobPushNotifyMessage.getTitle(), paramAnonymousMobPushNotifyMessage.getContent(), paramAnonymousMobPushNotifyMessage.getStyleContent(), paramAnonymousMobPushNotifyMessage.getInboxStyleContent(), paramAnonymousMobPushNotifyMessage.getExtrasMap(), paramAnonymousMobPushNotifyMessage.getMessageId(), paramAnonymousMobPushNotifyMessage.getTimestamp(), paramAnonymousMobPushNotifyMessage.isVoice(), paramAnonymousMobPushNotifyMessage.isShake(), paramAnonymousMobPushNotifyMessage.isLight());
              }
              this.val$wrapper.onNotifyMessageReceive(paramAnonymousContext, localMobPushNotifyMessageWrapper);
            }
            
            public void onTagsCallback(Context paramAnonymousContext, String[] paramAnonymousArrayOfString, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              this.val$wrapper.onTagsCallback(paramAnonymousContext, paramAnonymousArrayOfString, paramAnonymousInt1, paramAnonymousInt2);
            }
          };
          receiverWrapperMap.put(paramMobPushReceiverWrapper, localObject);
          MobPush.addPushReceiver((MobPushReceiver)localObject);
          return;
          localObject = (MobPushReceiver)receiverWrapperMap.get(paramMobPushReceiverWrapper);
        }
        return;
      }
      catch (Throwable paramMobPushReceiverWrapper) {}
    }
  }
  
  public static void addTags(String[] paramArrayOfString)
  {
    if (isAvailable()) {}
    try
    {
      MobPush.addTags(paramArrayOfString);
      return;
    }
    catch (Throwable paramArrayOfString) {}
  }
  
  public static void cleanTags()
  {
    if (isAvailable()) {}
    try
    {
      MobPush.cleanTags();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static boolean clearLocalNotifications()
  {
    if (isAvailable()) {
      return MobPush.clearLocalNotifications();
    }
    return false;
  }
  
  public static void deleteAlias()
  {
    if (isAvailable()) {}
    try
    {
      MobPush.deleteAlias();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void deleteTags(String[] paramArrayOfString)
  {
    if (isAvailable()) {}
    try
    {
      MobPush.deleteTags(paramArrayOfString);
      return;
    }
    catch (Throwable paramArrayOfString) {}
  }
  
  public static void getAlias()
  {
    if (isAvailable()) {}
    try
    {
      MobPush.getAlias();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void getRegistrationId(MobPushCallbackWrapper<String> paramMobPushCallbackWrapper)
  {
    if (isAvailable()) {}
    while (paramMobPushCallbackWrapper == null) {
      try
      {
        MobPush.getRegistrationId(new MobPushCallback()
        {
          public void onCallback(String paramAnonymousString)
          {
            if (this.val$callback != null) {
              this.val$callback.onSuccess(paramAnonymousString);
            }
          }
        });
        return;
      }
      catch (Throwable localThrowable)
      {
        while (paramMobPushCallbackWrapper == null) {}
        UIHandler.sendEmptyMessage(0, new Handler.Callback()
        {
          public boolean handleMessage(Message paramAnonymousMessage)
          {
            this.val$callback.onSuccess(null);
            return false;
          }
        });
        return;
      }
    }
    UIHandler.sendEmptyMessage(0, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        this.val$callback.onSuccess(null);
        return false;
      }
    });
  }
  
  public static void getTags()
  {
    if (isAvailable()) {}
    try
    {
      MobPush.getTags();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private static boolean isAvailable()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        int i = state;
        if (i == 0) {}
        try
        {
          ReflectHelper.importClass("com.mob.pushsdk.MobPush");
          state = 1;
          i = state;
          if (i == 1) {
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          state = -1;
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
  
  public static boolean isPushStopped()
  {
    if (isAvailable()) {
      try
      {
        boolean bool = MobPush.isPushStopped();
        return bool;
      }
      catch (Throwable localThrowable) {}
    }
    return false;
  }
  
  public static boolean removeLocalNotification(int paramInt)
  {
    if (isAvailable()) {
      return MobPush.removeLocalNotification(paramInt);
    }
    return false;
  }
  
  public static void removePushReceiver(MobPushReceiverWrapper paramMobPushReceiverWrapper)
  {
    if (paramMobPushReceiverWrapper == null) {}
    for (;;)
    {
      return;
      if (isAvailable()) {
        try
        {
          if (receiverWrapperMap != null)
          {
            paramMobPushReceiverWrapper = receiverWrapperMap.get(paramMobPushReceiverWrapper);
            if (paramMobPushReceiverWrapper != null)
            {
              MobPush.removePushReceiver((MobPushReceiver)paramMobPushReceiverWrapper);
              return;
            }
          }
        }
        catch (Throwable paramMobPushReceiverWrapper) {}
      }
    }
  }
  
  public static void restartPush()
  {
    if (isAvailable()) {}
    try
    {
      MobPush.restartPush();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setAlias(String paramString)
  {
    if (isAvailable()) {}
    try
    {
      MobPush.setAlias(paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setCustomNotification(MobPushCustomNotificationWrapper paramMobPushCustomNotificationWrapper)
  {
    if (isAvailable())
    {
      if (paramMobPushCustomNotificationWrapper == null) {}
      try
      {
        MobPush.setCustomNotification(null);
        return;
      }
      catch (Throwable paramMobPushCustomNotificationWrapper) {}
      MobPush.setCustomNotification(new MobPushCustomNotification()
      {
        public Notification getNotification(Context paramAnonymousContext, long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString4, String[] paramAnonymousArrayOfString, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3)
        {
          try
          {
            paramAnonymousContext = this.val$wrapper.getNotification(paramAnonymousContext, paramAnonymousLong, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString4, paramAnonymousArrayOfString, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousBoolean3);
            return paramAnonymousContext;
          }
          catch (Throwable paramAnonymousContext) {}
          return new Notification();
        }
      });
      return;
    }
  }
  
  public static void setSilenceTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isAvailable()) {}
    try
    {
      MobPush.setSilenceTime(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void stopPush()
  {
    if (isAvailable()) {}
    try
    {
      MobPush.stopPush();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static abstract interface MobPushCallbackWrapper<T>
  {
    public abstract void onSuccess(T paramT);
  }
  
  public static class MobPushCustomMessageWrapper
    implements ClassKeeper, Serializable
  {
    private String content;
    private HashMap<String, String> extrasMap;
    private String messageId;
    private long timestamp;
    
    public MobPushCustomMessageWrapper(String paramString1, HashMap<String, String> paramHashMap, String paramString2, long paramLong)
    {
      this.content = paramString1;
      this.extrasMap = paramHashMap;
      this.messageId = paramString2;
      this.timestamp = paramLong;
    }
    
    public String getContent()
    {
      return this.content;
    }
    
    public HashMap<String, String> getExtrasMap()
    {
      return this.extrasMap;
    }
    
    public String getMessageId()
    {
      return this.messageId;
    }
    
    public long getTimestamp()
    {
      return this.timestamp;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
    
    public void setExtrasMap(HashMap<String, String> paramHashMap)
    {
      this.extrasMap = paramHashMap;
    }
    
    public void setMessageId(String paramString)
    {
      this.messageId = paramString;
    }
    
    public void setTimestamp(long paramLong)
    {
      this.timestamp = paramLong;
    }
  }
  
  public static abstract interface MobPushCustomNotificationWrapper
  {
    public abstract Notification getNotification(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  }
  
  class MobPushLocalNotificationWrapper
    extends MobPushWrapper.MobPushNotifyMessageWrapper
  {
    private int notificationId;
    
    public MobPushLocalNotificationWrapper() {}
    
    public MobPushLocalNotificationWrapper(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, HashMap<String, String> paramHashMap, String paramString4, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super(paramString2, paramString3, paramArrayOfString, paramHashMap, paramString4, paramLong, ???, paramBoolean2, paramBoolean3, bool1);
    }
    
    public int getNotificationId()
    {
      return this.notificationId;
    }
    
    public void setNotificationId(int paramInt)
    {
      this.notificationId = paramInt;
    }
  }
  
  public static class MobPushNotifyMessageWrapper
    implements ClassKeeper, Serializable
  {
    private String content;
    private HashMap<String, String> extrasMap;
    private String[] inboxStyleContent;
    private boolean light = true;
    private String messageId;
    private boolean shake = true;
    private int style;
    private String styleContent;
    private long timestamp;
    private String title;
    private boolean voice = true;
    
    public MobPushNotifyMessageWrapper() {}
    
    public MobPushNotifyMessageWrapper(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, HashMap<String, String> paramHashMap, String paramString4, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.style = paramInt;
      this.title = paramString1;
      this.content = paramString2;
      this.styleContent = paramString3;
      this.inboxStyleContent = paramArrayOfString;
      this.extrasMap = paramHashMap;
      this.messageId = paramString4;
      this.timestamp = paramLong;
      this.voice = paramBoolean1;
      this.shake = paramBoolean2;
      this.light = paramBoolean3;
    }
    
    public String getContent()
    {
      return this.content;
    }
    
    public HashMap<String, String> getExtrasMap()
    {
      return this.extrasMap;
    }
    
    public String[] getInboxStyleContent()
    {
      return this.inboxStyleContent;
    }
    
    public String getMessageId()
    {
      return this.messageId;
    }
    
    public int getStyle()
    {
      return this.style;
    }
    
    public String getStyleContent()
    {
      return this.styleContent;
    }
    
    public long getTimestamp()
    {
      return this.timestamp;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public boolean isLight()
    {
      return this.light;
    }
    
    public boolean isShake()
    {
      return this.shake;
    }
    
    public boolean isVoice()
    {
      return this.voice;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
    
    public void setExtrasMap(HashMap<String, String> paramHashMap)
    {
      this.extrasMap = paramHashMap;
    }
    
    public void setInboxStyleContent(String[] paramArrayOfString)
    {
      this.inboxStyleContent = paramArrayOfString;
    }
    
    public void setLight(boolean paramBoolean)
    {
      this.light = paramBoolean;
    }
    
    public void setMessageId(String paramString)
    {
      this.messageId = paramString;
    }
    
    public void setShake(boolean paramBoolean)
    {
      this.shake = paramBoolean;
    }
    
    public void setStyle(int paramInt)
    {
      this.style = paramInt;
    }
    
    public void setStyleContent(String paramString)
    {
      this.styleContent = paramString;
    }
    
    public void setTimestamp(long paramLong)
    {
      this.timestamp = paramLong;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setVoice(boolean paramBoolean)
    {
      this.voice = paramBoolean;
    }
  }
  
  public static abstract interface MobPushReceiverWrapper
  {
    public abstract void onAliasCallback(Context paramContext, String paramString, int paramInt1, int paramInt2);
    
    public abstract void onCustomMessageReceive(Context paramContext, MobPushWrapper.MobPushCustomMessageWrapper paramMobPushCustomMessageWrapper);
    
    public abstract void onNotifyMessageOpenedReceive(Context paramContext, MobPushWrapper.MobPushNotifyMessageWrapper paramMobPushNotifyMessageWrapper);
    
    public abstract void onNotifyMessageReceive(Context paramContext, MobPushWrapper.MobPushNotifyMessageWrapper paramMobPushNotifyMessageWrapper);
    
    public abstract void onTagsCallback(Context paramContext, String[] paramArrayOfString, int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/wrappers/MobPushWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */