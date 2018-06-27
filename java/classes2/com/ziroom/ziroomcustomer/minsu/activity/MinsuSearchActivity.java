package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.fragment.MinsuSearchFragment;

public class MinsuSearchActivity
  extends BaseActivity
{
  private MinsuSearchFragment a;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903468);
    this.a = MinsuSearchFragment.newInstance();
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131692270, this.a);
    paramBundle.commitAllowingStateLoss();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    paramIntent = getSupportFragmentManager().beginTransaction();
    paramIntent.replace(2131692270, MinsuSearchFragment.newInstance());
    paramIntent.commitAllowingStateLoss();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */