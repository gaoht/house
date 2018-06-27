package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ZryuSignBillLiving
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignBillLiving> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignBillLiving createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignBillLiving(paramAnonymousParcel);
    }
    
    public ZryuSignBillLiving[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignBillLiving[paramAnonymousInt];
    }
  };
  private Integer amount;
  private String billNum;
  private Integer delCode;
  private String delDesc;
  private List<ZryuSignKvItem> list;
  private String name;
  private Integer operationCode;
  private String value;
  
  public ZryuSignBillLiving() {}
  
  protected ZryuSignBillLiving(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.list = paramParcel.createTypedArrayList(ZryuSignKvItem.CREATOR);
    this.operationCode = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.billNum = paramParcel.readString();
    this.amount = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.delCode = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.delDesc = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Integer getAmount()
  {
    return this.amount;
  }
  
  public String getBillNum()
  {
    return this.billNum;
  }
  
  public Integer getDelCode()
  {
    return this.delCode;
  }
  
  public String getDelDesc()
  {
    return this.delDesc;
  }
  
  public List<ZryuSignKvItem> getList()
  {
    return this.list;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Integer getOperationCode()
  {
    return this.operationCode;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setAmount(Integer paramInteger)
  {
    this.amount = paramInteger;
  }
  
  public void setBillNum(String paramString)
  {
    this.billNum = paramString;
  }
  
  public void setDelCode(Integer paramInteger)
  {
    this.delCode = paramInteger;
  }
  
  public void setDelDesc(String paramString)
  {
    this.delDesc = paramString;
  }
  
  public void setList(List<ZryuSignKvItem> paramList)
  {
    this.list = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOperationCode(Integer paramInteger)
  {
    this.operationCode = paramInteger;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.value);
    paramParcel.writeTypedList(this.list);
    paramParcel.writeValue(this.operationCode);
    paramParcel.writeString(this.billNum);
    paramParcel.writeValue(this.amount);
    paramParcel.writeValue(this.delCode);
    paramParcel.writeString(this.delDesc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignBillLiving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */