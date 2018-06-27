package com.facebook.cache.common;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface WriterCallback
{
  public abstract void write(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/common/WriterCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */