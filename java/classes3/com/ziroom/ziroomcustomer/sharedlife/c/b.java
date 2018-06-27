package com.ziroom.ziroomcustomer.sharedlife.c;

import java.util.List;

public class b
{
  private int a;
  private String b;
  private int c;
  private String d;
  private String e;
  private Long f;
  private List<a> g;
  
  public int getDeviceStatus()
  {
    return this.a;
  }
  
  public String getImageUrl()
  {
    return this.b;
  }
  
  public Long getInterval()
  {
    return this.f;
  }
  
  public List<a> getOperationResponseList()
  {
    return this.g;
  }
  
  public int getOperationType()
  {
    return this.c;
  }
  
  public String getPageContent()
  {
    return this.d;
  }
  
  public String getPromptContent()
  {
    return this.e;
  }
  
  public void setDeviceStatus(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setImageUrl(String paramString)
  {
    this.b = paramString;
  }
  
  public void setInterval(Long paramLong)
  {
    this.f = paramLong;
  }
  
  public void setOperationResponseList(List<a> paramList)
  {
    this.g = paramList;
  }
  
  public void setOperationType(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setPageContent(String paramString)
  {
    this.d = paramString;
  }
  
  public void setPromptContent(String paramString)
  {
    this.e = paramString;
  }
  
  public static class a
  {
    private String a;
    private String b;
    private int c;
    private String d;
    private int e;
    
    public String getOperation()
    {
      return this.a;
    }
    
    public String getOperationContent()
    {
      return this.d;
    }
    
    public String getOperationMarkedName()
    {
      return this.b;
    }
    
    public int getOperationWeight()
    {
      return this.c;
    }
    
    public int getOrderMoney()
    {
      return this.e;
    }
    
    public void setOperation(String paramString)
    {
      this.a = paramString;
    }
    
    public void setOperationContent(String paramString)
    {
      this.d = paramString;
    }
    
    public void setOperationMarkedName(String paramString)
    {
      this.b = paramString;
    }
    
    public void setOperationWeight(int paramInt)
    {
      this.c = paramInt;
    }
    
    public void setOrderMoney(int paramInt)
    {
      this.e = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */