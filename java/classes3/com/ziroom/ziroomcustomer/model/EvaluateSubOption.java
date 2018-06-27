package com.ziroom.ziroomcustomer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EvaluateSubOption
  implements Parcelable
{
  public static final Parcelable.Creator<EvaluateSubOption> CREATOR = new Parcelable.Creator()
  {
    public EvaluateSubOption createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EvaluateSubOption(paramAnonymousParcel);
    }
    
    public EvaluateSubOption[] newArray(int paramAnonymousInt)
    {
      return new EvaluateSubOption[paramAnonymousInt];
    }
  };
  private String desc;
  private int selected;
  private String subOptionCode;
  
  public EvaluateSubOption() {}
  
  protected EvaluateSubOption(Parcel paramParcel)
  {
    this.subOptionCode = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.selected = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public int getSelected()
  {
    return this.selected;
  }
  
  public String getSubOptionCode()
  {
    return this.subOptionCode;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setSelected(int paramInt)
  {
    this.selected = paramInt;
  }
  
  public void setSubOptionCode(String paramString)
  {
    this.subOptionCode = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.subOptionCode);
    paramParcel.writeString(this.desc);
    paramParcel.writeInt(this.selected);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/EvaluateSubOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */