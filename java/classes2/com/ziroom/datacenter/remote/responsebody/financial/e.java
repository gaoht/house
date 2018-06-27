package com.ziroom.datacenter.remote.responsebody.financial;

import java.util.List;

public class e
{
  private String a;
  private String b;
  private List<Object> c;
  
  public List<Object> getList()
  {
    return this.c;
  }
  
  public String getPromotionCode()
  {
    return this.b;
  }
  
  public String getPromotionId()
  {
    return this.a;
  }
  
  public void setList(List<Object> paramList)
  {
    this.c = paramList;
  }
  
  public void setPromotionCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setPromotionId(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */