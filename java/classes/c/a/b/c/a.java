package c.a.b.c;

import c.a.b.a.h;
import c.a.b.a.i;
import c.a.b.e.j;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a
{
  public static int a = 1000;
  public static int b = 64;
  public static final byte[] c = c.a.b.b.c.a("<policy-file-request/>\000");
  protected c.a.b.a.b d = null;
  protected c.a.b.e.a.a e = null;
  
  public static c.a.b.a.c a(ByteBuffer paramByteBuffer, c.a.b.a.b paramb)
    throws c.a.b.d.d, c.a.b.d.a
  {
    Object localObject = b(paramByteBuffer);
    if (localObject == null) {
      throw new c.a.b.d.a(paramByteBuffer.capacity() + 128);
    }
    localObject = ((String)localObject).split(" ", 3);
    if (localObject.length != 3) {
      throw new c.a.b.d.d();
    }
    if (paramb == c.a.b.a.b.a)
    {
      paramb = new c.a.b.a.e();
      i locali = (i)paramb;
      locali.a(Short.parseShort(localObject[1]));
      locali.a(localObject[2]);
    }
    for (;;)
    {
      localObject = b(paramByteBuffer);
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label239;
      }
      localObject = ((String)localObject).split(":", 2);
      if (localObject.length == 2) {
        break;
      }
      throw new c.a.b.d.d("not an http header");
      paramb = new c.a.b.a.d();
      paramb.a(localObject[1]);
    }
    if (paramb.c(localObject[0])) {
      paramb.a(localObject[0], paramb.b(localObject[0]) + "; " + localObject[1].replaceFirst("^ +", ""));
    }
    for (;;)
    {
      localObject = b(paramByteBuffer);
      break;
      paramb.a(localObject[0], localObject[1].replaceFirst("^ +", ""));
    }
    label239:
    if (localObject == null) {
      throw new c.a.b.d.a();
    }
    return paramb;
  }
  
  public static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b1;
    for (int i = 48;; i = b1) {
      if (paramByteBuffer.hasRemaining())
      {
        b1 = paramByteBuffer.get();
        localByteBuffer.put(b1);
        if ((i == 13) && (b1 == 10))
        {
          localByteBuffer.limit(localByteBuffer.position() - 2);
          localByteBuffer.position(0);
          return localByteBuffer;
        }
      }
      else
      {
        paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
        return null;
      }
    }
  }
  
  public static String b(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = a(paramByteBuffer);
    if (paramByteBuffer == null) {
      return null;
    }
    return c.a.b.b.c.a(paramByteBuffer.array(), 0, paramByteBuffer.limit());
  }
  
  public int a(int paramInt)
    throws c.a.b.d.e, c.a.b.d.b
  {
    if (paramInt < 0) {
      throw new c.a.b.d.b(1002, "Negative count");
    }
    return paramInt;
  }
  
  public abstract c.a.b.a.b a(c.a.b.a.b paramb)
    throws c.a.b.d.d;
  
  public abstract c.a.b.a.c a(c.a.b.a.a parama, i parami)
    throws c.a.b.d.d;
  
  public abstract b a(c.a.b.a.a parama)
    throws c.a.b.d.d;
  
  public abstract b a(c.a.b.a.a parama, h paramh)
    throws c.a.b.d.d;
  
  public abstract ByteBuffer a(c.a.b.e.a parama);
  
  public List<ByteBuffer> a(c.a.b.a.f paramf, c.a.b.a.b paramb)
  {
    return a(paramf, paramb, true);
  }
  
  public List<ByteBuffer> a(c.a.b.a.f paramf, c.a.b.a.b paramb, boolean paramBoolean)
  {
    paramb = new StringBuilder(100);
    if ((paramf instanceof c.a.b.a.a))
    {
      paramb.append("GET ");
      paramb.append(((c.a.b.a.a)paramf).a());
      paramb.append(" HTTP/1.1");
    }
    Object localObject;
    for (;;)
    {
      paramb.append("\r\n");
      localObject = paramf.c();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = paramf.b(str1);
        paramb.append(str1);
        paramb.append(": ");
        paramb.append(str2);
        paramb.append("\r\n");
      }
      if (!(paramf instanceof h)) {
        break;
      }
      paramb.append("HTTP/1.1 101 ").append(((h)paramf).a());
    }
    throw new RuntimeException("unknown role");
    paramb.append("\r\n");
    paramb = c.a.b.b.c.b(paramb.toString());
    if (paramBoolean)
    {
      paramf = paramf.d();
      if (paramf != null) {
        break label240;
      }
    }
    label240:
    for (int i = 0;; i = paramf.length)
    {
      localObject = ByteBuffer.allocate(i + paramb.length);
      ((ByteBuffer)localObject).put(paramb);
      if (paramf != null) {
        ((ByteBuffer)localObject).put(paramf);
      }
      ((ByteBuffer)localObject).flip();
      return Collections.singletonList(localObject);
      paramf = null;
      break;
    }
  }
  
  public List<c.a.b.e.a> a(c.a.b.e.a.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if ((parama != c.a.b.e.a.a.c) && (parama != c.a.b.e.a.a.b)) {
      throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
    }
    Object localObject;
    if (this.e != null) {
      localObject = new c.a.b.e.d();
    }
    for (;;)
    {
      ((c.a.b.e.f)localObject).a(paramByteBuffer);
      ((c.a.b.e.f)localObject).a(paramBoolean);
      for (;;)
      {
        try
        {
          ((c.a.b.e.f)localObject).c();
          if (!paramBoolean) {
            break label126;
          }
          this.e = null;
          return Collections.singletonList(localObject);
        }
        catch (c.a.b.d.b parama)
        {
          throw new RuntimeException(parama);
        }
        this.e = parama;
        if (parama == c.a.b.e.a.a.c)
        {
          localObject = new c.a.b.e.b();
          break;
        }
        if (parama != c.a.b.e.a.a.b) {
          break label134;
        }
        localObject = new j();
        break;
        label126:
        this.e = parama;
      }
      label134:
      localObject = null;
    }
  }
  
  public abstract List<c.a.b.e.a> a(String paramString, boolean paramBoolean);
  
  public abstract List<c.a.b.e.a> a(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public abstract void a();
  
  public void a(c.a.b.a.b paramb)
  {
    this.d = paramb;
  }
  
  protected boolean a(c.a.b.a.f paramf)
  {
    return (paramf.b("Upgrade").equalsIgnoreCase("websocket")) && (paramf.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public abstract a b();
  
  public abstract a c();
  
  public abstract List<c.a.b.e.a> c(ByteBuffer paramByteBuffer)
    throws c.a.b.d.b;
  
  public c.a.b.a.b d()
  {
    return this.d;
  }
  
  public c.a.b.a.f d(ByteBuffer paramByteBuffer)
    throws c.a.b.d.d
  {
    return a(paramByteBuffer, this.d);
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */