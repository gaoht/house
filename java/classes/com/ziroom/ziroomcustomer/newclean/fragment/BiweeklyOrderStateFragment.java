package com.ziroom.ziroomcustomer.newclean.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.a;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.b.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class BiweeklyOrderStateFragment
  extends BaseFragment
{
  private ListViewForScrollView a;
  private PullToRefreshScrollView b;
  private d c;
  private String d;
  private FragmentActivity e;
  private String f;
  
  private void a(View paramView)
  {
    this.a = ((ListViewForScrollView)paramView.findViewById(2131691763));
    this.b = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
  }
  
  private void c()
  {
    u.d("dsljgl", "========== initDate ");
    this.f = getArguments().getString("orderId");
    this.b.setMode(PullToRefreshBase.b.b);
    this.b.setOnRefreshListener(new BiweeklyOrderStateFragment.1(this));
    d();
  }
  
  private void d()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    this.d = localUserInfo.getUid();
    n.getBiweeklyCleanOrderState(this.e, this.d, this.f, new BiweeklyOrderStateFragment.2(this, new com.ziroom.ziroomcustomer.e.c.l(com.ziroom.ziroomcustomer.newclean.d.l.class, new a())));
  }
  
  private void e()
  {
    if ((this.b != null) && (this.b.isRefreshing())) {
      this.b.onRefreshComplete();
    }
  }
  
  public static BiweeklyOrderStateFragment getInstance(String paramString)
  {
    BiweeklyOrderStateFragment localBiweeklyOrderStateFragment = new BiweeklyOrderStateFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString);
    localBiweeklyOrderStateFragment.setArguments(localBundle);
    return localBiweeklyOrderStateFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903974, paramViewGroup, false);
    this.e = getActivity();
    org.greenrobot.eventbus.c.getDefault().register(this);
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  @j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if ("biweekly_fragment_state_refresh".equals(paramc.getType())) {
      d();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiweeklyOrderStateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */