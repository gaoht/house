package com.ziroom.ziroomcustomer.minsu.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MinsuMiPushMessage
  implements Parcelable
{
  public static final Parcelable.Creator<MinsuMiPushMessage> CREATOR = new Parcelable.Creator()
  {
    public MinsuMiPushMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MinsuMiPushMessage(paramAnonymousParcel);
    }
    
    public MinsuMiPushMessage[] newArray(int paramAnonymousInt)
    {
      return new MinsuMiPushMessage[paramAnonymousInt];
    }
  };
  public String a;
  public String b;
  public String c;
  
  public MinsuMiPushMessage() {}
  
  protected MinsuMiPushMessage(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContent()
  {
    return this.b;
  }
  
  public String getExtra()
  {
    return this.c;
  }
  
  public String getTitle()
  {
    return this.a;
  }
  
  public void setContent(String paramString)
  {
    this.b = paramString;
  }
  
  public void setExtra(String paramString)
  {
    this.c = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuMiPushMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */