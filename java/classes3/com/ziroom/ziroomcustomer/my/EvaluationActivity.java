package com.ziroom.ziroomcustomer.my;

import android.content.Context;
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
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinListActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuEvaluationListActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluateWaitBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluateWaitBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.widget.OrderItemView;
import com.ziroom.ziroomcustomer.ziroomstation.StationUnEvaOrderListActivity;

public class EvaluationActivity
  extends BaseActivity
{
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131689933)
  OrderItemView order_minsu;
  
  private void a(Class paramClass)
  {
    startActivity(new Intent(this, paramClass));
  }
  
  @OnClick({2131689933, 2131690580, 2131689932, 2131690578, 2131690581, 2131690579, 2131689930})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689930: 
      startActivity(new Intent(this, MyRentEvaluateListActivity.class));
      return;
    case 2131689933: 
      startActivity(new Intent(this, MinsuEvaluationListActivity.class));
      return;
    case 2131690580: 
      a(MyApartUnEvaAppointActivity.class);
      return;
    case 2131689932: 
      a(StationUnEvaOrderListActivity.class);
      return;
    case 2131690578: 
      j.setToList(this, "onlyEval");
      return;
    case 2131690581: 
      paramView = new Intent(this, YouPinListActivity.class);
      paramView.putExtra("orderState", 27);
      startActivity(paramView);
      return;
    }
    paramView = new Intent(this, ZiroomOrderListActivity.class);
    paramView.putExtra("order_status_type", "onlyEval");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903173);
    ButterKnife.bind(this);
    this.mBztb.setTitle("待评价");
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    com.ziroom.ziroomcustomer.minsu.e.a.getEvaluateWaitNum(this, new t(this, new r(MinsuEvaluateWaitBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuEvaluateWaitBean paramAnonymousMinsuEvaluateWaitBean)
      {
        if ((paramAnonymousMinsuEvaluateWaitBean != null) && ("0".equals(paramAnonymousMinsuEvaluateWaitBean.getStatus())) && (paramAnonymousMinsuEvaluateWaitBean.getData() != null))
        {
          if (paramAnonymousMinsuEvaluateWaitBean.getData().getCount() < 1) {
            EvaluationActivity.this.order_minsu.setMessageCount(null);
          }
        }
        else {
          return;
        }
        if (paramAnonymousMinsuEvaluateWaitBean.getData().getCount() > 99)
        {
          EvaluationActivity.this.order_minsu.setMessageCount("99+");
          return;
        }
        EvaluationActivity.this.order_minsu.setMessageCount(paramAnonymousMinsuEvaluateWaitBean.getData().getCount() + "");
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/EvaluationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */