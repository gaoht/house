package com.ziroom.ziroomcustomer.bestgoods.model;

import java.util.List;

public class af
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
  
  public class a
  {
    private String b;
    private List<a> c;
    
    public a() {}
    
    public List<a> getReplacementDetailList()
    {
      return this.c;
    }
    
    public String getTypeName()
    {
      return this.b;
    }
    
    public void setReplacementDetailList(List<a> paramList)
    {
      this.c = paramList;
    }
    
    public void setTypeName(String paramString)
    {
      this.b = paramString;
    }
    
    public class a
    {
      private String b;
      private String c;
      
      public a() {}
      
      public String getDescription()
      {
        return this.c;
      }
      
      public String getTitle()
      {
        return this.b;
      }
      
      public void setDescription(String paramString)
      {
        this.c = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.b = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/model/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */