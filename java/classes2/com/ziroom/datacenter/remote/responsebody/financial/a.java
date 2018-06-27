package com.ziroom.datacenter.remote.responsebody.financial;

import java.util.List;

public class a
  extends com.ziroom.datacenter.remote.responsebody.a
{
  private a e;
  
  public a getData()
  {
    return this.e;
  }
  
  public void setData(a parama)
  {
    this.e = parama;
  }
  
  public static class a
  {
    private String a;
    private String b;
    private List<Object> c;
    
    public String getBalance()
    {
      return this.a;
    }
    
    public List<Object> getChildrenAccounts()
    {
      return this.c;
    }
    
    public String getFrozenBalance()
    {
      return this.b;
    }
    
    public void setBalance(String paramString)
    {
      this.a = paramString;
    }
    
    public void setChildrenAccounts(List<Object> paramList)
    {
      this.c = paramList;
    }
    
    public void setFrozenBalance(String paramString)
    {
      this.b = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */