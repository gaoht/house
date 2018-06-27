package com.alipay.sdk.auth;

public class a
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramString3;
    this.c = paramString4;
  }
  
  public String getAppId()
  {
    return this.a;
  }
  
  public String getPid()
  {
    return this.c;
  }
  
  public String getProductId()
  {
    return this.b;
  }
  
  public String getRedirectUri()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */