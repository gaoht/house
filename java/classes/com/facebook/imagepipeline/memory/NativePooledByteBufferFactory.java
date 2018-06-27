package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBufferFactory
  implements PooledByteBufferFactory
{
  private final NativeMemoryChunkPool mPool;
  private final PooledByteStreams mPooledByteStreams;
  
  public NativePooledByteBufferFactory(NativeMemoryChunkPool paramNativeMemoryChunkPool, PooledByteStreams paramPooledByteStreams)
  {
    this.mPool = paramNativeMemoryChunkPool;
    this.mPooledByteStreams = paramPooledByteStreams;
  }
  
  @VisibleForTesting
  NativePooledByteBuffer newByteBuf(InputStream paramInputStream, NativePooledByteBufferOutputStream paramNativePooledByteBufferOutputStream)
    throws IOException
  {
    this.mPooledByteStreams.copy(paramInputStream, paramNativePooledByteBufferOutputStream);
    return paramNativePooledByteBufferOutputStream.toByteBuffer();
  }
  
  /* Error */
  public NativePooledByteBuffer newByteBuffer(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifle +43 -> 44
    //   4: iconst_1
    //   5: istore_2
    //   6: iload_2
    //   7: invokestatic 48	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   10: aload_0
    //   11: getfield 18	com/facebook/imagepipeline/memory/NativePooledByteBufferFactory:mPool	Lcom/facebook/imagepipeline/memory/NativeMemoryChunkPool;
    //   14: iload_1
    //   15: invokevirtual 54	com/facebook/imagepipeline/memory/NativeMemoryChunkPool:get	(I)Ljava/lang/Object;
    //   18: aload_0
    //   19: getfield 18	com/facebook/imagepipeline/memory/NativePooledByteBufferFactory:mPool	Lcom/facebook/imagepipeline/memory/NativeMemoryChunkPool;
    //   22: invokestatic 60	com/facebook/common/references/CloseableReference:of	(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)Lcom/facebook/common/references/CloseableReference;
    //   25: astore_3
    //   26: new 62	com/facebook/imagepipeline/memory/NativePooledByteBuffer
    //   29: dup
    //   30: aload_3
    //   31: iload_1
    //   32: invokespecial 65	com/facebook/imagepipeline/memory/NativePooledByteBuffer:<init>	(Lcom/facebook/common/references/CloseableReference;I)V
    //   35: astore 4
    //   37: aload_3
    //   38: invokevirtual 68	com/facebook/common/references/CloseableReference:close	()V
    //   41: aload 4
    //   43: areturn
    //   44: iconst_0
    //   45: istore_2
    //   46: goto -40 -> 6
    //   49: astore 4
    //   51: aload_3
    //   52: invokevirtual 68	com/facebook/common/references/CloseableReference:close	()V
    //   55: aload 4
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	NativePooledByteBufferFactory
    //   0	58	1	paramInt	int
    //   5	41	2	bool	boolean
    //   25	27	3	localCloseableReference	com.facebook.common.references.CloseableReference
    //   35	7	4	localNativePooledByteBuffer	NativePooledByteBuffer
    //   49	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	37	49	finally
  }
  
  public NativePooledByteBuffer newByteBuffer(InputStream paramInputStream)
    throws IOException
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool);
    try
    {
      paramInputStream = newByteBuf(paramInputStream, localNativePooledByteBufferOutputStream);
      return paramInputStream;
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }
  
  public NativePooledByteBuffer newByteBuffer(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool, paramInt);
    try
    {
      paramInputStream = newByteBuf(paramInputStream, localNativePooledByteBufferOutputStream);
      return paramInputStream;
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }
  
  public NativePooledByteBuffer newByteBuffer(byte[] paramArrayOfByte)
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool, paramArrayOfByte.length);
    try
    {
      localNativePooledByteBufferOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localNativePooledByteBufferOutputStream.toByteBuffer();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw Throwables.propagate(paramArrayOfByte);
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }
  
  public NativePooledByteBufferOutputStream newOutputStream()
  {
    return new NativePooledByteBufferOutputStream(this.mPool);
  }
  
  public NativePooledByteBufferOutputStream newOutputStream(int paramInt)
  {
    return new NativePooledByteBufferOutputStream(this.mPool, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/memory/NativePooledByteBufferFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */