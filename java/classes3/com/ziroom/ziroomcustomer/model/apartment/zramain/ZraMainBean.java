package com.ziroom.ziroomcustomer.model.apartment.zramain;

import java.util.List;

public class ZraMainBean
{
  public ActivityBean activity;
  public BannerBean banner;
  public BusinessBean business;
  public HeadBean head;
  public HouseBean house;
  public IconBean icon;
  public MoreBean more;
  public ZiroomerBean ziroomer;
  public ZryBean zry;
  
  public ActivityBean getActivity()
  {
    return this.activity;
  }
  
  public BannerBean getBanner()
  {
    return this.banner;
  }
  
  public BusinessBean getBusiness()
  {
    return this.business;
  }
  
  public HeadBean getHead()
  {
    return this.head;
  }
  
  public HouseBean getHouse()
  {
    return this.house;
  }
  
  public IconBean getIcon()
  {
    return this.icon;
  }
  
  public MoreBean getMore()
  {
    return this.more;
  }
  
  public ZiroomerBean getZiroomer()
  {
    return this.ziroomer;
  }
  
  public ZryBean getZry()
  {
    return this.zry;
  }
  
  public void setActivity(ActivityBean paramActivityBean)
  {
    this.activity = paramActivityBean;
  }
  
  public void setBanner(BannerBean paramBannerBean)
  {
    this.banner = paramBannerBean;
  }
  
  public void setBusiness(BusinessBean paramBusinessBean)
  {
    this.business = paramBusinessBean;
  }
  
  public void setHead(HeadBean paramHeadBean)
  {
    this.head = paramHeadBean;
  }
  
  public void setHouse(HouseBean paramHouseBean)
  {
    this.house = paramHouseBean;
  }
  
  public void setIcon(IconBean paramIconBean)
  {
    this.icon = paramIconBean;
  }
  
  public void setMore(MoreBean paramMoreBean)
  {
    this.more = paramMoreBean;
  }
  
  public void setZiroomer(ZiroomerBean paramZiroomerBean)
  {
    this.ziroomer = paramZiroomerBean;
  }
  
  public void setZry(ZryBean paramZryBean)
  {
    this.zry = paramZryBean;
  }
  
  public static class ActivityBean
  {
    public List<LunboBeanXXXXXX> lunbo;
    public String title;
    
    public List<LunboBeanXXXXXX> getLunbo()
    {
      return this.lunbo;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setLunbo(List<LunboBeanXXXXXX> paramList)
    {
      this.lunbo = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class LunboBeanXXXXXX
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
  
  public static class BannerBean
  {
    public List<LunboBeanXXX> lunbo;
    
    public List<LunboBeanXXX> getLunbo()
    {
      return this.lunbo;
    }
    
    public void setLunbo(List<LunboBeanXXX> paramList)
    {
      this.lunbo = paramList;
    }
    
    public static class LunboBeanXXX
    {
      public int allBoolParamas;
      public String app;
      public String description;
      public String img;
      public String target;
      public String title;
      
      public int getAllBoolParamas()
      {
        return this.allBoolParamas;
      }
      
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
      
      public void setAllBoolParamas(int paramInt)
      {
        this.allBoolParamas = paramInt;
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
  
  public static class BusinessBean
  {
    public String business_mail;
    public String business_tel;
    
    public String getBusiness_mail()
    {
      return this.business_mail;
    }
    
    public String getBusiness_tel()
    {
      return this.business_tel;
    }
    
    public void setBusiness_mail(String paramString)
    {
      this.business_mail = paramString;
    }
    
    public void setBusiness_tel(String paramString)
    {
      this.business_tel = paramString;
    }
  }
  
  public static class HeadBean
  {
    public LunboBean lunbo;
    public String projectNums;
    public String subtitle;
    public String title;
    
    public LunboBean getLunbo()
    {
      return this.lunbo;
    }
    
    public String getSubtitle()
    {
      return this.subtitle;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setLunbo(LunboBean paramLunboBean)
    {
      this.lunbo = paramLunboBean;
    }
    
    public void setSubtitle(String paramString)
    {
      this.subtitle = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class LunboBean
    {
      public int allBoolParamas;
      public String app;
      public String description;
      public String img;
      public String target;
      public String title;
      
      public int getAllBoolParamas()
      {
        return this.allBoolParamas;
      }
      
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
      
      public void setAllBoolParamas(int paramInt)
      {
        this.allBoolParamas = paramInt;
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
  
  public static class HouseBean
  {
    public List<LunboBeanXX> lunbo;
    public String title;
    
    public List<LunboBeanXX> getLunbo()
    {
      return this.lunbo;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setLunbo(List<LunboBeanXX> paramList)
    {
      this.lunbo = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class LunboBeanXX
    {
      public String app;
      public String description;
      public String img;
      public String price;
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
      
      public String getPrice()
      {
        return this.price;
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
      
      public void setPrice(String paramString)
      {
        this.price = paramString;
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
  
  public static class IconBean
  {
    public List<LunboBeanX> lunbo;
    
    public List<LunboBeanX> getLunbo()
    {
      return this.lunbo;
    }
    
    public void setLunbo(List<LunboBeanX> paramList)
    {
      this.lunbo = paramList;
    }
    
    public static class LunboBeanX
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
  
  public static class MoreBean
  {
    public List<LunboBeanXXXXXXX> lunbo;
    public String title;
    
    public List<LunboBeanXXXXXXX> getLunbo()
    {
      return this.lunbo;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setLunbo(List<LunboBeanXXXXXXX> paramList)
    {
      this.lunbo = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class LunboBeanXXXXXXX
    {
      public String address;
      public String app;
      public String description;
      public String img;
      public String price;
      public String target;
      public String title;
      
      public String getAddress()
      {
        return this.address;
      }
      
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
      
      public String getPrice()
      {
        return this.price;
      }
      
      public String getTarget()
      {
        return this.target;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setAddress(String paramString)
      {
        this.address = paramString;
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
      
      public void setPrice(String paramString)
      {
        this.price = paramString;
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
  
  public static class ZiroomerBean
  {
    public List<LunboBeanXXXXX> lunbo;
    public String title;
    
    public List<LunboBeanXXXXX> getLunbo()
    {
      return this.lunbo;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setLunbo(List<LunboBeanXXXXX> paramList)
    {
      this.lunbo = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class LunboBeanXXXXX
    {
      public String app;
      public String description;
      public String headImg;
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
      
      public String getHeadImg()
      {
        return this.headImg;
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
      
      public void setHeadImg(String paramString)
      {
        this.headImg = paramString;
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
  
  public static class ZryBean
  {
    public List<LunboBeanXXXX> lunbo;
    public String title;
    
    public List<LunboBeanXXXX> getLunbo()
    {
      return this.lunbo;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setLunbo(List<LunboBeanXXXX> paramList)
    {
      this.lunbo = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class LunboBeanXXXX
    {
      public String app;
      public String img;
      public String price;
      public String projectInfoLabel;
      public String projectName;
      public String shortRentLabel;
      public String subtitle;
      public String target;
      public List<ThumbnailsBean> thumbnails;
      public String title;
      
      public String getApp()
      {
        return this.app;
      }
      
      public String getImg()
      {
        return this.img;
      }
      
      public String getPrice()
      {
        return this.price;
      }
      
      public String getProjectInfoLabel()
      {
        return this.projectInfoLabel;
      }
      
      public String getProjectName()
      {
        return this.projectName;
      }
      
      public String getShortRentLabel()
      {
        return this.shortRentLabel;
      }
      
      public String getSubtitle()
      {
        return this.subtitle;
      }
      
      public String getTarget()
      {
        return this.target;
      }
      
      public List<ThumbnailsBean> getThumbnails()
      {
        return this.thumbnails;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setApp(String paramString)
      {
        this.app = paramString;
      }
      
      public void setImg(String paramString)
      {
        this.img = paramString;
      }
      
      public void setPrice(String paramString)
      {
        this.price = paramString;
      }
      
      public void setProjectInfoLabel(String paramString)
      {
        this.projectInfoLabel = paramString;
      }
      
      public void setProjectName(String paramString)
      {
        this.projectName = paramString;
      }
      
      public void setShortRentLabel(String paramString)
      {
        this.shortRentLabel = paramString;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTarget(String paramString)
      {
        this.target = paramString;
      }
      
      public void setThumbnails(List<ThumbnailsBean> paramList)
      {
        this.thumbnails = paramList;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ThumbnailsBean
      {
        public String description;
        public String target;
        
        public String getDescription()
        {
          return this.description;
        }
        
        public String getTarget()
        {
          return this.target;
        }
        
        public void setDescription(String paramString)
        {
          this.description = paramString;
        }
        
        public void setTarget(String paramString)
        {
          this.target = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/apartment/zramain/ZraMainBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */