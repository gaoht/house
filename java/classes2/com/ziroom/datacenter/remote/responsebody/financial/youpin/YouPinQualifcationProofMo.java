package com.ziroom.datacenter.remote.responsebody.financial.youpin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class YouPinQualifcationProofMo
  implements Parcelable
{
  public static final Parcelable.Creator<YouPinQualifcationProofMo> CREATOR = new Parcelable.Creator()
  {
    public YouPinQualifcationProofMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new YouPinQualifcationProofMo(paramAnonymousParcel);
    }
    
    public YouPinQualifcationProofMo[] newArray(int paramAnonymousInt)
    {
      return new YouPinQualifcationProofMo[paramAnonymousInt];
    }
  };
  private String a;
  
  public YouPinQualifcationProofMo() {}
  
  protected YouPinQualifcationProofMo(Parcel paramParcel)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/youpin/YouPinQualifcationProofMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */