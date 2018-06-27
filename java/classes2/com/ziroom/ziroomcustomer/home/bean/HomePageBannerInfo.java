package com.ziroom.ziroomcustomer.home.bean;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class HomePageBannerInfo
  extends b
{
  private List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public static class DataBean
  {
    private String id;
    private String pic;
    private String rgb;
    private String subtitle;
    private String title;
    private String types;
    private String url;
    
    public String getId()
    {
      return this.id;
    }
    
    public String getPic()
    {
      return this.pic;
    }
    
    public String getRgb()
    {
      return this.rgb;
    }
    
    public String getSubtitle()
    {
      return this.subtitle;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getTypes()
    {
      return this.types;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setPic(String paramString)
    {
      this.pic = paramString;
    }
    
    public void setRgb(String paramString)
    {
      this.rgb = paramString;
    }
    
    public void setSubtitle(String paramString)
    {
      this.subtitle = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setTypes(String paramString)
    {
      this.types = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/HomePageBannerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */