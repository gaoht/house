package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class MapMoveHouse
  implements Serializable
{
  private String picUrl;
  private String priceRemark;
  private List<String> proDescs;
  private String remark;
  private String serviceInfoId;
  private String serviceInfoName;
  private String slogan;
  private int suggest;
  
  public String getPicUrl()
  {
    return this.picUrl;
  }
  
  public String getPriceRemark()
  {
    return this.priceRemark;
  }
  
  public List<String> getProDescs()
  {
    return this.proDescs;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public String getServiceInfoId()
  {
    return this.serviceInfoId;
  }
  
  public String getServiceInfoName()
  {
    return this.serviceInfoName;
  }
  
  public String getSlogan()
  {
    return this.slogan;
  }
  
  public int getSuggest()
  {
    return this.suggest;
  }
  
  public void setPicUrl(String paramString)
  {
    this.picUrl = paramString;
  }
  
  public void setPriceRemark(String paramString)
  {
    this.priceRemark = paramString;
  }
  
  public void setProDescs(List<String> paramList)
  {
    this.proDescs = paramList;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.serviceInfoId = paramString;
  }
  
  public void setServiceInfoName(String paramString)
  {
    this.serviceInfoName = paramString;
  }
  
  public void setSlogan(String paramString)
  {
    this.slogan = paramString;
  }
  
  public void setSuggest(int paramInt)
  {
    this.suggest = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MapMoveHouse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */