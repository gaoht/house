package d;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class j
  implements t
{
  private int a = 0;
  private final e b;
  private final Inflater c;
  private final k d;
  private final CRC32 e = new CRC32();
  
  public j(t paramt)
  {
    if (paramt == null) {
      throw new IllegalArgumentException("source == null");
    }
    this.c = new Inflater(true);
    this.b = l.buffer(paramt);
    this.d = new k(this.b, this.c);
  }
  
  private void a()
    throws IOException
  {
    this.b.require(10L);
    int j = this.b.buffer().getByte(3L);
    if ((j >> 1 & 0x1) == 1) {}
    long l;
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        a(this.b.buffer(), 0L, 10L);
      }
      a("ID1ID2", 8075, this.b.readShort());
      this.b.skip(8L);
      if ((j >> 2 & 0x1) == 1)
      {
        this.b.require(2L);
        if (i != 0) {
          a(this.b.buffer(), 0L, 2L);
        }
        int k = this.b.buffer().readShortLe();
        this.b.require(k);
        if (i != 0) {
          a(this.b.buffer(), 0L, k);
        }
        this.b.skip(k);
      }
      if ((j >> 3 & 0x1) != 1) {
        break label265;
      }
      l = this.b.indexOf((byte)0);
      if (l != -1L) {
        break;
      }
      throw new EOFException();
    }
    if (i != 0) {
      a(this.b.buffer(), 0L, 1L + l);
    }
    this.b.skip(1L + l);
    label265:
    if ((j >> 4 & 0x1) == 1)
    {
      l = this.b.indexOf((byte)0);
      if (l == -1L) {
        throw new EOFException();
      }
      if (i != 0) {
        a(this.b.buffer(), 0L, 1L + l);
      }
      this.b.skip(1L + l);
    }
    if (i != 0)
    {
      a("FHCRC", this.b.readShortLe(), (short)(int)this.e.getValue());
      this.e.reset();
    }
  }
  
  private void a(c paramc, long paramLong1, long paramLong2)
  {
    Object localObject;
    long l1;
    long l2;
    for (paramc = paramc.a;; paramc = paramc.f)
    {
      localObject = paramc;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < paramc.c - paramc.b) {
        break;
      }
      paramLong1 -= paramc.c - paramc.b;
    }
    while (l2 > 0L)
    {
      int i = (int)(((p)localObject).b + l1);
      int j = (int)Math.min(((p)localObject).c - i, l2);
      this.e.update(((p)localObject).a, i, j);
      l2 -= j;
      localObject = ((p)localObject).f;
      l1 = 0L;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 != paramInt1) {
      throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
  }
  
  private void b()
    throws IOException
  {
    a("CRC", this.b.readIntLe(), (int)this.e.getValue());
    a("ISIZE", this.b.readIntLe(), (int)this.c.getBytesWritten());
  }
  
  public void close()
    throws IOException
  {
    this.d.close();
  }
  
  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return 0L;
    }
    if (this.a == 0)
    {
      a();
      this.a = 1;
    }
    if (this.a == 1)
    {
      long l = paramc.b;
      paramLong = this.d.read(paramc, paramLong);
      if (paramLong != -1L)
      {
        a(paramc, l, paramLong);
        return paramLong;
      }
      this.a = 2;
    }
    if (this.a == 2)
    {
      b();
      this.a = 3;
      if (!this.b.exhausted()) {
        throw new IOException("gzip finished without exhausting source");
      }
    }
    return -1L;
  }
  
  public u timeout()
  {
    return this.b.timeout();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */