package com.ziroom.ziroomcustomer.base;

import android.content.Intent;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.WelcomeActivity;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;

public abstract class BaseFluxSupportURIActivity
  extends BaseFluxActivity
{
  public void finish()
  {
    if (WelcomeActivity.a)
    {
      WelcomeActivity.a = false;
      startActivity(new Intent(this, MainActivity.class));
    }
    super.finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/BaseFluxSupportURIActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */