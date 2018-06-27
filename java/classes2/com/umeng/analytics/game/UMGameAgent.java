package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;

public class UMGameAgent
  extends MobclickAgent
{
  private static final String a = "Input string is null or empty";
  private static final String b = "Input string must be less than 64 chars";
  private static final String c = "Input value type is negative";
  private static final String d = "The int value for 'Pay Channels' ranges between 1 ~ 99 ";
  private static final c e = new c();
  private static Context f;
  
  private static boolean a(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().length() <= 0) {
      return true;
    }
    return false;
  }
  
  public static void bonus(double paramDouble, int paramInt)
  {
    if (paramDouble < 0.0D)
    {
      by.e("Input value type is negative");
      return;
    }
    if ((paramInt <= 0) || (paramInt >= 100))
    {
      by.e("The int value for 'Pay Channels' ranges between 1 ~ 99 ");
      return;
    }
    e.a(paramDouble, paramInt);
  }
  
  public static void bonus(String paramString, int paramInt1, double paramDouble, int paramInt2)
  {
    if (a(paramString))
    {
      by.e("Input string is null or empty");
      return;
    }
    if ((paramInt1 < 0) || (paramDouble < 0.0D))
    {
      by.e("Input value type is negative");
      return;
    }
    if ((paramInt2 <= 0) || (paramInt2 >= 100))
    {
      by.e("The int value for 'Pay Channels' ranges between 1 ~ 99 ");
      return;
    }
    e.a(paramString, paramInt1, paramDouble, paramInt2);
  }
  
  public static void buy(String paramString, int paramInt, double paramDouble)
  {
    if (a(paramString))
    {
      by.e("Input string is null or empty");
      return;
    }
    if ((paramInt < 0) || (paramDouble < 0.0D))
    {
      by.e("Input value type is negative");
      return;
    }
    e.a(paramString, paramInt, paramDouble);
  }
  
  public static void exchange(double paramDouble1, String paramString1, double paramDouble2, int paramInt, String paramString2)
  {
    if ((paramDouble1 < 0.0D) || (paramDouble2 < 0.0D))
    {
      by.e("Input value type is negative");
      return;
    }
    if ((paramInt <= 0) || (paramInt >= 100))
    {
      by.e("The int value for 'Pay Channels' ranges between 1 ~ 99 ");
      return;
    }
    e.a(paramDouble1, paramString1, paramDouble2, paramInt, paramString2);
  }
  
  public static void failLevel(String paramString)
  {
    if (a(paramString))
    {
      by.e("Input string is null or empty");
      return;
    }
    if (paramString.length() > 64)
    {
      by.e("Input string must be less than 64 chars");
      return;
    }
    e.d(paramString);
  }
  
  public static void finishLevel(String paramString)
  {
    if (a(paramString))
    {
      by.e("Input string is null or empty");
      return;
    }
    if (paramString.length() > 64)
    {
      by.e("Input string must be less than 64 chars");
      return;
    }
    e.c(paramString);
  }
  
  public static void init(Context paramContext)
  {
    e.a(paramContext);
    f = paramContext.getApplicationContext();
  }
  
  public static void onEvent(String paramString1, String paramString2)
  {
    onEvent(f, paramString1, paramString2);
  }
  
  public static void onSocialEvent(Context paramContext, String paramString, UMPlatformData... paramVarArgs)
  {
    if (paramContext == null)
    {
      by.e("context is null in onShareEvent");
      return;
    }
    com.umeng.analytics.social.d.d = "4";
    UMSocialService.share(paramContext, paramString, paramVarArgs);
  }
  
  public static void onSocialEvent(Context paramContext, UMPlatformData... paramVarArgs)
  {
    if (paramContext == null)
    {
      by.e("context is null in onShareEvent");
      return;
    }
    com.umeng.analytics.social.d.d = "4";
    UMSocialService.share(paramContext, paramVarArgs);
  }
  
  public static void pay(double paramDouble1, double paramDouble2, int paramInt)
  {
    if ((paramInt <= 0) || (paramInt >= 100))
    {
      by.e("The int value for 'Pay Channels' ranges between 1 ~ 99 ");
      return;
    }
    if ((paramDouble1 < 0.0D) || (paramDouble2 < 0.0D))
    {
      by.e("Input value type is negative");
      return;
    }
    e.a(paramDouble1, paramDouble2, paramInt);
  }
  
  public static void pay(double paramDouble1, String paramString, int paramInt1, double paramDouble2, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt2 >= 100))
    {
      by.e("The int value for 'Pay Channels' ranges between 1 ~ 99 ");
      return;
    }
    if ((paramDouble1 < 0.0D) || (paramInt1 < 0) || (paramDouble2 < 0.0D))
    {
      by.e("Input value type is negative");
      return;
    }
    if (a(paramString))
    {
      by.e("Input string is null or empty");
      return;
    }
    e.a(paramDouble1, paramString, paramInt1, paramDouble2, paramInt2);
  }
  
  public static void setPlayerLevel(int paramInt)
  {
    e.a(String.valueOf(paramInt));
  }
  
  public static void setTraceSleepTime(boolean paramBoolean)
  {
    e.a(paramBoolean);
  }
  
  public static void startLevel(String paramString)
  {
    if (a(paramString))
    {
      by.e("Input string is null or empty");
      return;
    }
    if (paramString.length() > 64)
    {
      by.e("Input string must be less than 64 chars");
      return;
    }
    e.b(paramString);
  }
  
  public static void use(String paramString, int paramInt, double paramDouble)
  {
    if (a(paramString))
    {
      by.e("Input string is null or empty");
      return;
    }
    if ((paramInt < 0) || (paramDouble < 0.0D))
    {
      by.e("Input value type is negative");
      return;
    }
    e.b(paramString, paramInt, paramDouble);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/game/UMGameAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */