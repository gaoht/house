package com.mcxiaoke.packer.b.a;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;

final class c
{
  private static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt)
    throws BufferUnderflowException
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("size: " + paramInt);
    }
    int i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    paramInt = j + paramInt;
    if ((paramInt < j) || (paramInt > i)) {
      throw new BufferUnderflowException();
    }
    paramByteBuffer.limit(paramInt);
    try
    {
      ByteBuffer localByteBuffer = paramByteBuffer.slice();
      localByteBuffer.order(paramByteBuffer.order());
      paramByteBuffer.position(paramInt);
      return localByteBuffer;
    }
    finally
    {
      paramByteBuffer.limit(i);
    }
  }
  
  private static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("start: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("end < start: " + paramInt2 + " < " + paramInt1);
    }
    int i = paramByteBuffer.capacity();
    if (paramInt2 > paramByteBuffer.capacity()) {
      throw new IllegalArgumentException("end > capacity: " + paramInt2 + " > " + i);
    }
    i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    try
    {
      paramByteBuffer.position(0);
      paramByteBuffer.limit(paramInt2);
      paramByteBuffer.position(paramInt1);
      ByteBuffer localByteBuffer = paramByteBuffer.slice();
      localByteBuffer.order(paramByteBuffer.order());
      return localByteBuffer;
    }
    finally
    {
      paramByteBuffer.position(0);
      paramByteBuffer.limit(i);
      paramByteBuffer.position(j);
    }
  }
  
  private static void a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
      throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
  }
  
  public static d<ByteBuffer, Long> findApkSigningBlock(FileChannel paramFileChannel)
    throws IOException
  {
    return findApkSigningBlock(paramFileChannel, findCentralDirStartOffset(paramFileChannel));
  }
  
  public static d<ByteBuffer, Long> findApkSigningBlock(FileChannel paramFileChannel, long paramLong)
    throws IOException
  {
    if (paramLong < 32L) {
      throw new IOException("APK too small for APK Signing Block. ZIP Central Directory offset: " + paramLong);
    }
    paramFileChannel.position(paramLong - 24L);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
    paramFileChannel.read(localByteBuffer);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if ((localByteBuffer.getLong(8) != 2334950737559900225L) || (localByteBuffer.getLong(16) != 3617552046287187010L)) {
      throw new IOException("No APK Signing Block before ZIP Central Directory");
    }
    long l1 = localByteBuffer.getLong(0);
    if ((l1 < localByteBuffer.capacity()) || (l1 > 2147483639L)) {
      throw new IOException("APK Signing Block size out of range: " + l1);
    }
    int i = (int)(8L + l1);
    paramLong -= i;
    if (paramLong < 0L) {
      throw new IOException("APK Signing Block offset out of range: " + paramLong);
    }
    paramFileChannel.position(paramLong);
    localByteBuffer = ByteBuffer.allocate(i);
    paramFileChannel.read(localByteBuffer);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    long l2 = localByteBuffer.getLong(0);
    if (l2 != l1) {
      throw new IOException("APK Signing Block sizes in header and footer do not match: " + l2 + " vs " + l1);
    }
    return d.of(localByteBuffer, Long.valueOf(paramLong));
  }
  
  public static long findCentralDirStartOffset(FileChannel paramFileChannel)
    throws IOException
  {
    return findCentralDirStartOffset(paramFileChannel, findZipCommentLength(paramFileChannel));
  }
  
  public static long findCentralDirStartOffset(FileChannel paramFileChannel, long paramLong)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramFileChannel.position(paramFileChannel.size() - paramLong - 6L);
    paramFileChannel.read(localByteBuffer);
    return localByteBuffer.getInt(0);
  }
  
  public static Map<Integer, ByteBuffer> findIdValues(ByteBuffer paramByteBuffer)
    throws IOException
  {
    a(paramByteBuffer);
    paramByteBuffer = a(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8) {
        throw new IOException("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L)) {
        throw new IOException("APK Signing Block entry #" + i + " size out of range: " + l);
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining()) {
        throw new IOException("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
      }
      localLinkedHashMap.put(Integer.valueOf(paramByteBuffer.getInt()), a(paramByteBuffer, j - 4));
      paramByteBuffer.position(k + j);
    }
    return localLinkedHashMap;
  }
  
  public static long findZipCommentLength(FileChannel paramFileChannel)
    throws IOException
  {
    long l1 = paramFileChannel.size();
    if (l1 < 22L) {
      throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
    }
    long l2 = Math.min(l1 - 22L, 65535L);
    int i = 0;
    while (i <= l2)
    {
      long l3 = l1 - 22L - i;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      paramFileChannel.position(l3);
      paramFileChannel.read(localByteBuffer);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      if (localByteBuffer.getInt(0) == 101010256)
      {
        localByteBuffer = ByteBuffer.allocate(2);
        paramFileChannel.position(l3 + 20L);
        paramFileChannel.read(localByteBuffer);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        int j = localByteBuffer.getShort(0);
        if (j == i) {
          return j;
        }
      }
      i += 1;
    }
    throw new IOException("ZIP End of Central Directory (EOCD) record not found");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mcxiaoke/packer/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */