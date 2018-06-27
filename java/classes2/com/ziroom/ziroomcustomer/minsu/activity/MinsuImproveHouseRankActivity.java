package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.os.Bundle;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImproveHouseRankBean;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.s;

public class MinsuImproveHouseRankActivity
  extends BaseActivity
{
  private void a()
  {
    b();
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.improveHouseRank(this, new s(this, new p(MinsuImproveHouseRankBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuImproveHouseRankBean paramAnonymousMinsuImproveHouseRankBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuImproveHouseRankBean);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903288);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuImproveHouseRankActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */