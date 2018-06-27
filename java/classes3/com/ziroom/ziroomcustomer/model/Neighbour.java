package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class Neighbour
{
  private String house_code;
  private List<NeighbourDetail> list;
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public List<NeighbourDetail> getList()
  {
    return this.list;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setList(List<NeighbourDetail> paramList)
  {
    this.list = paramList;
  }
  
  public String toString()
  {
    return "Neighbour [house_code=" + this.house_code + ", list=" + this.list + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Neighbour.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */