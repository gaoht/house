package com.ziroom.ziroomcustomer.newrepair.b;

import java.io.Serializable;

public class q
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  
  public String getEmpTypeId()
  {
    return this.b;
  }
  
  public String getKjId()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public void setEmpTypeId(String paramString)
  {
    this.b = paramString;
  }
  
  public void setKjId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setName(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */