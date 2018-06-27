package com.hyphenate.chat.adapter.message;

public class EMAImageMessageBody
  extends EMAFileMessageBody
{
  public long fileLength;
  public double height;
  public int thumbnailDownloadStatus;
  public String thumbnailLocalPath;
  public String thumbnailRemotePath;
  public String thumbnailSecretKey;
  public double width;
  
  private EMAImageMessageBody()
  {
    super("", 1);
    nativeInit("", "");
  }
  
  public EMAImageMessageBody(EMAImageMessageBody paramEMAImageMessageBody)
  {
    super("", 1);
    nativeInit(paramEMAImageMessageBody);
  }
  
  public EMAImageMessageBody(String paramString1, String paramString2)
  {
    super(paramString1, 1);
    nativeInit(paramString1, paramString2);
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
  
  native void nativeInit(EMAImageMessageBody paramEMAImageMessageBody);
  
  native void nativeInit(String paramString1, String paramString2);
  
  native int nativeheight();
  
  native void nativesetSize(int paramInt1, int paramInt2);
  
  native void nativesetThumbnailDisplayName(String paramString);
  
  native void nativesetThumbnailDownloadStatus(int paramInt);
  
  native void nativesetThumbnailFileLength(long paramLong);
  
  native void nativesetThumbnailLocalPath(String paramString);
  
  native void nativesetThumbnailRemotePath(String paramString);
  
  native void nativesetThumbnailSecretKey(String paramString);
  
  native void nativesetThumbnailSize(int paramInt1, int paramInt2);
  
  native String nativethumbnailDisplayName();
  
  native int nativethumbnailDownloadStatus();
  
  native long nativethumbnailFileLength();
  
  native int nativethumbnailHeight();
  
  native String nativethumbnailLocalPath();
  
  native String nativethumbnailRemotePath();
  
  native String nativethumbnailSecretKey();
  
  native int nativethumbnailWidth();
  
  native int nativewidth();
  
  public void setSize(int paramInt1, int paramInt2)
  {
    nativesetSize(paramInt1, paramInt2);
  }
  
  public void setThumbnailDisplayName(String paramString)
  {
    nativesetThumbnailDisplayName(paramString);
  }
  
  public void setThumbnailDownloadStatus(EMAFileMessageBody.EMADownloadStatus paramEMADownloadStatus)
  {
    nativesetThumbnailDownloadStatus(paramEMADownloadStatus.ordinal());
  }
  
  public void setThumbnailFileLength(long paramLong)
  {
    nativesetThumbnailFileLength(paramLong);
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
  
  public void setThumbnailSize(int paramInt1, int paramInt2)
  {
    nativesetThumbnailSize(paramInt1, paramInt2);
  }
  
  public String thumbnailDisplayName()
  {
    return nativethumbnailDisplayName();
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
  
  public long thumbnailFileLength()
  {
    return nativethumbnailFileLength();
  }
  
  int thumbnailHeight()
  {
    return nativethumbnailHeight();
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
  
  public int thumbnailWidth()
  {
    return nativethumbnailWidth();
  }
  
  public int width()
  {
    return nativewidth();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/message/EMAImageMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */