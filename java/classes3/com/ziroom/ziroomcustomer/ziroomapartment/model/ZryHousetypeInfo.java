package com.ziroom.ziroomcustomer.ziroomapartment.model;

import java.util.List;

public class ZryHousetypeInfo
{
  private List<LabBean> activityLab;
  private List<String> basicLab;
  private String bookUrl;
  private String coreLab = "";
  private List<HouseConfigDtoListBean> houseConfigDtoList;
  private List<HouseTypeImgDtoListBean> houseTypeImgDtoList;
  private String houseTypeName = "";
  private String lat;
  private String lng;
  private String maxPrice = "";
  private String minPrice = "";
  private int newBookPage;
  private String panoramicUrl = "";
  private String phone = "";
  private String proAddrDesc = "";
  private String roomIntroduction = "";
  private String shareUrl = "";
  
  public List<LabBean> getActivityLab()
  {
    return this.activityLab;
  }
  
  public List<String> getBasicLab()
  {
    return this.basicLab;
  }
  
  public String getBookUrl()
  {
    return this.bookUrl;
  }
  
  public String getCoreLab()
  {
    return this.coreLab;
  }
  
  public List<HouseConfigDtoListBean> getHouseConfigDtoList()
  {
    return this.houseConfigDtoList;
  }
  
  public List<HouseTypeImgDtoListBean> getHouseTypeImgDtoList()
  {
    return this.houseTypeImgDtoList;
  }
  
  public String getHouseTypeName()
  {
    return this.houseTypeName;
  }
  
  public String getLat()
  {
    return this.lat;
  }
  
  public String getLng()
  {
    return this.lng;
  }
  
  public String getMaxPrice()
  {
    return this.maxPrice;
  }
  
  public String getMinPrice()
  {
    return this.minPrice;
  }
  
  public int getNewBookPage()
  {
    return this.newBookPage;
  }
  
  public String getPanoramicUrl()
  {
    return this.panoramicUrl;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getProAddrDesc()
  {
    return this.proAddrDesc;
  }
  
  public String getRoomIntroduction()
  {
    return this.roomIntroduction;
  }
  
  public String getShareUrl()
  {
    return this.shareUrl;
  }
  
  public void setActivityLab(List<LabBean> paramList)
  {
    this.activityLab = paramList;
  }
  
  public void setBasicLab(List<String> paramList)
  {
    this.basicLab = paramList;
  }
  
  public void setBookUrl(String paramString)
  {
    this.bookUrl = paramString;
  }
  
  public void setCoreLab(String paramString)
  {
    this.coreLab = paramString;
  }
  
  public void setHouseConfigDtoList(List<HouseConfigDtoListBean> paramList)
  {
    this.houseConfigDtoList = paramList;
  }
  
  public void setHouseTypeImgDtoList(List<HouseTypeImgDtoListBean> paramList)
  {
    this.houseTypeImgDtoList = paramList;
  }
  
  public void setHouseTypeName(String paramString)
  {
    this.houseTypeName = paramString;
  }
  
  public void setLat(String paramString)
  {
    this.lat = paramString;
  }
  
  public void setLng(String paramString)
  {
    this.lng = paramString;
  }
  
  public void setMaxPrice(String paramString)
  {
    this.maxPrice = paramString;
  }
  
  public void setMinPrice(String paramString)
  {
    this.minPrice = paramString;
  }
  
  public void setNewBookPage(int paramInt)
  {
    this.newBookPage = paramInt;
  }
  
  public void setPanoramicUrl(String paramString)
  {
    this.panoramicUrl = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setProAddrDesc(String paramString)
  {
    this.proAddrDesc = paramString;
  }
  
  public void setRoomIntroduction(String paramString)
  {
    this.roomIntroduction = paramString;
  }
  
  public void setShareUrl(String paramString)
  {
    this.shareUrl = paramString;
  }
  
  public static class HouseConfigDtoListBean
  {
    private String imgUrl = "";
    private String itemId = "";
    private String itemName = "";
    private int itemOrder;
    
    public String getImgUrl()
    {
      return this.imgUrl;
    }
    
    public String getItemId()
    {
      return this.itemId;
    }
    
    public String getItemName()
    {
      return this.itemName;
    }
    
    public int getItemOrder()
    {
      return this.itemOrder;
    }
    
    public void setImgUrl(String paramString)
    {
      this.imgUrl = paramString;
    }
    
    public void setItemId(String paramString)
    {
      this.itemId = paramString;
    }
    
    public void setItemName(String paramString)
    {
      this.itemName = paramString;
    }
    
    public void setItemOrder(int paramInt)
    {
      this.itemOrder = paramInt;
    }
    
    public String toString()
    {
      return "HouseConfigDtoListBean{itemId='" + this.itemId + '\'' + ", imgUrl='" + this.imgUrl + '\'' + ", itemName='" + this.itemName + '\'' + ", itemOrder=" + this.itemOrder + '}';
    }
  }
  
  public static class HouseTypeImgDtoListBean
  {
    private List<String> imgPathList;
    private String imgTypeName = "";
    
    public List<String> getImgPathList()
    {
      return this.imgPathList;
    }
    
    public String getImgTypeName()
    {
      return this.imgTypeName;
    }
    
    public void setImgPathList(List<String> paramList)
    {
      this.imgPathList = paramList;
    }
    
    public void setImgTypeName(String paramString)
    {
      this.imgTypeName = paramString;
    }
    
    public String toString()
    {
      return "HouseTypeImgDtoListBean{imgTypeName='" + this.imgTypeName + '\'' + ", imgPathList=" + this.imgPathList + '}';
    }
  }
  
  public static class LabBean
  {
    private String content = "";
    private String hUrl = "";
    private String imgUrl = "";
    
    public String getContent()
    {
      return this.content;
    }
    
    public String getImgUrl()
    {
      return this.imgUrl;
    }
    
    public String gethUrl()
    {
      return this.hUrl;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
    
    public void setImgUrl(String paramString)
    {
      this.imgUrl = paramString;
    }
    
    public void sethUrl(String paramString)
    {
      this.hUrl = paramString;
    }
    
    public String toString()
    {
      return "LabBean{content='" + this.content + '\'' + ", imgUrl='" + this.imgUrl + '\'' + ", hUrl='" + this.hUrl + '\'' + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryHousetypeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */