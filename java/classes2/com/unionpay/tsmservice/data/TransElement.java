package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TransElement
  implements Parcelable
{
  public static final Parcelable.Creator<TransElement> CREATOR = new TransElement.1();
  private boolean isMustShow = true;
  private String mHint = "";
  private String mLabel = "";
  private String mName = "";
  private String mType = "";
  private String mVerfyRule = "";
  
  public TransElement() {}
  
  public TransElement(Parcel paramParcel)
  {
    if (1 == paramParcel.readInt()) {}
    for (;;)
    {
      this.isMustShow = bool;
      this.mLabel = paramParcel.readString();
      this.mName = paramParcel.readString();
      this.mHint = paramParcel.readString();
      this.mVerfyRule = paramParcel.readString();
      this.mType = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getHint()
  {
    return this.mHint;
  }
  
  public String getLabel()
  {
    return this.mLabel;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public String getVerfyRule()
  {
    return this.mVerfyRule;
  }
  
  public boolean isMustShow()
  {
    return this.isMustShow;
  }
  
  public void setHint(String paramString)
  {
    this.mHint = paramString;
  }
  
  public void setLabel(String paramString)
  {
    this.mLabel = paramString;
  }
  
  public void setMustShow(boolean paramBoolean)
  {
    this.isMustShow = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
  
  public void setVerfyRule(String paramString)
  {
    this.mVerfyRule = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.isMustShow) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mLabel);
      paramParcel.writeString(this.mName);
      paramParcel.writeString(this.mHint);
      paramParcel.writeString(this.mVerfyRule);
      paramParcel.writeString(this.mType);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/TransElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */