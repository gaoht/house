package com.ziroom.ziroomcustomer.newclean.d;

import java.util.List;

public class be
{
  private List<b> a;
  private List<a> b;
  
  public List<a> getPointItems()
  {
    return this.b;
  }
  
  public List<b> getSelectItems()
  {
    return this.a;
  }
  
  public void setPointItems(List<a> paramList)
  {
    this.b = paramList;
  }
  
  public void setSelectItems(List<b> paramList)
  {
    this.a = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("selectItems:");
    if (this.a == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str).append(",pointItems:");
      if (this.b != null) {
        break label64;
      }
    }
    label64:
    for (String str = "";; str = this.b.toString())
    {
      return str;
      str = this.a.toString();
      break;
    }
  }
  
  public static class a
  {
    private String a;
    private String b;
    
    public String getFid()
    {
      return this.b;
    }
    
    public String getFpointitem()
    {
      return this.a;
    }
    
    public void setFid(String paramString)
    {
      this.b = paramString;
    }
    
    public void setFpointitem(String paramString)
    {
      this.a = paramString;
    }
  }
  
  public static class b
  {
    private String a;
    private int b;
    
    public String getName()
    {
      return this.a;
    }
    
    public int getValue()
    {
      return this.b;
    }
    
    public void setName(String paramString)
    {
      this.a = paramString;
    }
    
    public void setValue(int paramInt)
    {
      this.b = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/d/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */