package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;

public class GingerbreadPurgeableDecoder
  extends DalvikPurgeableDecoder
{
  private static Method sGetFileDescriptorMethod;
  
  /* Error */
  private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, @javax.annotation.Nullable byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_2
    //   4: ifnonnull +105 -> 109
    //   7: iconst_0
    //   8: istore_3
    //   9: new 18	android/os/MemoryFile
    //   12: dup
    //   13: aconst_null
    //   14: iload_3
    //   15: iload_1
    //   16: iadd
    //   17: invokespecial 21	android/os/MemoryFile:<init>	(Ljava/lang/String;I)V
    //   20: astore 7
    //   22: aload 7
    //   24: iconst_0
    //   25: invokevirtual 25	android/os/MemoryFile:allowPurging	(Z)Z
    //   28: pop
    //   29: new 27	com/facebook/imagepipeline/memory/PooledByteBufferInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokevirtual 33	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   37: checkcast 35	com/facebook/imagepipeline/memory/PooledByteBuffer
    //   40: invokespecial 38	com/facebook/imagepipeline/memory/PooledByteBufferInputStream:<init>	(Lcom/facebook/imagepipeline/memory/PooledByteBuffer;)V
    //   43: astore 4
    //   45: new 40	com/facebook/common/streams/LimitedInputStream
    //   48: dup
    //   49: aload 4
    //   51: iload_1
    //   52: invokespecial 43	com/facebook/common/streams/LimitedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   55: astore 5
    //   57: aload 7
    //   59: invokevirtual 47	android/os/MemoryFile:getOutputStream	()Ljava/io/OutputStream;
    //   62: astore 6
    //   64: aload 5
    //   66: aload 6
    //   68: invokestatic 53	com/facebook/common/internal/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   71: pop2
    //   72: aload_2
    //   73: ifnull +13 -> 86
    //   76: aload 7
    //   78: aload_2
    //   79: iconst_0
    //   80: iload_1
    //   81: aload_2
    //   82: arraylength
    //   83: invokevirtual 57	android/os/MemoryFile:writeBytes	([BIII)V
    //   86: aload_0
    //   87: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   90: aload 4
    //   92: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   95: aload 5
    //   97: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   100: aload 6
    //   102: iconst_1
    //   103: invokestatic 71	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   106: aload 7
    //   108: areturn
    //   109: aload_2
    //   110: arraylength
    //   111: istore_3
    //   112: goto -103 -> 9
    //   115: astore_2
    //   116: aconst_null
    //   117: astore 4
    //   119: aconst_null
    //   120: astore 5
    //   122: aload_0
    //   123: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   126: aload 5
    //   128: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   131: aload 6
    //   133: invokestatic 67	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   136: aload 4
    //   138: iconst_1
    //   139: invokestatic 71	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   142: aload_2
    //   143: athrow
    //   144: astore_2
    //   145: aconst_null
    //   146: astore 7
    //   148: aload 4
    //   150: astore 5
    //   152: aload 7
    //   154: astore 4
    //   156: goto -34 -> 122
    //   159: astore_2
    //   160: aconst_null
    //   161: astore 6
    //   163: aload 4
    //   165: astore 7
    //   167: aload 6
    //   169: astore 4
    //   171: aload 5
    //   173: astore 6
    //   175: aload 7
    //   177: astore 5
    //   179: goto -57 -> 122
    //   182: astore_2
    //   183: aload 4
    //   185: astore 7
    //   187: aload 6
    //   189: astore 4
    //   191: aload 5
    //   193: astore 6
    //   195: aload 7
    //   197: astore 5
    //   199: goto -77 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramCloseableReference	CloseableReference<PooledByteBuffer>
    //   0	202	1	paramInt	int
    //   0	202	2	paramArrayOfByte	byte[]
    //   8	104	3	i	int
    //   43	147	4	localObject1	Object
    //   55	143	5	localObject2	Object
    //   1	193	6	localObject3	Object
    //   20	176	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   29	45	115	finally
    //   45	57	144	finally
    //   57	64	159	finally
    //   64	72	182	finally
    //   76	86	182	finally
  }
  
  /* Error */
  private Method getFileDescriptorMethod()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 81	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:sGetFileDescriptorMethod	Ljava/lang/reflect/Method;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +17 -> 24
    //   10: ldc 18
    //   12: ldc 83
    //   14: iconst_0
    //   15: anewarray 85	java/lang/Class
    //   18: invokevirtual 89	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   21: putstatic 81	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:sGetFileDescriptorMethod	Ljava/lang/reflect/Method;
    //   24: getstatic 81	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:sGetFileDescriptorMethod	Ljava/lang/reflect/Method;
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 95	com/facebook/common/internal/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   37: athrow
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	GingerbreadPurgeableDecoder
    //   5	26	1	localMethod	Method
    //   32	2	1	localException	Exception
    //   38	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	24	32	java/lang/Exception
    //   2	6	38	finally
    //   10	24	38	finally
    //   24	28	38	finally
    //   33	38	38	finally
  }
  
  private FileDescriptor getMemoryFileDescriptor(MemoryFile paramMemoryFile)
  {
    try
    {
      paramMemoryFile = (FileDescriptor)getFileDescriptorMethod().invoke(paramMemoryFile, new Object[0]);
      return paramMemoryFile;
    }
    catch (Exception paramMemoryFile)
    {
      throw Throwables.propagate(paramMemoryFile);
    }
  }
  
  protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions)
  {
    return decodeFileDescriptorAsPurgeable(paramCloseableReference, ((PooledByteBuffer)paramCloseableReference.get()).size(), null, paramOptions);
  }
  
  protected Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    Object localObject = null;
    CloseableReference<PooledByteBuffer> localCloseableReference = null;
    try
    {
      paramCloseableReference = copyToMemoryFile(paramCloseableReference, paramInt, paramArrayOfByte);
      localCloseableReference = paramCloseableReference;
      localObject = paramCloseableReference;
      paramArrayOfByte = getMemoryFileDescriptor(paramCloseableReference);
      localCloseableReference = paramCloseableReference;
      localObject = paramCloseableReference;
      paramArrayOfByte = (Bitmap)Preconditions.checkNotNull(WebpSupportStatus.sWebpBitmapFactory.decodeFileDescriptor(paramArrayOfByte, null, paramOptions), "BitmapFactory returned null");
      if (paramCloseableReference != null) {
        paramCloseableReference.close();
      }
      return paramArrayOfByte;
    }
    catch (IOException paramCloseableReference)
    {
      localObject = localCloseableReference;
      throw Throwables.propagate(paramCloseableReference);
    }
    finally
    {
      if (localObject != null) {
        ((MemoryFile)localObject).close();
      }
    }
  }
  
  protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions)
  {
    if (endsWithEOI(paramCloseableReference, paramInt)) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = EOI) {
      return decodeFileDescriptorAsPurgeable(paramCloseableReference, paramInt, arrayOfByte, paramOptions);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */