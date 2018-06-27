package com.ziroom.ziroomcustomer.newrepair.b;

import java.util.List;

public class g
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
  
  public static class a
  {
    private String a;
    private String b;
    private String c;
    private List<a> d;
    
    public List<a> getFaultFlagList()
    {
      return this.d;
    }
    
    public String getGoodsCode()
    {
      return this.c;
    }
    
    public String getGoodsName()
    {
      return this.a;
    }
    
    public String getGoodsPic()
    {
      return this.b;
    }
    
    public void setFaultFlagList(List<a> paramList)
    {
      this.d = paramList;
    }
    
    public void setGoodsCode(String paramString)
    {
      this.c = paramString;
    }
    
    public void setGoodsName(String paramString)
    {
      this.a = paramString;
    }
    
    public void setGoodsPic(String paramString)
    {
      this.b = paramString;
    }
    
    public static class a
    {
      private String a;
      private String b;
      private String c;
      
      public String getIsUrgent()
      {
        return this.a;
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
        this.a = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */