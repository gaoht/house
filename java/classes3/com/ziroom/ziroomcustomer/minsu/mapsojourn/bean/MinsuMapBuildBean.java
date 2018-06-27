package com.ziroom.ziroomcustomer.minsu.mapsojourn.bean;

import android.text.TextUtils;

public class MinsuMapBuildBean
  extends MinsuMapBean
{
  private String fidrentway;
  private boolean isRepeatRoom;
  public int orderType;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof MinsuMapBuildBean));
      paramObject = (MinsuMapBuildBean)paramObject;
      bool1 = bool2;
    } while (getType() != ((MinsuMapBuildBean)paramObject).getType());
    return getFidrentway().equals(((MinsuMapBuildBean)paramObject).getFidrentway());
  }
  
  public int getBizType()
  {
    return 2;
  }
  
  public String getFidrentway()
  {
    return this.fidrentway;
  }
  
  public String getMapMarkerDesc()
  {
    if (this.isRepeatRoom)
    {
      String str2 = getNum();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "(0间)";
      }
      return str1;
    }
    return "¥" + getNum();
  }
  
  public String getMapMarkerName()
  {
    return super.getMapMarkerName();
  }
  
  public int getType()
  {
    return 3;
  }
  
  public int hashCode()
  {
    return getType() * 31 + getFidrentway().hashCode();
  }
  
  public boolean isRepeatRoom()
  {
    return this.isRepeatRoom;
  }
  
  public void setFidrentway(String paramString)
  {
    this.fidrentway = paramString;
  }
  
  public void setRepeatRoom(boolean paramBoolean)
  {
    this.isRepeatRoom = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/bean/MinsuMapBuildBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */