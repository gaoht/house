package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b.a;
import com.xiaomi.push.service.aq;
import com.xiaomi.smack.util.d;
import java.io.IOException;
import java.nio.ByteBuffer;

public class b
{
  private static String b = d.a(5) + "-";
  private static long c = 0L;
  private static final byte[] f = new byte[0];
  String a = null;
  private b.a d;
  private short e = 2;
  private byte[] g = f;
  
  public b()
  {
    this.d = new b.a();
  }
  
  b(b.a parama, short paramShort, byte[] paramArrayOfByte)
  {
    this.d = parama;
    this.e = paramShort;
    this.g = paramArrayOfByte;
  }
  
  /* Error */
  @Deprecated
  public static b a(com.xiaomi.smack.packet.d paramd, String paramString)
  {
    // Byte code:
    //   0: new 2	com/xiaomi/slim/b
    //   3: dup
    //   4: invokespecial 65	com/xiaomi/slim/b:<init>	()V
    //   7: astore 4
    //   9: iconst_1
    //   10: istore_2
    //   11: aload_0
    //   12: invokevirtual 70	com/xiaomi/smack/packet/d:l	()Ljava/lang/String;
    //   15: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   18: istore_3
    //   19: iload_3
    //   20: istore_2
    //   21: aload 4
    //   23: iload_2
    //   24: invokevirtual 79	com/xiaomi/slim/b:a	(I)V
    //   27: aload 4
    //   29: aload_0
    //   30: invokevirtual 82	com/xiaomi/smack/packet/d:k	()Ljava/lang/String;
    //   33: invokevirtual 85	com/xiaomi/slim/b:a	(Ljava/lang/String;)V
    //   36: aload 4
    //   38: aload_0
    //   39: invokevirtual 88	com/xiaomi/smack/packet/d:n	()Ljava/lang/String;
    //   42: invokevirtual 90	com/xiaomi/slim/b:c	(Ljava/lang/String;)V
    //   45: aload 4
    //   47: aload_0
    //   48: invokevirtual 93	com/xiaomi/smack/packet/d:o	()Ljava/lang/String;
    //   51: invokevirtual 95	com/xiaomi/slim/b:b	(Ljava/lang/String;)V
    //   54: aload 4
    //   56: ldc 97
    //   58: aconst_null
    //   59: invokevirtual 100	com/xiaomi/slim/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload 4
    //   64: aload_0
    //   65: invokevirtual 102	com/xiaomi/smack/packet/d:c	()Ljava/lang/String;
    //   68: ldc 104
    //   70: invokevirtual 110	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   73: aload_1
    //   74: invokevirtual 113	com/xiaomi/slim/b:a	([BLjava/lang/String;)V
    //   77: aload_1
    //   78: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +43 -> 124
    //   84: aload 4
    //   86: iconst_3
    //   87: invokevirtual 122	com/xiaomi/slim/b:a	(S)V
    //   90: aload 4
    //   92: areturn
    //   93: astore 5
    //   95: new 20	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   102: ldc 124
    //   104: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 5
    //   109: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 130	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   121: goto -100 -> 21
    //   124: aload 4
    //   126: iconst_2
    //   127: invokevirtual 122	com/xiaomi/slim/b:a	(S)V
    //   130: aload 4
    //   132: ldc -124
    //   134: aconst_null
    //   135: invokevirtual 100	com/xiaomi/slim/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 4
    //   140: areturn
    //   141: astore_0
    //   142: new 20	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   149: ldc -122
    //   151: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: invokevirtual 135	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 130	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramd	com.xiaomi.smack.packet.d
    //   0	170	1	paramString	String
    //   10	14	2	i	int
    //   18	2	3	j	int
    //   7	161	4	localb	b
    //   93	15	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	19	93	java/lang/Exception
    //   62	90	141	java/io/UnsupportedEncodingException
    //   124	138	141	java/io/UnsupportedEncodingException
  }
  
  static b b(ByteBuffer paramByteBuffer)
  {
    try
    {
      if ((paramByteBuffer.getShort(0) != 49918) || (paramByteBuffer.getShort(2) != 4)) {
        throw new IOException("Malformed Input");
      }
    }
    catch (Exception paramByteBuffer)
    {
      com.xiaomi.channel.commonutils.logger.b.a("read Blob err :" + paramByteBuffer.getMessage());
      throw new IOException("Malformed Input");
    }
    short s = paramByteBuffer.getShort(6);
    int i = paramByteBuffer.getShort(8);
    int j = paramByteBuffer.getInt(10);
    b.a locala = new b.a();
    locala.b(paramByteBuffer.array(), 14, i);
    byte[] arrayOfByte = new byte[j];
    paramByteBuffer.position(i + 14);
    paramByteBuffer.get(arrayOfByte, 0, j);
    paramByteBuffer = new b(locala, s, arrayOfByte);
    return paramByteBuffer;
  }
  
  static int c(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer.getShort(8) + paramByteBuffer.getInt(10);
  }
  
  public static String g()
  {
    try
    {
      Object localObject1 = new StringBuilder().append(b);
      long l = c;
      c = 1L + l;
      localObject1 = Long.toString(l);
      return (String)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  static int n()
  {
    return 14;
  }
  
  public String a()
  {
    return this.d.l();
  }
  
  ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    int j = l();
    ByteBuffer localByteBuffer;
    if (paramByteBuffer != null)
    {
      localByteBuffer = paramByteBuffer;
      if (paramByteBuffer.remaining() >= j) {}
    }
    else
    {
      i = j;
      if (paramByteBuffer != null) {
        i = j + paramByteBuffer.capacity();
      }
      localByteBuffer = ByteBuffer.allocate(i);
      if (paramByteBuffer != null) {
        localByteBuffer.put(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.position());
      }
    }
    paramByteBuffer = localByteBuffer.slice();
    paramByteBuffer.putShort((short)49918);
    paramByteBuffer.putShort((short)4);
    paramByteBuffer.putShort((short)1);
    paramByteBuffer.putShort(this.e);
    paramByteBuffer.putShort((short)this.d.a());
    paramByteBuffer.putInt(this.g.length);
    int i = paramByteBuffer.position();
    this.d.a(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + i, this.d.a());
    paramByteBuffer.position(i + this.d.a());
    paramByteBuffer.put(this.g);
    i = localByteBuffer.position();
    localByteBuffer.position(paramByteBuffer.position() + i);
    return localByteBuffer;
  }
  
  public void a(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong != 0L) {
      this.d.a(paramLong);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      this.d.a(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.d.b(paramString2);
    }
  }
  
  public void a(String paramString)
  {
    this.d.e(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("command should not be empty");
    }
    this.d.c(paramString1);
    this.d.p();
    if (!TextUtils.isEmpty(paramString2)) {
      this.d.d(paramString2);
    }
  }
  
  public void a(short paramShort)
  {
    this.e = paramShort;
  }
  
  public void a(byte[] paramArrayOfByte, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.d.c(1);
      this.g = aq.a(aq.a(paramString, h()), paramArrayOfByte);
      return;
    }
    this.d.c(0);
    this.g = paramArrayOfByte;
  }
  
  public String b()
  {
    return this.d.n();
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  public int c()
  {
    return this.d.d();
  }
  
  public void c(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = paramString.indexOf("@");
    }
    try
    {
      long l = Long.parseLong(paramString.substring(0, i));
      int j = paramString.indexOf("/", i);
      String str = paramString.substring(i + 1, j);
      paramString = paramString.substring(j + 1);
      this.d.a(l);
      this.d.a(str);
      this.d.b(paramString);
      return;
    }
    catch (Exception paramString)
    {
      com.xiaomi.channel.commonutils.logger.b.a("Blob parse user err " + paramString.getMessage());
    }
  }
  
  public boolean d()
  {
    return this.d.x();
  }
  
  public byte[] d(String paramString)
  {
    if (this.d.u() == 1) {
      return aq.a(aq.a(paramString, h()), this.g);
    }
    if (this.d.u() == 0) {
      return this.g;
    }
    com.xiaomi.channel.commonutils.logger.b.a("unknow cipher = " + this.d.u());
    return this.g;
  }
  
  public int e()
  {
    return this.d.w();
  }
  
  public String f()
  {
    return this.d.y();
  }
  
  public String h()
  {
    String str = this.d.q();
    if ("ID_NOT_AVAILABLE".equals(str)) {
      str = null;
    }
    while (this.d.r()) {
      return str;
    }
    str = g();
    this.d.e(str);
    return str;
  }
  
  public String i()
  {
    return this.a;
  }
  
  public String j()
  {
    if (this.d.g()) {
      return Long.toString(this.d.f()) + "@" + this.d.h() + "/" + this.d.j();
    }
    return null;
  }
  
  public byte[] k()
  {
    return this.g;
  }
  
  public int l()
  {
    return n() + this.d.b() + this.g.length;
  }
  
  public short m()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "Blob [chid=" + c() + "; Id=" + h() + "; cmd=" + a() + "; type=" + m() + "; from=" + j() + " ]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/xiaomi/slim/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */