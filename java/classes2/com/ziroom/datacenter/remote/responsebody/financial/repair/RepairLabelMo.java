package com.ziroom.datacenter.remote.responsebody.financial.repair;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RepairLabelMo
  implements Parcelable
{
  public static final Parcelable.Creator<RepairLabelMo> CREATOR = new Parcelable.Creator()
  {
    public RepairLabelMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RepairLabelMo(paramAnonymousParcel);
    }
    
    public RepairLabelMo[] newArray(int paramAnonymousInt)
    {
      return new RepairLabelMo[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private Integer c;
  private Integer d;
  
  public RepairLabelMo() {}
  
  protected RepairLabelMo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.d = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Integer getIsUrgent()
  {
    return this.d;
  }
  
  public String getLogicCode()
  {
    return this.a;
  }
  
  public Integer getRank()
  {
    return this.c;
  }
  
  public String getTagName()
  {
    return this.b;
  }
  
  public void setIsUrgent(Integer paramInteger)
  {
    this.d = paramInteger;
  }
  
  public void setLogicCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setRank(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  public void setTagName(String paramString)
  {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeValue(this.c);
    paramParcel.writeValue(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/repair/RepairLabelMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */