package com.baidu.mapapi.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelItem
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelItem> CREATOR = new c();
  private Bundle a;
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getBundle()
  {
    return this.a;
  }
  
  public void setBundle(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/model/ParcelItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */