package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SeAppListItem$1
  implements Parcelable.Creator<SeAppListItem>
{
  public final SeAppListItem createFromParcel(Parcel paramParcel)
  {
    return new SeAppListItem(paramParcel);
  }
  
  public final SeAppListItem[] newArray(int paramInt)
  {
    return new SeAppListItem[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/SeAppListItem$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */