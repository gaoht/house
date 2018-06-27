package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.util.List;

public class IntoSelectedInfos
{
  public int bedSingleCash;
  public int cashTotal;
  public int personNum;
  public List<RoomBedInfos> selectedBedInfos;
  public String timeString;
  
  public static class RoomBedInfos
  {
    public List<String> beds;
    public String roomName;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/IntoSelectedInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */