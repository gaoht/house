package com.g.a;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONObject;

public class bi
{
  static HashMap a = new HashMap();
  static HashMap b = new HashMap();
  static String c = "utf-8";
  static byte[] d;
  private static volatile bi e = null;
  
  static
  {
    try
    {
      ad.a().register(b());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private bi()
  {
    String str = z.c(c.e.getPackageName());
    if ((c.e != null) && (str != null))
    {
      d = str.getBytes();
      return;
    }
    d = c.class.getSimpleName().getBytes();
  }
  
  public static void a() {}
  
  public static bi b()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new bi();
      }
      return e;
    }
    finally {}
  }
  
  /* Error */
  public java.util.List a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: invokestatic 82	com/g/a/bk:a	()Lcom/g/a/bk;
    //   9: aload_1
    //   10: bipush 100
    //   12: invokevirtual 85	com/g/a/bk:a	(Lcom/g/a/a;I)Ljava/util/List;
    //   15: astore 4
    //   17: aload_2
    //   18: astore_1
    //   19: aload 4
    //   21: invokeinterface 91 1 0
    //   26: ifle +73 -> 99
    //   29: new 93	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 94	java/util/ArrayList:<init>	()V
    //   36: astore_1
    //   37: aload 4
    //   39: invokeinterface 98 1 0
    //   44: astore_2
    //   45: aload_2
    //   46: invokeinterface 104 1 0
    //   51: ifeq +61 -> 112
    //   54: aload_2
    //   55: invokeinterface 108 1 0
    //   60: checkcast 109	[B
    //   63: astore_3
    //   64: aload_1
    //   65: new 64	java/lang/String
    //   68: dup
    //   69: aload_3
    //   70: getstatic 70	com/g/a/bi:d	[B
    //   73: invokestatic 112	com/g/a/z:b	([B[B)[B
    //   76: invokespecial 115	java/lang/String:<init>	([B)V
    //   79: invokeinterface 119 2 0
    //   84: pop
    //   85: goto -40 -> 45
    //   88: astore_3
    //   89: goto -44 -> 45
    //   92: astore_2
    //   93: aload_3
    //   94: astore_1
    //   95: aload_2
    //   96: invokestatic 125	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: areturn
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore_2
    //   109: goto -14 -> 95
    //   112: goto -13 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	bi
    //   0	115	1	parama	a
    //   3	52	2	localIterator	java.util.Iterator
    //   92	4	2	localThrowable1	Throwable
    //   108	1	2	localThrowable2	Throwable
    //   5	65	3	arrayOfByte	byte[]
    //   88	6	3	localThrowable3	Throwable
    //   15	23	4	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   64	85	88	java/lang/Throwable
    //   6	17	92	java/lang/Throwable
    //   19	37	92	java/lang/Throwable
    //   6	17	103	finally
    //   19	37	103	finally
    //   37	45	103	finally
    //   45	64	103	finally
    //   64	85	103	finally
    //   95	99	103	finally
    //   37	45	108	java/lang/Throwable
    //   45	64	108	java/lang/Throwable
  }
  
  public final void onTDEBEventDataStore(be parambe)
  {
    if (parambe == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((parambe.a == null) || (!parambe.a.b().equals("APP_SQL"))) {
          if ((parambe.a != null) && (parambe.a.b().equals("ENV")))
          {
            localObject = new bo(parambe.b, parambe.c);
            ((bo)localObject).setData(parambe.d);
            localObject = new bj(z.a(ce.a().a((bo)localObject, true, parambe.a).toString().getBytes(), d));
            bk.a().a((bj)localObject, parambe);
            return;
          }
        }
      }
      catch (Throwable parambe)
      {
        parambe = parambe;
        av.postSDKError(parambe);
        return;
      }
      finally {}
    }
    Object localObject = new bo(parambe.b, parambe.c);
    ((bo)localObject).setData(parambe.d);
    localObject = new bj(z.a(ce.a().a((bo)localObject, true, parambe.a).toString().getBytes(), d));
    bk.a().a((bj)localObject, parambe);
  }
  
  public void sendMessageSuccess(a parama)
  {
    try
    {
      bk.a().confirmRead(parama);
      return;
    }
    catch (Throwable parama)
    {
      av.postSDKError(parama);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */