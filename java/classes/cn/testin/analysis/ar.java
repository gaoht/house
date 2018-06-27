package cn.testin.analysis;

import android.text.TextUtils;
import android.util.Log;

public final class ar
{
  public static boolean a = a.a;
  public static String b = "testin_ab";
  
  public static void a(String paramString)
  {
    if (a) {
      Log.d(b, paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a) {
      Log.d(paramString1, paramString2);
    }
  }
  
  /* Error */
  public static void a(String paramString, Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 33	java/io/StringWriter
    //   3: dup
    //   4: invokespecial 36	java/io/StringWriter:<init>	()V
    //   7: astore 4
    //   9: new 38	java/io/PrintWriter
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 41	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_1
    //   22: aload_3
    //   23: invokevirtual 47	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: invokevirtual 50	java/io/PrintWriter:flush	()V
    //   32: aload_3
    //   33: astore_2
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 54	java/io/StringWriter:toString	()Ljava/lang/String;
    //   40: invokestatic 57	cn/testin/analysis/ar:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: ifnull +7 -> 51
    //   47: aload_3
    //   48: invokevirtual 60	java/io/PrintWriter:close	()V
    //   51: return
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_0
    //   55: aload_0
    //   56: astore_2
    //   57: aload_1
    //   58: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   61: aload_0
    //   62: ifnull -11 -> 51
    //   65: aload_0
    //   66: invokevirtual 60	java/io/PrintWriter:close	()V
    //   69: return
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 60	java/io/PrintWriter:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: goto -11 -> 73
    //   87: astore_1
    //   88: aload_3
    //   89: astore_0
    //   90: goto -35 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString	String
    //   0	93	1	paramThrowable	Throwable
    //   20	58	2	localObject	Object
    //   18	71	3	localPrintWriter	java.io.PrintWriter
    //   7	29	4	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   0	19	52	java/lang/Exception
    //   0	19	70	finally
    //   21	26	83	finally
    //   28	32	83	finally
    //   34	43	83	finally
    //   57	61	83	finally
    //   21	26	87	java/lang/Exception
    //   28	32	87	java/lang/Exception
    //   34	43	87	java/lang/Exception
  }
  
  public static void a(Throwable paramThrowable)
  {
    a(b, paramThrowable);
  }
  
  public static void b(String paramString)
  {
    if (a) {
      Log.i(b, paramString);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a) {
      Log.i(paramString1, paramString2);
    }
  }
  
  /* Error */
  public static void b(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 33	java/io/StringWriter
    //   8: dup
    //   9: invokespecial 36	java/io/StringWriter:<init>	()V
    //   12: astore_3
    //   13: new 38	java/io/PrintWriter
    //   16: dup
    //   17: aload_3
    //   18: invokespecial 41	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   21: astore_2
    //   22: aload_2
    //   23: astore_1
    //   24: aload_0
    //   25: aload_2
    //   26: invokevirtual 47	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokevirtual 50	java/io/PrintWriter:flush	()V
    //   35: aload_2
    //   36: astore_1
    //   37: aload_3
    //   38: invokevirtual 54	java/io/StringWriter:toString	()Ljava/lang/String;
    //   41: astore_0
    //   42: aload_2
    //   43: astore_1
    //   44: getstatic 19	cn/testin/analysis/ar:b	Ljava/lang/String;
    //   47: aload_0
    //   48: invokestatic 71	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   51: pop
    //   52: aload_2
    //   53: astore_1
    //   54: invokestatic 76	cn/testin/analysis/aa:a	()Lcn/testin/analysis/aa;
    //   57: aload_0
    //   58: invokevirtual 78	cn/testin/analysis/aa:a	(Ljava/lang/String;)V
    //   61: aload_2
    //   62: ifnull -58 -> 4
    //   65: aload_2
    //   66: invokevirtual 60	java/io/PrintWriter:close	()V
    //   69: return
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: astore_1
    //   75: aload_3
    //   76: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   79: aload_0
    //   80: ifnull -76 -> 4
    //   83: aload_0
    //   84: invokevirtual 60	java/io/PrintWriter:close	()V
    //   87: return
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 60	java/io/PrintWriter:close	()V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: goto -11 -> 91
    //   105: astore_3
    //   106: aload_2
    //   107: astore_0
    //   108: goto -35 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramThrowable	Throwable
    //   23	73	1	localObject	Object
    //   21	86	2	localPrintWriter	java.io.PrintWriter
    //   12	26	3	localStringWriter	java.io.StringWriter
    //   70	6	3	localException1	Exception
    //   105	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	22	70	java/lang/Exception
    //   5	22	88	finally
    //   24	29	101	finally
    //   31	35	101	finally
    //   37	42	101	finally
    //   44	52	101	finally
    //   54	61	101	finally
    //   75	79	101	finally
    //   24	29	105	java/lang/Exception
    //   31	35	105	java/lang/Exception
    //   37	42	105	java/lang/Exception
    //   44	52	105	java/lang/Exception
    //   54	61	105	java/lang/Exception
  }
  
  public static void c(String paramString)
  {
    Log.i(b, paramString);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if ((a) && (!TextUtils.isEmpty(paramString2))) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString)
  {
    if (a) {
      Log.w(b, paramString);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString)
  {
    Log.w(b, paramString);
  }
  
  public static void f(String paramString)
  {
    if (a) {
      Log.e(b, paramString);
    }
  }
  
  public static void g(String paramString)
  {
    Log.e(b, paramString);
  }
  
  public static void h(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Log.e(b, paramString);
      aa.a().a(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */