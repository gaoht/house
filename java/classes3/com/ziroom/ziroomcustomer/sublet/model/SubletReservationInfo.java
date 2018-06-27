package com.ziroom.ziroomcustomer.sublet.model;

public class SubletReservationInfo
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
    public String canSigndate;
    public String certNum;
    public int certType;
    public String descr;
    public String houseAddress;
    public String houseCode;
    public String houseId;
    public String houseSourceCode;
    public String houseType;
    public String rentPromptMsg;
    public String reserveCode;
    public int reserveType;
    public String subtenantBackRentDate;
    public String subtenantCertNum;
    public int subtenantCertType;
    public String subtenantPromptMsg;
    public String subtenantUid;
    public String subtenantUserName;
    public String subtenantUserPhone;
    public String uid;
    public String userName;
    public String userPhone;
    
    public String getCertNum()
    {
      return this.certNum;
    }
    
    public int getCertType()
    {
      return this.certType;
    }
    
    public String getDescr()
    {
      return this.descr;
    }
    
    public String getHouseAddress()
    {
      return this.houseAddress;
    }
    
    public String getHouseCode()
    {
      return this.houseCode;
    }
    
    public String getHouseId()
    {
      return this.houseId;
    }
    
    public String getHouseType()
    {
      return this.houseType;
    }
    
    public String getRentPromptMsg()
    {
      return this.rentPromptMsg;
    }
    
    public String getReserveCode()
    {
      return this.reserveCode;
    }
    
    public int getReserveType()
    {
      return this.reserveType;
    }
    
    public String getSubtenantBackRentDate()
    {
      return this.subtenantBackRentDate;
    }
    
    public String getSubtenantCertNum()
    {
      return this.subtenantCertNum;
    }
    
    public int getSubtenantCertType()
    {
      return this.subtenantCertType;
    }
    
    public String getSubtenantPromptMsg()
    {
      return this.subtenantPromptMsg;
    }
    
    public String getSubtenantUid()
    {
      return this.subtenantUid;
    }
    
    public String getSubtenantUserName()
    {
      return this.subtenantUserName;
    }
    
    public String getSubtenantUserPhone()
    {
      return this.subtenantUserPhone;
    }
    
    public String getUid()
    {
      return this.uid;
    }
    
    public String getUserName()
    {
      return this.userName;
    }
    
    public String getUserPhone()
    {
      return this.userPhone;
    }
    
    public void setCertNum(String paramString)
    {
      this.certNum = paramString;
    }
    
    public void setCertType(int paramInt)
    {
      this.certType = paramInt;
    }
    
    public void setDescr(String paramString)
    {
      this.descr = paramString;
    }
    
    public void setHouseAddress(String paramString)
    {
      this.houseAddress = paramString;
    }
    
    public void setHouseCode(String paramString)
    {
      this.houseCode = paramString;
    }
    
    public void setHouseId(String paramString)
    {
      this.houseId = paramString;
    }
    
    public void setHouseType(String paramString)
    {
      this.houseType = paramString;
    }
    
    public void setRentPromptMsg(String paramString)
    {
      this.rentPromptMsg = paramString;
    }
    
    public void setReserveCode(String paramString)
    {
      this.reserveCode = paramString;
    }
    
    public void setReserveType(int paramInt)
    {
      this.reserveType = paramInt;
    }
    
    public void setSubtenantBackRentDate(String paramString)
    {
      this.subtenantBackRentDate = paramString;
    }
    
    public void setSubtenantCertNum(String paramString)
    {
      this.subtenantCertNum = paramString;
    }
    
    public void setSubtenantCertType(int paramInt)
    {
      this.subtenantCertType = paramInt;
    }
    
    public void setSubtenantPromptMsg(String paramString)
    {
      this.subtenantPromptMsg = paramString;
    }
    
    public void setSubtenantUid(String paramString)
    {
      this.subtenantUid = paramString;
    }
    
    public void setSubtenantUserName(String paramString)
    {
      this.subtenantUserName = paramString;
    }
    
    public void setSubtenantUserPhone(String paramString)
    {
      this.subtenantUserPhone = paramString;
    }
    
    public void setUid(String paramString)
    {
      this.uid = paramString;
    }
    
    public void setUserName(String paramString)
    {
      this.userName = paramString;
    }
    
    public void setUserPhone(String paramString)
    {
      this.userPhone = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */