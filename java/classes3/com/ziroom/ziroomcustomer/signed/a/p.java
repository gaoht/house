package com.ziroom.ziroomcustomer.signed.a;

import java.util.List;

public class p
{
  private String a;
  private String b;
  private String c;
  private List<p> d;
  
  public List<p> getAspects()
  {
    return this.d;
  }
  
  public String getCode()
  {
    return this.a;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public void setAspects(List<p> paramList)
  {
    this.d = paramList;
  }
  
  public void setCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setId(String paramString)
  {
    this.b = paramString;
  }
  
  public void setName(String paramString)
  {
    this.c = paramString;
  }
  
  public String toString()
  {
    return "TradeDirectModel{code='" + this.a + '\'' + ", id='" + this.b + '\'' + ", name='" + this.c + '\'' + ", aspects=" + this.d + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */