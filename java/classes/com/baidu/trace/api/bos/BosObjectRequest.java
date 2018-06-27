package com.baidu.trace.api.bos;

import com.baidu.trace.model.BaseRequest;

public class BosObjectRequest
  extends BaseRequest
{
  private String a = null;
  private BosObjectType b = BosObjectType.image;
  
  public BosObjectRequest() {}
  
  public BosObjectRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public BosObjectRequest(int paramInt, long paramLong, String paramString, BosObjectType paramBosObjectType)
  {
    super(paramInt, paramLong);
    this.a = paramString;
    this.b = paramBosObjectType;
  }
  
  public String getObjectKey()
  {
    return this.a;
  }
  
  public BosObjectType getObjectType()
  {
    return this.b;
  }
  
  public void setObjectKey(String paramString)
  {
    this.a = paramString;
  }
  
  public void setObjectType(BosObjectType paramBosObjectType)
  {
    this.b = paramBosObjectType;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BosObjectRequest{");
    localStringBuffer.append("objectKey='").append(this.a).append('\'');
    localStringBuffer.append(", objectType=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/BosObjectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */