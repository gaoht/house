package com.ziroom.ziroomcustomer.newServiceList.fragment;

import android.os.Bundle;
import com.ziroom.ziroomcustomer.newServiceList.utils.c;

public class OrderStatusAcceptedFragment
  extends OrderListBaseFragment
{
  public static OrderStatusAcceptedFragment getInstance(String paramString)
  {
    OrderStatusAcceptedFragment localOrderStatusAcceptedFragment = new OrderStatusAcceptedFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("order_bus_type", paramString);
    localOrderStatusAcceptedFragment.setArguments(localBundle);
    return localOrderStatusAcceptedFragment;
  }
  
  public void getOrderType(Integer paramInteger)
  {
    this.b = Integer.valueOf(1000);
    super.getOrderType(paramInteger);
  }
  
  public void onShowMessageEvent(c paramc)
  {
    this.a = "accepted";
    super.onShowMessageEvent(paramc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/fragment/OrderStatusAcceptedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */