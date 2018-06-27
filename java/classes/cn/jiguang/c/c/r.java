package cn.jiguang.c.c;

import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public final class r
  extends a
{
  private r(long paramLong)
  {
    super(SocketChannel.open(), paramLong);
  }
  
  private byte[] a(int paramInt)
  {
    SocketChannel localSocketChannel = (SocketChannel)this.b.channel();
    byte[] arrayOfByte = new byte[paramInt];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
    this.b.interestOps(1);
    int i = 0;
    while (i < paramInt)
    {
      long l;
      try
      {
        if (!this.b.isReadable()) {
          break label133;
        }
        l = localSocketChannel.read(localByteBuffer);
        if (l < 0L) {
          throw new EOFException();
        }
      }
      finally
      {
        if (this.b.isValid()) {
          this.b.interestOps(0);
        }
      }
      int j = i + (int)l;
      i = j;
      if (j < paramInt)
      {
        i = j;
        if (System.currentTimeMillis() > this.a)
        {
          throw new SocketTimeoutException();
          label133:
          a(this.b, this.a);
        }
      }
    }
    if (this.b.isValid()) {
      this.b.interestOps(0);
    }
    return arrayOfByte;
  }
  
  public static byte[] a(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, byte[] paramArrayOfByte, long paramLong)
  {
    int i = 0;
    paramSocketAddress1 = new r(paramLong);
    try
    {
      localObject = (SocketChannel)paramSocketAddress1.b.channel();
      if (((SocketChannel)localObject).connect(paramSocketAddress2)) {
        break label123;
      }
      paramSocketAddress1.b.interestOps(8);
    }
    finally
    {
      try
      {
        while (!((SocketChannel)localObject).finishConnect()) {
          if (!paramSocketAddress1.b.isConnectable())
          {
            a(paramSocketAddress1.b, paramSocketAddress1.a);
            continue;
            throw paramSocketAddress2;
          }
        }
      }
      finally
      {
        if (paramSocketAddress1.b.isValid()) {
          paramSocketAddress1.b.interestOps(0);
        }
      }
    }
    if (paramSocketAddress1.b.isValid()) {
      paramSocketAddress1.b.interestOps(0);
    }
    label123:
    paramSocketAddress2 = (SocketChannel)paramSocketAddress1.b.channel();
    Object localObject = ByteBuffer.wrap(new byte[] { (byte)(paramArrayOfByte.length >>> 8), (byte)(paramArrayOfByte.length & 0xFF) });
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    paramSocketAddress1.b.interestOps(4);
    for (;;)
    {
      try
      {
        if (i >= paramArrayOfByte.length + 2) {
          break;
        }
        if (!paramSocketAddress1.b.isWritable()) {
          break label293;
        }
        paramLong = paramSocketAddress2.write(new ByteBuffer[] { localObject, localByteBuffer });
        if (paramLong < 0L) {
          throw new EOFException();
        }
      }
      finally
      {
        if (paramSocketAddress1.b.isValid()) {
          paramSocketAddress1.b.interestOps(0);
        }
      }
      int j = i + (int)paramLong;
      i = j;
      if (j < paramArrayOfByte.length + 2)
      {
        i = j;
        if (System.currentTimeMillis() > paramSocketAddress1.a)
        {
          throw new SocketTimeoutException();
          label293:
          a(paramSocketAddress1.b, paramSocketAddress1.a);
        }
      }
    }
    if (paramSocketAddress1.b.isValid()) {
      paramSocketAddress1.b.interestOps(0);
    }
    paramSocketAddress2 = paramSocketAddress1.a(2);
    i = paramSocketAddress2[0];
    paramSocketAddress2 = paramSocketAddress1.a((paramSocketAddress2[1] & 0xFF) + ((i & 0xFF) << 8));
    paramSocketAddress1.b.channel();
    paramSocketAddress1.a();
    return paramSocketAddress2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */