package com.mob.wrappers;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.mob.jimu.biz.ReadOnlyProperty;
import com.mob.jimu.biz.ReadWriteProperty;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import com.mob.ums.OperationCallback;
import com.mob.ums.UMSSDK;
import com.mob.ums.User;
import com.mob.ums.gui.UMSGUI;

public class UMSSDKWrapper
  implements PublicMemberKeeper
{
  private static int state;
  private static int stateGUI;
  
  public static void getLoginUser(CallbackWrapper paramCallbackWrapper)
  {
    if (isAvailable()) {
      try
      {
        UMSSDK.getLoginUser(new OperationCallback()
        {
          public void onFailed(Throwable paramAnonymousThrowable)
          {
            if (this.val$callback != null) {
              this.val$callback.onError(paramAnonymousThrowable);
            }
          }
          
          public void onSuccess(User paramAnonymousUser)
          {
            if (this.val$callback != null) {
              this.val$callback.onSuccess(new UMSSDKWrapper.User(paramAnonymousUser, null));
            }
          }
        });
        return;
      }
      catch (Throwable localThrowable)
      {
        UIHandler.sendEmptyMessage(0, new Handler.Callback()
        {
          public boolean handleMessage(Message paramAnonymousMessage)
          {
            if (this.val$callback != null) {
              this.val$callback.onError(localThrowable);
            }
            return false;
          }
        });
        return;
      }
    }
    unAvailable(paramCallbackWrapper, 1);
  }
  
  public static String getLoginUserId()
  {
    if (isAvailable()) {
      return UMSSDK.getLoginUserId();
    }
    return null;
  }
  
  public static String getLoginUserToken()
  {
    if (isAvailable()) {
      return UMSSDK.getLoginUserToken();
    }
    return null;
  }
  
  public static boolean hasLogin()
  {
    return !TextUtils.isEmpty(getLoginUserToken());
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
          ReflectHelper.importClass("com.mob.ums.UMSSDK");
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
  
  private static boolean isAvailableGUI()
  {
    if (stateGUI == 0) {}
    try
    {
      ReflectHelper.importClass("com.mob.ums.gui.UMSGUI");
      stateGUI = 1;
      if (stateGUI == 1) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        stateGUI = -1;
      }
    }
    return false;
  }
  
  public static void logout()
  {
    if (isAvailable()) {
      UMSSDK.logout(null);
    }
  }
  
  public static void showLogin(CallbackWrapper paramCallbackWrapper)
  {
    if (isAvailableGUI())
    {
      UMSGUI.showLogin(new OperationCallback()
      {
        public void onFailed(Throwable paramAnonymousThrowable)
        {
          if (this.val$callback != null) {
            this.val$callback.onError(paramAnonymousThrowable);
          }
        }
        
        public void onSuccess(User paramAnonymousUser)
        {
          if (this.val$callback != null) {
            this.val$callback.onSuccess(new UMSSDKWrapper.User(paramAnonymousUser, null));
          }
        }
      });
      return;
    }
    unAvailable(paramCallbackWrapper, 2);
  }
  
  private static void unAvailable(CallbackWrapper paramCallbackWrapper, final int paramInt)
  {
    UIHandler.sendEmptyMessage(0, new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if (this.val$callback != null) {
          if (paramInt != 2) {
            break label37;
          }
        }
        label37:
        for (paramAnonymousMessage = new Throwable("UMSSDKGUI is not available");; paramAnonymousMessage = new Throwable("UMSSDK is not available"))
        {
          this.val$callback.onError(paramAnonymousMessage);
          return false;
        }
      }
    });
  }
  
  public static abstract interface CallbackWrapper
  {
    public abstract void onError(Throwable paramThrowable);
    
    public abstract void onSuccess(UMSSDKWrapper.User paramUser);
  }
  
  public static class User
    implements PublicMemberKeeper
  {
    private User user;
    
    private User(User paramUser)
    {
      this.user = paramUser;
    }
    
    public String getAvatar()
    {
      if (this.user == null) {}
      while (this.user.avatar.isNull()) {
        return null;
      }
      return ((String[])this.user.avatar.get())[0];
    }
    
    public String getNickname()
    {
      if (this.user == null) {
        return null;
      }
      return (String)this.user.nickname.get();
    }
    
    public String getUserId()
    {
      if (this.user == null) {
        return null;
      }
      return (String)this.user.id.get();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/wrappers/UMSSDKWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */