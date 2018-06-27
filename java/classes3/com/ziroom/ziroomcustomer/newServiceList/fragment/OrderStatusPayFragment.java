package com.ziroom.ziroomcustomer.newServiceList.fragment;

import android.os.Bundle;
import com.ziroom.ziroomcustomer.newServiceList.utils.c;

public class OrderStatusPayFragment
  extends OrderListBaseFragment
{
  public static OrderStatusPayFragment getInstance(String paramString)
  {
    OrderStatusPayFragment localOrderStatusPayFragment = new OrderStatusPayFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("order_bus_type", paramString);
    localOrderStatusPayFragment.setArguments(localBundle);
    return localOrderStatusPayFragment;
  }
  
  public void getOrderType(Integer paramInteger)
  {
    this.b = Integer.valueOf(1003);
    super.getOrderType(paramInteger);
  }
  
  public void onShowMessageEvent(c paramc)
  {
    this.a = "pay";
    super.onShowMessageEvent(paramc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/fragment/OrderStatusPayFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */