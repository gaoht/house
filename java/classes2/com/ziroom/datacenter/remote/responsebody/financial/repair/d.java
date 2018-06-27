package com.ziroom.datacenter.remote.responsebody.financial.repair;

import java.util.List;

public class d
{
  private String a;
  private String b;
  private List<Object> c;
  
  public List<Object> getGoodsList()
  {
    return this.c;
  }
  
  public String getTypeCode()
  {
    return this.a;
  }
  
  public String getTypeName()
  {
    return this.b;
  }
  
  public void setGoodsList(List<Object> paramList)
  {
    this.c = paramList;
  }
  
  public void setTypeCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setTypeName(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/repair/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */