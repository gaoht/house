package com.ziroom.ziroomcustomer.ziroomstation.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.k;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationHotelProjectDto;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import com.ziroom.ziroomcustomer.ziroomstation.utils.j;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StationHotelFragment
  extends BaseFragment
  implements XListView.a
{
  public boolean a = false;
  private XListView b;
  private k c;
  private List<StationHotelProjectDto> d;
  private ViewPager e;
  private j f;
  private LinearLayout g;
  private List<View> h = new ArrayList();
  private List<String> i = new ArrayList();
  
  private void a(View paramView)
  {
    this.e = ((ViewPager)paramView.findViewById(2131690262));
    this.g = ((LinearLayout)paramView.findViewById(2131694368));
    this.h.add(paramView.findViewById(2131694369));
    this.f = new j(this.e, this.i, this.h);
    this.b.setAdapter(this.c);
    this.b.setPullLoadEnable(false);
    this.b.setPullRefreshEnable(true);
    this.b.setXListViewListener(this);
  }
  
  private void c()
  {
    this.d = new ArrayList();
    int j = 0;
    while (j < 4)
    {
      StationHotelProjectDto localStationHotelProjectDto = new StationHotelProjectDto();
      localStationHotelProjectDto.minPrice = "¥100起";
      localStationHotelProjectDto.projectName = "自如驿1号";
      localStationHotelProjectDto.projectAddress = "北京市朝阳区将台路链家总部16号院4层自如中心";
      this.d.add(localStationHotelProjectDto);
      j += 1;
    }
  }
  
  private void d()
  {
    this.b.stopRefresh();
    this.b.stopLoadMore();
    this.b.setRefreshTime(new Date().toLocaleString());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Log.d("StationHotelFragment", "onCreateView");
    paramLayoutInflater = paramLayoutInflater.inflate(2130903990, paramViewGroup, false);
    this.b = ((XListView)paramLayoutInflater.findViewById(2131692015));
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.f.onDestory();
    super.onDestroy();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    d();
  }
  
  public void onStart()
  {
    this.f.onStart();
    super.onStart();
  }
  
  public void onStop()
  {
    this.f.onStop();
    super.onStop();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    Log.d("StationHotelFragment", "isVisibleToUser" + paramBoolean);
    this.a = paramBoolean;
    if ((paramBoolean) && (!i.isLegal(this.d))) {
      c();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/fragment/StationHotelFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */