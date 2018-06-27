package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.io.Serializable;

public class LandlordReleaseHousePriceBasicBean
  extends MinsuBaseJson
  implements Serializable
{
  private LandlordReleaseHousePriceBasicData data;
  
  public LandlordReleaseHousePriceBasicData getData()
  {
    return this.data;
  }
  
  public void setData(LandlordReleaseHousePriceBasicData paramLandlordReleaseHousePriceBasicData)
  {
    this.data = paramLandlordReleaseHousePriceBasicData;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/LandlordReleaseHousePriceBasicBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */