package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PhotoDescription
  implements Parcelable
{
  public static final Parcelable.Creator<PhotoDescription> CREATOR = new Parcelable.Creator()
  {
    public PhotoDescription createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PhotoDescription(paramAnonymousParcel, null);
    }
    
    public PhotoDescription[] newArray(int paramAnonymousInt)
    {
      return new PhotoDescription[paramAnonymousInt];
    }
  };
  public String a;
  public int b = 1;
  public String c;
  public int d = 0;
  public a e = a.a;
  
  public PhotoDescription() {}
  
  private PhotoDescription(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "PhotoDescription{path='" + this.a + '\'' + ", isLocalPhoto=" + this.b + ", UUID='" + this.c + '\'' + ", isPreViewImage=" + this.d + ", state=" + this.e + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/PhotoDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */