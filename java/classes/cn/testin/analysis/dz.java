package cn.testin.analysis;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class dz
  extends dw
{
  private ByteBuffer g;
  private eo h = null;
  private final Random i = new Random();
  
  static
  {
    if (!dz.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      return;
    }
  }
  
  private byte a(ep paramep)
  {
    if (paramep == ep.a) {
      return 0;
    }
    if (paramep == ep.b) {
      return 1;
    }
    if (paramep == ep.c) {
      return 2;
    }
    if (paramep == ep.f) {
      return 8;
    }
    if (paramep == ep.d) {
      return 9;
    }
    if (paramep == ep.e) {
      return 10;
    }
    throw new RuntimeException("Don't know how to handle " + paramep.toString());
  }
  
  private ep a(byte paramByte)
  {
    switch (paramByte)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new eg("unknow optcode " + (short)paramByte);
    case 0: 
      return ep.a;
    case 1: 
      return ep.b;
    case 2: 
      return ep.c;
    case 8: 
      return ep.f;
    case 9: 
      return ep.d;
    }
    return ep.e;
  }
  
  private String a(String paramString)
  {
    paramString = paramString.trim();
    paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      return fa.a(localMessageDigest.digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  private byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int j = 0;
    while (j < paramInt)
    {
      arrayOfByte[j] = ((byte)(int)(paramLong >>> paramInt * 8 - 8 - j * 8));
      j += 1;
    }
    return arrayOfByte;
  }
  
  public static int b(ew paramew)
  {
    int j = -1;
    paramew = paramew.b("Sec-WebSocket-Version");
    if (paramew.length() > 0) {}
    try
    {
      j = new Integer(paramew.trim()).intValue();
      return j;
    }
    catch (NumberFormatException paramew) {}
    return -1;
  }
  
  public dy a(er paramer)
  {
    int j = b(paramer);
    if ((j == 7) || (j == 8))
    {
      if (a(paramer)) {
        return dy.a;
      }
      return dy.b;
    }
    return dy.b;
  }
  
  public dy a(er paramer, ey paramey)
  {
    if ((!paramer.c("Sec-WebSocket-Key")) || (!paramey.c("Sec-WebSocket-Accept"))) {
      return dy.b;
    }
    paramey = paramey.b("Sec-WebSocket-Accept");
    if (a(paramer.b("Sec-WebSocket-Key")).equals(paramey)) {
      return dy.a;
    }
    return dy.b;
  }
  
  public es a(es parames)
  {
    parames.a("Upgrade", "websocket");
    parames.a("Connection", "Upgrade");
    parames.a("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.i.nextBytes(arrayOfByte);
    parames.a("Sec-WebSocket-Key", fa.a(arrayOfByte));
    return parames;
  }
  
  public et a(er paramer, ez paramez)
  {
    paramez.a("Upgrade", "websocket");
    paramez.a("Connection", paramer.b("Connection"));
    paramez.a("Switching Protocols");
    paramer = paramer.b("Sec-WebSocket-Key");
    if (paramer == null) {
      throw new eh("missing Sec-WebSocket-Key");
    }
    paramez.a("Sec-WebSocket-Accept", a(paramer));
    return paramez;
  }
  
  public ByteBuffer a(eo parameo)
  {
    int k = -128;
    int i2 = 0;
    ByteBuffer localByteBuffer1 = parameo.c();
    int m;
    int j;
    label39:
    label49:
    int i1;
    label57:
    ByteBuffer localByteBuffer2;
    if (this.d == dp.a)
    {
      m = 1;
      if (localByteBuffer1.remaining() > 125) {
        break label151;
      }
      j = 1;
      if (j <= 1) {
        break label172;
      }
      n = j + 1;
      if (m == 0) {
        break label178;
      }
      i1 = 4;
      localByteBuffer2 = ByteBuffer.allocate(i1 + (n + 1) + localByteBuffer1.remaining());
      i1 = a(parameo.f());
      if (!parameo.d()) {
        break label184;
      }
    }
    label151:
    label172:
    label178:
    label184:
    for (int n = -128;; n = 0)
    {
      localByteBuffer2.put((byte)((byte)n | i1));
      parameo = a(localByteBuffer1.remaining(), j);
      if ((f) || (parameo.length == j)) {
        break label190;
      }
      throw new AssertionError();
      m = 0;
      break;
      if (localByteBuffer1.remaining() <= 65535)
      {
        j = 2;
        break label39;
      }
      j = 8;
      break label39;
      n = j;
      break label49;
      i1 = 0;
      break label57;
    }
    label190:
    if (j == 1)
    {
      j = parameo[0];
      if (m != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(j | k));
        if (m == 0) {
          break;
        }
        parameo = ByteBuffer.allocate(4);
        parameo.putInt(this.i.nextInt());
        localByteBuffer2.put(parameo.array());
        j = i2;
        while (localByteBuffer1.hasRemaining())
        {
          localByteBuffer2.put((byte)(localByteBuffer1.get() ^ parameo.get(j % 4)));
          j += 1;
        }
        k = 0;
      }
    }
    if (j == 2)
    {
      if (m != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(k | 0x7E));
        localByteBuffer2.put(parameo);
        break;
        k = 0;
      }
    }
    if (j == 8)
    {
      if (m != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(k | 0x7F));
        localByteBuffer2.put(parameo);
        break;
        k = 0;
      }
    }
    throw new RuntimeException("Size representation not supported/specified");
    localByteBuffer2.put(localByteBuffer1);
    if ((!f) && (localByteBuffer2.remaining() != 0)) {
      throw new AssertionError(localByteBuffer2.remaining());
    }
    localByteBuffer2.flip();
    return localByteBuffer2;
  }
  
  public void a()
  {
    this.g = null;
  }
  
  public dx b()
  {
    return dx.c;
  }
  
  public dw c()
  {
    return new dz();
  }
  
  public List<eo> c(ByteBuffer paramByteBuffer)
  {
    LinkedList localLinkedList = new LinkedList();
    if (this.g != null) {}
    try
    {
      paramByteBuffer.mark();
      int j = paramByteBuffer.remaining();
      int k = this.g.remaining();
      if (k > j)
      {
        this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(j + paramByteBuffer.position());
        return Collections.emptyList();
      }
      this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), k);
      paramByteBuffer.position(paramByteBuffer.position() + k);
      localLinkedList.add(e((ByteBuffer)this.g.duplicate().position(0)));
      this.g = null;
      while (paramByteBuffer.hasRemaining())
      {
        paramByteBuffer.mark();
        try
        {
          localLinkedList.add(e(paramByteBuffer));
        }
        catch (ea localea2)
        {
          paramByteBuffer.reset();
          this.g = ByteBuffer.allocate(a(localea2.a()));
          this.g.put(paramByteBuffer);
        }
      }
      return localLinkedList;
    }
    catch (ea localea1)
    {
      this.g.limit();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(a(localea1.a()));
      if ((!f) && (localByteBuffer.limit() <= this.g.limit())) {
        throw new AssertionError();
      }
      this.g.rewind();
      localByteBuffer.put(this.g);
      this.g = localByteBuffer;
    }
    return c(paramByteBuffer);
  }
  
  public eo e(ByteBuffer paramByteBuffer)
  {
    int k = 2;
    int i1 = 0;
    int i2 = paramByteBuffer.remaining();
    if (i2 < 2) {
      throw new ea(this, 2);
    }
    int n = paramByteBuffer.get();
    if (n >> 8 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      j = (byte)((n & 0x7F) >> 4);
      if (j == 0) {
        break;
      }
      throw new eg("bad rsv " + j);
    }
    int j = paramByteBuffer.get();
    if ((j & 0xFFFFFF80) != 0) {}
    ep localep;
    for (int m = 1;; m = 0)
    {
      j = (byte)(j & 0x7F);
      localep = a((byte)(n & 0xF));
      if ((bool) || ((localep != ep.d) && (localep != ep.e) && (localep != ep.f))) {
        break;
      }
      throw new eg("control frames may no be fragmented");
    }
    if ((j >= 0) && (j <= 125)) {
      if (m == 0) {
        break label398;
      }
    }
    label398:
    for (n = 4;; n = 0)
    {
      k = n + k + j;
      if (i2 >= k) {
        break label404;
      }
      throw new ea(this, k);
      if ((localep == ep.d) || (localep == ep.e) || (localep == ep.f)) {
        throw new eg("more than 125 octets");
      }
      if (j == 126)
      {
        if (i2 < 4) {
          throw new ea(this, 4);
        }
        localObject = new byte[3];
        localObject[1] = paramByteBuffer.get();
        localObject[2] = paramByteBuffer.get();
        j = new BigInteger((byte[])localObject).intValue();
        k = 4;
        break;
      }
      if (i2 < 10) {
        throw new ea(this, 10);
      }
      localObject = new byte[8];
      j = 0;
      while (j < 8)
      {
        localObject[j] = paramByteBuffer.get();
        j += 1;
      }
      long l = new BigInteger((byte[])localObject).longValue();
      if (l > 2147483647L) {
        throw new ei("Payloadsize is to big...");
      }
      j = (int)l;
      k = 10;
      break;
    }
    label404:
    Object localObject = ByteBuffer.allocate(a(j));
    if (m != 0)
    {
      byte[] arrayOfByte = new byte[4];
      paramByteBuffer.get(arrayOfByte);
      k = i1;
      while (k < j)
      {
        ((ByteBuffer)localObject).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(k % 4)]));
        k += 1;
      }
    }
    ((ByteBuffer)localObject).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject).limit());
    paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject).limit());
    if (localep == ep.f) {
      paramByteBuffer = new em();
    }
    for (;;)
    {
      ((ByteBuffer)localObject).flip();
      paramByteBuffer.a((ByteBuffer)localObject);
      return paramByteBuffer;
      paramByteBuffer = new eq();
      paramByteBuffer.a(bool);
      paramByteBuffer.a(localep);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */