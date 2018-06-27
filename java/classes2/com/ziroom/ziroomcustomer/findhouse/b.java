package com.ziroom.ziroomcustomer.findhouse;

import java.io.Serializable;
import java.util.List;

public class b
  implements Serializable
{
  private List<String> a;
  private List<Integer> b;
  
  public b() {}
  
  public b(List<String> paramList, List<Integer> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
  }
  
  public List<Integer> getIs_hot()
  {
    return this.b;
  }
  
  public List<String> getSubway_station_name()
  {
    return this.a;
  }
  
  public void setIs_hot(List<Integer> paramList)
  {
    this.b = paramList;
  }
  
  public void setSubway_station_name(List<String> paramList)
  {
    this.a = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */