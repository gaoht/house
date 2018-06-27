package com.ziroom.datacenter.remote.responsebody.financial.chat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ChatMapMoveHouse
  implements Parcelable
{
  public static final Parcelable.Creator<ChatMapMoveHouse> CREATOR = new Parcelable.Creator()
  {
    public ChatMapMoveHouse createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ChatMapMoveHouse(paramAnonymousParcel);
    }
    
    public ChatMapMoveHouse[] newArray(int paramAnonymousInt)
    {
      return new ChatMapMoveHouse[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private String g;
  private List<String> h;
  
  public ChatMapMoveHouse() {}
  
  protected ChatMapMoveHouse(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.createStringArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getPicUrl()
  {
    return this.b;
  }
  
  public String getPriceRemark()
  {
    return this.d;
  }
  
  public List<String> getProDescs()
  {
    return this.h;
  }
  
  public String getRemark()
  {
    return this.e;
  }
  
  public String getServiceInfoId()
  {
    return this.a;
  }
  
  public String getServiceInfoName()
  {
    return this.c;
  }
  
  public String getSlogan()
  {
    return this.g;
  }
  
  public int getSuggest()
  {
    return this.f;
  }
  
  public void setPicUrl(String paramString)
  {
    this.b = paramString;
  }
  
  public void setPriceRemark(String paramString)
  {
    this.d = paramString;
  }
  
  public void setProDescs(List<String> paramList)
  {
    this.h = paramList;
  }
  
  public void setRemark(String paramString)
  {
    this.e = paramString;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setServiceInfoName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setSlogan(String paramString)
  {
    this.g = paramString;
  }
  
  public void setSuggest(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeStringList(this.h);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/chat/ChatMapMoveHouse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */