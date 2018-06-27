package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.reserve.BookingOrderListActivity;
import com.ziroom.ziroomcustomer.ziroomstation.StationOrderListActivity;

public class MyOrdersActivity
  extends BaseActivity
{
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  
  private void a(Class paramClass)
  {
    startActivity(new Intent(this, paramClass));
  }
  
  @OnClick({2131689930, 2131689931, 2131689932, 2131689933, 2131691985, 2131690581, 2131690579})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689930: 
      paramView = new Intent(this, BookingOrderListActivity.class);
      paramView.putExtra("from", "orders");
      startActivity(paramView);
      return;
    case 2131689931: 
      a(ZiroomOrderListActivity.class);
      return;
    case 2131689932: 
      a(StationOrderListActivity.class);
      return;
    case 2131689933: 
      a(MinsuOrderListActivity.class);
      return;
    case 2131691985: 
      a(RepairOrderListActivity.class);
      return;
    case 2131690581: 
      j.toServiceOrderList(this, "type_youpin", "");
      return;
    }
    a(ZiroomOrderListActivity.class);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903401);
    ButterKnife.bind(this);
    this.mBztb.setTitle("我的订单");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyOrdersActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */