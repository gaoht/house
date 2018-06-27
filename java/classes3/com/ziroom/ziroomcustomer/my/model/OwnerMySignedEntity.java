package com.ziroom.ziroomcustomer.my.model;

import java.io.Serializable;
import java.util.List;

public class OwnerMySignedEntity
  implements Serializable
{
  private String address;
  private String end_date;
  private HouseEntity house;
  private HousekeeperEntity housekeeper;
  private IncomeEntity income;
  private boolean isSelected;
  private int is_nc;
  private String renew_tip_text;
  private ServiceEntity service;
  private String start_date;
  private int trusteeship_day;
  private int trusteeship_surplus_day;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getEnd_date()
  {
    return this.end_date;
  }
  
  public HouseEntity getHouse()
  {
    return this.house;
  }
  
  public HousekeeperEntity getHousekeeper()
  {
    return this.housekeeper;
  }
  
  public IncomeEntity getIncome()
  {
    return this.income;
  }
  
  public int getIs_nc()
  {
    return this.is_nc;
  }
  
  public String getRenew_tip_text()
  {
    return this.renew_tip_text;
  }
  
  public ServiceEntity getService()
  {
    return this.service;
  }
  
  public String getStart_date()
  {
    return this.start_date;
  }
  
  public int getTrusteeship_day()
  {
    return this.trusteeship_day;
  }
  
  public int getTrusteeship_surplus_day()
  {
    return this.trusteeship_surplus_day;
  }
  
  public boolean isSelected()
  {
    return this.isSelected;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setEnd_date(String paramString)
  {
    this.end_date = paramString;
  }
  
  public void setHouse(HouseEntity paramHouseEntity)
  {
    this.house = paramHouseEntity;
  }
  
  public void setHousekeeper(HousekeeperEntity paramHousekeeperEntity)
  {
    this.housekeeper = paramHousekeeperEntity;
  }
  
  public void setIncome(IncomeEntity paramIncomeEntity)
  {
    this.income = paramIncomeEntity;
  }
  
  public void setIs_nc(int paramInt)
  {
    this.is_nc = paramInt;
  }
  
  public void setRenew_tip_text(String paramString)
  {
    this.renew_tip_text = paramString;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }
  
  public void setService(ServiceEntity paramServiceEntity)
  {
    this.service = paramServiceEntity;
  }
  
  public void setStart_date(String paramString)
  {
    this.start_date = paramString;
  }
  
  public void setTrusteeship_day(int paramInt)
  {
    this.trusteeship_day = paramInt;
  }
  
  public void setTrusteeship_surplus_day(int paramInt)
  {
    this.trusteeship_surplus_day = paramInt;
  }
  
  public static class HouseEntity
    implements Serializable
  {
    private List<String> photos_big;
    private List<String> photos_big_webp;
    private List<String> photos_min;
    private List<String> photos_min_webp;
    
    public List<String> getPhotos_big()
    {
      return this.photos_big;
    }
    
    public List<String> getPhotos_big_webp()
    {
      return this.photos_big_webp;
    }
    
    public List<String> getPhotos_min()
    {
      return this.photos_min;
    }
    
    public List<String> getPhotos_min_webp()
    {
      return this.photos_min_webp;
    }
    
    public void setPhotos_big(List<String> paramList)
    {
      this.photos_big = paramList;
    }
    
    public void setPhotos_big_webp(List<String> paramList)
    {
      this.photos_big_webp = paramList;
    }
    
    public void setPhotos_min(List<String> paramList)
    {
      this.photos_min = paramList;
    }
    
    public void setPhotos_min_webp(List<String> paramList)
    {
      this.photos_min_webp = paramList;
    }
  }
  
  public static class HousekeeperEntity
    implements Serializable
  {
    private String avatar;
    private String desc;
    private String name;
    private String phone;
    
    public String getAvatar()
    {
      return this.avatar;
    }
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getPhone()
    {
      return this.phone;
    }
    
    public void setAvatar(String paramString)
    {
      this.avatar = paramString;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setPhone(String paramString)
    {
      this.phone = paramString;
    }
  }
  
  public static class IncomeEntity
    implements Serializable
  {
    private String amount;
    private EarningEntity latest;
    private String link;
    private String link_type;
    private EarningEntity next;
    
    public String getAmount()
    {
      return this.amount;
    }
    
    public EarningEntity getLatest()
    {
      return this.latest;
    }
    
    public String getLink()
    {
      return this.link;
    }
    
    public String getLink_type()
    {
      return this.link_type;
    }
    
    public EarningEntity getNext()
    {
      return this.next;
    }
    
    public void setAmount(String paramString)
    {
      this.amount = paramString;
    }
    
    public void setLatest(EarningEntity paramEarningEntity)
    {
      this.latest = paramEarningEntity;
    }
    
    public void setLink(String paramString)
    {
      this.link = paramString;
    }
    
    public void setLink_type(String paramString)
    {
      this.link_type = paramString;
    }
    
    public void setNext(EarningEntity paramEarningEntity)
    {
      this.next = paramEarningEntity;
    }
    
    public static class EarningEntity
      implements Serializable
    {
      private String amount;
      private String date;
      
      public String getAmount()
      {
        return this.amount;
      }
      
      public String getDate()
      {
        return this.date;
      }
      
      public void setAmount(String paramString)
      {
        this.amount = paramString;
      }
      
      public void setDate(String paramString)
      {
        this.date = paramString;
      }
    }
  }
  
  public static class ServiceEntity
    implements Serializable
  {
    private String clean_text;
    private int clean_times;
    private String link;
    private String link_type;
    private String repair_text;
    private int repair_times;
    
    public String getClean_text()
    {
      return this.clean_text;
    }
    
    public int getClean_times()
    {
      return this.clean_times;
    }
    
    public String getLink()
    {
      return this.link;
    }
    
    public String getLink_type()
    {
      return this.link_type;
    }
    
    public String getRepair_text()
    {
      return this.repair_text;
    }
    
    public int getRepair_times()
    {
      return this.repair_times;
    }
    
    public void setClean_text(String paramString)
    {
      this.clean_text = paramString;
    }
    
    public void setClean_times(int paramInt)
    {
      this.clean_times = paramInt;
    }
    
    public void setLink(String paramString)
    {
      this.link = paramString;
    }
    
    public void setLink_type(String paramString)
    {
      this.link_type = paramString;
    }
    
    public void setRepair_text(String paramString)
    {
      this.repair_text = paramString;
    }
    
    public void setRepair_times(int paramInt)
    {
      this.repair_times = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OwnerMySignedEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */