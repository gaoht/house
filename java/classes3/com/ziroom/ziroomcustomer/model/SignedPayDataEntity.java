package com.ziroom.ziroomcustomer.model;

import com.ziroom.ziroomcustomer.signed.a.a;
import com.ziroom.ziroomcustomer.signed.m;
import java.io.Serializable;
import java.util.List;

public class SignedPayDataEntity
  implements Serializable
{
  private String activityNote;
  private a activityPayModel;
  private float commission;
  private String countMoney;
  private String couponView;
  private float deposit;
  private float discountCommission;
  private String feeNote;
  private float housePrice;
  private int isPreDeposit;
  private String isShowCoupon;
  private int isZWhite;
  private m loanPayInfo;
  private int oldIsDeposit;
  private float payment;
  private String paymentUnit;
  private String priceUnit;
  private List<String> promptTags;
  private String renewContractCode;
  private String rentDescribe;
  private String rentMoneyCount;
  private String rentMoneyTab;
  private String rentPeriodDes;
  private float reserveDeposit;
  
  public SignedPayDataEntity() {}
  
  public SignedPayDataEntity(float paramFloat1, String paramString1, float paramFloat2, String paramString2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, float paramFloat5, String paramString3, int paramInt3, m paramm, String paramString4, List<String> paramList, a parama, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.housePrice = paramFloat1;
    this.priceUnit = paramString1;
    this.payment = paramFloat2;
    this.paymentUnit = paramString2;
    this.deposit = paramFloat3;
    this.commission = paramFloat4;
    this.isPreDeposit = paramInt1;
    this.oldIsDeposit = paramInt2;
    this.discountCommission = paramFloat5;
    this.feeNote = paramString3;
    this.isZWhite = paramInt3;
    this.loanPayInfo = paramm;
    this.renewContractCode = paramString4;
    this.promptTags = paramList;
    this.activityPayModel = parama;
    this.rentDescribe = paramString5;
    this.rentPeriodDes = paramString6;
    this.activityNote = paramString7;
    this.rentMoneyCount = paramString8;
    this.countMoney = paramString9;
    this.couponView = paramString10;
    this.isShowCoupon = paramString11;
  }
  
  public String getActivityNote()
  {
    return this.activityNote;
  }
  
  public a getActivityPayModel()
  {
    return this.activityPayModel;
  }
  
  public float getCommission()
  {
    return this.commission;
  }
  
  public String getCountMoney()
  {
    return this.countMoney;
  }
  
  public String getCouponView()
  {
    return this.couponView;
  }
  
  public float getDeposit()
  {
    return this.deposit;
  }
  
  public float getDiscountCommission()
  {
    return this.discountCommission;
  }
  
  public String getFeeNote()
  {
    return this.feeNote;
  }
  
  public float getHousePrice()
  {
    return this.housePrice;
  }
  
  public int getIsPreDeposit()
  {
    return this.isPreDeposit;
  }
  
  public String getIsShowCoupon()
  {
    return this.isShowCoupon;
  }
  
  public int getIsZWhite()
  {
    return this.isZWhite;
  }
  
  public m getLoanPayInfo()
  {
    return this.loanPayInfo;
  }
  
  public int getOldIsDeposit()
  {
    return this.oldIsDeposit;
  }
  
  public float getPayment()
  {
    return this.payment;
  }
  
  public String getPaymentUnit()
  {
    return this.paymentUnit;
  }
  
  public String getPriceUnit()
  {
    return this.priceUnit;
  }
  
  public List<String> getPromptTags()
  {
    return this.promptTags;
  }
  
  public String getRenewContractCode()
  {
    return this.renewContractCode;
  }
  
  public String getRentDescribe()
  {
    return this.rentDescribe;
  }
  
  public String getRentMoneyCount()
  {
    return this.rentMoneyCount;
  }
  
  public String getRentMoneyTab()
  {
    return this.rentMoneyTab;
  }
  
  public String getRentPeriodDes()
  {
    return this.rentPeriodDes;
  }
  
  public float getReserveDeposit()
  {
    return this.reserveDeposit;
  }
  
  public void setActivityNote(String paramString)
  {
    this.activityNote = paramString;
  }
  
  public void setActivityPayModel(a parama)
  {
    this.activityPayModel = parama;
  }
  
  public void setCommission(float paramFloat)
  {
    this.commission = paramFloat;
  }
  
  public void setCountMoney(String paramString)
  {
    this.countMoney = paramString;
  }
  
  public void setCouponView(String paramString)
  {
    this.couponView = paramString;
  }
  
  public void setDeposit(float paramFloat)
  {
    this.deposit = paramFloat;
  }
  
  public void setDiscountCommission(float paramFloat)
  {
    this.discountCommission = paramFloat;
  }
  
  public void setFeeNote(String paramString)
  {
    this.feeNote = paramString;
  }
  
  public void setHousePrice(float paramFloat)
  {
    this.housePrice = paramFloat;
  }
  
  public void setIsPreDeposit(int paramInt)
  {
    this.isPreDeposit = paramInt;
  }
  
  public void setIsShowCoupon(String paramString)
  {
    this.isShowCoupon = paramString;
  }
  
  public void setIsZWhite(int paramInt)
  {
    this.isZWhite = paramInt;
  }
  
  public void setLoanPayInfo(m paramm)
  {
    this.loanPayInfo = paramm;
  }
  
  public void setOldIsDeposit(int paramInt)
  {
    this.oldIsDeposit = paramInt;
  }
  
  public void setPayment(float paramFloat)
  {
    this.payment = paramFloat;
  }
  
  public void setPaymentUnit(String paramString)
  {
    this.paymentUnit = paramString;
  }
  
  public void setPriceUnit(String paramString)
  {
    this.priceUnit = paramString;
  }
  
  public void setPromptTags(List<String> paramList)
  {
    this.promptTags = paramList;
  }
  
  public void setRenewContractCode(String paramString)
  {
    this.renewContractCode = paramString;
  }
  
  public void setRentDescribe(String paramString)
  {
    this.rentDescribe = paramString;
  }
  
  public void setRentMoneyCount(String paramString)
  {
    this.rentMoneyCount = paramString;
  }
  
  public void setRentMoneyTab(String paramString)
  {
    this.rentMoneyTab = paramString;
  }
  
  public void setRentPeriodDes(String paramString)
  {
    this.rentPeriodDes = paramString;
  }
  
  public void setReserveDeposit(float paramFloat)
  {
    this.reserveDeposit = paramFloat;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SignedPayDataEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */