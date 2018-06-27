package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuSignBillRent
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignBillRent> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignBillRent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignBillRent(paramAnonymousParcel);
    }
    
    public ZryuSignBillRent[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignBillRent[paramAnonymousInt];
    }
  };
  private String billCycle;
  private Integer billStatus;
  private String billStatusTxt;
  private String operation;
  private Integer operationCode;
  private String paymentDate;
  private Integer period;
  private String receivableAmount;
  private String receivedAmount;
  
  public ZryuSignBillRent() {}
  
  protected ZryuSignBillRent(Parcel paramParcel)
  {
    this.period = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.billCycle = paramParcel.readString();
    this.paymentDate = paramParcel.readString();
    this.receivableAmount = paramParcel.readString();
    this.receivedAmount = paramParcel.readString();
    this.billStatusTxt = paramParcel.readString();
    this.operationCode = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.operation = paramParcel.readString();
    this.billStatus = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBillCycle()
  {
    return this.billCycle;
  }
  
  public Integer getBillStatus()
  {
    return this.billStatus;
  }
  
  public String getBillStatusTxt()
  {
    return this.billStatusTxt;
  }
  
  public String getOperation()
  {
    return this.operation;
  }
  
  public Integer getOperationCode()
  {
    return this.operationCode;
  }
  
  public String getPaymentDate()
  {
    return this.paymentDate;
  }
  
  public Integer getPeriod()
  {
    return this.period;
  }
  
  public String getReceivableAmount()
  {
    return this.receivableAmount;
  }
  
  public String getReceivedAmount()
  {
    return this.receivedAmount;
  }
  
  public void setBillCycle(String paramString)
  {
    this.billCycle = paramString;
  }
  
  public void setBillStatus(Integer paramInteger)
  {
    this.billStatus = paramInteger;
  }
  
  public void setBillStatusTxt(String paramString)
  {
    this.billStatusTxt = paramString;
  }
  
  public void setOperation(String paramString)
  {
    this.operation = paramString;
  }
  
  public void setOperationCode(Integer paramInteger)
  {
    this.operationCode = paramInteger;
  }
  
  public void setPaymentDate(String paramString)
  {
    this.paymentDate = paramString;
  }
  
  public void setPeriod(Integer paramInteger)
  {
    this.period = paramInteger;
  }
  
  public void setReceivableAmount(String paramString)
  {
    this.receivableAmount = paramString;
  }
  
  public void setReceivedAmount(String paramString)
  {
    this.receivedAmount = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.period);
    paramParcel.writeString(this.billCycle);
    paramParcel.writeString(this.paymentDate);
    paramParcel.writeString(this.receivableAmount);
    paramParcel.writeString(this.receivedAmount);
    paramParcel.writeString(this.billStatusTxt);
    paramParcel.writeValue(this.operationCode);
    paramParcel.writeString(this.operation);
    paramParcel.writeValue(this.billStatus);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignBillRent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */