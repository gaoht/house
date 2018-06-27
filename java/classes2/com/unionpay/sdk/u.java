package com.unionpay.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import java.util.zip.CRC32;

final class u
{
  private static volatile u a = null;
  private static p e = null;
  private final CRC32 b = new CRC32();
  private Handler c = null;
  private final HandlerThread d = new HandlerThread("NetWorkThread");
  
  static
  {
    a().d.start();
    a().c = new v(a().d.getLooper());
  }
  
  public static u a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new u();
      }
      return a;
    }
    finally {}
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, Object paramObject, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = a(paramArrayOfByte);
        if (ag.a) {
          k.b(new String[] { String.format("Gzipped post size is: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) }) });
        }
        this.b.reset();
        this.b.update(paramArrayOfByte);
        if (paramInt == 0)
        {
          paramString1 = paramString1 + "?crc=" + Long.toHexString(this.b.getValue());
          paramString1 = e.a(d.c, paramString3, paramString2, paramString1, paramString4, paramArrayOfByte);
          d.f = SystemClock.elapsedRealtime();
          paramString2 = new s();
          paramString2.a.putInt("statusCode", paramString1.a);
          paramString2.a.putString("responseMsg", paramString1.b);
          paramString2.a.putString("action", e.d);
          paramString2.b = paramObject;
          paramString2.c = paramInt;
        }
      }
      catch (Throwable paramString1)
      {
        k.a(paramString1);
        continue;
      }
      finally {}
      try
      {
        ar.a().post(paramString2);
        return;
        paramString1 = paramString1 + "?crc=" + Long.toHexString(this.b.getValue());
      }
      catch (Throwable paramString1)
      {
        k.a(paramString1);
      }
    }
  }
  
  /* Error */
  private static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 194	java/util/zip/Deflater
    //   3: dup
    //   4: bipush 9
    //   6: invokespecial 197	java/util/zip/Deflater:<init>	(I)V
    //   9: astore_2
    //   10: aload_2
    //   11: aload_0
    //   12: invokevirtual 200	java/util/zip/Deflater:setInput	([B)V
    //   15: new 202	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: aload_0
    //   20: arraylength
    //   21: invokespecial 203	java/io/ByteArrayOutputStream:<init>	(I)V
    //   24: astore_1
    //   25: aload_2
    //   26: invokevirtual 206	java/util/zip/Deflater:finish	()V
    //   29: sipush 1024
    //   32: newarray <illegal type>
    //   34: astore_3
    //   35: aload_2
    //   36: invokevirtual 210	java/util/zip/Deflater:finished	()Z
    //   39: ifne +28 -> 67
    //   42: aload_1
    //   43: aload_3
    //   44: iconst_0
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 214	java/util/zip/Deflater:deflate	([B)I
    //   50: invokevirtual 218	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -18 -> 35
    //   56: astore_0
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   65: aload_0
    //   66: athrow
    //   67: aload_1
    //   68: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_1
    //   72: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   75: aload_1
    //   76: invokevirtual 225	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   79: astore_1
    //   80: new 99	java/lang/StringBuilder
    //   83: dup
    //   84: ldc -29
    //   86: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: arraylength
    //   91: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 233	com/unionpay/sdk/k:a	(Ljava/lang/String;)V
    //   100: new 99	java/lang/StringBuilder
    //   103: dup
    //   104: ldc -21
    //   106: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: arraylength
    //   111: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 233	com/unionpay/sdk/k:a	(Ljava/lang/String;)V
    //   120: aload_1
    //   121: areturn
    //   122: astore_2
    //   123: aload_2
    //   124: invokestatic 190	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   127: goto -56 -> 71
    //   130: astore_1
    //   131: aload_1
    //   132: invokestatic 190	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   135: goto -70 -> 65
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_1
    //   141: goto -84 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramArrayOfByte	byte[]
    //   24	97	1	localObject1	Object
    //   130	2	1	localException1	Exception
    //   140	1	1	localObject2	Object
    //   9	37	2	localDeflater	java.util.zip.Deflater
    //   122	2	2	localException2	Exception
    //   34	13	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	35	56	finally
    //   35	53	56	finally
    //   67	71	122	java/lang/Exception
    //   61	65	130	java/lang/Exception
    //   15	25	138	finally
  }
  
  public final void onTDEBEventSubmitRequest(p paramp)
  {
    Message localMessage = new Message();
    localMessage.obj = paramp;
    this.c.sendMessage(localMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */