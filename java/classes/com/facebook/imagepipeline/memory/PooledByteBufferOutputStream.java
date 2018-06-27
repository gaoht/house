package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream
  extends OutputStream
{
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
    }
  }
  
  public abstract int size();
  
  public abstract PooledByteBuffer toByteBuffer();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/memory/PooledByteBufferOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */