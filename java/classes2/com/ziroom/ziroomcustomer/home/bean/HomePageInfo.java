package com.ziroom.ziroomcustomer.home.bean;

import java.util.List;

public class HomePageInfo
{
  private HouseInfo house;
  private ZiruHuoDong huodong;
  private List<BannerPic> pics;
  private Ziruke ziker;
  
  public HouseInfo getHouse()
  {
    return this.house;
  }
  
  public ZiruHuoDong getHuodong()
  {
    return this.huodong;
  }
  
  public List<BannerPic> getPics()
  {
    return this.pics;
  }
  
  public Ziruke getZiker()
  {
    return this.ziker;
  }
  
  public void setHouse(HouseInfo paramHouseInfo)
  {
    this.house = paramHouseInfo;
  }
  
  public void setHuodong(ZiruHuoDong paramZiruHuoDong)
  {
    this.huodong = paramZiruHuoDong;
  }
  
  public void setPics(List<BannerPic> paramList)
  {
    this.pics = paramList;
  }
  
  public void setZiker(Ziruke paramZiruke)
  {
    this.ziker = paramZiruke;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/HomePageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */