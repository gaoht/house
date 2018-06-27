package com.ziroom.ziroomcustomer.newclean.periodclean.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.newclean.d.av;
import com.ziroom.ziroomcustomer.newclean.periodclean.a;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralStatusBean;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class PeriodGeneralStateFragment
  extends BaseFragment
{
  private PullToRefreshScrollView a;
  private ListViewForScrollView b;
  private String c;
  private FragmentActivity d;
  private List<av> e = new ArrayList();
  private com.ziroom.ziroomcustomer.newclean.periodclean.a.e f;
  
  private void a(View paramView)
  {
    this.a = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.b = ((ListViewForScrollView)paramView.findViewById(2131691763));
  }
  
  private void c()
  {
    this.c = getArguments().getString("orderId");
    this.a.setMode(PullToRefreshBase.b.b);
    this.a.setOnRefreshListener(new PeriodGeneralStateFragment.1(this));
    d();
  }
  
  private void d()
  {
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    a.getPeriodGeneralStatusInfo(this.d, this.c, new PeriodGeneralStateFragment.2(this, this.d, new com.ziroom.ziroomcustomer.e.c.e(PeriodGeneralStatusBean.class)));
  }
  
  private void e()
  {
    if ((this.a != null) && (this.a.isRefreshing())) {
      this.a.onRefreshComplete();
    }
  }
  
  public static PeriodGeneralStateFragment getInstance(String paramString)
  {
    PeriodGeneralStateFragment localPeriodGeneralStateFragment = new PeriodGeneralStateFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString);
    localPeriodGeneralStateFragment.setArguments(localBundle);
    return localPeriodGeneralStateFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903911, paramViewGroup, false);
    this.d = getActivity();
    org.greenrobot.eventbus.c.getDefault().register(this);
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    org.greenrobot.eventbus.c.getDefault().unregister(this);
  }
  
  @j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if ("period_general_detail_refresh".equals(paramc.getType()))
    {
      u.d("general_refresh", "======  period_general_detail_refresh success");
      d();
    }
    if ("period_general_button_refresh_cancle".equals(paramc.getType()))
    {
      u.d("general_button_refresh_cancle", "======  period_general_button_refresh_cancle success");
      d();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/fragment/PeriodGeneralStateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */