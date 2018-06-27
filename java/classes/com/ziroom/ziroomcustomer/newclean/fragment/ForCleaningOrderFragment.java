package com.ziroom.ziroomcustomer.newclean.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.a;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.e;
import com.ziroom.ziroomcustomer.newclean.b.u;
import com.ziroom.ziroomcustomer.newclean.d.ao;
import com.ziroom.ziroomcustomer.newclean.d.m;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class ForCleaningOrderFragment
  extends BaseFragment
  implements XListView.a
{
  private FragmentActivity a;
  private XListView b;
  private TextView c;
  private u d;
  private List<m> e = new ArrayList();
  private ao f;
  private Bundle g = new Bundle();
  private int h = 1;
  
  private void a(int paramInt)
  {
    String str1 = this.g.getString("uid");
    String str2 = this.g.getString("rentContractCode");
    String str3 = this.g.getString("hireContractCode");
    n.getForCleaningOrderByMonth(getActivity(), str1, str2, str3, "", paramInt, new ForCleaningOrderFragment.1(this, new l(m.class, new a())));
  }
  
  private void a(View paramView)
  {
    this.b = ((XListView)paramView.findViewById(2131694033));
    this.c = ((TextView)paramView.findViewById(2131690175));
  }
  
  private void c()
  {
    this.b.setXListViewListener(this);
    this.b.setPullLoadEnable(true);
    this.b.setPullRefreshEnable(false);
    this.h = 1;
    this.g.putString("uid", getArguments().getString("uid"));
    this.g.putString("rentContractCode", getArguments().getString("rentContractCode"));
    this.g.putString("hireContractCode", getArguments().getString("hireContractCode"));
    this.g.putString("phone", getArguments().getString("phone"));
    this.g.putString("name", getArguments().getString("name"));
    this.g.putString("contractAddress", getArguments().getString("contractAddress"));
    this.d = new u(getActivity(), this.e, this.g);
    this.b.setAdapter(this.d);
    a(1);
  }
  
  private void d()
  {
    this.b.stopRefresh();
    this.b.stopLoadMore();
    this.b.setRefreshTime("刚刚");
  }
  
  public static ForCleaningOrderFragment getInstance(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ForCleaningOrderFragment localForCleaningOrderFragment = new ForCleaningOrderFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("uid", paramString1);
    localBundle.putString("rentContractCode", paramString2);
    localBundle.putString("hireContractCode", paramString3);
    localBundle.putString("phone", paramString4);
    localBundle.putString("name", paramString5);
    localBundle.putString("contractAddress", paramString6);
    localForCleaningOrderFragment.setArguments(localBundle);
    return localForCleaningOrderFragment;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.h = 1;
      this.e.clear();
      this.d.setData(this.e, this.g);
      a(1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903909, paramViewGroup, false);
    this.a = getActivity();
    org.greenrobot.eventbus.c.getDefault().register(this);
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  public void onLoadMore()
  {
    int i = this.h + 1;
    this.h = i;
    a(i);
  }
  
  public void onRefresh() {}
  
  @j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if (e.a.equals(paramc.getType()))
    {
      this.f = ((ao)paramc.getData());
      if (this.f != null)
      {
        this.g.putString("uid", this.f.getUid());
        this.g.putString("rentContractCode", this.f.getRentContractCode());
        this.g.putString("hireContractCode", this.f.getHireContractCode());
        this.g.putString("phone", this.f.getPhone());
        this.g.putString("name", this.f.getName());
        this.g.putString("contractAddress", this.f.getContractAddress());
        this.h = 1;
        this.e.clear();
        this.d.setData(this.e, this.g);
        a(1);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/ForCleaningOrderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */