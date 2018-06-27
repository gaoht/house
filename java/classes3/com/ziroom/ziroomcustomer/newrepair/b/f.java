package com.ziroom.ziroomcustomer.newrepair.b;

import java.util.List;

public class f
{
  private List<a> a;
  
  public List<a> getRepairGoodsList()
  {
    return this.a;
  }
  
  public void setRepairGoodsList(List<a> paramList)
  {
    this.a = paramList;
  }
  
  public class a
  {
    private String b;
    private String c;
    private String d;
    private List<a> e;
    
    public a() {}
    
    public List<a> getFaultFlagList()
    {
      return this.e;
    }
    
    public String getGoodsCode()
    {
      return this.d;
    }
    
    public String getGoodsName()
    {
      return this.b;
    }
    
    public String getGoodsPic()
    {
      return this.c;
    }
    
    public void setFaultFlagList(List<a> paramList)
    {
      this.e = paramList;
    }
    
    public void setGoodsCode(String paramString)
    {
      this.d = paramString;
    }
    
    public void setGoodsName(String paramString)
    {
      this.b = paramString;
    }
    
    public void setGoodsPic(String paramString)
    {
      this.c = paramString;
    }
    
    public class a
    {
      private String b;
      private String c;
      private String d;
      
      public a() {}
      
      public String getIsUrgent()
      {
        return this.d;
      }
      
      public String getMaintainTag()
      {
        return this.b;
      }
      
      public String getMaintainTagId()
      {
        return this.c;
      }
      
      public void setIsUrgent(String paramString)
      {
        this.d = paramString;
      }
      
      public void setMaintainTag(String paramString)
      {
        this.b = paramString;
      }
      
      public void setMaintainTagId(String paramString)
      {
        this.c = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */