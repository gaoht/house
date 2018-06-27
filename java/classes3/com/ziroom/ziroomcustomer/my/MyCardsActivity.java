package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairCardListActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanGiftCardActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.util.ah;

public class MyCardsActivity
  extends BaseActivity
{
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131690091)
  TextView tv_call;
  
  private void a(Class paramClass)
  {
    startActivity(new Intent(this, paramClass));
  }
  
  @OnClick({2131690088, 2131690090, 2131690089, 2131690091})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690090: 
      a(RepairCardListActivity.class);
      return;
    case 2131690088: 
      a(CleanStoredCardBuyActivity.class);
      return;
    case 2131690089: 
      a(CleanGiftCardActivity.class);
      return;
    }
    ah.callPhone(this, "01059329088");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903122);
    ButterKnife.bind(this);
    this.mBztb.setTitle("自如服务卡");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyCardsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */