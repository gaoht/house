package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class LeasePayDetail
  implements Serializable
{
  private String address;
  private String contractCode;
  private float fee;
  private int id;
  private int payCount;
  private String payDate;
  private List<payDetailEntity> payDetail;
  private float payFee;
  private String payMoney;
  private Integer periods;
  private String uid;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public float getFee()
  {
    return this.fee;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getPayCount()
  {
    return this.payCount;
  }
  
  public String getPayDate()
  {
    return this.payDate;
  }
  
  public List<payDetailEntity> getPayDetail()
  {
    return this.payDetail;
  }
  
  public float getPayFee()
  {
    return this.payFee;
  }
  
  public String getPayMoney()
  {
    return this.payMoney;
  }
  
  public Integer getPeriods()
  {
    return this.periods;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setFee(float paramFloat)
  {
    this.fee = paramFloat;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setPayCount(int paramInt)
  {
    this.payCount = paramInt;
  }
  
  public void setPayDate(String paramString)
  {
    this.payDate = paramString;
  }
  
  public void setPayDetail(List<payDetailEntity> paramList)
  {
    this.payDetail = paramList;
  }
  
  public void setPayFee(float paramFloat)
  {
    this.payFee = paramFloat;
  }
  
  public void setPayMoney(String paramString)
  {
    this.payMoney = paramString;
  }
  
  public void setPeriods(Integer paramInteger)
  {
    this.periods = paramInteger;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/LeasePayDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */