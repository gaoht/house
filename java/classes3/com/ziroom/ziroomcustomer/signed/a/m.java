package com.ziroom.ziroomcustomer.signed.a;

import java.io.Serializable;

public class m
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private int d;
  private String e;
  
  public String getDesc()
  {
    return this.c;
  }
  
  public String getLogo()
  {
    return this.b;
  }
  
  public int getStatus()
  {
    return this.d;
  }
  
  public String getTitle()
  {
    return this.a;
  }
  
  public String getUrl()
  {
    return this.e;
  }
  
  public void setDesc(String paramString)
  {
    this.c = paramString;
  }
  
  public void setLogo(String paramString)
  {
    this.b = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.a = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.e = paramString;
  }
  
  public String toString()
  {
    return "SignerCareerInfoNative{title='" + this.a + '\'' + ", logo='" + this.b + '\'' + ", desc='" + this.c + '\'' + ", status=" + this.d + ", url='" + this.e + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */