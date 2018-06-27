package com.ziroom.ziroomcustomer.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.activity.LeaseActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.life.ZirukeDetailActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.morepage.MorePageActivity;
import com.ziroom.ziroomcustomer.my.ServiceOrderActivity;
import com.ziroom.ziroomcustomer.util.u;

public class MenuFragment
  extends BaseFragment
  implements View.OnClickListener
{
  protected boolean a;
  private Context b;
  private TextView c;
  private UserInfo d;
  private Intent e;
  private DrawerLayout f;
  private TextView g;
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131694476: 
    case 2131694479: 
    case 2131694480: 
    case 2131694481: 
    case 2131694482: 
    case 2131694484: 
    case 2131694485: 
    case 2131694487: 
    case 2131694493: 
    default: 
      return;
    case 2131694477: 
      this.f.closeDrawer(8388611);
      return;
    case 2131694483: 
      this.f.closeDrawer(8388611);
      if (this.a)
      {
        this.e = new Intent(this.b, LeaseActivity.class);
        startActivity(this.e);
        return;
      }
      a.startLoginActivity(this.b);
      return;
    case 2131694486: 
      this.f.closeDrawer(8388611);
      if (this.a)
      {
        this.e = new Intent(this.b, ServiceOrderActivity.class);
        startActivity(this.e);
        return;
      }
      a.startLoginActivity(this.b);
      return;
    case 2131694492: 
      this.f.closeDrawer(8388611);
      this.e = new Intent(this.b, MorePageActivity.class);
      startActivity(this.e);
      return;
    case 2131694489: 
      this.f.closeDrawer(8388611);
      ((MainFragmentActivity)this.b).switchCurrentFragment(0);
      return;
    case 2131694488: 
      this.f.closeDrawer(8388611);
      ((MainFragmentActivity)this.b).switchCurrentFragment(1);
      return;
    case 2131694478: 
      this.f.closeDrawer(8388611);
      this.e = new Intent(this.b, MainActivity.class);
      this.e.putExtra("MyZiroom", "MyZiroom");
      startActivity(this.e);
      return;
    case 2131694490: 
      this.f.closeDrawer(8388611);
      ((MainFragmentActivity)this.b).switchCurrentFragment(3);
      return;
    }
    this.f.closeDrawer(8388611);
    this.e = new Intent(this.b, ZirukeDetailActivity.class);
    this.e.putExtra("url", "http://www.ziroom.com/zhuanti/zrzk/index.html");
    this.e.putExtra("title", "自如客");
    startActivity(this.e);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    u.e("onResume", "menu  onResume");
    super.onResume();
  }
  
  public void updateHead()
  {
    this.a = ApplicationEx.c.isLoginState();
    if (this.a) {
      this.g.setVisibility(8);
    }
    for (;;)
    {
      this.d = ApplicationEx.c.getUser();
      if (this.d == null) {
        break label102;
      }
      String str = this.d.getUser_name();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      this.c.setText(str);
      return;
      this.g.setVisibility(0);
      this.c.setText("");
    }
    this.c.setText(this.d.getLogin_name_mobile());
    return;
    label102:
    this.c.setText("");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/MenuFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */