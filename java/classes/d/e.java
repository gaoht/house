package d;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract interface e
  extends t, ReadableByteChannel
{
  public abstract c buffer();
  
  public abstract boolean exhausted()
    throws IOException;
  
  public abstract long indexOf(byte paramByte)
    throws IOException;
  
  public abstract long indexOf(byte paramByte, long paramLong)
    throws IOException;
  
  public abstract long indexOf(byte paramByte, long paramLong1, long paramLong2)
    throws IOException;
  
  public abstract long indexOf(f paramf)
    throws IOException;
  
  public abstract long indexOf(f paramf, long paramLong)
    throws IOException;
  
  public abstract long indexOfElement(f paramf)
    throws IOException;
  
  public abstract long indexOfElement(f paramf, long paramLong)
    throws IOException;
  
  public abstract InputStream inputStream();
  
  public abstract boolean rangeEquals(long paramLong, f paramf)
    throws IOException;
  
  public abstract boolean rangeEquals(long paramLong, f paramf, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract long readAll(s params)
    throws IOException;
  
  public abstract byte readByte()
    throws IOException;
  
  public abstract byte[] readByteArray()
    throws IOException;
  
  public abstract byte[] readByteArray(long paramLong)
    throws IOException;
  
  public abstract f readByteString()
    throws IOException;
  
  public abstract f readByteString(long paramLong)
    throws IOException;
  
  public abstract long readDecimalLong()
    throws IOException;
  
  public abstract void readFully(c paramc, long paramLong)
    throws IOException;
  
  public abstract void readFully(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract long readHexadecimalUnsignedLong()
    throws IOException;
  
  public abstract int readInt()
    throws IOException;
  
  public abstract int readIntLe()
    throws IOException;
  
  public abstract long readLong()
    throws IOException;
  
  public abstract long readLongLe()
    throws IOException;
  
  public abstract short readShort()
    throws IOException;
  
  public abstract short readShortLe()
    throws IOException;
  
  public abstract String readString(long paramLong, Charset paramCharset)
    throws IOException;
  
  public abstract String readString(Charset paramCharset)
    throws IOException;
  
  public abstract String readUtf8()
    throws IOException;
  
  public abstract String readUtf8(long paramLong)
    throws IOException;
  
  public abstract int readUtf8CodePoint()
    throws IOException;
  
  @Nullable
  public abstract String readUtf8Line()
    throws IOException;
  
  public abstract String readUtf8LineStrict()
    throws IOException;
  
  public abstract String readUtf8LineStrict(long paramLong)
    throws IOException;
  
  public abstract boolean request(long paramLong)
    throws IOException;
  
  public abstract void require(long paramLong)
    throws IOException;
  
  public abstract int select(m paramm)
    throws IOException;
  
  public abstract void skip(long paramLong)
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */