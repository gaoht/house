package cn.testin.analysis;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class dw
{
  public static int a = 1000;
  public static int b = 64;
  public static final byte[] c = fc.a("<policy-file-request/>\000");
  protected dp d = null;
  protected ep e = null;
  
  public static et a(ByteBuffer paramByteBuffer, dp paramdp)
  {
    Object localObject = b(paramByteBuffer);
    if (localObject == null) {
      throw new ee(paramByteBuffer.capacity() + 128);
    }
    localObject = ((String)localObject).split(" ", 3);
    if (localObject.length != 3) {
      throw new eh();
    }
    if (paramdp == dp.a)
    {
      paramdp = new ev();
      ez localez = (ez)paramdp;
      localez.a(Short.parseShort(localObject[1]));
      localez.a(localObject[2]);
    }
    for (localObject = b(paramByteBuffer);; localObject = b(paramByteBuffer))
    {
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label175;
      }
      localObject = ((String)localObject).split(":", 2);
      if (localObject.length != 2)
      {
        throw new eh("not an http header");
        paramdp = new eu();
        paramdp.a(localObject[1]);
        break;
      }
      paramdp.a(localObject[0], localObject[1].replaceFirst("^ +", ""));
    }
    label175:
    if (localObject == null) {
      throw new ee();
    }
    return paramdp;
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
    return fc.a(paramByteBuffer.array(), 0, paramByteBuffer.limit());
  }
  
  public int a(int paramInt)
  {
    if (paramInt < 0) {
      throw new ef(1002, "Negative count");
    }
    return paramInt;
  }
  
  public abstract dy a(er paramer);
  
  public abstract dy a(er paramer, ey paramey);
  
  public abstract es a(es parames);
  
  public abstract et a(er paramer, ez paramez);
  
  public abstract ByteBuffer a(eo parameo);
  
  public List<eo> a(ep paramep, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if ((paramep != ep.c) && (paramep != ep.b) && (paramep != ep.b)) {
      throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
    }
    eq localeq;
    if (this.e != null)
    {
      this.e = ep.a;
      localeq = new eq(this.e);
    }
    for (;;)
    {
      try
      {
        localeq.a(paramByteBuffer);
        localeq.a(paramBoolean);
        if (!paramBoolean) {
          break label107;
        }
        this.e = null;
        return Collections.singletonList(localeq);
      }
      catch (ef paramep)
      {
        throw new RuntimeException(paramep);
      }
      this.e = paramep;
      break;
      label107:
      this.e = paramep;
    }
  }
  
  public List<ByteBuffer> a(ew paramew, dp paramdp)
  {
    return a(paramew, paramdp, true);
  }
  
  public List<ByteBuffer> a(ew paramew, dp paramdp, boolean paramBoolean)
  {
    paramdp = new StringBuilder(100);
    if ((paramew instanceof er))
    {
      paramdp.append("GET ");
      paramdp.append(((er)paramew).a());
      paramdp.append(" HTTP/1.1");
    }
    Object localObject;
    for (;;)
    {
      paramdp.append("\r\n");
      localObject = paramew.b();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = paramew.b(str1);
        paramdp.append(str1);
        paramdp.append(": ");
        paramdp.append(str2);
        paramdp.append("\r\n");
      }
      if (!(paramew instanceof ey)) {
        break;
      }
      paramdp.append("HTTP/1.1 101 " + ((ey)paramew).a());
    }
    throw new RuntimeException("unknow role");
    paramdp.append("\r\n");
    paramdp = fc.b(paramdp.toString());
    if (paramBoolean)
    {
      paramew = paramew.c();
      if (paramew != null) {
        break label254;
      }
    }
    label254:
    for (int i = 0;; i = paramew.length)
    {
      localObject = ByteBuffer.allocate(i + paramdp.length);
      ((ByteBuffer)localObject).put(paramdp);
      if (paramew != null) {
        ((ByteBuffer)localObject).put(paramew);
      }
      ((ByteBuffer)localObject).flip();
      return Collections.singletonList(localObject);
      paramew = null;
      break;
    }
  }
  
  public abstract void a();
  
  public void a(dp paramdp)
  {
    this.d = paramdp;
  }
  
  protected boolean a(ew paramew)
  {
    return (paramew.b("Upgrade").equalsIgnoreCase("websocket")) && (paramew.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public abstract dx b();
  
  public abstract dw c();
  
  public abstract List<eo> c(ByteBuffer paramByteBuffer);
  
  public ew d(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */