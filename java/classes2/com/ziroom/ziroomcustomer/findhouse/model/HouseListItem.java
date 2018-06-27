package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class HouseListItem
{
  private HouseListOptions options;
  private List<HouseItem> rooms;
  
  public HouseListOptions getOptions()
  {
    return this.options;
  }
  
  public List<HouseItem> getRooms()
  {
    return this.rooms;
  }
  
  public void setOptions(HouseListOptions paramHouseListOptions)
  {
    this.options = paramHouseListOptions;
  }
  
  public void setRooms(List<HouseItem> paramList)
  {
    this.rooms = paramList;
  }
  
  public String toString()
  {
    return "HouseListItem{rooms=" + this.rooms + ", options=" + this.options + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/HouseListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */