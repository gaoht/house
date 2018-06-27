package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class CleanDailyService
  implements Serializable
{
  private String picUrl;
  private String priceRemark;
  private String remark;
  private String serDate;
  private String serviceInfoId;
  private String serviceInfoName;
  
  public String getPicUrl()
  {
    return this.picUrl;
  }
  
  public String getPriceRemark()
  {
    return this.priceRemark;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public String getSerDate()
  {
    return this.serDate;
  }
  
  public String getServiceInfoId()
  {
    return this.serviceInfoId;
  }
  
  public String getServiceInfoName()
  {
    return this.serviceInfoName;
  }
  
  public void setPicUrl(String paramString)
  {
    this.picUrl = paramString;
  }
  
  public void setPriceRemark(String paramString)
  {
    this.priceRemark = paramString;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setSerDate(String paramString)
  {
    this.serDate = paramString;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.serviceInfoId = paramString;
  }
  
  public void setServiceInfoName(String paramString)
  {
    this.serviceInfoName = paramString;
  }
  
  public String toString()
  {
    return "CleanDailyService [picUrl=" + this.picUrl + ", serviceInfoId=" + this.serviceInfoId + ", remark=" + this.remark + ", priceRemark=" + this.priceRemark + ", serviceInfoName=" + this.serviceInfoName + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanDailyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */