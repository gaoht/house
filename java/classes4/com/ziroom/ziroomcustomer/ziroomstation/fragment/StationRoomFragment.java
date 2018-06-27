package com.ziroom.ziroomcustomer.ziroomstation.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import com.ziroom.ziroomcustomer.ziroomstation.ProjectDetailActivity;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.b.c;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoom;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class StationRoomFragment
  extends BaseFragment
  implements XListView.a
{
  public StationRoom a;
  public boolean b = false;
  private XListView c;
  private com.ziroom.ziroomcustomer.ziroomstation.adapter.m d;
  private ProjectDetailActivity e;
  
  private void c()
  {
    this.a = new StationRoom();
    this.d = new com.ziroom.ziroomcustomer.ziroomstation.adapter.m(this.e, this.a.data, this.e);
    this.c.setAdapter(this.d);
    this.c.setPullLoadEnable(false);
    this.c.setPullRefreshEnable(false);
    this.c.setXListViewListener(this);
  }
  
  private void d()
  {
    this.c.stopRefresh();
    this.c.stopLoadMore();
    this.c.setRefreshTime(new Date().toLocaleString());
  }
  
  public void initData()
  {
    if (this.e != null) {
      this.e = ((ProjectDetailActivity)getActivity());
    }
    if (BaseActivity.checkNet(this.e))
    {
      Map localMap = b.buildStationRooms(this.e, this.e.a, com.ziroom.ziroomcustomer.util.m.getFormatDate(new Date(this.e.c.getTimeInMillis()), com.ziroom.ziroomcustomer.util.m.b), com.ziroom.ziroomcustomer.util.m.getFormatDate(new Date(this.e.d.getTimeInMillis()), com.ziroom.ziroomcustomer.util.m.b));
      c.getStationRoomList(this.e, localMap, new b(null), true);
      return;
    }
    af.showToast(this.e, "网络请求失败，请检查您的网络设置");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Log.d("StationRoomFragment", "onCreateView");
    this.e = ((ProjectDetailActivity)getActivity());
    paramLayoutInflater = paramLayoutInflater.inflate(2130903991, paramViewGroup, false);
    this.c = ((XListView)paramLayoutInflater.findViewById(2131693954));
    c();
    return paramLayoutInflater;
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    initData();
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
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    Log.d("StationRoomFragment", "isVisibleToUser" + paramBoolean);
    this.b = paramBoolean;
    if ((paramBoolean) && (!i.isLegal(this.a.data))) {
      initData();
    }
  }
  
  public static abstract interface a
  {
    public abstract void numChange(int paramInt1, int paramInt2);
  }
  
  private class b
    implements i.a<String>
  {
    private b() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        StationRoomFragment.this.a = ((StationRoom)paramk.getObject());
        d.i("HttpResult code:", Integer.valueOf(StationRoomFragment.this.a.error_code));
        StationRoomFragment.a(StationRoomFragment.this).setData(StationRoomFragment.this.a.data);
      }
      for (;;)
      {
        StationRoomFragment.b(StationRoomFragment.this).initPricesDetail(StationRoomFragment.this.a);
        StationRoomFragment.c(StationRoomFragment.this);
        return;
        d.i("HttpResult :", "ro failed");
        af.showToast(StationRoomFragment.b(StationRoomFragment.this), "获取驿房间列表失败:" + StationRoomFragment.this.a.error_message);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/fragment/StationRoomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */