package com.hyphenate.chat.adapter;

public class EMAMucShareFile
  extends EMABase
{
  public EMAMucShareFile()
  {
    nativeInit();
  }
  
  public EMAMucShareFile(EMAMucShareFile paramEMAMucShareFile)
  {
    nativeInit(paramEMAMucShareFile);
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public String getFileId()
  {
    return nativeGetFileId();
  }
  
  public String getFileName()
  {
    return nativeGetFileName();
  }
  
  public String getFileOwner()
  {
    return nativeGetFileOwner();
  }
  
  public long getFileSize()
  {
    return nativeGetFileSize();
  }
  
  public long getUpdateTime()
  {
    return nativeGetUpdateTime();
  }
  
  native void nativeFinalize();
  
  native String nativeGetFileId();
  
  native String nativeGetFileName();
  
  native String nativeGetFileOwner();
  
  native long nativeGetFileSize();
  
  native long nativeGetUpdateTime();
  
  native void nativeInit();
  
  native void nativeInit(EMAMucShareFile paramEMAMucShareFile);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAMucShareFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */