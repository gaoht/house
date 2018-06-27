package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class OwnerMyBannerOneBean
{
  public List<BannerBean> banner;
  public ClubBean club;
  public List<HuodongBean> huodong;
  public List<MenuPrimayBean> menu_primay;
  public List<MenuSecondaryBean> menu_secondary;
  public TipBean tip;
  public TrendsBean trends;
  public List<YezhubannerBean> yezhubanner;
  
  public List<BannerBean> getBanner()
  {
    return this.banner;
  }
  
  public ClubBean getClub()
  {
    return this.club;
  }
  
  public List<MenuPrimayBean> getMenu_primay()
  {
    return this.menu_primay;
  }
  
  public List<MenuSecondaryBean> getMenu_secondary()
  {
    return this.menu_secondary;
  }
  
  public TipBean getTip()
  {
    return this.tip;
  }
  
  public TrendsBean getTrends()
  {
    return this.trends;
  }
  
  public List<YezhubannerBean> getYezhubanner()
  {
    return this.yezhubanner;
  }
  
  public void setBanner(List<BannerBean> paramList)
  {
    this.banner = paramList;
  }
  
  public void setClub(ClubBean paramClubBean)
  {
    this.club = paramClubBean;
  }
  
  public void setMenu_primay(List<MenuPrimayBean> paramList)
  {
    this.menu_primay = paramList;
  }
  
  public void setMenu_secondary(List<MenuSecondaryBean> paramList)
  {
    this.menu_secondary = paramList;
  }
  
  public void setTip(TipBean paramTipBean)
  {
    this.tip = paramTipBean;
  }
  
  public void setTrends(TrendsBean paramTrendsBean)
  {
    this.trends = paramTrendsBean;
  }
  
  public void setYezhubanner(List<YezhubannerBean> paramList)
  {
    this.yezhubanner = paramList;
  }
  
  public static class BannerBean
  {
    public String app;
    public String description;
    public String img;
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
  
  public static class ClubBean
  {
    public List<ListBean> list;
    public String title;
    
    public List<ListBean> getList()
    {
      return this.list;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setList(List<ListBean> paramList)
    {
      this.list = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class ListBean
    {
      public String app;
      public String description;
      public String img;
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
  
  public static class HuodongBean
  {
    public String app;
    public String description;
    public String img;
    public String target;
    public String title;
  }
  
  public static class MenuPrimayBean
  {
    public String app;
    public String applink;
    public String description;
    public String img;
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
  
  public static class MenuSecondaryBean
  {
    public String app;
    public String description;
    public String img;
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
  
  public static class TipBean
  {
    public String desc;
    public String icon;
    public String target;
    public String title;
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public String getIcon()
    {
      return this.icon;
    }
    
    public String getTarget()
    {
      return this.target;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setIcon(String paramString)
    {
      this.icon = paramString;
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
  
  public static class TrendsBean
  {
    public List<ListBean> list;
    public String title;
    
    public List<ListBean> getList()
    {
      return this.list;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setList(List<ListBean> paramList)
    {
      this.list = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class ListBean
    {
      public String app;
      public String description;
      public String img;
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
  
  public static class YezhubannerBean
  {
    public String app;
    public String description;
    public String img;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OwnerMyBannerOneBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */