package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<ParcelItem>
{
  public ParcelItem a(Parcel paramParcel)
  {
    ParcelItem localParcelItem = new ParcelItem();
    localParcelItem.setBundle(paramParcel.readBundle());
    return localParcelItem;
  }
  
  public ParcelItem[] a(int paramInt)
  {
    return new ParcelItem[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */