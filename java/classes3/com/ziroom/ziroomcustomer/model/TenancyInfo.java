package com.ziroom.ziroomcustomer.model;

import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import java.io.Serializable;
import java.util.List;

public class TenancyInfo
  implements Serializable
{
  private e additionalLoad;
  private int isBlank;
  private int isShort;
  private String isZWhite;
  private List<Integer> payments;
  private b paymentsTags;
  private String price;
  private String priceUnit;
  private int shorRentMaxDays;
  private int shortRentMinDays;
  private String signDate;
  private String stopDate;
  private String tenancyChoice;
  private String tenancyType;
  private e zWhiteModel;
  
  public TenancyInfo() {}
  
  public TenancyInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, List<Integer> paramList, int paramInt2, String paramString6, b paramb, e parame, int paramInt3, int paramInt4, String paramString7)
  {
    this.signDate = paramString1;
    this.stopDate = paramString2;
    this.price = paramString3;
    this.priceUnit = paramString4;
    this.tenancyType = paramString5;
    this.isShort = paramInt1;
    this.payments = paramList;
    this.isBlank = paramInt2;
    this.isZWhite = paramString6;
    this.paymentsTags = paramb;
    this.zWhiteModel = parame;
    this.shorRentMaxDays = paramInt3;
    this.shortRentMinDays = paramInt4;
    this.tenancyChoice = paramString7;
  }
  
  public e getAdditionalLoad()
  {
    return this.additionalLoad;
  }
  
  public int getIsBlank()
  {
    return this.isBlank;
  }
  
  public int getIsShort()
  {
    return this.isShort;
  }
  
  public String getIsZWhite()
  {
    return this.isZWhite;
  }
  
  public List<Integer> getPayments()
  {
    return this.payments;
  }
  
  public b getPaymentsTags()
  {
    return this.paymentsTags;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getPriceUnit()
  {
    return this.priceUnit;
  }
  
  public int getShorRentMaxDays()
  {
    return this.shorRentMaxDays;
  }
  
  public int getShortRentMinDays()
  {
    return this.shortRentMinDays;
  }
  
  public String getSignDate()
  {
    return this.signDate;
  }
  
  public String getStopDate()
  {
    return this.stopDate;
  }
  
  public String getTenancyChoice()
  {
    return this.tenancyChoice;
  }
  
  public String getTenancyType()
  {
    return this.tenancyType;
  }
  
  public e getzWhiteModel()
  {
    return this.zWhiteModel;
  }
  
  public void setAdditionalLoad(e parame)
  {
    this.additionalLoad = parame;
  }
  
  public void setIsBlank(int paramInt)
  {
    this.isBlank = paramInt;
  }
  
  public void setIsShort(int paramInt)
  {
    this.isShort = paramInt;
  }
  
  public void setIsZWhite(String paramString)
  {
    this.isZWhite = paramString;
  }
  
  public void setPayments(List<Integer> paramList)
  {
    this.payments = paramList;
  }
  
  public void setPaymentsTags(b paramb)
  {
    this.paymentsTags = paramb;
  }
  
  public void setPrice(String paramString)
  {
    this.price = paramString;
  }
  
  public void setPriceUnit(String paramString)
  {
    this.priceUnit = paramString;
  }
  
  public void setShorRentMaxDays(int paramInt)
  {
    this.shorRentMaxDays = paramInt;
  }
  
  public void setShortRentMinDays(int paramInt)
  {
    this.shortRentMinDays = paramInt;
  }
  
  public void setSignDate(String paramString)
  {
    this.signDate = paramString;
  }
  
  public void setStopDate(String paramString)
  {
    this.stopDate = paramString;
  }
  
  public void setTenancyChoice(String paramString)
  {
    this.tenancyChoice = paramString;
  }
  
  public void setTenancyType(String paramString)
  {
    this.tenancyType = paramString;
  }
  
  public void setzWhiteModel(e parame)
  {
    this.zWhiteModel = parame;
  }
  
  public String toString()
  {
    return "TenancyInfo [signDate=" + this.signDate + ", stopDate=" + this.stopDate + ", price=" + this.price + ", priceUnit=" + this.priceUnit + ", tenancyType=" + this.tenancyType + ", isShort=" + this.isShort + ", payments=" + this.payments + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/TenancyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */