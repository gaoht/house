package com.ziroom.ziroomcustomer.base;

import android.content.Intent;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.WelcomeActivity;

public class BaseSupportURIActivity
  extends BaseActivity
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/BaseSupportURIActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */