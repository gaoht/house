package com.ziroom.ziroomcustomer.ziroomstation.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZSpaceImageItem
  implements Parcelable
{
  public static final Parcelable.Creator<ZSpaceImageItem> CREATOR = new Parcelable.Creator()
  {
    public ZSpaceImageItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZSpaceImageItem(paramAnonymousParcel);
    }
    
    public ZSpaceImageItem[] newArray(int paramAnonymousInt)
    {
      return new ZSpaceImageItem[paramAnonymousInt];
    }
  };
  public String imageDesc;
  public String imageId;
  public boolean isSelected = false;
  public String localPath;
  public String sourcePath;
  public String thumbnailPath;
  
  public ZSpaceImageItem() {}
  
  protected ZSpaceImageItem(Parcel paramParcel)
  {
    this.imageId = paramParcel.readString();
    this.thumbnailPath = paramParcel.readString();
    this.sourcePath = paramParcel.readString();
    this.localPath = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.isSelected = bool;
    this.imageDesc = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.imageId);
    paramParcel.writeString(this.thumbnailPath);
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeString(this.localPath);
    if (this.isSelected) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.imageDesc);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/ZSpaceImageItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */