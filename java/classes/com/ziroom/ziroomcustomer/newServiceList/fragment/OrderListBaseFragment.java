package com.ziroom.ziroomcustomer.newServiceList.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.newServiceList.a.l;
import com.ziroom.ziroomcustomer.newServiceList.model.bh;
import com.ziroom.ziroomcustomer.newServiceList.model.i;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class OrderListBaseFragment
  extends BaseFragment
  implements XListView.a
{
  public String a = "";
  public Integer b;
  private Context c;
  private XListView d;
  private RelativeLayout e;
  private TextView f;
  private List<Integer> g = new ArrayList();
  private String h = "";
  private List<bh> i = new ArrayList();
  private l j;
  private List<com.ziroom.ziroomcustomer.newServiceList.model.j> k = new ArrayList();
  private List<com.ziroom.ziroomcustomer.newServiceList.model.j> l;
  private int m;
  private boolean n = true;
  private String o = "type_all";
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private ImageView s;
  
  private void a(View paramView)
  {
    this.d = ((XListView)paramView.findViewById(2131691762));
    this.e = ((RelativeLayout)paramView.findViewById(2131690202));
    this.f = ((TextView)paramView.findViewById(2131691096));
    this.s = ((ImageView)paramView.findViewById(2131691095));
  }
  
  private void a(Integer paramInteger1, Integer paramInteger2)
  {
    this.i.clear();
    Object localObject = ApplicationEx.c.getContracts();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Contract localContract = (Contract)((Iterator)localObject).next();
        bh localbh = new bh();
        localbh.setHouseSourceCode(localContract.getHouse_code());
        localbh.setRentTimeBegin(localContract.getEffect_date());
        localbh.setRentTimeEnd(localContract.getStop_date());
        this.i.add(localbh);
      }
    }
    if (ApplicationEx.c.getUser() == null)
    {
      g.textToast(this.c, "您已在其他设备登录，请退出当前页面，重新登录");
      return;
    }
    n.getGataWayServiceList(this.c, paramInteger1, paramInteger2, this.g, this.i, new OrderListBaseFragment.1(this, this.c, new e(com.ziroom.ziroomcustomer.newServiceList.model.j.class), paramInteger2));
  }
  
  private void c()
  {
    if ((!this.q) || (!this.r)) {
      return;
    }
    if (!TextUtils.isEmpty(this.h)) {
      this.o = this.h;
    }
    e();
  }
  
  private void d()
  {
    this.q = true;
    this.h = getArguments().getString("order_bus_type");
    c();
    this.d.setPullLoadEnable(false);
    this.d.setPullRefreshEnable(true);
    this.d.setXListViewListener(this);
    this.j = new l(this.c, this.k);
    this.d.setAdapter(this.j);
  }
  
  private void e()
  {
    if (this.d != null) {
      this.d.setPullLoadEnable(false);
    }
    this.m = 1;
    this.k.clear();
    if (this.j != null) {
      this.j.notifyDataSetChanged();
    }
    getOrderType(Integer.valueOf(1));
  }
  
  private void f()
  {
    this.d.stopRefresh();
    this.d.stopLoadMore();
    this.d.setRefreshTime("刚刚");
  }
  
  public void getOrderType(Integer paramInteger)
  {
    this.g.clear();
    if ("type_clean".equals(this.o))
    {
      this.s.setBackgroundResource(2130840035);
      this.f.setText("您暂时没有保洁订单");
      this.g.add(Integer.valueOf(1000));
      this.g.add(Integer.valueOf(1100));
      this.g.add(Integer.valueOf(1200));
      this.g.add(Integer.valueOf(1101));
    }
    for (;;)
    {
      a(this.b, paramInteger);
      return;
      if ("type_move".equals(this.o))
      {
        this.s.setBackgroundResource(2130840402);
        this.f.setText("您暂时没有搬家订单");
        this.g.add(Integer.valueOf(1001));
        this.g.add(Integer.valueOf(1301));
      }
      else if ("type_repair".equals(this.o))
      {
        this.s.setBackgroundResource(2130840422);
        this.f.setText("您暂时没有维修订单");
        this.g.add(Integer.valueOf(1002));
      }
      else if ("type_youpin".equals(this.o))
      {
        this.s.setBackgroundResource(2130840442);
        this.f.setText("您暂时没有优品订单");
        this.g.add(Integer.valueOf(1003));
      }
      else if ("type_zuzhu".equals(this.o))
      {
        this.s.setBackgroundResource(2130840036);
        this.f.setText("您暂时没有租住订单");
        this.g.add(Integer.valueOf(1004));
      }
      else if ("type_all".equals(this.o))
      {
        this.s.setBackgroundResource(2130840420);
        this.f.setText("您暂时没有订单");
        this.g.add(Integer.valueOf(1000));
        this.g.add(Integer.valueOf(1100));
        this.g.add(Integer.valueOf(1001));
        this.g.add(Integer.valueOf(1002));
        this.g.add(Integer.valueOf(1003));
        this.g.add(Integer.valueOf(1004));
        this.g.add(Integer.valueOf(1200));
        this.g.add(Integer.valueOf(1101));
        this.g.add(Integer.valueOf(1301));
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903983, paramViewGroup, false);
    this.c = getActivity();
    org.greenrobot.eventbus.c.getDefault().register(this);
    a(paramLayoutInflater);
    d();
    return paramLayoutInflater;
  }
  
  public void onLoadMore()
  {
    int i1 = this.m + 1;
    this.m = i1;
    getOrderType(Integer.valueOf(i1));
  }
  
  public void onRefresh()
  {
    e();
    org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("service_orderlist_refresh_order_num", null));
  }
  
  @org.greenrobot.eventbus.j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if ("service_orderlist_typename".equals(paramc.getType()))
    {
      u.d("service_orderlist_typename", "======dd  service_orderlist_typename success");
      paramc = (i)paramc.getData();
      this.h = paramc.getOrderTypeName();
      paramc = paramc.getOrderStatusName();
      this.m = 1;
      this.p = false;
      this.k.clear();
      if (this.j != null) {
        this.j.notifyDataSetChanged();
      }
      if (this.a.equals(paramc))
      {
        this.o = this.h;
        getOrderType(Integer.valueOf(1));
      }
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    u.d("setUserVisibleHint", "======setUserVisibleHint 111");
    if (paramBoolean)
    {
      this.r = true;
      if (!this.n) {
        break label40;
      }
      this.n = false;
      c();
    }
    label40:
    do
    {
      do
      {
        return;
        u.d("sdgklsdjg", "=====  orderTypeName=" + this.h + "    orderFristName==" + this.o);
      } while (TextUtils.isEmpty(this.h));
      if (!this.o.equals(this.h))
      {
        this.o = this.h;
        e();
        return;
      }
    } while ((this.p) || (this.k.size() != 0));
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/fragment/OrderListBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */