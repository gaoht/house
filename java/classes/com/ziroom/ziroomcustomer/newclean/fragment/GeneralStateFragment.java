package com.ziroom.ziroomcustomer.newclean.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.a;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.b.w;
import com.ziroom.ziroomcustomer.newclean.d.av;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class GeneralStateFragment
  extends BaseFragment
{
  private PullToRefreshScrollView a;
  private ListViewForScrollView b;
  private String c;
  private FragmentActivity d;
  private List<av> e = new ArrayList();
  private w f;
  private SimpleDraweeView g;
  
  private void a(View paramView)
  {
    this.a = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.b = ((ListViewForScrollView)paramView.findViewById(2131691763));
    this.g = ((SimpleDraweeView)paramView.findViewById(2131691764));
    this.g.setController(com.freelxl.baselibrary.f.c.frescoController("http://image.ziroom.com/g2/M00/6E/34/ChAFD1m6PJ-AE59ZAACPrWLB7gA932.jpg"));
    this.g.setOnClickListener(new GeneralStateFragment.1(this));
    paramView = paramView.findViewById(2131690279);
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    paramView.requestFocus();
    paramView.requestFocusFromTouch();
  }
  
  private void c()
  {
    org.greenrobot.eventbus.c.getDefault().register(this);
    this.c = getArguments().getString("orderId");
    this.a.setMode(PullToRefreshBase.b.b);
    this.a.setOnRefreshListener(new GeneralStateFragment.2(this));
    d();
  }
  
  private void d()
  {
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    n.getGeneralOrderState(this.d, this.c, new GeneralStateFragment.3(this, new l(av.class, new a())));
  }
  
  private void e()
  {
    if ((this.a != null) && (this.a.isRefreshing())) {
      this.a.onRefreshComplete();
    }
  }
  
  public static GeneralStateFragment getInstance(String paramString)
  {
    GeneralStateFragment localGeneralStateFragment = new GeneralStateFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString);
    localGeneralStateFragment.setArguments(localBundle);
    return localGeneralStateFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903911, paramViewGroup, false);
    this.d = getActivity();
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
    if ("general_detail_refresh".equals(paramc.getType()))
    {
      u.d("general_refresh", "======  general_detail_refresh success");
      d();
    }
    if ("general_button_refresh_cancle".equals(paramc.getType()))
    {
      u.d("general_button_refresh_cancle", "======  general_button_refresh_cancle success");
      d();
    }
    if ("general_button_refresh_state".equals(paramc.getType())) {
      d();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/GeneralStateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */