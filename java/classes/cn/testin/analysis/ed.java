package cn.testin.analysis;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ed
  extends ec
{
  private static final byte[] j = { -1, 0 };
  private boolean i = false;
  private final Random k = new Random();
  
  private static byte[] a(String paramString)
  {
    long l2;
    try
    {
      l1 = Long.parseLong(paramString.replaceAll("[^0-9]", ""));
      l2 = paramString.split(" ").length - 1;
      if (l2 == 0L) {
        throw new eh("invalid Sec-WebSocket-Key (/key2/)");
      }
    }
    catch (NumberFormatException paramString)
    {
      throw new eh("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
    }
    long l1 = new Long(l1 / l2).longValue();
    int m = (byte)(int)(l1 >> 24);
    int n = (byte)(int)(l1 << 8 >> 24);
    int i1 = (byte)(int)(l1 << 16 >> 24);
    int i2 = (byte)(int)(l1 << 24 >> 24);
    return new byte[] { m, n, i1, i2 };
  }
  
  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    int m = paramString1[0];
    int n = paramString1[1];
    int i1 = paramString1[2];
    int i2 = paramString1[3];
    int i3 = paramString2[0];
    int i4 = paramString2[1];
    int i5 = paramString2[2];
    int i6 = paramString2[3];
    int i7 = paramArrayOfByte[0];
    int i8 = paramArrayOfByte[1];
    int i9 = paramArrayOfByte[2];
    int i10 = paramArrayOfByte[3];
    int i11 = paramArrayOfByte[4];
    int i12 = paramArrayOfByte[5];
    int i13 = paramArrayOfByte[6];
    int i14 = paramArrayOfByte[7];
    try
    {
      paramString1 = MessageDigest.getInstance("MD5");
      return paramString1.digest(new byte[] { m, n, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14 });
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  private static String e()
  {
    Random localRandom = new Random();
    long l = localRandom.nextInt(12) + 1;
    String str = Long.toString((localRandom.nextInt(Math.abs(new Long(4294967295L / l).intValue())) + 1) * l);
    int n = localRandom.nextInt(12);
    int m = 0;
    while (m < n + 1)
    {
      int i1 = Math.abs(localRandom.nextInt(str.length()));
      char c2 = (char)(localRandom.nextInt(95) + 33);
      char c1 = c2;
      if (c2 >= '0')
      {
        c1 = c2;
        if (c2 <= '9') {
          c1 = (char)(c2 - '\017');
        }
      }
      str = new StringBuilder(str).insert(i1, c1).toString();
      m += 1;
    }
    m = 0;
    while (m < l)
    {
      n = Math.abs(localRandom.nextInt(str.length() - 1) + 1);
      str = new StringBuilder(str).insert(n, " ").toString();
      m += 1;
    }
    return str;
  }
  
  public dy a(er paramer)
  {
    if ((paramer.b("Upgrade").equals("WebSocket")) && (paramer.b("Connection").contains("Upgrade")) && (paramer.b("Sec-WebSocket-Key1").length() > 0) && (!paramer.b("Sec-WebSocket-Key2").isEmpty()) && (paramer.c("Origin"))) {
      return dy.a;
    }
    return dy.b;
  }
  
  public dy a(er paramer, ey paramey)
  {
    if (this.i) {
      return dy.b;
    }
    try
    {
      if ((!paramey.b("Sec-WebSocket-Origin").equals(paramer.b("Origin"))) || (!a(paramey))) {
        return dy.b;
      }
      paramey = paramey.c();
      if ((paramey == null) || (paramey.length == 0)) {
        throw new ee();
      }
    }
    catch (eh paramer)
    {
      throw new RuntimeException("bad handshakerequest", paramer);
    }
    if (Arrays.equals(paramey, a(paramer.b("Sec-WebSocket-Key1"), paramer.b("Sec-WebSocket-Key2"), paramer.c()))) {
      return dy.a;
    }
    paramer = dy.b;
    return paramer;
  }
  
  public es a(es parames)
  {
    parames.a("Upgrade", "WebSocket");
    parames.a("Connection", "Upgrade");
    parames.a("Sec-WebSocket-Key1", e());
    parames.a("Sec-WebSocket-Key2", e());
    if (!parames.c("Origin")) {
      parames.a("Origin", "random" + this.k.nextInt());
    }
    byte[] arrayOfByte = new byte[8];
    this.k.nextBytes(arrayOfByte);
    parames.a(arrayOfByte);
    return parames;
  }
  
  public et a(er paramer, ez paramez)
  {
    paramez.a("WebSocket Protocol Handshake");
    paramez.a("Upgrade", "WebSocket");
    paramez.a("Connection", paramer.b("Connection"));
    paramez.a("Sec-WebSocket-Origin", paramer.b("Origin"));
    paramez.a("Sec-WebSocket-Location", "ws://" + paramer.b("Host") + paramer.a());
    String str1 = paramer.b("Sec-WebSocket-Key1");
    String str2 = paramer.b("Sec-WebSocket-Key2");
    paramer = paramer.c();
    if ((str1 == null) || (str2 == null) || (paramer == null) || (paramer.length != 8)) {
      throw new eh("Bad keys");
    }
    paramez.a(a(str1, str2, paramer));
    return paramez;
  }
  
  public ByteBuffer a(eo parameo)
  {
    if (parameo.f() == ep.f) {
      return ByteBuffer.wrap(j);
    }
    return super.a(parameo);
  }
  
  public dx b()
  {
    return dx.b;
  }
  
  public dw c()
  {
    return new ed();
  }
  
  public List<eo> c(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.mark();
    List localList2 = super.e(paramByteBuffer);
    List localList1 = localList2;
    if (localList2 == null)
    {
      paramByteBuffer.reset();
      localList1 = this.g;
      this.f = true;
      if (this.h == null)
      {
        this.h = ByteBuffer.allocate(2);
        if (paramByteBuffer.remaining() > this.h.remaining()) {
          throw new eg();
        }
      }
      else
      {
        throw new eg();
      }
      this.h.put(paramByteBuffer);
      if (this.h.hasRemaining()) {
        break label139;
      }
      if (Arrays.equals(this.h.array(), j)) {
        localList1.add(new em(1000));
      }
    }
    else
    {
      return localList1;
    }
    throw new eg();
    label139:
    this.g = new LinkedList();
    return localList1;
  }
  
  public ew d(ByteBuffer paramByteBuffer)
  {
    et localet = a(paramByteBuffer, this.d);
    if (((localet.c("Sec-WebSocket-Key1")) || (this.d == dp.a)) && (!localet.c("Sec-WebSocket-Version"))) {
      if (this.d != dp.b) {
        break label77;
      }
    }
    for (int m = 8;; m = 16)
    {
      byte[] arrayOfByte = new byte[m];
      try
      {
        paramByteBuffer.get(arrayOfByte);
        localet.a(arrayOfByte);
        return localet;
      }
      catch (BufferUnderflowException localBufferUnderflowException)
      {
        label77:
        throw new ee(paramByteBuffer.capacity() + 16);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */