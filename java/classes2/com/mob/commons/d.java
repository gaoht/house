package com.mob.commons;

import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;

public class d
{
  private static SharePrefrenceHelper a;
  
  public static String a()
  {
    try
    {
      o();
      String str = a.getString("key_ext_info");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      o();
      a.putLong("wifi_last_time", Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      o();
      a.putString("key_ext_info", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static void a(HashMap<String, Object> paramHashMap)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 11	com/mob/commons/d:o	()V
    //   6: aload_0
    //   7: ifnonnull +15 -> 22
    //   10: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   13: ldc 43
    //   15: invokevirtual 46	com/mob/tools/utils/SharePrefrenceHelper:remove	(Ljava/lang/String;)V
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   25: ldc 43
    //   27: new 48	com/mob/tools/utils/Hashon
    //   30: dup
    //   31: invokespecial 51	com/mob/tools/utils/Hashon:<init>	()V
    //   34: aload_0
    //   35: invokevirtual 55	com/mob/tools/utils/Hashon:fromHashMap	(Ljava/util/HashMap;)Ljava/lang/String;
    //   38: invokevirtual 40	com/mob/tools/utils/SharePrefrenceHelper:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   44: ldc 57
    //   46: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   49: invokestatic 31	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 35	com/mob/tools/utils/SharePrefrenceHelper:putLong	(Ljava/lang/String;Ljava/lang/Long;)V
    //   55: goto -37 -> 18
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramHashMap	HashMap<String, Object>
    // Exception table:
    //   from	to	target	type
    //   3	6	58	finally
    //   10	18	58	finally
    //   22	55	58	finally
  }
  
  public static void a(HashMap<String, Object> paramHashMap, int paramInt)
  {
    try
    {
      o();
      a.putString("key_utags_buffer_time", new Hashon().fromHashMap(paramHashMap));
      a.putLong("key_utags_buffer_time", Long.valueOf(System.currentTimeMillis() + paramInt * 1000));
      return;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  private static void a(boolean paramBoolean)
  {
    try
    {
      if ((a == null) || (paramBoolean))
      {
        a = new SharePrefrenceHelper(MobSDK.getContext());
        a.open("mob_commons", 1);
      }
      return;
    }
    finally {}
  }
  
  public static long b()
  {
    try
    {
      o();
      long l = a.getLong("wifi_last_time");
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void b(long paramLong)
  {
    try
    {
      o();
      a.putLong("key_cellinfo_next_total", Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void b(String paramString)
  {
    try
    {
      o();
      a.putString("wifi_last_info", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String c()
  {
    try
    {
      o();
      String str = a.getString("wifi_last_info");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void c(long paramLong)
  {
    try
    {
      o();
      a.putLong("key_art_next_total", Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void c(String paramString)
  {
    try
    {
      o();
      a.putString("key_cellinfo", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String d()
  {
    try
    {
      o();
      String str = a.getString("key_cellinfo");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void d(long paramLong)
  {
    try
    {
      o();
      a.putLong("key_backend_time", Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void d(String paramString)
  {
    try
    {
      o();
      a.putString("key_switches", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static long e()
  {
    try
    {
      o();
      long l = a.getLong("key_cellinfo_next_total");
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static void e(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 11	com/mob/commons/d:o	()V
    //   6: aload_0
    //   7: ifnonnull +15 -> 22
    //   10: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   13: ldc 107
    //   15: invokevirtual 46	com/mob/tools/utils/SharePrefrenceHelper:remove	(Ljava/lang/String;)V
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   25: ldc 107
    //   27: aload_0
    //   28: invokevirtual 40	com/mob/tools/utils/SharePrefrenceHelper:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: goto -13 -> 18
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	6	34	finally
    //   10	18	34	finally
    //   22	31	34	finally
  }
  
  public static long f()
  {
    try
    {
      o();
      long l = a.getLong("key_art_next_total");
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static void f(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 11	com/mob/commons/d:o	()V
    //   6: aload_0
    //   7: ifnonnull +15 -> 22
    //   10: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   13: ldc 110
    //   15: invokevirtual 46	com/mob/tools/utils/SharePrefrenceHelper:remove	(Ljava/lang/String;)V
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   25: ldc 110
    //   27: aload_0
    //   28: invokevirtual 40	com/mob/tools/utils/SharePrefrenceHelper:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: goto -13 -> 18
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	6	34	finally
    //   10	18	34	finally
    //   22	31	34	finally
  }
  
  public static String g()
  {
    try
    {
      o();
      String str = a.getString("key_switches");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void g(String paramString)
  {
    try
    {
      o();
      a.putString("key_wifi_list_hash", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String h()
  {
    try
    {
      o();
      String str = a.getString("key_data_url");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void h(String paramString)
  {
    try
    {
      o();
      a.putString("key_simulator_info_md5", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String i()
  {
    try
    {
      o();
      String str = a.getString("key_conf_url");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String j()
  {
    try
    {
      o();
      String str = a.getString("key_wifi_list_hash");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static long k()
  {
    try
    {
      o();
      long l = a.getLong("key_last_utag_config");
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static HashMap<String, Object> l()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 11	com/mob/commons/d:o	()V
    //   6: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   9: ldc 43
    //   11: invokevirtual 21	com/mob/tools/utils/SharePrefrenceHelper:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_1
    //   15: aload_1
    //   16: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: istore_0
    //   20: iload_0
    //   21: ifeq +10 -> 31
    //   24: aconst_null
    //   25: astore_1
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_1
    //   30: areturn
    //   31: new 48	com/mob/tools/utils/Hashon
    //   34: dup
    //   35: invokespecial 51	com/mob/tools/utils/Hashon:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 131	com/mob/tools/utils/Hashon:fromJson	(Ljava/lang/String;)Ljava/util/HashMap;
    //   42: astore_1
    //   43: goto -17 -> 26
    //   46: astore_1
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	2	0	bool	boolean
    //   14	29	1	localObject1	Object
    //   46	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	20	46	finally
    //   31	43	46	finally
  }
  
  /* Error */
  public static HashMap<String, Object> m()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 11	com/mob/commons/d:o	()V
    //   9: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   12: ldc 68
    //   14: invokevirtual 90	com/mob/tools/utils/SharePrefrenceHelper:getLong	(Ljava/lang/String;)J
    //   17: lstore_0
    //   18: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   21: lstore_2
    //   22: lload_2
    //   23: lload_0
    //   24: lcmp
    //   25: ifle +9 -> 34
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload 4
    //   33: areturn
    //   34: getstatic 13	com/mob/commons/d:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   37: ldc -121
    //   39: invokevirtual 21	com/mob/tools/utils/SharePrefrenceHelper:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 5
    //   44: aload 5
    //   46: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne -21 -> 28
    //   52: new 48	com/mob/tools/utils/Hashon
    //   55: dup
    //   56: invokespecial 51	com/mob/tools/utils/Hashon:<init>	()V
    //   59: aload 5
    //   61: invokevirtual 131	com/mob/tools/utils/Hashon:fromJson	(Ljava/lang/String;)Ljava/util/HashMap;
    //   64: astore 4
    //   66: goto -38 -> 28
    //   69: astore 4
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload 4
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	7	0	l1	long
    //   21	2	2	l2	long
    //   1	64	4	localObject1	Object
    //   69	6	4	localObject2	Object
    //   42	18	5	str	String
    // Exception table:
    //   from	to	target	type
    //   6	22	69	finally
    //   34	44	69	finally
    //   44	66	69	finally
  }
  
  public static String n()
  {
    try
    {
      o();
      String str = a.getString("key_simulator_info_md5");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void o()
  {
    try
    {
      a(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */