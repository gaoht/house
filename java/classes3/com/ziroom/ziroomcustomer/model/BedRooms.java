package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class BedRooms
  implements Serializable, Comparable<BedRooms>
{
  private String house_code;
  private int room_code;
  private List<String> room_photos_big;
  private List<String> room_photos_small;
  private int room_type;
  
  public int compareTo(BedRooms paramBedRooms)
  {
    if (paramBedRooms != null)
    {
      if (getRoom_type() > paramBedRooms.getRoom_type()) {
        return 1;
      }
      if (getRoom_type() == paramBedRooms.getRoom_type()) {
        return 0;
      }
    }
    return -1;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public int getRoom_code()
  {
    return this.room_code;
  }
  
  public List<String> getRoom_photos_big()
  {
    return this.room_photos_big;
  }
  
  public List<String> getRoom_photos_small()
  {
    return this.room_photos_small;
  }
  
  public int getRoom_type()
  {
    return this.room_type;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setRoom_code(int paramInt)
  {
    this.room_code = paramInt;
  }
  
  public void setRoom_photos_big(List<String> paramList)
  {
    this.room_photos_big = paramList;
  }
  
  public void setRoom_photos_small(List<String> paramList)
  {
    this.room_photos_small = paramList;
  }
  
  public void setRoom_type(int paramInt)
  {
    this.room_type = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/BedRooms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */