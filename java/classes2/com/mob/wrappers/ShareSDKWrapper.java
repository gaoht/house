package com.mob.wrappers;

import android.os.Handler.Callback;
import android.os.Message;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.reflect.Field;
import java.util.HashMap;

public class ShareSDKWrapper
  implements PublicMemberKeeper
{
  private static int state;
  
  public static String getDbData(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isAvailable())
    {
      paramString = ShareSDK.getPlatform(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = paramString.getDb().exportData();
      }
    }
    return (String)localObject1;
  }
  
  public static String[] getPlatformList()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isAvailable())
    {
      Platform[] arrayOfPlatform = ShareSDK.getPlatformList();
      localObject1 = localObject2;
      if (arrayOfPlatform != null)
      {
        localObject1 = new String[arrayOfPlatform.length];
        int i = 0;
        while (i < arrayOfPlatform.length)
        {
          localObject1[i] = arrayOfPlatform[i].getName();
          i += 1;
        }
      }
    }
    return (String[])localObject1;
  }
  
  public static int getPlatformToId(String paramString)
  {
    if (isAvailable()) {
      return ShareSDK.platformNameToId(paramString);
    }
    return 0;
  }
  
  public static String getToken(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isAvailable())
    {
      paramString = ShareSDK.getPlatform(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = paramString.getDb().getToken();
      }
    }
    return (String)localObject1;
  }
  
  public static String getUserID(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isAvailable())
    {
      paramString = ShareSDK.getPlatform(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = paramString.getDb().getUserId();
      }
    }
    return (String)localObject1;
  }
  
  public static String getUserName(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isAvailable())
    {
      paramString = ShareSDK.getPlatform(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = paramString.getDb().getUserName();
      }
    }
    return (String)localObject1;
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
          ReflectHelper.importClass("cn.sharesdk.framework.ShareSDK");
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
  
  public static boolean isLogin(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isAvailable())
    {
      paramString = ShareSDK.getPlatform(paramString);
      bool1 = bool2;
      if (paramString != null) {
        bool1 = paramString.isAuthValid();
      }
    }
    return bool1;
  }
  
  private static boolean isOneKeyShareAvailable()
  {
    try
    {
      ReflectHelper.importClass("cn.sharesdk.onekeyshare.OnekeyShare");
      return true;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static void login(String paramString, final CallbackWrapper paramCallbackWrapper)
  {
    if (isAvailable())
    {
      localPlatform = ShareSDK.getPlatform(paramString);
      if (localPlatform == null) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback()
        {
          public boolean handleMessage(Message paramAnonymousMessage)
          {
            paramAnonymousMessage = new Throwable("platform " + this.val$platform + " is not exist or disable");
            paramCallbackWrapper.onError(this.val$platform, 8, paramAnonymousMessage);
            return false;
          }
        });
      }
    }
    while (paramCallbackWrapper == null)
    {
      Platform localPlatform;
      do
      {
        return;
        localPlatform.showUser(null);
      } while (paramCallbackWrapper == null);
      localPlatform.setPlatformActionListener(new PlatformActionListener()
      {
        public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
        {
          this.val$callback.onCancel(paramAnonymousPlatform.getName(), paramAnonymousInt);
        }
        
        public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
        {
          this.val$callback.onComplete(paramAnonymousPlatform.getName(), paramAnonymousInt, paramAnonymousHashMap);
        }
        
        public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
        {
          this.val$callback.onError(paramAnonymousPlatform.getName(), paramAnonymousInt, paramAnonymousThrowable);
        }
      });
      return;
    }
    UIHandler.sendEmptyMessage(0, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        paramAnonymousMessage = new Throwable("platform " + this.val$platform + " is not exist or disable");
        paramCallbackWrapper.onError(this.val$platform, 8, paramAnonymousMessage);
        return false;
      }
    });
  }
  
  public static void logout(String paramString)
  {
    if (isAvailable())
    {
      paramString = ShareSDK.getPlatform(paramString);
      if (paramString != null) {
        paramString.removeAccount(true);
      }
    }
  }
  
  public static void oneKeyShare(String paramString, HashMap<String, Object> paramHashMap, CallbackWrapper paramCallbackWrapper)
  {
    OnekeyShare localOnekeyShare;
    int j;
    int i;
    if (isOneKeyShareAvailable())
    {
      localOnekeyShare = new OnekeyShare();
      if (paramString != null) {
        localOnekeyShare.setPlatform(paramString);
      }
      if (paramCallbackWrapper != null) {
        localOnekeyShare.setCallback(new PlatformActionListener()
        {
          public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
          {
            this.val$callback.onCancel(paramAnonymousPlatform.getName(), paramAnonymousInt);
          }
          
          public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
          {
            this.val$callback.onComplete(paramAnonymousPlatform.getName(), paramAnonymousInt, paramAnonymousHashMap);
          }
          
          public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
          {
            this.val$callback.onError(paramAnonymousPlatform.getName(), paramAnonymousInt, paramAnonymousThrowable);
          }
        });
      }
      paramString = localOnekeyShare.getClass().getDeclaredFields();
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        paramCallbackWrapper = paramString[i];
        if (!HashMap.class.isAssignableFrom(paramCallbackWrapper.getType())) {}
      }
      else
      {
        try
        {
          paramCallbackWrapper.setAccessible(true);
          ((HashMap)paramCallbackWrapper.get(localOnekeyShare)).putAll(paramHashMap);
          localOnekeyShare.show(MobSDK.getContext());
          return;
        }
        catch (Throwable paramCallbackWrapper) {}
      }
      i += 1;
    }
  }
  
  public static void oneKeyShare(HashMap<String, Object> paramHashMap, CallbackWrapper paramCallbackWrapper)
  {
    oneKeyShare(null, paramHashMap, paramCallbackWrapper);
  }
  
  public static void share(String paramString, HashMap<String, Object> paramHashMap, final CallbackWrapper paramCallbackWrapper)
  {
    if (isAvailable())
    {
      localPlatform = ShareSDK.getPlatform(paramString);
      if (localPlatform == null) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback()
        {
          public boolean handleMessage(Message paramAnonymousMessage)
          {
            paramAnonymousMessage = new Throwable("platform " + this.val$platform + " is not exist or disable");
            paramCallbackWrapper.onError(this.val$platform, 9, paramAnonymousMessage);
            return false;
          }
        });
      }
    }
    while (paramCallbackWrapper == null)
    {
      Platform localPlatform;
      return;
      paramString = new Platform.ShareParams(paramHashMap);
      if (paramCallbackWrapper != null) {
        localPlatform.setPlatformActionListener(new PlatformActionListener()
        {
          public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
          {
            this.val$callback.onCancel(paramAnonymousPlatform.getName(), paramAnonymousInt);
          }
          
          public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
          {
            this.val$callback.onComplete(paramAnonymousPlatform.getName(), paramAnonymousInt, paramAnonymousHashMap);
          }
          
          public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
          {
            this.val$callback.onError(paramAnonymousPlatform.getName(), paramAnonymousInt, paramAnonymousThrowable);
          }
        });
      }
      localPlatform.share(paramString);
      return;
    }
    UIHandler.sendEmptyMessage(0, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        paramAnonymousMessage = new Throwable("platform " + this.val$platform + " is not exist or disable");
        paramCallbackWrapper.onError(this.val$platform, 9, paramAnonymousMessage);
        return false;
      }
    });
  }
  
  public static abstract interface CallbackWrapper
  {
    public abstract void onCancel(String paramString, int paramInt);
    
    public abstract void onComplete(String paramString, int paramInt, HashMap<String, Object> paramHashMap);
    
    public abstract void onError(String paramString, int paramInt, Throwable paramThrowable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/wrappers/ShareSDKWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */