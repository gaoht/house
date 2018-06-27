package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;

public class MinsuHouseBannerBean
  implements Serializable, Comparable<MinsuHouseBannerBean>
{
  private String bannerImg;
  private int bannerIndex;
  private String bannerSubtitle;
  private String bannerTitle;
  private String bannerType;
  
  public int compareTo(MinsuHouseBannerBean paramMinsuHouseBannerBean)
  {
    if (paramMinsuHouseBannerBean.getBannerIndex() != getBannerIndex()) {
      return paramMinsuHouseBannerBean.getBannerIndex() - getBannerIndex();
    }
    return 0;
  }
  
  public String getBannerImg()
  {
    return this.bannerImg;
  }
  
  public int getBannerIndex()
  {
    return this.bannerIndex;
  }
  
  public String getBannerSubtitle()
  {
    return this.bannerSubtitle;
  }
  
  public String getBannerTitle()
  {
    return this.bannerTitle;
  }
  
  public String getBannerType()
  {
    return this.bannerType;
  }
  
  public void setBannerImg(String paramString)
  {
    this.bannerImg = paramString;
  }
  
  public void setBannerIndex(int paramInt)
  {
    this.bannerIndex = paramInt;
  }
  
  public void setBannerSubtitle(String paramString)
  {
    this.bannerSubtitle = paramString;
  }
  
  public void setBannerTitle(String paramString)
  {
    this.bannerTitle = paramString;
  }
  
  public void setBannerType(String paramString)
  {
    this.bannerType = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuHouseBannerBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */