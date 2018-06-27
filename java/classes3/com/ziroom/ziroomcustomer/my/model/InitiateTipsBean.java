package com.ziroom.ziroomcustomer.my.model;

import java.io.Serializable;
import java.util.List;

public class InitiateTipsBean
  implements Serializable
{
  private List<BannerBean> bannar;
  private String subtitle;
  private String tips_content;
  private String tips_title;
  private String title;
  
  public List<BannerBean> getBannar()
  {
    return this.bannar;
  }
  
  public String getSubtitle()
  {
    return this.subtitle;
  }
  
  public String getTips_content()
  {
    return this.tips_content;
  }
  
  public String getTips_title()
  {
    return this.tips_title;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setBannar(List<BannerBean> paramList)
  {
    this.bannar = paramList;
  }
  
  public void setSubtitle(String paramString)
  {
    this.subtitle = paramString;
  }
  
  public void setTips_content(String paramString)
  {
    this.tips_content = paramString;
  }
  
  public void setTips_title(String paramString)
  {
    this.tips_title = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return "InitiateTipsBean{title='" + this.title + '\'' + ", subtitle='" + this.subtitle + '\'' + ", tips_title='" + this.tips_title + '\'' + ", tips_content='" + this.tips_content + '\'' + ", bannar=" + this.bannar + '}';
  }
  
  public static class BannerBean
    implements Serializable
  {
    private String app;
    private String description;
    private String img;
    private String target;
    private String title;
    
    public String getApp()
    {
      return this.app;
    }
    
    public String getDescription()
    {
      return this.description;
    }
    
    public String getImg()
    {
      return this.img;
    }
    
    public String getTarget()
    {
      return this.target;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setApp(String paramString)
    {
      this.app = paramString;
    }
    
    public void setDescription(String paramString)
    {
      this.description = paramString;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
    }
    
    public void setTarget(String paramString)
    {
      this.target = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/InitiateTipsBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */