package okhttp3.internal.cache2;

import d.c;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class FileOperator
{
  private final FileChannel fileChannel;
  
  FileOperator(FileChannel paramFileChannel)
  {
    this.fileChannel = paramFileChannel;
  }
  
  public void read(long paramLong1, c paramc, long paramLong2)
    throws IOException
  {
    if (paramLong2 < 0L) {
      throw new IndexOutOfBoundsException();
    }
    for (;;)
    {
      if (paramLong2 > 0L)
      {
        long l = this.fileChannel.transferTo(paramLong1, paramLong2, paramc);
        paramLong1 += l;
        paramLong2 -= l;
      }
      else
      {
        return;
      }
    }
  }
  
  public void write(long paramLong1, c paramc, long paramLong2)
    throws IOException
  {
    if ((paramLong2 < 0L) || (paramLong2 > paramc.size())) {
      throw new IndexOutOfBoundsException();
    }
    for (;;)
    {
      if (paramLong2 > 0L)
      {
        long l = this.fileChannel.transferFrom(paramc, paramLong1, paramLong2);
        paramLong1 += l;
        paramLong2 -= l;
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/cache2/FileOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */