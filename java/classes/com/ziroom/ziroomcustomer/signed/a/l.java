package com.ziroom.ziroomcustomer.signed.a;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

public class l
  implements Serializable
{
  private int a;
  private String b;
  private String c;
  private String d;
  private int e;
  private int f;
  private m g;
  
  public int getFlag()
  {
    return this.e;
  }
  
  public String getIcon()
  {
    return this.b;
  }
  
  public int getKey()
  {
    return this.a;
  }
  
  @JSONField(name="native")
  public m getNative()
  {
    return this.g;
  }
  
  public int getStatus()
  {
    return this.f;
  }
  
  public String getTitle()
  {
    return this.d;
  }
  
  public String getUrl()
  {
    return this.c;
  }
  
  public void setFlag(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setIcon(String paramString)
  {
    this.b = paramString;
  }
  
  @JSONField(name="native")
  public void setInfoNative(m paramm)
  {
    this.g = paramm;
  }
  
  public void setKey(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.d = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.c = paramString;
  }
  
  public String toString()
  {
    return "SignerCareerInfo{key=" + this.a + ", icon='" + this.b + '\'' + ", url='" + this.c + '\'' + ", title='" + this.d + '\'' + ", flag=" + this.e + ", status=" + this.f + ", infoNative=" + this.g + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */