package com.ziroom.ziroomcustomer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class EvaluateOption
  implements Parcelable
{
  public static final Parcelable.Creator<EvaluateOption> CREATOR = new Parcelable.Creator()
  {
    public EvaluateOption createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EvaluateOption(paramAnonymousParcel);
    }
    
    public EvaluateOption[] newArray(int paramAnonymousInt)
    {
      return new EvaluateOption[paramAnonymousInt];
    }
  };
  private String code;
  private String desc;
  private int selected;
  private List<EvaluateSubOption> subOptions;
  private String subQuestionCode;
  
  public EvaluateOption() {}
  
  protected EvaluateOption(Parcel paramParcel)
  {
    this.code = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.subQuestionCode = paramParcel.readString();
    this.subOptions = paramParcel.createTypedArrayList(EvaluateSubOption.CREATOR);
    this.selected = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public int getSelected()
  {
    return this.selected;
  }
  
  public List<EvaluateSubOption> getSubOptions()
  {
    return this.subOptions;
  }
  
  public String getSubQuestionCode()
  {
    return this.subQuestionCode;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setSelected(int paramInt)
  {
    this.selected = paramInt;
  }
  
  public void setSubOptions(List<EvaluateSubOption> paramList)
  {
    this.subOptions = paramList;
  }
  
  public void setSubQuestionCode(String paramString)
  {
    this.subQuestionCode = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.code);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.subQuestionCode);
    paramParcel.writeTypedList(this.subOptions);
    paramParcel.writeInt(this.selected);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/EvaluateOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */