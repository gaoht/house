package com.hyphenate.chat.adapter.message;

public class EMAVideoMessageBody
  extends EMAFileMessageBody
{
  private EMAVideoMessageBody()
  {
    super("", 2);
    nativeInit("", "");
  }
  
  public EMAVideoMessageBody(EMAVideoMessageBody paramEMAVideoMessageBody)
  {
    super("", 2);
    nativeInit(paramEMAVideoMessageBody);
  }
  
  public EMAVideoMessageBody(String paramString1, String paramString2)
  {
    super(paramString1, 2);
    nativeInit(paramString1, paramString2);
  }
  
  public int duration()
  {
    return nativeduration();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public int height()
  {
    return nativeheight();
  }
  
  native void nativeFinalize();
  
  native void nativeInit(EMAVideoMessageBody paramEMAVideoMessageBody);
  
  native void nativeInit(String paramString1, String paramString2);
  
  native int nativeduration();
  
  native int nativeheight();
  
  native void nativesetDuration(int paramInt);
  
  native void nativesetSize(int paramInt1, int paramInt2);
  
  native void nativesetThumbnailDownloadStatus(int paramInt);
  
  native void nativesetThumbnailLocalPath(String paramString);
  
  native void nativesetThumbnailRemotePath(String paramString);
  
  native void nativesetThumbnailSecretKey(String paramString);
  
  native int nativethumbnailDownloadStatus();
  
  native String nativethumbnailLocalPath();
  
  native String nativethumbnailRemotePath();
  
  native String nativethumbnailSecretKey();
  
  native int nativewidth();
  
  public void setDuration(int paramInt)
  {
    nativesetDuration(paramInt);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    nativesetSize(paramInt1, paramInt2);
  }
  
  public void setThumbnailDownloadStatus(EMAFileMessageBody.EMADownloadStatus paramEMADownloadStatus)
  {
    nativesetThumbnailDownloadStatus(paramEMADownloadStatus.ordinal());
  }
  
  public void setThumbnailLocalPath(String paramString)
  {
    nativesetThumbnailLocalPath(paramString);
  }
  
  public void setThumbnailRemotePath(String paramString)
  {
    nativesetThumbnailRemotePath(paramString);
  }
  
  public void setThumbnailSecretKey(String paramString)
  {
    nativesetThumbnailSecretKey(paramString);
  }
  
  public EMAFileMessageBody.EMADownloadStatus thumbnailDownloadStatus()
  {
    int i = nativethumbnailDownloadStatus();
    if (i == EMAFileMessageBody.EMADownloadStatus.DOWNLOADING.ordinal()) {
      return EMAFileMessageBody.EMADownloadStatus.DOWNLOADING;
    }
    if (i == EMAFileMessageBody.EMADownloadStatus.SUCCESSED.ordinal()) {
      return EMAFileMessageBody.EMADownloadStatus.SUCCESSED;
    }
    if (i == EMAFileMessageBody.EMADownloadStatus.FAILED.ordinal()) {
      return EMAFileMessageBody.EMADownloadStatus.FAILED;
    }
    return EMAFileMessageBody.EMADownloadStatus.PENDING;
  }
  
  public String thumbnailLocalPath()
  {
    return nativethumbnailLocalPath();
  }
  
  public String thumbnailRemotePath()
  {
    return nativethumbnailRemotePath();
  }
  
  public String thumbnailSecretKey()
  {
    return nativethumbnailSecretKey();
  }
  
  public int width()
  {
    return nativewidth();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/message/EMAVideoMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */