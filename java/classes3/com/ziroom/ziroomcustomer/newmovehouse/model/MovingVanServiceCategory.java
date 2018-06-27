package com.ziroom.ziroomcustomer.newmovehouse.model;

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
  private List<MovingVanService> childrenItemlist;
  private MovingVanServiceCategoryDetail item;
  
  public MovingVanServiceCategory() {}
  
  protected MovingVanServiceCategory(Parcel paramParcel)
  {
    this.item = ((MovingVanServiceCategoryDetail)paramParcel.readParcelable(MovingVanServiceCategoryDetail.class.getClassLoader()));
    this.childrenItemlist = paramParcel.createTypedArrayList(MovingVanService.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<MovingVanService> getChildrenItemlist()
  {
    return this.childrenItemlist;
  }
  
  public MovingVanServiceCategoryDetail getItem()
  {
    return this.item;
  }
  
  public void setChildrenItemlist(List<MovingVanService> paramList)
  {
    this.childrenItemlist = paramList;
  }
  
  public void setItem(MovingVanServiceCategoryDetail paramMovingVanServiceCategoryDetail)
  {
    this.item = paramMovingVanServiceCategoryDetail;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.item, paramInt);
    paramParcel.writeTypedList(this.childrenItemlist);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MovingVanServiceCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */