package com.facebook.common.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class Files
{
  static byte[] readFile(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L) {
      throw new OutOfMemoryError("file is too large to fit in a byte array: " + paramLong + " bytes");
    }
    if (paramLong == 0L) {
      return ByteStreams.toByteArray(paramInputStream);
    }
    return ByteStreams.toByteArray(paramInputStream, (int)paramLong);
  }
  
  public static byte[] toByteArray(File paramFile)
    throws IOException
  {
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramFile);
      if (localFileInputStream == null) {
        break label42;
      }
    }
    finally
    {
      try
      {
        paramFile = readFile(localFileInputStream, localFileInputStream.getChannel().size());
        if (localFileInputStream != null) {
          localFileInputStream.close();
        }
        return paramFile;
      }
      finally {}
      paramFile = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label42:
    throw paramFile;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/internal/Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */