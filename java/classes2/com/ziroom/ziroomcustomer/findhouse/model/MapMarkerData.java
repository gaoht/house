package com.ziroom.ziroomcustomer.findhouse.model;

import com.baidu.mapapi.model.LatLng;
import java.io.Serializable;

public abstract class MapMarkerData
  implements Serializable
{
  public static final int TYPE_BIZCIRCLE = 2;
  public static final int TYPE_BUILDING = 3;
  public static final int TYPE_DISTRICT = 1;
  private boolean isValidLevel = true;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null) {
      return (getType() == ((MapMarkerData)paramObject).getType()) && (getBizType() == ((MapMarkerData)paramObject).getBizType()) && (getLatLng() != null) && (((MapMarkerData)paramObject).getLatLng() != null) && (getLatLng().latitude == ((MapMarkerData)paramObject).getLatLng().latitude) && (getLatLng().longitude == ((MapMarkerData)paramObject).getLatLng().longitude);
    }
    return super.equals(paramObject);
  }
  
  public int getBizType()
  {
    return 1;
  }
  
  public abstract LatLng getLatLng();
  
  public abstract String getMapMarkerCode();
  
  public abstract String getMapMarkerDesc();
  
  public abstract String getMapMarkerIcon();
  
  public abstract String getMapMarkerName();
  
  public abstract LatLng getTouchLatLng();
  
  public abstract int getType();
  
  public boolean isValidLevel()
  {
    return this.isValidLevel;
  }
  
  public boolean nameAndDescEquals(MapMarkerData paramMapMarkerData)
  {
    boolean bool3 = true;
    if (paramMapMarkerData == null) {
      return false;
    }
    boolean bool2;
    if ((paramMapMarkerData.getMapMarkerName() == null) && (getMapMarkerName() == null))
    {
      bool1 = true;
      if ((paramMapMarkerData.getMapMarkerDesc() != null) || (getMapMarkerDesc() != null)) {
        break label69;
      }
      bool2 = true;
      label41:
      if ((!bool1) || (!bool2)) {
        break label84;
      }
    }
    label69:
    label84:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      return bool1;
      bool1 = paramMapMarkerData.getMapMarkerName().equals(getMapMarkerName());
      break;
      bool2 = paramMapMarkerData.getMapMarkerDesc().equals(getMapMarkerDesc());
      break label41;
    }
  }
  
  public void setValidLevel(boolean paramBoolean)
  {
    this.isValidLevel = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/MapMarkerData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */