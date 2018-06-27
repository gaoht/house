package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class AreaSubway
  implements Serializable
{
  private String lines;
  private String station;
  
  public String getLines()
  {
    return this.lines;
  }
  
  public String getStation()
  {
    return this.station;
  }
  
  public void setLines(String paramString)
  {
    this.lines = paramString;
  }
  
  public void setStation(String paramString)
  {
    this.station = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AreaSubway.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */