package com.ziroom.ziroomcustomer.minsu.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuChatListFragment;

public class MinsuCustomerChatListActivity
  extends BaseActivity
{
  private MinsuChatListFragment a;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903268);
    this.a = new MinsuChatListFragment();
    paramBundle = new Bundle();
    paramBundle.putInt("customerType", 2);
    this.a.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().add(2131691278, this.a).commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCustomerChatListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */