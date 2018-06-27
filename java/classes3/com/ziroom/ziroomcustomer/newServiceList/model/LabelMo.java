package com.ziroom.ziroomcustomer.newServiceList.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.fastjson.a;

public class LabelMo
  implements Parcelable
{
  public static final Parcelable.Creator<LabelMo> CREATOR = new Parcelable.Creator()
  {
    public LabelMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LabelMo(paramAnonymousParcel);
    }
    
    public LabelMo[] newArray(int paramAnonymousInt)
    {
      return new LabelMo[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private Integer c;
  private Integer d;
  
  public LabelMo() {}
  
  protected LabelMo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Integer getIsUrgent()
  {
    return this.d;
  }
  
  public String getLogicCode()
  {
    return this.a;
  }
  
  public Integer getRank()
  {
    return this.c;
  }
  
  public String getTagName()
  {
    return this.b;
  }
  
  public void setIsUrgent(Integer paramInteger)
  {
    this.d = paramInteger;
  }
  
  public void setLogicCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setRank(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  public void setTagName(String paramString)
  {
    this.b = paramString;
  }
  
  public String toString()
  {
    return a.toJSONString(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeValue(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/LabelMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */