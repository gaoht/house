package com.ziroom.datacenter.remote.responsebody.financial.repair;

import java.io.Serializable;

public class f
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  
  public String getCode()
  {
    return this.a;
  }
  
  public String getCue()
  {
    return this.c;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public void setCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCue(String paramString)
  {
    this.c = paramString;
  }
  
  public void setName(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/repair/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */