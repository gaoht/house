package com.baidu.trace.api.bos;

import com.baidu.trace.model.BaseResponse;

public class BosObjectResponse
  extends BaseResponse
{
  protected BosObjectType a = BosObjectType.image;
  protected String b = "";
  
  public BosObjectResponse() {}
  
  public BosObjectResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public String getObjectKey()
  {
    return this.b;
  }
  
  public BosObjectType getObjectType()
  {
    return this.a;
  }
  
  public void setObjectKey(String paramString)
  {
    this.b = paramString;
  }
  
  public void setObjectType(BosObjectType paramBosObjectType)
  {
    this.a = paramBosObjectType;
  }
  
  public String toString()
  {
    return "BosObjectResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", objectType=" + this.a + ", objectKey=" + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/BosObjectResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */