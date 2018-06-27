package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuChatListFragment;

public class MinsuLandlordChartListAvtivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903294);
    if (paramBundle == null)
    {
      paramBundle = new MinsuChatListFragment();
      Bundle localBundle = new Bundle();
      localBundle.putInt("customerType", 1);
      paramBundle.setArguments(localBundle);
      getSupportFragmentManager().beginTransaction().add(2131691278, paramBundle).commitAllowingStateLoss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordChartListAvtivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */