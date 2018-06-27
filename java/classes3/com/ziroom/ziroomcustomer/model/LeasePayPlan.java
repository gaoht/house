package com.ziroom.ziroomcustomer.model;

import com.ziroom.ziroomcustomer.activity.a;
import java.io.Serializable;
import java.util.List;

public class LeasePayPlan
  implements Serializable
{
  private int canPayRent;
  private String cityCode;
  private String contractCode;
  private a contractWyjPayInfo;
  private String fee = "";
  private String hasWyj;
  private int id;
  private String is_blank;
  private List<LeasePayDetail> lpdl;
  private Integer payCount = Integer.valueOf(0);
  private String payFee = "";
  private boolean payIsVisibility;
  private int payType;
  private boolean payWyjIsVisibility;
  private String penalty;
  private String penalty_num;
  private Integer periods;
  private String receivableCycle;
  private String receivableDate;
  private String status;
  private String uid;
  
  public int getCanPayRent()
  {
    return this.canPayRent;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public a getContractWyjPayInfo()
  {
    return this.contractWyjPayInfo;
  }
  
  public String getFee()
  {
    return this.fee;
  }
  
  public String getHasWyj()
  {
    return this.hasWyj;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getIs_blank()
  {
    return this.is_blank;
  }
  
  public List<LeasePayDetail> getLpdl()
  {
    return this.lpdl;
  }
  
  public Integer getPayCount()
  {
    return this.payCount;
  }
  
  public String getPayFee()
  {
    return this.payFee;
  }
  
  public int getPayType()
  {
    return this.payType;
  }
  
  public String getPenalty()
  {
    return this.penalty;
  }
  
  public String getPenalty_num()
  {
    return this.penalty_num;
  }
  
  public Integer getPeriods()
  {
    return this.periods;
  }
  
  public String getReceivableCycle()
  {
    return this.receivableCycle;
  }
  
  public String getReceivableDate()
  {
    return this.receivableDate;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public boolean isPayIsVisibility()
  {
    return this.payIsVisibility;
  }
  
  public boolean isPayWyjIsVisibility()
  {
    return this.payWyjIsVisibility;
  }
  
  public void setCanPayRent(int paramInt)
  {
    this.canPayRent = paramInt;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setContractWyjPayInfo(a parama)
  {
    this.contractWyjPayInfo = parama;
  }
  
  public void setFee(String paramString)
  {
    this.fee = paramString;
  }
  
  public void setHasWyj(String paramString)
  {
    this.hasWyj = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIs_blank(String paramString)
  {
    this.is_blank = paramString;
  }
  
  public void setLpdl(List<LeasePayDetail> paramList)
  {
    this.lpdl = paramList;
  }
  
  public void setPayCount(Integer paramInteger)
  {
    this.payCount = paramInteger;
  }
  
  public void setPayFee(String paramString)
  {
    this.payFee = paramString;
  }
  
  public void setPayIsVisibility(boolean paramBoolean)
  {
    this.payIsVisibility = paramBoolean;
  }
  
  public void setPayType(int paramInt)
  {
    this.payType = paramInt;
  }
  
  public void setPayWyjIsVisibility(boolean paramBoolean)
  {
    this.payWyjIsVisibility = paramBoolean;
  }
  
  public void setPenalty(String paramString)
  {
    this.penalty = paramString;
  }
  
  public void setPenalty_num(String paramString)
  {
    this.penalty_num = paramString;
  }
  
  public void setPeriods(Integer paramInteger)
  {
    this.periods = paramInteger;
  }
  
  public void setReceivableCycle(String paramString)
  {
    this.receivableCycle = paramString;
  }
  
  public void setReceivableDate(String paramString)
  {
    this.receivableDate = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public String toString()
  {
    return "LeasePayPlan [id=" + this.id + ", uid=" + this.uid + ", contractCode=" + this.contractCode + ", periods=" + this.periods + ", payCount=" + this.payCount + ", receivableDate=" + this.receivableDate + ", receivableCycle=" + this.receivableCycle + ", fee=" + this.fee + ", payFee=" + this.payFee + ", status=" + this.status + ", penalty=" + this.penalty + ", penalty_num=" + this.penalty_num + ", is_blank=" + this.is_blank + ", lpdl=" + this.lpdl + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/LeasePayPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */