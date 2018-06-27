package com.baidu.mapapi.map;

import java.util.ArrayList;

public final class MapBaseIndoorMapInfo
{
  private static final String d = MapBaseIndoorMapInfo.class.getSimpleName();
  String a;
  String b;
  ArrayList<String> c;
  
  public MapBaseIndoorMapInfo() {}
  
  public MapBaseIndoorMapInfo(MapBaseIndoorMapInfo paramMapBaseIndoorMapInfo)
  {
    this.a = paramMapBaseIndoorMapInfo.a;
    this.b = paramMapBaseIndoorMapInfo.b;
    this.c = paramMapBaseIndoorMapInfo.c;
  }
  
  public MapBaseIndoorMapInfo(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
  }
  
  public String getCurFloor()
  {
    return this.b;
  }
  
  public ArrayList<String> getFloors()
  {
    return this.c;
  }
  
  public String getID()
  {
    return this.a;
  }
  
  public static enum SwitchFloorError
  {
    private SwitchFloorError() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/MapBaseIndoorMapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */