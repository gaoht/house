package d;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

public abstract interface d
  extends s, WritableByteChannel
{
  public abstract c buffer();
  
  public abstract d emit()
    throws IOException;
  
  public abstract d emitCompleteSegments()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract OutputStream outputStream();
  
  public abstract d write(f paramf)
    throws IOException;
  
  public abstract d write(t paramt, long paramLong)
    throws IOException;
  
  public abstract d write(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract d write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract long writeAll(t paramt)
    throws IOException;
  
  public abstract d writeByte(int paramInt)
    throws IOException;
  
  public abstract d writeDecimalLong(long paramLong)
    throws IOException;
  
  public abstract d writeHexadecimalUnsignedLong(long paramLong)
    throws IOException;
  
  public abstract d writeInt(int paramInt)
    throws IOException;
  
  public abstract d writeIntLe(int paramInt)
    throws IOException;
  
  public abstract d writeLong(long paramLong)
    throws IOException;
  
  public abstract d writeLongLe(long paramLong)
    throws IOException;
  
  public abstract d writeShort(int paramInt)
    throws IOException;
  
  public abstract d writeShortLe(int paramInt)
    throws IOException;
  
  public abstract d writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException;
  
  public abstract d writeString(String paramString, Charset paramCharset)
    throws IOException;
  
  public abstract d writeUtf8(String paramString)
    throws IOException;
  
  public abstract d writeUtf8(String paramString, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract d writeUtf8CodePoint(int paramInt)
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */