package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.ziroom.ziroomcustomer.ziroomstation.b.a;
import java.util.List;

public class StationBaseData
  extends a
{
  private DataEntity data;
  
  public DataEntity getData()
  {
    return this.data;
  }
  
  public void setData(DataEntity paramDataEntity)
  {
    this.data = paramDataEntity;
  }
  
  public String toString()
  {
    return "StationBaseData{data=" + this.data + '}';
  }
  
  public static class DataEntity
  {
    private List<String> bankName;
    private List<String> credentialType;
    private List<String> refundReason;
    
    public List<String> getBankName()
    {
      return this.bankName;
    }
    
    public List<String> getCredentialType()
    {
      return this.credentialType;
    }
    
    public List<String> getRefundReason()
    {
      return this.refundReason;
    }
    
    public void setBankName(List<String> paramList)
    {
      this.bankName = paramList;
    }
    
    public void setCredentialType(List<String> paramList)
    {
      this.credentialType = paramList;
    }
    
    public void setRefundReason(List<String> paramList)
    {
      this.refundReason = paramList;
    }
    
    public String toString()
    {
      return "DataEntity{credentialType=" + this.credentialType + ", bankName=" + this.bankName + ", refundReason=" + this.refundReason + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationBaseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */