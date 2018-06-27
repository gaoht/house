package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoSourceObject
  implements Parcelable
{
  public static final Parcelable.Creator<VideoSourceObject> CREATOR = new Parcelable.Creator()
  {
    public VideoSourceObject createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VideoSourceObject(paramAnonymousParcel);
    }
    
    public VideoSourceObject[] newArray(int paramAnonymousInt)
    {
      return new VideoSourceObject[paramAnonymousInt];
    }
  };
  public String actionUrl;
  public Uri coverPath;
  public String defaultText;
  public String description;
  public long during;
  public String identify;
  public String schema;
  public byte[] thumbData;
  public String title;
  public Uri videoPath;
  
  public VideoSourceObject() {}
  
  protected VideoSourceObject(Parcel paramParcel)
  {
    this.actionUrl = paramParcel.readString();
    this.schema = paramParcel.readString();
    this.identify = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.thumbData = paramParcel.createByteArray();
    this.coverPath = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.videoPath = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.during = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getObjType()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeString(this.schema);
    paramParcel.writeString(this.identify);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeByteArray(this.thumbData);
    paramParcel.writeParcelable(this.coverPath, paramInt);
    paramParcel.writeParcelable(this.videoPath, paramInt);
    paramParcel.writeLong(this.during);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/sina/weibo/sdk/api/VideoSourceObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */