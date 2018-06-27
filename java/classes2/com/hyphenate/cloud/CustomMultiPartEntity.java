package com.hyphenate.cloud;

import c.a.a.a.a.a.d;
import c.a.a.a.a.a.g;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class CustomMultiPartEntity
  extends g
{
  private ProgressListener listener;
  
  public CustomMultiPartEntity(d paramd, ProgressListener paramProgressListener)
  {
    super(paramd);
    this.listener = paramProgressListener;
  }
  
  public CustomMultiPartEntity(d paramd, String paramString, Charset paramCharset, ProgressListener paramProgressListener)
  {
    super(paramd, paramString, paramCharset);
    this.listener = paramProgressListener;
  }
  
  public CustomMultiPartEntity(ProgressListener paramProgressListener)
  {
    this.listener = paramProgressListener;
  }
  
  public void setListener(ProgressListener paramProgressListener)
  {
    this.listener = paramProgressListener;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(new CountingOutputStream(paramOutputStream, this.listener));
  }
  
  public static class CountingOutputStream
    extends FilterOutputStream
  {
    private final CustomMultiPartEntity.ProgressListener listener;
    private long transferred;
    
    public CountingOutputStream(OutputStream paramOutputStream, CustomMultiPartEntity.ProgressListener paramProgressListener)
    {
      super();
      this.listener = paramProgressListener;
      this.transferred = 0L;
    }
    
    public void write(int paramInt)
      throws IOException
    {
      this.out.write(paramInt);
      this.transferred += 1L;
      this.listener.transferred(this.transferred);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      this.transferred += paramInt2;
      this.listener.transferred(this.transferred);
    }
  }
  
  public static abstract interface ProgressListener
  {
    public abstract void transferred(long paramLong);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/cloud/CustomMultiPartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */