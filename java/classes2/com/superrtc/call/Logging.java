package com.superrtc.call;

import com.superrtc.sdk.d;
import com.superrtc.sdk.d.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;

public class Logging
{
  private static d.d a = d.s;
  private static volatile boolean b;
  private static volatile boolean c;
  private static int d = d.r;
  
  static
  {
    try
    {
      System.loadLibrary("hyphenate_av");
      c = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      a.onLog(d, "Failed to load hyphenate_av: ");
    }
  }
  
  private static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static void d(String paramString1, String paramString2)
  {
    log(a.c, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    log(a.e, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(a.e, paramString1, paramString2);
    log(a.e, paramString1, paramThrowable.toString());
    log(a.e, paramString1, a(paramThrowable));
  }
  
  public static void enableLogThreads()
  {
    if (!c)
    {
      a.onLog(d, "Cannot enable log thread because native lib not loaded.");
      return;
    }
    nativeEnableLogThreads();
  }
  
  public static void enableLogTimeStamps()
  {
    if (!c)
    {
      a.onLog(d, "Cannot enable log timestamps because native lib not loaded.");
      return;
    }
    nativeEnableLogTimeStamps();
  }
  
  /* Error */
  public static void enableTracing(String paramString, java.util.EnumSet<b> paramEnumSet, a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	com/superrtc/call/Logging:c	Z
    //   6: ifne +20 -> 26
    //   9: getstatic 28	com/superrtc/call/Logging:a	Lcom/superrtc/sdk/d$d;
    //   12: getstatic 33	com/superrtc/call/Logging:d	I
    //   15: ldc 107
    //   17: invokeinterface 51 3 0
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: getstatic 109	com/superrtc/call/Logging:b	Z
    //   29: ifne -7 -> 22
    //   32: aload_1
    //   33: invokevirtual 115	java/util/EnumSet:iterator	()Ljava/util/Iterator;
    //   36: astore_1
    //   37: iconst_0
    //   38: istore_3
    //   39: aload_1
    //   40: invokeinterface 121 1 0
    //   45: ifeq +21 -> 66
    //   48: aload_1
    //   49: invokeinterface 125 1 0
    //   54: checkcast 11	com/superrtc/call/Logging$b
    //   57: getfield 128	com/superrtc/call/Logging$b:p	I
    //   60: iload_3
    //   61: ior
    //   62: istore_3
    //   63: goto -24 -> 39
    //   66: aload_0
    //   67: iload_3
    //   68: aload_2
    //   69: invokevirtual 132	com/superrtc/call/Logging$a:ordinal	()I
    //   72: invokestatic 136	com/superrtc/call/Logging:nativeEnableTracing	(Ljava/lang/String;II)V
    //   75: iconst_1
    //   76: putstatic 109	com/superrtc/call/Logging:b	Z
    //   79: goto -57 -> 22
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramString	String
    //   0	88	1	paramEnumSet	java.util.EnumSet<b>
    //   0	88	2	parama	a
    //   38	30	3	i	int
    // Exception table:
    //   from	to	target	type
    //   3	22	82	finally
    //   26	37	82	finally
    //   39	63	82	finally
    //   66	79	82	finally
  }
  
  public static void log(a parama, String paramString1, String paramString2)
  {
    if (b)
    {
      nativeLog(parama.ordinal(), paramString1, paramString2);
      return;
    }
    switch (1.a[parama.ordinal()])
    {
    default: 
      parama = Level.FINE;
    }
    for (;;)
    {
      a.onLog(d, paramString1 + ": " + paramString2);
      return;
      parama = Level.SEVERE;
      continue;
      parama = Level.WARNING;
      continue;
      parama = Level.INFO;
    }
  }
  
  private static native void nativeEnableLogThreads();
  
  private static native void nativeEnableLogTimeStamps();
  
  private static native void nativeEnableTracing(String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeLog(int paramInt, String paramString1, String paramString2);
  
  public static void v(String paramString1, String paramString2)
  {
    log(a.b, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    log(a.d, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    log(a.d, paramString1, paramString2);
    log(a.d, paramString1, paramThrowable.toString());
    log(a.d, paramString1, a(paramThrowable));
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    public final int p;
    
    private b(int paramInt)
    {
      this.p = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */