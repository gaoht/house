package com.ziroom.ziroomcustomer.bestgoods.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.bestgoods.a.af;
import com.ziroom.ziroomcustomer.bestgoods.a.al;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinOrderDetailsActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinOrderDetailsActivity.a;
import com.ziroom.ziroomcustomer.bestgoods.model.ao;
import com.ziroom.ziroomcustomer.bestgoods.model.ao.c;
import com.ziroom.ziroomcustomer.bestgoods.model.ao.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import java.util.List;

public class YouPinOrderProgressFragment
  extends BaseFragment
  implements YouPinOrderDetailsActivity.a
{
  private PullToRefreshScrollView a;
  private TextView b;
  private ListViewForScrollView c;
  private View d;
  private TextView e;
  private ListViewForScrollView f;
  private YouPinOrderDetailsActivity g;
  private ao h;
  private List<ao.d> i;
  private List<ao.c> j;
  
  private void a(View paramView)
  {
    this.a = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.b = ((TextView)paramView.findViewById(2131694394));
    this.c = ((ListViewForScrollView)paramView.findViewById(2131694395));
    this.d = paramView.findViewById(2131694396);
    this.e = ((TextView)paramView.findViewById(2131694397));
    this.f = ((ListViewForScrollView)paramView.findViewById(2131694398));
  }
  
  private void c()
  {
    this.a.setMode(PullToRefreshBase.b.b);
    this.a.setOnRefreshListener(new PullToRefreshBase.d()
    {
      public void onRefresh(PullToRefreshBase<ScrollView> paramAnonymousPullToRefreshBase)
      {
        YouPinOrderProgressFragment.a(YouPinOrderProgressFragment.this).getServerData();
      }
    });
  }
  
  private void d()
  {
    if ((this.a != null) && (this.a.isRefreshing())) {
      this.a.onRefreshComplete();
    }
  }
  
  public static YouPinOrderProgressFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    YouPinOrderProgressFragment localYouPinOrderProgressFragment = new YouPinOrderProgressFragment();
    localYouPinOrderProgressFragment.setArguments(localBundle);
    return localYouPinOrderProgressFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903995, null);
    this.g = ((YouPinOrderDetailsActivity)getActivity());
    this.g.addOnYouPinOrderDetailsDataListener(this);
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  public void onYpDetailsData(ao paramao)
  {
    d();
    this.h = paramao;
    if (this.h == null) {
      return;
    }
    this.i = this.h.getRecords();
    if ((this.i == null) || (this.i.size() == 0))
    {
      this.e.setVisibility(8);
      this.f.setVisibility(8);
    }
    for (;;)
    {
      this.j = this.h.getLogistics();
      if ((this.j != null) && (this.j.size() != 0)) {
        break;
      }
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      return;
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      paramao = new al(this.g, this.i);
      this.f.setAdapter(paramao);
    }
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    paramao = new af(this.g, this.j);
    this.c.setAdapter(paramao);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/fragment/YouPinOrderProgressFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */