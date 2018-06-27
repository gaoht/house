package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.fragment.MinsuSearchTabLocaltionFragment;

public class MinsuSearchTabLocationActivity
  extends BaseActivity
{
  private MinsuSearchTabLocaltionFragment a;
  private int b;
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903468);
    this.b = getIntent().getIntExtra("index", -1);
    this.a = MinsuSearchTabLocaltionFragment.newInstance(getIntent().getExtras());
    this.a.initData(this.b);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.add(2131692270, this.a, "fragment");
    paramBundle.commit();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    this.a.resetView();
    this.b = paramIntent.getIntExtra("index", -1);
    this.a.initData(this.b);
    paramIntent = getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = paramIntent.beginTransaction();
    localFragmentTransaction.add(2131692270, paramIntent.findFragmentByTag("fragment"));
    localFragmentTransaction.commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuSearchTabLocationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */