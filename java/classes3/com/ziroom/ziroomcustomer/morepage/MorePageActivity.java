package com.ziroom.ziroomcustomer.morepage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.AboutServerAcitivity;
import com.ziroom.ziroomcustomer.activity.AboutZiroomYuAcitivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.f.a;
import com.ziroom.ziroomcustomer.my.SettingItemView;
import com.ziroom.ziroomcustomer.my.SettingItemView.a;

public class MorePageActivity
  extends BaseActivity
{
  private SettingItemView a;
  private SettingItemView b;
  private SettingItemView c;
  private SettingItemView d;
  private TextView e;
  private Context f;
  
  private void a()
  {
    this.a = ((SettingItemView)findViewById(2131696921));
    this.b = ((SettingItemView)findViewById(2131696922));
    this.c = ((SettingItemView)findViewById(2131696923));
    this.d = ((SettingItemView)findViewById(2131696924));
    this.e = ((TextView)findViewById(2131696925));
    this.e.setText(getAppVersion());
    b();
    findViewById(2131696920).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MorePageActivity.this.finish();
      }
    });
  }
  
  private void b()
  {
    this.a.setOnclick(this, ZiroomHomeAcitivity.class, "2more_ziruyoujia");
    this.b.setOnclick(this, AboutZiroomYuAcitivity.class, "2more_ziruyouyu");
    this.c.setOnclick(this, AboutServerAcitivity.class, "2more_ziruserver");
    this.d.setOnclick(new SettingItemView.a()
    {
      public void mMethod()
      {
        new a(MorePageActivity.this).checkPgyUpdate(false);
      }
    });
  }
  
  public String getAppVersion()
  {
    Object localObject = this.f.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(this.f.getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904939);
    this.f = this;
    a();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/morepage/MorePageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */