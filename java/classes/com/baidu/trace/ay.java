package com.baidu.trace;

import com.baidu.trace.c.g;

public class ay
  implements g
{
  protected static byte a;
  protected static int b;
  protected static byte[] c = new byte[32];
  protected static byte d;
  protected static String e;
  
  public final void a()
  {
    TraceJniInterface.a().setPushResult(b, a);
  }
  
  /* Error */
  public final void a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 41	com/baidu/trace/a/i
    //   3: dup
    //   4: invokespecial 42	com/baidu/trace/a/i:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: ldc 44
    //   12: invokevirtual 50	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: putfield 52	com/baidu/trace/a/i:a	Ljava/lang/String;
    //   18: aload_2
    //   19: aload_1
    //   20: ldc 54
    //   22: invokevirtual 58	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   25: putfield 59	com/baidu/trace/a/i:b	I
    //   28: aload_2
    //   29: aload_1
    //   30: ldc 61
    //   32: invokevirtual 58	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   35: i2b
    //   36: putfield 63	com/baidu/trace/a/i:c	B
    //   39: aload_2
    //   40: aload_1
    //   41: ldc 65
    //   43: invokevirtual 50	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: putfield 67	com/baidu/trace/a/i:d	Ljava/lang/String;
    //   49: invokestatic 72	com/baidu/trace/bc:a	()Lcom/baidu/trace/bc;
    //   52: aload_2
    //   53: aload_1
    //   54: ldc 74
    //   56: invokevirtual 78	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   59: invokevirtual 81	com/baidu/trace/bc:a	(Lcom/baidu/trace/a/i;J)V
    //   62: return
    //   63: astore_1
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ay
    //   0	68	1	paramJSONObject	org.json.JSONObject
    //   7	46	2	locali	com.baidu.trace.a.i
    // Exception table:
    //   from	to	target	type
    //   8	62	63	finally
    //   8	62	66	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */