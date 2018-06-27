package com.ziroom.ziroomcustomer.newServiceList.fragment;

import android.os.Bundle;
import com.ziroom.ziroomcustomer.newServiceList.utils.c;

public class OrderStatusVisitFragment
  extends OrderListBaseFragment
{
  public static OrderStatusVisitFragment getInstance(String paramString)
  {
    OrderStatusVisitFragment localOrderStatusVisitFragment = new OrderStatusVisitFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("order_bus_type", paramString);
    localOrderStatusVisitFragment.setArguments(localBundle);
    return localOrderStatusVisitFragment;
  }
  
  public void getOrderType(Integer paramInteger)
  {
    this.b = Integer.valueOf(1001);
    super.getOrderType(paramInteger);
  }
  
  public void onShowMessageEvent(c paramc)
  {
    this.a = "visit";
    super.onShowMessageEvent(paramc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/fragment/OrderStatusVisitFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */