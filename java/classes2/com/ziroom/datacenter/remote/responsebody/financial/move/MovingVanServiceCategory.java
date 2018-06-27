package com.ziroom.datacenter.remote.responsebody.financial.move;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class MovingVanServiceCategory
  implements Parcelable
{
  public static final Parcelable.Creator<MovingVanServiceCategory> CREATOR = new Parcelable.Creator()
  {
    public MovingVanServiceCategory createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MovingVanServiceCategory(paramAnonymousParcel);
    }
    
    public MovingVanServiceCategory[] newArray(int paramAnonymousInt)
    {
      return new MovingVanServiceCategory[paramAnonymousInt];
    }
  };
  private MovingVanServiceCategoryDetail a;
  private List<MovingVanService> b;
  
  public MovingVanServiceCategory() {}
  
  protected MovingVanServiceCategory(Parcel paramParcel)
  {
    this.a = ((MovingVanServiceCategoryDetail)paramParcel.readParcelable(MovingVanServiceCategoryDetail.class.getClassLoader()));
    this.b = paramParcel.createTypedArrayList(MovingVanService.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<MovingVanService> getChildrenItemlist()
  {
    return this.b;
  }
  
  public MovingVanServiceCategoryDetail getItem()
  {
    return this.a;
  }
  
  public void setChildrenItemlist(List<MovingVanService> paramList)
  {
    this.b = paramList;
  }
  
  public void setItem(MovingVanServiceCategoryDetail paramMovingVanServiceCategoryDetail)
  {
    this.a = paramMovingVanServiceCategoryDetail;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeTypedList(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/move/MovingVanServiceCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */