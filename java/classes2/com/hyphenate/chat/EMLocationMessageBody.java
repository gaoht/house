package com.hyphenate.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.hyphenate.chat.adapter.message.EMALocationMessageBody;

public class EMLocationMessageBody
  extends EMMessageBody
  implements Parcelable
{
  public static final Parcelable.Creator<EMLocationMessageBody> CREATOR = new Parcelable.Creator()
  {
    public EMLocationMessageBody createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EMLocationMessageBody(paramAnonymousParcel, null);
    }
    
    public EMLocationMessageBody[] newArray(int paramAnonymousInt)
    {
      return new EMLocationMessageBody[paramAnonymousInt];
    }
  };
  
  private EMLocationMessageBody(Parcel paramParcel)
  {
    this.emaObject = new EMALocationMessageBody(0.0D, 0.0D, "");
    String str = paramParcel.readString();
    double d1 = paramParcel.readDouble();
    double d2 = paramParcel.readDouble();
    ((EMALocationMessageBody)this.emaObject).setAddress(str);
    ((EMALocationMessageBody)this.emaObject).setLatitude(d1);
    ((EMALocationMessageBody)this.emaObject).setLongitude(d2);
  }
  
  public EMLocationMessageBody(EMALocationMessageBody paramEMALocationMessageBody)
  {
    this.emaObject = paramEMALocationMessageBody;
  }
  
  public EMLocationMessageBody(String paramString, double paramDouble1, double paramDouble2)
  {
    this.emaObject = new EMALocationMessageBody(paramDouble1, paramDouble2, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return ((EMALocationMessageBody)this.emaObject).address();
  }
  
  public double getLatitude()
  {
    return ((EMALocationMessageBody)this.emaObject).latitude();
  }
  
  public double getLongitude()
  {
    return ((EMALocationMessageBody)this.emaObject).longitude();
  }
  
  public String toString()
  {
    return "location:" + ((EMALocationMessageBody)this.emaObject).address() + ",lat:" + ((EMALocationMessageBody)this.emaObject).latitude() + ",lng:" + ((EMALocationMessageBody)this.emaObject).longitude();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(((EMALocationMessageBody)this.emaObject).address());
    paramParcel.writeDouble(((EMALocationMessageBody)this.emaObject).latitude());
    paramParcel.writeDouble(((EMALocationMessageBody)this.emaObject).longitude());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMLocationMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */