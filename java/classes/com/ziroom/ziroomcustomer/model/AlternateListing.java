package com.ziroom.ziroomcustomer.model;

import android.content.Context;
import com.ziroom.ziroomcustomer.b.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import java.io.Serializable;

public class AlternateListing
  implements Serializable
{
  private String add_time = "";
  private String cityCode;
  private int duanzuFlag;
  private String house_id;
  private String house_photos;
  private int house_type;
  private String id;
  private boolean isChecked;
  private String is_turn;
  private String release_date;
  private String resblock_id;
  private String room_name;
  private String room_status;
  private String sell_price;
  private String shortDayRental;
  private String to_see_state;
  private String uid = "";
  
  public static AlternateListing copyData(String paramString, HouseListSearchResult paramHouseListSearchResult)
  {
    AlternateListing localAlternateListing = new AlternateListing();
    localAlternateListing.setUid(paramString);
    localAlternateListing.setHouse_id(paramHouseListSearchResult.getHouse_id());
    localAlternateListing.setId(paramHouseListSearchResult.getHouse_code());
    localAlternateListing.setSell_price(paramHouseListSearchResult.getHouse_price());
    localAlternateListing.setShortDayRental(paramHouseListSearchResult.getHouse_price());
    localAlternateListing.setResblock_id(paramHouseListSearchResult.getBlock_id());
    localAlternateListing.setHouse_photos(paramHouseListSearchResult.getHouse_photos());
    localAlternateListing.setRoom_name(paramHouseListSearchResult.getHouse_name());
    localAlternateListing.setDuanzuFlag(paramHouseListSearchResult.getIs_duanzu());
    localAlternateListing.setAdd_time(String.valueOf(System.currentTimeMillis() / 1000L));
    localAlternateListing.setRoom_status("");
    localAlternateListing.setTo_see_state("");
    return localAlternateListing;
  }
  
  public static AlternateListing copyUploadData(HouseListSearchResult paramHouseListSearchResult)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((UserInfo)localObject).getUid()) {
      return copyData((String)localObject, paramHouseListSearchResult);
    }
  }
  
  public static void syncData(Context paramContext, String paramString)
  {
    a.bindData(paramContext, paramString);
  }
  
  public String getAdd_time()
  {
    return this.add_time;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public int getDuanzuFlag()
  {
    return this.duanzuFlag;
  }
  
  public String getHouse_id()
  {
    return this.house_id;
  }
  
  public String getHouse_photos()
  {
    return this.house_photos;
  }
  
  public int getHouse_type()
  {
    return this.house_type;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getIs_turn()
  {
    return this.is_turn;
  }
  
  public String getRelease_date()
  {
    return this.release_date;
  }
  
  public String getResblock_id()
  {
    return this.resblock_id;
  }
  
  public String getRoom_name()
  {
    return this.room_name;
  }
  
  public String getRoom_status()
  {
    return this.room_status;
  }
  
  public String getSell_price()
  {
    return this.sell_price;
  }
  
  public String getShortDayRental()
  {
    return this.shortDayRental;
  }
  
  public String getTo_see_state()
  {
    return this.to_see_state;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void setAdd_time(String paramString)
  {
    this.add_time = paramString;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setDuanzuFlag(int paramInt)
  {
    this.duanzuFlag = paramInt;
  }
  
  public void setHouse_id(String paramString)
  {
    this.house_id = paramString;
  }
  
  public void setHouse_photos(String paramString)
  {
    this.house_photos = paramString;
  }
  
  public void setHouse_type(int paramInt)
  {
    this.house_type = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public void setIs_turn(String paramString)
  {
    this.is_turn = paramString;
  }
  
  public void setRelease_date(String paramString)
  {
    this.release_date = paramString;
  }
  
  public void setResblock_id(String paramString)
  {
    this.resblock_id = paramString;
  }
  
  public void setRoom_name(String paramString)
  {
    this.room_name = paramString;
  }
  
  public void setRoom_status(String paramString)
  {
    this.room_status = paramString;
  }
  
  public void setSell_price(String paramString)
  {
    this.sell_price = paramString;
  }
  
  public void setShortDayRental(String paramString)
  {
    this.shortDayRental = paramString;
  }
  
  public void setTo_see_state(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.to_see_state = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public String toString()
  {
    return "AlternateListing{uid='" + this.uid + '\'' + ", to_see_state='" + this.to_see_state + '\'' + ", id='" + this.id + '\'' + ", house_id='" + this.house_id + '\'' + ", sell_price='" + this.sell_price + '\'' + ", room_name='" + this.room_name + '\'' + ", duanzuFlag=" + this.duanzuFlag + ", resblock_id='" + this.resblock_id + '\'' + ", room_status='" + this.room_status + '\'' + ", cityCode='" + this.cityCode + '\'' + ", shortDayRental=" + this.shortDayRental + ", house_photos='" + this.house_photos + '\'' + ", house_type='" + this.house_type + '\'' + ", add_time='" + this.add_time + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AlternateListing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */