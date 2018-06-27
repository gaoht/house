package com.ziroom.ziroomcustomer.bestgoods.model;

import java.util.List;

public class aj
{
  private List<a> a;
  
  public List<a> getList()
  {
    return this.a;
  }
  
  public void setList(List<a> paramList)
  {
    this.a = paramList;
  }
  
  public static class a
  {
    private String a;
    private String b;
    private List<a> c;
    private String d;
    
    public List<a> getAreaDetailList()
    {
      return this.c;
    }
    
    public String getAreaDetailText()
    {
      return this.d;
    }
    
    public String getCode()
    {
      return this.a;
    }
    
    public String getTypeName()
    {
      return this.b;
    }
    
    public void setAreaDetailList(List<a> paramList)
    {
      this.c = paramList;
    }
    
    public void setAreaDetailText(String paramString)
    {
      this.d = paramString;
    }
    
    public void setCode(String paramString)
    {
      this.a = paramString;
    }
    
    public void setTypeName(String paramString)
    {
      this.b = paramString;
    }
    
    public static class a
    {
      private String a;
      private String b;
      
      public String getCityName()
      {
        return this.a;
      }
      
      public String getRegion()
      {
        return this.b;
      }
      
      public void setCityName(String paramString)
      {
        this.a = paramString;
      }
      
      public void setRegion(String paramString)
      {
        this.b = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/model/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */