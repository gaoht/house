package com.baidu.trace.api.bos;

import java.io.File;
import java.io.InputStream;

public final class BosPutObjectRequest
  extends BosObjectRequest
{
  private File a = null;
  private InputStream b = null;
  private byte[] c = null;
  private String d = null;
  private long e = 0L;
  
  private BosPutObjectRequest(int paramInt, long paramLong, String paramString1, BosObjectType paramBosObjectType, File paramFile, InputStream paramInputStream, byte[] paramArrayOfByte, String paramString2)
  {
    super(paramInt, paramLong, paramString1, paramBosObjectType);
    this.a = paramFile;
    this.b = paramInputStream;
    this.c = paramArrayOfByte;
    this.d = paramString2;
  }
  
  public static BosPutObjectRequest buildByteArrayRequest(int paramInt, long paramLong, String paramString, BosObjectType paramBosObjectType, byte[] paramArrayOfByte)
  {
    return new BosPutObjectRequest(paramInt, paramLong, paramString, paramBosObjectType, null, null, paramArrayOfByte, null);
  }
  
  public static BosPutObjectRequest buildFileRequest(int paramInt, long paramLong, String paramString, BosObjectType paramBosObjectType, File paramFile)
  {
    return new BosPutObjectRequest(paramInt, paramLong, paramString, paramBosObjectType, paramFile, null, null, null);
  }
  
  public static BosPutObjectRequest buildStreamReqeust(int paramInt, long paramLong, String paramString, BosObjectType paramBosObjectType, InputStream paramInputStream)
  {
    return new BosPutObjectRequest(paramInt, paramLong, paramString, paramBosObjectType, null, paramInputStream, null, null);
  }
  
  public static BosPutObjectRequest buildStringRequest(int paramInt, long paramLong, String paramString1, BosObjectType paramBosObjectType, String paramString2)
  {
    return new BosPutObjectRequest(paramInt, paramLong, paramString1, paramBosObjectType, null, null, null, paramString2);
  }
  
  public final byte[] getByteArray()
  {
    return this.c;
  }
  
  public final File getFile()
  {
    return this.a;
  }
  
  public final long getObjectSize()
  {
    return this.e;
  }
  
  public final InputStream getStreamData()
  {
    return this.b;
  }
  
  public final String getStringData()
  {
    return this.d;
  }
  
  public final void setByteArray(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public final void setFile(File paramFile)
  {
    this.a = paramFile;
  }
  
  public final void setObjectSize(long paramLong)
  {
    this.e = paramLong;
  }
  
  public final void setStreamData(InputStream paramInputStream)
  {
    this.b = paramInputStream;
  }
  
  public final void setStringData(String paramString)
  {
    this.d = paramString;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BosPutObjectRequest{");
    localStringBuffer.append("file=").append(this.a);
    localStringBuffer.append(", streamData=").append(this.b);
    localStringBuffer.append(", byteArray=");
    if (this.c == null) {
      localStringBuffer.append("null");
    }
    for (;;)
    {
      localStringBuffer.append(", stringData='").append(this.d).append('\'');
      localStringBuffer.append(", objectSize=").append(this.e);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
      localStringBuffer.append('[');
      int i = 0;
      if (i < this.c.length)
      {
        if (i == 0) {}
        for (String str = "";; str = ", ")
        {
          localStringBuffer.append(str).append(this.c[i]);
          i += 1;
          break;
        }
      }
      localStringBuffer.append(']');
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/BosPutObjectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */