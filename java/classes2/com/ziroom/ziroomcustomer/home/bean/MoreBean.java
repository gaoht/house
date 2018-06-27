package com.ziroom.ziroomcustomer.home.bean;

import java.io.Serializable;
import java.util.List;

public class MoreBean
  implements Serializable
{
  private List<TypeBean> leasetype;
  private List<TypeBean> tag;
  private List<TypeBean> type;
  private List<Version2Bean> version2;
  
  public List<TypeBean> getLeasetype()
  {
    return this.leasetype;
  }
  
  public List<TypeBean> getTag()
  {
    return this.tag;
  }
  
  public List<TypeBean> getType()
  {
    return this.type;
  }
  
  public List<Version2Bean> getVersion2()
  {
    return this.version2;
  }
  
  public void setLeasetype(List<TypeBean> paramList)
  {
    this.leasetype = paramList;
  }
  
  public void setTag(List<TypeBean> paramList)
  {
    this.tag = paramList;
  }
  
  public void setType(List<TypeBean> paramList)
  {
    this.type = paramList;
  }
  
  public void setVersion2(List<Version2Bean> paramList)
  {
    this.version2 = paramList;
  }
  
  public static class TypeBean
    implements Serializable
  {
    private String title;
    private String type;
    private String value;
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getType()
    {
      return this.type;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setType(String paramString)
    {
      this.type = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
  
  public static class Version2Bean
    implements Serializable
  {
    private String title;
    private String value;
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/MoreBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */