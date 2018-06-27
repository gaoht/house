package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a;

public class MinsuFragmentWrapperActivity
  extends BaseActivity
{
  private BaseFragment a;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if ((this.a instanceof a))
    {
      if (((a)this.a).onBackPressed()) {
        super.onBackPressed();
      }
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903468);
    int i = getIntent().getIntExtra("type", 2);
    this.a = c.getInstance().getFragment(i, getIntent().getExtras());
    if (this.a == null) {
      finish();
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131692270, this.a);
    paramBundle.commitAllowingStateLoss();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuFragmentWrapperActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */