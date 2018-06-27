package com.ziroom.ziroomcustomer.my.aboutus;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.update.UpdateObject;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil.NeedOtherCheckUpdate;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil.UpdateListener;
import com.ziroom.ziroomcustomer.newchat.chatcenter.ChatCenterActivity;
import java.lang.ref.WeakReference;

public class b
  implements a.a
{
  WeakReference<a.b> a;
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (getView() != null) {
      getView().setPresenter(this);
    }
  }
  
  public void checkUpdate()
  {
    UpdateUtil.getInstance().checkUpdate(getView().getViewContext(), true);
    UpdateUtil.getInstance().setNeedOtherCheckUpdate(new UpdateUtil.NeedOtherCheckUpdate()
    {
      public void checkUpdate()
      {
        new com.ziroom.ziroomcustomer.f.a(b.this.getView().getViewContext()).checkPgyUpdate(true);
      }
    });
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public String getAppVersion()
  {
    Object localObject = getView().getViewContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(getView().getViewContext().getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public a.b getView()
  {
    if (this.a != null) {
      return (a.b)this.a.get();
    }
    return null;
  }
  
  public void initData()
  {
    getView().showCurrVersion(getAppVersion());
    UpdateUtil.getInstance().checkUpdate(getView().getViewContext(), new UpdateUtil.UpdateListener()
    {
      public void onDealUpdate(UpdateObject paramAnonymousUpdateObject)
      {
        if (paramAnonymousUpdateObject.getUpgradeType() == 0)
        {
          b.this.getView().showUpdate(false);
          return;
        }
        b.this.getView().showUpdate(true);
      }
    });
    UpdateUtil.getInstance().setNeedOtherCheckUpdate(new UpdateUtil.NeedOtherCheckUpdate()
    {
      public void checkUpdate()
      {
        new com.ziroom.ziroomcustomer.f.a(b.this.getView().getViewContext()).checkPgyUpdate(new com.ziroom.ziroomcustomer.f.a.a()
        {
          public void onNoUpdateAvailable()
          {
            b.this.getView().showUpdate(false);
          }
          
          public void onUpdateAvailable(String paramAnonymous2String)
          {
            b.this.getView().showUpdate(true);
          }
        });
      }
    });
  }
  
  public void start() {}
  
  public void toServiceAndHelp()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(getView().getViewContext());
      return;
    }
    Intent localIntent = new Intent(getView().getViewContext(), ChatCenterActivity.class);
    getView().getViewContext().startActivity(localIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/aboutus/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */