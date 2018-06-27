package com.ziroom.ziroomcustomer.sublet.model;

import java.util.List;

public class SubletReservationDetail
{
  public DataBean data;
  public int error_code;
  public String error_message;
  public String status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public int getError_code()
  {
    return this.error_code;
  }
  
  public String getError_message()
  {
    return this.error_message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setError_code(int paramInt)
  {
    this.error_code = paramInt;
  }
  
  public void setError_message(String paramString)
  {
    this.error_message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    public List<BtnBean> buttons;
    public String canAdmittedTime;
    public String contractCode;
    public List<FlowBean> flowList;
    public String houseCode;
    public String houseId;
    public HouseInfoBean houseInfo;
    public String houseType;
    public int isShort;
    public String keeperPhone;
    public String remindDesc;
    public String reserveCode;
    public String reserveContractUrl;
    public int reserveDeposit;
    public String reserveDepositStr;
    public int reserveStatus;
    public String reserveStatusStr;
    public int reserveType;
    public String reserveUserCertNum;
    public String reserveUserName;
    public String surrenderContractUrl;
    
    public String getCanAdmittedTime()
    {
      return this.canAdmittedTime;
    }
    
    public String getContractCode()
    {
      return this.contractCode;
    }
    
    public String getHouseCode()
    {
      return this.houseCode;
    }
    
    public String getHouseId()
    {
      return this.houseId;
    }
    
    public HouseInfoBean getHouseInfo()
    {
      return this.houseInfo;
    }
    
    public String getHouseType()
    {
      return this.houseType;
    }
    
    public int getIsShort()
    {
      return this.isShort;
    }
    
    public String getKeeperPhone()
    {
      return this.keeperPhone;
    }
    
    public String getRemindDesc()
    {
      return this.remindDesc;
    }
    
    public String getReserveCode()
    {
      return this.reserveCode;
    }
    
    public String getReserveContractUrl()
    {
      return this.reserveContractUrl;
    }
    
    public int getReserveDeposit()
    {
      return this.reserveDeposit;
    }
    
    public String getReserveDepositStr()
    {
      return this.reserveDepositStr;
    }
    
    public int getReserveStatus()
    {
      return this.reserveStatus;
    }
    
    public String getReserveStatusStr()
    {
      return this.reserveStatusStr;
    }
    
    public String getReserveUserCertNum()
    {
      return this.reserveUserCertNum;
    }
    
    public String getReserveUserName()
    {
      return this.reserveUserName;
    }
    
    public String getSurrenderContractUrl()
    {
      return this.surrenderContractUrl;
    }
    
    public void setCanAdmittedTime(String paramString)
    {
      this.canAdmittedTime = paramString;
    }
    
    public void setContractCode(String paramString)
    {
      this.contractCode = paramString;
    }
    
    public void setHouseCode(String paramString)
    {
      this.houseCode = paramString;
    }
    
    public void setHouseId(String paramString)
    {
      this.houseId = paramString;
    }
    
    public void setHouseInfo(HouseInfoBean paramHouseInfoBean)
    {
      this.houseInfo = paramHouseInfoBean;
    }
    
    public void setHouseType(String paramString)
    {
      this.houseType = paramString;
    }
    
    public void setIsShort(int paramInt)
    {
      this.isShort = paramInt;
    }
    
    public void setKeeperPhone(String paramString)
    {
      this.keeperPhone = paramString;
    }
    
    public void setRemindDesc(String paramString)
    {
      this.remindDesc = paramString;
    }
    
    public void setReserveCode(String paramString)
    {
      this.reserveCode = paramString;
    }
    
    public void setReserveContractUrl(String paramString)
    {
      this.reserveContractUrl = paramString;
    }
    
    public void setReserveDeposit(int paramInt)
    {
      this.reserveDeposit = paramInt;
    }
    
    public void setReserveDepositStr(String paramString)
    {
      this.reserveDepositStr = paramString;
    }
    
    public void setReserveStatus(int paramInt)
    {
      this.reserveStatus = paramInt;
    }
    
    public void setReserveStatusStr(String paramString)
    {
      this.reserveStatusStr = paramString;
    }
    
    public void setReserveUserCertNum(String paramString)
    {
      this.reserveUserCertNum = paramString;
    }
    
    public void setReserveUserName(String paramString)
    {
      this.reserveUserName = paramString;
    }
    
    public void setSurrenderContractUrl(String paramString)
    {
      this.surrenderContractUrl = paramString;
    }
    
    public static class BtnBean
    {
      public String promptText;
      public String promptTitle;
      public String title;
      public String type;
    }
    
    public static class FlowBean
    {
      public String activeType;
      public String buttonTitle;
      public String buttonValue;
      public String contents;
      public int isLight;
      public String title;
      public String type;
    }
    
    public static class HouseInfoBean
    {
      public String houseAddress;
      public String houseArea;
      public String housePrice;
      public String houseTypeStr;
      public String picUrl;
      public String priceUnit;
      
      public String getHouseAddress()
      {
        return this.houseAddress;
      }
      
      public String getHouseArea()
      {
        return this.houseArea;
      }
      
      public String getHousePrice()
      {
        return this.housePrice;
      }
      
      public String getHouseTypeStr()
      {
        return this.houseTypeStr;
      }
      
      public String getPicUrl()
      {
        return this.picUrl;
      }
      
      public String getPriceUnit()
      {
        return this.priceUnit;
      }
      
      public void setHouseAddress(String paramString)
      {
        this.houseAddress = paramString;
      }
      
      public void setHouseArea(String paramString)
      {
        this.houseArea = paramString;
      }
      
      public void setHousePrice(String paramString)
      {
        this.housePrice = paramString;
      }
      
      public void setHouseTypeStr(String paramString)
      {
        this.houseTypeStr = paramString;
      }
      
      public void setPicUrl(String paramString)
      {
        this.picUrl = paramString;
      }
      
      public void setPriceUnit(String paramString)
      {
        this.priceUnit = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/model/SubletReservationDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */