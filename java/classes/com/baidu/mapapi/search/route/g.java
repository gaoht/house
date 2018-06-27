package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g
  implements Parcelable.Creator<PlanNode>
{
  public PlanNode a(Parcel paramParcel)
  {
    return new PlanNode(paramParcel);
  }
  
  public PlanNode[] a(int paramInt)
  {
    return new PlanNode[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */