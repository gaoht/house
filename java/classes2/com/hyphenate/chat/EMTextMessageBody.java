package com.hyphenate.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.hyphenate.chat.adapter.message.EMATextMessageBody;

public class EMTextMessageBody
  extends EMMessageBody
  implements Parcelable
{
  public static final Parcelable.Creator<EMTextMessageBody> CREATOR = new Parcelable.Creator()
  {
    public EMTextMessageBody createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EMTextMessageBody(paramAnonymousParcel, null);
    }
    
    public EMTextMessageBody[] newArray(int paramAnonymousInt)
    {
      return new EMTextMessageBody[paramAnonymousInt];
    }
  };
  
  private EMTextMessageBody(Parcel paramParcel)
  {
    this.emaObject = new EMATextMessageBody(paramParcel.readString());
  }
  
  EMTextMessageBody(EMATextMessageBody paramEMATextMessageBody)
  {
    this.emaObject = paramEMATextMessageBody;
  }
  
  public EMTextMessageBody(String paramString)
  {
    this.emaObject = new EMATextMessageBody(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMessage()
  {
    return ((EMATextMessageBody)this.emaObject).text();
  }
  
  public String toString()
  {
    return "txt:\"" + ((EMATextMessageBody)this.emaObject).text() + "\"";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(((EMATextMessageBody)this.emaObject).text());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMTextMessageBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */