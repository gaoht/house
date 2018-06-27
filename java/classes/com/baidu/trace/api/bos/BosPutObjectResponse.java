package com.baidu.trace.api.bos;

import com.baidubce.services.bos.model.ObjectMetadata;

public final class BosPutObjectResponse
  extends BosObjectResponse
{
  private String c;
  private ObjectMetadata d = null;
  
  public BosPutObjectResponse() {}
  
  public BosPutObjectResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public final String getETag()
  {
    return this.c;
  }
  
  public final ObjectMetadata getMetaData()
  {
    return this.d;
  }
  
  public final void setETag(String paramString)
  {
    this.c = paramString;
  }
  
  public final void setMetaData(ObjectMetadata paramObjectMetadata)
  {
    this.d = paramObjectMetadata;
  }
  
  public final String toString()
  {
    String str = "";
    if (this.d != null) {
      str = this.d.toString();
    }
    return "BosPutObjectResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", objectType=" + this.a + ", objectKey=" + this.b + ", eTag=" + this.c + ", metaData=" + str + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/BosPutObjectResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */