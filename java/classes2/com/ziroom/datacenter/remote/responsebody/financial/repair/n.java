package com.ziroom.datacenter.remote.responsebody.financial.repair;

import java.io.Serializable;

public class n
  implements Serializable
{
  private String a;
  private String b;
  
  public String getPromise()
  {
    return this.b;
  }
  
  public String getPromiseRemark()
  {
    return this.a;
  }
  
  public void setPromise(String paramString)
  {
    this.b = paramString;
  }
  
  public void setPromiseRemark(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/repair/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */