package com.ziroom.ziroomcustomer.minsu.mapsojourn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.model.a;
import org.greenrobot.eventbus.c;

public class MinsuMapFindActivity
  extends BaseActivity
{
  SojournMapFragment a;
  
  public void finish()
  {
    super.finish();
    c.getDefault().post(new a());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.a != null) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.a != null) {
      this.a.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903314);
    this.a = SojournMapFragment.getIntance();
    getSupportFragmentManager().beginTransaction().add(2131691551, this.a).commit();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c.getDefault().unregister(this);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/MinsuMapFindActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */