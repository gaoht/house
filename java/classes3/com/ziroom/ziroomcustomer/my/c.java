package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.ziroomcustomer.gesturelock.GestureLockActivity;
import com.ziroom.ziroomcustomer.util.ad;

public class c
  implements b.a
{
  private b.b a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public c(b.b paramb)
  {
    this.a = paramb;
  }
  
  public void editEmail()
  {
    MobclickAgent.onEvent(this.a.getViewContext(), "click_boundmail");
    a.startBindEmailActivity(this.a.getViewContext());
  }
  
  public void editIntelligenceLockPassword()
  {
    Intent localIntent = new Intent(this.a.getViewContext(), GestureLockActivity.class);
    localIntent.putExtra("from", getClass().getName());
    this.a.getViewContext().startActivity(localIntent);
  }
  
  public void editPassword()
  {
    MobclickAgent.onEvent(this.a.getViewContext(), "change_pass");
    a.startModifyPassActivity(this.a.getViewContext());
  }
  
  public void editTelephone()
  {
    MobclickAgent.onEvent(this.a.getViewContext(), "click_boundphone");
    a.startBindPhoneActivity(this.a.getViewContext());
  }
  
  public void editUserName()
  {
    if (TextUtils.isEmpty(this.e))
    {
      a.startUsernameActivity(this.a.getViewContext());
      return;
    }
    g.textToast(this.a.getViewContext(), this.a.getViewContext().getString(2131297228));
  }
  
  public void updatePhoneEmailUsername()
  {
    a.getUserInfo(this.a.getViewContext(), new a.b()
    {
      public void onUserInfo(e paramAnonymouse)
      {
        if (!c.a(c.this).isActive()) {}
        do
        {
          do
          {
            return;
          } while ((paramAnonymouse == null) || (!c.a(c.this).isActive()));
          c.a(c.this, paramAnonymouse.getString("uid"));
          c.b(c.this, paramAnonymouse.getString("phone"));
          c.c(c.this, paramAnonymouse.getString("email"));
          c.d(c.this, paramAnonymouse.getString("username"));
          if (!TextUtils.isEmpty(c.b(c.this))) {
            c.a(c.this).showTelephone(c.b(c.this));
          }
          if (!TextUtils.isEmpty(c.c(c.this))) {
            c.a(c.this).showEmail(c.c(c.this));
          }
          if (!TextUtils.isEmpty(c.d(c.this))) {
            c.a(c.this).showUserName(c.d(c.this));
          }
        } while (!c.a(c.this).getViewContext().getSharedPreferences("myZiroomState", 0).getBoolean("isFirst_" + c.e(c.this), true));
        ad.isFirstMyZiRoom(c.a(c.this).getViewContext(), false, c.e(c.this));
        a.showFirstBindDialog(c.a(c.this).getViewContext());
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */