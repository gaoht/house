package com.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class i
{
  public static String a()
  {
    if (c.e == null) {
      return null;
    }
    try
    {
      String str = v.b(c.e, "TDpref_longtime", "TDaes_key", null);
      return str;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
    return null;
  }
  
  public static String a(a parama)
  {
    if ((c.e == null) || (parama == null)) {
      return null;
    }
    try
    {
      parama = v.b(c.e, "TDpref_longtime" + parama.c(), "TDpref.session.key", null);
      return parama;
    }
    catch (Throwable parama)
    {
      av.postSDKError(parama);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (c.e == null) {
      return null;
    }
    try
    {
      paramString = v.b(c.e, "TDpref_shorttime", paramString, null);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static void a(long paramLong, a parama)
  {
    if ((c.e == null) || (parama == null)) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_longtime" + parama.c(), "TDpref.start.key", paramLong);
      return;
    }
    catch (Throwable parama) {}
  }
  
  public static void a(String paramString, a parama)
  {
    if ((c.e == null) || (parama == null)) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_longtime" + parama.c(), "TDpref.session.key", paramString);
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_shorttime", paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static long b(a parama)
  {
    if ((c.e == null) || (parama == null)) {
      return 0L;
    }
    try
    {
      long l = v.b(c.e, "TDpref_longtime" + parama.c(), "TDpref.start.key", 0L);
      return l;
    }
    catch (Throwable parama) {}
    return 0L;
  }
  
  public static String b(String paramString)
  {
    if (c.e == null) {
      return null;
    }
    try
    {
      paramString = v.b(c.e, "TDpref_shorttime", paramString, null);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static void b()
  {
    if (c.e == null) {
      return;
    }
    try
    {
      c.e.getSharedPreferences("TD_CHANNEL_ID", 0).edit().putBoolean("location_called", true).commit();
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  public static void b(long paramLong, a parama)
  {
    if ((c.e == null) || (parama == null)) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_shorttime" + parama.c(), "TDpref.end.key", paramLong);
      return;
    }
    catch (Throwable parama) {}
  }
  
  public static void b(String paramString, a parama)
  {
    if ((c.e == null) || (parama == null)) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_longtime" + parama.c(), "TDisAppQuiting", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_shorttime", paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static long c(a parama)
  {
    if ((c.e == null) || (parama == null)) {
      return 0L;
    }
    try
    {
      long l = v.b(c.e, "TDpref_shorttime" + parama.c(), "TDpref.end.key", 0L);
      return l;
    }
    catch (Throwable parama) {}
    return 0L;
  }
  
  public static String c(String paramString)
  {
    if (c.e == null) {
      return "";
    }
    try
    {
      paramString = v.b(c.e, "TDpref_game", paramString + "TDpref.accountgame.key", "");
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_game", paramString1 + "TDpref.accountgame.key", paramString2);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static boolean c()
  {
    if (c.e == null) {
      return false;
    }
    try
    {
      boolean bool = c.e.getSharedPreferences("TD_CHANNEL_ID", 0).getBoolean("location_called", false);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
    return false;
  }
  
  public static String d()
  {
    if (c.e == null) {
      return "";
    }
    try
    {
      String str = v.b(c.e, "TDpref_shorttime", "TDpref.lastactivity.key", "");
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String d(a parama)
  {
    if ((c.e == null) || (parama == null)) {
      return "-1";
    }
    try
    {
      parama = v.b(c.e, "TDpref_longtime" + parama.c(), "TDisAppQuiting", "-1");
      return parama;
    }
    catch (Throwable parama) {}
    return "-1";
  }
  
  public static long e()
  {
    if (c.e == null) {
      return 0L;
    }
    try
    {
      long l = v.b(c.e, "TDpref_longtime", "TDpref.init.key", 0L);
      return l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public static long f()
  {
    if (c.e == null) {
      return 0L;
    }
    try
    {
      long l = v.b(c.e, "TDpref_shorttime", "TDpref.actstart.key", 0L);
      return l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public static long g()
  {
    if (c.e == null) {
      return 0L;
    }
    try
    {
      long l = v.b(c.e, "TDpref_longtime", "TDpref.running.app.key", 0L);
      return l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public static String h()
  {
    if (c.e == null) {
      return null;
    }
    try
    {
      String str = v.b(c.e, "TDpref_longtime", "TDadditionalVersionName", null);
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static long i()
  {
    if (c.e == null) {
      return -1L;
    }
    try
    {
      long l = v.b(c.e, "TDpref_longtime", "TDadditionalVersionCode", -1L);
      return l;
    }
    catch (Throwable localThrowable) {}
    return -1L;
  }
  
  public static int j()
  {
    try
    {
      if (i() != -1L) {
        return Integer.parseInt(String.valueOf(i()));
      }
      int i = g.a().b(c.e);
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  public static String k()
  {
    try
    {
      if (h() != null) {
        return h();
      }
      String str = g.a().c(c.e);
      return str;
    }
    catch (Throwable localThrowable) {}
    return "unknown";
  }
  
  public static String l()
  {
    if (c.e == null) {
      return null;
    }
    try
    {
      String str = v.b(c.e, "TDpref_shorttime", "TDtd_role_id", null);
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static long m()
  {
    if (c.e == null) {
      return 0L;
    }
    try
    {
      long l = v.b(c.e, "TDpref_shorttime", "TDtime_set_collect_net", 0L);
      return l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public static String n()
  {
    if (c.e == null) {
      return null;
    }
    try
    {
      String str = v.b(c.e, "TDpref_shorttime", "TDdeep_link_url", null);
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String o()
  {
    if (c.e == null) {
      return "";
    }
    try
    {
      String str = v.b(c.e, "TDpref_game", "TDpref.accountid.key", "");
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String p()
  {
    if (c.e == null) {
      return "";
    }
    try
    {
      String str = v.b(c.e, "TDpref_game", "TDpref.missionid.key", "");
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static void q()
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_game", "TDpref.game.session.startsystem.key", System.currentTimeMillis());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String r()
  {
    if (c.e == null) {
      return "";
    }
    try
    {
      String str = v.b(c.e, "TD_push_pref_file", "TDappcontext_push", "");
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static long s()
  {
    if (c.e == null) {
      return 0L;
    }
    try
    {
      long l = v.b(c.e, "TD_push_pref_file", "TDpref.tokensync.key", 0L);
      return l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public static void setAESKey(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_longtime", "TDaes_key", paramString);
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public static void setAccountId(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_game", "TDpref.accountid.key", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setActivityStartTime(long paramLong)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_shorttime", "TDpref.actstart.key", paramLong);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setAdditionalVersionCode(long paramLong)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_longtime", "TDadditionalVersionCode", paramLong);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setAdditionalVersionName(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_longtime", "TDadditionalVersionName", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setCollectNetInfoTime(long paramLong)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_shorttime", "TDtime_set_collect_net", paramLong);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setCollectRunningTime(long paramLong)
  {
    try
    {
      v.a(c.e, "TDpref_longtime", "TDpref.running.app.key", paramLong);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setDeepLink(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_shorttime", "TDdeep_link_url", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setInitTime(long paramLong)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_longtime", "TDpref.init.key", paramLong);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setLastActivity(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_shorttime", "TDpref.lastactivity.key", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setLastRoleName(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_shorttime", "TDtd_role_id", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setMissionId(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TDpref_game", "TDpref.missionid.key", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setPostProfile(boolean paramBoolean)
  {
    try
    {
      Context localContext = c.e;
      if (paramBoolean) {}
      for (long l = 1L;; l = 0L)
      {
        v.a(localContext, "TDpref_longtime", "TDpref.profile.key", l);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setPushAppContext(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TD_push_pref_file", "TDappcontext_push", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setPushLastMsgId(String paramString)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TD_push_pref_file", "TDpref.push.msgid.key", paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void setPushSyncTokenLastTime(long paramLong)
  {
    if (c.e == null) {
      return;
    }
    try
    {
      v.a(c.e, "TD_push_pref_file", "TDpref.tokensync.key", paramLong);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String t()
  {
    if (c.e == null) {
      return "";
    }
    try
    {
      String str = v.b(c.e, "TD_push_pref_file", "TDpref.push.msgid.key", "");
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */