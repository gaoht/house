package com.ziroom.ziroomcustomer.newmovehouse.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.a;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.d.av;
import com.ziroom.ziroomcustomer.newmovehouse.b.g;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class MoveSmallStateFragment
  extends BaseFragment
{
  private PullToRefreshScrollView a;
  private ListViewForScrollView b;
  private String c;
  private FragmentActivity d;
  private List<av> e = new ArrayList();
  private g f;
  
  private void a(View paramView)
  {
    this.a = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.b = ((ListViewForScrollView)paramView.findViewById(2131691763));
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
    this.a.setOnRefreshListener(new MoveSmallStateFragment.1(this));
    d();
  }
  
  private void d()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    n.getMoveOrderState(this.d, this.c, (String)localObject, new MoveSmallStateFragment.2(this, new l(av.class, new a())));
  }
  
  private void e()
  {
    if ((this.a != null) && (this.a.isRefreshing())) {
      this.a.onRefreshComplete();
    }
  }
  
  public static MoveSmallStateFragment getInstance(String paramString)
  {
    MoveSmallStateFragment localMoveSmallStateFragment = new MoveSmallStateFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString);
    localMoveSmallStateFragment.setArguments(localBundle);
    return localMoveSmallStateFragment;
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
    if ("move_small_detail_refresh".equals(paramc.getType())) {
      d();
    }
    if ("move_small_button_refresh_cancle".equals(paramc.getType())) {
      d();
    }
    if ("move_small_button_refresh_state".equals(paramc.getType())) {
      d();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/fragment/MoveSmallStateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */