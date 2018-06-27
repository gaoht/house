package d;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

final class o
  implements e
{
  public final c a = new c();
  public final t b;
  boolean c;
  
  o(t paramt)
  {
    if (paramt == null) {
      throw new NullPointerException("source == null");
    }
    this.b = paramt;
  }
  
  public c buffer()
  {
    return this.a;
  }
  
  public void close()
    throws IOException
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b.close();
    this.a.clear();
  }
  
  public boolean exhausted()
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    return (this.a.exhausted()) && (this.b.read(this.a, 8192L) == -1L);
  }
  
  public long indexOf(byte paramByte)
    throws IOException
  {
    return indexOf(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong)
    throws IOException
  {
    return indexOf(paramByte, paramLong, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong1, long paramLong2)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((paramLong1 < 0L) || (paramLong2 < paramLong1))
    {
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      Object localObject;
      paramLong1 = Math.max(paramLong1, localObject);
    }
    for (;;)
    {
      if (paramLong1 < paramLong2)
      {
        long l = this.a.indexOf(paramByte, paramLong1, paramLong2);
        if (l != -1L) {
          return l;
        }
        l = this.a.b;
        if ((l < paramLong2) && (this.b.read(this.a, 8192L) != -1L)) {
          break;
        }
        return -1L;
      }
      return -1L;
    }
  }
  
  public long indexOf(f paramf)
    throws IOException
  {
    return indexOf(paramf, 0L);
  }
  
  public long indexOf(f paramf, long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      Object localObject;
      paramLong = Math.max(paramLong, localObject - paramf.size() + 1L);
      long l = this.a.indexOf(paramf, paramLong);
      if (l != -1L) {
        return l;
      }
      l = this.a.b;
    } while (this.b.read(this.a, 8192L) != -1L);
    return -1L;
  }
  
  public long indexOfElement(f paramf)
    throws IOException
  {
    return indexOfElement(paramf, 0L);
  }
  
  public long indexOfElement(f paramf, long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      Object localObject;
      paramLong = Math.max(paramLong, localObject);
      long l = this.a.indexOfElement(paramf, paramLong);
      if (l != -1L) {
        return l;
      }
      l = this.a.b;
    } while (this.b.read(this.a, 8192L) != -1L);
    return -1L;
  }
  
  public InputStream inputStream()
  {
    return new o.1(this);
  }
  
  public boolean isOpen()
  {
    return !this.c;
  }
  
  public boolean rangeEquals(long paramLong, f paramf)
    throws IOException
  {
    return rangeEquals(paramLong, paramf, 0, paramf.size());
  }
  
  public boolean rangeEquals(long paramLong, f paramf, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 < 0) || (paramf.size() - paramInt1 < paramInt2)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {
        break label105;
      }
      long l = i + paramLong;
      if ((!request(1L + l)) || (this.a.getByte(l) != paramf.getByte(paramInt1 + i))) {
        break;
      }
      i += 1;
    }
    label105:
    return true;
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if ((this.a.b == 0L) && (this.b.read(this.a, 8192L) == -1L)) {
      return -1;
    }
    return this.a.read(paramByteBuffer);
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    v.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    if ((this.a.b == 0L) && (this.b.read(this.a, 8192L) == -1L)) {
      return -1;
    }
    paramInt2 = (int)Math.min(paramInt2, this.a.b);
    return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramc == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if ((this.a.b == 0L) && (this.b.read(this.a, 8192L) == -1L)) {
      return -1L;
    }
    paramLong = Math.min(paramLong, this.a.b);
    return this.a.read(paramc, paramLong);
  }
  
  public long readAll(s params)
    throws IOException
  {
    if (params == null) {
      throw new IllegalArgumentException("sink == null");
    }
    long l1 = 0L;
    while (this.b.read(this.a, 8192L) != -1L)
    {
      l2 = this.a.completeSegmentByteCount();
      if (l2 > 0L)
      {
        l1 += l2;
        params.write(this.a, l2);
      }
    }
    long l2 = l1;
    if (this.a.size() > 0L)
    {
      l2 = l1 + this.a.size();
      params.write(this.a, this.a.size());
    }
    return l2;
  }
  
  public byte readByte()
    throws IOException
  {
    require(1L);
    return this.a.readByte();
  }
  
  public byte[] readByteArray()
    throws IOException
  {
    this.a.writeAll(this.b);
    return this.a.readByteArray();
  }
  
  public byte[] readByteArray(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.a.readByteArray(paramLong);
  }
  
  public f readByteString()
    throws IOException
  {
    this.a.writeAll(this.b);
    return this.a.readByteString();
  }
  
  public f readByteString(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.a.readByteString(paramLong);
  }
  
  public long readDecimalLong()
    throws IOException
  {
    require(1L);
    int i = 0;
    while (request(i + 1))
    {
      byte b1 = this.a.getByte(i);
      if (((b1 < 48) || (b1 > 57)) && ((i != 0) || (b1 != 45)))
      {
        if (i != 0) {
          break;
        }
        throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[] { Byte.valueOf(b1) }));
      }
      i += 1;
    }
    return this.a.readDecimalLong();
  }
  
  public void readFully(c paramc, long paramLong)
    throws IOException
  {
    try
    {
      require(paramLong);
      this.a.readFully(paramc, paramLong);
      return;
    }
    catch (EOFException localEOFException)
    {
      paramc.writeAll(this.a);
      throw localEOFException;
    }
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      require(paramArrayOfByte.length);
      this.a.readFully(paramArrayOfByte);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      while (this.a.b > 0L)
      {
        int j = this.a.read(paramArrayOfByte, i, (int)this.a.b);
        if (j == -1) {
          throw new AssertionError();
        }
        i += j;
      }
      throw localEOFException;
    }
  }
  
  public long readHexadecimalUnsignedLong()
    throws IOException
  {
    require(1L);
    int i = 0;
    while (request(i + 1))
    {
      byte b1 = this.a.getByte(i);
      if (((b1 < 48) || (b1 > 57)) && ((b1 < 97) || (b1 > 102)) && ((b1 < 65) || (b1 > 70)))
      {
        if (i != 0) {
          break;
        }
        throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b1) }));
      }
      i += 1;
    }
    return this.a.readHexadecimalUnsignedLong();
  }
  
  public int readInt()
    throws IOException
  {
    require(4L);
    return this.a.readInt();
  }
  
  public int readIntLe()
    throws IOException
  {
    require(4L);
    return this.a.readIntLe();
  }
  
  public long readLong()
    throws IOException
  {
    require(8L);
    return this.a.readLong();
  }
  
  public long readLongLe()
    throws IOException
  {
    require(8L);
    return this.a.readLongLe();
  }
  
  public short readShort()
    throws IOException
  {
    require(2L);
    return this.a.readShort();
  }
  
  public short readShortLe()
    throws IOException
  {
    require(2L);
    return this.a.readShortLe();
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws IOException
  {
    require(paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    return this.a.readString(paramLong, paramCharset);
  }
  
  public String readString(Charset paramCharset)
    throws IOException
  {
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    this.a.writeAll(this.b);
    return this.a.readString(paramCharset);
  }
  
  public String readUtf8()
    throws IOException
  {
    this.a.writeAll(this.b);
    return this.a.readUtf8();
  }
  
  public String readUtf8(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.a.readUtf8(paramLong);
  }
  
  public int readUtf8CodePoint()
    throws IOException
  {
    require(1L);
    int i = this.a.getByte(0L);
    if ((i & 0xE0) == 192) {
      require(2L);
    }
    for (;;)
    {
      return this.a.readUtf8CodePoint();
      if ((i & 0xF0) == 224) {
        require(3L);
      } else if ((i & 0xF8) == 240) {
        require(4L);
      }
    }
  }
  
  @Nullable
  public String readUtf8Line()
    throws IOException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.a.b != 0L) {
        return readUtf8(this.a.b);
      }
      return null;
    }
    return this.a.a(l);
  }
  
  public String readUtf8LineStrict()
    throws IOException
  {
    return readUtf8LineStrict(Long.MAX_VALUE);
  }
  
  public String readUtf8LineStrict(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("limit < 0: " + paramLong);
    }
    if (paramLong == Long.MAX_VALUE) {}
    for (long l1 = Long.MAX_VALUE;; l1 = paramLong + 1L)
    {
      long l2 = indexOf((byte)10, 0L, l1);
      if (l2 == -1L) {
        break;
      }
      return this.a.a(l2);
    }
    if ((l1 < Long.MAX_VALUE) && (request(l1)) && (this.a.getByte(l1 - 1L) == 13) && (request(1L + l1)) && (this.a.getByte(l1) == 10)) {
      return this.a.a(l1);
    }
    c localc = new c();
    this.a.copyTo(localc, 0L, Math.min(32L, this.a.size()));
    throw new EOFException("\\n not found: limit=" + Math.min(this.a.size(), paramLong) + " content=" + localc.readByteString().hex() + '…');
  }
  
  public boolean request(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    while (this.a.b < paramLong) {
      if (this.b.read(this.a, 8192L) == -1L) {
        return false;
      }
    }
    return true;
  }
  
  public void require(long paramLong)
    throws IOException
  {
    if (!request(paramLong)) {
      throw new EOFException();
    }
  }
  
  public int select(m paramm)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      int i = this.a.a(paramm);
      if (i == -1) {
        return -1;
      }
      int j = paramm.a[i].size();
      if (j <= this.a.b)
      {
        this.a.skip(j);
        return i;
      }
    } while (this.b.read(this.a, 8192L) != -1L);
    return -1;
  }
  
  public void skip(long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    do
    {
      long l = Math.min(paramLong, this.a.size());
      this.a.skip(l);
      paramLong -= l;
      if (paramLong <= 0L) {
        break;
      }
    } while ((this.a.b != 0L) || (this.b.read(this.a, 8192L) != -1L));
    throw new EOFException();
  }
  
  public u timeout()
  {
    return this.b.timeout();
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */