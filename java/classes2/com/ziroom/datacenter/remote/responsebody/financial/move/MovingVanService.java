package com.ziroom.datacenter.remote.responsebody.financial.move;

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
  private MovingVanServiceCategoryDetail a;
  private List<MovingVanServiceItem> b;
  
  public MovingVanService() {}
  
  protected MovingVanService(Parcel paramParcel)
  {
    this.a = ((MovingVanServiceCategoryDetail)paramParcel.readParcelable(MovingVanServiceCategoryDetail.class.getClassLoader()));
    this.b = new ArrayList();
    paramParcel.readList(this.b, MovingVanServiceItem.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<MovingVanServiceItem> getChildrenItemlist()
  {
    return this.b;
  }
  
  public MovingVanServiceCategoryDetail getItem()
  {
    return this.a;
  }
  
  public void setChildrenItemlist(List<MovingVanServiceItem> paramList)
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
    paramParcel.writeList(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/move/MovingVanService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */