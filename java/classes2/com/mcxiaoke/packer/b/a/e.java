package com.mcxiaoke.packer.b.a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;

final class e
{
  private static Map<Integer, ByteBuffer> a(File paramFile)
    throws IOException
  {
    Map localMap = null;
    Object localObject1 = null;
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "r");
      paramFile = localMap;
      h.a(paramFile);
    }
    finally
    {
      try
      {
        localObject1 = localRandomAccessFile.getChannel();
        paramFile = (File)localObject1;
        localMap = c.findIdValues((ByteBuffer)c.findApkSigningBlock((FileChannel)localObject1).getFirst());
        h.a((Closeable)localObject1);
        h.a(localRandomAccessFile);
        return localMap;
      }
      finally
      {
        RandomAccessFile localRandomAccessFile;
        for (;;) {}
      }
      localObject3 = finally;
      localRandomAccessFile = null;
      paramFile = (File)localObject1;
      localObject1 = localObject3;
    }
    h.a(localRandomAccessFile);
    throw ((Throwable)localObject1);
  }
  
  public static ByteBuffer readBlock(File paramFile, int paramInt)
    throws IOException
  {
    paramFile = a(paramFile);
    if (paramFile == null) {
      return null;
    }
    return (ByteBuffer)paramFile.get(Integer.valueOf(paramInt));
  }
  
  public static byte[] readBytes(File paramFile, int paramInt)
    throws IOException
  {
    paramFile = readBlock(paramFile, paramInt);
    if (paramFile == null) {
      return null;
    }
    return h.a(paramFile);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mcxiaoke/packer/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */