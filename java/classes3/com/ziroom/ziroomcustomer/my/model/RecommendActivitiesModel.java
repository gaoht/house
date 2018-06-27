package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class RecommendActivitiesModel
{
  public String button_name;
  public List<ContentBean> content;
  public String created_at;
  public int id;
  public String isOpenActivity;
  public String subtitle;
  public String title;
  public String updated_at;
  
  public String getButton_name()
  {
    return this.button_name;
  }
  
  public List<ContentBean> getContent()
  {
    return this.content;
  }
  
  public String getCreated_at()
  {
    return this.created_at;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getIsOpenActivity()
  {
    return this.isOpenActivity;
  }
  
  public String getSubtitle()
  {
    return this.subtitle;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUpdated_at()
  {
    return this.updated_at;
  }
  
  public void setButton_name(String paramString)
  {
    this.button_name = paramString;
  }
  
  public void setContent(List<ContentBean> paramList)
  {
    this.content = paramList;
  }
  
  public void setCreated_at(String paramString)
  {
    this.created_at = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsOpenActivity(String paramString)
  {
    this.isOpenActivity = paramString;
  }
  
  public void setSubtitle(String paramString)
  {
    this.subtitle = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUpdated_at(String paramString)
  {
    this.updated_at = paramString;
  }
  
  public static class ContentBean
  {
    public String app;
    public String description;
    public String img;
    public String sort;
    public String target;
    public String title;
    
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
    
    public String getSort()
    {
      return this.sort;
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
    
    public void setSort(String paramString)
    {
      this.sort = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/RecommendActivitiesModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */