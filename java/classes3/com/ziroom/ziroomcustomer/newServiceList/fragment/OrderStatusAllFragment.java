package com.ziroom.ziroomcustomer.newServiceList.fragment;

import android.os.Bundle;
import com.ziroom.ziroomcustomer.newServiceList.utils.c;

public class OrderStatusAllFragment
  extends OrderListBaseFragment
{
  public static OrderStatusAllFragment getInstance(String paramString)
  {
    OrderStatusAllFragment localOrderStatusAllFragment = new OrderStatusAllFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("order_bus_type", paramString);
    localOrderStatusAllFragment.setArguments(localBundle);
    return localOrderStatusAllFragment;
  }
  
  public void getOrderType(Integer paramInteger)
  {
    this.b = null;
    super.getOrderType(paramInteger);
  }
  
  public void onShowMessageEvent(c paramc)
  {
    this.a = "all";
    super.onShowMessageEvent(paramc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/fragment/OrderStatusAllFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */