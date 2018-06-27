package com.ziroom.ziroomcustomer.findhouse.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class MapPlanNode
  implements Parcelable
{
  public static final Parcelable.Creator<MapPlanNode> CREATOR = new Parcelable.Creator()
  {
    public MapPlanNode createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MapPlanNode(paramAnonymousParcel);
    }
    
    public MapPlanNode[] newArray(int paramAnonymousInt)
    {
      return new MapPlanNode[paramAnonymousInt];
    }
  };
  private LatLng latlng;
  private String name;
  
  public MapPlanNode() {}
  
  protected MapPlanNode(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.latlng = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LatLng getLatlng()
  {
    return this.latlng;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setLatlng(LatLng paramLatLng)
  {
    this.latlng = paramLatLng;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeParcelable(this.latlng, paramInt);
  }
  
  public static class MapRoute
    implements Parcelable
  {
    public static final Parcelable.Creator<MapRoute> CREATOR = new Parcelable.Creator()
    {
      public MapPlanNode.MapRoute createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MapPlanNode.MapRoute(paramAnonymousParcel);
      }
      
      public MapPlanNode.MapRoute[] newArray(int paramAnonymousInt)
      {
        return new MapPlanNode.MapRoute[paramAnonymousInt];
      }
    };
    MapPlanNode endNode;
    MapPlanNode startNode;
    
    public MapRoute() {}
    
    protected MapRoute(Parcel paramParcel)
    {
      this.startNode = ((MapPlanNode)paramParcel.readParcelable(MapPlanNode.class.getClassLoader()));
      this.endNode = ((MapPlanNode)paramParcel.readParcelable(MapPlanNode.class.getClassLoader()));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public MapPlanNode getEndNode()
    {
      return this.endNode;
    }
    
    public MapPlanNode getStartNode()
    {
      return this.startNode;
    }
    
    public void setEndNode(MapPlanNode paramMapPlanNode)
    {
      this.endNode = paramMapPlanNode;
    }
    
    public void setStartNode(MapPlanNode paramMapPlanNode)
    {
      this.startNode = paramMapPlanNode;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.startNode, paramInt);
      paramParcel.writeParcelable(this.endNode, paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/MapPlanNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */