package com.ziroom.ziroomcustomer.newServiceList.fragment;

import android.os.Bundle;
import com.ziroom.ziroomcustomer.newServiceList.utils.c;

public class OrderStatusEvalFragment
  extends OrderListBaseFragment
{
  public static OrderStatusEvalFragment getInstance(String paramString)
  {
    OrderStatusEvalFragment localOrderStatusEvalFragment = new OrderStatusEvalFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("order_bus_type", paramString);
    localOrderStatusEvalFragment.setArguments(localBundle);
    return localOrderStatusEvalFragment;
  }
  
  public void getOrderType(Integer paramInteger)
  {
    this.b = Integer.valueOf(1004);
    super.getOrderType(paramInteger);
  }
  
  public void onShowMessageEvent(c paramc)
  {
    this.a = "eval";
    super.onShowMessageEvent(paramc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/fragment/OrderStatusEvalFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */