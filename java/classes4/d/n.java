package d;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class n
  implements d
{
  public final c a = new c();
  public final s b;
  boolean c;
  
  n(s params)
  {
    if (params == null) {
      throw new NullPointerException("sink == null");
    }
    this.b = params;
  }
  
  public c buffer()
  {
    return this.a;
  }
  
  public void close()
    throws IOException
  {
    if (this.c) {}
    do
    {
      return;
      localObject2 = null;
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          if (this.a.b > 0L)
          {
            this.b.write(this.a, this.a.b);
            localObject1 = localObject2;
          }
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
        try
        {
          this.b.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable2)
        {
          localObject2 = localObject1;
          if (localObject1 != null) {
            continue;
          }
          localObject2 = localThrowable2;
        }
      }
      this.c = true;
    } while (localObject2 == null);
    v.sneakyRethrow((Throwable)localObject2);
  }
  
  public d emit()
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.size();
    if (l > 0L) {
      this.b.write(this.a, l);
    }
    return this;
  }
  
  public d emitCompleteSegments()
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.completeSegmentByteCount();
    if (l > 0L) {
      this.b.write(this.a, l);
    }
    return this;
  }
  
  public void flush()
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if (this.a.b > 0L) {
      this.b.write(this.a, this.a.b);
    }
    this.b.flush();
  }
  
  public boolean isOpen()
  {
    return !this.c;
  }
  
  public OutputStream outputStream()
  {
    new OutputStream()
    {
      public void close()
        throws IOException
      {
        n.this.close();
      }
      
      public void flush()
        throws IOException
      {
        if (!n.this.c) {
          n.this.flush();
        }
      }
      
      public String toString()
      {
        return n.this + ".outputStream()";
      }
      
      public void write(int paramAnonymousInt)
        throws IOException
      {
        if (n.this.c) {
          throw new IOException("closed");
        }
        n.this.a.writeByte((byte)paramAnonymousInt);
        n.this.emitCompleteSegments();
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (n.this.c) {
          throw new IOException("closed");
        }
        n.this.a.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        n.this.emitCompleteSegments();
      }
    };
  }
  
  public u timeout()
  {
    return this.b.timeout();
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    int i = this.a.write(paramByteBuffer);
    emitCompleteSegments();
    return i;
  }
  
  public d write(f paramf)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.write(paramf);
    return emitCompleteSegments();
  }
  
  public d write(t paramt, long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      long l = paramt.read(this.a, paramLong);
      if (l == -1L) {
        throw new EOFException();
      }
      paramLong -= l;
      emitCompleteSegments();
    }
    return this;
  }
  
  public d write(byte[] paramArrayOfByte)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.write(paramArrayOfByte);
    return emitCompleteSegments();
  }
  
  public d write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
    return emitCompleteSegments();
  }
  
  public void write(c paramc, long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.write(paramc, paramLong);
    emitCompleteSegments();
  }
  
  public long writeAll(t paramt)
    throws IOException
  {
    if (paramt == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramt.read(this.a, 8192L);
      if (l2 == -1L) {
        break;
      }
      l1 += l2;
      emitCompleteSegments();
    }
    return l1;
  }
  
  public d writeByte(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeByte(paramInt);
    return emitCompleteSegments();
  }
  
  public d writeDecimalLong(long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeDecimalLong(paramLong);
    return emitCompleteSegments();
  }
  
  public d writeHexadecimalUnsignedLong(long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeHexadecimalUnsignedLong(paramLong);
    return emitCompleteSegments();
  }
  
  public d writeInt(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeInt(paramInt);
    return emitCompleteSegments();
  }
  
  public d writeIntLe(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeIntLe(paramInt);
    return emitCompleteSegments();
  }
  
  public d writeLong(long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeLong(paramLong);
    return emitCompleteSegments();
  }
  
  public d writeLongLe(long paramLong)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeLongLe(paramLong);
    return emitCompleteSegments();
  }
  
  public d writeShort(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeShort(paramInt);
    return emitCompleteSegments();
  }
  
  public d writeShortLe(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeShortLe(paramInt);
    return emitCompleteSegments();
  }
  
  public d writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeString(paramString, paramInt1, paramInt2, paramCharset);
    return emitCompleteSegments();
  }
  
  public d writeString(String paramString, Charset paramCharset)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeString(paramString, paramCharset);
    return emitCompleteSegments();
  }
  
  public d writeUtf8(String paramString)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeUtf8(paramString);
    return emitCompleteSegments();
  }
  
  public d writeUtf8(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeUtf8(paramString, paramInt1, paramInt2);
    return emitCompleteSegments();
  }
  
  public d writeUtf8CodePoint(int paramInt)
    throws IOException
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.writeUtf8CodePoint(paramInt);
    return emitCompleteSegments();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */