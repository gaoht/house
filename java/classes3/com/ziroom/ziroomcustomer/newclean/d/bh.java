package com.ziroom.ziroomcustomer.newclean.d;

import java.util.List;

public class bh
{
  private String a;
  private List<a> b;
  private List<b> c;
  
  public List<a> getChargeItem()
  {
    return this.b;
  }
  
  public List<b> getDiscountChargeItem()
  {
    return this.c;
  }
  
  public String getTotal()
  {
    return this.a;
  }
  
  public void setChargeItem(List<a> paramList)
  {
    this.b = paramList;
  }
  
  public void setDiscountChargeItem(List<b> paramList)
  {
    this.c = paramList;
  }
  
  public void setTotal(String paramString)
  {
    this.a = paramString;
  }
  
  public static class a
  {
    private String a;
    private String b;
    
    public String getItemCost()
    {
      return this.b;
    }
    
    public String getItemName()
    {
      return this.a;
    }
    
    public void setItemCost(String paramString)
    {
      this.b = paramString;
    }
    
    public void setItemName(String paramString)
    {
      this.a = paramString;
    }
  }
  
  public static class b
  {
    private String a;
    private String b;
    
    public String getItemCost()
    {
      return this.b;
    }
    
    public String getItemName()
    {
      return this.a;
    }
    
    public void setItemCost(String paramString)
    {
      this.b = paramString;
    }
    
    public void setItemName(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/d/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */