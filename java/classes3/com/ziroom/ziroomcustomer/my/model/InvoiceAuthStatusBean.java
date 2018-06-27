package com.ziroom.ziroomcustomer.my.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InvoiceAuthStatusBean
  implements Parcelable
{
  public static final Parcelable.Creator<InvoiceAuthStatusBean> CREATOR = new Parcelable.Creator()
  {
    public InvoiceAuthStatusBean createFromParcel(Parcel paramAnonymousParcel)
    {
      return new InvoiceAuthStatusBean(paramAnonymousParcel);
    }
    
    public InvoiceAuthStatusBean[] newArray(int paramAnonymousInt)
    {
      return new InvoiceAuthStatusBean[paramAnonymousInt];
    }
  };
  private String accountLicense;
  private String address;
  private String applyNum;
  private String applyTime;
  private String bank;
  private String bankNum;
  private String businessLicense;
  private String companyName;
  private String id;
  private String lastModifyTime;
  private String orgCode;
  private String phone;
  private String rejectReason;
  private int status;
  private String systemId;
  private String taxIdfa;
  private String taxRegNum;
  private String uid;
  
  public InvoiceAuthStatusBean() {}
  
  protected InvoiceAuthStatusBean(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.applyNum = paramParcel.readString();
    this.companyName = paramParcel.readString();
    this.taxIdfa = paramParcel.readString();
    this.address = paramParcel.readString();
    this.phone = paramParcel.readString();
    this.bank = paramParcel.readString();
    this.bankNum = paramParcel.readString();
    this.businessLicense = paramParcel.readString();
    this.taxRegNum = paramParcel.readString();
    this.accountLicense = paramParcel.readString();
    this.orgCode = paramParcel.readString();
    this.uid = paramParcel.readString();
    this.systemId = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.rejectReason = paramParcel.readString();
    this.applyTime = paramParcel.readString();
    this.lastModifyTime = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountLicense()
  {
    return this.accountLicense;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getApplyNum()
  {
    return this.applyNum;
  }
  
  public String getApplyTime()
  {
    return this.applyTime;
  }
  
  public String getBank()
  {
    return this.bank;
  }
  
  public String getBankNum()
  {
    return this.bankNum;
  }
  
  public String getBusinessLicense()
  {
    return this.businessLicense;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getLastModifyTime()
  {
    return this.lastModifyTime;
  }
  
  public String getOrgCode()
  {
    return this.orgCode;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getRejectReason()
  {
    return this.rejectReason;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getSystemId()
  {
    return this.systemId;
  }
  
  public String getTaxIdfa()
  {
    return this.taxIdfa;
  }
  
  public String getTaxRegNum()
  {
    return this.taxRegNum;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setAccountLicense(String paramString)
  {
    this.accountLicense = paramString;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setApplyNum(String paramString)
  {
    this.applyNum = paramString;
  }
  
  public void setApplyTime(String paramString)
  {
    this.applyTime = paramString;
  }
  
  public void setBank(String paramString)
  {
    this.bank = paramString;
  }
  
  public void setBankNum(String paramString)
  {
    this.bankNum = paramString;
  }
  
  public void setBusinessLicense(String paramString)
  {
    this.businessLicense = paramString;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setLastModifyTime(String paramString)
  {
    this.lastModifyTime = paramString;
  }
  
  public void setOrgCode(String paramString)
  {
    this.orgCode = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setRejectReason(String paramString)
  {
    this.rejectReason = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setSystemId(String paramString)
  {
    this.systemId = paramString;
  }
  
  public void setTaxIdfa(String paramString)
  {
    this.taxIdfa = paramString;
  }
  
  public void setTaxRegNum(String paramString)
  {
    this.taxRegNum = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.applyNum);
    paramParcel.writeString(this.companyName);
    paramParcel.writeString(this.taxIdfa);
    paramParcel.writeString(this.address);
    paramParcel.writeString(this.phone);
    paramParcel.writeString(this.bank);
    paramParcel.writeString(this.bankNum);
    paramParcel.writeString(this.businessLicense);
    paramParcel.writeString(this.taxRegNum);
    paramParcel.writeString(this.accountLicense);
    paramParcel.writeString(this.orgCode);
    paramParcel.writeString(this.uid);
    paramParcel.writeString(this.systemId);
    paramParcel.writeInt(this.status);
    paramParcel.writeString(this.rejectReason);
    paramParcel.writeString(this.applyTime);
    paramParcel.writeString(this.lastModifyTime);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/InvoiceAuthStatusBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */