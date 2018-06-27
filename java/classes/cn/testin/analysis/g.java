package cn.testin.analysis;

import android.text.TextUtils;

public class g
  implements Thread.UncaughtExceptionHandler
{
  private static g b = new g();
  private Thread.UncaughtExceptionHandler a;
  
  public static g a()
  {
    return b;
  }
  
  private boolean a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {}
    do
    {
      return true;
      paramThrowable = b(paramThrowable);
    } while (TextUtils.isEmpty(paramThrowable));
    ar.f("以下异常信息导致程序崩溃:\n");
    if (paramThrowable.contains("cn.testin.analysis."))
    {
      ar.h("crash:" + paramThrowable);
      return true;
    }
    ar.f(paramThrowable);
    return true;
  }
  
  /* Error */
  private String b(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 65	java/io/StringWriter
    //   6: dup
    //   7: invokespecial 66	java/io/StringWriter:<init>	()V
    //   10: astore 4
    //   12: new 68	java/io/PrintWriter
    //   15: dup
    //   16: aload 4
    //   18: invokespecial 71	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore_2
    //   24: aload_1
    //   25: aload_3
    //   26: invokevirtual 77	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 80	java/io/PrintWriter:flush	()V
    //   35: aload_3
    //   36: astore_2
    //   37: aload 4
    //   39: invokevirtual 81	java/io/StringWriter:toString	()Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +9 -> 55
    //   49: aload_3
    //   50: invokevirtual 84	java/io/PrintWriter:close	()V
    //   53: aload_1
    //   54: astore_2
    //   55: aload_2
    //   56: areturn
    //   57: astore 4
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: astore_2
    //   63: aload 4
    //   65: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   68: aload 5
    //   70: astore_2
    //   71: aload_1
    //   72: ifnull -17 -> 55
    //   75: aload_1
    //   76: invokevirtual 84	java/io/PrintWriter:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_1
    //   84: aload 5
    //   86: astore_2
    //   87: aload_1
    //   88: ifnull -33 -> 55
    //   91: aload_1
    //   92: invokevirtual 84	java/io/PrintWriter:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_1
    //   98: aload_2
    //   99: astore_1
    //   100: goto -16 -> 84
    //   103: astore 4
    //   105: aload_3
    //   106: astore_1
    //   107: goto -46 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	g
    //   0	110	1	paramThrowable	Throwable
    //   23	76	2	localObject1	Object
    //   21	85	3	localPrintWriter	java.io.PrintWriter
    //   10	28	4	localStringWriter	java.io.StringWriter
    //   57	7	4	localException1	Exception
    //   103	1	4	localException2	Exception
    //   1	84	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	22	57	java/lang/Exception
    //   3	22	81	finally
    //   24	29	97	finally
    //   31	35	97	finally
    //   37	43	97	finally
    //   63	68	97	finally
    //   24	29	103	java/lang/Exception
    //   31	35	103	java/lang/Exception
    //   37	43	103	java/lang/Exception
  }
  
  public void b()
  {
    this.a = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    a(paramThrowable);
    if (this.a != null) {
      this.a.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */