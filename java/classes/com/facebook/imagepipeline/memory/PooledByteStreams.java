package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PooledByteStreams
{
  private static final int DEFAULT_TEMP_BUF_SIZE = 16384;
  private final ByteArrayPool mByteArrayPool;
  private final int mTempBufSize;
  
  public PooledByteStreams(ByteArrayPool paramByteArrayPool)
  {
    this(paramByteArrayPool, 16384);
  }
  
  @VisibleForTesting
  PooledByteStreams(ByteArrayPool paramByteArrayPool, int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mTempBufSize = paramInt;
      this.mByteArrayPool = paramByteArrayPool;
      return;
    }
  }
  
  /* Error */
  public long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_0
    //   4: getfield 30	com/facebook/imagepipeline/memory/PooledByteStreams:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   7: aload_0
    //   8: getfield 28	com/facebook/imagepipeline/memory/PooledByteStreams:mTempBufSize	I
    //   11: invokeinterface 41 2 0
    //   16: checkcast 43	[B
    //   19: astore 6
    //   21: aload_1
    //   22: aload 6
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 28	com/facebook/imagepipeline/memory/PooledByteStreams:mTempBufSize	I
    //   29: invokevirtual 49	java/io/InputStream:read	([BII)I
    //   32: istore_3
    //   33: iload_3
    //   34: iconst_m1
    //   35: if_icmpne +17 -> 52
    //   38: aload_0
    //   39: getfield 30	com/facebook/imagepipeline/memory/PooledByteStreams:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   42: aload 6
    //   44: invokeinterface 53 2 0
    //   49: lload 4
    //   51: lreturn
    //   52: aload_2
    //   53: aload 6
    //   55: iconst_0
    //   56: iload_3
    //   57: invokevirtual 59	java/io/OutputStream:write	([BII)V
    //   60: lload 4
    //   62: iload_3
    //   63: i2l
    //   64: ladd
    //   65: lstore 4
    //   67: goto -46 -> 21
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 30	com/facebook/imagepipeline/memory/PooledByteStreams:mByteArrayPool	Lcom/facebook/imagepipeline/memory/ByteArrayPool;
    //   75: aload 6
    //   77: invokeinterface 53 2 0
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	PooledByteStreams
    //   0	84	1	paramInputStream	InputStream
    //   0	84	2	paramOutputStream	OutputStream
    //   32	31	3	i	int
    //   1	65	4	l	long
    //   19	57	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	33	70	finally
    //   52	60	70	finally
  }
  
  public long copy(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    long l = 0L;
    boolean bool = false;
    if (paramLong > 0L) {
      bool = true;
    }
    Preconditions.checkState(bool);
    arrayOfByte = (byte[])this.mByteArrayPool.get(this.mTempBufSize);
    for (;;)
    {
      if (l < paramLong) {}
      try
      {
        int i = paramInputStream.read(arrayOfByte, 0, (int)Math.min(this.mTempBufSize, paramLong - l));
        if (i == -1) {
          return l;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        l += i;
      }
      finally
      {
        this.mByteArrayPool.release(arrayOfByte);
      }
    }
    this.mByteArrayPool.release(arrayOfByte);
    return l;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/memory/PooledByteStreams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */