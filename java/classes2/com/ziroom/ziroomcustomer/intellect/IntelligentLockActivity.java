package com.ziroom.ziroomcustomer.intellect;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.u;

public class IntelligentLockActivity
  extends BaseActivity
{
  private Context a;
  private Unbinder b;
  @BindView(2131690994)
  LinearLayout intellect_ll_point;
  @BindView(2131690993)
  ViewPager intellect_vp;
  @BindView(2131690992)
  RelativeLayout rl_vp;
  @BindView(2131690990)
  TextView tv_lockInfo_contractName;
  @BindView(2131689977)
  TextView tv_lockInfo_roomName;
  
  private void a()
  {
    b();
  }
  
  private void b()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    n.getLockRoomInfo(this.a, localUserInfo.getUid(), new f(this.a, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.e("dsfdsg", "========   " + com.alibaba.fastjson.a.toJSONString(paramAnonymouse));
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903223);
    this.a = this;
    this.b = ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/intellect/IntelligentLockActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */