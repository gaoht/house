package com.ziroom.ziroomcustomer.newmovehouse.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MovingVanService
  implements Parcelable
{
  public static final Parcelable.Creator<MovingVanService> CREATOR = new Parcelable.Creator()
  {
    public MovingVanService createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MovingVanService(paramAnonymousParcel);
    }
    
    public MovingVanService[] newArray(int paramAnonymousInt)
    {
      return new MovingVanService[paramAnonymousInt];
    }
  };
  private List<MovingVanServiceItem> childrenItemlist;
  private MovingVanServiceCategoryDetail item;
  
  public MovingVanService() {}
  
  protected MovingVanService(Parcel paramParcel)
  {
    this.item = ((MovingVanServiceCategoryDetail)paramParcel.readParcelable(MovingVanServiceCategoryDetail.class.getClassLoader()));
    this.childrenItemlist = new ArrayList();
    paramParcel.readList(this.childrenItemlist, MovingVanServiceItem.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<MovingVanServiceItem> getChildrenItemlist()
  {
    return this.childrenItemlist;
  }
  
  public MovingVanServiceCategoryDetail getItem()
  {
    return this.item;
  }
  
  public void setChildrenItemlist(List<MovingVanServiceItem> paramList)
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
    paramParcel.writeList(this.childrenItemlist);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MovingVanService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */