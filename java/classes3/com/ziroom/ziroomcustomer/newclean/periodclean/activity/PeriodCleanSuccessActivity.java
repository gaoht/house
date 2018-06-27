package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;

public class PeriodCleanSuccessActivity
  extends BaseActivity
{
  private String a;
  @BindView(2131692102)
  Button btnGetOrder;
  @BindView(2131692101)
  Button btnOrderDetail;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131689541)
  TextView tvTitle;
  
  public void onBackPressed()
  {
    super.onBackPressed();
    startActivity(new Intent(this, MainActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903431);
    ButterKnife.bind(this);
    this.a = getIntent().getStringExtra("orderId");
  }
  
  @OnClick({2131689492, 2131692101, 2131692102})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692101: 
      paramView = new Intent(this, PeriodCleanerOrderDetailActivity.class);
      paramView.putExtra("orderId", this.a);
      startActivity(paramView);
      return;
    case 2131689492: 
      startActivity(new Intent(this, MainActivity.class));
      return;
    }
    paramView = new Intent(this, CleanIndexActivity.class);
    paramView.putExtra("ServiceInfoId", "2c9084454b7835b0014b7841269101a9");
    paramView.putExtra("ServiceInfoName", "日常保洁");
    startActivity(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */