package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class LinkedInActivity
  extends BaseActivity
{
  private Context a;
  private ImageView b;
  private Button c;
  private int d;
  private int e;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131696712));
    this.c = ((Button)findViewById(2131696714));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904848);
    this.a = this;
    paramBundle = getWindowManager();
    this.d = paramBundle.getDefaultDisplay().getWidth();
    this.e = paramBundle.getDefaultDisplay().getHeight();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/LinkedInActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */