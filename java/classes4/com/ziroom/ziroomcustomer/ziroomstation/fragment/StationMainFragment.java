package com.ziroom.ziroomcustomer.ziroomstation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.ziroomstation.ZiroomStationMainActivity;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.a;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationMainFragment
  extends BaseFragment
  implements View.OnClickListener
{
  List<Integer> a = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2130838514), Integer.valueOf(2130838514), Integer.valueOf(2130838514), Integer.valueOf(2130838514), Integer.valueOf(2130838514), Integer.valueOf(2130838514), Integer.valueOf(2130838514), Integer.valueOf(2130838514), Integer.valueOf(2130838514) }));
  private TextView b;
  private RecyclerView c;
  private RecyclerView d;
  
  private void a(View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131691258));
    this.b.setOnClickListener(this);
    this.c = ((RecyclerView)paramView.findViewById(2131694366));
    this.d = ((RecyclerView)paramView.findViewById(2131694367));
    paramView = new LinearLayoutManager(getActivity());
    paramView.setOrientation(0);
    this.c.setLayoutManager(paramView);
    paramView = new a(getActivity(), this.a);
    this.c.setAdapter(paramView);
    paramView.setOnItemClickLitener(new a.a()
    {
      public void onItemClick(View paramAnonymousView, int paramAnonymousInt)
      {
        g.textToast(StationMainFragment.this.getActivity(), paramAnonymousInt + "");
      }
    });
    paramView = new LinearLayoutManager(getActivity());
    paramView.setOrientation(0);
    this.d.setLayoutManager(paramView);
    paramView = new a(getActivity(), this.a);
    this.d.setAdapter(paramView);
    paramView.setOnItemClickLitener(new a.a()
    {
      public void onItemClick(View paramAnonymousView, int paramAnonymousInt)
      {
        g.textToast(StationMainFragment.this.getActivity(), paramAnonymousInt + "");
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(getActivity(), ZiroomStationMainActivity.class);
    getActivity().startActivity(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903988, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/fragment/StationMainFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */