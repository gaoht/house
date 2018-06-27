package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.fragment.MinsuLLNeadDealOrderFragment;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuLandlordFutrueOrderActivity
  extends BaseActivity
{
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131691278)
  FrameLayout container;
  
  public void initTitle()
  {
    this.commonTitle.setLeftButtonType(0);
    this.commonTitle.setMiddleText("进行中");
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLandlordFutrueOrderActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903295);
    ButterKnife.bind(this);
    if (paramBundle == null)
    {
      paramBundle = MinsuLLNeadDealOrderFragment.getInitstance(12);
      getSupportFragmentManager().beginTransaction().add(2131691278, paramBundle).commitAllowingStateLoss();
    }
    initTitle();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordFutrueOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */