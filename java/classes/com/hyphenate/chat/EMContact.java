package com.hyphenate.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EMContact
  implements Parcelable
{
  public static final Parcelable.Creator<EMContact> CREATOR = new EMContact.1();
  protected String nick;
  protected String username;
  
  protected EMContact() {}
  
  private EMContact(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
  }
  
  public EMContact(String paramString)
  {
    this.username = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getNick()
  {
    return getNickname();
  }
  
  public String getNickname()
  {
    if (this.nick == null) {
      return getUsername();
    }
    return this.nick;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  @Deprecated
  public void setNick(String paramString)
  {
    this.nick = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nick = paramString;
  }
  
  public String toString()
  {
    return "<contact , username:" + this.username + ">";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMContact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */