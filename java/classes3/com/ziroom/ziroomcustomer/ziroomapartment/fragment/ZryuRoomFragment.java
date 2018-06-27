package com.ziroom.ziroomcustomer.ziroomapartment.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuProjectDetailActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.adapter.h;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel.DataBean.HouseTypeListBean;
import java.util.List;

public class ZryuRoomFragment
  extends BaseFragment
  implements View.OnClickListener
{
  public List<ZryuHouseTypeListModel.DataBean.HouseTypeListBean> a;
  public boolean b = false;
  private XListView c;
  private RelativeLayout d;
  private TextView e;
  private h f;
  private RelativeLayout g;
  private ZryuProjectDetailActivity h;
  
  private void a(View paramView)
  {
    this.d = ((RelativeLayout)paramView.findViewById(2131692929));
    this.e = ((TextView)paramView.findViewById(2131692930));
    this.g = ((RelativeLayout)paramView.findViewById(2131694400));
    this.g.setOnClickListener(this);
    this.c = ((XListView)paramView.findViewById(2131693954));
    this.f = new h(this.h, null);
    this.c.setAdapter(this.f);
    this.c.setPullLoadEnable(false);
    this.c.setPullRefreshEnable(false);
    if ((this.h.b != null) && (this.h.b.data != null) && (this.h.b.data.houseTypeList != null)) {
      setData(this.h.b);
    }
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
    this.h.toFilterPage();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Log.d("ZryuRoomFragment", "onCreateView");
    this.h = ((ZryuProjectDetailActivity)getActivity());
    paramLayoutInflater = paramLayoutInflater.inflate(2130903997, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    a("zinn_detail_room_duration");
    super.onResume();
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.c != null)) {
      this.c.setSelection(0);
    }
  }
  
  public void setData(ZryuHouseTypeListModel paramZryuHouseTypeListModel)
  {
    this.a = paramZryuHouseTypeListModel.data.houseTypeList;
    if ("0".equals(paramZryuHouseTypeListModel.data.ifSearchSuc))
    {
      this.d.setVisibility(0);
      this.e.setText(paramZryuHouseTypeListModel.data.searchFailMsg);
    }
    for (;;)
    {
      this.f.setData(this.a);
      return;
      this.d.setVisibility(8);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    Log.d("ZryuRoomFragment", "isVisibleToUser" + paramBoolean);
    this.b = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/fragment/ZryuRoomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */