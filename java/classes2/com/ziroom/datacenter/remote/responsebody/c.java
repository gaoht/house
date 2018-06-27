package com.ziroom.datacenter.remote.responsebody;

import java.util.List;

public class c
{
  private a a;
  private List<Object> b;
  
  public List<Object> getTips()
  {
    return this.b;
  }
  
  public a getTopBanner()
  {
    return this.a;
  }
  
  public void setTips(List<Object> paramList)
  {
    this.b = paramList;
  }
  
  public void setTopBanner(a parama)
  {
    this.a = parama;
  }
  
  public class a
  {
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    
    public a() {}
    
    public String getPic()
    {
      return this.b;
    }
    
    public String getSubtitle()
    {
      return this.c;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public String getTypes()
    {
      return this.e;
    }
    
    public String getUrl()
    {
      return this.f;
    }
    
    public void setPic(String paramString)
    {
      this.b = paramString;
    }
    
    public void setSubtitle(String paramString)
    {
      this.c = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.d = paramString;
    }
    
    public void setTypes(String paramString)
    {
      this.e = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.f = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */