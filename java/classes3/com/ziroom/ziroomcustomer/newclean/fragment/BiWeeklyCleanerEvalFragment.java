package com.ziroom.ziroomcustomer.newclean.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.activity.BiweeklyCleanAllEvalListActivity;
import com.ziroom.ziroomcustomer.newclean.b.f;
import com.ziroom.ziroomcustomer.newclean.d.k;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.List;

public class BiWeeklyCleanerEvalFragment
  extends BaseFragment
{
  private f a;
  private List<k> b = new ArrayList();
  private String c;
  @BindView(2131693955)
  ListViewForScrollView lv_eval;
  @BindView(2131690175)
  TextView tv_no_data;
  @BindView(2131693956)
  TextView tv_to_all_list;
  
  private void c()
  {
    w.onEventToZiroomAndUmeng("biweeklyclean_cleanner_info_evaluate_uv");
    this.c = getArguments().getString("cleanerId");
    n.getBiweeklyCleanerBestEvalList(getActivity(), this.c, new com.freelxl.baselibrary.d.c.a(new l(k.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<k> paramAnonymousList)
      {
        BiWeeklyCleanerEvalFragment.a(BiWeeklyCleanerEvalFragment.this).clear();
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          BiWeeklyCleanerEvalFragment.a(BiWeeklyCleanerEvalFragment.this, paramAnonymousList);
          BiWeeklyCleanerEvalFragment.this.tv_to_all_list.setVisibility(0);
          BiWeeklyCleanerEvalFragment.this.tv_no_data.setVisibility(8);
        }
        for (;;)
        {
          BiWeeklyCleanerEvalFragment.a(BiWeeklyCleanerEvalFragment.this, new f(BiWeeklyCleanerEvalFragment.this.getActivity(), BiWeeklyCleanerEvalFragment.a(BiWeeklyCleanerEvalFragment.this)));
          BiWeeklyCleanerEvalFragment.this.lv_eval.setAdapter(BiWeeklyCleanerEvalFragment.b(BiWeeklyCleanerEvalFragment.this));
          return;
          BiWeeklyCleanerEvalFragment.this.tv_to_all_list.setVisibility(8);
          BiWeeklyCleanerEvalFragment.this.tv_no_data.setVisibility(0);
        }
      }
    });
  }
  
  public static BiWeeklyCleanerEvalFragment getInstance(String paramString)
  {
    BiWeeklyCleanerEvalFragment localBiWeeklyCleanerEvalFragment = new BiWeeklyCleanerEvalFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("cleanerId", paramString);
    localBiWeeklyCleanerEvalFragment.setArguments(localBundle);
    return localBiWeeklyCleanerEvalFragment;
  }
  
  @OnClick({2131693956})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(getActivity(), BiweeklyCleanAllEvalListActivity.class);
    paramView.putExtra("cleanerId", this.c);
    startActivity(paramView);
    w.onEventToZiroomAndUmeng("biweeklyclean_cleanner_info_evaluate_all");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    d.d("BiWeeklyCleanerEvalFragment", "onCreateView");
    paramLayoutInflater = paramLayoutInflater.inflate(2130903895, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiWeeklyCleanerEvalFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */