package com.mob.wrappers;

import android.os.Handler.Callback;
import android.os.Message;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import com.mob.MobSDK;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import java.util.HashSet;
import java.util.Iterator;

public class SMSSDKWrapper
  implements PublicMemberKeeper
{
  private static Integer state;
  
  /* Error */
  public static java.util.HashMap<Character, java.util.ArrayList<String[]>> getGroupedCountryList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 32	com/mob/wrappers/SMSSDKWrapper:isAvailable	()Z
    //   6: ifeq +12 -> 18
    //   9: invokestatic 38	cn/smssdk/SMSSDK:getGroupedCountryList	()Ljava/util/HashMap;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 40	java/util/HashMap
    //   21: dup
    //   22: invokespecial 41	java/util/HashMap:<init>	()V
    //   25: astore_0
    //   26: goto -13 -> 13
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	14	0	localHashMap	java.util.HashMap
    //   29	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	29	finally
    //   18	26	29	finally
  }
  
  public static void getSupportedCountries()
  {
    if (isAvailable())
    {
      SMSSDK.getSupportedCountries();
      return;
    }
    CallbackWrapper.broadcastNotAvailable(1);
  }
  
  public static void getVerificationCode(String paramString1, String paramString2)
  {
    getVerificationCode(paramString1, paramString2, null);
  }
  
  public static void getVerificationCode(String paramString1, String paramString2, BeforeSendMessage paramBeforeSendMessage)
  {
    if (isAvailable())
    {
      OnSendMessageHandler local1 = null;
      if (paramBeforeSendMessage != null) {
        local1 = new OnSendMessageHandler()
        {
          public boolean onSendMessage(String paramAnonymousString1, String paramAnonymousString2)
          {
            return this.val$listener.beforeSendMessage(paramAnonymousString1, paramAnonymousString2);
          }
        };
      }
      SMSSDK.getVerificationCode(paramString1, paramString2, local1);
      return;
    }
    CallbackWrapper.broadcastNotAvailable(2);
  }
  
  /* Error */
  public static void getVoiceVerifyCode(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 32	com/mob/wrappers/SMSSDKWrapper:isAvailable	()Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: aload_1
    //   11: invokestatic 64	cn/smssdk/SMSSDK:getVoiceVerifyCode	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: bipush 8
    //   20: invokestatic 50	com/mob/wrappers/SMSSDKWrapper$CallbackWrapper:access$200	(I)V
    //   23: goto -9 -> 14
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	paramString1	String
    //   0	32	1	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   3	14	26	finally
    //   18	23	26	finally
  }
  
  /* Error */
  private static boolean isAvailable()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 68	com/mob/wrappers/SMSSDKWrapper:state	Ljava/lang/Integer;
    //   8: ifnull +25 -> 33
    //   11: getstatic 68	com/mob/wrappers/SMSSDKWrapper:state	Ljava/lang/Integer;
    //   14: invokevirtual 74	java/lang/Integer:intValue	()I
    //   17: istore_0
    //   18: iload_0
    //   19: iconst_1
    //   20: if_icmpne +8 -> 28
    //   23: ldc 2
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_1
    //   30: goto -7 -> 23
    //   33: ldc 76
    //   35: invokestatic 82	com/mob/tools/utils/ReflectHelper:importClass	(Ljava/lang/String;)Ljava/lang/String;
    //   38: pop
    //   39: iconst_1
    //   40: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: putstatic 68	com/mob/wrappers/SMSSDKWrapper:state	Ljava/lang/Integer;
    //   46: getstatic 68	com/mob/wrappers/SMSSDKWrapper:state	Ljava/lang/Integer;
    //   49: invokevirtual 74	java/lang/Integer:intValue	()I
    //   52: iconst_1
    //   53: if_icmpeq -30 -> 23
    //   56: iconst_0
    //   57: istore_1
    //   58: goto -35 -> 23
    //   61: astore_2
    //   62: iconst_m1
    //   63: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: putstatic 68	com/mob/wrappers/SMSSDKWrapper:state	Ljava/lang/Integer;
    //   69: goto -23 -> 46
    //   72: astore_2
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	4	0	i	int
    //   1	57	1	bool	boolean
    //   61	1	2	localThrowable	Throwable
    //   72	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	46	61	java/lang/Throwable
    //   5	18	72	finally
    //   33	46	72	finally
    //   46	56	72	finally
    //   62	69	72	finally
  }
  
  public static void registerEventHandler(CallbackWrapper paramCallbackWrapper)
  {
    paramCallbackWrapper.registerEventHandler();
  }
  
  /* Error */
  public static void setAskPermisionOnReadContact(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 32	com/mob/wrappers/SMSSDKWrapper:isAvailable	()Z
    //   6: ifeq +15 -> 21
    //   9: iload_0
    //   10: ifeq +15 -> 25
    //   13: getstatic 99	cn/smssdk/SMSSDK$InitFlag:WARNNING_READCONTACT_DIALOG_MODE	Lcn/smssdk/SMSSDK$InitFlag;
    //   16: astore_1
    //   17: aload_1
    //   18: invokestatic 103	cn/smssdk/SMSSDK:setInitFlag	(Lcn/smssdk/SMSSDK$InitFlag;)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: getstatic 106	cn/smssdk/SMSSDK$InitFlag:DEFAULT	Lcn/smssdk/SMSSDK$InitFlag;
    //   28: astore_1
    //   29: goto -12 -> 17
    //   32: astore_1
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	paramBoolean	boolean
    //   16	13	1	localInitFlag	cn.smssdk.SMSSDK.InitFlag
    //   32	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	9	32	finally
    //   13	17	32	finally
    //   17	21	32	finally
    //   25	29	32	finally
  }
  
  public static void showVerificationPage(CallbackWrapper paramCallbackWrapper)
  {
    try
    {
      ReflectHelper.importClass("cn.smssdk.gui.RegisterPage");
      RegisterPage localRegisterPage = new RegisterPage();
      if (paramCallbackWrapper != null) {
        localRegisterPage.setRegisterCallback((EventHandler)paramCallbackWrapper.handler);
      }
      localRegisterPage.show(MobSDK.getContext());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (paramCallbackWrapper != null) {
          UIHandler.sendEmptyMessage(0, new Handler.Callback()
          {
            public boolean handleMessage(Message paramAnonymousMessage)
            {
              if (this.val$handler != null) {
                this.val$handler.afterEvent(0, 0, localThrowable);
              }
              return false;
            }
          });
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public static void submitVerificationCode(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 32	com/mob/wrappers/SMSSDKWrapper:isAvailable	()Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: aload_1
    //   11: aload_2
    //   12: invokestatic 145	cn/smssdk/SMSSDK:submitVerificationCode	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: iconst_3
    //   20: invokestatic 50	com/mob/wrappers/SMSSDKWrapper$CallbackWrapper:access$200	(I)V
    //   23: goto -8 -> 15
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	paramString1	String
    //   0	32	1	paramString2	String
    //   0	32	2	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   3	15	26	finally
    //   19	23	26	finally
  }
  
  public static void unregisterEventHandler(CallbackWrapper paramCallbackWrapper)
  {
    paramCallbackWrapper.unregisterEventHandler();
  }
  
  public static abstract interface BeforeSendMessage
  {
    public abstract boolean beforeSendMessage(String paramString1, String paramString2);
  }
  
  public static abstract class CallbackWrapper
    implements PublicMemberKeeper
  {
    private static final HashSet<CallbackWrapper> CALLBACKS = new HashSet();
    private Object handler;
    
    public CallbackWrapper()
    {
      if (SMSSDKWrapper.access$400()) {
        this.handler = new EventHandler()
        {
          public void afterEvent(final int paramAnonymousInt1, final int paramAnonymousInt2, final Object paramAnonymousObject)
          {
            UIHandler.sendEmptyMessage(0, new Handler.Callback()
            {
              public boolean handleMessage(Message paramAnonymous2Message)
              {
                SMSSDKWrapper.CallbackWrapper.this.afterEvent(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
                return false;
              }
            });
          }
        };
      }
    }
    
    private static void broadcastNotAvailable(int paramInt)
    {
      Throwable localThrowable = new Throwable("SMSSDK is not available");
      synchronized (CALLBACKS)
      {
        Iterator localIterator = CALLBACKS.iterator();
        if (localIterator.hasNext()) {
          ((CallbackWrapper)localIterator.next()).afterEvent(paramInt, 0, localThrowable);
        }
      }
    }
    
    private void registerEventHandler()
    {
      if (SMSSDKWrapper.access$400())
      {
        SMSSDK.registerEventHandler((EventHandler)this.handler);
        return;
      }
      synchronized (CALLBACKS)
      {
        CALLBACKS.add(this);
        return;
      }
    }
    
    private void unregisterEventHandler()
    {
      if (SMSSDKWrapper.access$400())
      {
        SMSSDK.unregisterEventHandler((EventHandler)this.handler);
        return;
      }
      synchronized (CALLBACKS)
      {
        CALLBACKS.remove(this);
        return;
      }
    }
    
    protected abstract void afterEvent(int paramInt1, int paramInt2, Object paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/wrappers/SMSSDKWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */