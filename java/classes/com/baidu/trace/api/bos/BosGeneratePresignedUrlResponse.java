package com.baidu.trace.api.bos;

public final class BosGeneratePresignedUrlResponse
  extends BosObjectResponse
{
  private String c;
  
  public BosGeneratePresignedUrlResponse() {}
  
  public BosGeneratePresignedUrlResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public final String getUrl()
  {
    return this.c;
  }
  
  public final void setUrl(String paramString)
  {
    this.c = paramString;
  }
  
  public final String toString()
  {
    return "BosGeneratePresignedUrlResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", objectType=" + this.a + ", objectKey=" + this.b + ", url=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/BosGeneratePresignedUrlResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */