package com.ziroom.ziroomcustomer.newclean.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.a;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.e;
import com.ziroom.ziroomcustomer.newclean.b.t;
import com.ziroom.ziroomcustomer.newclean.d.ao;
import com.ziroom.ziroomcustomer.newclean.d.k;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class ForCleaningEvalFragment
  extends BaseFragment
{
  private FragmentActivity a;
  private List<k> b = new ArrayList();
  private String c;
  private t d;
  @BindView(2131693955)
  ListViewForScrollView mLvEval;
  @BindView(2131690175)
  TextView mTvNoData;
  @BindView(2131693956)
  TextView mTvToAll;
  
  private void c()
  {
    this.c = getArguments().getString("cleanerId");
    this.d = new t(getActivity(), this.b);
    this.mLvEval.setAdapter(this.d);
    e();
  }
  
  private void d()
  {
    this.mTvToAll.setOnClickListener(new ForCleaningEvalFragment.1(this));
  }
  
  private void e()
  {
    n.getBiweeklyCleanerBestEvalList(getActivity(), this.c, new ForCleaningEvalFragment.2(this, new l(k.class, new a())));
  }
  
  public static ForCleaningEvalFragment getInstance(String paramString)
  {
    ForCleaningEvalFragment localForCleaningEvalFragment = new ForCleaningEvalFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("cleanerId", paramString);
    localForCleaningEvalFragment.setArguments(localBundle);
    return localForCleaningEvalFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903908, paramViewGroup, false);
    this.a = getActivity();
    ButterKnife.bind(this, paramLayoutInflater);
    org.greenrobot.eventbus.c.getDefault().register(this);
    c();
    d();
    return paramLayoutInflater;
  }
  
  @j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if (e.a.equals(paramc.getType()))
    {
      paramc = (ao)paramc.getData();
      if (paramc != null)
      {
        this.c = paramc.getCleanerId();
        e();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/ForCleaningEvalFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */