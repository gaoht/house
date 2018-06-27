package com.ziroom.ziroomcustomer.activity;

import android.os.Bundle;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.morepage.MoreItemView;
import com.ziroom.ziroomcustomer.morepage.MoreItemView.b;

public class ZiroomServerAcitivity
  extends BaseActivity
{
  private MoreItemView a;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904941);
    this.a = ((MoreItemView)findViewById(2131692134));
    this.a.setTitle("");
    this.a.setWeb("file:///android_asset/more/jiangfu.html");
    this.a.setBack(new MoreItemView.b()
    {
      public void backtoActivity() {}
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/ZiroomServerAcitivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */