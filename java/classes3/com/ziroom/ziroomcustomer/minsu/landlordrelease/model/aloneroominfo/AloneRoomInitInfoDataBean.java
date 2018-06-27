package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo;

import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean;
import java.io.Serializable;
import java.util.List;

public class AloneRoomInitInfoDataBean
  implements Serializable
{
  private AloneRoomBedTypeListBean bedTypeList;
  private List<AloneRoomBedTypeMsgListBean> bedTypeMsgList;
  private AloneRoomCleaningFeesBean cleaningFees;
  private int cleaningFeesPer;
  private int fullDayRateSwitch;
  private AloneRoomAreaBean houseArea;
  private AloneRoomIsToiletListBean isToiletList;
  private AloneRoomLeasePriceBean leasePrice;
  private AloneRoomLimitPersonListBean limitPersonList;
  private int maxBedNumLimit;
  private int maxPrice;
  private int minPrice;
  private AloneRoomNameBean roomName;
  private AloneRoomSevenDiscountRateBean sevenDiscountRate;
  private AloneRoomThirtyDiscountRateBean thirtyDiscountRate;
  private WeekendListBean weekendList;
  private AloneRoomWeekendPriceBean weekendPrice;
  private int weekendPriceSwitch;
  
  public AloneRoomBedTypeListBean getBedTypeList()
  {
    return this.bedTypeList;
  }
  
  public List<AloneRoomBedTypeMsgListBean> getBedTypeMsgList()
  {
    return this.bedTypeMsgList;
  }
  
  public AloneRoomCleaningFeesBean getCleaningFees()
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
  
  public AloneRoomAreaBean getHouseArea()
  {
    return this.houseArea;
  }
  
  public AloneRoomIsToiletListBean getIsToiletList()
  {
    return this.isToiletList;
  }
  
  public AloneRoomLeasePriceBean getLeasePrice()
  {
    return this.leasePrice;
  }
  
  public AloneRoomLimitPersonListBean getLimitPersonList()
  {
    return this.limitPersonList;
  }
  
  public int getMaxBedNumLimit()
  {
    return this.maxBedNumLimit;
  }
  
  public int getMaxPrice()
  {
    return this.maxPrice;
  }
  
  public int getMinPrice()
  {
    return this.minPrice;
  }
  
  public AloneRoomNameBean getRoomName()
  {
    return this.roomName;
  }
  
  public AloneRoomSevenDiscountRateBean getSevenDiscountRate()
  {
    return this.sevenDiscountRate;
  }
  
  public AloneRoomThirtyDiscountRateBean getThirtyDiscountRate()
  {
    return this.thirtyDiscountRate;
  }
  
  public WeekendListBean getWeekendList()
  {
    return this.weekendList;
  }
  
  public AloneRoomWeekendPriceBean getWeekendPrice()
  {
    return this.weekendPrice;
  }
  
  public int getWeekendPriceSwitch()
  {
    return this.weekendPriceSwitch;
  }
  
  public void setBedTypeList(AloneRoomBedTypeListBean paramAloneRoomBedTypeListBean)
  {
    this.bedTypeList = paramAloneRoomBedTypeListBean;
  }
  
  public void setBedTypeMsgList(List<AloneRoomBedTypeMsgListBean> paramList)
  {
    this.bedTypeMsgList = paramList;
  }
  
  public void setCleaningFees(AloneRoomCleaningFeesBean paramAloneRoomCleaningFeesBean)
  {
    this.cleaningFees = paramAloneRoomCleaningFeesBean;
  }
  
  public void setCleaningFeesPer(int paramInt)
  {
    this.cleaningFeesPer = paramInt;
  }
  
  public void setFullDayRateSwitch(int paramInt)
  {
    this.fullDayRateSwitch = paramInt;
  }
  
  public void setHouseArea(AloneRoomAreaBean paramAloneRoomAreaBean)
  {
    this.houseArea = paramAloneRoomAreaBean;
  }
  
  public void setIsToiletList(AloneRoomIsToiletListBean paramAloneRoomIsToiletListBean)
  {
    this.isToiletList = paramAloneRoomIsToiletListBean;
  }
  
  public void setLeasePrice(AloneRoomLeasePriceBean paramAloneRoomLeasePriceBean)
  {
    this.leasePrice = paramAloneRoomLeasePriceBean;
  }
  
  public void setLimitPersonList(AloneRoomLimitPersonListBean paramAloneRoomLimitPersonListBean)
  {
    this.limitPersonList = paramAloneRoomLimitPersonListBean;
  }
  
  public void setMaxBedNumLimit(int paramInt)
  {
    this.maxBedNumLimit = paramInt;
  }
  
  public void setMaxPrice(int paramInt)
  {
    this.maxPrice = paramInt;
  }
  
  public void setMinPrice(int paramInt)
  {
    this.minPrice = paramInt;
  }
  
  public void setRoomName(AloneRoomNameBean paramAloneRoomNameBean)
  {
    this.roomName = paramAloneRoomNameBean;
  }
  
  public void setSevenDiscountRate(AloneRoomSevenDiscountRateBean paramAloneRoomSevenDiscountRateBean)
  {
    this.sevenDiscountRate = paramAloneRoomSevenDiscountRateBean;
  }
  
  public void setThirtyDiscountRate(AloneRoomThirtyDiscountRateBean paramAloneRoomThirtyDiscountRateBean)
  {
    this.thirtyDiscountRate = paramAloneRoomThirtyDiscountRateBean;
  }
  
  public void setWeekendList(WeekendListBean paramWeekendListBean)
  {
    this.weekendList = paramWeekendListBean;
  }
  
  public void setWeekendPrice(AloneRoomWeekendPriceBean paramAloneRoomWeekendPriceBean)
  {
    this.weekendPrice = paramAloneRoomWeekendPriceBean;
  }
  
  public void setWeekendPriceSwitch(int paramInt)
  {
    this.weekendPriceSwitch = paramInt;
  }
  
  public class AloneRoomCleaningFeesBean
    implements Serializable
  {
    private String auditMsg;
    private boolean isEdit;
    private int value;
    
    public AloneRoomCleaningFeesBean() {}
    
    public String getAuditMsg()
    {
      return this.auditMsg;
    }
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setAuditMsg(String paramString)
    {
      this.auditMsg = paramString;
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
  
  public class AloneRoomLeasePriceBean
    implements Serializable
  {
    private String auditMsg;
    private boolean isEdit;
    private int value;
    
    public AloneRoomLeasePriceBean() {}
    
    public String getAuditMsg()
    {
      return this.auditMsg;
    }
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setAuditMsg(String paramString)
    {
      this.auditMsg = paramString;
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
  
  public class AloneRoomSevenDiscountRateBean
    implements Serializable
  {
    private String auditMsg;
    private boolean isEdit;
    private int value;
    
    public AloneRoomSevenDiscountRateBean() {}
    
    public String getAuditMsg()
    {
      return this.auditMsg;
    }
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setAuditMsg(String paramString)
    {
      this.auditMsg = paramString;
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
  
  public class AloneRoomThirtyDiscountRateBean
    implements Serializable
  {
    private String auditMsg;
    private boolean isEdit;
    private int value;
    
    public AloneRoomThirtyDiscountRateBean() {}
    
    public String getAuditMsg()
    {
      return this.auditMsg;
    }
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setAuditMsg(String paramString)
    {
      this.auditMsg = paramString;
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
  
  public class AloneRoomWeekendPriceBean
    implements Serializable
  {
    private String auditMsg;
    private boolean isEdit;
    private int value;
    
    public AloneRoomWeekendPriceBean() {}
    
    public String getAuditMsg()
    {
      return this.auditMsg;
    }
    
    public int getValue()
    {
      return this.value;
    }
    
    public boolean isEdit()
    {
      return this.isEdit;
    }
    
    public void setAuditMsg(String paramString)
    {
      this.auditMsg = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/aloneroominfo/AloneRoomInitInfoDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */