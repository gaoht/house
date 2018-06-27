package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import java.io.Serializable;
import java.util.List;

public class LandlordReleaseHousePriceBasicData
  implements Serializable
{
  private Integer balconyNum;
  private BedTypeListBean bedTypeList;
  private CheckInLimitBean checkInLimit;
  private CleaningFeesBean cleaningFees;
  private int cleaningFeesPer;
  private int fullDayRateSwitch;
  private List<HouseFacilityGroupBean> groupFacilityList;
  private HouseAreaBean houseArea;
  private String houseBaseFid;
  private HouseFacilityBean houseFacility;
  private HouseModelBean houseModel;
  private List<HouseRoomListBean> houseRoomList;
  private Integer kitchenNum;
  private LeasePriceBean leasePrice;
  private Integer maxBalcony;
  private Integer maxKitchen;
  private Integer maxParlor;
  private int maxPrice;
  private Integer maxRoom;
  private Integer maxToilet;
  private int minPrice;
  private Integer parlorNum;
  private int rentWay;
  private String roomFid;
  private Integer roomNum;
  private SevenDiscountRateBean sevenDiscountRate;
  private ThirtyDiscountRateBean thirtyDiscountRate;
  private Integer toiletNum;
  private WeekendListBean weekendList;
  private WeekendPriceBean weekendPrice;
  private int weekendPriceSwitch;
  
  public Integer getBalconyNum()
  {
    return this.balconyNum;
  }
  
  public BedTypeListBean getBedTypeList()
  {
    return this.bedTypeList;
  }
  
  public CheckInLimitBean getCheckInLimit()
  {
    return this.checkInLimit;
  }
  
  public CleaningFeesBean getCleaningFees()
  {
    return this.cleaningFees;
  }
  
  public int getCleaningFeesPer()
  {
    return this.cleaningFeesPer;
  }
  
  public int getFullDayRateSwitch()
  {
    return this.fullDayRateSwitch;
  }
  
  public List<HouseFacilityGroupBean> getGroupFacilityList()
  {
    return this.groupFacilityList;
  }
  
  public HouseAreaBean getHouseArea()
  {
    return this.houseArea;
  }
  
  public String getHouseBaseFid()
  {
    return this.houseBaseFid;
  }
  
  public HouseFacilityBean getHouseFacility()
  {
    return this.houseFacility;
  }
  
  public HouseModelBean getHouseModel()
  {
    return this.houseModel;
  }
  
  public List<HouseRoomListBean> getHouseRoomList()
  {
    return this.houseRoomList;
  }
  
  public Integer getKitchenNum()
  {
    return this.kitchenNum;
  }
  
  public LeasePriceBean getLeasePrice()
  {
    return this.leasePrice;
  }
  
  public Integer getMaxBalcony()
  {
    return this.maxBalcony;
  }
  
  public Integer getMaxKitchen()
  {
    return this.maxKitchen;
  }
  
  public Integer getMaxParlor()
  {
    return this.maxParlor;
  }
  
  public int getMaxPrice()
  {
    return this.maxPrice;
  }
  
  public Integer getMaxRoom()
  {
    return this.maxRoom;
  }
  
  public Integer getMaxToilet()
  {
    return this.maxToilet;
  }
  
  public int getMinPrice()
  {
    return this.minPrice;
  }
  
  public Integer getParlorNum()
  {
    return this.parlorNum;
  }
  
  public int getRentWay()
  {
    return this.rentWay;
  }
  
  public String getRoomFid()
  {
    return this.roomFid;
  }
  
  public Integer getRoomNum()
  {
    return this.roomNum;
  }
  
  public SevenDiscountRateBean getSevenDiscountRate()
  {
    return this.sevenDiscountRate;
  }
  
  public ThirtyDiscountRateBean getThirtyDiscountRate()
  {
    return this.thirtyDiscountRate;
  }
  
  public Integer getToiletNum()
  {
    return this.toiletNum;
  }
  
  public WeekendListBean getWeekendList()
  {
    return this.weekendList;
  }
  
  public WeekendPriceBean getWeekendPrice()
  {
    return this.weekendPrice;
  }
  
  public int getWeekendPriceSwitch()
  {
    return this.weekendPriceSwitch;
  }
  
  public void setBalconyNum(Integer paramInteger)
  {
    this.balconyNum = paramInteger;
  }
  
  public void setBedTypeList(BedTypeListBean paramBedTypeListBean)
  {
    this.bedTypeList = paramBedTypeListBean;
  }
  
  public void setCheckInLimit(CheckInLimitBean paramCheckInLimitBean)
  {
    this.checkInLimit = paramCheckInLimitBean;
  }
  
  public void setCleaningFees(CleaningFeesBean paramCleaningFeesBean)
  {
    this.cleaningFees = paramCleaningFeesBean;
  }
  
  public void setCleaningFeesPer(int paramInt)
  {
    this.cleaningFeesPer = paramInt;
  }
  
  public void setFullDayRateSwitch(int paramInt)
  {
    this.fullDayRateSwitch = paramInt;
  }
  
  public void setGroupFacilityList(List<HouseFacilityGroupBean> paramList)
  {
    this.groupFacilityList = paramList;
  }
  
  public void setHouseArea(HouseAreaBean paramHouseAreaBean)
  {
    this.houseArea = paramHouseAreaBean;
  }
  
  public void setHouseBaseFid(String paramString)
  {
    this.houseBaseFid = paramString;
  }
  
  public void setHouseFacility(HouseFacilityBean paramHouseFacilityBean)
  {
    this.houseFacility = paramHouseFacilityBean;
  }
  
  public void setHouseModel(HouseModelBean paramHouseModelBean)
  {
    this.houseModel = paramHouseModelBean;
  }
  
  public void setHouseRoomList(List<HouseRoomListBean> paramList)
  {
    this.houseRoomList = paramList;
  }
  
  public void setKitchenNum(Integer paramInteger)
  {
    this.kitchenNum = paramInteger;
  }
  
  public void setLeasePrice(LeasePriceBean paramLeasePriceBean)
  {
    this.leasePrice = paramLeasePriceBean;
  }
  
  public void setMaxBalcony(Integer paramInteger)
  {
    this.maxBalcony = paramInteger;
  }
  
  public void setMaxKitchen(Integer paramInteger)
  {
    this.maxKitchen = paramInteger;
  }
  
  public void setMaxParlor(Integer paramInteger)
  {
    this.maxParlor = paramInteger;
  }
  
  public void setMaxPrice(int paramInt)
  {
    this.maxPrice = paramInt;
  }
  
  public void setMaxRoom(Integer paramInteger)
  {
    this.maxRoom = paramInteger;
  }
  
  public void setMaxToilet(Integer paramInteger)
  {
    this.maxToilet = paramInteger;
  }
  
  public void setMinPrice(int paramInt)
  {
    this.minPrice = paramInt;
  }
  
  public void setParlorNum(Integer paramInteger)
  {
    this.parlorNum = paramInteger;
  }
  
  public void setRentWay(int paramInt)
  {
    this.rentWay = paramInt;
  }
  
  public void setRoomFid(String paramString)
  {
    this.roomFid = paramString;
  }
  
  public void setRoomNum(Integer paramInteger)
  {
    this.roomNum = paramInteger;
  }
  
  public void setSevenDiscountRate(SevenDiscountRateBean paramSevenDiscountRateBean)
  {
    this.sevenDiscountRate = paramSevenDiscountRateBean;
  }
  
  public void setThirtyDiscountRate(ThirtyDiscountRateBean paramThirtyDiscountRateBean)
  {
    this.thirtyDiscountRate = paramThirtyDiscountRateBean;
  }
  
  public void setToiletNum(Integer paramInteger)
  {
    this.toiletNum = paramInteger;
  }
  
  public void setWeekendList(WeekendListBean paramWeekendListBean)
  {
    this.weekendList = paramWeekendListBean;
  }
  
  public void setWeekendPrice(WeekendPriceBean paramWeekendPriceBean)
  {
    this.weekendPrice = paramWeekendPriceBean;
  }
  
  public void setWeekendPriceSwitch(int paramInt)
  {
    this.weekendPriceSwitch = paramInt;
  }
  
  public class CleaningFeesBean
    implements Serializable
  {
    private boolean isEdit;
    private int value;
    
    public CleaningFeesBean() {}
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setValue(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public class HouseAreaBean
    implements Serializable
  {
    private String explain;
    private boolean isEdit;
    private String text;
    private int value;
    
    public HouseAreaBean() {}
    
    public String getExplain()
    {
      return this.explain;
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setExplain(String paramString)
    {
      this.explain = paramString;
    }
    
    public void setText(String paramString)
    {
      this.text = paramString;
    }
    
    public void setValue(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public class HouseFacilityBean
    implements Serializable
  {
    private String explain;
    private boolean isEdit;
    private String text;
    private String value;
    
    public HouseFacilityBean() {}
    
    public String getExplain()
    {
      return this.explain;
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setExplain(String paramString)
    {
      this.explain = paramString;
    }
    
    public void setText(String paramString)
    {
      this.text = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
  
  public class HouseModelBean
    implements Serializable
  {
    private String explain;
    private boolean isEdit;
    private String text;
    private String value;
    
    public HouseModelBean() {}
    
    public String getExplain()
    {
      return this.explain;
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setExplain(String paramString)
    {
      this.explain = paramString;
    }
    
    public void setText(String paramString)
    {
      this.text = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
  
  public class HouseRoomListBean
    implements Serializable
  {
    private List<HouseHaveBedListDataBean> bedList;
    private String roomFid;
    
    public HouseRoomListBean() {}
    
    public List<HouseHaveBedListDataBean> getBedList()
    {
      return this.bedList;
    }
    
    public String getRoomFid()
    {
      return this.roomFid;
    }
    
    public void setBedList(List<HouseHaveBedListDataBean> paramList)
    {
      this.bedList = paramList;
    }
    
    public void setRoomFid(String paramString)
    {
      this.roomFid = paramString;
    }
    
    public class HouseHaveBedListDataBean
      implements Serializable
    {
      private String explain;
      private boolean isEdit;
      private String text;
      private int value;
      
      public HouseHaveBedListDataBean() {}
      
      public String getExplain()
      {
        return this.explain;
      }
      
      public String getText()
      {
        return this.text;
      }
      
      public int getValue()
      {
        return this.value;
      }
      
      public boolean isEdit()
      {
        return this.isEdit;
      }
      
      public void setEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setExplain(String paramString)
      {
        this.explain = paramString;
      }
      
      public void setText(String paramString)
      {
        this.text = paramString;
      }
      
      public void setValue(int paramInt)
      {
        this.value = paramInt;
      }
    }
  }
  
  public class LeasePriceBean
    implements Serializable
  {
    private boolean isEdit;
    private int value;
    
    public LeasePriceBean() {}
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setValue(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public class SevenDiscountRateBean
    implements Serializable
  {
    private boolean isEdit;
    private Double value;
    
    public SevenDiscountRateBean() {}
    
    public Double getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setValue(Double paramDouble)
    {
      this.value = paramDouble;
    }
  }
  
  public class ThirtyDiscountRateBean
    implements Serializable
  {
    private boolean isEdit;
    private Double value;
    
    public ThirtyDiscountRateBean() {}
    
    public Double getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setValue(Double paramDouble)
    {
      this.value = paramDouble;
    }
  }
  
  public class WeekendPriceBean
    implements Serializable
  {
    private boolean isEdit;
    private int value;
    
    public WeekendPriceBean() {}
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setEdit(boolean paramBoolean)
    {
      this.isEdit = paramBoolean;
    }
    
    public void setValue(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/LandlordReleaseHousePriceBasicData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */