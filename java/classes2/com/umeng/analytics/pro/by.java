package com.umeng.analytics.pro;

import android.text.TextUtils;
import android.util.Log;
import java.util.Formatter;
import java.util.Locale;

public class by
{
  public static boolean a = false;
  private static String b = "MobclickAgent";
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 4;
  private static final int g = 5;
  private static int h = 2000;
  
  private static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    int j = 0;
    int m;
    int k;
    if (!TextUtils.isEmpty(paramString2))
    {
      m = paramString2.length();
      int i = h;
      k = 0;
      if (j < 100)
      {
        if (m > i)
        {
          switch (paramInt)
          {
          }
          for (;;)
          {
            int n = h;
            j += 1;
            k = i;
            i = n + i;
            break;
            Log.d(paramString1, paramString2.substring(k, i));
            continue;
            Log.i(paramString1, paramString2.substring(k, i));
            continue;
            Log.e(paramString1, paramString2.substring(k, i));
            continue;
            Log.v(paramString1, paramString2.substring(k, i));
            continue;
            Log.w(paramString1, paramString2.substring(k, i));
          }
        }
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      if (paramThrowable != null)
      {
        paramString2 = f(paramThrowable);
        if (TextUtils.isEmpty(paramString2)) {}
      }
      switch (paramInt)
      {
      default: 
        return;
        Log.d(paramString1, paramString2.substring(k, m));
        continue;
        Log.i(paramString1, paramString2.substring(k, m));
        continue;
        Log.e(paramString1, paramString2.substring(k, m));
        continue;
        Log.v(paramString1, paramString2.substring(k, m));
        continue;
        Log.w(paramString1, paramString2.substring(k, m));
      }
    }
    Log.d(paramString1, paramString2);
    return;
    Log.i(paramString1, paramString2);
    return;
    Log.e(paramString1, paramString2);
    return;
    Log.v(paramString1, paramString2);
    return;
    Log.w(paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    a(b, paramString, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      a(1, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    c(b, paramString, paramThrowable);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    String str = "";
    try
    {
      if (paramString.contains("%"))
      {
        paramString = new Formatter().format(paramString, paramVarArgs).toString();
        c(b, paramString, null);
        return;
      }
      if (paramVarArgs != null) {
        str = (String)paramVarArgs[0];
      }
      c(paramString, str, null);
      return;
    }
    catch (Throwable paramString)
    {
      e(paramString);
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    c(b, null, paramThrowable);
  }
  
  public static void a(Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramLocale = new Formatter(paramLocale).format(paramString, paramVarArgs).toString();
      c(b, paramLocale, null);
      return;
    }
    catch (Throwable paramLocale)
    {
      e(paramLocale);
    }
  }
  
  public static void b(String paramString)
  {
    b(b, paramString, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      a(2, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    a(b, paramString, paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    String str = "";
    try
    {
      if (paramString.contains("%"))
      {
        paramString = new Formatter().format(paramString, paramVarArgs).toString();
        b(b, paramString, null);
        return;
      }
      if (paramVarArgs != null) {
        str = (String)paramVarArgs[0];
      }
      b(paramString, str, null);
      return;
    }
    catch (Throwable paramString)
    {
      e(paramString);
    }
  }
  
  public static void b(Throwable paramThrowable)
  {
    a(b, null, paramThrowable);
  }
  
  public static void b(Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramLocale = new Formatter(paramLocale).format(paramString, paramVarArgs).toString();
      b(b, paramLocale, null);
      return;
    }
    catch (Throwable paramLocale)
    {
      e(paramLocale);
    }
  }
  
  public static void c(String paramString)
  {
    c(b, paramString, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      a(3, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    d(b, paramString, paramThrowable);
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    String str = "";
    try
    {
      if (paramString.contains("%"))
      {
        paramString = new Formatter().format(paramString, paramVarArgs).toString();
        e(b, paramString, null);
        return;
      }
      if (paramVarArgs != null) {
        str = (String)paramVarArgs[0];
      }
      e(paramString, str, null);
      return;
    }
    catch (Throwable paramString)
    {
      e(paramString);
    }
  }
  
  public static void c(Throwable paramThrowable)
  {
    d(b, null, paramThrowable);
  }
  
  public static void c(Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramLocale = new Formatter(paramLocale).format(paramString, paramVarArgs).toString();
      e(b, paramLocale, null);
      return;
    }
    catch (Throwable paramLocale)
    {
      e(paramLocale);
    }
  }
  
  public static void d(String paramString)
  {
    d(b, paramString, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      a(4, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    b(b, paramString, paramThrowable);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    String str = "";
    try
    {
      if (paramString.contains("%"))
      {
        paramString = new Formatter().format(paramString, paramVarArgs).toString();
        a(b, paramString, null);
        return;
      }
      if (paramVarArgs != null) {
        str = (String)paramVarArgs[0];
      }
      a(paramString, str, null);
      return;
    }
    catch (Throwable paramString)
    {
      e(paramString);
    }
  }
  
  public static void d(Throwable paramThrowable)
  {
    b(b, null, paramThrowable);
  }
  
  public static void d(Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramLocale = new Formatter(paramLocale).format(paramString, paramVarArgs).toString();
      a(b, paramLocale, null);
      return;
    }
    catch (Throwable paramLocale)
    {
      e(paramLocale);
    }
  }
  
  public static void e(String paramString)
  {
    e(b, paramString, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      a(5, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    e(b, paramString, paramThrowable);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    String str = "";
    try
    {
      if (paramString.contains("%"))
      {
        paramString = new Formatter().format(paramString, paramVarArgs).toString();
        d(b, paramString, null);
        return;
      }
      if (paramVarArgs != null) {
        str = (String)paramVarArgs[0];
      }
      d(paramString, str, null);
      return;
    }
    catch (Throwable paramString)
    {
      e(paramString);
    }
  }
  
  public static void e(Throwable paramThrowable)
  {
    e(b, null, paramThrowable);
  }
  
  public static void e(Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramLocale = new Formatter(paramLocale).format(paramString, paramVarArgs).toString();
      d(b, paramLocale, null);
      return;
    }
    catch (Throwable paramLocale)
    {
      e(paramLocale);
    }
  }
  
  /* Error */
  public static String f(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 85
    //   4: astore_3
    //   5: new 116	java/io/StringWriter
    //   8: dup
    //   9: invokespecial 117	java/io/StringWriter:<init>	()V
    //   12: astore_1
    //   13: new 119	java/io/PrintWriter
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 122	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   21: astore_2
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 126	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   27: aload_2
    //   28: invokevirtual 129	java/io/PrintWriter:flush	()V
    //   31: aload_1
    //   32: invokevirtual 130	java/io/StringWriter:flush	()V
    //   35: aload_1
    //   36: invokevirtual 131	java/io/StringWriter:toString	()Ljava/lang/String;
    //   39: astore_0
    //   40: aload_1
    //   41: ifnull +7 -> 48
    //   44: aload_1
    //   45: invokevirtual 134	java/io/StringWriter:close	()V
    //   48: aload_0
    //   49: astore_1
    //   50: aload_2
    //   51: ifnull +9 -> 60
    //   54: aload_2
    //   55: invokevirtual 135	java/io/PrintWriter:close	()V
    //   58: aload_0
    //   59: astore_1
    //   60: aload_1
    //   61: areturn
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_2
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 134	java/io/StringWriter:close	()V
    //   75: aload_3
    //   76: astore_1
    //   77: aload_0
    //   78: ifnull -18 -> 60
    //   81: aload_0
    //   82: invokevirtual 135	java/io/PrintWriter:close	()V
    //   85: ldc 85
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 134	java/io/StringWriter:close	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 135	java/io/PrintWriter:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_1
    //   112: goto -64 -> 48
    //   115: astore_1
    //   116: goto -41 -> 75
    //   119: astore_1
    //   120: goto -19 -> 101
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_2
    //   126: goto -33 -> 93
    //   129: astore_0
    //   130: goto -37 -> 93
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_0
    //   136: goto -69 -> 67
    //   139: astore_0
    //   140: aload_2
    //   141: astore_0
    //   142: goto -75 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramThrowable	Throwable
    //   12	86	1	localObject	Object
    //   111	1	1	localThrowable1	Throwable
    //   115	1	1	localThrowable2	Throwable
    //   119	1	1	localThrowable3	Throwable
    //   1	140	2	localPrintWriter	java.io.PrintWriter
    //   4	72	3	str	String
    // Exception table:
    //   from	to	target	type
    //   5	13	62	java/lang/Throwable
    //   5	13	88	finally
    //   44	48	111	java/lang/Throwable
    //   71	75	115	java/lang/Throwable
    //   97	101	119	java/lang/Throwable
    //   13	22	123	finally
    //   22	40	129	finally
    //   13	22	133	java/lang/Throwable
    //   22	40	139	java/lang/Throwable
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */