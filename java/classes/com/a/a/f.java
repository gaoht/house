package com.a.a;

import com.a.a.a.n;
import com.a.a.a.o;
import com.a.a.a.s;
import com.a.a.a.t;
import com.a.a.b.d;
import java.io.InputStream;
import java.io.OutputStream;

public final class f
{
  private static h a = new s();
  private static j b = null;
  
  private static void a(e parame)
  {
    if (!(parame instanceof n)) {
      throw new UnsupportedOperationException("The serializing service works onlywith the XMPMeta implementation of this library");
    }
  }
  
  public static e create()
  {
    return new n();
  }
  
  public static h getSchemaRegistry()
  {
    return a;
  }
  
  /* Error */
  public static j getVersionInfo()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/a/a/f:b	Lcom/a/a/j;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +13 -> 21
    //   11: new 6	com/a/a/f$1
    //   14: dup
    //   15: invokespecial 42	com/a/a/f$1:<init>	()V
    //   18: putstatic 21	com/a/a/f:b	Lcom/a/a/j;
    //   21: getstatic 21	com/a/a/f:b	Lcom/a/a/j;
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: getstatic 48	java/lang/System:out	Ljava/io/PrintStream;
    //   34: aload_0
    //   35: invokevirtual 54	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   38: goto -17 -> 21
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	23	0	localj	j
    //   30	5	0	localThrowable	Throwable
    //   41	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	30	java/lang/Throwable
    //   3	7	41	finally
    //   11	21	41	finally
    //   21	25	41	finally
    //   31	38	41	finally
  }
  
  public static e parse(InputStream paramInputStream)
    throws c
  {
    return parse(paramInputStream, null);
  }
  
  public static e parse(InputStream paramInputStream, d paramd)
    throws c
  {
    return o.parse(paramInputStream, paramd);
  }
  
  public static e parseFromBuffer(byte[] paramArrayOfByte)
    throws c
  {
    return parseFromBuffer(paramArrayOfByte, null);
  }
  
  public static e parseFromBuffer(byte[] paramArrayOfByte, d paramd)
    throws c
  {
    return o.parse(paramArrayOfByte, paramd);
  }
  
  public static e parseFromString(String paramString)
    throws c
  {
    return parseFromString(paramString, null);
  }
  
  public static e parseFromString(String paramString, d paramd)
    throws c
  {
    return o.parse(paramString, paramd);
  }
  
  public static void reset()
  {
    a = new s();
  }
  
  public static void serialize(e parame, OutputStream paramOutputStream)
    throws c
  {
    serialize(parame, paramOutputStream, null);
  }
  
  public static void serialize(e parame, OutputStream paramOutputStream, com.a.a.b.f paramf)
    throws c
  {
    a(parame);
    t.serialize((n)parame, paramOutputStream, paramf);
  }
  
  public static byte[] serializeToBuffer(e parame, com.a.a.b.f paramf)
    throws c
  {
    a(parame);
    return t.serializeToBuffer((n)parame, paramf);
  }
  
  public static String serializeToString(e parame, com.a.a.b.f paramf)
    throws c
  {
    a(parame);
    return t.serializeToString((n)parame, paramf);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */