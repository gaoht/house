package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuContractListModel
  extends b
{
  public List<DataBean> data;
  
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
    public String contactTel;
    public String contractCode;
    public String contractId;
    public long endDate;
    public String endDateStr;
    public int payType;
    public String projectImg;
    public String projectName;
    public String roomCode;
    public String roomPrice;
    public String roomPriceStr;
    public long startDate;
    public String startDateStr;
    public String status;
    public String uid;
    
    public String getContactTel()
    {
      return this.contactTel;
    }
    
    public String getContractCode()
    {
      return this.contractCode;
    }
    
    public String getContractId()
    {
      return this.contractId;
    }
    
    public long getEndDate()
    {
      return this.endDate;
    }
    
    public String getEndDateStr()
    {
      return this.endDateStr;
    }
    
    public int getPayType()
    {
      return this.payType;
    }
    
    public String getProjectImg()
    {
      return this.projectImg;
    }
    
    public String getProjectName()
    {
      return this.projectName;
    }
    
    public String getRoomCode()
    {
      return this.roomCode;
    }
    
    public String getRoomPrice()
    {
      return this.roomPrice;
    }
    
    public String getRoomPriceStr()
    {
      return this.roomPriceStr;
    }
    
    public long getStartDate()
    {
      return this.startDate;
    }
    
    public String getStartDateStr()
    {
      return this.startDateStr;
    }
    
    public String getStatus()
    {
      return this.status;
    }
    
    public String getUid()
    {
      return this.uid;
    }
    
    public void setContactTel(String paramString)
    {
      this.contactTel = paramString;
    }
    
    public void setContractCode(String paramString)
    {
      this.contractCode = paramString;
    }
    
    public void setContractId(String paramString)
    {
      this.contractId = paramString;
    }
    
    public void setEndDate(long paramLong)
    {
      this.endDate = paramLong;
    }
    
    public void setEndDateStr(String paramString)
    {
      this.endDateStr = paramString;
    }
    
    public void setPayType(int paramInt)
    {
      this.payType = paramInt;
    }
    
    public void setProjectImg(String paramString)
    {
      this.projectImg = paramString;
    }
    
    public void setProjectName(String paramString)
    {
      this.projectName = paramString;
    }
    
    public void setRoomCode(String paramString)
    {
      this.roomCode = paramString;
    }
    
    public void setRoomPrice(String paramString)
    {
      this.roomPrice = paramString;
    }
    
    public void setRoomPriceStr(String paramString)
    {
      this.roomPriceStr = paramString;
    }
    
    public void setStartDate(long paramLong)
    {
      this.startDate = paramLong;
    }
    
    public void setStartDateStr(String paramString)
    {
      this.startDateStr = paramString;
    }
    
    public void setStatus(String paramString)
    {
      this.status = paramString;
    }
    
    public void setUid(String paramString)
    {
      this.uid = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuContractListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */