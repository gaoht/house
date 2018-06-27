package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlord.fragment.MinsuLLHouseFragment;
import com.ziroom.ziroomcustomer.util.ai;

public class MinsuLandlordHouseAvtivity
  extends BaseActivity
{
  MinsuLLHouseFragment a;
  private int b = 0;
  
  public void finish()
  {
    String str = getIntent().getStringExtra("from");
    if (ai.class.getSimpleName().equals(str)) {
      k.landlordActivity(this);
    }
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.a != null) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903294);
    if (paramBundle == null)
    {
      this.a = new MinsuLLHouseFragment();
      getSupportFragmentManager().beginTransaction().add(2131691278, this.a).commitAllowingStateLoss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordHouseAvtivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */