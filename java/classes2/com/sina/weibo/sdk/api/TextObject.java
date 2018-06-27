package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class TextObject
  implements Parcelable
{
  public static final Parcelable.Creator<TextObject> CREATOR = new Parcelable.Creator()
  {
    public TextObject createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TextObject(paramAnonymousParcel);
    }
    
    public TextObject[] newArray(int paramAnonymousInt)
    {
      return new TextObject[paramAnonymousInt];
    }
  };
  public String text;
  
  public TextObject() {}
  
  public TextObject(Parcel paramParcel)
  {
    this.text = paramParcel.readString();
  }
  
  public boolean checkArgs()
  {
    return (!TextUtils.isEmpty(this.text)) && (this.text.length() <= 1024);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getObjType()
  {
    return 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.text);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/sina/weibo/sdk/api/TextObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */