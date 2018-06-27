package com.ziroom.ziroomcustomer.bestgoods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QualifcationProofMo
  implements Parcelable
{
  public static final Parcelable.Creator<QualifcationProofMo> CREATOR = new Parcelable.Creator()
  {
    public QualifcationProofMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new QualifcationProofMo(paramAnonymousParcel);
    }
    
    public QualifcationProofMo[] newArray(int paramAnonymousInt)
    {
      return new QualifcationProofMo[paramAnonymousInt];
    }
  };
  private String a;
  
  public QualifcationProofMo() {}
  
  protected QualifcationProofMo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getImgUrl()
  {
    return this.a;
  }
  
  public void setImgUrl(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/model/QualifcationProofMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */