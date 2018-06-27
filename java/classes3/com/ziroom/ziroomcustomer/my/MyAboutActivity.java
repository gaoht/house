package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil.NeedOtherCheckUpdate;
import com.ziroom.ziroomcustomer.newchat.chatcenter.ChatCenterActivity;

public class MyAboutActivity
  extends BaseActivity
{
  private Unbinder a;
  @BindView(2131691818)
  TextView mTvVersion;
  
  public String getAppVersion()
  {
    Object localObject = getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903364);
    this.a = ButterKnife.bind(this);
    this.mTvVersion.setText(getAppVersion());
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131690693, 2131691819, 2131689895})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690693: 
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this);
        return;
      }
      startActivity(new Intent(this, ChatCenterActivity.class));
      return;
    case 2131691819: 
      UpdateUtil.getInstance().checkUpdate(this, true);
      UpdateUtil.getInstance().setNeedOtherCheckUpdate(new UpdateUtil.NeedOtherCheckUpdate()
      {
        public void checkUpdate()
        {
          new com.ziroom.ziroomcustomer.f.a(MyAboutActivity.this).checkPgyUpdate(true);
        }
      });
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAboutActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */