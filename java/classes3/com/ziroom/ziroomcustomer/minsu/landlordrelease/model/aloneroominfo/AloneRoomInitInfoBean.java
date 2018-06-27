package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.io.Serializable;

public class AloneRoomInitInfoBean
  extends MinsuBaseJson
  implements Serializable
{
  private AloneRoomInitInfoDataBean data;
  
  public AloneRoomInitInfoDataBean getData()
  {
    return this.data;
  }
  
  public void setData(AloneRoomInitInfoDataBean paramAloneRoomInitInfoDataBean)
  {
    this.data = paramAloneRoomInitInfoDataBean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/aloneroominfo/AloneRoomInitInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */