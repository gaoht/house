package com.ziroom.ziroomcustomer.findhouse.presenter;

import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;

public abstract interface a
{
  public static abstract interface a
    extends com.ziroom.ziroomcustomer.a<a.b>
  {
    public abstract void initData();
  }
  
  public static abstract interface b
    extends b<a.a>
  {
    public abstract void initWithData(RentHouseDetail paramRentHouseDetail);
    
    public abstract void showError();
    
    public abstract void showToast(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */