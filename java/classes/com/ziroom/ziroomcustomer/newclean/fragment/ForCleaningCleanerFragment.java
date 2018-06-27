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
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.e;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.ao;
import com.ziroom.ziroomcustomer.newclean.d.i;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class ForCleaningCleanerFragment
  extends BaseFragment
{
  private FragmentActivity a;
  private String b;
  private List<i> c = new ArrayList();
  private com.ziroom.ziroomcustomer.newclean.b.c d;
  @BindView(2131690332)
  FlowLayout mFlLike;
  @BindView(2131693958)
  MyGridView mGvIdent;
  @BindView(2131690052)
  TextView mTvAge;
  @BindView(2131693963)
  TextView mTvConstellation;
  @BindView(2131694031)
  TextView mTvFlkeTag;
  @BindView(2131693964)
  TextView mTvFond;
  @BindView(2131693961)
  TextView mTvHireData;
  @BindView(2131694032)
  TextView mTvIdentDesc;
  @BindView(2131693962)
  TextView mTvNativePlace;
  @BindView(2131690003)
  TextView mTvNum;
  @BindView(2131693960)
  TextView mTvServicePlace;
  
  private void c()
  {
    this.b = getArguments().getString("cleanerId");
    this.d = new com.ziroom.ziroomcustomer.newclean.b.c(getActivity(), this.c);
    this.mGvIdent.setAdapter(this.d);
    d();
    e();
  }
  
  private void d()
  {
    n.getBiweeklyCleanerInfo(this.a, this.b, new ForCleaningCleanerFragment.1(this, new m(com.ziroom.ziroomcustomer.newclean.d.j.class, new a())));
  }
  
  private void e()
  {
    n.getBiweeklyCleanerIdent(getActivity(), this.b, new ForCleaningCleanerFragment.2(this, new l(i.class, new a())));
  }
  
  public static ForCleaningCleanerFragment getInstance(String paramString)
  {
    ForCleaningCleanerFragment localForCleaningCleanerFragment = new ForCleaningCleanerFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("cleanerId", paramString);
    localForCleaningCleanerFragment.setArguments(localBundle);
    return localForCleaningCleanerFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903907, paramViewGroup, false);
    this.a = getActivity();
    ButterKnife.bind(this, paramLayoutInflater);
    org.greenrobot.eventbus.c.getDefault().register(this);
    c();
    com.ziroom.ziroomcustomer.newServiceList.utils.j.requestFocus(paramLayoutInflater.findViewById(2131692733));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    org.greenrobot.eventbus.c.getDefault().unregister(this);
  }
  
  @org.greenrobot.eventbus.j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if (e.a.equals(paramc.getType()))
    {
      paramc = (ao)paramc.getData();
      if (paramc != null)
      {
        this.b = paramc.getCleanerId();
        d();
        e();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/ForCleaningCleanerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */