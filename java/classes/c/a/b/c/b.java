package c.a.b.c;

import c.a.b.a.h;
import c.a.b.a.i;
import c.a.b.d.d;
import c.a.b.d.e;
import c.a.b.e.g;
import c.a.b.e.j;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Deprecated
public class b
  extends a
{
  private ByteBuffer g;
  private final Random h = new Random();
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      return;
    }
  }
  
  private byte a(c.a.b.e.a.a parama)
  {
    if (parama == c.a.b.e.a.a.a) {
      return 0;
    }
    if (parama == c.a.b.e.a.a.b) {
      return 1;
    }
    if (parama == c.a.b.e.a.a.c) {
      return 2;
    }
    if (parama == c.a.b.e.a.a.f) {
      return 8;
    }
    if (parama == c.a.b.e.a.a.d) {
      return 9;
    }
    if (parama == c.a.b.e.a.a.e) {
      return 10;
    }
    throw new RuntimeException("Don't know how to handle " + parama.toString());
  }
  
  private c.a.b.e.a.a a(byte paramByte)
    throws c.a.b.d.c
  {
    switch (paramByte)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new c.a.b.d.c("Unknown opcode " + (short)paramByte);
    case 0: 
      return c.a.b.e.a.a.a;
    case 1: 
      return c.a.b.e.a.a.b;
    case 2: 
      return c.a.b.e.a.a.c;
    case 8: 
      return c.a.b.e.a.a.f;
    case 9: 
      return c.a.b.e.a.a.d;
    }
    return c.a.b.e.a.a.e;
  }
  
  private String a(String paramString)
  {
    paramString = paramString.trim();
    paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      return c.a.b.b.a.a(localMessageDigest.digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  private byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >>> paramInt * 8 - 8 - i * 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int b(c.a.b.a.f paramf)
  {
    int i = -1;
    paramf = paramf.b("Sec-WebSocket-Version");
    if (paramf.length() > 0) {}
    try
    {
      i = new Integer(paramf.trim()).intValue();
      return i;
    }
    catch (NumberFormatException paramf) {}
    return -1;
  }
  
  public c.a.b.a.b a(c.a.b.a.b paramb)
  {
    paramb.a("Upgrade", "websocket");
    paramb.a("Connection", "Upgrade");
    paramb.a("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.h.nextBytes(arrayOfByte);
    paramb.a("Sec-WebSocket-Key", c.a.b.b.a.a(arrayOfByte));
    return paramb;
  }
  
  public c.a.b.a.c a(c.a.b.a.a parama, i parami)
    throws d
  {
    parami.a("Upgrade", "websocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("Switching Protocols");
    parama = parama.b("Sec-WebSocket-Key");
    if (parama == null) {
      throw new d("missing Sec-WebSocket-Key");
    }
    parami.a("Sec-WebSocket-Accept", a(parama));
    return parami;
  }
  
  public a.b a(c.a.b.a.a parama)
    throws d
  {
    int i = b(parama);
    if ((i == 7) || (i == 8))
    {
      if (a(parama)) {
        return a.b.a;
      }
      return a.b.b;
    }
    return a.b.b;
  }
  
  public a.b a(c.a.b.a.a parama, h paramh)
    throws d
  {
    if ((!parama.c("Sec-WebSocket-Key")) || (!paramh.c("Sec-WebSocket-Accept"))) {
      return a.b.b;
    }
    paramh = paramh.b("Sec-WebSocket-Accept");
    if (a(parama.b("Sec-WebSocket-Key")).equals(paramh)) {
      return a.b.a;
    }
    return a.b.b;
  }
  
  public ByteBuffer a(c.a.b.e.a parama)
  {
    int j = -128;
    int i1 = 0;
    ByteBuffer localByteBuffer1 = parama.d();
    int k;
    int i;
    label39:
    label49:
    int n;
    label57:
    ByteBuffer localByteBuffer2;
    if (this.d == c.a.b.a.b.a)
    {
      k = 1;
      if (localByteBuffer1.remaining() > 125) {
        break label151;
      }
      i = 1;
      if (i <= 1) {
        break label172;
      }
      m = i + 1;
      if (k == 0) {
        break label178;
      }
      n = 4;
      localByteBuffer2 = ByteBuffer.allocate(n + (m + 1) + localByteBuffer1.remaining());
      n = a(parama.j());
      if (!parama.e()) {
        break label184;
      }
    }
    label151:
    label172:
    label178:
    label184:
    for (int m = -128;; m = 0)
    {
      localByteBuffer2.put((byte)((byte)m | n));
      parama = a(localByteBuffer1.remaining(), i);
      if ((f) || (parama.length == i)) {
        break label190;
      }
      throw new AssertionError();
      k = 0;
      break;
      if (localByteBuffer1.remaining() <= 65535)
      {
        i = 2;
        break label39;
      }
      i = 8;
      break label39;
      m = i;
      break label49;
      n = 0;
      break label57;
    }
    label190:
    if (i == 1)
    {
      i = parama[0];
      if (k != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(i | j));
        if (k == 0) {
          break;
        }
        parama = ByteBuffer.allocate(4);
        parama.putInt(this.h.nextInt());
        localByteBuffer2.put(parama.array());
        i = i1;
        while (localByteBuffer1.hasRemaining())
        {
          localByteBuffer2.put((byte)(localByteBuffer1.get() ^ parama.get(i % 4)));
          i += 1;
        }
        j = 0;
      }
    }
    if (i == 2)
    {
      if (k != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(j | 0x7E));
        localByteBuffer2.put(parama);
        break;
        j = 0;
      }
    }
    if (i == 8)
    {
      if (k != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(j | 0x7F));
        localByteBuffer2.put(parama);
        break;
        j = 0;
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
  
  public List<c.a.b.e.a> a(String paramString, boolean paramBoolean)
  {
    j localj = new j();
    localj.a(ByteBuffer.wrap(c.a.b.b.c.a(paramString)));
    localj.e(paramBoolean);
    try
    {
      localj.c();
      return Collections.singletonList(localj);
    }
    catch (c.a.b.d.b paramString)
    {
      throw new c.a.b.d.f(paramString);
    }
  }
  
  public List<c.a.b.e.a> a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    c.a.b.e.b localb = new c.a.b.e.b();
    localb.a(paramByteBuffer);
    localb.e(paramBoolean);
    try
    {
      localb.c();
      return Collections.singletonList(localb);
    }
    catch (c.a.b.d.b paramByteBuffer)
    {
      throw new c.a.b.d.f(paramByteBuffer);
    }
  }
  
  public void a()
  {
    this.g = null;
  }
  
  public a.a b()
  {
    return a.a.c;
  }
  
  public a c()
  {
    return new b();
  }
  
  public List<c.a.b.e.a> c(ByteBuffer paramByteBuffer)
    throws e, c.a.b.d.b
  {
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      if (this.g != null) {}
      try
      {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.g.remaining();
        if (j > i)
        {
          this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(i + paramByteBuffer.position());
          return Collections.emptyList();
        }
        this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        localLinkedList.add(e((ByteBuffer)this.g.duplicate().position(0)));
        this.g = null;
        while (paramByteBuffer.hasRemaining())
        {
          paramByteBuffer.mark();
          try
          {
            localLinkedList.add(e(paramByteBuffer));
          }
          catch (a locala2)
          {
            paramByteBuffer.reset();
            this.g = ByteBuffer.allocate(a(locala2.a()));
            this.g.put(paramByteBuffer);
          }
        }
        return localLinkedList;
      }
      catch (a locala1)
      {
        this.g.limit();
        ByteBuffer localByteBuffer = ByteBuffer.allocate(a(locala1.a()));
        if ((!f) && (localByteBuffer.limit() <= this.g.limit())) {
          throw new AssertionError();
        }
        this.g.rewind();
        localByteBuffer.put(this.g);
        this.g = localByteBuffer;
      }
    }
  }
  
  public c.a.b.e.a e(ByteBuffer paramByteBuffer)
    throws b.a, c.a.b.d.b
  {
    int j = 2;
    int n = 0;
    int i1 = paramByteBuffer.remaining();
    if (i1 < 2) {
      throw new a(2);
    }
    int i = paramByteBuffer.get();
    boolean bool1;
    if (i >> 8 != 0)
    {
      bool1 = true;
      if ((i & 0x40) == 0) {
        break label618;
      }
    }
    label366:
    label463:
    label618:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((i & 0x20) != 0) {}
      for (boolean bool3 = true;; bool3 = false)
      {
        if ((i & 0x10) != 0) {}
        for (boolean bool4 = true;; bool4 = false)
        {
          if ((bool2) || (bool3) || (bool4))
          {
            throw new c.a.b.d.c("bad rsv rsv1: " + bool2 + " rsv2: " + bool3 + " rsv3: " + bool4);
            bool1 = false;
            break;
          }
          int m = paramByteBuffer.get();
          if ((m & 0xFFFFFF80) != 0) {}
          c.a.b.e.a.a locala;
          for (int k = 1;; k = 0)
          {
            m = (byte)(m & 0x7F);
            locala = a((byte)(i & 0xF));
            if ((bool1) || ((locala != c.a.b.e.a.a.d) && (locala != c.a.b.e.a.a.e) && (locala != c.a.b.e.a.a.f))) {
              break;
            }
            throw new c.a.b.d.c("control frames may no be fragmented");
          }
          if (m >= 0)
          {
            i = m;
            if (m <= 125) {}
          }
          else
          {
            if ((locala == c.a.b.e.a.a.d) || (locala == c.a.b.e.a.a.e) || (locala == c.a.b.e.a.a.f)) {
              throw new c.a.b.d.c("more than 125 octets");
            }
            if (m != 126) {
              break label366;
            }
            if (i1 < 4) {
              throw new a(4);
            }
            localObject = new byte[3];
            localObject[1] = paramByteBuffer.get();
            localObject[2] = paramByteBuffer.get();
            i = new BigInteger((byte[])localObject).intValue();
            j = 4;
          }
          if (k != 0) {}
          for (m = 4;; m = 0)
          {
            j = m + j + i;
            if (i1 >= j) {
              break label463;
            }
            throw new a(j);
            if (i1 < 10) {
              throw new a(10);
            }
            localObject = new byte[8];
            i = 0;
            while (i < 8)
            {
              localObject[i] = paramByteBuffer.get();
              i += 1;
            }
            long l = new BigInteger((byte[])localObject).longValue();
            if (l > 2147483647L) {
              throw new e("Payloadsize is to big...");
            }
            i = (int)l;
            j = 10;
            break;
          }
          Object localObject = ByteBuffer.allocate(a(i));
          if (k != 0)
          {
            byte[] arrayOfByte = new byte[4];
            paramByteBuffer.get(arrayOfByte);
            j = n;
            while (j < i)
            {
              ((ByteBuffer)localObject).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(j % 4)]));
              j += 1;
            }
          }
          ((ByteBuffer)localObject).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject).limit());
          paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject).limit());
          if (locala == c.a.b.e.a.a.f) {
            paramByteBuffer = new c.a.b.e.c();
          }
          for (;;)
          {
            ((ByteBuffer)localObject).flip();
            paramByteBuffer.a((ByteBuffer)localObject);
            paramByteBuffer.c();
            return paramByteBuffer;
            paramByteBuffer = g.a(locala);
            paramByteBuffer.a(bool1);
          }
        }
      }
    }
  }
  
  private class a
    extends Throwable
  {
    private int b;
    
    public a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public int a()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */