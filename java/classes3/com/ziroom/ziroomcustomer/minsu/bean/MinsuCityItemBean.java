package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;

public class MinsuCityItemBean
  implements Serializable
{
  public String code;
  public Double latitude;
  public Double longitude;
  public String name;
  
  public String toString()
  {
    return "MinsuCityItemBean{name='" + this.name + '\'' + ", code='" + this.code + '\'' + ", latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCityItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */