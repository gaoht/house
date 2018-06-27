package com.facebook.cache.common;

import com.facebook.common.internal.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriterCallbacks
{
  public static WriterCallback from(InputStream paramInputStream)
  {
    new WriterCallback()
    {
      public void write(OutputStream paramAnonymousOutputStream)
        throws IOException
      {
        ByteStreams.copy(this.val$is, paramAnonymousOutputStream);
      }
    };
  }
  
  public static WriterCallback from(byte[] paramArrayOfByte)
  {
    new WriterCallback()
    {
      public void write(OutputStream paramAnonymousOutputStream)
        throws IOException
      {
        paramAnonymousOutputStream.write(this.val$data);
      }
    };
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/common/WriterCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */